package collegematch;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.*;
public class Menu {
	
	private Scanner keyboardIn;
	private UserManager userManager;
	private User currentUser;
	private CollegeManager collegeManager;
	
	public Menu() {
		keyboardIn = new Scanner(System.in);
		this.userManager = new UserManager();
		this.collegeManager = new CollegeManager();
	}
	
	public static void main(String[] args) throws Exception {
		
		Menu collegeMatchMenu = new Menu();
		collegeMatchMenu.runMainMenu(collegeMatchMenu);
	}

	public void runMainMenu (Menu collegeMatchMenu) throws Exception {
		System.out.println("Welcome to CollegeMatch!");
		this.runWelcomeMenu();	
		keyboardIn.close();
	}
	
	//welcome menu interface
	private void runWelcomeMenu() throws Exception {
		displayWelcomeMenu();
		processBaseMethod("int", "processWelcomeMenu");
	}	

	public void displayWelcomeMenu() {
		System.out.println("Please select an option: ");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Exit");
	}
	
	public void processWelcomeMenu(int welcomeSelection) throws Exception {
		if (welcomeSelection == 1) {
			runLoginMenu();
		} else if (welcomeSelection == 2) {
			runRegisterMenu();
		} else if (welcomeSelection == 3) {
			System.exit(0);
		} else {
			while (welcomeSelection != 1 || welcomeSelection != 2) {
				runWelcomeMenu();
			}	
		}
	}
	
	//login interface
	public void runLoginMenu() throws Exception {
		System.out.println("Enter username: ");
		String userName = keyboardIn.nextLine();
		currentUser = userManager.logIn(userName);
		processLoginMenu();	
	}

	public void processLoginMenu() throws Exception {
		if(currentUser != null) {
			System.out.println("Login successful");
			if (userManager.getUserRole(currentUser) == 1) {
				runStudentMenu();
			} else {
				runAdmissionsOfficerMenu();
			}	
		} else {
			System.out.println("Login unsuccessful. Transferring you to Welcome menu");
			runWelcomeMenu();
		}
	}
	
	//admissions officer menu  
	public void runAdmissionsOfficerMenu() throws Exception {
		displayAdmissionsOfficerMenu();
		processBaseMethod("int", "processAdmissionsOfficerMenu");
		while (true) {
			displayAdmissionsOfficerMenu();
			processBaseMethod("int", "processAdmissionsOfficerMenu");
		}
	}

	//student menu
	public void runStudentMenu() throws Exception {
		displayStudentMenu();
		processBaseMethod("int", "processStudentMenu");
		while (true) {
			displayStudentMenu();
			processBaseMethod("int", "processStudentMenu");
		}
	}
	
	//register interface
	public void runRegisterMenu() throws Exception {
		while(true) {
			displayRegisterMenu();
			processBaseMethod("int", "processRegisterMenu");
		}
	}
	
	public void displayRegisterMenu() {
		System.out.println("Please select an option: ");
		System.out.println("1. Register as a Student");
		System.out.println("2. Register as an Admissions Officer");
		System.out.println("3. Return to Welcome Menu");
	}

	public void processRegisterMenu(int registrationSelection) throws Exception {
		if (registrationSelection == 1) {
			runStudentRegisterMenu();
		} else if (registrationSelection == 2) {
			runAdmissionsOfficerRegisterMenu();
		} 
		else if (registrationSelection == 3) {
			runWelcomeMenu();
		}
	}
	
	//student register 
	public void runStudentRegisterMenu() throws Exception {
		System.out.println("Enter a username: ");
		String userName = processStringBaseMethod("processUsername");
		
		System.out.println("Enter your SAT Score: ");
		int satScore = processIntBaseMethod("processSATScore");
		
		System.out.println("Enter your GPA: ");
		double gpa = processDoubleBaseMethod("processGPA");
		
		System.out.println("Enter maximum tuition preference (value must be between 100 and 100000): ");
		int tuitionPreference = processIntBaseMethod("processTuitionPreference");
		
		System.out.println("Enter maximum campus size preference (value must be between 10 and 60000): ");
		int sizePreference = processIntBaseMethod("processSizePreference");
		
		userManager.registerStudent(userName, 1, satScore, gpa, tuitionPreference, sizePreference);
		System.out.println("Registration successful. Transferring you to Welcome menu");
		runWelcomeMenu();
	}

