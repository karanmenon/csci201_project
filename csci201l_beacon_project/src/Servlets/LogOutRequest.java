package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogOutRequest
 */
@WebServlet("/LogOutRequest")
public class LogOutRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies  = request.getCookies();
		for (Cookie aCookie : cookies) {
			if((aCookie.getName( )).equals("username")  )
			{
				aCookie.setMaxAge(0);
				response.addCookie(aCookie);
				System.out.print("Deleting Username = " + aCookie.getName( ) + ", Value = " + aCookie.getValue( )  + "<br/>");
			}
		}
		
		// after user logs out, redirected to the home page -- cookie has been removed 
		response.sendRedirect(request.getContextPath() + "/homepage.jsp");
		
	}


}
