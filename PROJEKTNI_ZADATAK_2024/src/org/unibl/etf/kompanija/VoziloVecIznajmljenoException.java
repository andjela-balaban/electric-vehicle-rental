package org.unibl.etf.kompanija;

/**
 * Korisnički definisan izuzetak koji signalizira da je vozilo već iznajmljeno u jednom vremenskom intervalu i da neije moguće ponovo da se iznajmi za taj isti interval.
 * @author andjelabalaban
 *
 */
public class VoziloVecIznajmljenoException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Default-ni konstruktor.
	 */
	public VoziloVecIznajmljenoException() {
		super();
	}
	
	/**
	 * Parametrizovani konstruktor sa detaljnom porukom o izuzetku.
	 * @param message
	 */
	public VoziloVecIznajmljenoException(String message) {
		super(message);
	}
}
