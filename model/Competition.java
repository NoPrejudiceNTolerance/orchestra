package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Competition extends Event {
	private ArrayList<Competitor> competitors;
	
	
	public ArrayList<Competitor> getCompetitors() {
		return competitors;
	}
	public void setCompetitors(ArrayList<Competitor> competitors) {
		this.competitors = competitors;
	}

	public Competition(String name, Calendar cal, String details) {
		super(name, cal, details);
	}
	
	
}