	//start process methods to validate student register inputs 
	public int processSizePreference(int sizePreference) {
		while (!userManager.validateSizePreference(sizePreference)) {
			System.out.println("Error: Enter maximum campus size preference (value must be between 10 and 60000): ");	
			sizePreference = getIntInput();
		}
		return sizePreference;
	}

	public int processTuitionPreference(int tuitionPreference) {
		while (!userManager.validateTuitionPreference(tuitionPreference)) {
			System.out.println("Error: Enter maximum tuition preference (value must be between 100 and 100000): ");	
			tuitionPreference = getIntInput();
		}
		return tuitionPreference;
	}

	public double processGPA(double gpa) {
		while (!userManager.validateGPA(gpa)) {
			System.out.println("Error: GPA must be between 0.0 and 4.0");
			System.out.println("Enter your GPA: ");
			gpa = getDoubleInput();
		}
		return gpa;
	}

	public int processSATScore(int satScore) {
		while (!userManager.validateSATScore(satScore)) {
			System.out.println("Error: SAT Scores must be between 400 and 1600");
			System.out.println("Enter your SAT Score: ");
			satScore = getIntInput();
		}
		return satScore;
	}

	public String processUsername(String userName) {
		while (userManager.checkForDuplicateUsername(userName)) {
			System.out.println("Error: Username already exists.");
			System.out.println("Enter a different username: ");
			userName = keyboardIn.nextLine();
		}
		return userName;
	}
	//end process methods to validate student register inputs
	
	//admission officer register 
	public void runAdmissionsOfficerRegisterMenu() throws Exception {
		System.out.println("Enter a username: ");
		String userName = processStringBaseMethod("processUsername");
		
		collegeManager.displayAllColleges();
		
		while(true) {
			System.out.println("Enter collegeID or enter 0 if your college is not on the list: ");
			int collegeSelection = getIntInput();
			if (collegeSelection == 0) {
				System.out.println("Enter a college name: ");
				String collegeName = processStringBaseMethod("processCollegeName");
				
				System.out.println("Enter college size: ");
				int collegeSize = processIntBaseMethod("processCollegeSize");
				
				System.out.println("Enter college State code: ");
				String collegeStateCode = processStringBaseMethod("processCollegeLocation");
				
				System.out.println("Enter college's average SAT Score: ");
				int satScore = processIntBaseMethod("processCollegeSATScore");
				
				System.out.println("Enter college's average GPA: ");
				double gpa = processDoubleBaseMethod("processCollegeGPA");
				
				System.out.println("Enter college's nick name: ");
				String collegeNickName = processStringBaseMethod("processCollegeNickname");
				
				System.out.println("Enter college's tuition: ");
				int tuition = processIntBaseMethod("processCollegeTuition");
				
				int collegeID = collegeManager.addCollege(collegeName, collegeSize, collegeStateCode, satScore, gpa, collegeNickName, tuition);
				userManager.registerAdmissionsOfficer(userName, 2, collegeID);
				System.out.println("Registration successful. Transferring you to Welcome menu");
				runWelcomeMenu();
			} else {
				College collegeToBeSaved = collegeManager.findCollege(collegeSelection);
				if (collegeToBeSaved == null) {
					System.out.println("Invalid college ID.");
				} else {
					userManager.registerAdmissionsOfficer(userName, 2, collegeSelection);
					System.out.println("Registration successful. Transferring you to Welcome menu");
					runWelcomeMenu();
				}
			}
		}
		
	}
	
	//start process methods to validate admission officer register inputs 
	public int processCollegeTuition(int tuition) {
		while (!collegeManager.validateTuition(tuition) ) {
			System.out.println("Tuition must be between 100 and 100000");
			System.out.println("Enter college's tuition: ");
			tuition = getIntInput();
		}
		return tuition;
	}

