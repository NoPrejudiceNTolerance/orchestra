package model;

import java.util.ArrayList;
import java.util.Date;

public class Competition extends Event {
	private ArrayList<ArrayList<Musician>> teams;
	
	
	
	
	public Competition(String name, Date d, String details) {
		super(name, d, details);
	}
	
	
	public ArrayList<ArrayList<Musician>> getTeams() {
		return teams;
	}
	public void setTeams(ArrayList<ArrayList<Musician>> teams) {
		this.teams = teams;
	}
	
}
