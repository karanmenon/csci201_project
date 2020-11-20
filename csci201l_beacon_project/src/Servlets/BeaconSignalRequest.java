package Servlets;
import javax.servlet.http.*;
import ClassStructure.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
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

		String title = request.getParameter("title"); 
		String postBody = request.getParameter("text_box"); 
		RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/disaster_thread.jsp");
		reqDispatcher.forward(request, response);
	}
	
	// creates a new BeaconSignal to add to database
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("test/html"); 

		
		// creates a new BeaconSignal object and adds to db 
		String title = request.getParameter("title");
		String postBody = request.getParameter("text_box"); 
		// when User function working, will display
		// User user = (User) request.getAttribute("user"); 
		User FakeUser = new User("testingName", "testingPass"); 
		String user = "Kiva"; // (String) request.getAttribute("user"); 
		SubBeacon subBeacon = (SubBeacon) request.getAttribute("subBeacon"); 
		LocalDate timeStamp = LocalDate.now();
		ArrayList<Comment> comments = new ArrayList<Comment>(); 
		BeaconSignal bSignal = new BeaconSignal(FakeUser, subBeacon, title, postBody, timeStamp, comments);
		db.addBeaconSignal(bSignal);
		
		// sets correct attributes to be displayed by front end
		request.setAttribute("postTitle", title);
		request.setAttribute("comments", "testing comment, this is a temp comment. ");
		request.setAttribute("postAuthor", user);
				
		RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/disaster_thread.jsp");
		reqDispatcher.forward(request, response);

	}

}