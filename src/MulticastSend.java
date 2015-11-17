
import java.net.*;
import java.io.*;
public class MulticastSend implements Runnable {
   private MulticastSocket socket;
   private InetAddress mAddr;
   private String username;
   private String message;
   private int port;
   
   public MulticastSend(String mAddr, int port, String username, String message){
       try{
        this.mAddr = InetAddress.getByName(mAddr);
        socket = new MulticastSocket();
        this.username = username;
        this.message = message;
        this.port = port;
       }
       catch (Exception e){
         System.out.println(e);
       }
   }
   
   public void run() {
     try {
       message = username + ">>>" + message;
       byte [] buffer = message.getBytes();
       DatagramPacket dp = new DatagramPacket(buffer, buffer.length, mAddr, port);
       socket.send(dp);
     }
     catch (SocketException se) {
       System.out.println("Socket Exception : " + se);
     }
     catch (IOException e) {
       System.out.println("Exception : " + e);
     }
   }//end of main
 }
 // end of class definition
