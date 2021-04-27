package collegematch;

public class AdmissionsOfficer extends User {
	private int collegeID;
	private String password;
	
	public AdmissionsOfficer (String username, String password, int role, int collegeID) {
		super(username, role, password);
		this.password = password;
		this.collegeID = collegeID;//college admission officer is associated with
	}
	
	public int getCollegeID() {
		return collegeID;
	}

	public String getPassword() {
		return password;
	}
	
}
