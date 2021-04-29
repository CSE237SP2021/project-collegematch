package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.File;
import java.util.Date;

import org.junit.jupiter.api.Test;

import collegematch.CollegeManager;

class testUpdateColleges {

	@Test
	void test() throws IOException {
		String filePath = "./src/collegematch/college.csv";
		File file = new File(filePath);
		long lastModified = file.lastModified();
		Date date = new Date(lastModified);
		CollegeManager cm= new CollegeManager();
		cm.updateColleges();
		long modifiedAgain = file.lastModified();
		Date newDate = new Date(modifiedAgain);
		assertTrue(date.compareTo(newDate) < 0);
	}
}