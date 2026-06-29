package org.unibl.etf.kompanija;


/**
 * Korisnički definisan izuzetak koji signalizira da je vozilo ne postoji u listi prevoznih sredstava.
 * @author andjelabalaban
 *
 */
public class VoziloNePostojiUListiPrevoznihSredstavaException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Default-ni konstruktor.
	 */
	public VoziloNePostojiUListiPrevoznihSredstavaException() {
		super();
	}
	
	/**
	 * Parametrizovani konstruktor sa detaljnom porukom o izuzetku.
	 * @param message
	 */
	public VoziloNePostojiUListiPrevoznihSredstavaException(String message) {
		super(message);
	}
}
