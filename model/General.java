package model;

import java.util.ArrayList;
import java.util.Date;

public class General extends Event {
	private Musician conductor;
	
	
	
	
	public General(String name, Date d, String details, Musician conductor) {
		super(name, d, details);
		this.conductor = conductor;
	}
	
	
	public Musician getConductor() {
		return conductor;
	}
	public void setConductor(Musician conductor) {
		this.conductor = conductor;
	}
	
}
