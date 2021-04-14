package collegematch;

public class User {

	private String username;
	private int role; //stored as 1 for student and 2 for admissions officer in userInfo.csv   
	
	public User(String username, int role) {
		this.username = username;
		this.role = role;
	}
	
	public String getUsername() {
		return username;
	}
	
	public int getRole() {
		return role;
	}
	
}
