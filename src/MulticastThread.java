/**
 * @author Jonathan Hosler
 * @author Kurtis Graben
 * @author Josh Hill
 * @author Christopher Burdette
 */
 
 import java.net.*;
 import java.io.*;
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 import javax.swing.UIManager.*;

public class MulticastThread implements Runnable {
    private JTextArea area = null;
    private InetAddress mAddr;
    private MulticastSocket mSocket;
    private DatagramPacket dp;
    private String username;
    private int port;
    private boolean active;

    public MulticastThread(int port, String mAddr, JTextArea incoming,boolean active){
      try{
          this.mAddr = InetAddress.getByName(mAddr);
          this.port = port;
          mSocket = new MulticastSocket(port);
          area = incoming;
          this.active = active;
      }
      catch (Exception e){
          System.out.println(e);
      }
    }
    public void run() {
        try {
  	        mSocket.joinGroup(mAddr);
            String hostname = InetAddress.getLocalHost().getHostName();
            System.out.println("Listening from " + hostname + " at " + mAddr.getHostName());
            while (active){
       	        byte [] buffer = new byte[8192];
                dp = new DatagramPacket(buffer, buffer.length);
                mSocket.receive(dp);
                String str = new String(dp.getData());
                System.out.println(str);
                area.append(str);
                str = " ";
                area.append("\n");
            }
        }
        catch (Exception e){}
    }

    public void leave(){
        try {
            active = false;
            mSocket.leaveGroup(mAddr);
            mSocket.close();
        } catch(Exception e) {}
    }


    public void send(String usern, String mes){
 	    String username = usern;
   	    String message = mes;
        try {
            message = username + ">>>" + message;
            byte [] buffer = message.getBytes();
            dp = new DatagramPacket(buffer, buffer.length, mAddr, port);
            mSocket.send(dp);
        }
        catch (Exception e){}
    }
}
