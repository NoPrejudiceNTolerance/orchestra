package model;

import java.util.ArrayList;
import java.util.Date;

public class Event {
	static private ArrayList<Event> instances;
	
	private String name;
	private Date d; //choose a type
	private ArrayList<Musician> musicians;
	private String details;
	
	
	
	
	public Event(String name, Date d, String details) {
		super();
		this.name = name;
		this.d = d;
		this.details = details;
		
		instances.add(this);
	}
	
	
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
	
	public ArrayList<Musician> getMusicians() {
		return musicians;
	}
	public void setMusicians(ArrayList<Musician> musicians) {
		this.musicians = musicians;
	}

	public static ArrayList<Event> getInstances() {
		return instances;
	}	
	
}
