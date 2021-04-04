package projekt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class PasswortAendern {
	// Anfang Attribute
	private JLabel lPasswortaendern = new JLabel();
	private JLabel lAltesPasswort = new JLabel();
	private JLabel lNeuesPasswort1 = new JLabel();
	private JLabel lWiederholen = new JLabel();
	private JPasswordField jPasswordAlt = new JPasswordField();
	private JPasswordField jPasswordNeu1 = new JPasswordField();
	private JPasswordField jPasswordNeu2 = new JPasswordField();
	private JLabel jStatus = new JLabel();
	private JButton bZurueck = new JButton();
	private JButton bPasswortaendern = new JButton();
	// Ende Attribute

	JFrame ChangePass = new JFrame();

	public PasswortAendern() {
		// Frame-Initialisierung
		super();
		ChangePass.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 575;
		int frameHeight = 376;
		ChangePass.setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - ChangePass.getSize().width) / 2;
		int y = (d.height - ChangePass.getSize().height) / 2;
		ChangePass.setLocation(x, y);
		ChangePass.setTitle("PasswortAendern");
		ChangePass.setResizable(false);
		Container cp = ChangePass.getContentPane();
		cp.setLayout(null);
		// Anfang Komponenten

		lPasswortaendern.setBounds(88, 16, 369, 57);
		lPasswortaendern.setText("Passwort aendern");
		lPasswortaendern.setBackground(new Color(0xFFAFAF));
		lPasswortaendern.setOpaque(true);
		lPasswortaendern.setFont(new Font("Dialog", Font.BOLD, 25));
		lPasswortaendern.setHorizontalAlignment(SwingConstants.CENTER);
		cp.add(lPasswortaendern);
		lAltesPasswort.setBounds(39, 100, 160, 25);
		lAltesPasswort.setText("Altes Passwort: ");
		lAltesPasswort.setFont(new Font("Dialog", Font.BOLD, 16));
		lAltesPasswort.setBackground(new Color(0xFFAFAF));
		lAltesPasswort.setOpaque(true);
		lAltesPasswort.setHorizontalAlignment(SwingConstants.CENTER);
		cp.add(lAltesPasswort);
		lNeuesPasswort1.setBounds(40, 160, 161, 25);
		lNeuesPasswort1.setText("Neues Passwort:");
		lNeuesPasswort1.setFont(new Font("Dialog", Font.BOLD, 16));
		lNeuesPasswort1.setHorizontalAlignment(SwingConstants.CENTER);
		lNeuesPasswort1.setBackground(new Color(0xFFAFAF));
		lNeuesPasswort1.setOpaque(true);
		cp.add(lNeuesPasswort1);
		lWiederholen.setBounds(40, 200, 161, 25);
		lWiederholen.setText("Wiederholen:");
		lWiederholen.setFont(new Font("Dialog", Font.BOLD, 16));
		lWiederholen.setHorizontalAlignment(SwingConstants.CENTER);
		lWiederholen.setBackground(new Color(0xFFAFAF));
		lWiederholen.setOpaque(true);
		cp.add(lWiederholen);
		jPasswordAlt.setBounds(216, 104, 177, 25);
		cp.add(jPasswordAlt);
		jPasswordNeu1.setBounds(216, 160, 177, 25);
		cp.add(jPasswordNeu1);
		jPasswordNeu2.setBounds(216, 200, 177, 25);
		cp.add(jPasswordNeu2);
		jStatus.setBounds(40, 232, 457, 25);
		jStatus.setText("");
		cp.add(jStatus);
		bZurueck.setBounds(64, 280, 129, 41);
		bZurueck.setText("Zurueck");
		bZurueck.setMargin(new Insets(2, 2, 2, 2));
		bZurueck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bZurueck_ActionPerformed(evt);
			}
		});
		bZurueck.setBackground(new Color(0xFFC800));
		bZurueck.setFont(new Font("Dialog", Font.BOLD, 20));
		cp.add(bZurueck);
		bPasswortaendern.setBounds(296, 280, 201, 41);
		bPasswortaendern.setText("Passwort aendern");
		bPasswortaendern.setMargin(new Insets(2, 2, 2, 2));
		bPasswortaendern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bPasswortaendern_ActionPerformed(evt);
			}
		});
		bPasswortaendern.setBackground(new Color(0xFFC800));
		bPasswortaendern.setFont(new Font("Dialog", Font.BOLD, 20));
		cp.add(bPasswortaendern);
		// Ende Komponenten

		ChangePass.setVisible(true);
	} // end of public PasswortAendern

	// Anfang Methoden

	public void bZurueck_ActionPerformed(ActionEvent evt) {

		ChangePass.dispose();
		jPasswordAlt.setText("");
		jPasswordNeu1.setText("");
		jPasswordNeu2.setText("");
		new BenutzerverwaltungGUI();
	}

	@SuppressWarnings("deprecation")
	public void bPasswortaendern_ActionPerformed(ActionEvent evt){

		String[][] Speicher = LoginGUI.readCSV();

		String Username = LoginGUI.NAME;
		String[][] csv = LoginGUI.readCSV();
		int x = 0;
		String Passwort = null;

		while (!csv[x][2].equals(Username)) {
			x++;
		}
		if (csv[x][2].equals(Username)) {
			Passwort = csv[x][3];

		}

		if (jPasswordAlt.getText().equals(Passwort)) {

			if (RegistrierungsGUI.CheckPasswords(jPasswordNeu1.getText(), jPasswordNeu2.getText())) {

				jStatus.setText("Passwort erfolgreich geändert!"); //Text wird nicht angezeigt weil das Programm zu schnell anfängt zu schlafen
			
				csv[x][3] = jPasswordNeu1.getText();
				
				
				schlafen();
				ChangePass.dispose();
				new BenutzerverwaltungGUI();

			}

			else {
				jStatus.setText("Neue Passwörter stimmen nicht überein");

			}

		} else {
			jStatus.setText("Altes Passwort falsch");

		}

	}
	public void schlafen() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
