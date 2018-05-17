package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Competition extends Event {
	private ArrayList<Team> teams;
	
	public Competition(String name, Calendar cal, String details) {
		super(name, cal, details);
	}
	
	public ArrayList<Team> getTeams() {
		return teams;
	}
	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	
}