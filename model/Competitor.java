package model;

public abstract class Competitor {
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
