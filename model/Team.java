package model;

import java.util.ArrayList;

public class Team extends Competitor {
	private ArrayList<Competitor> children;
	
	
	
	
	public Team(String name) {
		super(name);
	}
	
	
	public ArrayList<Competitor> getChildren() {
		return children;
	}
	public void setChildren(ArrayList<Competitor> children) {
		this.children = children;
	}
	
}
