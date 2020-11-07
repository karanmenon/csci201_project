package ClassStructure; 

public class User {
	
	private Integer id; 
	private String username; 
	private String password; 
	private String name; 
	
	public User(Integer id, String user, String pass, String name) 
	{
		this.id = id; 
		username = user; 
		password = pass; 
		this.name = name; 
	}
	
	public Integer get_id() { 
		return id; 
	}
	
	public String get_username() {
		return username; 
	}
	
	public String get_name() {
		return name; 
	}
	


}
