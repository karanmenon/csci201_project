package ClassStructure;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class BeaconSignal {
	
	private Integer userId; 
	private SubBeacon subBeacon; 
	private String postTitle; 
	private String postBody; 
	private LocalDateTime timestamp;
	private ArrayList<Comment> comments; 
	
	public BeaconSignal(Integer id, SubBeacon beacon, String title, String body, 
			LocalDateTime time, ArrayList<Comment> comms) 
	{
		userId = id; 
		subBeacon = beacon; 
		postTitle = title; 
		postBody = body; 
		timestamp = time; 
		comments = comms; 	
	}
	
	public Integer get_userId() {
		return userId; 
	}
	
	public SubBeacon get_subBeacon() {
		return subBeacon; 
	}
	
	public String get_postTitle() {
		return postTitle; 
	}
	
	public String get_postBody() {
		return postBody; 
	}
	
	public LocalDateTime get_timestamp() {
		return timestamp; 
	}
	
	public ArrayList<Comment> get_comments() {
		return comments; 
	}

}
