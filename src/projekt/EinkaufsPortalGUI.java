package projekt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class EinkaufsPortalGUI {
	private JLabel lEinkaufsportal = new JLabel();
	private JButton bWarenkorbhinzufuegen = new JButton();
	private JButton bZumWarenkorb = new JButton();
	private JButton admin = new JButton();
	private Ware temp;
	private JLabel AngemeldetAls = new JLabel();
	private JButton Benutzerverwaltung = new JButton();
	private JButton Abmelden = new JButton();
	private JLabel lblNewLabel = new JLabel("Artikel im Warenkorb : " + WarenkorbGUI.warenlist.size());
	private JLabel lblNewLabel_1 = new JLabel("Guthaben : ");

	private JTextField jNAME = new JTextField();
	private JTextField jPREIS = new JTextField();

	private JTextArea jTextArea1 = new JTextArea("");
	private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
	private JList<Ware> list_1 = new JList<Ware>();
	// Ende Attribute
	DefaultListModel<Ware> Modell = new DefaultListModel<>();
	JFrame EinkaufsPortal = new JFrame();

	public EinkaufsPortalGUI() {
		// Waren erschaffen
		addWaren();
		// Frame-Initialisierung
		EinkaufsPortal.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 891;
		int frameHeight = 600;
		EinkaufsPortal.setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - EinkaufsPortal.getSize().width) / 2;
		int y = (d.height - EinkaufsPortal.getSize().height) / 2;
		EinkaufsPortal.setLocation(x, y);
		EinkaufsPortal.setTitle("Einkaufsportal");
		EinkaufsPortal.setResizable(true);
		Container cp = EinkaufsPortal.getContentPane();
		cp.setLayout(null);

		// Anfang Komponenten
		// JList addElement
		list_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				temp = list_1.getSelectedValue();
				jTextArea1.setText(temp.getBeschreibung());
				jNAME.setText(temp.getName());
				jPREIS.setText(temp.getPreis() + " €");
			}
		});
		jTextArea1.setEditable(false);

		list_1.setModel(Modell);
		list_1.setBounds(24, 148, 338, 324);
		EinkaufsPortal.getContentPane().add(list_1);
		lEinkaufsportal.setBounds(285, 34, 270, 76);
		lEinkaufsportal.setText("Einkaufsportal");
		lEinkaufsportal.setHorizontalAlignment(SwingConstants.CENTER);
		lEinkaufsportal.setHorizontalTextPosition(SwingConstants.CENTER);
		lEinkaufsportal.setFont(new Font("Dialog", Font.BOLD, 22));
		lEinkaufsportal.setForeground(Color.BLACK);
		lEinkaufsportal.setBackground(new Color(0xFFAFAF));
		lEinkaufsportal.setOpaque(true);
		cp.add(lEinkaufsportal);
		admin.setBounds(24, 28, 150, 50);
		admin.setText("Verwaltung");
		admin.setBackground(Color.CYAN);
		admin.setMargin(new Insets(2, 2, 2, 2));
		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				admin_ActionPerformed(evt);
			}
		});
		if (LoginGUI.NAME.equals("admin")) {
			cp.add(admin);
		}

		AngemeldetAls.setBounds(700, 10, 150, 30);
		AngemeldetAls.setText("Angemeldet als: " + LoginGUI.NAME);

		cp.add(AngemeldetAls);

		Benutzerverwaltung.setBounds(700, 50, 150, 30);
		Benutzerverwaltung.setText("Benutzerverwaltung");
		Benutzerverwaltung.setBackground(Color.CYAN);
		Benutzerverwaltung.setMargin(new Insets(2, 2, 2, 2));
		Benutzerverwaltung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				benutzerverwaltung_ActionPerformed(evt);
			}
		});
		cp.add(Benutzerverwaltung);

		Abmelden.setBounds(700, 90, 150, 30);
		Abmelden.setText("Abmelden");
		Abmelden.setBackground(Color.CYAN);
		Abmelden.setMargin(new Insets(2, 2, 2, 2));
		Abmelden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				abmelden_ActionPerformed(evt);
			}
		});
		cp.add(Abmelden);

		bWarenkorbhinzufuegen.setBounds(59, 478, 291, 65);
		bWarenkorbhinzufuegen.setText("ZumWarenkorb hinzufuegen");
		bWarenkorbhinzufuegen.setMargin(new Insets(2, 2, 2, 2));
		bWarenkorbhinzufuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bWarenkorbhinzufuegen_ActionPerformed(evt);
			}
		});
		bWarenkorbhinzufuegen.setBackground(new Color(0xFFC800));
		bWarenkorbhinzufuegen.setFont(new Font("Dialog", Font.BOLD, 16));
		cp.add(bWarenkorbhinzufuegen);
		bZumWarenkorb.setBounds(700, 478, 155, 49);
		bZumWarenkorb.setText("Zum Warenkorb");
		bZumWarenkorb.setMargin(new Insets(2, 2, 2, 2));
		bZumWarenkorb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bZumWarenkorb_ActionPerformed(evt);
			}
		});
		bZumWarenkorb.setBackground(new Color(0xFFC800));
		bZumWarenkorb.setFont(new Font("Dialog", Font.BOLD, 16));
		cp.add(bZumWarenkorb);

		jNAME.setFont(new Font("Dialog", Font.BOLD, 16));
		jPREIS.setFont(new Font("Dialog", Font.BOLD, 16));
		jNAME.setBounds(378, 148, 208, 48);
		jPREIS.setBounds(588, 148, 208, 48);
		jPREIS.setEditable(false);
		jNAME.setEditable(false);

		cp.add(jPREIS);
		cp.add(jNAME);

		jTextArea1ScrollPane.setBounds(378, 208, 416, 264);
		cp.add(jTextArea1ScrollPane);

		lblNewLabel.setBounds(700, 530, 155, 13);
		cp.add(lblNewLabel);
		lblNewLabel_1.setBounds(700, 34, 150, 13);
		cp.add(lblNewLabel_1);

		// Ende Komponenten
		datenLaden();
		EinkaufsPortal.setVisible(true);
	} // end of public Einkaufsportal

	// Anfang Methoden

	public void bWarenkorbhinzufuegen_ActionPerformed(ActionEvent evt) {
		WarenkorbGUI.warenlist.add(temp);
		lblNewLabel.setText("Artikel im Warenkorb : " + WarenkorbGUI.warenlist.size());

	} // end of bWarenkorbhinzufuegen_ActionPerformed

	public void bZumWarenkorb_ActionPerformed(ActionEvent evt) {
		new WarenkorbGUI();
		EinkaufsPortal.dispose();

	}

	public void admin_ActionPerformed(ActionEvent evt) {

		if (LoginGUI.NAME != null) {

			if (LoginGUI.NAME.equals("admin")) {
				new VerwaltungGUI();
				EinkaufsPortal.dispose();
			}
		}

	}

	public void datenLaden() {
		String Username = LoginGUI.NAME;
		int Stelle = InteractBenutzerdaten.stelleArray(Username);
		Benutzer[] Liste = InteractBenutzerdaten.readCSV();

		if (Stelle != -1) {

			lblNewLabel_1.setText("Guthaben : " + Liste[Stelle].getGuthaben());
		}
	}

	public void abmelden_ActionPerformed(ActionEvent evt) {
		new LoginGUI();
		EinkaufsPortal.dispose();

	}

	public void benutzerverwaltung_ActionPerformed(ActionEvent evt) {
		EinkaufsPortal.dispose();
		new BenutzerverwaltungGUI();

	}

	public void addWaren() {
		Ware[] WarenListe = InteractWarenListe.readCSV();

		for (int i = 1; i < WarenListe.length; i++) {
			Modell.addElement(WarenListe[i]);
		}

	}

}
