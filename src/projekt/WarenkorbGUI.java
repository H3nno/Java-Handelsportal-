package projekt;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;

public class WarenkorbGUI {
	// Anfang Attribute
	public static ArrayList<Ware> warenlist = new ArrayList<>();
	private JLabel lWarenkorb = new JLabel();
	private JLabel lGesamtPreis = new JLabel();
	private JButton bEinkaufabschliessen = new JButton();
	private JLabel lPreiseintragen = new JLabel();
	private JTable jTable1 = new JTable(0, 2);
	private JScrollPane jTable1ScrollPane = new JScrollPane(jTable1);
	private JLabel lblBilanz = new JLabel();
	private JLabel lPreiseintragen_1 = new JLabel();
	private JButton bEinkaufabschliessen_1 = new JButton();
	private DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
	private int preisEintragen = 0;
	private JButton bZurueck = new JButton();
	private JLabel lAktuell = new JLabel();
	private JLabel lGuthabenAktuell = new JLabel();
	private int guthabenAktl = 0;
	
	JFrame warenkorbGUI = new JFrame();
	// Ende Attribute

	public WarenkorbGUI() {
		warenkorbGUI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 596;
		int frameHeight = 856;
		warenkorbGUI.setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - warenkorbGUI.getSize().width) / 2;
		int y = (d.height - warenkorbGUI.getSize().height) / 2;
		warenkorbGUI.setLocation(x, y);
		warenkorbGUI.setTitle("JavaGUI");
		warenkorbGUI.setResizable(false);
		Container cp = warenkorbGUI.getContentPane();
		cp.setLayout(null);

		// Anfang Komponenten
		lAktuell.setBounds(24, 607, 206, 37);
		lAktuell.setText("Aktueller Guthaben");
		lAktuell.setHorizontalAlignment(SwingConstants.CENTER);
		lAktuell.setHorizontalTextPosition(SwingConstants.CENTER);
		lAktuell.setBackground(Color.CYAN);
		lAktuell.setOpaque(true);
		lAktuell.setFont(new Font("Dialog", Font.BOLD, 20));
		cp.add(lAktuell);
		
		lGuthabenAktuell.setBounds(251, 607, 239, 37);
		
		lGuthabenAktuell.setText("0�");
		lGuthabenAktuell.setHorizontalAlignment(SwingConstants.CENTER);
		lGuthabenAktuell.setHorizontalTextPosition(SwingConstants.CENTER);
		lGuthabenAktuell.setBackground(Color.CYAN);
		lGuthabenAktuell.setOpaque(true);
		lGuthabenAktuell.setFont(new Font("Dialog", Font.BOLD, 20));
		cp.add(lGuthabenAktuell);
		
