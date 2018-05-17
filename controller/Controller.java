package controller;
import java.util.ArrayList;
import java.io.*;

import model.Event;
import model.Instrument;
import model.Musician;
import model.User;
import view.View;

public class Controller {
	private View view;
	private Event current_event;
	private Musician current_musician;
	
	private enum Page {
		EXITING,
		HOMEPAGE,
		
		EVENTS_PAGE,
		VIEW_EVENTS,
		ADD_EVENT,
		MODIFY_EVENT,
		DELETE_EVENT,
		EVENTS_DETAILS_NEW,
		
		EVENTS_DETAILS,
		VIEW_EVENT_MUSICIANS,
		ADD_EVENT_MUSICIAN,
		DELETE_EVENT_MUSICIAN,
		VIEW_SONGS,
		ADD_SONG,
		DELETE_SONG,
		
		MUSICIANS_PAGE,
		VIEW_MUSICIANS,
		ADD_MUSICIAN,
		MODIFY_MUSICIAN,
		DELETE_MUSICIAN,
		MUSICIAN_DETAILS_NEW,
		
		MUSICIANS_DETAILS,
		VIEW_MUSICIAN_INSTRUMENTS,
		ADD_MUSICIAN_INSTRUMENT,
		DELETE_MUSICIAN_INSTRUMENT,
		
		VIEW_INSTRUMENTS,
		ADD_INSTRUMENT,
		DELETE_INSTRUMENT;
	}
	
	public Controller () {	
		view = View.getInstance();
		loadFiles();
	}
	
