package org.unibl.etf.korisnik;

/**
 * Klasa nasljednica klase Dokument koji reprezentuje vozačku dozvolu korisnika.
 * @author andjelabalaban
 *
 */
public class DokumentVozackaDozvola extends Dokument {
	/**
	 * Default-ni konstruktor klase DokumentVozackaDozvola.
	 */
	public DokumentVozackaDozvola() {
		super();
	}
	
	/**
	 * Konstruktor klase DokumentVozackaDozvola koji prima dva argumenta koji predstavljaju ime i prezime korisnika.
	 * @param ime
	 * @param prezime
	 */
	public DokumentVozackaDozvola(String ime, String prezime) {
		super(ime, prezime);
	}
	
	/**
	 * Konstruktor klase DokumentVozackaDozvola koji prima tri argumenta koji predstavljaju broj dokumenta, ime i prezime korisnika.
	 * @param id
	 * @param ime
	 * @param prezime
	 */
	public DokumentVozackaDozvola(long id, String ime, String prezime) {
		super(id, ime, prezime);
	}
	
	/**
	 * Override-ovana toString metoda za ispis vozačke dozvole.
	 */
	@Override
	public String toString() {
		return "Vozačka dozvola broj: " + super.toString();
	}
}
