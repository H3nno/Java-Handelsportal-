package projekt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Registrierung {

	static int WieTief = 0;
	static String[][] Speichern;

	@SuppressWarnings("deprecation")
	public static void Registrieren() {

		RegistrierungsGUI.jStatus.setText("");

		if (Registrierung.CheckUsername()) {

			if (Registrierung.CheckPasswords()) {

				FileWriter writer = null;
				
				try {
					
					
					writer = new FileWriter("src\\projekt\\Benutzerdaten.csv", true);

					writer.append("" + RegistrierungsGUI.jTFVorname.getText());
					writer.append(";");
					writer.append("" + RegistrierungsGUI.jTFNachname.getText());
					writer.append(";");
					writer.append("" +RegistrierungsGUI.jTFUsername.getText());
					writer.append(";");
					writer.append("" +RegistrierungsGUI.jPFPasswort1.getText());

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  finally{
					  try {
				  
				      writer.flush();
				      writer.close();
				        } catch (IOException e) {
				      e.printStackTrace();
				}
				  }
				  

			} else {RegistrierungsGUI.jStatus.setText("Passwort Fehler");}
		}
		else {RegistrierungsGUI.jStatus.setText("Benutzername Fehler");}
	}

	//////////////////////////////////////////

	public static void Zurueck() {
		
		
		

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@SuppressWarnings("deprecation")
	public static boolean CheckPasswords() {

		if (!RegistrierungsGUI.jPFPasswort1.getText().equals("")) {

			if (RegistrierungsGUI.jPFPasswort1.getText().equals(RegistrierungsGUI.jPasswordField1.getText())) {

				return true;
			}

		}
		return false;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static boolean CheckUsername() {

		String Username = RegistrierungsGUI.jTFUsername.getText();

		Registrierung.readCSV();

		for (int i = 1; i < WieTief; i++) {

			if (Username.equals(Speichern[i][2])) {return false;}
			}

		if (Username.equals("")) {return false;}

		return true;

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void readCSV() {

		String Pfad = "src\\projekt\\Benutzerdaten.csv";
		String line;
		
		BufferedReader BR1 = null;
		BufferedReader BR = null;

		try {
			BR1 = new BufferedReader(new FileReader(Pfad));

			int z = 0;

			while ((line = BR1.readLine()) != null) {

				WieTief++;

			}

			Speichern = new String[WieTief][4];

			BR = new BufferedReader(new FileReader(Pfad));

			while ((line = BR.readLine()) != null) {

				String[] Spalten = line.split(";");

				for (int j = 0; j < 4; j++) {
					Speichern[z][j] = Spalten[j];

				}

				z++;

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
