package collegematch;
import java.io.BufferedWriter;
import java.io.File;
import java.io.Writer;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class CollegeManager {
	private ArrayList<College> colleges;
	private Scanner scanner;
	
	public CollegeManager() {
		try {
			this.colleges = this.readColleges();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// reads college information from the database (college.csv file) and create & adds college object to arraylist
	public ArrayList<College> readColleges() throws FileNotFoundException{
		ArrayList<College> allColleges = new ArrayList<College>();
		Scanner keyboardIn = new Scanner(new File("./src/collegematch/college.csv"));
		keyboardIn.useDelimiter("/n");
		while (keyboardIn.hasNextLine())
		{
			String[] collegeDataInArray = keyboardIn.nextLine().split(",");
			if(collegeDataInArray.length == 9) {
				int collegeID = Integer.parseInt(collegeDataInArray[0]);
				String collegeName = collegeDataInArray[1];
				int size = Integer.parseInt(collegeDataInArray[2]);
				String state = collegeDataInArray[3];
				int sat = Integer.parseInt(collegeDataInArray[4]);
				double gpa = Double.parseDouble(collegeDataInArray[5]);
				String nickname = collegeDataInArray[6];
				int tuition = Integer.parseInt(collegeDataInArray[7]);
				int numberOfSaves = Integer.parseInt(collegeDataInArray[8]);
				allColleges.add(new College(collegeID, collegeName, size, state, sat, gpa, nickname, tuition, numberOfSaves));
			}
		}
		keyboardIn.close();
		return allColleges;
	}
	
	//rewrites the updated arraylist in college.csv  											
	public void updateColleges() throws IOException{
		FileWriter writer = new FileWriter("./src/collegematch/college.csv", false);
		for (int i = 0; i < colleges.size(); i++) {
			if (i != 0) {
				writer.append("\n");
			}
			writer.append(String.valueOf(colleges.get(i).getCollegeID()));
			writer.append(",");
			writer.append(colleges.get(i).getCollegeName());
			writer.append(",");
			writer.append(String.valueOf(colleges.get(i).getSize()));
			writer.append(",");
			writer.append(colleges.get(i).getLocation());
			writer.append(",");
			writer.append(String.valueOf(colleges.get(i).getSatScore()));
			writer.append(",");
			writer.append(String.valueOf(colleges.get(i).getGpa()));
			writer.append(",");
			writer.append(colleges.get(i).getCollegeName2());
			writer.append(",");
			writer.append(String.valueOf(colleges.get(i).getTuition()));
			writer.append(",");
			writer.append(String.valueOf(colleges.get(i).getNumbeOfSaves()));
		}
		writer.close();
	}
	
	//find colleges by college names
	public void searchCollege(String collegeName) {
		boolean collegeNotFound = true;
		for (College college : colleges) {
			if (college.getCollegeName().contains(collegeName)) {
				college.displayCollegeInformation();
				collegeNotFound = false;
			} else if (college.getCollegeName2().contains(collegeName)) {
				college.displayCollegeInformation();
				collegeNotFound = false;
			}
		}
		if(collegeNotFound) {
			System.out.println("College not found.");
		}
	}

	//adds college to colleges ArrayList and adds college to end of college.csv
	public int addCollege(String collegeName, int size, String location, int satScore, double gpa, String collegeName2, int tuition, int numberOfSaves) throws IOException {
		int collegeID = colleges.size() + 1;
		College college = new College(collegeID, collegeName, size, location, satScore, gpa, collegeName2, tuition, numberOfSaves);
		colleges.add(college);
		FileWriter writer = new FileWriter("./src/collegematch/college.csv", true);

		writer.append("\n");
		writer.append(String.valueOf(collegeID));
		writer.append(",");
		writer.append(collegeName);
		writer.append(",");
		writer.append(String.valueOf(size));
		writer.append(",");
		writer.append(location);
		writer.append(",");
		writer.append(String.valueOf(satScore));
		writer.append(",");
		writer.append(String.valueOf(gpa));
		writer.append(",");
		writer.append(collegeName2);
		writer.append(",");
		writer.append(String.valueOf(tuition));
		writer.append(",");
		writer.append(String.valueOf(numberOfSaves));
		writer.close();
		return collegeID;
	}
	
	//delete college from college.csv, and therefore delete college from the System 			new
	public int deleteCollege(int collegeID) throws IOException {
		//int index=collegeID-1;
		colleges.remove(collegeID-1);
		return collegeID;
	}
	

	//returns College object when given collegeID
	public College findCollege (int collegeID) {
		for (College college : colleges) {
			if (collegeID == college.getCollegeID()) {
				return college;
			}
		}
		return null;
	}
	
	
	public ArrayList<College> getColleges(){
		return colleges;
	}

	public boolean validateSize(int size) {
		if (size >= 10 && size <= 60000) {
			return true;
		}
		return false;
	}

	//perhaps we can update this in iteration 3
	public boolean validateLocation(String location) {
		if (location.length()==2) {
			return true;
		}
		return false;
	}


	public boolean checkForDuplicateCollegename(String collegeName) {
		for (College college: colleges) {
			if (college.getCollegeName().equals(collegeName)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean validateSATScore(int satScore) {
		if (satScore >= 400 && satScore <= 1600) {
			return true;
		}
		return false;
	}
	
	public boolean validateGPA(double gpa) {
		if (gpa >= 0.0 && gpa <= 4.0) {
			return true;
		}
		return false;
	}

	public boolean checkForDuplicateCollegename2(String collegeName2) {
		for (College college: colleges) {
			if (college.getCollegeName2().equals(collegeName2)) {
				return true;
			}
		}
		return false;
	}

	public boolean validateTuition(int tuition) {
		if (tuition >= 100 && tuition <= 100000) {
			return true;
		}
		return false;
	}

	
	public void displayCollege(College college) {
		college.displayCollegeInformation();
	}
	
	
	public void displayAllColleges() {
		System.out.println("ID" + " College Name");
		System.out.println();
		for (College college : colleges) {
			System.out.println(college.getCollegeID() + "  " + college.getCollegeName());
		}
	}
	
	public int getCollegesLength() {
		return colleges.size();
	}

}