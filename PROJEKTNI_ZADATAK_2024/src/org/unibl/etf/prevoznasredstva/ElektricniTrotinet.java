package org.unibl.etf.prevoznasredstva;

import static org.unibl.etf.util.SimulacioniParametri.*;

/**
 * Klasa nasljednica klase "PrevoznoSredstvo". Ova klasa predstvalja električni trotinet koji može da bude iznajmljen od strane korisnika.
 * @author andjelabalaban
 *
 */
public class ElektricniTrotinet extends PrevoznoSredstvo {
	private static final long serialVersionUID = 1L;
	private static int maxKorisnika = MAX_BROJ_PUTNIKA_TROTINET;
	private int maxBrzina;
	
	/**
	 * Default-ni konstruktor.
	 */
	public ElektricniTrotinet() {
		super(maxKorisnika);
	}
	
	/**
	 * Konstruktor sa pet parametra koji predstavljaju ID, proizvođača, model, cijena i maksimalna brzina kretanja na trotinetu.
	 * @param id
	 * @param proizvodjac
	 * @param model
	 * @param cijenaNabavke
	 * @param maxBrzina
	 */
	public ElektricniTrotinet(String id, String proizvodjac, String model, double cijenaNabavke, int maxBrzina) {
		super(id, proizvodjac, model, cijenaNabavke, maxKorisnika);
		this.maxBrzina = maxBrzina;
	}

	/**
	 * Get-er za maksimalnu brzinu kretanja na trotinetu.
	 * @return maksimalna brzina kretanja na trotinetu.
	 */
	public int getMaxBrzina() {
		return maxBrzina;
	}

	/**
	 * Set-er za maksimalnu brzinu kretanja na trotinetu.
	 * @param maxBrzina
	 */
	public void setMaxBrzina(int maxBrzina) {
		this.maxBrzina = maxBrzina;
	}

	/**
	 * Get-er pomoću kojeg dobijam broj korisnika koji se može voziti na trotinetu.
	 */
	public int getMaxKorisnika() {
		return maxKorisnika;
	}
	
	/**
	 * Override-ovana toString metoda za ispis trotineta.
	 */
	@Override
	public String toString() {
//		return "\033[1mElektrični trotinet - \033[0m" + super.toString() + "\n - Maksimalna brzina: " + maxBrzina + "km/h";
		return "Električni trotinet - " + super.toString();
	}
	
	/**
	 * Override-ovana metoda za ispis informacija o trotinetu.
	 */
	@Override
	public String voziloInfo() {
		return "Električni trotinet - " + super.voziloInfo() + "\n - Maksimalna brzina: " + maxBrzina + "km/h";
	}
}
