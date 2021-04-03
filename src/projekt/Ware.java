package projekt;

public class Ware {
	private String Name;
	private int Preis;
	private String Beschreibung;
	// Konstruktor 
	public Ware(String _Name, int _Preis,String _Beschreibung) {
		Name = _Name;
		Preis = _Preis;
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
	public int getPreis() {
		return Preis;
	}
	public void setPreis(int preis) {
		Preis = preis;
	}
	@Override
	public String toString() {
		return Name;
	}
	
}
