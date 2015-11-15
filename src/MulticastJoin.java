import java.net.*;
import java.io.*;
public class MulticastJoin implements Runnable {
  public void run() {
    try {
      MulticastSocket mSocket = new MulticastSocket(4001);
      InetAddress mAddr = InetAddress.getByName("224.0.0.1");
      mSocket.joinGroup(mAddr);
      byte [] buffer = new byte[512];
      while (true) {
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        mSocket.receive(dp);
        String str = new String(dp.getData(), "8859_1");
        System.out.println(str);
      }//end of while
    }//end of try
    catch (SocketException se){
      System.out.println("Socket Exception : " + se);
    }
    catch (IOException e) {
      System.out.println("Exception : " + e);
    }
  }//end of main
}// end of class definition