		lGesamtPreis.setBounds(24, 647, 206, 37);
		lGesamtPreis.setText("Gesamt Preis");
		lGesamtPreis.setHorizontalAlignment(SwingConstants.CENTER);
		lGesamtPreis.setHorizontalTextPosition(SwingConstants.CENTER);
		lGesamtPreis.setBackground(Color.CYAN);
		lGesamtPreis.setOpaque(true);
		lGesamtPreis.setFont(new Font("Dialog", Font.BOLD, 20));
		cp.add(lGesamtPreis);
		bEinkaufabschliessen.setBounds(24, 743, 461, 58);
		bEinkaufabschliessen.setText("Einkaufabschlie�en");
		bEinkaufabschliessen.setMargin(new Insets(2, 2, 2, 2));
		bEinkaufabschliessen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bEinkaufabschliessen_ActionPerformed(evt);
			}
		});
		bEinkaufabschliessen.setBackground(new Color(0xFFC800));
		bEinkaufabschliessen.setFont(new Font("Dialog", Font.BOLD, 22));
		cp.add(bEinkaufabschliessen);
		
		bZurueck.setBounds(24, 24, 90, 35);
		bZurueck.setText("Zurueck");
		bZurueck.setMargin(new Insets(2, 2, 2, 2));
		bZurueck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bZurueck_ActionPerformed(evt);
			}
		});
		bZurueck.setBackground(new Color(0xFFC800));
		bZurueck.setFont(new Font("Dialog", Font.BOLD, 18));
		cp.add(bZurueck);
		
		lPreiseintragen.setBounds(251, 647, 239, 36);
		lPreiseintragen.setText(Integer.toString(preisEintragen) + "�");
		lPreiseintragen.setFont(new Font("Dialog", Font.BOLD, 22));
		lPreiseintragen.setBackground(Color.CYAN);
		lPreiseintragen.setOpaque(true);
		lPreiseintragen.setHorizontalAlignment(SwingConstants.CENTER);
		lPreiseintragen.setHorizontalTextPosition(SwingConstants.CENTER);
		cp.add(lPreiseintragen);
		jTable1ScrollPane.setBounds(20, 103, 468, 470);
		jTable1.getColumnModel().getColumn(0).setHeaderValue("Artikel");
		jTable1.getColumnModel().getColumn(1).setHeaderValue("Preis");
		jTable1.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		jTable1.setToolTipText("Warenkorb");
		jTable1.setRowHeight(25);
		jTable1.setDefaultEditor(Object.class, null);

		for (Ware ware : warenlist) {
			Vector<String> row = new Vector<String>();
			row.add(ware.getName());
			row.add(ware.getPreis());
			preisEintragen = preisEintragen + Integer.parseInt(ware.getPreis());/////////////////////////////
			lPreiseintragen.setText(Integer.toString(preisEintragen) + "�");
			model.addRow(row);
		}
		cp.add(jTable1ScrollPane);
		lWarenkorb.setBounds(149, 15, 342, 76);
		lWarenkorb.setText("Warenkorb");
		lWarenkorb.setHorizontalAlignment(SwingConstants.CENTER);
		lWarenkorb.setHorizontalTextPosition(SwingConstants.CENTER);
		lWarenkorb.setBackground(Color.pink);
		lWarenkorb.setOpaque(true);
		lWarenkorb.setFont(new Font("Dialog", Font.BOLD, 20));
		cp.add(lWarenkorb);

		bEinkaufabschliessen_1.setText("-");
		bEinkaufabschliessen_1.setMargin(new Insets(2, 2, 2, 2));
		bEinkaufabschliessen_1.setFont(new Font("Dialog", Font.BOLD, 22));
		bEinkaufabschliessen_1.setBackground(Color.RED);
		bEinkaufabschliessen_1.setBounds(496, 100, 26, 20);
		bEinkaufabschliessen_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bEinkaufabschliessen_1_ActionPerformed(evt);
			}
		});
		warenkorbGUI.getContentPane().add(bEinkaufabschliessen_1);

		lblBilanz.setText("Bilanz");
		lblBilanz.setOpaque(true);
		lblBilanz.setHorizontalTextPosition(SwingConstants.CENTER);
		lblBilanz.setHorizontalAlignment(SwingConstants.CENTER);
		lblBilanz.setFont(new Font("Dialog", Font.BOLD, 20));
		lblBilanz.setBackground(Color.CYAN);
		lblBilanz.setBounds(24, 686, 206, 37);
		warenkorbGUI.getContentPane().add(lblBilanz);

		lPreiseintragen_1.setText("0�");
		lPreiseintragen_1.setOpaque(true);
		lPreiseintragen_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lPreiseintragen_1.setHorizontalAlignment(SwingConstants.CENTER);
		lPreiseintragen_1.setFont(new Font("Dialog", Font.BOLD, 22));
		lPreiseintragen_1.setBackground(Color.CYAN);
		lPreiseintragen_1.setBounds(251, 686, 239, 36);
		warenkorbGUI.getContentPane().add(lPreiseintragen_1);
		// Ende Komponenten
		datenLaden();
		warenkorbGUI.setVisible(true);
	}

	public void datenLaden() {
		String username = LoginGUI.globalNAME;
		int stelle = InteractBenutzerdaten.stelleArray(username);
		Benutzer[] datenLadenListe = InteractBenutzerdaten.readCSV();
		int bilanz = preisEintragen;
		int aktguthaben;
		guthabenAktl = Integer.parseInt(datenLadenListe[stelle].getGuthaben());
		lGuthabenAktuell.setText(guthabenAktl + "�");
		try {
			aktguthaben = Integer.parseInt(datenLadenListe[stelle].getGuthaben());
			bilanz = aktguthaben - bilanz;
		} catch (NumberFormatException e) {
			System.out.println(e);
		}

		if (stelle != -1) {
			// preisEintragen
			lPreiseintragen_1.setText(bilanz + "�");
		}
		lPreiseintragen.setText(Integer.toString(preisEintragen) + "�");
	}

	public JFrame getWarenkorb() {
		return warenkorbGUI;
	}

	public void bEinkaufabschliessen_ActionPerformed(ActionEvent evt) {
		String username = LoginGUI.globalNAME;
		int stelle = InteractBenutzerdaten.stelleArray(username);
		Benutzer[] kaufAbschlussListe = InteractBenutzerdaten.readCSV();
		if (stelle != -1) {
			kaufAbschlussListe[stelle].setGuthaben(Integer.toString(guthabenAktl - preisEintragen));
			InteractBenutzerdaten.writeCSV(kaufAbschlussListe);
		}
		int rows1 = jTable1.getRowCount();
		for (int i = rows1 - 1; i >= 0; i--) {
			model.removeRow(i);
			warenlist.remove(i);
		}
		warenkorbGUI.dispose();
		new EinkaufsPortalGUI();
	}

	public void bEinkaufabschliessen_1_ActionPerformed(ActionEvent evt) {
		int[] rows = jTable1.getSelectedRows();
		for (int i = rows.length - 1; i >= 0; i--) {
			model.removeRow(rows[i]);
			preisEintragen = preisEintragen - Integer.parseInt(warenlist.get(i).getPreis());////////////merken
			warenlist.remove(i);
		}
		datenLaden();
	}
	
	
	
	//public void warenkorbLeeren() {
		//int[] rows = jTable1.getSelectedRows();
		//for (int i = rows.length - 1; i >= 0; i--) {
			//model.removeRow(rows[i]); //////////////DA M�SSEN WIR NOCH DRAN!!!!!!!!!!!!!!!!!! 
			//warenlist.remove(i);
//		}

	//}
	
	public void bZurueck_ActionPerformed(ActionEvent evt) {
		warenkorbGUI.dispose();
		new EinkaufsPortalGUI();
	}

}