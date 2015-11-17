import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.UIManager.*;

public class MulticastListener implements Runnable {
<<<<<<< HEAD
  JTextArea area = null;

  public MulticastListener(JTextArea incoming){
  	area = incoming;
  }
  
  
=======
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
>>>>>>> d119d87c528ed792573a4d044390d24e725d84b7
  
  public void run() {
    try {
<<<<<<< HEAD
      mAddr = InetAddress.getByName("audionews.mcast.net");
      mSocket = new MulticastSocket(PORT_NUM);
      String hostname = InetAddress.getLocalHost().getHostName();
      
      //mSocket.joinGroup(mAddr);
      System.out.println("Listening from " + hostname + " at " +
=======
      byte [] buffer = new byte[8192];
      mSocket.joinGroup(mAddr);
      System.out.println("Listening from " + username + " at " +
>>>>>>> d119d87c528ed792573a4d044390d24e725d84b7
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