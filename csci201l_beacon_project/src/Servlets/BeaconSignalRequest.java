package Servlets;
import javax.servlet.http.*;
import ClassStructure.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet; 

@WebServlet("/BeaconSignalRequest")
public class BeaconSignalRequest extends HttpServlet {
	DatabaseDriver db = new DatabaseDriver();
	
	// retrieves info from a specific BeaconSignal
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("test/html"); 
		
		Integer postID = (Integer) request.getAttribute("postId"); 
		
		BeaconSignal bs = db.getBeaconSignal(postID); 
		
		// DEPENDING ON WHAT FRONT END NEEDS, FORWARD NECESSARY INFO 
		
		RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/post_page.jsp");
		reqDispatcher.forward(request, response);
	}
	
	// creates a new BeaconSignal to add to database
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("test/html"); 
		
		// creates a new BeaconSignal object and adds to db 
		String title = request.getParameter("title");
		String postBody = request.getParameter("text_box");
		
		// how will we ensure that we know the author of the post? 
		String username = request.getParameter("username"); 
		User usr = db.isValidUser(username); 
		Integer userID = db.getUserId(username); 
		
		// change this if we have the SubBeacon object already 
		String subBeaconTitle = request.getParameter("disaster_title"); 
		SubBeacon sb = db.getSubBeacon(subBeaconTitle);
		
		
		LocalDate timeStamp = LocalDate.now();
		ArrayList<Comment> comments = new ArrayList<Comment>(); 
		
		BeaconSignal beacon = new BeaconSignal(userID, sb, title, postBody, LocalDateTime.now(), comments); 
		db.addBeaconSignal(beacon);
				
		// TODO: sets correct attributes to be displayed by front end
				
		RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/post_page.jsp");
		reqDispatcher.forward(request, response);

	}

}