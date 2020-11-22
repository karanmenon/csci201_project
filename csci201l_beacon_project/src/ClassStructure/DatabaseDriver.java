package ClassStructure;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DatabaseDriver {

	String serverConnection;
	String user = "root";
	String pwd = "root";
	
	public DatabaseDriver() {
		serverConnection = "jdbc:mysql://localhost/beacon_db";
		user = "root";
		pwd = "root";
	}
	
	//Karan's Code
	// gets the userID that corresponds with that specific user 
	public Integer getUserId(String username) {
		try(Connection connection = DriverManager.getConnection(serverConnection, user, pwd)){
			String sql="SELECT userID FROM Users WHERE username='"+username+"'";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return rs.getInt("userID");
			}
			else
			{
				System.out.println("No account with that username");
				return -1;
			}
		}
		catch(SQLException e)
		{
			System.out.println("SQLException: " + e.getMessage());
		}
		return 0; 
	}

	//finds username given userID (necessary as many tables use userID as a foreign key)
	public String getUsernameFromId(Integer userID)
	{
		try(Connection connection = DriverManager.getConnection(serverConnection, user, pwd)){
			String sql="SELECT username FROM Users WHERE userID='"+userID+"'";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return rs.getString("username");
			}
			else
			{
				System.out.println("No account with that username");
				return "";
			}
		}
		catch(SQLException e)
		{
			System.out.println("SQLException: " + e.getMessage());
		}
		return ""; 		
	}
	
	// GET functions
	public User getUser(String username, String password) {
			if (!(isValidUser(username, password)))
				return null;
			User u= new User(username, password);
			return u;


	}
	
	//helpful for login, verifies user exists then checks if password is correct

	public boolean isValidUser(String username, String password) {
		try(Connection connection = DriverManager.getConnection(serverConnection, user, pwd)){
			if(getUserId(username)==-1)
				return false;
			String sql="SELECT password FROM Users WHERE username='"+username+"'";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				if (rs.getString("password").equals(password))
					return true;
			}
			
		}
		catch(SQLException e)
		{
			System.out.println("SQLException: " + e.getMessage());		
		}
		return false;
	}
	
	// array list of comments should be sorted by timestamp -- so SORT BY when retrieving comments from db

	public SubBeacon getSubBeacon(String disasterTitle) {
		try(Connection connection = DriverManager.getConnection(serverConnection, user, pwd)){
			ArrayList<BeaconSignal> posts=new ArrayList<BeaconSignal>();
			String sql="SELECT * FROM Disasters WHERE disasterName='"+disasterTitle+"'";
			PreparedStatement ps = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = ps.executeQuery();
			SubBeacon s;
			if(rs.next()) //finds disaster info from title
			{
				s = new SubBeacon(posts, rs.getString("disasterName"), rs.getString("disasterType"));
				String sql1="SELECT * FROM Posts WHERE disasterID="+rs.getInt("disasterID") + (" ORDER BY timeStamps DESC");
				PreparedStatement ps1=connection.prepareStatement(sql1,ResultSet.TYPE_SCROLL_SENSITIVE, 
                        ResultSet.CONCUR_UPDATABLE);
				ResultSet rs1=ps1.executeQuery();


					
					while(rs1.next())
					{
						ArrayList<Comment> c= new ArrayList<Comment>();
						//creates beacon signal to add to arraylist
						BeaconSignal b= new BeaconSignal( (Integer) rs1.getInt("postID"), s, rs1.getString("postTitle"), rs1.getString("postContent"), (LocalDateTime) rs1.getObject("timeStamps"), c);
						
						//looks for comments for each beaconsignal
						String sql2="SELECT * FROM Comments WHERE postID="+rs1.getString("postID") + " ORDER BY timeStamps DESC";
						PreparedStatement ps2=connection.prepareStatement(sql2,ResultSet.TYPE_SCROLL_SENSITIVE, 
		                        ResultSet.CONCUR_UPDATABLE);
						ResultSet rs2=ps2.executeQuery();
	
						while(rs2.next())
						{
						Comment comm= new Comment(rs2.getString("commentContent"), getUsernameFromId(rs2.getInt("userID")), (LocalDateTime) rs2.getObject("timeStamps"), b);
						c.add(comm);

						//bod, username, time, bdpost
						}

						b.setComments(c); //updates comments arraylist

						posts.add(b);
						//SubBeacon beacon, String title, String body, LocalDateTime time, ArrayList<Comment> comms

					}
	

			}
			else
			{
				System.out.println("You might be a soothsayer, but currently this disaster doesn't exist!");
				return null;
			}
			s.setBeaconSignals(posts);
			return s;
			//SubBeacon(ArrayList<BeaconSignal> bSignals, String dis, String t) //dis=disaster name, t=tags
		}
		catch(SQLException e)
		{
			System.out.println("SQLException: " + e.getMessage());		
		}
		return null; 
	}
	
	public BeaconSignal getBeaconSignal(Integer postID) {
		try(Connection connection = DriverManager.getConnection(serverConnection, user, pwd)){
			String sql1="SELECT * FROM Posts WHERE postID="+postID;
			PreparedStatement ps1=connection.prepareStatement(sql1);
			ResultSet rs1=ps1.executeQuery();


			if(rs1.next())
			{
				
				// get the disasterID and disasterTitle for the Forum (SubBeacon) where the post is being made
				Integer disasterID = rs1.getInt("disasterID");
				String sqll = "SELECT disasterName FROM Disasters WHERE disasterID=" + disasterID + "";
				PreparedStatement pss = connection.prepareStatement(sqll);
				ResultSet rss = pss.executeQuery();
				rss.next();
				String disasterTitle = rss.getString("disasterName");
				
				SubBeacon forum = getSubBeacon(disasterTitle);
				ArrayList<Comment> c= new ArrayList<Comment>();
				
				Timestamp ts = (Timestamp) rs1.getObject("timeStamps");
				BeaconSignal b= new BeaconSignal( (Integer) rs1.getInt("postID"), forum, rs1.getString("postTitle"), rs1.getString("postContent"), ts.toLocalDateTime(), c);
				
				String sql2="SELECT * FROM Comments WHERE postID="+postID + " ORDER BY timeStamps DESC";
				PreparedStatement ps2=connection.prepareStatement(sql2);
				ResultSet rs2=ps2.executeQuery();

				while(rs2.next())
				{
					Comment comm= new Comment(rs2.getString("commentContent"), getUsernameFromId(rs2.getInt("userID")), (LocalDateTime) rs2.getObject("timeStamps"), b);
					c.add(comm);
	
						//bod, username, time, bdpost
				}
	
				b.setComments(c);
				return b;
			}
			else
			{
				System.out.println("Post not found! Doesn't mean you can't create one!");
				return null;
			}
		}
		catch(SQLException e)
		{
			System.out.println("SQLException: " + e.getMessage());		
		}
		return null; 
	}
	
	// TODO: returns an arrayList of all of the SubBeacons in DB
	public ArrayList<SubBeacon> getSubBeacons() {
		try(Connection connection = DriverManager.getConnection(serverConnection, user, pwd)){
			String sql="SELECT disasterName FROM Disasters";
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			ArrayList<SubBeacon> subList=new ArrayList<SubBeacon>();


			while(rs.next())
			{
				subList.add(getSubBeacon(rs.getString("disasterName")));
			}

			
			return subList;
		}
		catch(SQLException e)
		{
			System.out.println("SQLException: " + e.getMessage());
		}


		return null; 
	}
	
	// get all the subBeacons that are affiliated with said tag: ie. flood, hurricane 
	public ArrayList<SubBeacon> getSubBeaconbyTag(String tag) {
		try(Connection connection = DriverManager.getConnection(serverConnection, user, pwd)){
			String sql="SELECT disasterName FROM Disasters WHERE disasterType="+tag;
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();	

			ArrayList<SubBeacon> subList=new ArrayList<SubBeacon>();

			while(rs.next())
			{
				subList.add(getSubBeacon(rs.getString("disasterName")));
			}
			

			return subList;

		}
		catch(SQLException e)
		{
			System.out.println("SQLException: " + e.getMessage());
		}
		return null; 
	}
	
	// returns all posts(BeaconSignals) affiliated with that user
	public ArrayList<BeaconSignal> getMyBeaconSignals(String username) {
		try(Connection connection = DriverManager.getConnection(serverConnection, user, pwd)){
			
			ArrayList<BeaconSignal> signals=new ArrayList<BeaconSignal>();
			if(getUserId(username)==-1)
				return null;
			else
			{
				String sql="SELECT postID FROM Posts WHERE userID="+getUserId(username);
				PreparedStatement ps=connection.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{
					//System.out.println("No BeaconSignals found. It's not the WiFi!");
					signals.add(getBeaconSignal(rs.getInt("postID")));
				}


				return signals;
			}
		}
		catch(SQLException e)
		{
			System.out.println("SQLException: " + e.getMessage());
		}
		return null;
	}
	

	//Erin's code
		
	// ADD functions - timeStamps should be created for each object like this: LocalDateTime time = LocalDateTime.now();
	
	public void addSubBeacon(SubBeacon subBeacon) { // new forum, like "Hurricane Sandy"
		try(Connection connection = DriverManager.getConnection(serverConnection, user, pwd)){
			
			String sql = "INSERT INTO Disasters (disasterName, disasterType) VALUES ('" 
					+ subBeacon.get_disaster() + "', '" + subBeacon.get_tag() + "')";
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		}
		catch(SQLIntegrityConstraintViolationException e) {
			// disaster has already been created with that name
			if(e.getMessage().contains("Duplicate entry")) {
				if(e.getMessage().contains("for key 'disasterName'")) {
					System.out.println("That disaster name is already taken. Please try again with a "
							+ "different disaster name.");
				}
			}
		}
		catch(SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}
	
	public void addBeaconSignal(BeaconSignal beaconSignal) { // new post, like "Yo, I need a place to stay with my family tonight"
		try(Connection connection = DriverManager.getConnection(serverConnection, user, pwd)){
			
			// get the disasterID for the Forum (SubBeacon) where the post is being made
			SubBeacon beacon = beaconSignal.get_subBeacon();
			String sql1 = "SELECT disasterID FROM Disasters WHERE disasterName = '" + beacon.get_disaster() + "'";
			PreparedStatement ps = connection.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();
			Integer disasterID = -1;
			rs.next();
			disasterID = rs.getInt("disasterID"); 

			// initial post score
			Integer postScore = 0;
			
			// insert new post into Posts table
			String sql2 = "INSERT INTO Posts (disasterID, userID, postScore, timeStamps, postTitle, postContent) VALUES ('" 
					+ disasterID + "', '" + beaconSignal.get_userId() + "', '" + postScore + "', '" + beaconSignal.get_timestamp() + "', '" + beaconSignal.get_postTitle() + "', '" + beaconSignal.get_postBody() + "')";
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql2);
			
		}
		catch(SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
		
	}
	
	public void addComment(Comment comment) {
		
		try(Connection connection = DriverManager.getConnection(serverConnection, user, pwd)){
			// get the postID for the post where the comment is being placed
			BeaconSignal post = comment.get_post();
			String sql1 = "SELECT postID FROM Posts WHERE postTitle = '" + post.get_postTitle() + "'";
			PreparedStatement ps = connection.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();
			Integer post_id = -1;
			rs.next();
			post_id = rs.getInt("postID"); 
			
			// insert new comment into Comments table
			String sql2 = "INSERT INTO Comments (userID, postID, commentContent, timeStamps) VALUES (" 
					+ comment.get_author() + ", " + post_id + ", '" + comment.get_body() + "', '" + comment.get_time() + "')";
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql2);
			
		}
		catch(SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
	}
	
	public void addUser(User usr) {
		
		System.out.println("username: " + usr.get_username()); 
		System.out.println("pass: " + usr.get_password()); 
		
		try(Connection connection = DriverManager.getConnection(serverConnection, user, pwd)){
			
			String sql = "INSERT INTO Users (username, password, userPoints) VALUES ('" 
						+ usr.get_username() + "', '" + usr.get_password() + "', 0)";
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		}
		catch(SQLIntegrityConstraintViolationException e) {
			// username has already been taken
			if(e.getMessage().contains("Duplicate entry")) {
				if(e.getMessage().contains("for key 'username'")) {
					System.out.println("That username is already taken. Please try again with a "
							+ "different username.");
				}
			}
		}
		catch(SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
		
	}	

}