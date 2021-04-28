package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import collegematch.User;
import collegematch.UserManager;


class testLogin {

	@Test
	void testStudentLoginSuccessful() {
		UserManager UserManager = new UserManager();
		User outputUserObject = UserManager.logIn("a", "b");
		assertTrue(outputUserObject != null);
	}
	
	@Test
	void testAdmissionOfficerLoginSuccessful() {
		UserManager UserManager = new UserManager();
		User outputUserObject = UserManager.logIn("harvard_rep", "h");
		assertTrue(outputUserObject != null);
	}
	
	@Test
	void testStudentLoginUnSuccessful() {
		UserManager UserManager = new UserManager();
		User outputUserObject = UserManager.logIn("a", "c");
		assertTrue(outputUserObject == null);
	}
	
	@Test
	void testAdmissionOfficerLoginUnSuccessful() {
		UserManager UserManager = new UserManager();
		User outputUserObject = UserManager.logIn("lol", "c");
		assertTrue(outputUserObject == null);
	}

	
}
