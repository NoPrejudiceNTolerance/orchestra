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
		Event.setInstances(events);
		
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
		Musician.setInstances(musicians);
		
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
		Instrument.setInstances(instruments);
		
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
		User.setInstances(users);
	}
	
	public void run() {
		
		boolean exiting = false;
		int page = 1;
		
		//main loop
		while (!exiting) {
			
			switch (page) {
			
			case 1:
				page = welcomePage();
				break;
			
			case 2:
				page = eventsPage();
				break;
			
			case 3:
				page = musiciansPage();
				break;
			
			}
			
		}
		
		
		
		saveFiles();
	}
	
	private int welcomePage() {
		String choice = null;
		boolean is_valid = false;
		
		view.displayWelcomePage();
		choice = view.choice();
		
		while (!is_valid) {
			switch (choice.charAt(0)) {
			
			case '1':
				return 2;
			
			case '2':
				return 3;
			
			default:
				System.out.println("Invalid choice. Please try again.");
				choice = view.choice();
			}
		}
		
		return choice.charAt(0);
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
