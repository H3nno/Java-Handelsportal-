package projekt;

public class Benutzer {

	String Vorname;
	String Nachname;
	String Username;
	String Passwort;
	String Guthaben;

	public Benutzer(String pVorname, String pNachname, String pUsername, String pPasswort, String pGuthaben) {
		Vorname = pVorname;
		Nachname = pNachname;
		Username = pUsername;
		Passwort = pPasswort;
		Guthaben = pGuthaben;

	}

	public String getVorname() {
		return Vorname;
	}

	public void setVorname(String vorname) {
		Vorname = vorname;
	}

	public String getNachname() {
		return Nachname;
	}

	public void setNachname(String nachname) {
		Nachname = nachname;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPasswort() {
		return Passwort;
	}

	public void setPasswort(String passwort) {
		Passwort = passwort;
	}

	public String getGuthaben() {
		return Guthaben;
	}

	public void setGuthaben(String guthaben) {
		Guthaben = guthaben;
	}

}
