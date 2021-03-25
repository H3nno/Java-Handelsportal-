package projekt;


public class Main extends Login{
		
	
	  public static void main(String[] args){
		   
		   Ware w1 = new Ware("Henning",0);
		   EinkaufsPortalGUI ekpo = new EinkaufsPortalGUI();
		   LoginGUI logo = new LoginGUI();
		   WarenkorbGUI waren = new WarenkorbGUI();
		   // Sachen zum Warenkorb hinzufuegen (Ware ware) :-)
		   waren.Warenkorbhinzufügen(w1);
		   
		   logo.dispose();
		   
		   
		  
		   
		  
		  
		  }
}
