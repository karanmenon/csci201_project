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

import ClassStructure.*;


@WebServlet("/SubBeaconRequest")
public class SubBeaconRequest extends HttpServlet{
	
	DatabaseDriver db = new DatabaseDriver(); 
	
	// retireve a subBeacon from the database
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("test/html"); 

		String name = request.getParameter("name"); 
		String category = request.getParameter("categories"); 
		
		SubBeacon sb = db.getSubBeacon(name); 
		
		// THIS WILL BE CHANGED DEPENDING ON WHAT FROND END
		// should we be sending the whole subBeacon object, or smaller objects within subBeacon
		request.setAttribute("subBeacon", sb);
		request.getRequestDispatcher("/disaster_thread.jsp").forward(request, response); 
		
	}
	
	// adds a subbeacon to the database
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				
		response.setContentType("test/html"); 
		
		RequestDispatcher reqDispatcher;
		
		// checking to see if user is a guest. if not, redirect to login 
		if (request.getCookies().length == 0) {
			reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/login.jsp");
		}
		else {
			// parameters should match the name="" in input tags
			String threadTitle = request.getParameter("title");
			String category = request.getParameter("categories");
			ArrayList<BeaconSignal> beaconSignals = new ArrayList<BeaconSignal>(); 
			
			SubBeacon sb = new SubBeacon(beaconSignals, threadTitle, category); 
			
			db.addSubBeacon(sb);
			
			// these will be changed depending on what frond end needs 
			request.setAttribute("servlet_title", threadTitle);
			request.setAttribute("servlet_categories", category);
			
			Cookie[] cookies = request.getCookies(); 
			String username = cookies[0].getValue(); 
			request.setAttribute("username", username); 
					
			reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/homepage.jsp");
		}
		reqDispatcher.forward(request, response);
		
	}
}
