package projekt;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class WarenkorbGUI extends JFrame {
  // Anfang Attribute
  private JLabel lWarenkorb = new JLabel();
  private JLabel lGesamtPreis = new JLabel();
  private JButton bEinkaufabschliessen = new JButton();
  private JLabel lPreiseintragen = new JLabel();
  public static JTable jTable1 = new JTable(0, 2);
  public static DefaultTableModel jTable1Model = (DefaultTableModel) jTable1.getModel();
  private JScrollPane jTable1ScrollPane = new JScrollPane(jTable1);
  public static int preisEintragen = 0;
  // Ende Attribute
  
  public WarenkorbGUI() { 
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 536; 
    int frameHeight = 796;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("JavaGUI");
    setResizable(false);
    Container cp = getContentPane();
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
    bEinkaufabschliessen.setText("Einkauf abschließen");
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
    
    setVisible(true);
  } 
  
  
  
  public static void bEinkaufabschliessen_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  }
  public static void Warenkorbhinzufügen(String Name, int Preis) {
	  Vector row = new Vector();
	  row.add(Name);
	  row.add(Preis+"€");
	  jTable1Model.addRow(row);
	  preisEintragen += Preis;
  }


}