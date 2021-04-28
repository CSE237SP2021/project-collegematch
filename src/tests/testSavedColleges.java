package tests;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import collegematch.Student;
import collegematch.CollegeManager;
import collegematch.College;


public class testSavedColleges {
	
	
	@Test 
	void testSetSavedColleges() {
		Student student = new Student("bob", 1, 1250, 3.5, 20000, 20000, "password");
		student.setSavedColleges("1-2-3-");
		assertEquals(3, student.getSavedCollegesSize());
	}
	
	@Test
	void testFindCollege() {
		CollegeManager collegeManager = new CollegeManager();
		College college = collegeManager.findCollege(1);
		assertTrue(college != null);
	}
	
	@Test 
	void testAddToSavedColleges() {
		CollegeManager collegeManager = new CollegeManager();
		Student student = new Student("bob", 1, 1250, 3.5, 20000, 20000, "password");
		student.setSavedColleges("1-2-3-");
		College collegeToBeAdded = collegeManager.findCollege(4);
		student.saveNewCollege(collegeToBeAdded);
		assertEquals(4, student.getSavedCollegesSize());
	}
	
	@Test 
	void testDeleteFromSavedColleges() {
		CollegeManager collegeManager = new CollegeManager();
		Student student = new Student("bob", 1, 1250, 3.5, 20000, 20000, "password");
		student.setSavedColleges("1-2-3-");
		College collegeToBeRemoved = collegeManager.findCollege(3);
		student.deleteSavedCollege(collegeToBeRemoved);
		assertEquals(2, student.getSavedCollegesSize());
	}
	
	
	@Test
	void testGetSavedCollegeStringList() {
		Student student = new Student("bob", 1, 1250, 3.5, 20000, 20000, "password");
		student.setSavedColleges("1-2-3-");
		String collegeList = student.getSavedCollegesStringList();
		assertEquals("1-2-3-", collegeList);
	}
	

}