	public String processCollegeNickname(String collegeNickName) {
		while (collegeManager.checkForDuplicateCollegename(collegeNickName)) {
			System.out.println("Nick name already exists.");
			System.out.println("Enter a different nick name: ");
			collegeNickName= keyboardIn.nextLine();
		}
		return collegeNickName;
	}

	public double processCollegeGPA(double gpa) {
		while (!collegeManager.validateGPA(gpa)) {
			System.out.println("GPA must be between 0.0 and 4.0");
			System.out.println("Enter college's average GPA: ");
			gpa = getDoubleInput();
		}
		return gpa;
	}

	public int processCollegeSATScore(int satScore) {
		while (!collegeManager.validateSATScore(satScore)) {
			System.out.println("SAT Scores must be between 400 and 1600");
			System.out.println("Enter college's average SAT Score: ");
			satScore = getIntInput();
		}
		return satScore;
	}

	public String processCollegeLocation(String collegeStateCode) {
		while (!collegeManager.validateLocation(collegeStateCode)) {
			System.out.println("Location must be two letters in size and represent a real state");
			System.out.println("Enter college State code: ");
			collegeStateCode = keyboardIn.nextLine();
		}
		return collegeStateCode;
	}

	public int processCollegeSize(int collegeSize) {
		while (!collegeManager.validateSize(collegeSize)) {
			System.out.println("Size must be between 10 and 60000");
			System.out.println("Enter college size: ");
			collegeSize = getIntInput();
		}
		return collegeSize;
	}

	public String processCollegeName(String collegeName) {
		while (collegeManager.checkForDuplicateCollegename(collegeName)) {
			System.out.println("College already exists.");
			System.out.println("Enter a different college name: ");
			collegeName = keyboardIn.nextLine();
		}
		return collegeName;
	}
	//end process methods to validate admission officer register inputs 
	
	public void displayStudentMenu() {
		System.out.println("Please select an option: ");
		System.out.println("1. Display saved colleges");
		System.out.println("2. Edit saved colleges");
		System.out.println("3. Get college matches");
		System.out.println("4. Search college database");
		System.out.println("5. Sign out");
	}
	
	public void displayAdmissionsOfficerMenu() {
		System.out.println("Please select an option: ");
		System.out.println("1. Display college information");
		System.out.println("2. Sign out");
	}
	
	//Processes the student selected option from student menu
	//1. Displays saved colleges
	//2. Edit saved colleges
	//3. Get college matches
	//4. Search college database
	//5. Sign out
	public void processStudentMenu(int studentOption) throws Exception {
		//cases current user as Student to pass student object to methods in UserManager.java
		//follows Law of Demeter because no method is directly called on currentUser
		Student student = (Student) currentUser; 
		ArrayList<College> savedColleges = userManager.getUserSavedCollegeList(student);
		if (studentOption == 1) {
			displaySavedColleges(savedColleges);
		} else if(studentOption == 2) {
			//checks whether user has no saved colleges before allowing user to edit saved college list 
			if (savedColleges.size() == 0) {
				processNoSavedColleges(student);
			} else {  
				displaySavedColleges(savedColleges);
				processSavedColleges(student, savedColleges);
			}
			
		} else if (studentOption == 3) {
			ArrayList<College> colleges = collegeManager.getColleges();
			ArrayList<College> matches = userManager.getCollegeMatches(student, colleges);
			displayMatches(matches);
		} else if (studentOption == 4) { 
			System.out.println("Enter the name of the college to be searched: ");
			String collegeName = keyboardIn.nextLine();
			System.out.println("");
			collegeManager.searchCollege(collegeName);
			System.out.println("");
		} else if (studentOption == 5) { 
			signOut("student");
		} else {
			System.out.println("");
			System.out.println("Incorrect input.");
			System.out.println("");
		}
	}

	//method called when student has at one college saved and tries to edit saved college list 
	public void processSavedColleges(Student student, ArrayList<College> savedColleges)
			throws FileNotFoundException, IOException {
		while(true) {
			System.out.println("Enter 1 to save new college or 2 to delete a saved college: ");
			int savedCollegeSelection = getIntInput();
			if (savedCollegeSelection == 1) {
				saveNewCollege(student, savedColleges);
				break;
			} else if (savedCollegeSelection == 2) {
				deleteSavedCollege(student, savedColleges);
				break;
			} else {
				System.out.println("Incorrect input.");
			}
		}
	}
	
