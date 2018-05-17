package model;

import java.util.ArrayList;
import java.util.Observable;

public class Musician extends Competitor {
	static private ArrayList<Musician> instances;
	
	private ArrayList<Instrument> instruments;
	
	
	
	
	public Musician(String name) {
		super(name);
		
		instances.add(this);
	}
	
	
	public static ArrayList<Musician> getInstances() {
		return instances;
	}
	
	public ArrayList<Instrument> getInstruments() {
		return instruments;
	}
	public void setInstruments(ArrayList<Instrument> instruments) {
		this.instruments = instruments;
	}
	
	
}