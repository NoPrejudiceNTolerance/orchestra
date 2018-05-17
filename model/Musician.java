package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

public class Musician implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static private ArrayList<Musician> instances;
	
	private String name;
	private ArrayList<Instrument> instruments;
	
	
	
	
	public Musician(String name) {
		this.name = name;
		
		instances.add(this);
	}
	
	
	public static ArrayList<Musician> getInstances() {
		return instances;
	}
	
	public static void setInstances(ArrayList<Musician> musicians) {
		instances = musicians;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Instrument> getInstruments() {
		return instruments;
	}
	public void setInstruments(ArrayList<Instrument> instruments) {
		this.instruments = instruments;
	}
	
	
}