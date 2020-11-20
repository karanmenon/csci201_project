package ClassStructure;
import java.time.LocalDateTime;

public class Comment {
	
	private String body; 
	private String userName; 
	private LocalDateTime timestamp; 
	private BeaconSignal post;
	
	public Comment(String bod, String username, LocalDateTime time, BeaconSignal bpost)
	{
		body = bod; 
		userName = username; 
		timestamp = time; 
		post = bpost;
	}
	
	public BeaconSignal get_post() {
		return post;
	}
	
	public String get_body()
	{
		return body; 
	}
	
	public String get_author() 
	{
		return userName; 
	}
	
	public LocalDateTime get_time() 
	{
		return timestamp; 
	}

}