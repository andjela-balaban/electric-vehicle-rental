package org.unibl.etf.kompanija;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.unibl.etf.korisnik.Korisnik;
import org.unibl.etf.prevoznasredstva.*;

/**
 * Klasa koja predstavlja jedan račun koji se generiše po završetku iznajmljivanja prevoznog sredstva.
 * @author andjelabalaban
 *
 */
public class Racun {
	private LocalDateTime datum;
	private Korisnik korisnik;
	private Iznajmljivanje iznajmljivanje;
	private boolean desetiIznajmljen;
	private double cijenaIznajmljivanja;
	private double iznos;
	private double popust;
	private double promocija;

	/**
	 * Konstruktor klasa Racun koji na osnovu parametara koji su mu prosljedjeni generiše račun.
	 * @param datum
	 * @param korisnik
	 * @param iznajmljivanje
	 * @param desetiIznajmljen
	 * @param cijenaIznajmljivanja
	 * @param iznos
	 * @param popust
	 * @param promocija
	 */
	public Racun(LocalDateTime datum, Korisnik korisnik, Iznajmljivanje iznajmljivanje, boolean desetiIznajmljen, double cijenaIznajmljivanja, double iznos, double popust, double promocija) {
		this.datum = datum;
		this.korisnik = korisnik;
		this.iznajmljivanje = iznajmljivanje;
		this.desetiIznajmljen = desetiIznajmljen;
		this.cijenaIznajmljivanja = cijenaIznajmljivanja;
		this.iznos = iznos;
		this.popust = popust;
		this.promocija = promocija;
	}
	
	/**
	 * Get-er za datum kada je prevonzo sredstvo iznajmljneo.
	 * @return
	 */
	public LocalDateTime getDatum() {
		return datum;
	}

	/**
	 * Set-er za datum kada je prevozno sredstvo iznajmljneo.
	 * @param datum
	 */
	public void setDatum(LocalDateTime datum) {
		this.datum = datum;
	}

	/**
	 * Get-er za korisnika iznajmljenog prevoznog sredstva.
	 * @return
	 */
	public Korisnik getKorisnik() {
		return korisnik;
	}

	/**
	 * Set-er za korisnika prevoznog sredstva.
	 * @param korisnik
	 */
	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	/**
	 * Get-er za dobijanje iznajmljivanja za koji se generise racun.
	 * @return
	 */
	public Iznajmljivanje getIznajmljivanje() {
		return iznajmljivanje;
	}

	/**
	 * Set-er za iznajmljivanja za koji se generise racun.
	 * @param iznajmljivanje
	 */
	public void setIznajmljivanje(Iznajmljivanje iznajmljivanje) {
		this.iznajmljivanje = iznajmljivanje;
	}

	/**
	 * Get-er za dobijanje informacije da li je iznajmljivanje bilo deseto po redu.
	 * @return
	 */
	public boolean isDesetiIznajmljen() {
		return desetiIznajmljen;
	}

	/**
	 * Set-er da je iznajmljivanje bilo deseto.
	 * @param desetiIznajmljen
	 */
	public void setDesetiIznajmljen(boolean desetiIznajmljen) {
		this.desetiIznajmljen = desetiIznajmljen;
	}

	/**
	 * Get-er cijene iznajmljivanja.
	 * @return
	 */
	public double getCijenaIznajmljivanja() {
		return cijenaIznajmljivanja;
	}

	/**
	 * Set-er cijene iznajmljivaja;
	 * @param cijenaIznajmljivanja
	 */
	public void setCijenaIznajmljivanja(double cijenaIznajmljivanja) {
		this.cijenaIznajmljivanja = cijenaIznajmljivanja;
	}

	/**
	 * Get-er koji predstavlja iznos iznajmljivanja.
	 * @return
	 */
	public double getIznos() {
		return iznos;
	}

	/**
	 * Set-er kojim se podesava iznos iznajmljivanja.
	 * @param iznos
	 */
	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	/**
	 * Get-er iznosa popusta.
	 * @return
	 */
	public double getPopust() {
		return popust;
	}

	/**
	 * Set-er iznosa popusta.
	 * @param popust
	 */
	public void setPopust(double popust) {
		this.popust = popust;
	}

	/**
	 * Get-er iznosa promocije.
	 * @return
	 */
	public double getPromocija() {
		return promocija;
	}

	/**
	 * Set-er za iznos promocija.
	 * @param promocija
	 */
	public void setPromocija(double promocija) {
		this.promocija = promocija;
	}

	/**
	 * Override-ovana toString metoda za ispis racuna.
	 */
	@Override
	public String toString() {
		StringBuffer bw = new StringBuffer();
		// zaglavlje racuna
		bw.append("-------------------------------------------------------------\n");
		bw.append("\t \033[1m ePJ2 - eMobility kompanija \033[0m \n");
//		bw.append("\t  Adresa: Braće Jugovića 33.\n");
		bw.append("\t  Adresa: Javo Javoslava 33.\n");
		bw.append("\t       4892100 Javograd\n");
		bw.append("\t       Tel. 051/633-447\n");
		bw.append("     ---------------------------------------\n");
		bw.append("\n   \033[1m RAČUN ZA IZNAJMLJIVAJE PREVOZNOG SREDSTVA \033[0m \n\n");
		// racun
		bw.append("- ID iznajmljenog vozila: " + iznajmljivanje.getIdPrevoznogSredstva() + "\n");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
		String formatiraniDatum = datum.format(formatter);
		bw.append("- Datum i vrijeme iznajmljivanja: " + formatiraniDatum + "\n");
		bw.append("- Ime korisnika koji je iznajmio vozilo: " + korisnik.getIme() + " " + korisnik.getPrezime() + " (ID: " + korisnik.getKorisnikID() + ")\n");
		bw.append("- Lokacija na kojoj je vozilo preuzeto: [" + iznajmljivanje.getPocetnaLokacija()[0] + "][" + iznajmljivanje.getPocetnaLokacija()[1] + "]\n");
		bw.append("- Lokacija na kojoj je vozilo ostavljeno: [" + iznajmljivanje.getOdrediste()[0] + "][" + iznajmljivanje.getOdrediste()[1] + "]\n");
		bw.append("- Trajanje korištenja: " + iznajmljivanje.getTrajanje() + "s\n");
		if(iznajmljivanje.getPrevoznoSredstvo() instanceof ElektricniAutomobil) {
			bw.append("- ID korisnika: " + korisnik.getKorisnikID() + "\n");
			bw.append("- " + korisnik.getVozackaDozvola() + "\n");
		}
		bw.append("- Promocija: " + (iznajmljivanje.isPromocija() ? "DA" : "NE") + "\n\t - Iznos promocije: " + promocija + "KM\n");
		bw.append("- Popust: " + (desetiIznajmljen ? "DA" : "NE") + "\n\t - Iznos popusta: " + popust + "KM\n");
		if(iznajmljivanje.isKvar() == true) {
			bw.append("- Kvar: " + iznajmljivanje.getOpisKvara() + "\n");
			bw.append("- Datum i vrijeme kvara: " + formatiraniDatum + "\n");
		}
		bw.append("Iznos: " + iznos + "KM\n");
		bw.append("\n- Ukupna cijena za placanje:  " + cijenaIznajmljivanja + "KM\n");
		bw.append("-------------------------------------------------------------\n");
		return bw.toString();
	}
	
	
}
