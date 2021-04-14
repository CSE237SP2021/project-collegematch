package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import collegematch.User;
import collegematch.UserManager;

class testStudentRegister {

	
	@Test
	void testRegister() throws IOException {
		UserManager userManager = new UserManager();
		userManager.registerStudent("testUser", 1, 1100, 3.0, 10000,1000);
		ArrayList<User> allUsers = userManager.readUsers();
		boolean match = false;
		for(User user : allUsers) {
			if(user.getUsername().equals("testUser")) {
				match = true;
			}
		}
		assertEquals(true, match);
	}
	
	@Test
	void testDuplicateUsername() {
		UserManager userManager = new UserManager();
		boolean duplicate = userManager.checkForDuplicateUsername("batman");
		assertEquals(true, duplicate);
	}
	
	@Test
	void testNotADuplicateUsername() {
		UserManager userManager = new UserManager();
		boolean notADuplicate = userManager.checkForDuplicateUsername("charles");
		assertEquals(false, notADuplicate);
	}
	
	@Test 
	void testCorrectSATScore() {
		UserManager userManager = new UserManager();
		boolean satScoreFormatted = userManager.validateSATScore(1400);
		assertTrue(satScoreFormatted);
	}
	
	@Test 
	void testIncorrectSATScore() {
		UserManager userManager = new UserManager();
		boolean satScoreFormatted = userManager.validateSATScore(1700);
		assertFalse(satScoreFormatted);
	}
	
	@Test 
	void testCorrectGPA() {
		UserManager userManager = new UserManager();
		boolean gpaFormatted = userManager.validateGPA(3.88);
		assertTrue(gpaFormatted);
	}
	
	@Test 
	void testIncorrectGPA() {
		UserManager userManager = new UserManager();
		boolean gpaFormatted = userManager.validateGPA(5.09);
		assertFalse(gpaFormatted);
	}
	
	@Test 
	void testCorrectTuitionPreference() {
		UserManager userManager = new UserManager();
		boolean tuitionFormatted = userManager.validateTuitionPreference(10000);
		assertTrue(tuitionFormatted);
	}
	
	@Test 
	void testIncorrectTuitionPreference() {
		UserManager userManager = new UserManager();
		boolean tuitionFormatted = userManager.validateTuitionPreference(200000);
		assertFalse(tuitionFormatted);
	}
	
	@Test 
	void testCorrectSizePreference() {
		UserManager userManager = new UserManager();
		boolean sizeFormatted = userManager.validateSizePreference(20);
		assertTrue(sizeFormatted);
	}
	
	@Test 
	void testIncorrectSizePreference() {
		UserManager userManager = new UserManager();
		boolean sizeFormatted = userManager.validateSizePreference(70000);
		assertFalse(sizeFormatted);
	}

}
