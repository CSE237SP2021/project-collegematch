package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import collegematch.CollegeManager;
import collegematch.User;
import collegematch.UserManager;


class testAdmissionsOfficerRegister {

	
	@Test
	void testRegister() throws IOException {
		UserManager userManager = new UserManager();
		userManager.registerAdmissionsOfficer("testAdmissionsRep", "password", 2, 16);
		ArrayList<User> allUsers = userManager.readUsers();
		boolean match = false;
		for(User user : allUsers) {
			if(user.getUsername().equals("testAdmissionsRep")) {
				match = true;
			}
		}
		assertEquals(true, match);
	}
	
	@Test
	void testAddCollege() throws IOException {
		CollegeManager collegeManager = new CollegeManager();
		int collegeID = collegeManager.addCollege("Test University", 3000, "NA", 1400, 1.0, "Test", 100, 0);
		assertEquals(collegeManager.getCollegesLength(), collegeID);
	}
	
	@Test
	void testDuplicateCollegeName() {
		CollegeManager collegeManager = new CollegeManager();
		boolean duplicate = collegeManager.checkForDuplicateCollegename("Arizona State University");
		assertEquals(true, duplicate);
	}
	
	@Test
	void testNotADuplicateCollegeName() {
		CollegeManager collegeManager = new CollegeManager();
		boolean notADuplicate = collegeManager.checkForDuplicateCollegename("Moscow University");
		assertEquals(false, notADuplicate);
	}
	
	@Test
	void testDuplicateCollegeNickName() {
		CollegeManager collegeManager = new CollegeManager();
		boolean duplicate = collegeManager.checkForDuplicateCollegename2("ASU");
		assertEquals(true, duplicate);
	}
	
	@Test
	void testNotADuplicateCollegeNickName() {
		CollegeManager collegeManager = new CollegeManager();
		boolean notADuplicate = collegeManager.checkForDuplicateCollegename2("MU");
		assertEquals(false, notADuplicate);
	}
	
	@Test 
	void testCorrectLocation() {
		CollegeManager collegeManager = new CollegeManager();
		boolean campusLocation = collegeManager.validateLocation("AZ");
		assertTrue(campusLocation);
	}
	
	@Test 
	void testIncorrectLocation() {
		CollegeManager collegeManager = new CollegeManager();
		boolean campusLocation = collegeManager.validateLocation("Arizona");
		assertFalse(campusLocation);
	}
	
	@Test 
	void testCorrectSATScore() {
		CollegeManager collegeManager = new CollegeManager();
		boolean satScoreFormatted = collegeManager.validateSATScore(1200);
		assertTrue(satScoreFormatted);
	}
	
	@Test 
	void testIncorrectSATScore() {
		CollegeManager collegeManager = new CollegeManager();
		boolean satScoreFormatted = collegeManager.validateSATScore(1700);
		assertFalse(satScoreFormatted);
	}
	
	@Test 
	void testCorrectGPA() {
		CollegeManager collegeManager = new CollegeManager();
		boolean gpaFormatted = collegeManager.validateGPA(3.0);
		assertTrue(gpaFormatted);
	}
	
	@Test 
	void testIncorrectGPA() {
		CollegeManager collegeManager = new CollegeManager();
		boolean gpaFormatted = collegeManager.validateGPA(5.09);
		assertFalse(gpaFormatted);
	}
	
	@Test 
	void testCorrectTuitionPreference() {
		CollegeManager collegeManager = new CollegeManager();
		boolean tuitionFormatted = collegeManager.validateTuition(10000);
		assertTrue(tuitionFormatted);
	}
	
	@Test 
	void testIncorrectTuitionPreference() {
		CollegeManager collegeManager = new CollegeManager();
		boolean tuitionFormatted = collegeManager.validateTuition(200000);
		assertFalse(tuitionFormatted);
	}
	
	@Test 
	void testCorrectSizePreference() {
		CollegeManager collegeManager = new CollegeManager();
		boolean sizeFormatted = collegeManager.validateSize(20);
		assertTrue(sizeFormatted);
	}
	
	@Test 
	void testIncorrectSizePreference() {
		CollegeManager collegeManager = new CollegeManager();
		boolean sizeFormatted = collegeManager.validateSize(70000);
		assertFalse(sizeFormatted);
	}

}
