import java.io.IOException;
import java.lang.reflect.Array;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Server1 {

	
	private static DatagramSocket datasocket;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		datasocket = new DatagramSocket(1337);
		
		byte[] b1 = new byte [1024];
		DatagramPacket datapacket = new DatagramPacket(b1,  b1.length);
		datasocket.receive(datapacket);
		String str = new String(datapacket.getData());
		String reverse = "";
		for(int i = str.length() -1; 0 <= i; i--) {
			reverse =  reverse + str.charAt(i);
			
		}
		//for (int i =str.length(); )
//		int num = Integer.parseInt(str);
//		int result = num*num;
		
		//Once data is gotten we will want to send it back to client
		
		byte[] b2  = (reverse + "").getBytes();
		InetAddress ia = InetAddress.getLocalHost(); 
		DatagramPacket datapacket1 = new DatagramPacket(b2, b2.length,ia, datapacket.getPort());
		datasocket.send(datapacket1);
	}

}
