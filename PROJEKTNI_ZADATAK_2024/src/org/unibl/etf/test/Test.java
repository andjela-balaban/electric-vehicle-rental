package org.unibl.etf.test;

import java.util.*;
import org.unibl.etf.kompanija.*;
import org.unibl.etf.korisnik.*;
import org.unibl.etf.korisnikgenerator.*;
import org.unibl.etf.util.*;
import org.unibl.etf.prevoznasredstva.*;

import static org.unibl.etf.util.SimulacioniParametri.*;

public class Test {
	public static void main(String args[]) throws Exception {
		Korisnik korisnik = KorisnikGenerator.generateKorisnik();
		System.out.println(korisnik);
		
		List<Korisnik> korisnici = KorisnikGenerator.generateNKorisnika(MAX_BROJ_PUTNIKA_AUTOMOBIL);
		for(Korisnik k : korisnici)
			System.out.println(k);
		
		System.out.println("----------------------------------------------------------------------");
		
		List<PrevoznoSredstvo> prevoznaSredstva = Loader.ucitajPrevoznaSredstva(PREVOZNA_SREDSTVA_PUTANJA);
		int brojPs = 0;
		for(PrevoznoSredstvo ps : prevoznaSredstva) {
			System.out.println(ps);
			brojPs++;
		}
		System.out.println("Ukupan broj prevoznih sredstava je: " + brojPs);
		
		System.out.println("----------------------------------------------------------------------");
		
		List<Iznajmljivanje> iznajmljivanje = Loader.ucitajIznajmljivaje(IZNAJMLJIVANJE_PUTANJA);
		int brojIznajm = 0;
		for(Iznajmljivanje iz : iznajmljivanje) {
			System.out.println(iz);
			brojIznajm++;
		}
		System.out.println("Ukupan broj iznajmljivanja je: " + brojIznajm);
		
		System.out.println("----------------------------------------------------------------------\n\n");
		
		System.out.println("\t \033[1m ePJ2 - eMobility kompanija \033[0m");
		System.out.println("\t  Adresa: Javo Javoslava 33.");
		System.out.println("\t       4892100 Javograd");
		System.out.println("\t       Tel. 051/633-447");
		System.out.println("     ---------------------------------------");
		System.out.println("\n   \033[1m RAČUN ZA IZNAJMLJIVAJE PREVOZNOG SREDSTVA \033[0m \n");
		System.out.println("- ID iznajmljenog vozila: T1");
		System.out.println("----------------------------------------------------------------------\n\n");
//		Kompanija k = new Kompanija();
//		k.iznajmljivanjeSimulacija();
//		for(Map.Entry<String, Korisnik> e : k.korisnici.entrySet()) {
//			System.out.println(e.getKey() + " * " + e.getValue());
//		}
		
//		Korisnik kor = KorisnikGenerator.generateKorisnik();
//		System.out.println(kor);
//		int br = 1;
//		for(Iznajmljivanje i : k.iznajmljivanja) {
////			System.out.println(i.getDatum());
//			k.iznajmiPrevoznoSredstvo(i, (br%10==0));
//			br++;
//		}
	
		
		Kompanija ePJ2 = new Kompanija(Loader.ucitajPrevoznaSredstva(PREVOZNA_SREDSTVA_PUTANJA), Loader.ucitajIznajmljivaje(IZNAJMLJIVANJE_PUTANJA), SIRINA_GRADA, DUZINA_GRADA);
//		ePJ2.iznajmljivanjeSimulacija();
		
		for(Map.Entry<String, PrevoznoSredstvo> e : ePJ2.pronadjiNajveceGubitke().entrySet()) {
			System.out.println(e.getKey() + " - " + e.getValue());
		}
		
		System.out.println("----------------------------------------------------------------------");
		ePJ2.serijalizujNajveceGubitke();
		
		for(Map.Entry<String, PrevoznoSredstvo> e : ePJ2.deserijalizujNajveceGubitke().entrySet()) {
			System.out.println(e.getKey() + " - " + e.getValue());
		}

	}
	
	
}
