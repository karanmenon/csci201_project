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
		
		String title = (String) request.getAttribute("title"); 
		
		BeaconSignal bs = db.getBeaconSignal(title); 
		
		// sends beaconSignal object to front end -- contains arraylist of comments 
		request.setAttribute("BeaconSignal", bs);
		
		RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/post_page.jsp");
		reqDispatcher.forward(request, response);
	}
	
	// creates a new BeaconSignal to add to database
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("test/html"); 
		
		// creates a new BeaconSignal object and adds to db 
		String title = request.getParameter("modal_title");
		String postBody = request.getParameter("modal_info");
		
		// checking to see if user is a guest. if not, redirect to login 
		RequestDispatcher reqDispatcher;
		if (request.getCookies().length == 0) {
			reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/login.jsp");
		}
		
		else {
			String username = request.getParameter("user_name");
			Integer userID = db.getUserId(username); 
			
			// change this if we have the SubBeacon object already 
			String subBeaconTitle = request.getParameter("disaster_title"); 
			SubBeacon sb = db.getSubBeacon(subBeaconTitle);
			
			
			LocalDate timeStamp = LocalDate.now();
			ArrayList<Comment> comments = new ArrayList<Comment>(); 
			
			BeaconSignal bs = new BeaconSignal(null, userID, sb, title, postBody, LocalDateTime.now(), comments); 
			db.addBeaconSignal(bs);
			bs = db.getBeaconSignal(title);
			
			
			// sends the BeaconSignal object to front end -- contains the "new" beacon signal 
			request.setAttribute("BeaconSignal", bs);
			reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/post_page.jsp");
		}
		reqDispatcher.forward(request, response);
	}

}