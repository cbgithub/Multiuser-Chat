import java.net.*;
import java.io.*;
public class MulticastSend implements Runnable {
   private MulticastSocket socket;
   private InetAddress mAddr;
   
   public MulticastSend(String mAddr){
       try{
        this.mAddr = InetAddress.getByName(mAddr);
        socket = new MulticastSocket( );
       }
       catch (Exception e){
         System.out.println(e);
       }
   }
   
   public void run() {
     try {
       MulticastSocket mSocket = new MulticastSocket( );
       InetAddress mAddr = InetAddress.getByName("224.0.0.1");
       String hostname = InetAddress.getLocalHost().getHostName();
       String sendString = "Hello from " + hostname;
       byte [] buffer = sendString.getBytes();
       DatagramPacket dp = new DatagramPacket(buffer, buffer.length, mAddr, 4001);
       mSocket.send(dp);
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
