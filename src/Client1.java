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
	private InetAddress ia;
	private DatagramSocket socket = null;
	private static Scanner input;
	ConcurrentLinkedQueue<DatagramPacket> message = new ConcurrentLinkedQueue<DatagramPacket>();
	
	
	public Client1(int port) throws SocketException, UnknownHostException {
		this.port = port;
		
		InetAddress ip = ia.getLocalHost();
//		
		this.socket = new DatagramSocket(port, ip);
		
		Thread rThread = new Thread(
				new Runnable () {
				public void run(){
					recieve();
			}
		});
		rThread.setName("Receive Thread For Port = "+ this.port);
		rThread.start();
	}
	
	
	public String input () {
		input = new Scanner(System.in);
		String i = input.nextLine();
		return i;
	}
	
	public void recieve() {
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
			
			
			String str = new String(datapacket1.getData());
			System.out.print("result: " + str);
		}
		while(true);
	}
	
	public void send(String str1, InetAddress destIP, int port ) {
		byte[] b;
		
		try {
			b = (str1 +"").getBytes();
			DatagramPacket datapacket2 = new DatagramPacket(b,b.length, destIP, port);
			socket.send(datapacket2);
			
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
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
			
			byte[] b1 = new byte[1024];
			//to accept the data you need a new datagram packet 
			//to receive the data you don't need the port 
			DatagramPacket datapacket1 = new DatagramPacket(b1, b1.length);
			
			//to receive the datagram packet
//			datasocket.receive(datapacket1);
//			String str = new String(datapacket1.getData());
//			System.out.print("result: " + str);
	}

}
