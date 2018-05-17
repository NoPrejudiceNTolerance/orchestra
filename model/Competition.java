package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Competition extends Event {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Competitor> competitors;
	
	
	
	
	protected Competition(String name, Calendar cal, String details) {
		super(name, cal, details);
	}
	
	static public void addEvent(String name, Calendar cal, String details) {
		new Competition(name, cal, details);
	}
	
	static public boolean modifyEvent(String name, String newName, Calendar cal, String details) {
		Event e = Event.searchEvent(name);
		if(e != null && e.getClass() == Competition.class) {
			e.setName(newName);
			e.setD(cal);
			e.setDetails(details);
			return true;
		}
		return false;
	}
	
	
	public ArrayList<Competitor> getCompetitors() {
		return competitors;
	}
	public void setCompetitors(ArrayList<Competitor> competitors) {
		this.competitors = competitors;
	}
	
}