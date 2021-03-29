package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import collegematch.User;
import collegematch.UserManager;


class testLogin {

	@Test
	void testLoginSuccessful() {
		UserManager UserManager = new UserManager();
		User outputUserObject = UserManager.logIn("batman");
		assertTrue(outputUserObject != null);
	}

}
