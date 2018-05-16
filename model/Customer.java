package model;

import java.util.ArrayList;

public class Customer extends User {
	private ArrayList<Event> tickets;
	
	
	public Customer(String login, String pass) {
		super(login, pass);
	}
	
	
	public ArrayList<Event> getTickets() {
		return tickets;
	}
	public void setTickets(ArrayList<Event> tickets) {
		this.tickets = tickets;
	}
	
}