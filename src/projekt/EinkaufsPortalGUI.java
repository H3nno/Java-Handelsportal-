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
import javax.swing.border.LineBorder;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 25.03.2021
 * @author 
 */

public class EinkaufsPortalGUI{
  // Anfang Attribute
  private ArrayList<Ware> list = new ArrayList<>();
  private JLabel lEinkaufsportal = new JLabel();
  private DefaultListModel jList1Model = new DefaultListModel();
  private JButton bWarenkorbhinzufuegen = new JButton();
  private JButton bZumWarenkorb = new JButton();
  private JTextArea jTextArea1 = new JTextArea("");
  private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  private JList<Ware> list_1 = new JList();
  // Ende Attribute
  DefaultListModel<Ware> Modell = new DefaultListModel<>();
  JFrame EinkaufsPortal = new JFrame();
  public EinkaufsPortalGUI() { 
	//Waren erschaffen
	  Modell.addElement(new Ware("Henning",0,"leichte Erstinstallation"));
	  Modell.addElement(new Ware("Jermy",10,"schon Vorkonfiguriert"));
	  Modell.addElement(new Ware("Kevin",20,"schwer zu bedienen"));
	  Modell.addElement(new Ware("Marcelo",30,"Marcelooooo"));
    // Frame-Initialisierung
    EinkaufsPortal.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 891; 
    int frameHeight = 600;
    EinkaufsPortal.setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - EinkaufsPortal.getSize().width) / 2;
    int y = (d.height - EinkaufsPortal.getSize().height) / 2;
    EinkaufsPortal.setLocation(x, y);
    EinkaufsPortal.setTitle("Einkaufsportal");
    EinkaufsPortal.setResizable(true);
    Container cp = EinkaufsPortal.getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    //JList addElement
    list_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		
		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			Ware p = list_1.getSelectedValue();
			jTextArea1.setText(p.getBeschreibung()+ '\n'+'\n' +"Preis : " + p.getPreis()+"€");
		}
	});
    list_1.setModel(Modell);
    list_1.setBounds(24, 148, 338, 324);
    EinkaufsPortal.getContentPane().add(list_1);
    lEinkaufsportal.setBounds(285, 34, 270, 76);
    lEinkaufsportal.setText("Einkaufsportal");
    lEinkaufsportal.setHorizontalAlignment(SwingConstants.CENTER);
    lEinkaufsportal.setHorizontalTextPosition(SwingConstants.CENTER);
    lEinkaufsportal.setFont(new Font("Dialog", Font.BOLD, 22));
    lEinkaufsportal.setForeground(Color.BLACK);
    lEinkaufsportal.setBackground(new Color(0xFFAFAF));
    lEinkaufsportal.setOpaque(true);
    cp.add(lEinkaufsportal);
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
    
    EinkaufsPortal.setVisible(true);
  } // end of public Einkaufsportal
  
  // Anfang Methoden
  
  public void bWarenkorbhinzufuegen_ActionPerformed(ActionEvent evt) {
	 
    
  } // end of bWarenkorbhinzufuegen_ActionPerformed

  public void bZumWarenkorb_ActionPerformed(ActionEvent evt) {
	  EinkaufsPortal.dispose();
	  new WarenkorbGUI();
    
  } // end of bZumWarenkorb_ActionPerformed
 
} // end of class Einkaufsportal
