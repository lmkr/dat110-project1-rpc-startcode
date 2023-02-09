package no.hvl.dat110.messaging;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {
		
		byte[] segment = new byte[SEGMENTSIZE];
		byte[] data = message.getData();
		// Calulate lenght of our packet and set the first byte to its length
		byte size = (byte) data.length;
		segment[0] = size;
		// Fill out packet with data
		for (int i=0; i<data.length; i++){
			segment[i+1] = data[i];
		}
		
		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {
		// Get size from first byte
		byte size = segment[0];
		byte[] data = new byte[size];
		// Fill out a byte buffer with our segment size
		for(int i=1; i<=size; i++){
			data[i-1] = segment[i];
		}
		
		return new Message(data);
		
	}
	
}
