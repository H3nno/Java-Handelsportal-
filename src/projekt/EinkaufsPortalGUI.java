package projekt;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 25.03.2021
 * @author
 */

public class EinkaufsPortalGUI {
	// Anfang Attribute
	private ArrayList<Ware> list = new ArrayList<>();
	private JLabel lEinkaufsportal = new JLabel();
	private DefaultListModel jList1Model = new DefaultListModel();
	private JButton bWarenkorbhinzufuegen = new JButton();
	private JButton bZumWarenkorb = new JButton();
	private JButton admin = new JButton();
	private Ware temp;
	private JLabel AngemeldetAls = new JLabel();
	private JButton Benutzerverwaltung = new JButton();
	private JButton Abmelden = new JButton();
	private JLabel lblNewLabel = new JLabel("Artikel im Warenkorb : " + WarenkorbGUI.warenlist.size());
	private JLabel lblNewLabel_1 = new JLabel("Guthaben :");

	private JTextArea jTextArea1 = new JTextArea("");
	private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
	private JList<Ware> list_1 = new JList();
	// Ende Attribute
	DefaultListModel<Ware> Modell = new DefaultListModel<>();
	JFrame EinkaufsPortal = new JFrame();

	public EinkaufsPortalGUI() {
		// Waren erschaffen
		Modell.addElement(new Ware("Henning", 0, "leichte Erstinstallation"));
		Modell.addElement(new Ware("Jermy", 10, "schon Vorkonfiguriert"));
		Modell.addElement(new Ware("Kevin", 20, "schwer zu bedienen"));
		Modell.addElement(new Ware("Marcelo", 30, "Marcelooooo"));
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
		// JList addElement
		list_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				temp = list_1.getSelectedValue();
				jTextArea1.setText(temp.getBeschreibung() + '\n' + '\n' + "Preis : " + temp.getPreis() + "€");
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
		admin.setBounds(24, 28, 150, 50);
		admin.setText("Verwaltung");
		admin.setBackground(Color.CYAN);
		admin.setMargin(new Insets(2, 2, 2, 2));
		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				admin_ActionPerformed(evt);
			}
		});
		if (LoginGUI.NAME.equals("admin")) {
			cp.add(admin);
		}

		AngemeldetAls.setBounds(700, 10, 150, 30);
		AngemeldetAls.setText("Angemeldet als: " + LoginGUI.NAME);

		cp.add(AngemeldetAls);

		Benutzerverwaltung.setBounds(700, 50, 150, 30);
		Benutzerverwaltung.setText("Benutzerverwaltung");
		Benutzerverwaltung.setBackground(Color.CYAN);
		Benutzerverwaltung.setMargin(new Insets(2, 2, 2, 2));
		Benutzerverwaltung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Benutzerverwaltung_ActionPerformed(evt);
			}
		});
		cp.add(Benutzerverwaltung);

		Abmelden.setBounds(700, 90, 150, 30);
		Abmelden.setText("Abmelden");
		Abmelden.setBackground(Color.CYAN);
		Abmelden.setMargin(new Insets(2, 2, 2, 2));
		Abmelden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Abmelden_ActionPerformed(evt);
			}
		});
		cp.add(Abmelden);

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
		bZumWarenkorb.setBounds(700, 478, 155, 49);
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
		lblNewLabel.setBounds(700, 530, 155, 13);
		cp.add(lblNewLabel);
		lblNewLabel_1.setBounds(700, 34, 150, 13);
		cp.add(lblNewLabel_1);

		// Ende Komponenten

		EinkaufsPortal.setVisible(true);
	} // end of public Einkaufsportal

	// Anfang Methoden

	public void bWarenkorbhinzufuegen_ActionPerformed(ActionEvent evt) {
		WarenkorbGUI.warenlist.add(temp);
		lblNewLabel.setText("Artikel im Warenkorb : " + WarenkorbGUI.warenlist.size());

	} // end of bWarenkorbhinzufuegen_ActionPerformed

	public void bZumWarenkorb_ActionPerformed(ActionEvent evt) {
		new WarenkorbGUI();
		EinkaufsPortal.dispose();

	}

	public void admin_ActionPerformed(ActionEvent evt) {

		if (LoginGUI.NAME != null) {

			if (LoginGUI.NAME.equals("admin")) {
				System.out.println("JA ADMIN");

			} else {
				System.out.println("NEEEIN :(");
			}
		}

	}

	public void Abmelden_ActionPerformed(ActionEvent evt) {
		new LoginGUI();
		EinkaufsPortal.dispose();

	}

	public void Benutzerverwaltung_ActionPerformed(ActionEvent evt) {
		EinkaufsPortal.dispose();
		new BenutzerverwaltungGUI();

	}
} // end of class Einkaufsportal
