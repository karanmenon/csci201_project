package Servlets;

import javax.servlet.http.HttpServlet;

import ClassStructure.*;

import java.io.*;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CommentRequest")
public class CommentRequest extends HttpServlet {
	
	DatabaseDriver db = new DatabaseDriver(); 
	
	// adds a comment to the database
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher reqDispatcher;
		
		// checking to see if user is a guest. if not, redirect to login 
		if (request.getCookies().length == 0) {
			reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/login.jsp");
			reqDispatcher.forward(request, response);
		}
		else {
			ExecutorService executor = Executors.newCachedThreadPool();
			RefreshComments r = new RefreshComments();
			executor.execute(r);
				
			String comment = request.getParameter("comment_text");
			System.out.println(comment);
			String beaconTitle = (String) request.getParameter("beaconSignal");
			BeaconSignal bs = db.getBeaconSignal(beaconTitle);
			String username = (String) request.getParameter("username"); 
			
			Comment newCom = new Comment(comment, username, LocalDateTime.now(), bs); 
			db.addComment(newCom);
					
			// call the beaconSignal again that now contains the added comment 
			BeaconSignal newBeacon = db.getBeaconSignal(bs.get_postTitle()); 
			
			// sends the beaconSignal object to front end -- contains arraylist of comments w the new comment added
			request.setAttribute("BeaconSignal", newBeacon);
						
			reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/post_page.jsp");
			reqDispatcher.forward(request, response);
			
			executor.shutdown();
			while (!executor.isTerminated()) {
				Thread.yield();
			}
		}
		
	}

}