package projekt;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;


public class RegistrierungsGUI{
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
  public static JPasswordField jPFPasswort1 = new JPasswordField();
  public static JPasswordField jPasswordField1 = new JPasswordField();
  public static JLabel jStatus = new JLabel();
  private JButton bZurueckzumLogin = new JButton();
  // Ende Attribute
  
  
  
  JFrame Registrierung = new JFrame();
  static int WieTief = 0;
  static String[][] Speichern;
  
  
  
  
  public RegistrierungsGUI() { 
    // Frame-Initialisierung
    //super();
    Registrierung.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 498; 
    int frameHeight = 550;
    Registrierung.setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - Registrierung.getSize().width) / 2;
    int y = (d.height - Registrierung.getSize().height) / 2;
    Registrierung.setLocation(x, y);
    Registrierung.setTitle("RegistrierungGUI");
    Registrierung.setResizable(false);
    Container cp = Registrierung.getContentPane();
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
    jPFPasswort1.setBounds(176, 264, 185, 33);
    cp.add(jPFPasswort1);
    jPasswordField1.setBounds(176, 312, 185, 33);
    cp.add(jPasswordField1);
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
    
    Registrierung.setVisible(true);
  } 
  
 
  
  
  
  
  
  
  
  
  //^GUI 
  /////////////////////////////////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////////////////////////////////
  /////////////////////////////////////////////////////////////////////////////////////////////////////////
  //Methoden
  
  
  
  
  
  
  public void bZurueckzumLogin_ActionPerformed(ActionEvent evt) {
	    new LoginGUI();
	    Registrierung.dispose();
	  }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
  @SuppressWarnings("deprecation")
public void bJetztregistrierenundzurueckzumLogin_ActionPerformed(ActionEvent evt) {
	  jStatus.setText("");
		if (RegistrierungsGUI.CheckUsername()) {
			if (RegistrierungsGUI.CheckPasswords()) {
				FileWriter writer = null;		
				try {
					writer = new FileWriter("src\\projekt\\Benutzerdaten.csv", true);
					writer.append("\n");
					writer.append("" + RegistrierungsGUI.jTFVorname.getText());
					writer.append(";");
					writer.append("" + RegistrierungsGUI.jTFNachname.getText());
					writer.append(";");
					writer.append("" +RegistrierungsGUI.jTFUsername.getText());
					writer.append(";");
					writer.append("" +RegistrierungsGUI.jPFPasswort1.getText());
					writer.append(";");
					writer.append("0");

					new LoginGUI();
					Registrierung.dispose();
				} catch (IOException e) {
					e.printStackTrace();
				}
				  finally{
					  try {
				      writer.flush();
				      writer.close();
				        } catch (IOException e) {
				      e.printStackTrace();
				}
				  }
			} else {jStatus.setText("Passwort Fehler");}
		}
		else {jStatus.setText("Benutzername Fehler");}
  }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@SuppressWarnings("deprecation")
	public static boolean CheckPasswords() {
		if (!RegistrierungsGUI.jPFPasswort1.getText().equals("")) {
			if (RegistrierungsGUI.jPFPasswort1.getText().equals(RegistrierungsGUI.jPasswordField1.getText())) {
				return true;
			}
		}
		return false;
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static boolean CheckUsername() {
		String Username = RegistrierungsGUI.jTFUsername.getText();
		String[][] Speichern = LoginGUI.readCSV();
		for (int i = 1; i < WieTief; i++) {
			if (Username.equals(Speichern[i][2])) {return false;}
			}
		if (Username.equals("")) {return false;}
		return true;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * public static void readCSV() { String Pfad =
	 * "src\\projekt\\Benutzerdaten.csv"; String line; BufferedReader BR1 = null;
	 * BufferedReader BR = null; try { BR1 = new BufferedReader(new
	 * FileReader(Pfad)); int z = 0; while ((line = BR1.readLine()) != null) {
	 * WieTief++; } Speichern = new String[WieTief][4]; BR = new BufferedReader(new
	 * FileReader(Pfad)); while ((line = BR.readLine()) != null) { String[] Spalten
	 * = line.split(";"); for (int j = 0; j < 4; j++) { Speichern[z][j] =
	 * Spalten[j]; } z++; } } catch (IOException e) { e.printStackTrace(); } }
	 */
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  

} 
