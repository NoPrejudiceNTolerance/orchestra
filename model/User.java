package model;

import java.util.ArrayList;

public class User {
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
	
}