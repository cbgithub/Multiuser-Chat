
import java.net.*;
import java.io.*;
public class MulticastSend implements Runnable {
<<<<<<< HEAD
	
	
	String message = "";
	String username = "";
	
    
    public MulticastSend(String message, String username){
    	this.message = message;
    	this.username = username; 
    }
    
    
   public void run() {
     try {
     	
       	MulticastSocket mSocket = new MulticastSocket();
       	
       	InetAddress mAddr = InetAddress.getByName("224.0.0.1");
       	String hostname = InetAddress.getLocalHost().getHostName();
       	String sendString = username + ": " + message;
       	//byte [] buffer = new byte[256];
       	byte [] buffer = new byte [256]; 
       	buffer = sendString.getBytes();
       	DatagramPacket dp = new DatagramPacket(buffer, buffer.length, mAddr, 4001);
        String str = new String(dp.getData());
        //System.out.println(str);
       	mSocket.send(dp);
       
       	/*
       
       	byte[] buf= new byte[256];
        buf=msg.getBytes();
        InetAddress address = InetAddress.getByName("224.0.0.1");
        DatagramPacket PACKET;
        PACKET= new DatagramPacket(buf, buf.length, address, portNum);
        mSocket.send(PACKET);
        */
=======
   private MulticastSocket socket;
   private InetAddress mAddr;
   private String username;
   private String message;
   
   public MulticastSend(String mAddr, String username, String message){
       try{
        this.mAddr = InetAddress.getByName(mAddr);
        socket = new MulticastSocket( );
        this.username = username;
        this.message = message;
       }
       catch (Exception e){
         System.out.println(e);
       }
   }
   
   public void run() {
     try {
       message = username + ">>>" + message;
       byte [] buffer = sendString.getBytes();
       DatagramPacket dp = new DatagramPacket(buffer, buffer.length, mAddr, 4001);
       socket.send(dp);
>>>>>>> d119d87c528ed792573a4d044390d24e725d84b7
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