	//method called when student wants to delete saved college
	public void deleteSavedCollege(Student student, ArrayList<College> savedColleges)
			throws FileNotFoundException, IOException {
		displaySavedColleges(savedColleges);
		while(true) {
			System.out.println("Enter one collegeID to delete: ");
			int collegeSelection = getIntInput();
			//checks if student selects input correctly from list 
			if (collegeSelection > 0 && collegeSelection <= savedColleges.size()) {
				//deletes college from local Student object savedColleges ArrayList
				userManager.deleteSavedCollege(student, savedColleges.get(collegeSelection - 1));
				//displays current saved colleges 
				ArrayList<College> newSavedColleges = userManager.getUserSavedCollegeList(student);
				if (newSavedColleges.size() == 0) {
					System.out.println("You currently have no saved colleges.");
				} else {
					displaySavedColleges(newSavedColleges);
				}	
				//deletes college from userInfo.csv file	
				userManager.updateSavedCollegesInFile(student);
				break;
			} else {
				System.out.println("Invalid college ID.");
			}
		}
	}

	public void saveNewCollege(Student student, ArrayList<College> savedColleges)
			throws FileNotFoundException, IOException {
		collegeManager.displayAllColleges();
		while(true) {
			System.out.println("Enter one collegeID to save: ");
			int collegeSelection = getIntInput();
			College collegeToBeSaved = collegeManager.findCollege(collegeSelection);
			if (collegeToBeSaved == null) {
				System.out.println("Invalid college ID.");
			} else {
				//prevent user from adding a saved college again 
				boolean alreadySaved = checkCollegeAlreadySaved(savedColleges, collegeToBeSaved);
				if (alreadySaved) {
					System.out.println("College has already been saved.");
				} else {
					//saves college to local Student object savedColleges ArrayList
					userManager.saveNewCollege(student, collegeToBeSaved);
					//displays current saved colleges
					ArrayList<College> newSavedColleges = userManager.getUserSavedCollegeList(student);
					displaySavedColleges(newSavedColleges);
					//adds new college to userInfo.csv file	
					userManager.updateSavedCollegesInFile(student);
					break;
				}
			}
		}
	}
	
	public boolean checkCollegeAlreadySaved(ArrayList<College> savedColleges, College collegeToBeSaved) {
		boolean alreadySaved = false;
		for (College college : savedColleges) {
			if (college.getCollegeID() == collegeToBeSaved.getCollegeID()) {
				alreadySaved = true;
			} 
		}
		return alreadySaved;
	}

	//method called when student has no saved colleges but tries to edit saved colleges from menu 
	public void processNoSavedColleges(Student student) throws FileNotFoundException, IOException {
		System.out.println("");
		collegeManager.displayAllColleges();
		while(true) {
			System.out.println("You currently have no saved colleges. Enter one collegeID to save: ");
			int collegeSelection = getIntInput();
			College collegeToBeSaved = collegeManager.findCollege(collegeSelection);
			if (collegeToBeSaved == null) {
				System.out.println("Invalid college ID.");
			} else {
				//saves college to local Student object savedColleges ArrayList
				userManager.saveNewCollege(student, collegeToBeSaved);
				//displays current saved colleges
				ArrayList<College> newSavedColleges = userManager.getUserSavedCollegeList(student);
				displaySavedColleges(newSavedColleges);
				//adds new college to userInfo.csv file 
				userManager.updateSavedCollegesInFile(student);
				break;
			}
		}
	}

	public void displaySavedColleges(ArrayList<College> savedColleges) {
		System.out.println("");
		if (savedColleges.size() == 0) {
			System.out.println("You have no saved colleges");
		} else {
			System.out.println("Your current saved colleges are: ");
			for (int i = 1; i <= savedColleges.size(); i++) {
				System.out.println(i + ". " + (savedColleges.get(i-1)).getCollegeName());
			}
		}
		System.out.println("");
	}
	

