import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager.*;

public class MulticastListener implements Runnable {
  private JTextArea area = null;
  private InetAddress mAddr;
  private MulticastSocket mSocket;
  private String username;
  private int port;
  
  public MulticastListener(int port, String mAddr, JTextArea incoming){
    try{
        this.mAddr = InetAddress.getByName(mAddr);
        this.port = port;
        mSocket = new MulticastSocket(port);
        area = incoming;
    }
    catch (Exception e){
        System.out.println(e);
    }
  }
  public void run() {
    try {
      String hostname = InetAddress.getLocalHost().getHostName();
      System.out.println("Listening from " + hostname + " at " + mAddr.getHostName());
      while (true){
        byte [] buffer = new byte[8192];
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        mSocket.receive(dp);
        String str = new String(dp.getData());
        System.out.println(str);
        area.append(str);
        str = " ";
        area.append("\n");
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