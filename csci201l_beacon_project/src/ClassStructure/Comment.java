import java.time.LocalDateTime;

public class Comment {
	
	private String body; 
	private Integer userId; 
	private LocalDateTime timestamp; 
	private BeaconSignal post;
	
	public Comment(String bod, Integer id, LocalDateTime time, BeaconSignal bpost)
	{
		body = bod; 
		userId = id; 
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
	
	public Integer get_userId() 
	{
		return userId; 
	}
	
	public LocalDateTime get_time() 
	{
		return timestamp; 
	}

}