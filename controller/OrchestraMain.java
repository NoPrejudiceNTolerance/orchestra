package controller;
import model.*;
import view.*;
import java.util.Calendar;


public class OrchestraMain {

	public static void main(String[] args) {
		
		Event model = updateEvent();
		view.View view = new View();
		Controller c = new Controller(model,view);
		
		c.updateView();
	}
	
	private static Event updateEvent() {
		Calendar cal = Calendar.getInstance();
		//January 1st, 2018, at 10:00 AM
		cal.set(2018, 0, 1, 10, 0, 0);
		System.out.println("Event time is : " + cal.getTime());
		Event m = new Event("Spring festival", cal, "First concert of the year !");
		return m;
	}

}
