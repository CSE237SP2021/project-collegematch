package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import collegematch.College;
import collegematch.CollegeManager;


class testAdmissionsOfficerRegister {

	@Test
	void test() throws IOException {
		CollegeManager collegeManager = new CollegeManager();
		collegeManager.register("Arizona State University", 7100, "AZ", 1200, 3.0, "ASU", 20000);
		ArrayList<College> allColleges = collegeManager.readColleges();
		boolean match = false;
		for(College college : allColleges) {
			if(college.getCollegeName().equals("Arizona State University") 
					&&(college.getGpa()==3.0) &&college.getLocation().equals("AZ")) {
				match = true;
			}
		}
		assertEquals(true, match);
	}
	
	@Test 
	void testCorrectLocation() {
		CollegeManager collegeManager = new CollegeManager();
		boolean campusLocation = collegeManager.validateLocation("AZ");
		assertTrue(campusLocation);
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
		CollegeManager userManager = new CollegeManager();
		boolean gpaFormatted = userManager.validateGPA(5.09);
		assertFalse(gpaFormatted);
	}

}
