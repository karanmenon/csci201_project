package ClassStructure;

import java.time.LocalDate;
import java.util.ArrayList;

public class BeaconSignal {
	
	private User userId; 
	private SubBeacon subBeaconName; 
	private String postTitle; 
	private String postBody; 
	private LocalDate timestamp;
	private ArrayList<Comment> comments; 
	
	public BeaconSignal(User user, SubBeacon beacon, String title, String body, 
			LocalDate time, ArrayList<Comment> comms) 
	{
		userId = user; 
		subBeaconName = beacon; 
		postTitle = title; 
		postBody = body; 
		timestamp = time; 
		comments = comms; 	
	}
	
	public User get_userId() {
		return userId; 
	}
	
	public SubBeacon get_subBeaconName() {
		return subBeaconName; 
	}
	
	public String get_postTitle() {
		return postTitle; 
	}
	
	public String get_postBody() {
		return postBody; 
	}
	
	public LocalDate get_timestamp() {
		return timestamp; 
	}
	
	public ArrayList<Comment> get_comments() {
		return comments; 
	}

}
