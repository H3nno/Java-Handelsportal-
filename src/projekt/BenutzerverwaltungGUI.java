package projekt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class BenutzerverwaltungGUI {
	// Anfang Attribute
	private JLabel lBenutzerverwaltung = new JLabel();
	private JLabel lAngemeldetals = new JLabel();
	private JLabel jUsername = new JLabel();
	private JLabel lVorname = new JLabel();
	private JLabel lNachname = new JLabel();
	private JLabel lPasswort = new JLabel();
	private JLabel lGuthaben = new JLabel();
	private JLabel jVorname = new JLabel();
	private JLabel jNachname = new JLabel();
	private JLabel jPasswort = new JLabel();
	private JButton bPasswortaendern = new JButton();
	private JLabel jGuthaben = new JLabel();
	private JButton bGuthabenhinzufuegen = new JButton();
	private JButton bZurueck = new JButton();
	private JButton bAbmelden = new JButton();
	// Ende Attribute

	JFrame BenutzerverwaltungGUI = new JFrame();

	public BenutzerverwaltungGUI() {
		// Frame-Initialisierung
		// super();
		BenutzerverwaltungGUI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 527;
		int frameHeight = 637;
		BenutzerverwaltungGUI.setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - BenutzerverwaltungGUI.getSize().width) / 2;
		int y = (d.height - BenutzerverwaltungGUI.getSize().height) / 2;
		BenutzerverwaltungGUI.setLocation(x, y);
		BenutzerverwaltungGUI.setTitle("Verwaltung");
		BenutzerverwaltungGUI.setResizable(false);
		Container cp = BenutzerverwaltungGUI.getContentPane();
		cp.setLayout(null);
		// Anfang Komponenten

		lBenutzerverwaltung.setBounds(112, 24, 265, 65);
		lBenutzerverwaltung.setText("Benutzerverwaltung");
		lBenutzerverwaltung.setFont(new Font("Dialog", Font.BOLD, 25));
		lBenutzerverwaltung.setHorizontalAlignment(SwingConstants.CENTER);
		lBenutzerverwaltung.setBackground(new Color(0xFFAFAF));
		lBenutzerverwaltung.setOpaque(true);
		cp.add(lBenutzerverwaltung);
		lAngemeldetals.setBounds(27, 127, 142, 31);
		lAngemeldetals.setText("Angemeldet als:");
		lAngemeldetals.setHorizontalAlignment(SwingConstants.CENTER);
		lAngemeldetals.setFont(new Font("Dialog", Font.BOLD, 16));
		lAngemeldetals.setBackground(new Color(0xFFAFAF));
		lAngemeldetals.setOpaque(true);
		cp.add(lAngemeldetals);

		jUsername.setBounds(176, 128, 161, 25);
		jUsername.setText("");
		jUsername.setFont(new Font("Dialog", Font.BOLD, 14));
		jUsername.setBackground(Color.WHITE);
		jUsername.setOpaque(true);
		cp.add(jUsername);

		lVorname.setBounds(27, 167, 142, 31);
		lVorname.setText("Vorname: ");
		lVorname.setHorizontalAlignment(SwingConstants.CENTER);
		lVorname.setFont(new Font("Dialog", Font.BOLD, 16));
		lVorname.setBackground(new Color(0xFFAFAF));
		lVorname.setOpaque(true);
		cp.add(lVorname);
		lNachname.setBounds(27, 207, 142, 31);
		lNachname.setText("Nachname: ");
		lNachname.setHorizontalAlignment(SwingConstants.CENTER);
		lNachname.setFont(new Font("Dialog", Font.BOLD, 16));
		lNachname.setBackground(new Color(0xFFAFAF));
		lNachname.setOpaque(true);
		cp.add(lNachname);

		lPasswort.setBounds(27, 247, 142, 31);
		lPasswort.setText("Passwort: ");
		lPasswort.setHorizontalAlignment(SwingConstants.CENTER);
		lPasswort.setFont(new Font("Dialog", Font.BOLD, 16));
		lPasswort.setBackground(new Color(0xFFAFAF));
		lPasswort.setOpaque(true);
		cp.add(lPasswort);

		lGuthaben.setBounds(27, 383, 142, 31);
		lGuthaben.setText("Guthaben: ");
		lGuthaben.setHorizontalAlignment(SwingConstants.CENTER);
		lGuthaben.setFont(new Font("Dialog", Font.BOLD, 16));
		lGuthaben.setBackground(new Color(0xFFAFAF));
		lGuthaben.setOpaque(true);
		cp.add(lGuthaben);

		jVorname.setBounds(176, 168, 161, 25);
		jVorname.setText("");
		jVorname.setFont(new Font("Dialog", Font.BOLD, 14));
		jVorname.setBackground(Color.WHITE);
		jVorname.setOpaque(true);
		cp.add(jVorname);

		jNachname.setBounds(176, 208, 161, 25);
		jNachname.setText("");
		jNachname.setFont(new Font("Dialog", Font.BOLD, 14));
		jNachname.setBackground(Color.WHITE);
		jNachname.setOpaque(true);
		cp.add(jNachname);

		jPasswort.setBounds(176, 248, 161, 25);
		jPasswort.setText("");
		jPasswort.setFont(new Font("Dialog", Font.BOLD, 14));
		jPasswort.setBackground(Color.WHITE);
		jPasswort.setOpaque(true);

		cp.add(jPasswort);
		bPasswortaendern.setBounds(360, 248, 129, 25);
		bPasswortaendern.setText("Passwort aendern");
		bPasswortaendern.setMargin(new Insets(2, 2, 2, 2));
		bPasswortaendern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bPasswortaendern_ActionPerformed(evt);
			}
		});
		bPasswortaendern.setBackground(Color.CYAN);
		cp.add(bPasswortaendern);
		jGuthaben.setBounds(176, 384, 161, 25);
		jGuthaben.setText("");
		jGuthaben.setFont(new Font("Dialog", Font.BOLD, 14));
		jGuthaben.setBackground(Color.WHITE);
		jGuthaben.setOpaque(true);
		cp.add(jGuthaben);

		bGuthabenhinzufuegen.setBounds(352, 384, 145, 25);
		bGuthabenhinzufuegen.setText("Guthaben hinzufuegen");
		bGuthabenhinzufuegen.setMargin(new Insets(2, 2, 2, 2));
		bGuthabenhinzufuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bGuthabenhinzufuegen_ActionPerformed(evt);
			}
		});
		bGuthabenhinzufuegen.setBackground(Color.CYAN);
		cp.add(bGuthabenhinzufuegen);
		bZurueck.setBounds(72, 512, 129, 41);
		bZurueck.setText("Zurueck ");
		bZurueck.setMargin(new Insets(2, 2, 2, 2));
		bZurueck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bZurueck_ActionPerformed(evt);
			}
		});
		bZurueck.setBackground(new Color(0xFFC800));
		bZurueck.setFont(new Font("Dialog", Font.BOLD, 16));
		cp.add(bZurueck);

		bAbmelden.setBounds(288, 512, 129, 41);
		bAbmelden.setText("Abmelden");
		bAbmelden.setMargin(new Insets(2, 2, 2, 2));
		bAbmelden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bAbmelden_ActionPerformed(evt);
			}
		});
		bAbmelden.setBackground(new Color(0xFFC800));
		bAbmelden.setFont(new Font("Dialog", Font.BOLD, 16));
		cp.add(bAbmelden);
		// Ende Komponenten

		BenutzerverwaltungGUI.setVisible(true);

		DatenEintragen();
	} // end of public Verwaltung

	// Anfang Methoden

	public void bPasswortaendern_ActionPerformed(ActionEvent evt) {

	}

	public void bGuthabenhinzufuegen_ActionPerformed(ActionEvent evt) {

	}

	public void bZurueck_ActionPerformed(ActionEvent evt) {
		BenutzerverwaltungGUI.dispose();
		new EinkaufsPortalGUI();

	}

	public void bAbmelden_ActionPerformed(ActionEvent evt) {
		BenutzerverwaltungGUI.dispose();
		new LoginGUI();

	}

	public void DatenEintragen() {

		String Username = LoginGUI.NAME;
		String[][] csv = LoginGUI.readCSV();
		int x = 0;

		while (!csv[2][x].equals(Username)) {
			x++;

		}
		if (csv[2][x].equals(Username)) {

			jUsername.setText(csv[x][2]);
			jVorname.setText(csv[x][0]);
			jNachname.setText(csv[x][1]);
			jPasswort.setText("**********"); // richtiges Passwort liegt bei csv[x][3] aber soll ja nicht als Klartext dargestellt werden
			jGuthaben.setText(csv[x][4] + " €");
		}

	}

}
