package ClassStructure;

import java.time.LocalDate;

public class Comment {
	
	private String body; 
	private String userId; 
	private LocalDate timestamp; 
	
	public Comment(String bod, String id, LocalDate time)
	{
		body = bod; 
		userId = id; 
		timestamp = time; 
	}
	
	public String get_body()
	{
		return body; 
	}
	
	public String get_userId() 
	{
		return userId; 
	}
	
	public LocalDate get_time() 
	{
		return timestamp; 
	}

}
