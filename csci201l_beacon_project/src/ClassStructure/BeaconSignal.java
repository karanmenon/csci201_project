package ClassStructure;

import java.time.LocalDateTime;
import java.util.*;

public class BeaconSignal {
	
	private Integer postID; 
	private Integer userId; 
	private SubBeacon subBeacon; 
	private String postTitle; 
	private String postBody; 
	private LocalDateTime timestamp;
	private ArrayList<Comment> comments; 
	
	public BeaconSignal(Integer p_id, Integer u_id, SubBeacon beacon, String title, String body, 
			LocalDateTime time, ArrayList<Comment> comms) 
	{
		postID = p_id;
		userId = u_id; 
		subBeacon = beacon; 
		postTitle = title; 
		postBody = body; 
		timestamp = time; 
		comments = comms; 	
	}
	
	public Integer get_postId() {
		return postID; 
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

	public void setComments(ArrayList<Comment> c)
	{
		comments=c;
	}
	
	public void set_postId(Integer id) {
		postID = id; 
	}

}
