package main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) {
		
		try {
			
			ServerSocket ss = new ServerSocket(1223);
			Socket s = ss.accept();
			
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
			
			String msgIn = "", msgOutput = "" ;
			
			while(!msgIn.equals("end")) {
				msgIn = in.readUTF();
				System.out.println(msgIn);
				
				msgOutput = rd.readLine();
				out.writeUTF(msgOutput);
				
				out.flush();
			}
			
			s.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
