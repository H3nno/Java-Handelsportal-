package projekt;


public class Main extends Login{
		
	
	  public static void main(String[] args){
		   
		   Ware w1 = new Ware("Henning",0);
		   EinkaufsPortalGUI ekpo = new EinkaufsPortalGUI();
		   LoginGUI logo = new LoginGUI();
		   WarenkorbGUI waren = new WarenkorbGUI();
		   // Sachen zum Warenkorb hinzufuegen (String name, int Preis) :-)
		   // Muss nat�rlich noch in die Einkaufsportal klasse und falls die Irgendwann mal fertig wird, wird auch das
		   // Objekt �pbergeben und nicht String und int
		   waren.Warenkorbhinzuf�gen(w1);
		   
		   logo.dispose();
		   
		   
		  
		   
		  
		  
		  }
}
