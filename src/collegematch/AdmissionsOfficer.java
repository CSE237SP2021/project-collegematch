package collegematch;

public class AdmissionsOfficer extends User{
	private int collegeID;
	
	public AdmissionsOfficer (String username, int role, int collegeID) {
		super(username, role);
		this.collegeID = collegeID;
	}
	
	public int getCollegeID() {
		return collegeID;
	}
	
}
