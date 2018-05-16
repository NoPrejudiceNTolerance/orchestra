package controller;
import java.util.ArrayList;
import java.util.Calendar;

import model.Event;
import view.View;

public class Controller {
	private Event event = null;
	private View view = null;
	
		public Controller (Event event, View view) {
		this.event = event;
		this.view = view;
		}
		
		public ArrayList<Event> getEvents() {
			return event.getInstances();
		}
		
		public void updateView() {
			view.displayEvents(getEvents());
		}
		
		
}
