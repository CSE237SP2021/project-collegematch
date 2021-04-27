package collegematch;

public class AdmissionsOfficer extends User {
	private int collegeID;
	
	public AdmissionsOfficer (String username, String password, int role, int collegeID) {
		super(username, role);
		this.collegeID = collegeID; //college admission officer is associated with
	}
	
	public int getCollegeID() {
		return collegeID;
	}
	
}
