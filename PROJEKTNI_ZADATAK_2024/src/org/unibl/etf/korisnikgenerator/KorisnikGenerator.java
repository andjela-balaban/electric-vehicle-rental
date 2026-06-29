package org.unibl.etf.korisnikgenerator;

import org.unibl.etf.util.Util;
import static org.unibl.etf.util.SimulacioniParametri.*;
import java.util.*;
import org.unibl.etf.korisnik.*;

/**
 * <p>KorisnikGenerator je klasa koja je zadužena za generisanje korisnika. Ova klasa generiše ime, prezime i sve potrebne dokumente
 * koji su korisniku potrebni. </p>
 * <p>U slučaju da je korisnik stranac generiše mu se dokument 
 * <a href ="file:///Users/andjelabalaban/eclipse-workspace3/PROJEKTNI_ZADATAK_2024/doc/PROJEKTNI_ZADATAK_2024/org/unibl/etf/korisnik/DokumentPasos.html">DokumentPasos</a>, a u slučaju da je korisnik
 * domaći generiše mu se dokument <a href="file:///Users/andjelabalaban/eclipse-workspace3/PROJEKTNI_ZADATAK_2024/doc/PROJEKTNI_ZADATAK_2024/org/unibl/etf/korisnik/DokumentLicnaKarta.html">DokumentLicnaKarta.</a> </p>
 * Svaki korisnik ima dokument <a href = "file:///Users/andjelabalaban/eclipse-workspace3/PROJEKTNI_ZADATAK_2024/doc/PROJEKTNI_ZADATAK_2024/org/unibl/etf/korisnik/DokumentVozackaDozvola.html"> DokumentVozackaDozvola.</a>
 * @author andjelabalaban
 *
 */
public class KorisnikGenerator {
	private static String[] ime = {"Marko", "Janko", "Andreja", "Petar", "Mirko", "Slavko", "Milan", "Goran", "Sanja", 
			"Nikolina", "Katarina", "Sofija", "Nikola", "Marija", "Ana", "Martina", "Tara"};
	private static String[] prezime = {"Marković", "Popović", "Bajić", "Savić", "Petrović", "Milenković", "Sarić", "Andrić",
				"Novaković", "Ilić", "Janković", "Mitrović", "Bojić", "Stanković"};
	
	/**
	 * Privatni default-ni konstruktor.
	 */
	private KorisnikGenerator() {
		super();
	}

	/**
	 * Metoda zadužena za generisanje jednog korisnika. Vraća korisnika kojeg je generisala. 
	 * @return Vraća generisanog korisnika.
	 */
	public static Korisnik generateKorisnik() {	//generisanje jednog korisnika
		int x = Util.generateRandomInt(0, ime.length - 1);
		int y = Util.generateRandomInt(0, prezime.length - 1);
		String imeKorisnika = ime[x];
		String prezimeKorisnika = prezime[y];
		boolean stranac =  Util.generateVjerovatnoca(VJEROVATNOCA_DA_JE_KORISNIK_STRANAC);
		Dokument id = stranac ? new DokumentPasos(imeKorisnika, prezimeKorisnika) : new DokumentLicnaKarta(imeKorisnika, prezimeKorisnika);
		DokumentVozackaDozvola vozackaDozvola = new DokumentVozackaDozvola(imeKorisnika, prezimeKorisnika);
		Korisnik korisnik = new Korisnik(imeKorisnika, prezimeKorisnika, id, vozackaDozvola);
		return korisnik;
	}	
	
	/**
	 * Metoda zadužena za generisanje N korisnika. Kao parametar metode se šalje broj korisnika koje želimo da generišemo, 
	 * a metoda vraća listu objekata tipa Korisnik.  
	 * @param brojKorisnika broj korisnika koje želimo da generišemo.
	 * @return Vraća listu generisanih korisnika.
	 */
	public static List<Korisnik> generateNKorisnika(int brojKorisnika) {	// generisanje grupe korisnika - za potrebe auta
		List<Korisnik> korisnici = new ArrayList<>();
		for(int i = 0; i < brojKorisnika; i++) {
			korisnici.add(KorisnikGenerator.generateKorisnik());
		}
		return korisnici;
	}
}
