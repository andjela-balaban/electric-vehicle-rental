package org.unibl.etf.prevoznasredstva;

import static org.unibl.etf.util.SimulacioniParametri.*;

/**
 * Klasa nasljednica klase "PrevoznoSredstvo". Ova klasa predstvalja električni bicikl koji može da bude iznajmljen od strane korisnika.
 * @author andjelabalaban
 *
 */
public class ElektricniBicikl extends PrevoznoSredstvo {
	private static final long serialVersionUID = 1L;
	private static int maxKorisnika = MAX_BROJ_PUTNIKA_AUTOMOBIL;
	private int domet;	//autonomija
	
	/**
	 * Default-ni konstruktor.
	 */
	public ElektricniBicikl() {
		super(maxKorisnika);
	}
	
	/**
	 * Konstruktor sa pet parametra koji predstavljaju ID, proizvođača, model, cijena i domet koji se može preći na biciklu.
	 * @param id
	 * @param proizvodjac
	 * @param model
	 * @param cijenaNabavke
	 * @param domet
	 */
	public ElektricniBicikl(String id, String proizvodjac, String model, double cijenaNabavke, int domet) {
		super(id, proizvodjac, model, cijenaNabavke, maxKorisnika);
		this.domet = domet;
	}

	/**
	 * Get-er za domet koliki se može preći sa jednim punjenjem na biciklu.
	 * @return domet koliki se može preći sa jednim punjenjem na biciklu.
	 */
	public int getDomet() {
		return domet;
	}

	/**
	 * Set-er za domet koliki se može preći sa jednim punjenjem na biciklu.
	 * @param domet
	 */
	public void setDomet(int domet) {
		this.domet = domet;
	}

	/**
	 * Get-er pomoću kojeg dobijam broj korisnika koji se može voziti na biciklu.
	 */
	public int getMaxKorisnika() {
		return maxKorisnika;
	}
	
	/**
	 * Override-ovana toString metoda za ispis bicikla.
	 */
	@Override
	public String toString() {
//		return "\033[1mElektrični bicikl - \033[0m" + super.toString() + "\n - Domet sa jednim punjenjem (autonomija): " + domet + "km";
		return "Električni bicikl - " + super.toString();
	}
	
	/**
	 * Override-ovana metoda za ispis informacija o biciklu.
	 */
	@Override
	public String voziloInfo() {
		return "Električni bicikl - " + super.voziloInfo() + "\n - Domet sa jednim punjenjem (autonomija): " + domet + "km";
	}
}
