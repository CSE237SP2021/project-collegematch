package collegematch;

public class User {

	private String username;
	private String password;
	private int role; //1 for student and 2 for admissions officer in userInfo.csv   
	
	public User(String username, int role) {
		this.username = username;
		this.role = role;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getRole() {
		return role;
	}
	
}
