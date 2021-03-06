package client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args) {
			
		try {
			
			Socket s = new Socket("127.0.0.1", 1223);
			
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
			
			String msgIn = "", msgOutput = "" ;
			
			while(!msgIn.equals("end")) {
				
				msgOutput = rd.readLine();
				out.writeUTF(msgOutput);
				
				msgIn = in.readUTF();
				System.out.println(msgIn);
								
				out.flush();
			}
			
			s.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
