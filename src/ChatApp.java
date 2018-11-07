import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ChatApp extends JFrame{

	
	private JTextArea txtArea;
	private JTextField txtField;
	private	JButton send;
	private JButton close;
	private InetAddress destIP;
	private int port;
	private Socket socket;

	
	public ChatApp(Socket connect, String ip, int port){
//		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 800);
		setTitle("IP address: " + ip + " Port: " + port);
		setResizable(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		getContentPane().add(panel);
		
		// setting text area
		txtArea = new JTextArea();
		txtArea.setEditable(false);
		panel.add(txtArea);
		
		//text Field 
		JPanel bottom = new JPanel(new BorderLayout());
		panel.add(bottom, BorderLayout.SOUTH);
		txtField = new JTextField();
		
		
		bottom.add(txtField);
		JPanel button = new JPanel(new BorderLayout());
		bottom.add(button, BorderLayout.EAST);
		//adds Button send
		 send = new JButton("Send");
		 send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(!txtField.getText().isEmpty()) {
					String msg = txtField.getText().toString().trim();
					InetAddress dest = null;
					System.out.print(msg);
					txtArea.append("Stephen: "+ msg + "\n");
				
				
					try {
						dest = InetAddress.getByName(ip);
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					connect.send(msg, dest, port);
				
				}
			}
			 
			 
		 });
		 
		 button.add(send, BorderLayout.WEST);
		 
		 //close button
		 close = new JButton("close");
		 close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				
			}
			 
		 });
		
		 button.add(close);
		setVisible(true);
	}
	
	public JTextArea getText() {
		return this.txtArea;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
