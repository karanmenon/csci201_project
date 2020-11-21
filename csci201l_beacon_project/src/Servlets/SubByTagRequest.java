package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ClassStructure.*;

/**
 * Servlet implementation class SubByTagRequest
 */
@WebServlet("/SubByTagRequest")
public class SubByTagRequest extends HttpServlet {
       
	DatabaseDriver db = new DatabaseDriver(); 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String tag = request.getParameter("categories"); 
		ArrayList<SubBeacon> SubBeacons; 
		
		// tag wasn't specified, so sends back to homepage 
		if (tag.contentEquals("")) {
			SubBeacons = db.getSubBeacons(); 
		}
		else {
			SubBeacons = db.getSubBeaconbyTag(tag); 			
		}
		
		request.setAttribute("SubBeacons", SubBeacons);

		
		RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/homepage.jsp");
		reqDispatcher.forward(request, response);
	}

}
