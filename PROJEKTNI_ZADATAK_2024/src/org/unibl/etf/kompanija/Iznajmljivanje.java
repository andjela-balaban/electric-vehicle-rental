package org.unibl.etf.kompanija;

import java.time.*;
import java.time.format.*;
import org.unibl.etf.prevoznasredstva.*;
import org.unibl.etf.util.KvarGenerator;
//import org.unibl.etf.util.Util;
import static org.unibl.etf.util.SimulacioniParametri.*;

/**
 * Klasa koja predstavlja jedno iznajmljivanje prevoznog sredstva. Osim što sadrži sve podatke vezane za iznajmljivanje ova klasa predstavlja i nit koja vrši kretanje vozila po mapi.
 * @author andjelabalaban
 *
 */
public class Iznajmljivanje extends Thread {
	private LocalDateTime datum;
	private String korisnikID;
	private String idPrevoznogSredstva;
	private PrevoznoSredstvo vozilo;
	private int[] pocetnaLokacija;
	private int[] odrediste;
	private int trajanje;
	private boolean kvar;
	private String opisKvara;
	private boolean promocija;
	private Object[][] mapa;
	private boolean iznajmljen;

	/**
	 * Default-ni konstruktor.
	 */
	public Iznajmljivanje() {
		super();
	}
	
	/**
	 * 
	 * @param datum
	 * @param korisnik
	 * @param idPrevoznogSredstva
	 * @param pocetnaLokacija
	 * @param odrediste
	 * @param trajanje
	 * @param kvar
	 * @param promocija
	 */
	public Iznajmljivanje(LocalDateTime datum, String korisnik, String idPrevoznogSredstva, int[] pocetnaLokacija, int[] odrediste, int trajanje, boolean kvar, boolean promocija) {
		this.datum = datum;
		this.korisnikID = korisnik;
		this.idPrevoznogSredstva = idPrevoznogSredstva;
		this.pocetnaLokacija = pocetnaLokacija;
		this.odrediste = odrediste;
		this.trajanje = trajanje;
		this.kvar = kvar;
		if(kvar) {
			this.opisKvara = KvarGenerator.generateOpisKvara();
		}
		this.promocija = promocija;
	}

	/**
	 * Get-er datuma iznajmljivanja;
	 * @return datum iznajmljivanja.
	 */
	public LocalDateTime getDatum() {
		return datum;
	}

	/**
	 * Set-er datuma iznajmljivanja.
	 * @param datum
	 */
	public void setDatum(LocalDateTime datum) {
		this.datum = datum;
	}

	/**
	 * Get-er korisnickog ID-a.
	 * @return ID korisnika.
	 */
	public String getKorisnikID() {
		return korisnikID;
	}

	/**
	 * Set-er korisnickog ID-a.
	 * @param korisnik
	 */
	public void setKorisnikID(String korisnik) {
		this.korisnikID = korisnik;
	}

	/**
	 * Get-er ID prevoznog sredstva.
	 * @return vID prevoznog sredstva.
	 */
	public String getIdPrevoznogSredstva() {
		return idPrevoznogSredstva;
	}

	/**
	 * Set-er za ID prevoznog sredstva.
	 * @param idPrevoznogSredstva
	 */
	public void setIdPrevoznogSredstva(String idPrevoznogSredstva) {
		this.idPrevoznogSredstva = idPrevoznogSredstva;
	}

	/**
	 * Get-er lokacije odakle pocinje iznajmljivanje.
	 * @return pocetna lokacija.
	 */
	public int[] getPocetnaLokacija() {
		return pocetnaLokacija;
	}

	/**
	 * Get-er lokacije gdje zavrsava iznajmljivanje.
	 * @return krajnja lokacija.
	 */
	public int[] getOdrediste() {
		return odrediste;
	}

	/**
	 * Get-er trajanja iznajmljivanja.
	 * @return trajanje iznajmljivanja.
	 */
	public int getTrajanje() {
		return trajanje;
	}

	/**
	 * Get-er da li se desio kvar.
	 * @return postoji li kvar za trenutno iznajmljivanje.
	 */
	public boolean isKvar() {
		return kvar;
	}

	/**
	 * Set-er kvara za trenutno iznajmljivanje.
	 * @param kvar
	 */
	public void setKvar(boolean kvar) {
		this.kvar = kvar;
	}

	/**
	 * Get-er da li trenutno iznajmljivanje ima promociju.
	 * @return ima li promociju trenutno iznajmljivanje.
	 */
	public boolean isPromocija() {
		return promocija;
	}

	/**
	 * Set-er promocije za trenutno iznajmljivanje.
	 * @param promocija
	 */
	public void setPromocija(boolean promocija) {
		this.promocija = promocija;
	}
	
	/**
	 * Get-er za prevozno sredstvo koje se iznajmljuje trenutno.
	 * @return prevozno sredstvo koje se iznajmljuje.
	 */
	public PrevoznoSredstvo getPrevoznoSredstvo() {
		return vozilo;
	}

	/**
	 * Set-er za prevozno sredstvo koje se iznajmljuje trenutno.
	 * @param vozilo
	 */
	public void setPrevoznoSredstvo(PrevoznoSredstvo vozilo) {
		this.vozilo = vozilo;
	}
	
	/**
	 * Get-er za mapu grada gdje se iznajmljuje prevozno sredstvo.
	 * @return mapa grada.
	 */
	public Object[][] getMapa() {
		return mapa;
	}

	/**
	 * Set-er za mapu grada gdje se vrsi iznajmljivanje.
	 * @param mapa
	 */
	public void setMapa(Object[][] mapa) {
		this.mapa = mapa;
	}

