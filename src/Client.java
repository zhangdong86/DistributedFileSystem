import java.net.*;
import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Client {
	//request to the name nodes
	private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    
	public static void main(String[] args) {
		//Read a user string
		//Check that string
		//Send that string to the NameNode
		String input = new String();
		String filename = new String(); 
		String appendContents = new String();
		System.out.print("::");
		Scanner sc = new Scanner(System.in);
		while((input = sc.nextLine()) != null) {
			
			String[] tokens = input.split(" ");
			if(tokens[0].toLowerCase().equals("read")) {
				System.out.println("Got 'read' and the file name:" + tokens[1]);
//				Client c = new Client();
//				c.startConnection("127.0.0.1", 5558);
//				String ret = c.sendMessage(tokens[0] + " " + tokens[1]);	//send the read command assembly the file name.
//				String terminate = c.sendMessage("."); 						
//				c.stopConnection();//close the connection
			}
			
			else if(tokens[0].toLowerCase().equals("append") && tokens[1]!=null && tokens[2]!=null) {
				String[] contents = input.split(" ", 3);
				//System.out.println("Appended to the file name: " + tokens[1] + "the contents: " + contents[2]);
//				Client c = new Client();
//				c.startConnection("127.0.0.1", 5558);
//				String ret = c.sendMessage(tokens[0] + " " + tokens[1] + " " + tokens[1]);	//send the read command assembly the file name.
//				String terminate = c.sendMessage("."); 	
			  //c.stopConnection     //close the connection
			}
			
			else {
				System.out.println("Invalid Input");
			}
			
			System.out.print("::");
		
		}
	}
	
	public void startConnection(String ip, int port) {
	       try {
	    	clientSocket = new Socket(ip, port);
	        out = new PrintWriter(clientSocket.getOutputStream(), true);
	        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	       }catch(Exception e) {
	    	   System.out.println("Error Starting Connection");
	    	   e.printStackTrace();
	       }
	    }

	    public String sendMessage(String msg) {
	        try {
				out.println(msg);
				String resp = in.readLine();
				return resp;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return "ERROR";
	    }
	 
	    public void stopConnection() {
	        try {
				in.close();
				out.close();
		        clientSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

}
