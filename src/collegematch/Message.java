package collegematch;

public class Message {
	
	private String messageTitle;
	private String messageDescription;

	public Message(String messageTitle, String messageDescription) {
		this.messageTitle = messageTitle;
		this.messageDescription = messageDescription;
	}
	
	public void displayMessage() {
		System.out.println("");
		System.out.println("Name: " + messageTitle);
		System.out.println("Description: " + messageDescription);
		System.out.println("");
	}
	
	public String getMessageTitle() {
		return messageTitle;
	}

	public String getMessageDescription() {
		return messageDescription;
	}


	
}
