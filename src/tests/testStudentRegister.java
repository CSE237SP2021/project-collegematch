package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import collegematch.User;
import collegematch.UserManager;

class testStudentRegister {

	@Test
	void test() throws IOException {
		UserManager userManager = new UserManager();
		userManager.register("dan", 1100, 3.0, "rural");
		ArrayList<User> allUsers = userManager.readUsers();
		boolean match = false;
		for(User user : allUsers) {
			if(user.getUsername().equals("dan") 
					&&(user.getGpa()==3.0) &&user.getCampusPreference().equals("rural")) {
				match = true;
			}
		}
		assertEquals(true, match);
	}
	
	@Test 
	void testCorrectCampusPreference() {
		UserManager userManager = new UserManager();
		boolean campusPreferenceFormatted = userManager.validateCampusPreference("rural");
		assertTrue(campusPreferenceFormatted);
	}
	
	@Test 
	void testIncorrectCampusPreference() {
		UserManager userManager = new UserManager();
		boolean campusPreferenceFormatted = userManager.validateCampusPreference("suburban");
		assertFalse(campusPreferenceFormatted);
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

}
