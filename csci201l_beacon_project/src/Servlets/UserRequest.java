package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ClassStructure.*;

//validating user input
@WebServlet("/UserRequest")
public class UserRequest extends HttpServlet 
{
	DatabaseDriver db = new DatabaseDriver(); 

	// retrievs a user from the db after log in 
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Set response content type
		response.setContentType("text/html");

		int counter = 0;
		String error = "";
		String username = request.getParameter("username"); 
		String password = request.getParameter("password"); 

		// if either of the fields are left blank 
		if (username.contentEquals("")) {
			error += "Please enter username."; 
			counter++; 
		}
		if (password.contentEquals("")) {
			error += "Please enter password."; 
			counter++; 
		}
		 // checks to see if the user exists according to inputted parameters
		if (db.getUserId(username) != -1) {
			error += "User doesn't exist. Please create an account."; 
			counter++; 
		}

		if (counter > 0) {
			request.setAttribute("user_error_message", error); 
			request.getRequestDispatcher("/login.jsp").include(request, response); 
		}
		else {
			User user = db.getUser(username,password); 
			request.setAttribute("user", user); 
			request.getRequestDispatcher("/homepage.jsp").forward(request, response); 
		}
		
	}
	
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
			request.setAttribute("user_error_message", error); 
			request.getRequestDispatcher("/signup.jsp").include(request, response); 
		}
		else {
			User user = new User(username, password); 
			db.addUser(user);
			
			// for testing purposes, only sends the username, but will send the user object when working
			request.setAttribute("username", user.get_username());
			request.getRequestDispatcher("/homepage.jsp").include(request, response);
		}
		
	}
}


