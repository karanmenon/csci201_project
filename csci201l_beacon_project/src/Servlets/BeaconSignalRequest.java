package Servlets;
import javax.servlet.http.*;
import ClassStructure.*;
import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.*; 

public class BeaconSignalRequest extends HttpServlet {
	DatabaseDriver db; 
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		db = new DatabaseDriver();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException  {
		//ServletInputStream beaconSignal = req.getInputStream(); 
		BufferedReader in;
		try {
			in = req.getReader();
			db.getBeaconSignal(Integer.parseInt(in.readLine()));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 
		res.setContentType("text/xml");
		
	}
	
	public void destroy() {
		
	}

}
