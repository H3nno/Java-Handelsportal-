package projekt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class VerwaltungGUI {
	
	private Ware tempWare;
	private JLabel lProduktVerwaltung = new JLabel();
	private JButton bHinzufuegen = new JButton();
	private JButton bZurueck = new JButton();
	private JTextArea jBeschreibungArea = new JTextArea("");
	private JScrollPane jTextAreaScrollPane = new JScrollPane(jBeschreibungArea);
	private JList<Ware> jWarenliste = new JList<Ware>();
	private DefaultListModel<Ware> jWarenlisteModel = new DefaultListModel<>();
	private JScrollPane jBeschreibung = new JScrollPane(jWarenliste);
	private JTextField jName = new JTextField();
	private JTextField jPreis = new JTextField();
	private JLabel lName = new JLabel();
	private JLabel lPreis = new JLabel();
	private JLabel lBeschreibung = new JLabel();
	private JButton bBearbeiten = new JButton();
	private JButton bEntfernen = new JButton();
	private JButton bSpeichern = new JButton();
	private JButton bAbbrechen = new JButton();
	//private JLabel lStatusLabel = new JLabel(); tut nicht was es soll, Status label ist über dem "Speichern" Button
	public int status = 0;
	String halbGlobalNAME = "";

	JFrame verwaltungGUI = new JFrame();
	// Ende Attribute

	public VerwaltungGUI() {
		// Frame-Initialisierung
		addWaren();
		verwaltungGUI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 1011;
		int frameHeight = 730;
		verwaltungGUI.setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - verwaltungGUI.getSize().width) / 2;
		int y = (d.height - verwaltungGUI.getSize().height) / 2;
		verwaltungGUI.setLocation(x, y);
		verwaltungGUI.setTitle("Einkaufsportal");
		verwaltungGUI.setResizable(false);
		Container cp = verwaltungGUI.getContentPane();
		cp.setLayout(null);
		// Anfang Komponenten

		lProduktVerwaltung.setBounds(285, 34, 270, 76);
		lProduktVerwaltung.setText("Produkt Verwaltung");
		lProduktVerwaltung.setHorizontalAlignment(SwingConstants.CENTER);
		lProduktVerwaltung.setHorizontalTextPosition(SwingConstants.CENTER);
		lProduktVerwaltung.setFont(new Font("Dialog", Font.BOLD, 22));
		lProduktVerwaltung.setForeground(Color.BLACK);
		lProduktVerwaltung.setBackground(new Color(0xFFAFAF));
		lProduktVerwaltung.setOpaque(true);
		cp.add(lProduktVerwaltung);
		bHinzufuegen.setBounds(57, 502, 275, 49);
		bHinzufuegen.setText("Hinzufuegen");
		bHinzufuegen.setMargin(new Insets(2, 2, 2, 2));
		bHinzufuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bHinzufuegen_ActionPerformed(evt);
			}
		});
		bHinzufuegen.setBackground(Color.GREEN);
		bHinzufuegen.setFont(new Font("Dialog", Font.BOLD, 16));
		cp.add(bHinzufuegen);
		bZurueck.setBounds(78, 55, 155, 49);
		bZurueck.setText("Zurueck");
		bZurueck.setMargin(new Insets(2, 2, 2, 2));
		bZurueck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bZurueck_ActionPerformed(evt);
			}
		});
		bZurueck.setBackground(new Color(0xFFC800));
		bZurueck.setFont(new Font("Dialog", Font.BOLD, 16));
		cp.add(bZurueck);
		jTextAreaScrollPane.setBounds(390, 264, 416, 228);
		jBeschreibungArea.setEditable(false);
		cp.add(jTextAreaScrollPane);
		jWarenliste.setModel(jWarenlisteModel);
		jWarenliste.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent arg0) {
				status = 0;
				jBeschreibungArea.setEditable(false);
				jName.setEditable(false);
				jPreis.setEditable(false);

				jName.setBackground(Color.WHITE);
				jPreis.setBackground(Color.WHITE);
				jBeschreibungArea.setBackground(Color.WHITE);

				tempWare = jWarenliste.getSelectedValue();
					jName.setText(tempWare.getName());
					jPreis.setText(tempWare.getPreis());
					jBeschreibungArea.setText(tempWare.getBeschreibung());
			}
		});
		jBeschreibung.setBounds(57, 164, 302, 324);
		jBeschreibungArea.setEditable(false);
		cp.add(jBeschreibung);
		jName.setBounds(390, 188, 206, 52);
		jName.setEditable(false);
		cp.add(jName);
		jPreis.setBounds(609, 188, 195, 52);
		jPreis.setText("");
		jPreis.setEditable(false);
		cp.add(jPreis);
		lName.setBounds(390, 165, 110, 20);
		lName.setText("Name");
		cp.add(lName);
		lPreis.setBounds(609, 164, 110, 20);
		lPreis.setText("Preis");
		cp.add(lPreis);
		lBeschreibung.setBounds(390, 243, 110, 20);
		lBeschreibung.setText("Beschreibung");
		cp.add(lBeschreibung);
		bBearbeiten.setBounds(345, 502, 275, 49);
		bBearbeiten.setText("Bearbeiten");
		bBearbeiten.setMargin(new Insets(2, 2, 2, 2));
		bBearbeiten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bBearbeiten_ActionPerformed(evt);
			}
		});
		bBearbeiten.setBackground(Color.CYAN);
		cp.add(bBearbeiten);
		bEntfernen.setBounds(633, 502, 275, 49);
		bEntfernen.setText("Entfernen");
		bEntfernen.setMargin(new Insets(2, 2, 2, 2));
		bEntfernen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bEntfernen_ActionPerformed(evt);
			}
		});
		bEntfernen.setBackground(Color.RED);
		cp.add(bEntfernen);
		bSpeichern.setBounds(814, 319, 115, 41);
		bSpeichern.setText("Speichern");
		bSpeichern.setMargin(new Insets(2, 2, 2, 2));
		bSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bSpeichern_ActionPerformed(evt);
			}
		});
		cp.add(bSpeichern);


		//lStatusLabel.setBounds(814, 270, 115, 41); wie gesagt, tut nicht
		//cp.add(lStatusLabel);

		bAbbrechen.setBounds(814, 367, 115, 41);
		bAbbrechen.setText("Abbrechen");
		bAbbrechen.setMargin(new Insets(2, 2, 2, 2));
		bAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bAbbrechen_ActionPerformed(evt);
			}
		});
		cp.add(bAbbrechen);
		verwaltungGUI.setVisible(true);
	}

	// Anfang Methoden

	public void bHinzufuegen_ActionPerformed(ActionEvent evt) {
		status = 1;
		jName.setText("");
		jPreis.setText("");
		jBeschreibungArea.setText("");
		jBeschreibungArea.setEditable(true);
		jName.setEditable(true);
		jPreis.setEditable(true);
		jName.setBackground(new Color(77, 255, 77));
		jPreis.setBackground(new Color(77, 255, 77));
		jBeschreibungArea.setBackground(new Color(77, 255, 77));

	} // end of bHinzufuegen_ActionPerformed

	public void bZurueck_ActionPerformed(ActionEvent evt) {
		verwaltungGUI.dispose();
		new EinkaufsPortalGUI();

	} // end of bZurueck_ActionPerformed

	public void bBearbeiten_ActionPerformed(ActionEvent evt) {
		status = 2;

		jBeschreibungArea.setEditable(true);
		jName.setEditable(true);
		jPreis.setEditable(true);
		jName.setBackground(new Color(153, 255, 238));
		jPreis.setBackground(new Color(153, 255, 238));
		jBeschreibungArea.setBackground(new Color(153, 255, 238));

		halbGlobalNAME = jName.getText();

	} // end of bBearbeiten_ActionPerformed

	public void bEntfernen_ActionPerformed(ActionEvent evt) {
		status = 3;
		jName.setBackground(new Color(255, 66, 66));
		jPreis.setBackground(new Color(255, 66, 66));
		jBeschreibungArea.setBackground(new Color(255, 66, 66));

	} // end of bEntfernen_ActionPerformed

	public void bSpeichern_ActionPerformed(ActionEvent evt) {

		String tempName = "";
		String tempPreis = "";
		String tempBesch = "";

		switch (status) {
		case 0:
			break;
		case 1:

			tempName = jName.getText();
			tempPreis = jPreis.getText();
			tempBesch = jBeschreibungArea.getText();
			int i = 0;

			Ware tempWare = new Ware(tempName, tempPreis, tempBesch);

			Ware[] ALT = InteractWarenListe.readCSV();
			Ware[] NEU = new Ware[ALT.length + 1];

			for (i = 0; i < ALT.length; i++) {
				NEU[i] = ALT[i];

			}
			NEU[i] = tempWare;

			InteractWarenListe.writeCSV(NEU);

			break;
		case 2:

			tempName = jName.getText();
			tempPreis = jPreis.getText();
			tempBesch = jBeschreibungArea.getText();

			Ware[] Liste = InteractWarenListe.readCSV();

			int ID = InteractWarenListe.stelleArray(halbGlobalNAME);

			Liste[ID].setName(tempName);
			Liste[ID].setPreis(tempPreis);
			Liste[ID].setBeschreibung(tempBesch);
			halbGlobalNAME = "";

			InteractWarenListe.writeCSV(Liste);

			break;
		case 3:

			int WareEntfernenID = InteractWarenListe.stelleArray(jName.getText());

			Ware[] alteListe = InteractWarenListe.readCSV();
			Ware[] neueListe = new Ware[alteListe.length - 1];

			for (int z = 0; z < WareEntfernenID; z++) {
				neueListe[z] = alteListe[z];

			}
			for (int z = WareEntfernenID; z < alteListe.length - 1; z++) {
				neueListe[z] = alteListe[z + 1];

			}
			InteractWarenListe.writeCSV(neueListe);

			break;
		}

		verwaltungGUI.dispose();
		new VerwaltungGUI();
		//lStatusLabel.setText("Erfolgreich gespeichert"); funzt nicht aber status label ist theoretisch da 
		status = 0;

	} // end of bSpeichern_ActionPerformed

	public void bAbbrechen_ActionPerformed(ActionEvent evt) {
		jName.setText("");
		jPreis.setText("");
		jBeschreibungArea.setText("");
		status = 0;

		jBeschreibungArea.setEditable(false);
		jName.setEditable(false);
		jPreis.setEditable(false);

		jName.setBackground(Color.WHITE);
		jPreis.setBackground(Color.WHITE);
		jBeschreibungArea.setBackground(Color.WHITE);

	}

	public void btnNewButton_ActionPerformed(ActionEvent evt) {

	}

	public void addWaren() {
		Ware[] WarenListe = InteractWarenListe.readCSV();
		for (int i = 1; i < WarenListe.length; i++) {
			jWarenlisteModel.addElement(WarenListe[i]);
		}
	}

}