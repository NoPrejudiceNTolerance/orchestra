package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;

import model.Competition;
import model.Event;
import model.General;
import model.Instrument;
import model.Musician;
import model.Song;

public class View {
	
	private static View instance = null;
	
	private View() {
		
	}
	
	public static synchronized View getInstance() {
		if (instance == null)
			instance = new View();
		return instance;
	}

	public void printSpaces() {
		for (int i = 0; i < 50; i++)
			System.out.println();
	}
	
	public void waitEnter() {
		System.out.print("Press Enter to continue...");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
        	br.readLine();
        } catch (IOException e) {
        	e.printStackTrace();
        }
	}
	
	public String choice() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Choice: ");
        String input = "";
        while (input.equals("")) {
        	try {
        		input = br.readLine();
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
        }
		
		return input;
	}
	
	public void displayWelcomePage() {
		System.out.println("Welcome to the Orchestra!");
		System.out.println("1. See Events");
		System.out.println("2. See Musicians & Instruments");
		System.out.println("3. Exit the application");
	}
	
	public void displayEventsPage() {
		System.out.println("Events page");
		System.out.println("1. View incoming events");
		System.out.println("2. Add new event");
		System.out.println("3. Modify an existing event");
		System.out.println("4. Delete an event");
		System.out.println("5. Check the details of an event");
		System.out.println("6. Go back to the homepage");
	}
	
	public void viewEvents(ArrayList<Event> events) {
		if (events != null && !events.isEmpty()) {
			for (Event event : events) {
				printEvent(event);
				System.out.println();
			}
		}
		else {
			System.out.println("No event to display!");
		}
	}
	
	private void printEvent(Event event) {
		System.out.println(event.getName());
		
		if (event.getClass() == General.class) {
			System.out.println("General");
			System.out.println(event.getD().getTime());
			System.out.print("Conductor: ");
			System.out.println(((General)event).getConductor());
			System.out.print(((General)event).getMusicians().size());
			System.out.println(" musicians");
		} else {
			System.out.println("Competition");
			System.out.println(event.getD().getTime());
			System.out.print(((Competition)event).getCompetitors().size());
			System.out.println(" competitors");
		}
	}
	
	public void addEvent() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = null;
		String type = null;
		String day = null;
		String month = null;
		String year = null;
		String conductor = null;
		String details = null;
		
		System.out.println("New event:");
		System.out.print("Name: ");
		try {
			name = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Type:");
		System.out.println("1. General");
		System.out.println("2. Competition");
		type = choice();
		boolean is_valid = false;
		
		while (!is_valid) {
			switch (type.charAt(0)) {
			
			case '1':
				type = "General";
				is_valid = true;
				break;
				
			case '2':
				type = "Competition";
				is_valid = true;
				break;
			
			default:
				System.out.println("Wrong input. Please try again.");
				type = choice();
			}
		}
		
		System.out.println("Date:");
		System.out.print("   Day: ");
		try {
			day = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("   Month: ");
		try {
			month = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("   Year: ");
		try {
			year = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(day));
		
		System.out.println("Details: ");
		try {
			details = br.readLine();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
		if (type.equals("General")) {
			
			System.out.print("Conductor: ");
			try {
				conductor = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if (Musician.searchMusician(conductor) == null) {
				System.out.println("No musician with this name was found.");
				return;
			}
			
			General.addEvent(name, cal, details, conductor);
		}
		else {
			Competition.addEvent(name, cal, details);
		}
		
		System.out.println("The event has been added!");
	}
	
	public void deleteEvent() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = null;
		
		System.out.println("Delete en event:");
		System.out.print("Enter the name of the event you want to delete: ");
		try {
			name = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (Event.deleteEvent(name)) {
			System.out.println("The event has been deleted.");
		}
		else {
			System.out.println("No event with this name was found.");
		}
	}
	
	public void modifyEvent() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String original_name = null;
		String name = null;
		String type = null;
		String day = null;
		String month = null;
		String year = null;
		String conductor = null;
		String details = null;
		
		System.out.println("Modify en event:");
		System.out.print("Enter the name of the event you want to modify: ");
		try {
			original_name = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("Name: ");
		try {
			name = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Type:");
		System.out.println("1. General");
		System.out.println("2. Competition");
		type = choice();
		boolean is_valid = false;
		
		while (!is_valid) {
			switch (type.charAt(0)) {
			
			case '1':
				type = "General";
				is_valid = true;
				break;
				
			case '2':
				type = "Competition";
				is_valid = true;
				break;
			
			default:
				System.out.println("Wrong input. Please try again.");
				type = choice();
			}
		}
		
		System.out.println("Date:");
		System.out.print("   Day: ");
		try {
			day = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("   Month: ");
		try {
			month = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("   Year: ");
		try {
			year = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		
		System.out.println("Details: ");
		try {
			details = br.readLine();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		boolean success = false;
		
		if (type.equals("General")) {
			
			System.out.print("Conductor: ");
			try {
				conductor = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if (Musician.searchMusician(conductor) == null) {
				System.out.println("No musician with this name was found.");
				return;
			}
			
			success = General.modifyEvent(original_name, name, cal, details, conductor);
		}
		else {
			success = Competition.modifyEvent(original_name, name, cal, details);
		}
		
		if (success) {
			System.out.println("The event has been modified.");
		}
		else {
			System.out.println("No event with this name was found.");
		}
	}
	
	public Event searchEvent() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = null;
		
		System.out.println("Details of an event:");
		System.out.print("Enter the name of the event you want to know the details of: ");
		try {
			name = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Event.searchEvent(name);
	}
	
	public void eventsDetails(Event event) {
		System.out.println("Event: " + event.getName());
		System.out.println("1. See which musicians play at this event");
		System.out.println("2. Add a musician");
		System.out.println("3. Remove a musician");
		System.out.println("4. See which songs will be played at this event");
		System.out.println("5. Add a song");
		System.out.println("6. Remove a song");
		System.out.println("7. Go back to the events page");
	}
	
	public void displayEventMusicians(Event event) {
		if (event.getClass() == General.class) {
			ArrayList<String> musicians = ((General)event).getMusicians();
			for (String name : musicians) {
				System.out.println(name);
			}
		}
		else {
			//TODO print "teams" for a competition
		}
	}
	
	public void addEventMusician(Event event) {
		if (event.getClass() == General.class) {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String name = null;
			
			System.out.println("Add a musician to the list of musicians participating to this event:");
			System.out.print("Name: ");
			try {
				name = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if (Musician.searchMusician(name) == null) {
				System.out.println("No musician with this name was found.");
				return;
			}
			if (!((General)event).addMusician(name)) {
				System.out.println("This musician is alrealdy participating in that event!");
			}
			else {
				System.out.println(("The musician has been added to the event."));
			}
		}
		else {
			//TODO add competitor to a competition
		}
	}
	
	public void deleteEventMusician(Event event) {
		if (event.getClass() == General.class) {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String name = null;
			
			System.out.println("Delete a musician from the list of musicians participating to this event:");
			System.out.print("Name: ");
			try {
				name = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if (!((General)event).deleteMusician(name)) {
				System.out.println("No musician with this name was found.");
			}
			else {
				System.out.println("The musician has been deleted.");
			}
		}
	}
	
	public void displaySongs(Event event) {
		ArrayList<Song> songs = event.getSongs();
		for (Song song : songs) {
			System.out.println(song);
		}
	}
	
	public void addSong(Event event) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = null;
		String composer = null;
		
		System.out.println("New song:");
		System.out.print("Name: ");
		try {
			name = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("Composer: ");
		try {
			composer = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (event.addSong(new Song(name, composer))) {
			System.out.println("The song has been added!");
		}
		else {
			System.out.println("This song  was already listed in the event!");
		}
	}
	
	public void deleteSong(Event event) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = null;
		
		System.out.println("Delete a song:");
		System.out.print("Enter the song of the event you want to delete: ");
		try {
			name = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (event.deleteSong(name)) {
			System.out.println("The song has been deleted.");
		}
		else {
			System.out.println("No song with this name was found.");
		}
	}
	
	public void displayMusiciansPage() {
		System.out.println("Musicians & Instuments page");
		System.out.println("1. View musicians");
		System.out.println("2. Add new musician");
		System.out.println("3. Modify an existing musiciant");
		System.out.println("4. Delete a musician");
		System.out.println("5. Check the details of a musician");
		System.out.println("6. View instruments");
		System.out.println("7. Add new instrument");
		System.out.println("8. Delete instrument");
		System.out.println("9. Go back to the homepage");
	}
	
	public void viewMusicians(ArrayList<Musician> musicians) {
		if (musicians != null && !musicians.isEmpty()) {
			for (Musician musician : musicians) {
				System.out.println(musician.getName());
				System.out.println();
			}
		}
		else {
			System.out.println("No musician to display!");
		}
	}
	
	public void addMusician() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = null;
		
		System.out.println("New musician:");
		System.out.print("Name: ");
		try {
			name = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (Musician.addMusician(name)) {
			System.out.println("The musician has been added!");
		}
		else {
			System.out.println("There is already a musician with this name!");
		}
	}
	
	public void deleteMusician() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = null;
		
		System.out.println("Delete a musician:");
		System.out.print("Enter the name of the musician you want to delete: ");
		try {
			name = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (Musician.deleteMusician(name)) {
			System.out.println("The musician has been deleted.");
		}
		else {
			System.out.println("No musician with this name was found.");
		}
	}
	
	public void modifyMusician() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String original_name = null;
		String name = null;
		
		System.out.println("Modify a musician:");
		System.out.print("Enter the name of the musician you want to modify: ");
		try {
			original_name = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("Name: ");
		try {
			name = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (Musician.modifyMusician(original_name, name)) {
			System.out.println("The musician has been modified.");
		}
		else {
			System.out.println("No musician with this name was found.");
		}
	}
	
	public void viewInstruments(ArrayList<Instrument> instruments) {
		if (instruments != null && !instruments.isEmpty()) {
			for (Instrument instrument : instruments) {
				System.out.println(instrument.getName());
				System.out.println();
			}
		}
		else {
			System.out.println("No instrument to display!");
		}
	}
	
	public void addInstrument() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = null;
		
		System.out.println("New instrument:");
		System.out.print("Name: ");
		try {
			name = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (Instrument.addInstrument(name)) {
			System.out.println("The instrument has been added!");
		}
		else {
			System.out.println("There is already an instrument with this name!");
		}	
	}
	
	public void deleteInstrument() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = null;
		
		System.out.println("Delete an instrument:");
		System.out.print("Enter the name of the instrument you want to delete: ");
		try {
			name = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (Instrument.deleteInstrument(name)) {
			System.out.println("The instrument has been deleted.");
		}
		else {
			System.out.println("No instrument with this name was found.");
		}
	}
	
	public Musician searchMusician() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = null;
		
		System.out.println("Details of a muscian:");
		System.out.print("Enter the name of the musician you want to know the details of: ");
		try {
			name = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Musician.searchMusician(name);
	}
	
	public void musiciansDetails(Musician musician) {
		System.out.println("Musician: " + musician.getName());
		System.out.println("1. See which instrument(s) this musician plays");
		System.out.println("2. Add an instrument");
		System.out.println("3. Remove an instrument");
		System.out.println("4. Go back to the Musicians & Instruments page");
	}
	
	public void displayMusicianInstruments(Musician musician) {
		ArrayList<String> instruments = musician.getInstruments();
		for (String instrument : instruments) {
			System.out.println(instrument);
		}
	}
	
	public void addMusicianInstrument(Musician musician) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = null;
		
		System.out.println("Add an instrument to the list of instrument played by this musician:");
		System.out.print("Name: ");
		try {
			name = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (Instrument.searchInstrument(name) == null) {
			System.out.println("No instrument with this name was found.");
			return;
		}
		if (!(musician.addInstrument(name))) {
			System.out.println("This instrument is alrealdy played by that musician!");
		}
		else {
			System.out.println(("The instrument has been added to the musician."));
		}
	}
	
	public void deleteMusicianInstrument(Musician musician) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = null;
		
		System.out.println("Delete an instrument from the list of instruments played by this musician:");
		System.out.print("Name: ");
		try {
			name = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (!musician.deleteInstrument(name)) {
			System.out.println("No instrument with this name was found.");
		}
		else {
			System.out.println("The instrument has been deleted.");
		}
	}
}
