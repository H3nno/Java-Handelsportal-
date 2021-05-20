package projekt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RegistrierungsGUI {
	// Anfang Attribute
	private JLabel lPasswortwiederholen = new JLabel();
	private JLabel lVorname = new JLabel();
	private JLabel lNachname = new JLabel();
	private JLabel lUsername = new JLabel();
	private JLabel lPasswort = new JLabel();
	private JLabel lRegistrierung = new JLabel();
	private JButton bJetztregistrierenundzurueckzumLogin = new JButton();
	public static JTextField jTFVorname = new JTextField();
	public static JTextField jTFNachname = new JTextField();
	public static JTextField jTFUsername = new JTextField();
	public static JPasswordField jPassword1 = new JPasswordField();
	public static JPasswordField jPassword2 = new JPasswordField();
	public static JLabel jStatus = new JLabel();
	private JButton bZurueckzumLogin = new JButton();
	// Ende Attribute

	JFrame registrierungGUI = new JFrame();
	static int wieTief = 0;
	static String[][] speichern;

	public RegistrierungsGUI() {
		// Frame-Initialisierung
		// super();
		registrierungGUI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 498;
		int frameHeight = 550;
		registrierungGUI.setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - registrierungGUI.getSize().width) / 2;
		int y = (d.height - registrierungGUI.getSize().height) / 2;
		registrierungGUI.setLocation(x, y);
		registrierungGUI.setTitle("RegistrierungGUI");
		registrierungGUI.setResizable(false);
		Container cp = registrierungGUI.getContentPane();
		cp.setLayout(null);
		// Anfang Komponenten

		lVorname.setBounds(24, 120, 145, 33);
		lVorname.setText("Vorname:");
		lVorname.setHorizontalAlignment(SwingConstants.CENTER);
		lVorname.setFont(new Font("Dialog", Font.BOLD, 18));
		cp.add(lVorname);
		lNachname.setBounds(24, 168, 145, 33);
		lNachname.setText("Nachname:");
		lNachname.setFont(new Font("Dialog", Font.BOLD, 18));
		lNachname.setHorizontalAlignment(SwingConstants.CENTER);
		cp.add(lNachname);
		lUsername.setBounds(24, 216, 145, 33);
		lUsername.setText("Username:");
		lUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lUsername.setFont(new Font("Dialog", Font.BOLD, 18));
		cp.add(lUsername);
		lPasswort.setBounds(24, 264, 145, 33);
		lPasswort.setText("Passwort:");
		lPasswort.setHorizontalAlignment(SwingConstants.CENTER);
		lPasswort.setFont(new Font("Dialog", Font.BOLD, 18));
		cp.add(lPasswort);
		lPasswortwiederholen.setBounds(24, 312, 142, 33);
		lPasswortwiederholen.setText("Passwort wiederholen:");
		lPasswortwiederholen.setFont(new Font("Dialog", Font.BOLD, 12));
		lPasswortwiederholen.setBackground(new Color(0xFFAFAF));
		lPasswortwiederholen.setOpaque(true);
		lPasswortwiederholen.setHorizontalAlignment(SwingConstants.CENTER);
		cp.add(lPasswortwiederholen);

		lRegistrierung.setBounds(88, 32, 265, 57);
		lRegistrierung.setText("Registrierung");
		lRegistrierung.setBackground(new Color(0xFFAFAF));
		lRegistrierung.setOpaque(true);
		lRegistrierung.setFont(new Font("Dialog", Font.BOLD, 24));
		lRegistrierung.setHorizontalAlignment(SwingConstants.CENTER);
		cp.add(lRegistrierung);
		lVorname.setBackground(new Color(0xFFAFAF));
		lVorname.setOpaque(true);
		lNachname.setBackground(new Color(0xFFAFAF));
		lNachname.setOpaque(true);
		lUsername.setBackground(new Color(0xFFAFAF));
		lUsername.setOpaque(true);
		lPasswort.setBackground(new Color(0xFFAFAF));
		lPasswort.setOpaque(true);
		bJetztregistrierenundzurueckzumLogin.setBounds(80, 400, 313, 41);
		bJetztregistrierenundzurueckzumLogin.setText("Jetzt registrieren und zurueck zum Login");
		bJetztregistrierenundzurueckzumLogin.setMargin(new Insets(2, 2, 2, 2));
		bJetztregistrierenundzurueckzumLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bJetztregistrierenundzurueckzumLogin_ActionPerformed(evt);
			}
		});
		bJetztregistrierenundzurueckzumLogin.setBackground(Color.YELLOW);
		cp.add(bJetztregistrierenundzurueckzumLogin);
		jTFVorname.setBounds(176, 120, 185, 33);
		cp.add(jTFVorname);
		jTFNachname.setBounds(176, 168, 185, 33);
		cp.add(jTFNachname);
		jTFUsername.setBounds(176, 216, 185, 33);
		cp.add(jTFUsername);
		jPassword1.setBounds(176, 264, 185, 33);
		cp.add(jPassword1);
		jPassword2.setBounds(176, 312, 185, 33);
		cp.add(jPassword2);
		jStatus.setBounds(96, 360, 257, 25);
		jStatus.setText("");
		jStatus.setHorizontalAlignment(SwingConstants.CENTER);
		cp.add(jStatus);

		bZurueckzumLogin.setBounds(166, 464, 150, 33);
		bZurueckzumLogin.setText("Zurueck zum Login");
		bZurueckzumLogin.setMargin(new Insets(2, 2, 2, 2));
		bZurueckzumLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bZurueckzumLogin_ActionPerformed(evt);
			}
		});
		bZurueckzumLogin.setBackground(new Color(0xFFC800));
		cp.add(bZurueckzumLogin);
		// Ende Komponenten

		registrierungGUI.setVisible(true);
	}

	// Methoden

	public void bZurueckzumLogin_ActionPerformed(ActionEvent evt) {
		new LoginGUI();
		registrierungGUI.dispose();
	}

	@SuppressWarnings("deprecation")
	public void bJetztregistrierenundzurueckzumLogin_ActionPerformed(ActionEvent evt) {
		jStatus.setText("");
		if (RegistrierungsGUI.checkUsername()) {
			if (RegistrierungsGUI.checkPasswords(jPassword1.getText(), jPassword2.getText())) {

				Benutzer[] listeALT = InteractBenutzerdaten.readCSV();
				Benutzer[] listeNEU = new Benutzer[listeALT.length + 1];

				String tempVorname = jTFVorname.getText();
				String tempNachname = jTFNachname.getText();
				String tempUsername = jTFUsername.getText();
				String tempPasswort = jPassword1.getText();
				String tempGuthaben = "0";

				Benutzer temp = new Benutzer(tempVorname, tempNachname, tempUsername, tempPasswort, tempGuthaben);

				int i = 0;
				while (i < listeALT.length) {
					listeNEU[i] = listeALT[i];
					i++;
				}
				listeNEU[i] = temp;

				InteractBenutzerdaten.writeCSV(listeNEU);

				registrierungGUI.dispose();
				new LoginGUI();
			} else {
				jStatus.setText("Passwort Fehler");
			}
		} else {
			jStatus.setText("Benutzername Fehler");
		}
	}
	public static boolean checkPasswords(String pwd1, String pwd2) {
		if (!pwd1.equals("") && !pwd2.equals("")) {
			if (pwd1.equals(pwd2)) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkUsername() {
		String username = RegistrierungsGUI.jTFUsername.getText();

		int stelle = InteractBenutzerdaten.stelleArray(username);

		if (stelle == -1) {
			return true;

		}

		return false;

	}

}
