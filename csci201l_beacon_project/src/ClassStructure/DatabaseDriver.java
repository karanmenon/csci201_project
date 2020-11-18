package ClassStructure; 

public class DatabaseDriver {
	
	String serverConnection;
	String user = "root";
	String pwd = "erin";
	
	public DatabaseDriver() {
		serverConnection = "jdbc:mysql://localhost/beacon_db";
		user = "root";
		pwd = "erin";
	}
	
	public User getUser(String username, String password) {
		
	}
	
	public boolean isValidUser(Integer userID) {
		
	}
	
	public Integer get_UserID(User user) {
		
	}
	
	public BeaconSignal getSubBeacon(Integer disasterID) {
		return null; 
	}
	
	public BeaconSignal getBeaconSignal(Integer postID) {
		return null; 
	}
	
	void addSubBeacon(SubBeacon subBeacon) {
		
	}
	
	void addBeaconSignal(BeaconSignal beaconSignal) {
		
	}
	
	void addComment(Comment comment) {
		
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
