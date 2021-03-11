package projekt;

import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Login {

	static String[][] Speichern;
	static int WieTief = 0;

	public static void RegistrierungButtonPressed() {

		
		//LoginGUI.dispatchEvent(new WindowEvent(LoginGUI, WindowEvent.WINDOW_CLOSING));
		new RegistrierungsGUI();
		

	}

	public static void LoginButtonPressed() {

		boolean Allowed = Login.DarfLogin();

	}

	//////////////////////////////////////////////////////////////////////////////////////////
	
	
	public static boolean DarfLogin() {

		String Username = LoginGUI.jUsername.getText();
		String Passwort = LoginGUI.jPasswordField1.getText();

		Login.readCSV();

		for (int i = 1; i < WieTief; i++) {

			if (Username.equals(Speichern[i][2])) {

				if (Passwort.equals(Speichern[i][3])) {

					System.out.println("Test erfolgreich");
					return true;

				} else {

					System.out.println("Passwort falsch");
					return false;
				}

			}

		}

		System.out.println("Benutzer existiert nicht");
		return false;

	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////

	public static void readCSV() {

		String Pfad = "src\\projekt\\Benutzerdaten.csv";
		String line;

		try {
			BufferedReader BR1 = new BufferedReader(new FileReader(Pfad));

			int z = 0;

			while ((line = BR1.readLine()) != null) {

				WieTief++;

			}

			Speichern = new String[WieTief][4];

			BufferedReader BR = new BufferedReader(new FileReader(Pfad));

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
