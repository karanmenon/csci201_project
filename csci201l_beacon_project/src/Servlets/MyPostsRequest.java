package Servlets;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ClassStructure.*;

/**
 * Servlet implementation class UserPostsRequest
 */
@WebServlet("/MyPostsRequest")
public class MyPostsRequest extends HttpServlet {
	
	DatabaseDriver db = new DatabaseDriver(); 
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String username = request.getParameter("username"); 
		ArrayList<BeaconSignal> beaconSignals = db.getMyBeaconSignals(username);
				
		// sends array list of beacon signals to front end
		request.setAttribute("myBeaconSignals", beaconSignals);
		
		RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/user_posts.jsp");
		reqDispatcher.forward(request, response);
	}
}