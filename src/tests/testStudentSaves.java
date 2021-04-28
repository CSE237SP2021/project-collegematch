package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import collegematch.College;

class testStudentSaves {

	@Test
	void testIncrement() {
		College college = new College(1, "Hawaii University", 500, "HI", 1400, 3.3, "Aloha", 5000, 0);
		college.incrementSaves();
		assertEquals(1, college.getNumbeOfSaves());
	}
	
	@Test
	void testDecrement() {
		College college = new College(1, "Hawaii University", 500, "HI", 1400, 3.3, "Aloha", 5000, 1);
		college.decrementSaves();
		assertEquals(0, college.getNumbeOfSaves());
	}
	
	

}
