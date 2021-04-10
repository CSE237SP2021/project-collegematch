package collegematch;

public class College {
	
	private String collegeName;
	private int size;
	private String location;
	private int satScore;
	private double gpa;
	private String collegeName2;
	private int tuition;

	
	public College(String collegeName, int size, String location, int satScore, double gpa, String collegeName2, int tuition) {
		this.collegeName = collegeName;
		this.size=size;
		this.location = location;
		this.satScore = satScore;
		this.gpa = gpa;
		this.collegeName2 = collegeName2;
		this.tuition = tuition;
	}
	
	
	public void displayCollegeInformation() {
		System.out.println("College: "+ collegeName);
		System.out.println("Size: "+location);
		System.out.println("Location: "+location);
		System.out.println("SAT: "+satScore);
		System.out.println("Nick Name: " + collegeName2);
		System.out.println("GPA: "+gpa);
		System.out.println("Tuition: "+tuition);
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


}