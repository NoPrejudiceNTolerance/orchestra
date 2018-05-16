package model;

import java.util.ArrayList;
import java.util.Calendar;

public class General extends Event {
	private Musician conductor;
	private ArrayList<Musician> musicians;
	
	
	public General(String name, Calendar cal, String details, Musician conductor) {
		super(name, cal, details);
		this.conductor = conductor;
	}
	
	
	public ArrayList<Musician> getMusicians() {
		return musicians;
	}
	public void setMusicians(ArrayList<Musician> musicians) {
		this.musicians = musicians;
	}
	
	public Musician getConductor() {
		return conductor;
	}
	public void setConductor(Musician conductor) {
		this.conductor = conductor;
	}
	
}