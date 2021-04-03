package projekt;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class LoginGUI{
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
  
  
  
  static String[][] Speichern;
  static int WieTief = 0;
  
  public static String NAME;
  
  JFrame Login = new JFrame();
  
  
  
  public LoginGUI() { 
    // Frame-Initialisierung
	  
	//JFrame Login = new JFrame();
	  
    //super();
    Login.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 615; 
    int frameHeight = 571;
    Login.setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - Login.getSize().width) / 2;
    int y = (d.height - Login.getSize().height) / 2;
    Login.setLocation(x, y);
    Login.setTitle("LoginGUI");
    Login.setResizable(false);
    Container cp = Login.getContentPane();
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
    
    lStatus.setBounds(200,360,200,33);
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
    Login.setUndecorated(false);
    cp.setBackground(new Color(0xEEEEEE));
    jPasswordField1.setBounds(184, 312, 209, 33);
    cp.add(jPasswordField1);
    // Ende Komponenten
    
    Login.setVisible(true);
    

    
  } 
  
  
  
  
  
  
  
  
  ////////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////
  // Anfang Methoden
  
  
  

  
  public void bLogin_ActionPerformed(ActionEvent evt){
	  boolean Darf = LoginGUI.DarfLogin();
	  if(Darf) {
		  

		  NAME = jUsername.getText();
		  Login.dispose();
		  new EinkaufsPortalGUI();
	  } 	
  } 
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  public void bHierklicken_ActionPerformed(ActionEvent evt) {
	  new RegistrierungsGUI();
	  Login.dispose(); 
  }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static boolean DarfLogin() {
		String Username = jUsername.getText();
		@SuppressWarnings("deprecation")
		String Passwort = jPasswordField1.getText();
		LoginGUI.readCSV();
		for (int i = 1; i < WieTief; i++) {
			if (Username.equals(Speichern[i][2])) {
				if (Passwort.equals(Speichern[i][3])) {
					lStatus.setText("Erfolgreich");
					return true;
				} else {
					lStatus.setText("Passwort falsch");
					return false;
				}
			}
		}
		lStatus.setText("Benutzer existiert nicht");
		return false;
	}
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void readCSV() {
		String Pfad = "src\\projekt\\Benutzerdaten.csv";
		String line;
		BufferedReader BR1 = null;
		BufferedReader BR = null;
		try {
			BR1 = new BufferedReader(new FileReader(Pfad));
			int z = 0;
			while ((line = BR1.readLine()) != null) {
				WieTief++;
			}
			Speichern = new String[WieTief][4];
			BR = new BufferedReader(new FileReader(Pfad));
			while ((line = BR.readLine()) != null) {
				String[] Spalten = line.split(";");
				for (int j = 0; j < 4; j++) {
					Speichern[z][j] = Spalten[j];
				}
				z++;
			}
		} catch (IOException e) {
			e.printStackTrace();
	}
		finally {
			try {
				BR1.close();
				BR.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

} 
