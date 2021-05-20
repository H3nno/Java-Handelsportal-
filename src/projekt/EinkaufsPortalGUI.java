package projekt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class EinkaufsPortalGUI {
	private JLabel lEinkaufsportal = new JLabel();
	private JButton bWarenkorbhinzufuegen = new JButton();
	private JButton bZumWarenkorb = new JButton();
	private JButton bAdmin = new JButton();
	private Ware tempWare;
	private JLabel lAngemeldetAls = new JLabel();
	private JButton bBenutzerverwaltung = new JButton();
	private JButton bAbmelden = new JButton();
	private JLabel lArtInKorb = new JLabel("Artikel im Warenkorb : " + WarenkorbGUI.warenlist.size());
	private JLabel lGuthaben = new JLabel("Guthaben : ");

	private JTextField jNAME = new JTextField();
	private JTextField jPREIS = new JTextField();

	private JTextArea jTextArea = new JTextArea("");
	private JScrollPane jTextAreaScrollPane = new JScrollPane(jTextArea);
	private JList<Ware> jListeWare = new JList<Ware>();
	// Ende Attribute
	DefaultListModel<Ware> listModelWare = new DefaultListModel<>();
	JFrame einkaufsPortal = new JFrame();

	public EinkaufsPortalGUI() {
		// Waren erschaffen
		addWaren();
		// Frame-Initialisierung
		einkaufsPortal.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 891;
		int frameHeight = 600;
		einkaufsPortal.setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - einkaufsPortal.getSize().width) / 2;
		int y = (d.height - einkaufsPortal.getSize().height) / 2;
		einkaufsPortal.setLocation(x, y);
		einkaufsPortal.setTitle("Einkaufsportal");
		einkaufsPortal.setResizable(true);
		Container cp = einkaufsPortal.getContentPane();
		cp.setLayout(null);

		// Anfang Komponenten
		// JList addElement
		jListeWare.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				tempWare = jListeWare.getSelectedValue();
				jTextArea.setText(tempWare.getBeschreibung());
				jNAME.setText(tempWare.getName());
				jPREIS.setText(tempWare.getPreis() + " €");
			}
		});
		jTextArea.setEditable(false);

		jListeWare.setModel(listModelWare);
		jListeWare.setBounds(24, 148, 338, 324);
		einkaufsPortal.getContentPane().add(jListeWare);
		lEinkaufsportal.setBounds(285, 34, 270, 76);
		lEinkaufsportal.setText("Einkaufsportal");
		lEinkaufsportal.setHorizontalAlignment(SwingConstants.CENTER);
		lEinkaufsportal.setHorizontalTextPosition(SwingConstants.CENTER);
		lEinkaufsportal.setFont(new Font("Dialog", Font.BOLD, 22));
		lEinkaufsportal.setForeground(Color.BLACK);
		lEinkaufsportal.setBackground(new Color(0xFFAFAF));
		lEinkaufsportal.setOpaque(true);
		cp.add(lEinkaufsportal);
		bAdmin.setBounds(24, 28, 150, 50);
		bAdmin.setText("Verwaltung");
		bAdmin.setBackground(Color.CYAN);
		bAdmin.setMargin(new Insets(2, 2, 2, 2));
		bAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				admin_ActionPerformed(evt);
			}
		});
		if (LoginGUI.globalNAME.equals("admin")) {
			cp.add(bAdmin);
		}

		lAngemeldetAls.setBounds(700, 10, 150, 30);
		lAngemeldetAls.setText("Angemeldet als: " + LoginGUI.globalNAME);

		cp.add(lAngemeldetAls);

		bBenutzerverwaltung.setBounds(700, 50, 150, 30);
		bBenutzerverwaltung.setText("Benutzerverwaltung");
		bBenutzerverwaltung.setBackground(Color.CYAN);
		bBenutzerverwaltung.setMargin(new Insets(2, 2, 2, 2));
		bBenutzerverwaltung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				benutzerverwaltung_ActionPerformed(evt);
			}
		});
		cp.add(bBenutzerverwaltung);

		bAbmelden.setBounds(700, 90, 150, 30);
		bAbmelden.setText("Abmelden");
		bAbmelden.setBackground(Color.CYAN);
		bAbmelden.setMargin(new Insets(2, 2, 2, 2));
		bAbmelden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				abmelden_ActionPerformed(evt);
			}
		});
		cp.add(bAbmelden);

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

		jTextAreaScrollPane.setBounds(378, 208, 416, 264);
		cp.add(jTextAreaScrollPane);

		lArtInKorb.setBounds(700, 530, 155, 13);
		cp.add(lArtInKorb);
		lGuthaben.setBounds(700, 34, 150, 13);
		cp.add(lGuthaben);

		// Ende Komponenten
		datenLaden();
		einkaufsPortal.setVisible(true);
	} // end of public Einkaufsportal

	// Anfang Methoden

	public void bWarenkorbhinzufuegen_ActionPerformed(ActionEvent evt) {
		WarenkorbGUI.warenlist.add(tempWare);
		lArtInKorb.setText("Artikel im Warenkorb : " + WarenkorbGUI.warenlist.size());

	} // end of bWarenkorbhinzufuegen_ActionPerformed

	public void bZumWarenkorb_ActionPerformed(ActionEvent evt) {
		new WarenkorbGUI();
		einkaufsPortal.dispose();

	}

	public void admin_ActionPerformed(ActionEvent evt) {

		if (LoginGUI.globalNAME != null) {

			if (LoginGUI.globalNAME.equals("admin")) {
				new VerwaltungGUI();
				einkaufsPortal.dispose();
			}
		}

	}

	public void datenLaden() {
		String Username = LoginGUI.globalNAME;
		int Stelle = InteractBenutzerdaten.stelleArray(Username);
		Benutzer[] Liste = InteractBenutzerdaten.readCSV();

		if (Stelle != -1) {

			lGuthaben.setText("Guthaben : " + Liste[Stelle].getGuthaben());
		}
	}

	public void abmelden_ActionPerformed(ActionEvent evt) {
		new LoginGUI();
		einkaufsPortal.dispose();
		
		
		

	}

	public void benutzerverwaltung_ActionPerformed(ActionEvent evt) {
		einkaufsPortal.dispose();
		new BenutzerverwaltungGUI();

	}

	public void addWaren() {
		Ware[] WarenListe = InteractWarenListe.readCSV();

		for (int i = 1; i < WarenListe.length; i++) {
			listModelWare.addElement(WarenListe[i]);
		}

	}

}
