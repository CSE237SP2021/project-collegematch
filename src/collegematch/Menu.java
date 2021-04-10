package collegematch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	private Scanner keyboardIn;
	private UserManager userManager;
	private User currentUser;
	private College currentCollege;
	private CollegeManager collegeManager;
	
	public Menu() {
		keyboardIn = new Scanner(System.in);
		this.userManager = new UserManager();
		this.collegeManager = new CollegeManager();
	}
	
	public static void main(String[] args) throws IOException {
		
		Menu collegeMatchMenu = new Menu();
		collegeMatchMenu.runMainMenu(collegeMatchMenu);
	}

	public void runMainMenu (Menu collegeMatchMenu) throws IOException {
		this.displayLoginMenu();	
		keyboardIn.close();
	}
	
			
	// login interface
	private void displayLoginMenu() throws IOException {
		System.out.println("Welcome to CollegeMatch!");
		System.out.println("Are you a student or a college admissions officer?");
		String accountType = keyboardIn.nextLine();
		if(accountType.toLowerCase().equals("student")) {
			System.out.println("Enter username: ");
			String userName = keyboardIn.nextLine();
			currentUser = userManager.logIn(userName);
			if(currentUser != null) {
				System.out.println("Login successful");
				displayStudentMenu();
				int selectedOption = this.getUserInput();
				this.processStudentMenu(selectedOption);
			} else {
				System.out.println("Login unsuccessful. Transferring you to Register menu");
				displayRegisterMenu();
				displayLoginMenu();
			}	
		}
		else if(accountType.toLowerCase().equals("admissions officer") || accountType.toLowerCase().equals("college admissions officer")){
			System.out.println("Enter college name: ");
			String collegeName = keyboardIn.nextLine();
			currentCollege = collegeManager.logIn(collegeName);
			if(currentCollege != null) {
				System.out.println("Login successful");
				displayCollegeMenu();
				int selectedOption = this.getUserInput();
				this.processCollegeMenu(selectedOption);
			} else {
				System.out.println("Login unsuccessful. Transferring you to Register menu");
				displayRegisterMenu();
				displayLoginMenu();
			}	
		}
		else {
			System.out.println("Please enter either 'student' or 'admissions officer'");
			displayLoginMenu();
		}
	}
	
	//register interface
	public void displayRegisterMenu() throws IOException {
		System.out.println("Are you a student or a college admissions officer?");
		String accountType = keyboardIn.nextLine();
		if(accountType.toLowerCase().equals("student")) {
			System.out.println("Enter a username: ");
			String userName = keyboardIn.nextLine();
			while (userManager.checkForDuplicateUsername(userName)) {
				System.out.println("Username already exists.");
				System.out.println("Enter a different username: ");
				userName = keyboardIn.nextLine();
			}
			System.out.println("Enter your SAT Score: ");
			int satScore = keyboardIn.nextInt();
			while (!userManager.validateSATScore(satScore)) {
				System.out.println("SAT Scores must be between 400 and 1600");
				System.out.println("Enter your SAT Score: ");
				satScore = keyboardIn.nextInt();
			}
			System.out.println("Enter your GPA: ");
			double gpa = getDoubleInput();
			while (!userManager.validateGPA(gpa)) {
				System.out.println("GPA must be between 0.0 and 4.0");
				System.out.println("Enter your GPA: ");
				gpa = getDoubleInput();
			}
			System.out.println("Enter your whether you prefer \"rural\" or \"urban\" campuses: ");
			String campusPreference = keyboardIn.nextLine();
			while (!userManager.validateCampusPreference(campusPreference)) {
				System.out.println("Responses must be \"rural\" or \"urban\". Please try again: ");
				campusPreference = keyboardIn.nextLine();
			}
			userManager.register(userName, satScore, gpa, campusPreference);
			System.out.println("Registration successful. Transferring you to Login menu");
		}
		else if(accountType.toLowerCase().equals("admissions officer") || accountType.toLowerCase().equals("college admissions officer")) {
			System.out.println("Enter a college name: ");
			String collegeName = keyboardIn.nextLine();
			while (collegeManager.checkForDuplicateCollegename(collegeName)) {
				System.out.println("Username already exists.");
				System.out.println("Enter a different username: ");
				collegeName = keyboardIn.nextLine();
			}
			System.out.println("Enter college size: ");
			String collegeSize = keyboardIn.nextLine();
			while (!collegeManager.validateSize(collegeSize)) {
				System.out.println("Size must be a positive integer");
				System.out.println("Enter college size: ");
				collegeSize = keyboardIn.nextLine();
			}
			System.out.println("Enter college State code: ");
			String collegeStateCode = keyboardIn.nextLine();
			while (!collegeManager.validateLocation(collegeStateCode)) {
				System.out.println("Location must be two letters in size and represnt a real state");
				System.out.println("Enter college State code: ");
				collegeStateCode = keyboardIn.nextLine();
			}
			System.out.println("Enter college's average SAT Score: ");
			int satScore = keyboardIn.nextInt();
			while (!collegeManager.validateSATScore(satScore)) {
				System.out.println("SAT Scores must be between 400 and 1600");
				System.out.println("Enter college's average SAT Score: ");
				satScore = keyboardIn.nextInt();
			}
			System.out.println("Enter college's average GPA: ");
			double gpa = getDoubleInput();
			while (!collegeManager.validateGPA(gpa)) {
				System.out.println("GPA must be between 0.0 and 4.0");
				System.out.println("Enter college's average GPA: ");
				gpa = getDoubleInput();
			}

			System.out.println("Enter college's nick name: ");
			String collegeNickName= keyboardIn.nextLine();
			while (collegeManager.checkForDuplicateCollegename(collegeNickName)) {
				System.out.println("Nick name already exists.");
				System.out.println("Enter a different nick name: ");
				collegeNickName= keyboardIn.nextLine();
			}
			System.out.println("Enter college's tuition: ");
			int tuition = keyboardIn.nextInt();
			while (!collegeManager.validateGPA(gpa)) {
				System.out.println("GPA must be between 0.0 and 4.0");
				System.out.println("Enter college's average GPA: ");
				tuition = keyboardIn.nextInt();
			}
			
			collegeManager.register(collegeName, Integer.parseInt(collegeSize), collegeStateCode, satScore, gpa, collegeNickName, tuition);
			System.out.println("Registration successful. Transferring you to Login menu");
		}
		else {
			System.out.println("Please either enter 'student' or 'admissions officer'");
		}
	}
	//shows option for user
	public void displayStudentMenu() {
		System.out.println("Please select an option: ");
		System.out.println("1. Display saved colleges");
		System.out.println("2. Get college matches");
		System.out.println("3. Search college database");
		System.out.println("4. Sign out");
	}
	
	public void displayCollegeMenu() {
		System.out.println("Please select an option: ");
		System.out.println("1. Display college information");
		System.out.println("2. Sign out ");
	}
	//Processes the user selected option
	//1. Displays saved colleges
	//2. Gets college matches
	//3. Searches college database
	public void processStudentMenu(int studentOption) throws IOException {
		if(studentOption == 1) {
			userManager.displayUserSavedCollegeList(currentUser);
		} else if (studentOption == 2) {
			ArrayList<College> colleges = collegeManager.getColleges();
			ArrayList<College> matches = userManager.getCollegeMatches(currentUser, colleges);
			if (matches.isEmpty()) {
				System.out.println("Currently, no colleges can be matched according to your info, please check for updates!");
			}
			else {
				System.out.println("List of your matched college(s) are: ");
				for (College m : matches) {
					System.out.println(m.getCollegeName());
				}
			}
		} else if (studentOption == 3) { 
			System.out.println("Enter the name of the college to be searched: ");
			String collegeName = keyboardIn.nextLine();
			collegeManager.searchCollege(collegeName);
		}
		
		else if (studentOption == 4) { 
			System.out.println("Are you sure you want to sign out? (Y/N) ");
			String confirmation = keyboardIn.nextLine();
			if(confirmation.equals("Y")) {
				System.out.println("You have been signed out");
				displayLoginMenu();
			}
			
			else if (confirmation.equals("N"))
				displayStudentMenu();
			
			else {
				System.out.println("please enter either Y/N");
				displayStudentMenu();
			}
		}
	}
	
	public void processCollegeMenu(int collegeOption) throws IOException {
		if(collegeOption == 1) {
			collegeManager.displayCollege(currentCollege);
		} else if (collegeOption == 2) { 
			System.out.println("Are you sure you want to sign out? (Y/N) ");
			String confirmation = keyboardIn.nextLine();
			if(confirmation.equals("Y")) {
				System.out.println("You have been signed out");
				displayLoginMenu();
			}
			
			else if (confirmation.equals("N"))
				displayCollegeMenu();
			
			else {
				System.out.println("please enter either Y/N");
				displayCollegeMenu();
			}
		}
	}
	//deletes new line at the end of string
	private double getDoubleInput() {
		double selected = keyboardIn.nextDouble();
		String notUsed = keyboardIn.nextLine();
		return selected;
	}
	private int getUserInput() {
		int selected = keyboardIn.nextInt();
		String notUsed = keyboardIn.nextLine();
		return selected;
	}
}
