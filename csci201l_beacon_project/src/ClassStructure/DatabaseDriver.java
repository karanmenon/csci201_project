package ClassStructure; 

public class DatabaseDriver {
	
	String serverConnection;
	String user = "root";
	String pwd = "root";
	
	public DatabaseDriver() {
		serverConnection = "jdbc:mysql://localhost/beacon_db";
		user = "root";
		pwd = "root";
	}
	
	public User getUser(String username, String password) {
		
	}
	
	public boolean isValidUser(Integer userID) {
		
	}
	
	public BeaconSignal getSubBeacon(Integer disasterID) {
		return null; 
	}
	
	public BeaconSignal getBeaconSignal(Integer postID) {
		return null; 
	}
	
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
			
			SubBeacon beacon = beaconSignal.get_subBeacon();
			String sql1 = "SELECT disasterID FROM Disasters WHERE disasterName = '" + beacon.get_disaster() + "'";
			PreparedStatement ps = connection.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();
			Integer disasterID;
			while(rs.next()) {
				disasterID = rs.getInt("disasterID"); // not sure if this is going to work
			}

			Integer postScore = 0;
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
			BeaconSignal post = comment.get_post();
			String sql1 = "SELECT postID FROM Posts WHERE postTitle = '" + post.get_postTitle() + "'";
			PreparedStatement ps = connection.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();
			Integer post_id;
			while(rs.next()) {
				post_id = rs.getInt("postID"); // not sure if this is going to work
			}
			
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
			
			String sql = "INSERT INTO Users (username, password, email, userPoints) VALUES ('" 
						+ usr.get_username() + "', '" + usr.get_password() + "', '" + usr.get_email() + "', " + "0)";
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		}
		catch(SQLIntegrityConstraintViolationException e) {
			// username or email has already been taken
			if(e.getMessage().contains("Duplicate entry")) {
				if(e.getMessage().contains("for key 'username'")) {
					System.out.println("That username is already taken. Please try again with a "
							+ "different username.");
				}
				else if(e.getMessage().contains("for key 'email'")) {
					System.out.println("That email has already been registered with another account. "
							+ "Please try again with a different email.");		
				}
			}
		}
		catch(SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		}
		
	}	

}
