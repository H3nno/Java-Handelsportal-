package projekt;

public class Ware {
	private String Name;
	private int Preis;
	// Konstruktor 
	public Ware(String _Name, int _Preis) {
		Name = _Name;
		Preis = _Preis;
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
	
}
