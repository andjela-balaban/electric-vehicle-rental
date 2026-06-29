package org.unibl.etf.prevoznasredstva;

import java.time.*;
import java.time.format.*;
import static org.unibl.etf.util.SimulacioniParametri.*;

/**
 * Klasa nasljednica klase "PrevoznoSredstvo". Ova klasa predstvalja električni automobil koji može da bude iznajmljen od strane korisnika.
 * @author andjelabalaban
 *
 */
public class ElektricniAutomobil extends PrevoznoSredstvo {
	private static final long serialVersionUID = 1L;
	private static int maxKorisnika = MAX_BROJ_PUTNIKA_AUTOMOBIL;
	private String opis;
	private LocalDate datumNabavke;
	
	/**
	 * Default-ni konstruktor.
	 */
	public ElektricniAutomobil() {
		super(maxKorisnika);
	}
	
	/**
	 * Konstruktor sa šest parametra koji predstavljaju ID, proizvođača, model, datum kada je nabavljen, cijena i opis automobila.
	 * @param id
	 * @param proizvodjac
	 * @param model
	 * @param datumNabavke
	 * @param cijenaNabavke
	 * @param opis
	 */
	public ElektricniAutomobil(String id, String proizvodjac, String model, LocalDate datumNabavke, double cijenaNabavke, String opis) {
		super(id, proizvodjac, model, cijenaNabavke, maxKorisnika);
		this.opis = opis;
		this.datumNabavke = datumNabavke;
	}

	/**
	 * Get-er za opis automobila.
	 * @return opis automobila.
	 */
	public String getOpis() {
		return opis;
	}

	/**
	 * Set-er za opis automobila.
	 * @param opis
	 */
	public void setDomet(String opis) {
		this.opis = opis;
	}
	
	/**
	 * Get-er za datum nabavke automobila. 
	 * @return datum nabavke automobila.
	 */
	public LocalDate getDatumNabavke() {
		return datumNabavke;
	}

	/**
	 * Set-er datuma nabavke automobila.
	 * @param datumNabavke
	 */
	public void setDatumNabavke(LocalDate datumNabavke) {
		this.datumNabavke = datumNabavke;
	}

	/**
	 * Get-er pomoću kojeg dobijam broj korisnika koji se može voziti u automobilu.
	 */
	public int getMaxKorisnika() {
		return maxKorisnika;
	}
	
	/**
	 * Override-ovana toString metoda za ispis automobila.
	 */
	@Override
	public String toString() {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//		// Formatiranje datuma u string
//		String formatiraniDatum = datumNabavke.format(formatter);
//		return "\033[1mElektrični automobil - \033[0m" + super.toString() + "\n - Datum nabavke: " + formatiraniDatum + "\n - Opis: " + opis;
		return "Električni automobil - " + super.toString();
	}

	/**
	 * Override-ovana metoda za ispis informacija o automobilu.
	 */
	@Override
	public String voziloInfo() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		// Formatiranje datuma u string
		String formatiraniDatum = datumNabavke.format(formatter);
		return "Električni automobil - " + super.voziloInfo() + "\n - Datum nabavke: " + formatiraniDatum + "\n - Opis: " + opis;

	}

}
