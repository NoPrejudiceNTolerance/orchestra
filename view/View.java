package view;

import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Iterable;

import model.Event;

public class View {
		//Use-case 1
		public void displayEvents(ArrayList<Event> events) {
			for (Iterator<Event> iter = events.iterator(); iter.hasNext();) {
				//String str = (String)iter;
				System.out.println("Element Events :" + iter.next().toString());
			}
		}
		
		//Use-case 2
		public void CreateNewEvent() {
			
		}

}
