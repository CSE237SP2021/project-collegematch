package collegematch;

import java.util.ArrayList;

public class Student extends User {
	private int satScore;
	private double gpa;
	private int tuitionPreference; //maximum tuition willing to pay
	private int sizePreference; //maximum size preferred
	private ArrayList<College> savedColleges;
	
	public Student(String username, int role, int satScore, double gpa, int tuitionPreference, int sizePreference) {
		super(username, role);
		this.satScore = satScore;
		this.gpa = gpa;
		this.tuitionPreference = tuitionPreference;
		this.sizePreference = sizePreference;
		this.savedColleges = new ArrayList<College>(); 
	}
	
	public void saveNewCollege(College collegeToBeAdded) {
		savedColleges.add(collegeToBeAdded);
	}
	
	public void deleteSavedCollege(College collegeToBeRemoved) {
		for (int i=0; i < savedColleges.size(); i++) {
			if (savedColleges.get(i).getCollegeID() == collegeToBeRemoved.getCollegeID()) {
				savedColleges.remove(i);
			}
		}
	}

	//check user properties against college properties for a match
	public ArrayList<College> getCollegeMatches(ArrayList<College> collegesToBeChecked) {
		ArrayList<College> matchedColleges = new ArrayList<College>();
		for (College collegeToBeChecked : collegesToBeChecked) {
			if (satScore >= collegeToBeChecked.getSatScore() 
					&& gpa >= collegeToBeChecked.getGpa() 
					&& tuitionPreference >= collegeToBeChecked.getTuition()
					&& sizePreference >= collegeToBeChecked.getSize()) {
				matchedColleges.add(collegeToBeChecked);
			}
		}
		return matchedColleges;
	}
	
	public int getSatScore() {
		return satScore;
	}
	
	public double getGpa() {
		return gpa;
	}
	
	public ArrayList<College> getSavedColleges() {
		return savedColleges;	
	}
	
	public int getSavedCollegesSize() {
		return savedColleges.size();	
	}
	
	//creates String that contains all colleges in saved college list referred to by their IDs separated by hyphens 
	//String will be added to userInfo.csv 
	public String getSavedCollegesStringList() {
		String returnString = "";
		for (College college: savedColleges) {
			//limitation: adds unnecessary hyphen to end of last college ID
			returnString = returnString + college.getCollegeID() + "-";
		}
		return returnString;
		
	}
	
	//parses String of saved colleges from file and adds them to savedCollege ArrayList 
	public void setSavedColleges(String savedCollegeStringList) {
		//removes hyphen from the end of saved college String in file 
		String formatCollegeStringList = savedCollegeStringList.substring(0, savedCollegeStringList.length() - 1);
		String[] collegeIDs = formatCollegeStringList.split("-");
		ArrayList<College> collegesToBeSaved = new ArrayList<College>();
		for (String collegeID : collegeIDs) {
			CollegeManager collegeManager = new CollegeManager();
			collegesToBeSaved.add(collegeManager.findCollege(Integer.parseInt(collegeID)));
		}
		savedColleges = collegesToBeSaved;
	}
}
