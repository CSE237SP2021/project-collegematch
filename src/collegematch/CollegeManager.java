package collegematch;

import java.io.*; 

import java.util.Scanner;  

import java.util.ArrayList;

public class CollegeManager {
	private ArrayList<College> colleges;
	
	//hard code college into a arraylist
	public CollegeManager() {
		try {
			this.colleges = this.readColleges();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public College logIn(String collegeName) {
		for (College college: colleges) {
			if (college.getCollegeName().equals(collegeName)) {
				return college;
			}
		}
		return null;
	}
	
	public ArrayList<College> readColleges() throws FileNotFoundException{
		ArrayList<College> allColleges = new ArrayList<College>();
		Scanner keyboardIn = new Scanner(new File("./src/collegematch/college.csv"));
		keyboardIn.useDelimiter("/n");
		while (keyboardIn.hasNextLine())
		{
			String[] collegeDataInArray = keyboardIn.nextLine().split(",");
			allColleges.add(new College(collegeDataInArray[0],  
					Integer.parseInt(collegeDataInArray[1]), collegeDataInArray[2],  
					Integer.parseInt(collegeDataInArray[3]), Double.parseDouble(collegeDataInArray[4]), collegeDataInArray[5], 
					Integer.parseInt(collegeDataInArray[6])));
		}
		keyboardIn.close();
		return allColleges;
	}
	
	//find colleges by college names
	public void searchCollege(String collegeName) {
		boolean collegeNotFound = true;
		for (College college : colleges) {
			if (college.getCollegeName().contains(collegeName)) {
				college.displayCollegeInformation();
				collegeNotFound = false;
			}
			// search for alternative name
			if (college.getCollegeName2().contains(collegeName)) {
				college.displayCollegeInformation();
				collegeNotFound = false;
			}
		}
		if(collegeNotFound) {
			System.out.println("College not found.");
		}
	}

	public void register(String collegeName, int size, String location, int satScore, double gpa, String collegeName2, int tuition) throws IOException {
		College college = new College(collegeName, size, location, satScore, gpa, collegeName2, tuition);
		colleges.add(college);
		FileWriter writer = new FileWriter("./src/collegematch/college.csv", true);

		writer.append("\n");
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
		writer.close();
	}
	
	//return the arraylist of colleges
	public ArrayList<College> getColleges(){
		return colleges;
	}

	//for menu
	public boolean validateSize(String size) {
		if (Integer.parseInt(size)>0) {
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
			if (college.getCollegeName() == collegeName) {
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
			if (college.getCollegeName2() == collegeName2) {
				return true;
			}
		}
		return false;
	}

	public boolean validateTuition(String tuition) {
		if (Integer.parseInt(tuition)>=0) {
			return true;
		}
		return false;
	}

	public void displayCollege(College college) {
		college.displayCollegeInformation();
	}

}
