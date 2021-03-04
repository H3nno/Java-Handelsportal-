package projekt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class WarenkorbGUI extends JFrame {
  // Anfang Attribute
  private JLabel lWarenkorb = new JLabel();
  private JList Warenkorb = new JList();
    private DefaultListModel WarenkorbModel = new DefaultListModel();
    private JScrollPane WarenkorbScrollPane = new JScrollPane(Warenkorb);
  private JLabel lGesamtPreis = new JLabel();
  private JButton bEinkaufabschliessen = new JButton();
  private JLabel lPreiseintragen = new JLabel();
  // Ende Attribute
  
  public WarenkorbGUI() { 
    // Frame-Initialisierung
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
    
    
    lWarenkorb.setBounds(149, 15, 342, 76);
    lWarenkorb.setText("Warenkorb");
    lWarenkorb.setHorizontalAlignment(SwingConstants.CENTER);
    lWarenkorb.setHorizontalTextPosition(SwingConstants.CENTER);
    lWarenkorb.setBackground(new Color(0xFFAFAF));
    lWarenkorb.setOpaque(true);
    lWarenkorb.setFont(new Font("Dialog", Font.BOLD, 24));
    cp.add(lWarenkorb);
    Warenkorb.setModel(WarenkorbModel);
    WarenkorbScrollPane.setBounds(20, 103, 470, 468);
    Warenkorb.setToolTipText("Hier werden ihr Warenkorb angezeigt");
    WarenkorbScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    WarenkorbScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    cp.add(WarenkorbScrollPane);
    lGesamtPreis.setBounds(24, 591, 206, 68);
    lGesamtPreis.setText("Gesamt Preis");
    lGesamtPreis.setHorizontalAlignment(SwingConstants.CENTER);
    lGesamtPreis.setHorizontalTextPosition(SwingConstants.CENTER);
    lGesamtPreis.setBackground(Color.CYAN);
    lGesamtPreis.setOpaque(true);
    lGesamtPreis.setFont(new Font("Dialog", Font.BOLD, 20));
    cp.add(lGesamtPreis);
    bEinkaufabschliessen.setBounds(26, 676, 459, 65);
    bEinkaufabschliessen.setText("Einkauf abschliessen");
    bEinkaufabschliessen.setMargin(new Insets(2, 2, 2, 2));
    bEinkaufabschliessen.setBackground(new Color(0xFFC800));
    bEinkaufabschliessen.setFont(new Font("Dialog", Font.BOLD, 22));
    cp.add(bEinkaufabschliessen);
    lPreiseintragen.setBounds(236, 592, 254, 68);
    lPreiseintragen.setText("Preis eintragen");
    lPreiseintragen.setFont(new Font("Dialog", Font.BOLD, 22));
    lPreiseintragen.setBackground(Color.CYAN);
    lPreiseintragen.setOpaque(true);
    lPreiseintragen.setHorizontalAlignment(SwingConstants.CENTER);
    lPreiseintragen.setHorizontalTextPosition(SwingConstants.CENTER);
    cp.add(lPreiseintragen);
    // Ende Komponenten
    bEinkaufabschliessen.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent evt) { 
          bEinkaufabschliessen_ActionPerformed(evt);
          
        }
      });
    
    setVisible(true);
  }
  public void bEinkaufabschliessen_ActionPerformed(ActionEvent evt) {
	    // TODO hier Quelltext einfügen
	    
  }// end of public JavaGUI
}
  // Anfang Methoden