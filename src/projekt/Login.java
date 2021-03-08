package projekt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;  
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader; 


public class Login {

	public static void RegistrierungButtonPressed() {
		
		new RegistrierungsGUI();
		
		
	}
	
	public static void LoginButtonPressed(){
		
		
		
		Login.readCSV();
		
		
		
	}
	
	
	
	public static void CheckLogin(){
		
		String Username = LoginGUI.jUsername.getText();
		String Passwort = LoginGUI.jPasswordField1.getText();
		
		
		
	
		
	}
	
	public static void readCSV(){
		
		
	String Pfad = "C:\\Users\\Henning\\git\\Java-Handelsportal\\src\\projekt\\Benutzerdaten.csv";
	String line;
	
	ArrayList<String[]> Liste = new ArrayList<String[]>();
	
	try {
		BufferedReader BR = new BufferedReader(new FileReader(Pfad));
		
		while((line = BR.readLine()) != null) {
			String[] Werte = line.split(";");
			
			System.out.println(Werte[1]);
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
} 

}
	
	

