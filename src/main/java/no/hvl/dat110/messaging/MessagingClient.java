package no.hvl.dat110.messaging;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class MessagingClient {

	// name/IP address of the messaging server
	private String server;

	// server port on which the messaging server is listening
	private int port;
	
	public MessagingClient(String server, int port) {
		this.server = server;
		this.port = port;
	}
	
	// setup of a messaging connection to a messaging server
	public MessageConnection connect () {

		// client-side socket for underlying TCP connection to messaging server
		Socket clientSocket = new Socket();
		SocketAddress addr = new InetSocketAddress(server, port);
		try {
			clientSocket.connect(addr);
		} catch (IOException e) {
			e.printStackTrace();
		}

		MessageConnection connection = new MessageConnection(clientSocket);
		
		return connection;
	}
}
