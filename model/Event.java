package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Event {
	static private ArrayList<Event> instances;
	
	private String name;
	private Calendar cal; //choose a type
	private String details;
	
	public Event(String name, Calendar cal, String details) {
		
		this.name = name;
		this.cal = cal;
		this.details = details;
		
		instances = new ArrayList<Event>();
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
	
	public Calendar getD() {
		return cal;
	}
	public void setD(Calendar cal) {
		this.cal = cal;
	}

	public static ArrayList<Event> getInstances() {
		return instances;
	}


	@Override
	public String toString() {
		return "Event [name=" + name + ", cal=" + cal.getTime() + ", details=" + details + "]";
	}	
	
}