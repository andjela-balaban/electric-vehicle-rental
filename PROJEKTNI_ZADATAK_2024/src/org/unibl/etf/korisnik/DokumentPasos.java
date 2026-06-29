package org.unibl.etf.korisnik;

/**
 * Klasa nasljednica klase Dokument koji reprezentuje pasoš korisnika.
 * @author andjelabalaban
 *
 */
public class DokumentPasos extends Dokument {
	/**
	 * Default-ni konstruktor klase DokumentPasos.
	 */
	public DokumentPasos() {
		super();
	}
	
	/**
	 * Konstruktor klase DokumentPasos koji prima dva argumenta koji predstavljaju ime i prezime korisnika.
	 * @param ime
	 * @param prezime
	 */
	public DokumentPasos(String ime, String prezime) {
		super(ime, prezime);
	}
	
	/**
	 * Konstruktor klase DokumentPasos koji prima tri argumenta koji predstavljaju broj dokumenta, ime i prezime korisnika.
	 * @param id
	 * @param ime
	 * @param prezime
	 */
	public DokumentPasos(long id, String ime, String prezime) {
		super(id, ime, prezime);
	}
	
	/**
	 * Override-ovana toString metoda za ispis pasoša.
	 */
	@Override
	public String toString() {
		return "Pasoš broj: " + super.toString();
	}
}
