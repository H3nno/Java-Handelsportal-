package projekt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InteractWarenListe {

	static Ware[] Warenliste = null;
	static int WieTief = 0;

	public static Ware[] readCSV() {

		String Pfad = "src\\projekt\\WarenListe.csv";
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
			Speichern = new String[WieTief][3];
			BR = new BufferedReader(new FileReader(Pfad));
			while ((line = BR.readLine()) != null) {
				String[] Spalten = line.split(";");
				for (int j = 0; j < 3; j++) {
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

		Warenliste = new Ware[WieTief];

		for (int i = 0; i < WieTief; i++) {

			String tempName = Speichern[i][0];
			String tempPreis = Speichern[i][1];
			String tempBeschreibung = Speichern[i][2];

			// int tempPreisInt = Integer.parseInt(tempPreisString);

			Ware temp = new Ware(tempName, tempPreis, tempBeschreibung);

			Warenliste[i] = temp;
		}
		WieTief = 0;
		return Warenliste;
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

		Ware[] AListe = readCSV();

		for (int i = 0; i < AListe.length; i++) {
			System.out.println("WarenID" + i + " " + AListe[i].getName() + " " + AListe[i].getPreis() + " "
					+ AListe[i].getBeschreibung());

		}

	}

	public static int stelleArray(String Name) {

		Ware[] Liste = readCSV();
		int NameID = -1;

		for (int i = 0; i < Liste.length; i++) {
			if (Name.equals(Liste[i].getName())) {
				NameID = i;
			}
		}

		return NameID;

	}
}
