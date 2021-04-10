package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import collegematch.College;
import collegematch.CollegeManager;
import collegematch.User;
import collegematch.UserManager;

class testAdmissionOfficerLogin {

	@Test
	void test() {
		CollegeManager CollegeManager = new CollegeManager();
		College outputCollegeObject = CollegeManager.logIn("Harvard University");
		assertTrue(outputCollegeObject != null);
	}

}
