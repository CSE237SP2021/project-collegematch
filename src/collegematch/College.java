package collegematch;

public class College {
	private int collegeID;
	private String collegeName;
	private int size;
	private String location;
	private int satScore;
	private double gpa;
	private String collegeName2; //College Nickname
	private int tuition;
	private int numberOfSaves;

	
	public College(int collegeID, String collegeName, int size, String location, int satScore, double gpa, String collegeName2, int tuition, int numberOfSaves) {
		this.collegeID = collegeID;
		this.collegeName = collegeName;
		this.size = size;
		this.location = location;
		this.satScore = satScore;
		this.gpa = gpa;
		this.collegeName2 = collegeName2;
		this.tuition = tuition;
		this.numberOfSaves = numberOfSaves;
	}
	
	public void displayCollegeInformation() {
		System.out.println("College: "+ collegeName);
		System.out.println("Size: "+ size);
		System.out.println("Location: "+location);
		System.out.println("SAT: "+satScore);
		System.out.println("Nick Name: " + collegeName2);
		System.out.println("GPA: "+ gpa);
		System.out.println("Tuition: $"+tuition);
		System.out.println("Number of students, who saved you: "+numberOfSaves);
	}
	
	public int getCollegeID() {
		return collegeID;
	}
	
	public String getCollegeName() {
		return collegeName;
	}

	public int getSize() {
		return size;
	}

	public String getLocation() {
		return location;
	}

	public int getSatScore() {
		return satScore;
	}

	public double getGpa() {
		return gpa;
	}

	public String getCollegeName2() {
		return collegeName2;
	}

	public int getTuition() {
		return tuition;
	}
	
	public int getNumbeOfSaves() {
		return numberOfSaves;
	}
	
	public void increamentSaves() {
		this.numberOfSaves = this.numberOfSaves + 1;
	}
	public void decrementSaves() {
		this.numberOfSaves = this.numberOfSaves - 1;
	}
}