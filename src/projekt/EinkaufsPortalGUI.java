package projekt;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.*;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 25.03.2021
 * @author 
 */

public class EinkaufsPortalGUI extends JFrame {
  // Anfang Attribute
  private ArrayList<Ware> list = new ArrayList<>();
  private JLabel lEinkaufsportal = new JLabel();
  private JList jList1 = new JList(new Vector<Ware>(list));
    private DefaultListModel jList1Model = new DefaultListModel();
    private JScrollPane jList1ScrollPane = new JScrollPane(jList1);
  private JButton bWarenkorbhinzufuegen = new JButton();
  private JButton bZumWarenkorb = new JButton();
  private JTextArea jTextArea1 = new JTextArea("");
    private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  // Ende Attribute
  
  public EinkaufsPortalGUI() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 891; 
    int frameHeight = 600;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Einkaufsportal");
    setResizable(true);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    
    lEinkaufsportal.setBounds(285, 34, 270, 76);
    lEinkaufsportal.setText("Einkaufsportal");
    lEinkaufsportal.setHorizontalAlignment(SwingConstants.CENTER);
    lEinkaufsportal.setHorizontalTextPosition(SwingConstants.CENTER);
    lEinkaufsportal.setFont(new Font("Dialog", Font.BOLD, 22));
    lEinkaufsportal.setForeground(Color.BLACK);
    lEinkaufsportal.setBackground(new Color(0xFFAFAF));
    lEinkaufsportal.setOpaque(true);
    cp.add(lEinkaufsportal);
    jList1.setModel(jList1Model);
    jList1ScrollPane.setBounds(57, 144, 294, 324);
    jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    jList1.setFont(new Font("Dialog", Font.BOLD, 16));
    jList1.setDragEnabled(false);
    jList1.addFocusListener(new FocusAdapter() { 
      public void focusGained(FocusEvent evt) { 
        jList1_FocusGained(evt);
      }
    });
    cp.add(jList1ScrollPane);
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
    bZumWarenkorb.setBounds(702, 55, 155, 49);
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
    jTextArea1ScrollPane.setBounds(378, 148, 416, 324);
    cp.add(jTextArea1ScrollPane);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Einkaufsportal
  
  // Anfang Methoden
  
  public void bWarenkorbhinzufuegen_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of bWarenkorbhinzufuegen_ActionPerformed

  public void bZumWarenkorb_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of bZumWarenkorb_ActionPerformed
  public void Jlisthinzu(Ware ware) {
	  list.add(ware);
  }

  public void jList1_FocusGained(FocusEvent evt) {
    
    
  } // end of jList1_FocusGained

  // Ende Methoden
} // end of class Einkaufsportal
