package collegematch;

import java.util.ArrayList;

public class College {

	private String name;
	private int satScoreMin;
	private double gpaMin;
	private String campusType;
	
	public College(String name, int satScoreMin, double gpaMin, String campusType) {
		this.name = name;
		this.satScoreMin = satScoreMin;
		this.gpaMin = gpaMin;
		this.campusType = campusType;
	}
	
	public void displayCollegeInformation() {
		System.out.println("College Name: " + name);
		System.out.println("Minimum SAT Score: " + satScoreMin);
		System.out.println("Minimum GPA: " + gpaMin);
		System.out.println("Campus Type: " + campusType);

	}
	
	public String getName() {
		return name;
	}

	public int getSatScoreMin() {
		return satScoreMin;
	}

	public double getGpaMin() {
		return gpaMin;
	}

	public String getCampusType() {
		return campusType;
	}
	
}
