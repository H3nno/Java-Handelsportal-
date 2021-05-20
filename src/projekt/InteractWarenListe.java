package projekt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InteractWarenListe {

	static Ware[] warenliste = null;
	static int wieTief = 0;

	public static Ware[] readCSV() {

		String pfad = "src\\projekt\\WarenListe.csv";
		String line;
		BufferedReader bufferedReader1 = null;
		BufferedReader bufferedReader = null;
		String[][] speichern = null;
		try {
			bufferedReader1 = new BufferedReader(new FileReader(pfad));
			int z = 0;
			while ((line = bufferedReader1.readLine()) != null) {
				wieTief++;
			}
			speichern = new String[wieTief][3];
			bufferedReader = new BufferedReader(new FileReader(pfad));
			while ((line = bufferedReader.readLine()) != null) {
				String[] Spalten = line.split(";");
				for (int j = 0; j < 3; j++) {
					speichern[z][j] = Spalten[j];
				}
				z++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader1.close();
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		warenliste = new Ware[wieTief];

		for (int i = 0; i < wieTief; i++) {

			String tempName = speichern[i][0];
			String tempPreis = speichern[i][1];
			String tempBeschreibung = speichern[i][2];

			// int tempPreisInt = Integer.parseInt(tempPreisString);

			Ware temp = new Ware(tempName, tempPreis, tempBeschreibung);

			warenliste[i] = temp;
		}
		wieTief = 0;
		return warenliste;
	}

	public static void writeCSV(Ware[] Liste) {

		FileWriter writer = null;
		try {
			writer = new FileWriter("src\\projekt\\WarenListe.csv");
			writer.write("");
			writer.close();
			writer = new FileWriter("src\\projekt\\WarenListe.csv");

			for (int i = 0; i < Liste.length; i++) {

				writer.append("" + Liste[i].getName());
				writer.append(";");
				writer.append("" + Liste[i].getPreis());
				writer.append(";");
				writer.append("" + Liste[i].getBeschreibung());
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

	public static void ausgabeWarenliste() {

		Ware[] ausgabeWarenListe = readCSV();

		for (int i = 0; i < ausgabeWarenListe.length; i++) {
			System.out.println("WarenID" + i + " " + ausgabeWarenListe[i].getName() + " " + ausgabeWarenListe[i].getPreis() + " "
					+ ausgabeWarenListe[i].getBeschreibung());

		}

	}

	public static int stelleArray(String Name) {

		Ware[] stelleArrayListe = readCSV();
		int nameID = -1;

		for (int i = 0; i < stelleArrayListe.length; i++) {
			if (Name.equals(stelleArrayListe[i].getName())) {
				nameID = i;
			}
		}

		return nameID;

	}
}
