package org.unibl.etf.korisnik;

/**
 * Klasa koja reprezentuje korisnika koji može da iznajmi električno vozilo. Ova klasa sadrži sve neophodne informacije o korisniku.
 * @author andjelabalaban
 *
 */
public class Korisnik {
	private String korisnikID;
	private String ime;
	private String prezime;
	private boolean straniDrzavljanin; 
	private Dokument id;
	private DokumentVozackaDozvola vozackaDozvola;

	/**
	 * Default-ni konstruktor klase Korisnik.
	 */
	public Korisnik() {
		super();
	}
	
	/**
	 * Konstruktor klase Korisnik sa parametrom korisnikID, koji predstavlja ID korisnika.
	 * @param korisnikID
	 */
	public Korisnik(String korisnikID) {
		this.korisnikID = korisnikID;
	}

	/**
	 * Konstruktor klase Korisnik sa parametrima koji predstavljaju ime, prezime, 
	 * parametar "straniDrzavljanin" koji nam daje informaciju da li je korisnik stranac ili nije, te dokument korisnika.
	 * @param ime
	 * @param prezime
	 * @param straniDrzavljanin
	 * @param id
	 */
	public Korisnik(String ime, String prezime, boolean straniDrzavljanin, Dokument id) {
		this.ime = ime;
		this.prezime = prezime;
		this.id = id;
		this.straniDrzavljanin = straniDrzavljanin;
	}
	
	/**
	 * Konstruktor klase Korisnik sa paremetrima koji predstavljaju ime, prezime i dokument korisnika.
	 * @param ime
	 * @param prezime
	 * @param id
	 */
	public Korisnik(String ime, String prezime, Dokument id) {
		this.ime = ime;
		this.prezime = prezime;
		this.id = id;
	}
	
	/**
	 * Konstruktor klase Korisnik sa parametrima koji predstavljaju ime, prezime, parametar "straniDrzavljanin" 
	 * koji nam daje informaciju da li je korisnik stranac ili nije, dokument korisnika, te vozačku dozvolu korisnika
	 * @param ime
	 * @param prezime
	 * @param straniDrzavljanin
	 * @param id
	 * @param vozackaDozvola
	 */
	public Korisnik(String ime, String prezime, boolean straniDrzavljanin, Dokument id, DokumentVozackaDozvola vozackaDozvola) {
		this.ime = ime;
		this.prezime = prezime;
		this.id = id;
		this.straniDrzavljanin = straniDrzavljanin;
		this.vozackaDozvola = vozackaDozvola;
	}
	
	/**
	 * Konstruktor klase Korisnik sa parametrima koji predstavljaju ime, prezime,
	 * dokument korisnika, te vozačku dozvolu korisnika.
	 * @param ime
	 * @param prezime
	 * @param id
	 * @param vozackaDozvola
	 */
	public Korisnik(String ime, String prezime, Dokument id, DokumentVozackaDozvola vozackaDozvola) {
		this.ime = ime;
		this.prezime = prezime;
		this.id = id;
		this.vozackaDozvola = vozackaDozvola;
	}
	
	/**
	 * Get-er korisnikID atributa.
	 * @return korisnikID
	 */
	public String getKorisnikID() {
		return korisnikID;
	}

	/**
	 * Set-er korisnikID atributa.
	 * @param ID korisnika.
	 */
	public void setKorisnikID(String korisnikID) {
		this.korisnikID = korisnikID;
	}

	/**
	 * Get-er za ime korisnika.
	 * @return ime korisnika.
	 */
	public String getIme() {
		return ime;
	}

	/**
	 * Set-er za ime korisnika.
	 * @param ime
	 */
	public void setIme(String ime) {
		this.ime = ime;
	}

	/**
	 * Get-er za prezime korisnika
	 * @return prezime korisnika.
	 */
	public String getPrezime() {
		return prezime;
	}

	/**
	 * Set-er za prezime korisnika.
	 * @param prezime
	 */
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	/**
	 * Get-er za ID korisnika
	 * @return dokument korisnika, može biti pasoš ili lična karta.
	 */
	public Dokument getIdDokumenta() {
		return id;
	}
	
	/**
	 * Get-er za atribut koji nam govori da li je korisnik strani državljanin.
	 * @return da li je korisnik stranac ili domaći.
	 */
	public boolean isStraniDrzavljanin() {
		return this.straniDrzavljanin;
	}
	
	/**
	 * Set-er za vozačku dozvolu.
	 * @param vd
	 */
	public void setVozackaDozvola(DokumentVozackaDozvola vd) {
		this.vozackaDozvola = vd;
	}
	
	/**
	 * Get-er za vozačku dozvolu korisnika.
	 * @return vozačka dozvola korisnika.
	 */
	public DokumentVozackaDozvola getVozackaDozvola() {
		return this.vozackaDozvola;
	}

	/**
	 * Override-ovana toString metoda za prikaz korisnika.
	 */
	@Override
	public String toString() {
//		return korisnikID + " - " + ime + " " + prezime + " (ID: " + id.toString() + ")";
		return ime + " " + prezime + " (ID: " + id.toString() + ")";
	}
}
