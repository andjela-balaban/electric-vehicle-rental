package org.unibl.etf.korisnik;

/**
 * Klasa nasljednica klase Dokument koji reprezentuje ličnu kartu korisnika.
 * @author andjelabalaban
 *
 */
public class DokumentLicnaKarta extends Dokument {
	/**
	 * Default-ni konstruktor klase DokumentLicnaKarta.
	 */
	public DokumentLicnaKarta() {
		super();
	}
	
	/**
	 * Konstruktor klase DokumentLicnaKarta koji prima dva argumenta koji predstavljaju ime i prezime korisnika.
	 * @param ime
	 * @param prezime
	 */
	public DokumentLicnaKarta(String ime, String prezime) {
		super(ime, prezime);
	}
	
	/**
	 * Konstruktor klase DokumentLicnaKarta koji prima tri argumenta koji predstavljaju broj dokumenta, ime i prezime korisnika.
	 * @param id
	 * @param ime
	 * @param prezime
	 */
	public DokumentLicnaKarta(long id, String ime, String prezime) {
		super(id, ime, prezime);
	}
	
	/**
	 * Override-ovana toString metoda za ispis lične karte.
	 */
	@Override
	public String toString() {
		return "Lična karta broj: " + super.toString();
	}
}
