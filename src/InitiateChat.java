import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.util.HashMap;
import java.util.Map;

public class InitiateChat extends JFrame {
	
	private static Socket socket = new Socket(1300);
	private int port;
	private JLabel ipLabel, portLabel;
	private JTextField ipTxt, portTxt;
	private JButton connect;
	private static Map<String, ChatApp> newChat = new HashMap<String, ChatApp>();
	
	public InitiateChat() {
//		this.port = port;
//		this.socket = new Socket(this.port);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 500);
		setTitle("Initiate chat");
		setResizable(true);
		setLayout(new GridBagLayout());
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		GridBagConstraints constraints = new GridBagConstraints();
		
		ipLabel = new JLabel("IP Address:");
		constraints.insets = new Insets(0, 20, 0, 0);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 0.5;
		constraints.gridx = 0;
		constraints.gridy = 0;
		add(ipLabel, constraints);
		
		ipTxt = new JTextField();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(0,30,0,20);
		constraints.weightx = 2;
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		add(ipTxt, constraints);
		
		portLabel = new JLabel("Port number:");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(20, 20, 0, 0);
		constraints.weightx = 0.5;
		constraints.gridx = 0;
		constraints.gridy = 1;
		add(portLabel,  constraints);
		
		portTxt = new JTextField();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(20, 0, 0, 20);
		constraints.weightx = 2;
		constraints.gridx = 1;
	    constraints.gridy = 1;
	    constraints.gridwidth = 2;
		add(portTxt, constraints);
	    
		connect = new JButton("Connect");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(20, 40, 0, 80);
		constraints.weightx = .2;
		constraints.gridx = 1;
	    constraints.gridy = 2;
	    constraints.gridwidth = 1;
	    add(connect, constraints);
		connect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!ipTxt.getText().isEmpty() && !portTxt.getText().isEmpty()) {
					int portNum = Integer.parseInt(portTxt.getText());
					ChatApp createChat = new ChatApp(socket, ipTxt.getText(), portNum);
					newChat.put(ipTxt.getText(), createChat);
					
				}
				
			}
			
		});
		//panelS.add(connect);
		
		setVisible(true);
		
	DatagramPacket packet= null;
		
		do {
			packet = socket.receive();
			
			if(packet != null) {
				System.out.println("Receiving packet");
				String ip = packet.getAddress().getHostAddress();
				
				int port = packet.getPort();
						
				String msg = new String(packet.getData());
				
				if(!newChat.containsKey(ip)) {
					System.out.println("here");
					ChatApp newchat = new ChatApp(socket, ip, port);
					newChat.put(ip, newchat);
					newchat.getText().append("Them: " + msg + "\n");
					newchat.setVisible(true);
				} else {
					ChatApp currentChat = newChat.get(ip);
					currentChat.getText().append("Them: " + msg + "\n");
					currentChat.setVisible(true);
					System.out.println(msg);
				}
			}
		} while (true);
		
		
		
	}
	/*
	public static void recieve() {
			DatagramPacket packet= null;
		
		do {
			packet = socket.receive();
			
			if(packet != null) {
				System.out.println("Receiving packet");
				String ip = packet.getAddress().getHostAddress();
				
				int port = packet.getPort();
						
				String msg = new String(packet.getData());
				
				if(!newChat.containsKey(ip)) {
					System.out.println("here");
					ChatApp newchat = new ChatApp(socket, ip, port);
					newChat.put(ip, newchat);
					newchat.getText().append("Them: " + msg + "\n");
					newchat.setVisible(true);
				} else {
					ChatApp currentChat = newChat.get(ip);
					currentChat.getText().append("Them: " + msg + "\n");
					currentChat.setVisible(true);
					System.out.println(msg);
				}
			}
		} while (true);
		
	}
	
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InitiateChat ichat = new InitiateChat();
//		recieve();
	}
	
	
	//// receivemethod


	
	
	
	
	
	
}
