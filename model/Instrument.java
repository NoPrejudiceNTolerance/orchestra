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
		
		if(instances == null) instances = new ArrayList<Instrument>();
		
		instances.add(this);
	}
	
	static public Instrument searchInstrument(String name) {
		for(Instrument instance : instances) {
			if(instance.getName().toUpperCase().equals(name.toUpperCase())) return instance;
		}
		return null;
	}
	
	static public boolean addInstrument(String name) {
		if(Instrument.searchInstrument(name) == null) {
			new Instrument(name);
			return true;
		}
		return false;
	}
	
	static public boolean deleteInstrument(String name) {
		Instrument m = Instrument.searchInstrument(name);
		if(m != null) {
			Instrument.instances.remove(m);
			return true;
		}
		return false;
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