package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Competition extends Event {
<<<<<<< HEAD
	private ArrayList<Team> teams;
=======
	private ArrayList<Competitor> competitors;
	
	
	
>>>>>>> 5ecc8cee1692ce7a9ee6883af37e55861973e809
	
	public ArrayList<Competitor> getCompetitors() {
		return competitors;
	}
	
<<<<<<< HEAD
	public ArrayList<Team> getTeams() {
		return teams;
	}
	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
=======
	
	public void setCompetitors(ArrayList<Competitor> competitors) {
		this.competitors = competitors;
	}
	public Competition(String name, Calendar cal, String details) {
		super(name, cal, details);
>>>>>>> 5ecc8cee1692ce7a9ee6883af37e55861973e809
	}
	
	
}