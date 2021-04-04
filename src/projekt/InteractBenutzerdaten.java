package projekt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InteractBenutzerdaten {

	static Benutzer[] Kundenliste = null;
	static int WieTief = 0;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public static Benutzer[] readCSV() { // vorübergehend Static

		String Pfad = "src\\projekt\\Benutzerdaten.csv";
		String line;
		BufferedReader BR1 = null;
		BufferedReader BR = null;
		String[][] Speichern = null;
		try {
			BR1 = new BufferedReader(new FileReader(Pfad));
			int z = 0;
			while ((line = BR1.readLine()) != null) {
				WieTief++;
			}
			Speichern = new String[WieTief][5];
			BR = new BufferedReader(new FileReader(Pfad));
			while ((line = BR.readLine()) != null) {
				String[] Spalten = line.split(";");
				for (int j = 0; j < 5; j++) {
					Speichern[z][j] = Spalten[j];
				}
				z++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				BR1.close();
				BR.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Kundenliste = new Benutzer[WieTief];

		for (int i = 0; i < WieTief; i++) {

			String tempVorname = Speichern[i][0];
			String tempNachname = Speichern[i][1];
			String tempUsername = Speichern[i][2];
			String tempPassword = Speichern[i][3];
			String tempGuthaben = /* Integer.parseInt( */Speichern[i][4]/* ) */;

			Benutzer temp = new Benutzer(tempVorname, tempNachname, tempUsername, tempPassword, tempGuthaben);

			Kundenliste[i] = temp;
		}
		WieTief = 0;
		return Kundenliste;
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void writeCSV(Benutzer[] Liste) {

		FileWriter writer = null;
		try {
			writer = new FileWriter("src\\projekt\\Benutzerdaten.csv");
			writer.write("");
			writer.close();
			writer = new FileWriter("src\\projekt\\Benutzerdaten.csv");

			for (int i = 0; i < Liste.length; i++) {

				writer.append("" + Liste[i].getVorname());
				writer.append(";");
				writer.append("" + Liste[i].getNachname());
				writer.append(";");
				writer.append("" + Liste[i].getUsername());
				writer.append(";");
				writer.append("" + Liste[i].getPasswort());
				writer.append(";");
				writer.append("" + Liste[i].getGuthaben());
				writer.append("\n");

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void AusgabeKundenliste() {

		Benutzer[] AListe = readCSV();

		for (int i = 0; i < AListe.length; i++) {
			System.out.println("Kunde " + i + " " + AListe[i].getVorname() + " " + AListe[i].getNachname() + " "
					+ AListe[i].getUsername() + " " + AListe[i].getPasswort() + " " + AListe[i].getGuthaben());

		}

	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static int StelleArray(String Username) {

		Benutzer[] Liste = readCSV();
		int UserID = -1;

		for (int i = 0; i < Liste.length; i++) {
			if (Username.equals(Liste[i].getUsername())) {
				UserID = i;
			}
		}

		return UserID;

	}
}
