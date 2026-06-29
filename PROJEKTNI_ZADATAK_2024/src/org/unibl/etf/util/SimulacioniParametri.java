package org.unibl.etf.util;

import java.io.*;
import java.util.*;

/**
 * Klasa čiji je osnovni zadatak učitavanje parametara potrebnih za simulaciju iz file-ova. Potrebnim parametrima se pristupa preko statičkih članova.
 * @author andjelabalaban
 *
 */
public class SimulacioniParametri {
	/**
	 * Privatni konstruktor klase SimulacioniParametri.
	 */
	private SimulacioniParametri() {
		super();
	}

	static {
		try {
			FileReader reader = new FileReader(Util.buildPath("../PROJEKTNI_ZADATAK_2024/simulacioniParametri.txt")); 
			Properties p = new Properties(); //kreiranje Properties objekta
			p.load(reader); 
			MAX_BROJ_PUTNIKA_AUTOMOBIL = Integer.valueOf(p.getProperty("MAX_BROJ_PUTNIKA_AUTOMOBIL"));
			MAX_BROJ_PUTNIKA_BICIKLO = Integer.valueOf(p.getProperty("MAX_BROJ_PUTNIKA_BICIKLO"));
			MAX_BROJ_PUTNIKA_TROTINET = Integer.valueOf(p.getProperty("MAX_BROJ_PUTNIKA_TROTINET"));
			NAJVECI_GUBITAK_PREVOZNA_SREDSTVA_SERIJALIZACIJA_PUTANJA = Util.buildPath(p.getProperty("NAJVECI_GUBITAK_PREVOZNA_SREDSTVA_SERIJALIZACIJA_PUTANJA"));
			VJEROVATNOCA_DA_JE_KORISNIK_STRANAC = Integer.valueOf(p.getProperty("VJEROVATNOCA_DA_JE_KORISNIK_STRANAC"));
			PREVOZNA_SREDSTVA_PUTANJA = Util.buildPath(p.getProperty("PREVOZNA_SREDSTVA_PUTANJA"));
			IZNAJMLJIVANJE_PUTANJA = Util.buildPath(p.getProperty("IZNAJMLJIVANJE_PUTANJA"));
			DISTANCA_UZI_DIO = Integer.valueOf(p.getProperty("DISTANCA_UZI_DIO"));
			DISTANCA_SIRI_DIO = Integer.valueOf(p.getProperty("DISTANCA_SIRI_DIO"));
			POPUST = Double.valueOf(p.getProperty("POPUST"));
			POPUST_PROMOCIJA = Double.valueOf(p.getProperty("POPUST_PROMOCIJA"));
			AUTO_UNIT_CIJENA = Double.valueOf(p.getProperty("AUTO_UNIT_CIJENA"));
			BICIKL_UNIT_CIJENA = Double.valueOf(p.getProperty("BICIKL_UNIT_CIJENA"));
			TROTINET_UNIT_CIJENA = Double.valueOf(p.getProperty("TROTINET_UNIT_CIJENA"));
			DUZINA_GRADA = Integer.valueOf(p.getProperty("DUZINA_GRADA"));
			SIRINA_GRADA = Integer.valueOf(p.getProperty("SIRINA_GRADA"));
			POCETAK_UZI_X = Integer.valueOf(p.getProperty("POCETAK_UZI_X"));
			KRAJ_UZI_X = Integer.valueOf(p.getProperty("KRAJ_UZI_X"));
			POCETAK_UZI_Y = Integer.valueOf(p.getProperty("POCETAK_UZI_Y"));
			KRAJ_UZI_Y = Integer.valueOf(p.getProperty("KRAJ_UZI_Y"));
			PAUZA_NAREDNI_DAN = Integer.valueOf(p.getProperty("PAUZA_NAREDNI_DAN"));
			RACUNI_PUTANJA = Util.buildPath(p.getProperty("RACUNI_PUTANJA"));
			KOEFICIJENT_POPRAVKE_AUTOMOBIL = Double.valueOf(p.getProperty("KOEFICIJENT_POPRAVKE_AUTOMOBIL"));
			KOEFICIJENT_POPRAVKE_BICIKL = Double.valueOf(p.getProperty("KOEFICIJENT_POPRAVKE_BICIKL"));
			KOEFICIJENT_POPRAVKE_TROTINET = Double.valueOf(p.getProperty("KOEFICIJENT_POPRAVKE_TROTINET"));
			PAUZA_NAREDNI_SAT = Integer.valueOf(p.getProperty("PAUZA_NAREDNI_SAT"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
//  maksimalan dozvoljen broj putnika u vozilu
	public static int MAX_BROJ_PUTNIKA_AUTOMOBIL;
	public static int MAX_BROJ_PUTNIKA_BICIKLO;
	public static int MAX_BROJ_PUTNIKA_TROTINET;
	
//	putanja do fajla gdje ce se serijalizovati prevozna sredstva sa najvecim gubitkom za svaku vrstu
	public static String NAJVECI_GUBITAK_PREVOZNA_SREDSTVA_SERIJALIZACIJA_PUTANJA;

//	vjerovatnoca da je korisnik vozila stranac
	public static int VJEROVATNOCA_DA_JE_KORISNIK_STRANAC;
	
//	putanja do csv fajla sa generisanim prevoznim sredstvima
	public static String PREVOZNA_SREDSTVA_PUTANJA;
	
//	putanja do csv fajla sa generisanim iznajmljivanjima prevoznih sredstava
	public static String IZNAJMLJIVANJE_PUTANJA;
	
//	putanja do direktorijuma sa generisanim korisnickim racunima
	public static String RACUNI_PUTANJA;
	
//	parametri za iznajmljivanje
	public static int DISTANCA_UZI_DIO;
	public static int DISTANCA_SIRI_DIO;
	public static double POPUST;
	public static double POPUST_PROMOCIJA;
	public static double AUTO_UNIT_CIJENA;
	public static double BICIKL_UNIT_CIJENA;
	public static double TROTINET_UNIT_CIJENA;
	
//	duzina i sirina matrice, tj. grada
	public static int DUZINA_GRADA;
	public static int SIRINA_GRADA;
	
//	koordiante pocetka i kraja uzeg dijela grada
	public static int POCETAK_UZI_X;
	public static int KRAJ_UZI_X;
	public static int POCETAK_UZI_Y;
	public static int KRAJ_UZI_Y;
	
//	pauza za naredni dan simulacije
	public static int PAUZA_NAREDNI_DAN;
	public static int PAUZA_NAREDNI_SAT;
	
//	koeficijenti za popravku prevoznih sredstava
	public static double KOEFICIJENT_POPRAVKE_AUTOMOBIL;
	public static double KOEFICIJENT_POPRAVKE_BICIKL;
	public static double KOEFICIJENT_POPRAVKE_TROTINET;
}
