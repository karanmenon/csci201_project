package ClassStructure; 

import java.sql.*;

public class DatabaseDriver {
	
	String serverConnection;
	String user = "root";
	String pwd = "root";
	
	public DatabaseDriver() {
		serverConnection = "jdbc:mysql://localhost/beacon_db";
		user = "root";
		pwd = "root";
	}
	
	// GET functions
	
	public User getUser(String username, String password) {
		try(Connection connection = DriverManager.getConnection(db, user, pwd)){
		}
		catch(SQLIntegrityConstraintViolationException e) {
		}
		catch(SQLException e)
		{

		}

	}
	
	public boolean isValidUser(String username, String password) {
		try(Connection connection = DriverManager.getConnection(db, user, pwd)){
		}
		catch(SQLIntegrityConstraintViolationException e) {
		}
		catch(SQLException e)
		{
			
		}
	}
	
	public BeaconSignal getSubBeacon(Integer disasterID) {
		try(Connection connection = DriverManager.getConnection(db, user, pwd)){
		}
		catch(SQLIntegrityConstraintViolationException e) {
		}
		catch(SQLException e)
		{
			
		}
	}
	
	public BeaconSignal getBeaconSignal(Integer postID) {
		try(Connection connection = DriverManager.getConnection(db, user, pwd)){
		}
		catch(SQLIntegrityConstraintViolationException e) {
		}
		catch(SQLException e)
		{
			
		}
	}
	
	// ADD functions - timeStamps should be created for each object like this: LocalDateTime time = LocalDateTime.now();
	
	void addSubBeacon(SubBeacon subBeacon) { // new forum, like "Hurricane Sandy"
		try(Connection connection = DriverManager.getConnection(db, user, pwd)){
			
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
	
	void addBeaconSignal(BeaconSignal beaconSignal) { // new post, like "Yo, I need a place to stay with my family tonight"
		try(Connection connection = DriverManager.getConnection(db, user, pwd)){
			
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
			String sql2 = "INSERT INTO Posts (disasterID, userID, postScore, timeStamps, postContent) VALUES ('" 
					+ disasterID + "', '" + beaconSignal.get_userId() + "', '" + postScore + "', '" + beaconSignal.get_timestamp() + "', '" + beaconSignal.get_postBody() + "')";
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql2);
			
		}
		catch(SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
		
	}
	
	void addComment(Comment comment) {
		
		try(Connection connection = DriverManager.getConnection(db, user, pwd)){
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
					+ comment.get_userId() + ", " + post_id + ", '" + comment.get_body() + "', '" + comment.get_time() + "')";
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql2);
			
		}
		catch(SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
		
	}
	
	void addUser(User usr) {
		
		try(Connection connection = DriverManager.getConnection(db, user, pwd)){
			
			String sql = "INSERT INTO Users (username, password, userPoints) VALUES ('" 
						+ usr.get_username() + "', '" + usr.get_password() + "0)";
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
