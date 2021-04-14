package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


import org.junit.jupiter.api.Test;

import collegematch.College;
import collegematch.CollegeManager;
import collegematch.UserManager;
import collegematch.Student;

class testCollegeMatches {

	@Test
	void testMatches() {
		CollegeManager collegeManager = new CollegeManager();
		UserManager userManager = new UserManager();
		ArrayList<College> colleges = collegeManager.getColleges();
		Student student = new Student("bob", 1, 1250, 3.5, 20000, 20000);
		ArrayList<College> matches = userManager.getCollegeMatches(student, colleges);
		assertEquals(2, matches.size());
	}

}
