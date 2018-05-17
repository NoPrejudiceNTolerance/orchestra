package model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static private ArrayList<User> instances;
	
	private String login;
	private String pass;
	
	
	
	
	public User(String login, String pass) {
		this.login = login;
		this.pass = pass;
		
		instances.add(this);
	}
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public static ArrayList<User> getInstances() {
		return instances;
	}
	
	public static void setInstances(ArrayList<User> users) {
		instances = users;
	}
	
}