package ClassStructure;

import java.time.LocalDate;

public class Comment {
	
	private String body; 
	private User userId; 
	private LocalDate timestamp; 
	
	public Comment(String bod, User id, LocalDate time)
	{
		body = bod; 
		userId = id; 
		timestamp = time; 
	}
	
	public String get_body()
	{
		return body; 
	}
	
	public User get_userId() 
	{
		return userId; 
	}
	
	public LocalDate get_time() 
	{
		return timestamp; 
	}

}
