import java.net.*;
import java.io.*;
public class MulticastListener implements Runnable {
  private InetAddress mAddr;
  private MulticastSocket mSocket;
  private String username;
  
  public MulticastListener(int port,
                           String mAddr,
                           String username){
    try{
        this.mAddr = InetAddress.getByName(mAddr);
        mSocket = new MulticastSocket(port);
        this.username = username;
    }
    catch (Exception e){
        System.out.println(e);
    }
  }
  
  public void run() {
    try {
      byte [] buffer = new byte[8192];
      mSocket.joinGroup(mAddr);
      System.out.println("Listening from " + username + " at " +
      mAddr.getHostName());
      while (true){
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        mSocket.receive(dp);
        String str = new String(dp.getData(), "8859_1");
        System.out.println(str);
      }//end of while
    }
    catch (SocketException se) {
      System.out.println("Socket Exception : " + se);
    }
    catch (IOException e) {
      System.out.println("Exception : " + e);
    }
    finally {
      if (mSocket != null){
        try {
          mSocket.leaveGroup(mAddr);
          mSocket.close();
        }
        catch (IOException e){
          System.out.println("Exception: " + e);
        }
      }//end of if
    }//end of finally
  }//end of main
}
