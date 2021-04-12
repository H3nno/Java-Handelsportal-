package projekt;

public class Ware {
	private String Name;
	private String Preis;
	private String Beschreibung;
	// Konstruktor 
	public Ware(String _Name, String tempPreis,String _Beschreibung) {
		Name = _Name;
		Preis = tempPreis;
		Beschreibung = _Beschreibung;
		
	}
	//get set und so
	public String getBeschreibung() {
		return Beschreibung;
	}
	public void setBeschreibung(String besch) {
		Beschreibung = besch;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPreis() {
		return Preis;
	}
	public void setPreis(String preis) {
		Preis = preis;
	}
	@Override
	public String toString() {
		return Name;
	}
	
}
