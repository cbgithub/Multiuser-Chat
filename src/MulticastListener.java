import java.net.*;
import java.io.*;
public class MulticastListener implements Runnable {
  public void run() {
    InetAddress mAddr=null;
    MulticastSocket mSocket=null;
    final int PORT_NUM=4001;
    try {
      mAddr = InetAddress.getByName("audionews.mcast.net");
      mSocket = new MulticastSocket(PORT_NUM);
      String hostname = InetAddress.getLocalHost().getHostName();
      byte [] buffer = new byte[8192];
      mSocket.joinGroup(mAddr);
      System.out.println("Listening from " + hostname + " at " +
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
