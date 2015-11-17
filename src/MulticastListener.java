import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager.*;

public class MulticastListener implements Runnable {
  JTextArea area = null;

  public MulticastListener(JTextArea incoming){
  	area = incoming;
  }
  
  
  
  public void run() {
    InetAddress mAddr=null;
    MulticastSocket mSocket=null;
    final int PORT_NUM=4001;
    try {
      mAddr = InetAddress.getByName("audionews.mcast.net");
      mSocket = new MulticastSocket(PORT_NUM);
      String hostname = InetAddress.getLocalHost().getHostName();
      
      //mSocket.joinGroup(mAddr);
      System.out.println("Listening from " + hostname + " at " +
      mAddr.getHostName());
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