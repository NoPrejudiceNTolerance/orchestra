package model;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static private ArrayList<User> instances;
	
	private String login;
	private String hashedPass;
	
	MessageDigest messageDigest;
	
	
	
	
	public User(String login, String pass) {
		this.login = login;
		
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
		}
		catch (NoSuchAlgorithmException e) {
	        System.err.println("Error with SHA-256 algorithm");
		}
		
		this.messageDigest.update(pass.getBytes());
		this.hashedPass = new String(messageDigest.digest());
		
		instances.add(this);
	}
	
	public boolean checkPass(String pass) {
		this.messageDigest.update(pass.getBytes());
		return (this.hashedPass.equals(new String(messageDigest.digest()))) ? true : false;
	}
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setPass(String pass) {
		this.messageDigest.update(pass.getBytes());
		this.hashedPass = new String(messageDigest.digest());
	}
	
	public static ArrayList<User> getInstances() {
		return instances;
	}
	
	public static void setInstances(ArrayList<User> users) {
		instances = users;
	}
	
}