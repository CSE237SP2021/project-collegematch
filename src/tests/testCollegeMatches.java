package tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;


import org.junit.jupiter.api.Test;

import collegematch.College;
import collegematch.CollegeManager;
import collegematch.User;

class testCollegeMatches {

	@Test
	void test() {
		User test = new User("plagiarizer", 1600, 4.0, "urban");
		CollegeManager collegeManager = new CollegeManager();
		ArrayList<College> outputCollegeObjects = test.getCollegeMatches(collegeManager.getColleges());
		ArrayList<String> outputCollegeNames = new ArrayList<>();
		String[] output = {"Harvard College", "Washington University"};
		int numberOfCorrectMatches = 0;
		for(College college : outputCollegeObjects) {
			outputCollegeNames.add(college.getCollegeName());
			for(String c : output) {
				if(c.equals(college.getCollegeName())) {
					numberOfCorrectMatches++;
				}
			}
		}
		assertEquals(numberOfCorrectMatches, outputCollegeNames.size());
	}

}
