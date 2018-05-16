package model;

import java.util.ArrayList;

public class Instrument {
	static private ArrayList<Instrument> instances;
	
	private String name;
	
	
	
	
	public Instrument(String name) {
		super();
		this.name = name;
		
		instances.add(this);
	}
	
	
	public static ArrayList<Instrument> getInstances() {
		return instances;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}