	public void displayMatches(ArrayList<College> matches) {
		if (matches.isEmpty()) {
			System.out.println("Currently, no colleges can be matched according to your info, please check for updates!");
		}
		else {
			System.out.println("");
			System.out.println("List of your matched college(s) are: ");
			for (int i = 0; i < matches.size(); i++) {
				System.out.println((i + 1) + ". " + matches.get(i).getCollegeName());
			}
			System.out.println("");
		}
	}
	
	//Processes the admission officer selected option
	//1. Display college information
	//2. Sign out 
	public void processAdmissionsOfficerMenu(int admissionsOfficerOption) throws Exception {
		//casts current user as admission officer to call call methods from AdmissionsOfficer.java 
		AdmissionsOfficer admissionsOfficer = (AdmissionsOfficer) currentUser; 
		//displays college info associated with admissions officer 
		if (admissionsOfficerOption == 1) {
			College collegeToBeDisplayed = collegeManager.findCollege(admissionsOfficer.getCollegeID());
			System.out.println("");
			collegeToBeDisplayed.displayCollegeInformation();
			System.out.println("");
		//confirms whether admissions officer actually wants to sign out
		} else if (admissionsOfficerOption == 2) {
			signOut("admissionsOfficer");
		//prints error message if one of admission officer menu options is not selected 
		} else {
			System.out.println("");
			System.out.println("Incorrect input.");
			System.out.println("");
		}
	}
	
	//confirms user sign out 
	//reads in user type as String to display correct menu if user decides not to sign out 
	public void signOut(String userType) throws Exception {
		while(true) {
			System.out.println("Are you sure you want to sign out? (y/n) ");
			String confirmation = keyboardIn.nextLine();
			if(confirmation.equals("y")) {
				System.out.println("You have been signed out");
				runWelcomeMenu();
			} else if (confirmation.equals("n")) {
				if (userType == "student") {
					displayStudentMenu();
					processBaseMethod("int", "processStudentMenu");
				} else {
					displayAdmissionsOfficerMenu();
					processBaseMethod("int", "processAdmissionsOfficerMenu");
				}
					
			} 
		}
	}
	
	//reads in method name and user input types as Strings and invokes method on user input 
	public void processBaseMethod (String varType, String processMethodName) throws Exception {
		
		if (varType.equals("int")) {
			int varInt = getIntInput();
			Method processMethod = this.getClass().getMethod(processMethodName, int.class);
			processMethod.invoke(this, varInt);
		}
		if (varType.equals("String")) {
			String varString = keyboardIn.nextLine();
			Method processMethod = this.getClass().getMethod(processMethodName, String.class);
			processMethod.invoke(this, varString);
		}
	}	
	
	//reads in method name as String, invokes method on user input, and returns String 
	public String processStringBaseMethod (String processMethodName) throws Exception {
		String varString = keyboardIn.nextLine();
		Method processMethod = this.getClass().getMethod(processMethodName, String.class);
		return (String) processMethod.invoke(this, varString);
	}	
	
	//reads in method name as String, invokes method on user input, and returns int 
	public int processIntBaseMethod (String processMethodName) throws Exception {
		int varInt = getIntInput();
		Method processMethod = this.getClass().getMethod(processMethodName, int.class);
		return (int) processMethod.invoke(this, varInt);
	}	
	
	//reads in method name as String, invokes method on user input, and returns double 
	public double processDoubleBaseMethod (String processMethodName) throws Exception {
		double varDouble = getDoubleInput();
		Method processMethod = this.getClass().getMethod(processMethodName, double.class);
		return (double) processMethod.invoke(this, varDouble);
	}	
	
	//deletes new line when obtaining double from user
	private double getDoubleInput() {
		double selected = keyboardIn.nextDouble();
		String notUsed = keyboardIn.nextLine();
		return selected;
	}
	
	//deletes new line when obtaining int from user
	private int getIntInput() {
		int selected = keyboardIn.nextInt();
		String notUsed = keyboardIn.nextLine();
		return selected;
	}
	
}
