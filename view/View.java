package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {
	
	private static View instance = null;
	
	private View() {
		
	}

	public static synchronized View getInstance() {
		if (instance == null)
			instance = new View();
		return instance;
	}
	
	public void displayWelcomePage() {
		System.out.println("Welcome to the Orchestra!");
		System.out.println("1. See Events");
		System.out.println("2. See Musicians & Instruments");
	}
	
	public String choice() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Choice: ");
        String input = null;
		try {
			input = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return input;
	}
	
}
