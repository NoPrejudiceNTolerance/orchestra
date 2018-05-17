package model;

import java.util.ArrayList;

public class Customer extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private ArrayList<Event> tickets;
	
	static private long nb = 0;
	
	
	
	
	public Customer(String login, String pass) {
		super(login, pass);
		
		this.id = Customer.nb;
		Customer.nb++;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public ArrayList<Event> getTickets() {
		return tickets;
	}
	public void setTickets(ArrayList<Event> tickets) {
		this.tickets = tickets;
	}
	
}