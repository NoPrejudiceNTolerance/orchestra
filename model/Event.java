package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public abstract class Event implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static private ArrayList<Event> instances;
	
	private String name;
	private Calendar cal; //choose a type
	private String details;
	private ArrayList<Song> songs;
	
	protected Event(String name, Calendar cal, String details) {
		this.name = name;
		this.cal = cal;
		this.details = details;
		this.songs = new ArrayList<Song>();
		
		if(instances == null) instances = new ArrayList<Event>();
		
		instances.add(this);
	}
	
	static public Event searchEvent(String name) {
		for(Event instance : instances) {
			if(instance.name.toUpperCase().equals(name.toUpperCase())) return instance;
		}
		return null;
	}
	
	static public boolean deleteEvent(String name) {
		Event e = Event.searchEvent(name);
		if(e != null) {
			instances.remove(e);
			return true;
		}
		return false;
	}
	
	public boolean addSong(Song s) {
		if(!songs.contains(s)) {
			this.songs.add(s);
			return true;
		}
		return false;
	}
	
	public boolean deleteSong(Song s) {
		return songs.remove(s);
	}
	
	
	
	
	public ArrayList<Song> getSongs() {
		return songs;
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
	
	public static void setInstances(ArrayList<Event> events) {
		instances = events;
	}


	@Override
	public String toString() {
		return "Event [name=" + name + ", cal=" + cal.getTime() + ", details=" + details + "]";
	}	
	
}