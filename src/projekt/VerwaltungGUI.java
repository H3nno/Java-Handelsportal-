package projekt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class VerwaltungGUI {
	// Anfang Attribute
	//private Ware[] wareAtemp;
	private Ware temp;
	private JLabel lProduktVerwaltung = new JLabel();
	private JButton bHinzufuegen = new JButton();
	private JButton bZurueck = new JButton();
	private JTextArea jTextArea1 = new JTextArea("");
	private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
	private JList<Ware> jList1 = new JList<Ware>();
	private DefaultListModel<Ware> jList1Model = new DefaultListModel<>();
	private JScrollPane jBeschreibung = new JScrollPane(jList1);
	private JTextField jName = new JTextField();
	private JTextField jTpreis = new JTextField();
	private JLabel lName = new JLabel();
	private JLabel lPreis = new JLabel();
	private JLabel lBeschreibung = new JLabel();
	private JButton bBearbeiten = new JButton();
	private JButton bEntfernen = new JButton();
	private JButton bSpeichern = new JButton();
	private JButton bAbbrechen = new JButton();
	
	private JLabel StatusLabel = new JLabel();
	
	public int status = 0;
	String NAME = "";

	JFrame VerwaltungGUI = new JFrame();
	// Ende Attribute

	public VerwaltungGUI() {
		// Frame-Initialisierung
		addWaren();
		VerwaltungGUI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 1011;
		int frameHeight = 730;
		VerwaltungGUI.setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - VerwaltungGUI.getSize().width) / 2;
		int y = (d.height - VerwaltungGUI.getSize().height) / 2;
		VerwaltungGUI.setLocation(x, y);
		VerwaltungGUI.setTitle("Einkaufsportal");
		VerwaltungGUI.setResizable(false);
		Container cp = VerwaltungGUI.getContentPane();
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
		jTextArea1ScrollPane.setBounds(390, 264, 416, 228);
		jTextArea1.setEditable(false);
		cp.add(jTextArea1ScrollPane);
		jList1.setModel(jList1Model);
		jList1.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent arg0) {
				status = 0;
				jTextArea1.setEditable(false);
				jName.setEditable(false);
				jTpreis.setEditable(false);
				
				
				jName.setBackground(Color.WHITE);
				jTpreis.setBackground(Color.WHITE);
				jTextArea1.setBackground(Color.WHITE);
				
				
				temp = jList1.getSelectedValue();
				jTextArea1.setText(temp.getBeschreibung());
				jName.setText(temp.getName());
				jTpreis.setText(temp.getPreis() + " €");
			}
		});
		jBeschreibung.setBounds(57, 164, 302, 324);
		cp.add(jBeschreibung);
		jName.setBounds(390, 188, 206, 52);
		cp.add(jName);
		jTpreis.setBounds(609, 188, 195, 52);
		jTpreis.setText("");
		cp.add(jTpreis);
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
		
		StatusLabel.setText("Status Text: qTEST");
		StatusLabel.setBounds(814, 270,115,41);
		cp.add(StatusLabel);
		
		
		
		bAbbrechen.setBounds(814, 367, 115, 41);
		bAbbrechen.setText("Abbrechen");
		bAbbrechen.setMargin(new Insets(2, 2, 2, 2));
		bAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bAbbrechen_ActionPerformed(evt);
			}
		});
		cp.add(bAbbrechen);

		// Ende Komponenten

		VerwaltungGUI.setVisible(true);
	} // end of public Einkaufsportal

	// Anfang Methoden

	public void bHinzufuegen_ActionPerformed(ActionEvent evt) {
		status = 1;
		jName.setText("");
		jTpreis.setText("");
		jTextArea1.setText("");
		
		jTextArea1.setEditable(true);
		jName.setEditable(true);
		jTpreis.setEditable(true);
		
		
		jName.setBackground(new Color(77, 255, 77));
		jTpreis.setBackground(new Color(77, 255, 77));
		jTextArea1.setBackground(new Color(77, 255, 77));
		
		
		
		

	} // end of bHinzufuegen_ActionPerformed

	public void bZurueck_ActionPerformed(ActionEvent evt) {
		VerwaltungGUI.dispose();
		new EinkaufsPortalGUI();

	} // end of bZurueck_ActionPerformed

	public void bBearbeiten_ActionPerformed(ActionEvent evt) {
		status = 2;
		
		jTextArea1.setEditable(true);
		jName.setEditable(true);
		jTpreis.setEditable(true);
		jName.setBackground(new Color(153, 255, 238));
		jTpreis.setBackground(new Color(153, 255, 238));
		jTextArea1.setBackground(new Color(153, 255, 238));
		
		NAME = jName.getText();

	} // end of bBearbeiten_ActionPerformed

	public void bEntfernen_ActionPerformed(ActionEvent evt) {
		status = 3;
		jName.setBackground(new Color(255, 66, 66));
		jTpreis.setBackground(new Color(255, 66, 66));
		jTextArea1.setBackground(new Color(255, 66, 66));

	} // end of bEntfernen_ActionPerformed

	public void bSpeichern_ActionPerformed(ActionEvent evt) {

		String tempName = "";
		String tempPreis = "";
		String tempBesch = "";
		
		
		
		switch(status) {
		case 0:
			break;
		case 1:
			
			tempName = jName.getText();
			tempPreis = jTpreis.getText();
			tempBesch = jTextArea1.getText();
			int i = 0;
			
			Ware tempWare = new Ware(tempName,tempPreis,tempBesch);
			
			Ware[] ALT = InteractWarenListe.readCSV();
			Ware[] NEU = new Ware[ALT.length + 1];
			
			for(i = 0; i<ALT.length; i++) {
				NEU[i] = ALT[i];
				
			}
			NEU[i] = tempWare;
			
			InteractWarenListe.writeCSV(NEU);
			
			
			
			
			
			
			break;
		case 2:
			
			tempName = jName.getText();
			tempPreis = jTpreis.getText();
			tempBesch = jTextArea1.getText();
			
			Ware[] Liste = InteractWarenListe.readCSV();
			
			int ID = InteractWarenListe.StelleArray(NAME);
			
			Liste[ID].setName(tempName);
			Liste[ID].setPreis(tempPreis);
			Liste[ID].setBeschreibung(tempBesch);
			NAME = "";
			
			InteractWarenListe.writeCSV(Liste);
			
			
			break;
		case 3:
			
			
			
			
			break;
	}
		
		
		
		addWaren(); // @FINN gibts dazu nen pendant das man alles entfernt? erst entfernen danach mit addWaren() die gesamte Liste inkl neues Item neu anzeigen
		status = 0;

	} // end of bSpeichern_ActionPerformed

	public void bAbbrechen_ActionPerformed(ActionEvent evt) {
		// TODO hier Quelltext einfügen

	}

	public void btnNewButton_ActionPerformed(ActionEvent evt) {

	}

	public void addWaren() {
		Ware[] WarenListe = InteractWarenListe.readCSV();
		for (int i = 1; i < WarenListe.length; i++) {
			jList1Model.addElement(WarenListe[i]);
		}
	}

	public Ware[] statusAbfrage(int status) { //versteh ich nicht? switch case doch direkt in den "Speichern" Button /HS @Finn
		Ware[] WarenListe = InteractWarenListe.readCSV();
		switch(status) {
			case 0:
				break;
			case 1:
			
				
				break;
			case 2:
				break;
			case 3:
				break;
		}
		return WarenListe;
	}
} // end of class Einkaufsporta