package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Competition extends Event {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Competitor> competitors;
	
	
	
	
	public Competition(String name, Calendar cal, String details) {
		super(name, cal, details);
	}
	
	static public void addEvent(String name, Calendar cal, String details) {
		new Competition(name, cal, details);
	}
	
	
	public ArrayList<Competitor> getCompetitors() {
		return competitors;
	}
	public void setCompetitors(ArrayList<Competitor> competitors) {
		this.competitors = competitors;
	}
	
}