package org.usfirst.frc.team548.robot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static Server instance;
	public static Server getInstance(){
		if(instance == null)
			instance = new Server();
		return instance;
	}
	private Server(){
		
	}
	public static void run(){
		try {
	         ServerSocket srvr = new ServerSocket(5801);
	         Socket skt = srvr.accept();
	         System.out.print("Server has connected!\n");
	         Thread.sleep(100);
	         BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
	         System.out.print("Received string: '");
	    
	          System.out.println(in.readLine()); // Read one line and output it

	          System.out.print("'\n");
	          in.close();
	         skt.close();
	         srvr.close();
	      }
	      catch(Exception e) {
	         e.printStackTrace();
	      }
	}

}
