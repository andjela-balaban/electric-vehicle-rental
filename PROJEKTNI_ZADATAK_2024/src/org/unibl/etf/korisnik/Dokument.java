package org.unibl.etf.korisnik;

/**
 * Apstraktna klasa koja reprezentuje dokument koji korisnik može da ima. Ova klasa je namjenjena da bude roditeljska klasa svim konkretnim 
 * implementacijama dokumenata koji su neophodni korisniku.
 * @author andjelabalaban
 *
 */
public abstract class Dokument {
	private long id;
	private String ime;
	private String prezime;
	private static long count = 1;
	
	/**
	 * Default-ni konstruktor.
	 */
	public Dokument() {
		super();
		id = count++;
	}
	
	/**
	 * Konstruktor koji prima ime i prezime korisnika i na osnovu tih informacija pravi dokument za korisnika.
	 * @param ime
	 * @param prezime
	 */
	public Dokument(String ime, String prezime) {
		super();
		id = count++;
		this.ime = ime;
		this.prezime = prezime;
	}
	
	/**
	 * Konstruktor koji prima identifikacioni broj dokumenta, ime i prezime korisnika i na osnovu tih informacija pravi dokument za korisnika.
	 * @param id
	 * @param ime
	 * @param prezime
	 */
	public Dokument(long id, String ime, String prezime) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
	}
	
	/**
	 * Get-er za identifikacioni broj dokumenta.
	 * @return identifikacioni broj dokumenta.
	 */
	public long getId() {
		return id;
	}

	/**
	 * Set-er za identifikacioni broj dokumenta.
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
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
	 * Get-er za prezime korisnika.
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
	 * Override-ovana toString metoda za prikaz identifikacionog broja dokumenta.
	 */
	@Override
	public String toString() {
		return Long.toString(id);
	}
}
