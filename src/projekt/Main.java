package projekt;


public class Main extends Login{
		
	
	  public static void main(String[] args){
		    
		   Login LoginFenster = new Login();
		   WarenkorbGUI waren = new WarenkorbGUI();
		   // Sachen zum Warenkorb hinzufuegen (String name, int Preis) :-)
		   // Muss natürlich noch in die Einkaufsportal klasse und falls die Irgendwann mal fertig wird, wird auch das
		   // Objekt üpbergeben und nicht String und int
		   WarenkorbGUI.Warenkorbhinzufügen("Henning",0);
		   WarenkorbGUI.Warenkorbhinzufügen("Jeremiiiiiii", 100);
		   WarenkorbGUI.Warenkorbhinzufügen("Kevin", 187);
		   WarenkorbGUI.Warenkorbhinzufügen("Marcelooo", 420);
		   
		   //LoginFenster.dispose();
		   
		   
		  
		   
		  
		  
		  }
}
