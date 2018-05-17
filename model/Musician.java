package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

public class Musician extends Competitor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static private ArrayList<Musician> instances;
	
	private ArrayList<Instrument> instruments;
	
	
	
	
	public Musician(String name) {
		super(name);
		
		instances.add(this);
	}
	
	
	public static ArrayList<Musician> getInstances() {
		return instances;
	}
	public static void setInstances(ArrayList<Musician> musicians) {
		instances = musicians;
	}

	public ArrayList<Instrument> getInstruments() {
		return instruments;
	}
	public void setInstruments(ArrayList<Instrument> instruments) {
		this.instruments = instruments;
	}
	
	
}