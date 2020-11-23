package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.*; 
import ClassStructure.*;

//validating user input
@WebServlet("/SignUpRequest")
public class SignUpRequest extends HttpServlet 
{
	DatabaseDriver db = new DatabaseDriver(); 
	
	// adds a user to the db after sign up 
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String username = request.getParameter("username"); 
		String password = request.getParameter("password"); 
		
		String error = ""; 
		int counter = 0; 
		
		if (username.contentEquals("")) {
			error += "Please enter username."; 
			counter++; 
		}
		if (password.contentEquals("")) {
			error += "Please enter password."; 
			counter++; 
		}
		// user already exists, need to create a new 
		if (db.getUserId(username) != -1) {
			error += "User already exists, please login to already existing account or create a new account"; 
			counter++; 
		}
		if (counter > 0) {
			request.setAttribute("signUpError", error); 
			request.getRequestDispatcher("/signup.jsp").include(request, response); 
		}
		else {
			User user = new User(username, password); 
			db.addUser(user);
			
			Cookie userCookie = new Cookie("username", user.get_username());
			response.addCookie(userCookie);
			
			ArrayList<SubBeacon> subBeacons = db.getSubBeacons(); 
			if (subBeacons == null) {
				subBeacons = new ArrayList<SubBeacon>(); 
			}
			request.setAttribute("SubBeacons", subBeacons);
			
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/redirect_home.jsp");
			reqDispatcher.forward(request, response);
		}
		
	}
}


