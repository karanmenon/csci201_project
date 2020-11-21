package ClassStructure;
import java.io.*;
import java.net.*;
import java.awt.*;

public class RefreshComments implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			URL beaconSignalServlet = new URL("http://localhost:8080/csci201l_beacon_project/BeaconSignalRequest");
			BufferedReader in = new BufferedReader(new InputStreamReader(beaconSignalServlet.openStream()));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
