package projekt;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class WarenkorbGUI{
  // Anfang Attribute
  private JLabel lWarenkorb = new JLabel();
  private JLabel lGesamtPreis = new JLabel();
  private JButton bEinkaufabschliessen = new JButton();
  private JLabel lPreiseintragen = new JLabel();
  private JTable jTable1 = new JTable(0, 2);
  private JScrollPane jTable1ScrollPane = new JScrollPane(jTable1);
  private int preisEintragen = 0;
  
  JFrame Warenkorb = new JFrame();
  // Ende Attribute
  
  public WarenkorbGUI() { 
    Warenkorb.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 536; 
    int frameHeight = 796;
    Warenkorb.setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - Warenkorb.getSize().width) / 2;
    int y = (d.height - Warenkorb.getSize().height) / 2;
    Warenkorb.setLocation(x, y);
    Warenkorb.setTitle("JavaGUI");
    Warenkorb.setResizable(false);
    Container cp = Warenkorb.getContentPane();
    cp.setLayout(null);
    
    
    // Anfang Komponenten
    lGesamtPreis.setBounds(24, 591, 206, 68);
    lGesamtPreis.setText("Gesamt Preis");
    lGesamtPreis.setHorizontalAlignment(SwingConstants.CENTER);
    lGesamtPreis.setHorizontalTextPosition(SwingConstants.CENTER);
    lGesamtPreis.setBackground(Color.CYAN);
    lGesamtPreis.setOpaque(true);
    lGesamtPreis.setFont(new Font("Dialog", Font.BOLD, 20));
    cp.add(lGesamtPreis);
    bEinkaufabschliessen.setBounds(26, 676, 459, 65);
    bEinkaufabschliessen.setText("Zurueck");
    bEinkaufabschliessen.setMargin(new Insets(2, 2, 2, 2));
    bEinkaufabschliessen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bEinkaufabschliessen_ActionPerformed(evt);
      }
    });
    bEinkaufabschliessen.setBackground(new Color(0xFFC800));
    bEinkaufabschliessen.setFont(new Font("Dialog", Font.BOLD, 22));
    cp.add(bEinkaufabschliessen);
    lPreiseintragen.setBounds(236, 592, 254, 68);
    lPreiseintragen.setText(Integer.toString(preisEintragen)+"€");
    lPreiseintragen.setFont(new Font("Dialog", Font.BOLD, 22));
    lPreiseintragen.setBackground(Color.CYAN);
    lPreiseintragen.setOpaque(true);
    lPreiseintragen.setHorizontalAlignment(SwingConstants.CENTER);
    lPreiseintragen.setHorizontalTextPosition(SwingConstants.CENTER);
    cp.add(lPreiseintragen);
    jTable1ScrollPane.setBounds(20, 103, 468, 470);
    jTable1.getColumnModel().getColumn(0).setHeaderValue("Artikel");
    jTable1.getColumnModel().getColumn(1).setHeaderValue("Preis");
    jTable1.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
    jTable1.setToolTipText("Warenkorb");
    jTable1.setRowHeight(25);
    jTable1.setDefaultEditor(Object.class, null);
    cp.add(jTable1ScrollPane);
    lWarenkorb.setBounds(149, 15, 342, 76);
    lWarenkorb.setText("Warenkorb");
    lWarenkorb.setHorizontalAlignment(SwingConstants.CENTER);
    lWarenkorb.setHorizontalTextPosition(SwingConstants.CENTER);
    lWarenkorb.setBackground(Color.pink);
    lWarenkorb.setOpaque(true);
    lWarenkorb.setFont(new Font("Dialog", Font.BOLD, 20));
    cp.add(lWarenkorb);
    // Ende Komponenten
    
    Warenkorb.setVisible(true);
  } 
  
  
  
  public void bEinkaufabschliessen_ActionPerformed(ActionEvent evt) {
      Warenkorb.dispose();
      new EinkaufsPortalGUI();
    
  }
  public void Warenkorbhinzufügen(Ware ware) {
	 
  }


}