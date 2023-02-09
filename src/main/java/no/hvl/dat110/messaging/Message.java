package no.hvl.dat110.messaging;

public class Message {

	// the up to 127 bytes of data (payload) that a message can hold
	private byte[] data;

	// construction a Message with the data provided
	public Message(byte[] data) {
		if(data.length < 127 && data != null)
			this.data = data;
		// If our message is bigger then 128 bytes cut off the rest
		else if (data.length >= 127 && data != null){
			this.data = new byte[127];
			for (byte i = 0; i < 127; i++){
				this.data[i] = data[i];
			}
		}
	}

	public byte[] getData() {
		return this.data; 
	}

}
