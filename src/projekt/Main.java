package projekt;


public class Main extends Login{
		
	
	  public static void main(String[] args){
		    
		   EinkaufsPortalGUI ekpo = new EinkaufsPortalGUI();
		   LoginGUI logo = new LoginGUI();
		   WarenkorbGUI waren = new WarenkorbGUI();
		   // Sachen zum Warenkorb hinzufuegen (String name, int Preis) :-)
		   // Muss nat�rlich noch in die Einkaufsportal klasse und falls die Irgendwann mal fertig wird, wird auch das
		   // Objekt �pbergeben und nicht String und int
		   WarenkorbGUI.Warenkorbhinzuf�gen("Henning",0);
		   WarenkorbGUI.Warenkorbhinzuf�gen("Jeremy", 100);
		   WarenkorbGUI.Warenkorbhinzuf�gen("Kevin", 187);
		   WarenkorbGUI.Warenkorbhinzuf�gen("Marcelooo", 420);
		   
		   logo.dispose();
		   
		   
		  
		   
		  
		  
		  }
}
