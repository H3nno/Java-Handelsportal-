package projekt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class RegistrierungsGUI extends JFrame {
  // Anfang Attribute
  private JLabel lPasswortwiederholen = new JLabel();
  private JLabel lVorname = new JLabel();
  private JLabel lNachname = new JLabel();
  private JLabel lUsername = new JLabel();
  private JLabel lPasswort = new JLabel();
  private JLabel lRegistrierung = new JLabel();
  private JButton bJetztregistrierenundzurueckzumLogin = new JButton();
  private JTextField jTFVorname = new JTextField();
  private JTextField jTFNachname = new JTextField();
  public JTextField jTFUsername = new JTextField();
  public JPasswordField jPFPasswort1 = new JPasswordField();
  public JPasswordField jPasswordField1 = new JPasswordField();
  public static JLabel jStatus = new JLabel();
  private JButton bZurueckzumLogin = new JButton();
  // Ende Attribute
  
  public RegistrierungsGUI() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 498; 
    int frameHeight = 550;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("RegistrierungGUI");
    setResizable(false);
    Container cp = getContentPane();
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
    bJetztregistrierenundzurueckzumLogin.setText("Jetzt registrieren und zurück zum Login");
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
    
    
    
    bZurueckzumLogin.setBounds(176, 464, 113, 33);
    bZurueckzumLogin.setText("Zurück zum Login");
    bZurueckzumLogin.setMargin(new Insets(2, 2, 2, 2));
    bZurueckzumLogin.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bZurueckzumLogin_ActionPerformed(evt);
      }
    });
    bZurueckzumLogin.setBackground(new Color(0xFFC800));
    cp.add(bZurueckzumLogin);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public RegistrierungGUI
  
  // Anfang Methoden
  
  
  public void bZurueckzumLogin_ActionPerformed(ActionEvent evt) {
	    Registrierung.Zurueck();
	    
	  }

  
  public void bJetztregistrierenundzurueckzumLogin_ActionPerformed(ActionEvent evt) {
    Registrierung.Registrieren();
    
  }

} 
