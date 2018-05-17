package model;

import java.io.Serializable;

public abstract class Competitor implements Serializable{
	private String name;
	
	
	
	
	public Competitor(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
