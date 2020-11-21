package ClassStructure;

import java.util.ArrayList;

public class SubBeacon {
	
	private ArrayList<BeaconSignal> beaconSignals; 
	private String disaster; 
	private String tag; 
	
	public SubBeacon(ArrayList<BeaconSignal> bSignals, String dis, String t) 
	{
		beaconSignals = bSignals; 
		disaster = dis; 
		tag = t; 
	}
	
	public ArrayList<BeaconSignal> get_beaconSignals() {
		return beaconSignals; 
	}

	public void setBeaconSignals(ArrayList<BeaconSignal> a)
	{
		beaconSignals=a;
	}
	
	public String get_disaster() {
		return disaster; 
	}
	
	public String get_tag() {
		return tag; 
	}

}