	private void loadFiles() {
		ArrayList<Event> events = null;
		try {
			FileInputStream fileIn = new FileInputStream("src/files/events.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			events = (ArrayList<Event>) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Event class not found");
			c.printStackTrace();
			return;
		}
		if (events == null) {
			Event.setInstances(new ArrayList<Event>());
		}
		else {
			Event.setInstances(events);
		}
		
		ArrayList<Musician> musicians = null;
		try {
			FileInputStream fileIn = new FileInputStream("src/files/musicians.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			musicians = (ArrayList<Musician>) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Musician class not found");
			c.printStackTrace();
			return;
		}
		
		if (musicians == null) {
			Musician.setInstances(new ArrayList<Musician>());
		}
		else {
			Musician.setInstances(musicians);
		}
		
		ArrayList<Instrument> instruments = null;
		try {
			FileInputStream fileIn = new FileInputStream("src/files/instruments.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			instruments = (ArrayList<Instrument>) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Instrument class not found");
			c.printStackTrace();
			return;
		}
		if (instruments == null) {
			Instrument.setInstances(new ArrayList<Instrument>());
		}
		else {
			Instrument.setInstances(instruments);
		}
		
		ArrayList<User> users = null;
		try {
			FileInputStream fileIn = new FileInputStream("src/files/users.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			users = (ArrayList<User>) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("User class not found");
			c.printStackTrace();
			return;
		}
		
		if (users == null) {
			User.setInstances(new ArrayList<User>());
		}
		else {
			User.setInstances(users);
		}
	}
	
	public void run() {
		
		boolean exiting = false;
		Page page = Page.HOMEPAGE;
		
		//main loop
		while (!exiting) {
			view.printSpaces();
			
			switch (page) {
			
			case EXITING:
				exiting = true;
				break;
			
			case HOMEPAGE:
				page = welcomePage();
				break;
			
			case EVENTS_PAGE:
				page = eventsPage();
				break;
			
			case VIEW_EVENTS:
				page = viewEvents();
				break;
				
			case ADD_EVENT:
				page = addEvent();
				break;
				
			case DELETE_EVENT:
				page = deleteEvent();
				break;
				
			case MODIFY_EVENT:
				page = modifyEvent();
				break;
			
			case EVENTS_DETAILS_NEW:
				page = eventsDetailsNew();
				break;
				
			case EVENTS_DETAILS:
				page = eventsDetails();
				break;
				
			case VIEW_EVENT_MUSICIANS:
				page = viewEventMusicians();
				break;
				
			case ADD_EVENT_MUSICIAN:
				page = addEventMusician();
				break;
				
			case DELETE_EVENT_MUSICIAN:
				page = deleteEventMusician();
				break;
				
			case VIEW_SONGS:
				page = viewSongs();
				break;
				
			case ADD_SONG:
				page = addSong();
				break;
				
			case DELETE_SONG:
				page = deleteSong();
				break;
			
			case MUSICIANS_PAGE:
				page = musiciansPage();
				break;
			
			case VIEW_MUSICIANS:
				page = viewMusicians();
				break;
				
			case ADD_MUSICIAN:
				page = addMusician();
				break;
				
			case DELETE_MUSICIAN:
				page = deleteMusician();
				break;
				
			case MODIFY_MUSICIAN:
				page = modifyMusician();
				break;
				
			case VIEW_INSTRUMENTS:
				page = viewInstruments();
				break;
				
			case ADD_INSTRUMENT:
				page = addInstrument();
				break;
				
			case DELETE_INSTRUMENT:
				page = deleteInstrument();
				break;
				
			case MUSICIAN_DETAILS_NEW:
				page = musicianDetailsNew();
				break;
				
			case MUSICIANS_DETAILS:
				page = musiciansDetails();
				break;
				
			case VIEW_MUSICIAN_INSTRUMENTS:
				page = viewMusicianInstruments();
				break;
				
			case ADD_MUSICIAN_INSTRUMENT:
				page = addMusicianInstrument();
				break;
				
			case DELETE_MUSICIAN_INSTRUMENT:
				page = deleteMusicianInstrument();
			
			default:
			}
		}
		
		
		
		saveFiles();
	}
	
	private Page eventsPage() {
		String choice;
		boolean is_valid = false;
		
		view.displayEventsPage();
		choice = view.choice();
		
		while (!is_valid) {
			switch (choice.charAt(0)) {
			
			case '1':
				return Page.VIEW_EVENTS;
			
			case '2':
				return Page.ADD_EVENT;
			
			case '3':
				return Page.MODIFY_EVENT;
				
			case '4':
				return Page.DELETE_EVENT;
				
			case '5':
				return Page.EVENTS_DETAILS_NEW;
			
			case '6':
				return Page.HOMEPAGE;
			
			default:
				System.out.println("Invalid choice. Please try again.");
				choice = view.choice();
			}
		}
		
		return Page.EXITING;
	}
	
	private Page viewEvents() {
		view.viewEvents(Event.getInstances());
		view.waitEnter();
		return Page.EVENTS_PAGE;
	}
	
	private Page addEvent() {
		view.addEvent();
		view.waitEnter();
		return Page.EVENTS_PAGE;
	}
	
	private Page deleteEvent() {
		view.deleteEvent();
		view.waitEnter();
		return Page.EVENTS_PAGE;
	}
	
	private Page modifyEvent() {
		view.modifyEvent();
		view.waitEnter();
		return Page.EVENTS_PAGE;
	}
	
	private Page eventsDetailsNew() {
		current_event = view.searchEvent();
		if (current_event == null) {
			System.out.println("No event with this name was found.");
			view.waitEnter();
			return Page.EVENTS_PAGE;
		}
		return Page.EVENTS_DETAILS;
	}
	
	private Page eventsDetails() {
		String choice;
		boolean is_valid = false;
		
		view.eventsDetails(current_event);
		choice = view.choice();
		
		while (!is_valid) {
			switch (choice.charAt(0)) {
			
			case '1':
				return Page.VIEW_EVENT_MUSICIANS;
			
			case '2':
				return Page.ADD_EVENT_MUSICIAN;
			
			case '3':
				return Page.DELETE_EVENT_MUSICIAN;
				
			case '4':
				return Page.VIEW_SONGS;
				
			case '5':
				return Page.ADD_SONG;
			
			case '6':
				return Page.DELETE_SONG;
				
			case '7':
				return Page.EVENTS_PAGE;
			
			default:
				System.out.println("Invalid choice. Please try again.");
				choice = view.choice();
			}
		}
		
		return Page.EXITING;
	}
	
	private Page viewEventMusicians() {
		view.displayEventMusicians(current_event);
		view.waitEnter();
		return Page.EVENTS_DETAILS;
	}
	
	private Page addEventMusician() {
		view.addEventMusician(current_event);
		view.waitEnter();
		return Page.EVENTS_DETAILS;
	}
	
	private Page deleteEventMusician() {
		view.deleteEventMusician(current_event);
		view.waitEnter();
		return Page.EVENTS_DETAILS;
	}
	
	private Page viewSongs() {
		view.displaySongs(current_event);
		view.waitEnter();
		return Page.EVENTS_DETAILS;
	}
	
	private Page addSong() {
		view.addSong(current_event);
		view.waitEnter();
		return Page.EVENTS_DETAILS;
	}
	
	private Page deleteSong() {
		view.deleteSong(current_event);
		view.waitEnter();
		return Page.EVENTS_DETAILS;
	}
	
	private Page musiciansPage() {
		String choice;
		boolean is_valid = false;
		
		view.displayMusiciansPage();
		choice = view.choice();
		
		while (!is_valid) {
			switch (choice.charAt(0)) {
			
			case '1':
				return Page.VIEW_MUSICIANS;
			
			case '2':
				return Page.ADD_MUSICIAN;
			
			case '3':
				return Page.MODIFY_MUSICIAN;
				
			case '4':
				return Page.DELETE_MUSICIAN;
				
			case '5':
				return Page.MUSICIAN_DETAILS_NEW;
				
			case '6':
				return Page.VIEW_INSTRUMENTS;
				
			case '7':
				return Page.ADD_INSTRUMENT;
				
			case '8':
				return Page.DELETE_INSTRUMENT;
			
			case '9':
				return Page.HOMEPAGE;
			
			default:
				System.out.println("Invalid choice. Please try again.");
				choice = view.choice();
			}
		}
		
		return Page.EXITING;
	}
	
	private Page viewMusicians() {
		view.viewMusicians(Musician.getInstances());
		view.waitEnter();
		return Page.MUSICIANS_PAGE;
	}
	
	private Page addMusician() {
		view.addMusician();
		view.waitEnter();
		return Page.MUSICIANS_PAGE;
	}
	
	private Page deleteMusician() {
		view.deleteMusician();
		view.waitEnter();
		return Page.MUSICIANS_PAGE;
	}
	
	private Page modifyMusician() {
		view.modifyMusician();
		view.waitEnter();
		return Page.MUSICIANS_PAGE;
	}
	
	private Page viewInstruments() {
		view.viewInstruments(Instrument.getInstances());
		view.waitEnter();
		return Page.MUSICIANS_PAGE;
	}
	
	private Page addInstrument() {
		view.addInstrument();
		view.waitEnter();
		return Page.MUSICIANS_PAGE;
	}
	
	private Page deleteInstrument() {
		view.deleteInstrument();
		view.waitEnter();
		return Page.MUSICIANS_PAGE;
	}
	
	private Page musicianDetailsNew() {
		current_musician = view.searchMusician();
		if (current_musician == null) {
			System.out.println("No musician with this name was found.");
			view.waitEnter();
			return Page.MUSICIANS_PAGE;
		}
		return Page.MUSICIANS_DETAILS;
	}
	
	private Page musiciansDetails() {
		String choice;
		boolean is_valid = false;
		
		view.musiciansDetails(current_musician);
		choice = view.choice();
		
		while (!is_valid) {
			switch (choice.charAt(0)) {
			
			case '1':
				return Page.VIEW_MUSICIAN_INSTRUMENTS;
			
			case '2':
				return Page.ADD_MUSICIAN_INSTRUMENT;
			
			case '3':
				return Page.DELETE_MUSICIAN_INSTRUMENT;
				
			case '4':
				return Page.MUSICIANS_PAGE;
			
			default:
				System.out.println("Invalid choice. Please try again.");
				choice = view.choice();
			}
		}
		
		return Page.EXITING;
	}
	
	private Page viewMusicianInstruments() {
		view.displayMusicianInstruments(current_musician);
		view.waitEnter();
		return Page.MUSICIANS_DETAILS;
	}
	
	private Page addMusicianInstrument() {
		view.addMusicianInstrument(current_musician);
		view.waitEnter();
		return Page.MUSICIANS_DETAILS;
	}
	
	private Page deleteMusicianInstrument() {
		view.deleteMusicianInstrument(current_musician);
		view.waitEnter();
		return Page.MUSICIANS_DETAILS;
	}
	
	private Page welcomePage() {
		String choice = null;
		boolean is_valid = false;
		
		view.displayWelcomePage();
		choice = view.choice();
		
		while (!is_valid) {
			switch (choice.charAt(0)) {
			
			case '1':
				return Page.EVENTS_PAGE;
			
			case '2':
				return Page.MUSICIANS_PAGE;
			
			case '3':
				return Page.EXITING;
			
			default:
				System.out.println("Invalid choice. Please try again.");
				choice = view.choice();
			}
		}
		
		return Page.EXITING;
	}
		
	private void saveFiles() {
		try {
			FileOutputStream fileOut = new FileOutputStream("src/files/events.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(Event.getInstances());
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
		
		try {
			FileOutputStream fileOut = new FileOutputStream("src/files/musicians.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(Musician.getInstances());
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
		
		try {
			FileOutputStream fileOut = new FileOutputStream("src/files/instruments.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(Instrument.getInstances());
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
		
		try {
			FileOutputStream fileOut = new FileOutputStream("src/files/users.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(User.getInstances());
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}
