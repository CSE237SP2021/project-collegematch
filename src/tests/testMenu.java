package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import collegematch.Student;
import collegematch.CollegeManager;
import collegematch.UserManager;
import collegematch.College;
import collegematch.Menu;


public class testMenu {
	
	@Test
	void testCheckCollegeAlreadySaved() {
		CollegeManager collegeManager = new CollegeManager();
		Menu menu = new Menu();
		UserManager userManager = new UserManager();
		Student student = new Student("bob", 1, 1250, 3.5, 20000, 20000, "password");
		student.setSavedColleges("1-2-3-");
		College collegeToBeAdded = collegeManager.findCollege(2);
		ArrayList<College> newSavedColleges = userManager.getUserSavedCollegeList(student);
		boolean alreadySavedCollege = menu.checkCollegeAlreadySaved(newSavedColleges, collegeToBeAdded);
		assertEquals(true, alreadySavedCollege);
		
	}
	
	
	@Test
	void testCheckCollegeNotAlreadySaved() {
		CollegeManager collegeManager = new CollegeManager();
		Menu menu = new Menu();
		UserManager userManager = new UserManager();
		Student student = new Student("bob", 1, 1250, 3.5, 20000, 20000, "password");
		student.setSavedColleges("1-2-3-");
		College collegeToBeAdded = collegeManager.findCollege(5);
		ArrayList<College> newSavedColleges = userManager.getUserSavedCollegeList(student);
		boolean alreadySavedCollege = menu.checkCollegeAlreadySaved(newSavedColleges, collegeToBeAdded);
		assertEquals(false, alreadySavedCollege);
		
	}
	

}
