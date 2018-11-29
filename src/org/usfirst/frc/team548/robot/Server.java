package org.usfirst.frc.team548.robot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
	          Socket skt = new Socket("206.57.198.201", 5801);
	          BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
	          System.out.print("Received string: '");

	          while (!in.ready()) {}
	          System.out.println(in.readLine()); // Read one line and output it

	          System.out.print("'\n");
	          in.close();
	       }
	       catch(Exception e) {
	          e.printStackTrace();
	       }
	}

}
