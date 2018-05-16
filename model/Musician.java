package model;

import java.util.ArrayList;
import java.util.Observable;

public class Musician extends Observable {
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