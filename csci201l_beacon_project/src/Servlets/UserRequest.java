package Servlets;
import javax.servlet.http.HttpServlet;

//validating user input
@WebServlet("/UserRequest")
public class UserRequest extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		DatabaseDriver db = new DatabaseDriver(); 

		// Set response content type
		response.setContentType("text/html");
		
		int counter = 0; 
		String username = request.getParamter("user_id"); 
		String password = request.getParamter("password"); 
		
		String error = ""; 
		
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
		if (db.getUser(username, password) == null ) {
			error += "User doesn't exist. Please create an account."; 
			counter++; 
		}
		
		if (counter > 0) {
			request.setAttribute("user_error_message", error); 
			request.getRequestDispatcher("/userLoginPage.jsp").include(request, response); 
		}
		else {
			User user = db.getUser(username, password); 
			request.setAttribute("user", user); 
			request.getRequestDispatcher("/homepage.jsp").forward(request, response); 
		}
	

	}
}
