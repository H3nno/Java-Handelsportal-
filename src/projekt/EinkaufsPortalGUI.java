package projekt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 04.03.2021
 * @author 
 */

public class EinkaufsPortalGUI extends JFrame {
  // Anfang Attribute
  private JButton bIndenWarenkorb = new JButton();
  private JButton bIndenWarenkorb1 = new JButton();
  private JLabel lEinkaufsportal = new JLabel();
  private JButton bZumWarenkorb = new JButton();
  // Ende Attribute
  
  public EinkaufsPortalGUI() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 766; 
    int frameHeight = 541;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Einkaufsportal");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    bIndenWarenkorb.setBounds(128, 416, 121, 49);
    bIndenWarenkorb.setText("In den Warenkorb");
    bIndenWarenkorb.setMargin(new Insets(2, 2, 2, 2));
    bIndenWarenkorb.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bIndenWarenkorb_ActionPerformed(evt);
      }
    });
    bIndenWarenkorb.setBackground(new Color(0xFFC800));
    cp.add(bIndenWarenkorb);
    bIndenWarenkorb1.setBounds(408, 416, 121, 49);
    bIndenWarenkorb1.setText("In den Warenkorb");
    bIndenWarenkorb1.setMargin(new Insets(2, 2, 2, 2));
    bIndenWarenkorb1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bIndenWarenkorb1_ActionPerformed(evt);
      }
    });
    bIndenWarenkorb1.setBackground(new Color(0xFFC800));
    cp.add(bIndenWarenkorb1);

    lEinkaufsportal.setBounds(240, 24, 169, 73);
    lEinkaufsportal.setText("Einkaufsportal");
    lEinkaufsportal.setFont(new Font("Dialog", Font.BOLD, 24));
    lEinkaufsportal.setVerticalAlignment(SwingConstants.CENTER);
    lEinkaufsportal.setVerticalTextPosition(SwingConstants.CENTER);
    lEinkaufsportal.setBackground(new Color(0xFFAFAF));
    lEinkaufsportal.setOpaque(true);
    cp.add(lEinkaufsportal);
    bZumWarenkorb.setBounds(576, 112, 113, 33);
    bZumWarenkorb.setText("Zum Warenkorb");
    bZumWarenkorb.setMargin(new Insets(2, 2, 2, 2));
    bZumWarenkorb.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bZumWarenkorb_ActionPerformed(evt);
      }
    });
    bZumWarenkorb.setBackground(new Color(0xFFC800));
    cp.add(bZumWarenkorb);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public EinkaufsPortalGUI
  
  // A{
        
      
  
  public static void main(String[] args) {
    new EinkaufsPortalGUI();
  } // end of main
  
  public void bIndenWarenkorb_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of bIndenWarenkorb_ActionPerformed

  public void bIndenWarenkorb1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of bIndenWarenkorb1_ActionPerformed

  public void bZumWarenkorb_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of bZumWarenkorb_ActionPerformed

  // Ende Methoden
} // end of class EinkaufsPortalGUI
