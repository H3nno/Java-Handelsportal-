package projekt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginGUI extends JFrame {
  /**
	 * 
	 */
	private static final long serialVersionUID = 512483451666563178L;
// Anfang Attribute
  private JLabel lEinkaufsladenonline = new JLabel();
  private JLabel lEroeffnetam1872021 = new JLabel();
  public static JTextField jUsername = new JTextField();
  private JLabel lBenutzername1 = new JLabel();
  private JLabel lPasswort = new JLabel();
  private JButton bLogin = new JButton();
  private JLabel lNochkeinKontoHierregistrieren = new JLabel();
  private JButton bHierklicken = new JButton();
  public static JPasswordField jPasswordField1 = new JPasswordField();
  // Ende Attribute
  
  public LoginGUI() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 615; 
    int frameHeight = 571;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("LoginGUI");
    setResizable(false);
    Container cp = getContentPane();
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
    setUndecorated(false);
    cp.setBackground(new Color(0xEEEEEE));
    jPasswordField1.setBounds(184, 312, 209, 33);
    cp.add(jPasswordField1);
    // Ende Komponenten
    
    setVisible(true);
  } 
  
  // Anfang Methoden
  
  
  public void bLogin_ActionPerformed(ActionEvent evt){
	  Login.LoginButtonPressed();
    
  } 

  public void bHierklicken_ActionPerformed(ActionEvent evt) {
     Login.RegistrierungButtonPressed();
    
  } 


} 
