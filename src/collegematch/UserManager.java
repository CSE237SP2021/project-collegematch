package collegematch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class UserManager {

	private ArrayList<User> users;
	
	public UserManager() {
		try {
			this.users = this.readUsers();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// checks if entered user name exists in database and returns the object, else returns null
	public User logIn(String userName) {
		for (User user: users) {
			if (user.getUsername().equals(userName)) {
				return user;
			}
		}
		return null;
	}
	
	// reads userinfo from the databse(csv file) file and create & adds user object to arraylist
		public ArrayList<User> readUsers() throws FileNotFoundException{
			ArrayList<User> allUsers = new ArrayList<User>();
			Scanner keyboardIn = new Scanner(new File("./src/collegematch/userInfo.csv"));
			keyboardIn.useDelimiter("/n");
			while (keyboardIn.hasNextLine())
			{
				String[] userDataInArray = keyboardIn.nextLine().split(",");
				allUsers.add(new User(userDataInArray[0],  Integer.parseInt(userDataInArray[1]), Double.parseDouble(userDataInArray[2]), userDataInArray[3]));
			}
			keyboardIn.close();
			return allUsers;
		}
		
		// registers new user by creating a new user object, adding it to array list and database.
		public void register(String userName, int satScore, double gpa, String campusPreference) throws IOException {
			User user = new User(userName, satScore, gpa, campusPreference);
			users.add(user);
			FileWriter writer = new FileWriter("./src/collegematch/userInfo.csv", true);
			writer.append("\n");
			writer.append(userName);
			writer.append(",");
			writer.append(String.valueOf(satScore));
			writer.append(",");
			writer.append(String.valueOf(gpa));
			writer.append(",");
			writer.append(campusPreference);
			writer.close();
		}
		
		public boolean validateCampusPreference(String campusPreference) {
			if (campusPreference.equals("rural" )|| campusPreference.equals("urban")) {
				return true;
			}
			return false;
		}

		public boolean checkForDuplicateUsername(String userName) {
			for (User user: users) {
				if (user.getUsername() == userName) {
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
		
		public void displayUserSavedCollegeList(User user) {
			user.displaySavedColleges();
		}

		public ArrayList<College> getCollegeMatches(User user, ArrayList<College> colleges) {
			ArrayList<College> matches = user.getCollegeMatches(colleges);
			return matches;
		}
}
