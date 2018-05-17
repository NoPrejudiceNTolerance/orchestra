package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

<<<<<<< HEAD
public class Musician implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

=======
public class Musician extends Competitor {
>>>>>>> 5ecc8cee1692ce7a9ee6883af37e55861973e809
	static private ArrayList<Musician> instances;
	
	private ArrayList<Instrument> instruments;
	
	
	
	
	public Musician(String name) {
		super(name);
		
		instances.add(this);
	}
	
	
	public static ArrayList<Musician> getInstances() {
		return instances;
	}
	
<<<<<<< HEAD
	public static void setInstances(ArrayList<Musician> musicians) {
		instances = musicians;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
=======
>>>>>>> 5ecc8cee1692ce7a9ee6883af37e55861973e809
	public ArrayList<Instrument> getInstruments() {
		return instruments;
	}
	public void setInstruments(ArrayList<Instrument> instruments) {
		this.instruments = instruments;
	}
	
	
}