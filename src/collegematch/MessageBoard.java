package collegematch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MessageBoard {
	
	private ArrayList<Message> messages;
	private String filePath = "./src/collegematch/messageBoard.txt";
	
	public MessageBoard() {
		try {
			this.messages = this.readMessages();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Message> readMessages() throws FileNotFoundException {
		ArrayList<Message> allMessages = new ArrayList<Message>();
		Scanner keyboardIn = new Scanner(new File(filePath));
		keyboardIn.useDelimiter("/n");
		while (keyboardIn.hasNextLine()) {
			String[] messageDataInArray = keyboardIn.nextLine().split("\t");
			String messageName = messageDataInArray[0];
			String messageDescription = messageDataInArray[1];
			Message message = new Message(messageName,messageDescription);
			allMessages.add(message);		
		}
		keyboardIn.close();		
		return allMessages;
	}
		
	public void displayMessageBoard() {
		System.out.println("");
		System.out.println("********************* Messages *********************");
		for (Message message : messages) {
			message.displayMessage();
		}
		System.out.println("********************* Messages *********************");
		System.out.println("");
	}
	
	public void addToMessageBoard(Message message) throws IOException {
		messages.add(message);
		FileWriter writer = new FileWriter(filePath, true);
		writer.append("\n");
		writer.append(message.getMessageTitle());
		writer.append("\t");
		writer.append(message.getMessageDescription());
		writer.close();	
	}


}
