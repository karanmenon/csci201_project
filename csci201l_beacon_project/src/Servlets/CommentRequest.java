package Servlets;

import javax.servlet.http.HttpServlet;

import ClassStructure.*;

import java.io.*;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class CommentRequest extends HttpServlet {
	
	DatabaseDriver db = new DatabaseDriver(); 
	
	// adds a comment to the database
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String comment = request.getParameter("comment_text");
		BeaconSignal bs = (BeaconSignal) request.getAttribute("beaconSignal");
		String username = (String) request.getAttribute("username"); 
		
		Comment newCom = new Comment(comment, username, LocalDateTime.now(), bs); 
		db.addComment(newCom);
				
		// call the beaconSignal again that now contains the added comment 
		BeaconSignal newBeacon = db.getBeaconSignal(bs.get_postId()); 
		
		// IMPLEMENT WHEN WE KNOW FRONT END WANTS 
		
		RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/post_page.jsp");
		reqDispatcher.forward(request, response);
		
	}

}