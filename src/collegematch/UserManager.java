package collegematch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class UserManager {

	private ArrayList<User> users;
	private String filePath = "./src/collegematch/userInfo.csv";
	
	public UserManager() {
		try {
			this.users = this.readUsers();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// checks if entered user name exists in database and returns the object, else returns null
	public User logIn(String userName, String password) {
		for (User user: users) {
			if (user.getUsername().equals(userName)) {

					if(user.getPassword().equals(password)) {
						return user;
					}
					else {
						System.out.println("wrong password bro");
					}
			}
		}
		return null;
	}
	
	
	// reads user information from the database (userInfo.csv file) and create & adds user object to arraylist
	public ArrayList<User> readUsers() throws FileNotFoundException{
		ArrayList<User> allUsers = new ArrayList<User>();
		//Instantiates Scanner class to read userInfo.csv file 
		Scanner keyboardIn = new Scanner(new File(filePath));
		keyboardIn.useDelimiter("/n");
		while (keyboardIn.hasNextLine())
		{
			String[] userDataInArray = keyboardIn.nextLine().split(",");
			if (Integer.parseInt(userDataInArray[1]) == 1) {
				String username = userDataInArray[0];
				int role = Integer.parseInt(userDataInArray[1]);
				int sat = Integer.parseInt(userDataInArray[2]);
				double gpa = Double.parseDouble(userDataInArray[3]);
				int tuitionPreference = Integer.parseInt(userDataInArray[4]);
				int sizePreference = Integer.parseInt(userDataInArray[5]);
				String password = userDataInArray[6];
				Student student = new Student(username, role, sat, gpa, tuitionPreference, sizePreference, password);
				allUsers.add(student);
				if (userDataInArray.length == 8) {
					student.setSavedColleges(userDataInArray[7]);
				} 
			} else {
				String username = userDataInArray[0];
				String password = userDataInArray[3];
				int role = Integer.parseInt(userDataInArray[1]);
				int collegeID = Integer.parseInt(userDataInArray[2]);
				allUsers.add(new AdmissionsOfficer(username, password, role, collegeID));
			}
			
		}
		keyboardIn.close();
		return allUsers;
	}
		
	//registers Student by adding them to total users list and by adding them to userInfo.csv file 
	public void registerStudent(String userName, int role, int satScore, double gpa, int tuitionPreference, int sizePreference, String password) throws IOException {
		Student student = new Student(userName, role, satScore, gpa, tuitionPreference, sizePreference, password);
		users.add(student);
		FileWriter writer = new FileWriter(filePath, true);
		writer.append("\n");
		writer.append(userName);
		writer.append(",");
		writer.append(String.valueOf(role));
		writer.append(",");
		writer.append(String.valueOf(satScore));
		writer.append(",");
		writer.append(String.valueOf(gpa));
		writer.append(",");
		writer.append(String.valueOf(tuitionPreference));
		writer.append(",");
		writer.append(String.valueOf(sizePreference));
		writer.append(",");
		writer.append(password);
		writer.close();	
	}
	
	//registers Admission Officer by adding them to total list of users and by adding them to userInfo.csv file 
	public void registerAdmissionsOfficer(String userName,  String password, int role, int collegeID) throws IOException {
		AdmissionsOfficer admissionsOfficer = new AdmissionsOfficer(userName, password, role, collegeID);
		users.add(admissionsOfficer);
		FileWriter writer = new FileWriter(filePath, true);
		writer.append("\n");
		writer.append(userName);
		writer.append(",");
		writer.append(String.valueOf(role));
		writer.append(",");
		writer.append(String.valueOf(collegeID));
		writer.append(",");
		writer.append(password);
		writer.close();	
	}
	
	//updates user's saved colleges in userInfo.csv 
	public void updateSavedCollegesInFile(Student student) throws FileNotFoundException, IOException {
		String userName = student.getUsername();
		//Instantiates Scanner class to read userInfo.csv file 
		Scanner keyboardIn = new Scanner(new File(filePath));
		//Instantiates StringBuffer class
		StringBuffer buffer = new StringBuffer();
		keyboardIn.useDelimiter("/n");
		//Reads lines of the file and appends them to StringBuffer
		while (keyboardIn.hasNextLine()) {
			String line = keyboardIn.nextLine();
			String[] userDataInArray = line.split(",");
			//finds line that matches student user name
			if (userName.equals(userDataInArray[0])) {
				String newLine = "";
				//checks whether student has any saved colleges 
				if (userDataInArray.length == 7) {
					//if student does have saved colleges, rewrites the entire line 
					userDataInArray[6] = student.getSavedCollegesStringList();
					for (String field : userDataInArray) {
						newLine = newLine + field + ",";
					}
					newLine = newLine.substring(0, newLine.length() - 1);
					line = newLine;
				} else {
					//if student doesn't have saved colleges, adds to end of line 
					newLine = line + "," + student.getSavedCollegesStringList();
					line = newLine;
				}
			}
			buffer.append(line + System.lineSeparator());
		}
		String fileContents = buffer.toString();
		keyboardIn.close();
		//rewrites entire file with FileWriter 
		FileWriter writer = new FileWriter(filePath, false);
		writer.append(fileContents);
		writer.close();	
	}	


	public boolean checkForDuplicateUsername(String userName) {
		for (User user: users) {
			if (user.getUsername().equals(userName)) {
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
	
	public boolean validateTuitionPreference(int tuitionPreference) {
		if (tuitionPreference >= 100 && tuitionPreference <= 100000) {
			return true;
		}
		return false;
	}
	
	public boolean validateSizePreference(int sizePreference) {
		if (sizePreference >= 10 && sizePreference <= 60000) {
			return true;
		}
		return false;
	}
	
	//methods below are called from Menu.java, which uses UserManager as a middle man to call methods on User objects without 
	//violating Law of Demeter 
	public ArrayList<College> getUserSavedCollegeList(Student student) {
		return student.getSavedColleges();
	}

	public ArrayList<College> getCollegeMatches(Student student, ArrayList<College> colleges) {
		ArrayList<College> matches = student.getCollegeMatches(colleges);
		return matches;
	}

	public void saveNewCollege (Student student, College college) {
		student.saveNewCollege(college);
	}
	
	public void deleteSavedCollege (Student student, College college) {
		student.deleteSavedCollege(college);
	}
	
	public int getUserRole (User user) {
		return user.getRole();
	}
		
}