	/**
	 * Get-er za opis kvara koji se desio na prevoznom sredstvu.
	 * @return opis kvara.
	 */
	public String getOpisKvara() {
		return opisKvara;
	}

	/**
	 * Set-er opisa kvara na prevoznom sredstvu.
	 * @param opisKvara
	 */
	public void setOpisKvara(String opisKvara) {
		this.opisKvara = opisKvara;
	}

	/**
	 * Override-ovana metoda za ispis iznajmljivanja.
	 */
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
		String formatiraniDatum = datum.format(formatter);
		return "Iznajmljivanje prevoznog sredstva: \033[1m" + idPrevoznogSredstva + "\033[0m\n - Datum: " + formatiraniDatum + "\n - Korisnik: " + korisnikID 
			+ "\n - Pocetna lokacija: [" + pocetnaLokacija[0] + "][" + pocetnaLokacija[1] + "]" + "\n - Odrediste: [" + + odrediste[0] + "][" + odrediste[1] + "]"
			+ "\n - Trajanje: " + trajanje + "s" + "\n - Kvar: " + (kvar ? "DA" : "NE") + "\n - Promocija: " + (promocija ? "DA" : "NE");
	}

	/**
	 * Override-ovana run metoda za pokretanje iznajmljivanja.
	 */
	@Override
	public void run() {
		iznajmljen = true;
		kretanje();
		vozilo.punjenjeBaterije();	
	}
	
	/**
	 * Metoda koja vrsi kretanje vozila po mapi od pocetne do krajnje lokacije.
	 */
	private void kretanje() {
		 int x1 = pocetnaLokacija[0];
		 int y1 = pocetnaLokacija[1];
		 // pomjeranje horizontalno po x osi
		 while(x1 != odrediste[0]) {
			 mapa[x1][y1] = vozilo;	
			 try {
				 Thread.sleep((int)(zadrzavanjePoPolju() * 1000));
			 }catch(InterruptedException e) {
				 e.printStackTrace();
			 }
			 if(mapa[x1][y1] == vozilo)
				 mapa[x1][y1] = null;
			 if(x1 < odrediste[0]) {
				 x1++;
			 }
			 else {
				 x1--;
			 }
			 vozilo.praznjenjeBaterije();	// praznjenje baterije tokom kretanja
			 System.out.println(vozilo.getId() + " (" + vozilo.getTrenutniNivoBaterije() + "%)" + " -> " + "[" + x1 + "][" + y1 + "]");
//			 System.out.println(vozilo.getId() + " -> " + "[" + x1 + "][" + y1 + "]");
		 }
		 // pomjeranje vertikalno po y osi
		 while(y1 != odrediste[1]) {
			 mapa[x1][y1] = vozilo;	// upisivanje i ispis sa trenutnog mjesta
			 try {
				 Thread.sleep((int)(zadrzavanjePoPolju() * 1000));
			 }catch(InterruptedException e) {
				 e.printStackTrace();
			 }
			 if(mapa[x1][y1] == vozilo)
				 mapa[x1][y1] = null;
			 if(y1 < odrediste[1]) {
				 y1++;
			 }
			 else {
				 y1--;
			 }
			 vozilo.praznjenjeBaterije();	// praznjenje baterije tokom kretanja
			 System.out.println(vozilo.getId() + " (" + vozilo.getTrenutniNivoBaterije() + "%)" + " -> " + "[" + x1 + "][" + y1 + "]");
//			 System.out.println(vozilo.getId() + " -> " + "[" + x1 + "][" + y1 + "]");
		 }
	}
	
	/**
	 * Metoda koja racuna zadrzavanje na svakom polju na osnovu ukupnog broja koraka i trajanja iznajmljivanja.
	 * @return zadrzavanje na svakom polju.
	 */
	private double zadrzavanjePoPolju() {
		int ukupnoKoraka = Math.abs(odrediste[0] - pocetnaLokacija[0]) + Math.abs(odrediste[1] - pocetnaLokacija[1]);
		if(ukupnoKoraka == 0)
			return 0;
		return (double)trajanje / ukupnoKoraka;
	}	 
	
	/**
	 * Metoda koja provjerava da li se prevozno sredstvo nalazi na uzem dijelu grada.
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean daLiJeUziDioGrada(int x, int y) {
		return x >= POCETAK_UZI_X && x <= KRAJ_UZI_X && y >= POCETAK_UZI_Y && y <= KRAJ_UZI_Y;
	}
	
	/**
	 * Metoda koja provjerava da li je vozilo bilo u sirem dijelu grada. 
	 * @return
	 */
	public boolean daLiJeVoziloBiloUSiremDijeluGrada() {
		int x1 = pocetnaLokacija[0];
        int y1 = pocetnaLokacija[1];
		// Horizontalni pokreti
        while (x1 != odrediste[0]) {
        	 if(!daLiJeUziDioGrada(x1,y1)) {
        		return true;
        	 }
            if (x1 < odrediste[0]) {
                x1++;
            } else {
                x1--;
            }
        }
        // Vertikalni pokreti
        while (y1 != odrediste[1]) {
        	if(!daLiJeUziDioGrada(x1,y1)) {
        		return true;
        	}
            if (y1 < odrediste[1]) {
                y1++;
            } else {
                y1--;
            }
        }
        return false;
	}
	
	/**
	 * Get-er koji vraca da li je prevozno sredstvo iznajmljeno ili nije.
	 * @return
	 */
	public boolean isIznajmljen() {
		return this.iznajmljen;
	}
}
