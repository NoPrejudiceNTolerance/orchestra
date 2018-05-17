package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Instrument implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	public static void setInstances(ArrayList<Instrument> instruments) {
		instances = instruments;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}