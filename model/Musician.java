package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Musician extends Competitor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static private ArrayList<Musician> instances;
	
	private ArrayList<String> instruments;
	
	
	
	
	public Musician(String name) {
		super(name);
		this.instruments = new ArrayList<String>();
		
		if (instances == null) instances = new ArrayList<Musician>();
		instances.add(this);
	}
	
	static public Musician searchMusician(String name) {
		for(Musician instance : instances) {
			if(instance.getName().toUpperCase().equals(name.toUpperCase())) return instance;
		}
		return null;
	}
	
	static public boolean addMusician(String name) {
		if(Musician.searchMusician(name) == null) {
			new Musician(name);
			return true;
		}
		return false;
	}
	
	static public boolean deleteMusician(String name) {
		Musician m = Musician.searchMusician(name);
		if(m != null) {
			Musician.instances.remove(m);
			return true;
		}
		return false;
	}
	
	static public boolean modifyMusician(String name, String newName) {
		Musician m = Musician.searchMusician(name);
		if(m != null && m.getClass() == Musician.class) {
			m.setName(newName);
			return true;
		}
		return false;
	}
	
	public boolean addInstrument(String name) {
		if(!instruments.contains(name)) {
			this.instruments.add(name);
			return true;
		}
		return false;
	}
	
	public boolean deleteInstrument(String name) {
		return instruments.remove(name);
	}
	
	
	
	
	public static ArrayList<Musician> getInstances() {
		return instances;
	}
	public static void setInstances(ArrayList<Musician> musicians) {
		instances = musicians;
	}

	public ArrayList<String> getInstruments() {
		return instruments;
	}
	public void setInstruments(ArrayList<String> instruments) {
		this.instruments = instruments;
	}
	
	
}