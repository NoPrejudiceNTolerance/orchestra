package model;

import java.util.ArrayList;
import java.util.Calendar;

public class General extends Event {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Musician conductor;
	private ArrayList<String> musicians;
	
	
	protected General(String name, Calendar cal, String details, Musician conductor) {
		super(name, cal, details);
		this.conductor = conductor;
	}
	
	static public void addEvent(String name, Calendar cal, String details, Musician conductor) {
		new General(name, cal, details, conductor);
	}
	
	static public boolean modifyEvent(String name, String newName, Calendar cal, String details, Musician conductor) {
		Event e = Event.searchEvent(name);
		if(e != null && e.getClass() == General.class) {
			e.setName(newName);
			e.setD(cal);
			e.setDetails(details);
			((General)e).setConductor(conductor);
			return true;
		}
		return false;
	}
	
	public boolean addMusician(String name) {
		if(!musicians.contains(name)) {
			this.musicians.add(name);
			return true;
		}
		return false;
	}
	
	public boolean deleteMusician(String name) {
		return musicians.remove(name);
	}
	
	
	
	
	public ArrayList<String> getMusicians() {
		return musicians;
	}
	public void setMusicians(ArrayList<String> musicians) {
		this.musicians = musicians;
	}
	
	public Musician getConductor() {
		return conductor;
	}
	public void setConductor(Musician conductor) {
		this.conductor = conductor;
	}
	
}