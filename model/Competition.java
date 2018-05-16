package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Competition extends Event {
	private ArrayList<ArrayList<Musician>> teams;
	
	
	
	
	public Competition(String name, Calendar cal, String details) {
		super(name, cal, details);
	}
	
	
	public ArrayList<ArrayList<Musician>> getTeams() {
		return teams;
	}
	public void setTeams(ArrayList<ArrayList<Musician>> teams) {
		this.teams = teams;
	}
	
}