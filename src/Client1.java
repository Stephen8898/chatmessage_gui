import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Client1 {


	private int port;
	private static InetAddress ia;
	private DatagramSocket socket = null;
	public static Scanner input = new Scanner(System.in);;
	ConcurrentLinkedQueue<DatagramPacket> message = new ConcurrentLinkedQueue<DatagramPacket>();
	
	
	
	// UDP needs a special socket called datagram socket to specify 
	//where the packet is being sent to
	public Client1() throws SocketException, UnknownHostException {
//		this.port = port;
		
		InetAddress ip = ia.getLocalHost();
//		
		this.socket = new DatagramSocket();
		
		Thread rThread = new Thread(
				new Runnable () {
				public void run(){
					recieveT();
			}
		});
		rThread.setName("Receive Thread For Port = "+ this.port);
		rThread.start();
	}
	
	
	
	public static int portNum() {
		System.out.print("Enter port number: ");
		input = new Scanner(System.in);
		int port = input.nextInt();
		return port;
	}
	
	public String input () {
		System.out.print("Enter message: ");
		String i = input.nextLine();
		return i;
	}
	
	//to accept the data you need a new datagram packet 
   //to receive the data you don't need the port 
	public void recieveT() {
		do {
			byte[] b1 = new byte[1024];
			for ( int i = 0 ; i < b1.length ; i++ ) {
				b1[i] = ' ';
			}
			DatagramPacket datapacket1 = new DatagramPacket(b1, b1.length);
			
			try {
				socket.receive(datapacket1);
			} catch(Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
			
			//to receive the datagram packet
			String str = new String(datapacket1.getData());
			message.add(datapacket1);
			System.out.print("result: " + str);
		}
		while(true);
	}
	
	
	public DatagramPacket receive() {
		return message.poll();
	}
	
	// to send a data to a server you use a datagram packet
	//To use a datagram packet it takes 4 parameters data sent, data length, IP address, port number
	public void send(String str1, InetAddress destIP, int port ) {
		byte[] b;
		
		try {
			b = (str1 +"").getBytes();
			DatagramPacket datapacket2 = new DatagramPacket(b,b.length, destIP, port);
			datapacket2.setAddress(destIP);
			datapacket2.setPort(port);
			socket.send(datapacket2);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		InetAddress ip = ia.getLocalHost();
		Client1 client = new Client1();
		client.send(client.input(),ip ,1337);
		
		
		
		
		
		
		// UDP needs a special socket called datagram socket to specify 
		//where the packet is being sent to
//			DatagramSocket datasocket = new DatagramSocket();
//			
//			input = new Scanner(System.in);
//			System.out.print("Type message here: ");
//			String i = input.nextLine();
			
//			InetAddress ia = InetAddress.getByName("192.168.1.101");
			// to send a data to a server you use a datagram packet
			//To use a datagram packet it takes 4 parameters data sent, data length, IP address, port number
//			byte[] b = (i+"").getBytes();
//			DatagramPacket datapacket = new DatagramPacket(b,b.length, ia, 64000);
//			datasocket.send(datapacket);
			
//			byte[] b1 = new byte[1024];
//			//to accept the data you need a new datagram packet 
//			//to receive the data you don't need the port 
//			DatagramPacket datapacket1 = new DatagramPacket(b1, b1.length);
			
			//to receive the datagram packet
//			datasocket.receive(datapacket1);
//			String str = new String(datapacket1.getData());
//			System.out.print("result: " + str);
	}

}
