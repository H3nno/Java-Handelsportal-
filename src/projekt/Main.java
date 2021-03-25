package projekt;


public class Main extends Login{
		
	
	  public static void main(String[] args){
		   
		   
		   
		   LoginGUI logo = new LoginGUI();
		   // Sachen relevant zum Warenkorb #nostatic 
		   WarenkorbGUI waren1 = new WarenkorbGUI();
		   Ware w1 = new Ware("Henning",0);
		   Ware w2 = new Ware("Hennings",128);
		   waren1.Warenkorbhinzufügen(w1);
		   waren1.Warenkorbhinzufügen(w2);
		   EinkaufsPortalGUI ekpo = new EinkaufsPortalGUI();
		   ekpo.Jlisthinzu(w1);
		   
		   
		  
		   
		  
		  
		  }
}
