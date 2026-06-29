package org.unibl.etf.kompanija;


/**
 * Korisnički definisan izuzetak koji signalizira da je vozilo van opsega grada.
 * @author andjelabalaban
 *
 */
public class KoordinataVanOpsegaGradaException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Default-ni konstruktor.
	 */
	public KoordinataVanOpsegaGradaException() {
		super();
	}
	
	/**
	 * Parametrizovani konstruktor sa detaljnom porukom o izuzetku.
	 * @param message
	 */
	public KoordinataVanOpsegaGradaException(String message) {
		super(message);
	}
}
