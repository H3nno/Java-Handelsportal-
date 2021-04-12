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

	JFrame Warenkorb = new JFrame();
	// Ende Attribute

	public WarenkorbGUI() {
		Warenkorb.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 536;
		int frameHeight = 796;
		Warenkorb.setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - Warenkorb.getSize().width) / 2;
		int y = (d.height - Warenkorb.getSize().height) / 2;
		Warenkorb.setLocation(x, y);
		Warenkorb.setTitle("JavaGUI");
		Warenkorb.setResizable(false);
		Container cp = Warenkorb.getContentPane();
		cp.setLayout(null);

		// Anfang Komponenten
		lGesamtPreis.setBounds(24, 591, 206, 37);
		lGesamtPreis.setText("Gesamt Preis");
		lGesamtPreis.setHorizontalAlignment(SwingConstants.CENTER);
		lGesamtPreis.setHorizontalTextPosition(SwingConstants.CENTER);
		lGesamtPreis.setBackground(Color.CYAN);
		lGesamtPreis.setOpaque(true);
		lGesamtPreis.setFont(new Font("Dialog", Font.BOLD, 20));
		cp.add(lGesamtPreis);
		bEinkaufabschliessen.setBounds(24, 683, 461, 58);
		bEinkaufabschliessen.setText("Einkaufabschlieﬂen");
		bEinkaufabschliessen.setMargin(new Insets(2, 2, 2, 2));
		bEinkaufabschliessen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bEinkaufabschliessen_ActionPerformed(evt);
			}
		});
		bEinkaufabschliessen.setBackground(new Color(0xFFC800));
		bEinkaufabschliessen.setFont(new Font("Dialog", Font.BOLD, 22));
		cp.add(bEinkaufabschliessen);
		lPreiseintragen.setBounds(251, 592, 239, 36);
		lPreiseintragen.setText(Integer.toString(preisEintragen) + "Ä");
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
			Vector row = new Vector();
			row.add(ware.getName());
			row.add(ware.getPreis());
			preisEintragen = preisEintragen + Integer.parseInt(ware.getPreis());/////////////////////////////
			lPreiseintragen.setText(Integer.toString(preisEintragen) + "Ä");
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
		Warenkorb.getContentPane().add(bEinkaufabschliessen_1);

		lblBilanz.setText("Bilanz");
		lblBilanz.setOpaque(true);
		lblBilanz.setHorizontalTextPosition(SwingConstants.CENTER);
		lblBilanz.setHorizontalAlignment(SwingConstants.CENTER);
		lblBilanz.setFont(new Font("Dialog", Font.BOLD, 20));
		lblBilanz.setBackground(Color.CYAN);
		lblBilanz.setBounds(24, 636, 206, 37);
		Warenkorb.getContentPane().add(lblBilanz);

		lPreiseintragen_1.setText("0Ä");
		lPreiseintragen_1.setOpaque(true);
		lPreiseintragen_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lPreiseintragen_1.setHorizontalAlignment(SwingConstants.CENTER);
		lPreiseintragen_1.setFont(new Font("Dialog", Font.BOLD, 22));
		lPreiseintragen_1.setBackground(Color.CYAN);
		lPreiseintragen_1.setBounds(251, 637, 239, 36);
		Warenkorb.getContentPane().add(lPreiseintragen_1);
		// Ende Komponenten
		Datenladen();
		Warenkorb.setVisible(true);
	}

	public void Datenladen() {
		String Username = LoginGUI.NAME;
		int Stelle = InteractBenutzerdaten.StelleArray(Username);
		Benutzer[] Liste = InteractBenutzerdaten.readCSV();
		int bilanz = preisEintragen;
		int aktguthaben;
		try {
			aktguthaben = Integer.parseInt(Liste[Stelle].getGuthaben());
			bilanz = aktguthaben - bilanz;
		} catch (NumberFormatException e) {
			System.out.println(e);
		}

		if (Stelle != -1) {
			// preisEintragen
			lPreiseintragen_1.setText(bilanz + "Ä");
		}
		lPreiseintragen.setText(Integer.toString(preisEintragen) + "Ä");
	}

	public JFrame getWarenkorb() {
		return Warenkorb;
	}

	public void bEinkaufabschliessen_ActionPerformed(ActionEvent evt) {
		Warenkorb.dispose();
		new EinkaufsPortalGUI();

	}

	public void bEinkaufabschliessen_1_ActionPerformed(ActionEvent evt) {
		int[] rows = jTable1.getSelectedRows();
		for (int i = 0; i < rows.length; i++) {
			model.removeRow(rows[i] - i);
			preisEintragen = preisEintragen - Integer.parseInt(warenlist.get(i).getPreis()); /////////////////////////////////////////
			warenlist.remove(i);

		}
		Datenladen();
	}

}