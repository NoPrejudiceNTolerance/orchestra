package model;

import java.io.Serializable;

public class Song{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	
	
	
	
	public Song(String name) {
		super();
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}