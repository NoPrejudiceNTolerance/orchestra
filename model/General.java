package model;

import java.util.ArrayList;
import java.util.Calendar;

public class General extends Event {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Musician conductor;
	private ArrayList<Musician> musicians;
	
	
	public General(String name, Calendar cal, String details, Musician conductor) {
		super(name, cal, details);
		this.conductor = conductor;
	}
	
	static public void addEvent(String name, Calendar cal, String details, Musician conductor) {
		new General(name, cal, details, conductor);
	}
	
	
	public ArrayList<Musician> getMusicians() {
		return musicians;
	}
	public void setMusicians(ArrayList<Musician> musicians) {
		this.musicians = musicians;
	}
	
	public Musician getConductor() {
		return conductor;
	}
	public void setConductor(Musician conductor) {
		this.conductor = conductor;
	}
	
}