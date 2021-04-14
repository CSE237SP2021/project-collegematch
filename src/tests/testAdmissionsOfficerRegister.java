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
		userManager.registerAdmissionsOfficer("testAdmissionsRep", 2, 16);
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
		int collegeID = collegeManager.addCollege("Test University", 3000, "NA", 1400, 1.0, "Test", 100);
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

}
