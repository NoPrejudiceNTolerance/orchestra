package view;

import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Iterable;

import model.Event;

public class View {
		//Use-case 1
		public void displayEvents(ArrayList<Event> events) {
			for (Iterator<Event> iter = events.iterator(); iter.hasNext();) {
				System.out.println(iter.next());
			}
		}

}
