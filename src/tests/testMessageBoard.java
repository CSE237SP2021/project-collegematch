package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import collegematch.MessageBoard;
import collegematch.Message;

import org.junit.jupiter.api.Test;

class testMessageBoard {

	@Test
	void testAddToMessageBoard() throws IOException {
		MessageBoard messageBoard = new MessageBoard();
		int originalSize = messageBoard.getMessageBoardSize();
		Message message = new Message("Hello world", "How are you?");
		messageBoard.addToMessageBoard(message);
		int newSize = messageBoard.getMessageBoardSize();
		assertEquals(newSize, originalSize + 1);
	}

}
