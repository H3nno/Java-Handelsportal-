package projekt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginGUI {
	// Anfang Attribute
	private JLabel lEinkaufsladenonline = new JLabel();
	private JLabel lEroeffnetam1872021 = new JLabel();
	public static JTextField jUsername = new JTextField();
	private JLabel lBenutzername1 = new JLabel();
	private JLabel lPasswort = new JLabel();
	private JButton bLogin = new JButton();
	private JLabel lNochkeinKontoHierregistrieren = new JLabel();
	private static JLabel lStatus = new JLabel();
	private JButton bHierklicken = new JButton();
	public static JPasswordField jPasswordField1 = new JPasswordField();
	// Ende Attribute

	static int wieTief = 0;

	public static String globalNAME;

	JFrame loginGUI = new JFrame();

	public LoginGUI() {
		// Frame-Initialisierung

		loginGUI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 615;
		int frameHeight = 571;
		loginGUI.setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - loginGUI.getSize().width) / 2;
		int y = (d.height - loginGUI.getSize().height) / 2;
		loginGUI.setLocation(x, y);
		loginGUI.setTitle("LoginGUI");
		loginGUI.setResizable(false);
		Container cp = loginGUI.getContentPane();
		cp.setLayout(null);
		// Anfang Komponenten

		lEinkaufsladenonline.setBounds(136, 32, 328, 110);
		lEinkaufsladenonline.setText("Einkaufsladen online");
		lEinkaufsladenonline.setHorizontalAlignment(SwingConstants.CENTER);
		lEinkaufsladenonline.setFont(new Font("Dialog", Font.BOLD, 25));
		lEinkaufsladenonline.setBackground(new Color(0xFFAFAF));
		lEinkaufsladenonline.setOpaque(true);
		cp.add(lEinkaufsladenonline);
		lEroeffnetam1872021.setBounds(192, 144, 209, 33);
		lEroeffnetam1872021.setText("Eroeffnet am 18.7.2021");
		lEroeffnetam1872021.setHorizontalAlignment(SwingConstants.CENTER);
		lEroeffnetam1872021.setBackground(new Color(0xFFC800));
		lEroeffnetam1872021.setOpaque(true);
		cp.add(lEroeffnetam1872021);
		jUsername.setBounds(184, 264, 209, 33);
		cp.add(jUsername);
		lBenutzername1.setBounds(40, 264, 129, 33);
		lBenutzername1.setText("Benutzername:");
		lBenutzername1.setHorizontalAlignment(SwingConstants.CENTER);
		lBenutzername1.setBackground(new Color(0xC0C0C0));
		lBenutzername1.setOpaque(true);
		cp.add(lBenutzername1);
		lPasswort.setBounds(40, 312, 129, 33);
		lPasswort.setText("Passwort:");
		lPasswort.setHorizontalAlignment(SwingConstants.CENTER);
		lPasswort.setBackground(new Color(0xC0C0C0));
		lPasswort.setOpaque(true);
		cp.add(lPasswort);
		bLogin.setBounds(416, 288, 137, 33);
		bLogin.setText("Login");
		bLogin.setMargin(new Insets(2, 2, 2, 2));
		bLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bLogin_ActionPerformed(evt);

			}
		});
		bLogin.setBackground(Color.CYAN);
		cp.add(bLogin);
		lNochkeinKontoHierregistrieren.setBounds(40, 416, 226, 33);
		lNochkeinKontoHierregistrieren.setText("Noch kein Konto? Hier registrieren:");
		lNochkeinKontoHierregistrieren.setHorizontalAlignment(SwingConstants.CENTER);
		cp.add(lNochkeinKontoHierregistrieren);

		lStatus.setBounds(200, 360, 200, 33);
		lStatus.setText("");
		cp.add(lStatus);

		bHierklicken.setBounds(280, 416, 113, 33);
		bHierklicken.setText("Hier klicken");
		bHierklicken.setMargin(new Insets(2, 2, 2, 2));
		bHierklicken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bHierklicken_ActionPerformed(evt);
			}
		});
		bHierklicken.setBackground(new Color(0xFFC800));
		cp.add(bHierklicken);
		loginGUI.setUndecorated(false);
		cp.setBackground(new Color(0xEEEEEE));
		jPasswordField1.setBounds(184, 312, 209, 33);
		cp.add(jPasswordField1);
		// Ende Komponenten

		loginGUI.setVisible(true);

	}

	// Anfang Methoden

	public void bLogin_ActionPerformed(ActionEvent evt) {
		boolean darf = LoginGUI.darfLogin();
		if (darf) {

			globalNAME = jUsername.getText();
			loginGUI.dispose();
			new EinkaufsPortalGUI();
			jUsername.setText("");
			jPasswordField1.setText("");
		}
	}

	public void bHierklicken_ActionPerformed(ActionEvent evt) {
		new RegistrierungsGUI();
		loginGUI.dispose();
	}

	@SuppressWarnings("deprecation")
	public static boolean darfLogin() {

		Benutzer[] darfLoginListe = InteractBenutzerdaten.readCSV();
		String username = jUsername.getText();

		int userID = InteractBenutzerdaten.stelleArray(username);

		if (userID != -1) {

			if (darfLoginListe[userID].getPasswort().equals(jPasswordField1.getText())) {

				lStatus.setText("Erfolgreich");
				return true;

			} else {
				lStatus.setText("Passwort falsch");
				return false;
			}

		} else {
			lStatus.setText("Benutzer existiert nicht");
			return false;
		}

	}

}
