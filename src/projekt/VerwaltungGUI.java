package projekt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 25.03.2021
 * @author
 */

public class VerwaltungGUI {
	// Anfang Attribute
	private JLabel lEinkaufsportal = new JLabel();
	private JButton bHinzufuegen = new JButton();
	private JButton bZurueck = new JButton();
	private JTextArea jTextArea1 = new JTextArea("");
	private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
	private JList<Ware> jList1 = new JList();
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

	JFrame VerwaltungGUI = new JFrame();
	// Ende Attribute

	public VerwaltungGUI() {
		// Frame-Initialisierung
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

		lEinkaufsportal.setBounds(285, 34, 270, 76);
		lEinkaufsportal.setText("Einkaufsportal");
		lEinkaufsportal.setHorizontalAlignment(SwingConstants.CENTER);
		lEinkaufsportal.setHorizontalTextPosition(SwingConstants.CENTER);
		lEinkaufsportal.setFont(new Font("Dialog", Font.BOLD, 22));
		lEinkaufsportal.setForeground(Color.BLACK);
		lEinkaufsportal.setBackground(new Color(0xFFAFAF));
		lEinkaufsportal.setOpaque(true);
		cp.add(lEinkaufsportal);
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
		jName.setBackground(new Color(77, 255, 77));
		jTpreis.setBackground(new Color(77, 255, 77));
		jTextArea1.setBackground(new Color(77, 255, 77));

	} // end of bHinzufuegen_ActionPerformed

	public void bZurueck_ActionPerformed(ActionEvent evt) {
		// TODO hier Quelltext einfügen

	} // end of bZurueck_ActionPerformed

	public void bBearbeiten_ActionPerformed(ActionEvent evt) {
		jName.setBackground(new Color(153, 255, 238));
		jTpreis.setBackground(new Color(153, 255, 238));
		jTextArea1.setBackground(new Color(153, 255, 238));

	} // end of bBearbeiten_ActionPerformed

	public void bEntfernen_ActionPerformed(ActionEvent evt) {
		jName.setBackground(new Color(255, 66, 66));
		jTpreis.setBackground(new Color(255, 66, 66));
		jTextArea1.setBackground(new Color(255, 66, 66));

	} // end of bEntfernen_ActionPerformed

	public void bSpeichern_ActionPerformed(ActionEvent evt) {
		// TODO hier Quelltext einfügen

	} // end of bSpeichern_ActionPerformed

	public void bAbbrechen_ActionPerformed(ActionEvent evt) {
		// TODO hier Quelltext einfügen

	} // end of bAbbrechen_ActionPerformed

	// Ende Methoden
} // end of class Einkaufsporta