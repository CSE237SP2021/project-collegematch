package collegematch;

import java.util.ArrayList;

public class User {

	private String username;
	private int satScore;
	private double gpa;
	private String campusPreference;
	private ArrayList<College> savedColleges;
	
	public User(String username, int satScore, double gpa, String campusPreference) {
		this.username = username;
		this.satScore = satScore;
		this.gpa = gpa;
		this.campusPreference = campusPreference;
		this.savedColleges = new ArrayList<College>(); 
	}
	
	
	public void displaySavedColleges() {
		if (savedColleges.size() == 0) {
			System.out.println("You have no saved colleges");
		} else {
			for(int i = 0; i < savedColleges.size(); i++) {
				System.out.println(i + 1 + ": " + savedColleges.get(i).getName());
			}
		}		
	}
	
	public void saveNewCollege(College collegeToBeAdded) {
		savedColleges.add(collegeToBeAdded);
	}
	
	public void deleteSavedCollege(College collegeToBeRemoved) {
		savedColleges.remove(collegeToBeRemoved);
	}

	//check user properties against college properties for a match
	public ArrayList<College> getCollegeMatches(ArrayList<College> collegesToBeChecked) {
		ArrayList<College> matchedColleges = new ArrayList<College>();
		for (College collegeToBeChecked : collegesToBeChecked) {
			if (satScore >= collegeToBeChecked.getSatScoreMin() 
					&& gpa >= collegeToBeChecked.getGpaMin() 
					&& campusPreference.equals(collegeToBeChecked.getCampusType())) {
				matchedColleges.add(collegeToBeChecked);
			}
		}
		return matchedColleges;
	}
	
	public String getUsername() {
		return username;
	}
	public int getSatScore() {
		return satScore;
	}
	public double getGpa() {
		return gpa;
	}
	public String getCampusPreference() {
		return campusPreference;
	}
}
