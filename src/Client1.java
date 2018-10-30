import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Client1 {

	private static Scanner input;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// UDP needs a special socket called datagram socket to specify 
		//where the packet is being sent to
			DatagramSocket datasocket = new DatagramSocket();
			
			input = new Scanner(System.in);
			System.out.print("Type message here: ");
			String i = input.nextLine();
			
			InetAddress ia = InetAddress.getLocalHost();
			// to send a data to a server you use a datagram packet
			//To use a datagram packet it takes 4 parameters data sent, data length, IP address, port number
			byte[] b = (i+"").getBytes();
			DatagramPacket datapacket = new DatagramPacket(b,b.length, ia, 1337);
			datasocket.send(datapacket);
			
			byte[] b1 = new byte[1024];
			//to accept the data you need a new datagram packet 
			//to receive the data you don't need the port 
			DatagramPacket datapacket1 = new DatagramPacket(b1, b1.length);
			
			//to receive the datagram packet
			datasocket.receive(datapacket1);
			String str = new String(datapacket1.getData());
			System.out.print("result: " + str);
	}

}
