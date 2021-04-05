package projekt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 05.04.2021
 * @author 
 */

public class GuthabenhinzufuegenGUI{
  // Anfang Attribute
  private JTextField jNumberField1 = new JTextField();
  private JLabel lGuthabenhinzufuegen = new JLabel();
  private JButton bSenden = new JButton();
  private JLabel lInfoText = new JLabel();
  // Ende Attribute
  JFrame GuthabenhinzufuegenGUI = new JFrame();
  public GuthabenhinzufuegenGUI() { 
    // Frame-Initialisierung
	GuthabenhinzufuegenGUI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 600; 
    int frameHeight = 300;
    GuthabenhinzufuegenGUI.setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - GuthabenhinzufuegenGUI.getSize().width) / 2;
    int y = (d.height - GuthabenhinzufuegenGUI.getSize().height) / 2;
    GuthabenhinzufuegenGUI.setLocation(x, y);
    GuthabenhinzufuegenGUI.setTitle("guthabenhinzufuegen");
    GuthabenhinzufuegenGUI.setResizable(false);
    Container cp = GuthabenhinzufuegenGUI.getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jNumberField1.setBounds(24, 107, 267, 52);
    jNumberField1.setText("0");
    cp.add(jNumberField1);
    lGuthabenhinzufuegen.setBounds(79, 13, 350, 52);
    lGuthabenhinzufuegen.setText("Guthaben hinzufuegen");
    lGuthabenhinzufuegen.setVisible(true);
    lGuthabenhinzufuegen.setFont(new Font("Dialog", Font.BOLD, 22));
    lGuthabenhinzufuegen.setHorizontalAlignment(SwingConstants.CENTER);
    lGuthabenhinzufuegen.setBackground(new Color(0xFFAFAF));
    lGuthabenhinzufuegen.setOpaque(true);
    lGuthabenhinzufuegen.setForeground(Color.BLACK);
    cp.add(lGuthabenhinzufuegen);
    bSenden.setBounds(298, 107, 187, 52);
    bSenden.setText("Senden");
    bSenden.setMargin(new Insets(2, 2, 2, 2));
    bSenden.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bSenden_ActionPerformed(evt);
      }
    });
    bSenden.setFont(new Font("Dialog", Font.BOLD, 18));
    bSenden.setBackground(Color.CYAN);
    cp.add(bSenden);
    lInfoText.setBounds(10, 164, 550, 84);
    lInfoText.setText("Guthaben eintragen und auf Senden drücken.Warum brauchen wir überhaupt mehr ?");
    lInfoText.setVerticalAlignment(SwingConstants.TOP);
    lInfoText.setHorizontalAlignment(SwingConstants.LEFT);
    lInfoText.setHorizontalTextPosition(SwingConstants.CENTER);
    cp.add(lInfoText);
    // Ende Komponenten
    
    GuthabenhinzufuegenGUI.setVisible(true);
  } // end of public guthabenhinzufuegen
  
  // Anfang Methoden
  
  public void bSenden_ActionPerformed(ActionEvent evt) {
	    String Username = LoginGUI.NAME;
		int Stelle = InteractBenutzerdaten.StelleArray(Username);
		Benutzer[] Liste = InteractBenutzerdaten.readCSV();
		int guthaben = 0;
		int aktguthaben;
		try {
			   guthaben = Integer.parseInt(jNumberField1.getText());
			   aktguthaben = Integer.parseInt(Liste[Stelle].getGuthaben());
			   guthaben = guthaben + aktguthaben;
			}
			catch (NumberFormatException e)
			{
				lInfoText.setText("Bitte NUR Zahlen eingeben");
			}

		if (Stelle != -1) {
			Liste[Stelle].setGuthaben(Integer.toString(guthaben));
			InteractBenutzerdaten.writeCSV(Liste);
  } // end of bSenden_ActionPerformed
 }
}// Ende Methoden // end of class guthabenhinzufuegen