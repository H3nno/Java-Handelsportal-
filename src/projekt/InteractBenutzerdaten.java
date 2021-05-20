package projekt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InteractBenutzerdaten {

	static Benutzer[] kundenliste = null;
	static int wieTief = 0;

	public static Benutzer[] readCSV() { // vorübergehend Static

		String pfad = "src\\projekt\\Benutzerdaten.csv";
		String line;
		BufferedReader bufferedReader2 = null;
		BufferedReader bufferedReader = null;
		String[][] speichern = null;
		try {
			bufferedReader2 = new BufferedReader(new FileReader(pfad));
			int z = 0;
			while ((line = bufferedReader2.readLine()) != null) {
				wieTief++;
			}
			speichern = new String[wieTief][5];
			bufferedReader = new BufferedReader(new FileReader(pfad));
			while ((line = bufferedReader.readLine()) != null) {
				String[] Spalten = line.split(";");
				for (int j = 0; j < 5; j++) {
					speichern[z][j] = Spalten[j];
				}
				z++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader2.close();
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		kundenliste = new Benutzer[wieTief];

		for (int i = 0; i < wieTief; i++) {

			String tempVorname = speichern[i][0];
			String tempNachname = speichern[i][1];
			String tempUsername = speichern[i][2];
			String tempPassword = speichern[i][3];
			String tempGuthaben = /* Integer.parseInt( */speichern[i][4]/* ) */;

			Benutzer temp = new Benutzer(tempVorname, tempNachname, tempUsername, tempPassword, tempGuthaben);

			kundenliste[i] = temp;
		}
		wieTief = 0;
		return kundenliste;
	}

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

	public static void ausgabeKundenliste() {

		Benutzer[] ausgabeKundenListe = readCSV();

		for (int i = 0; i < ausgabeKundenListe.length; i++) {
			System.out.println("Kunde " + i + " " + ausgabeKundenListe[i].getVorname() + " " + ausgabeKundenListe[i].getNachname() + " "
					+ ausgabeKundenListe[i].getUsername() + " " + ausgabeKundenListe[i].getPasswort() + " " + ausgabeKundenListe[i].getGuthaben());

		}

	}

	public static int stelleArray(String Username) {

		Benutzer[] stelleArrayListe = readCSV();
		int userID = -1;

		for (int i = 0; i < stelleArrayListe.length; i++) {
			if (Username.equals(stelleArrayListe[i].getUsername())) {
				userID = i;
			}
		}

		return userID;

	}
}
