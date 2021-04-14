package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import collegematch.User;
import collegematch.UserManager;


class testLogin {

	@Test
	void testStudentLoginSuccessful() {
		UserManager UserManager = new UserManager();
		User outputUserObject = UserManager.logIn("batman");
		assertTrue(outputUserObject != null);
	}
	
	@Test
	void testAdmissionOfficerLoginSuccessful() {
		UserManager UserManager = new UserManager();
		User outputUserObject = UserManager.logIn("harvard_rep");
		assertTrue(outputUserObject != null);
	}

	
}
