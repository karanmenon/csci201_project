package ClassStructure; 

public class User {
	
	private String username; 
	private String password; 
	
	public User(String user, String pass) 
	{
		username = user; 
		password = pass; 
	}
	
	public String get_username() {
		return username; 
	}
	
	public String get_password() {
		return password;
	}
	

}
