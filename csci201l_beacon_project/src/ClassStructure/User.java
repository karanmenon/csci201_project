package ClassStructure; 

public class User {
	
	private String username; 
	private String password; 
	private String email; 
	
	public User(String user, String pass, String email) 
	{
		username = user; 
		password = pass; 
		this.email = email; 
	}
	
	public String get_username() {
		return username; 
	}
	
	public String get_password() {
		return password;
	}
	
	public String get_email() {
		return email; 
	}
	
	

}
