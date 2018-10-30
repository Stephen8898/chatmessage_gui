import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class Driver {

	public static void main(String[] args) {
		Socket socket = new Socket(1337);
		
		InetAddress Address = null;
		try {
			Address = InetAddress.getByName("192.168.1.115");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}

		socket.send("My name is what? \n" + "My name is who? \n" +
				"my name is Slim Shady! \n" + "- Stephen CMP 405"
				, Address, 6400);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		try {
//			myAddress = InetAddress.getLocalHost();
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.exit(-1);
//		}
//		
//		
//		socket.send("My name is what? \n" + "My name is who? \n" +
//				"my name is Slim Shady \n" + "- Stephen CMP 405"
//				, myAddress, 64000);
//		
//		
//		socket.send("How Are You?", myAddress, 64000);
//		socket.send("I am having fun writing code", myAddress, 64000);
//		socket.send("What are you doing?", myAddress, 64000);
//		socket.send("Are you having fun?", myAddress, 64000);
		
//		try {
//			System.out.println("Main is sleeping");
//			TimeUnit.SECONDS.sleep(5);
//			System.out.println("Main woke up");
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.exit(-1);
//		} 
//		
//		DatagramPacket packet;
//		
//		do {
//			packet = socket.receive();
//			if (packet != null) {
//				String message = new String(packet.getData());
//				System.out.println("Message = " + message);
//			}
//		} while(packet != null);
//		
//		System.out.println("That's it folks!");
		
	}

}
