package org.unibl.etf.util;

/**
 * Klasa čija je uloga generisanje poruka o kvaru prevoznog sredstva. 
 * @author andjelabalaban
 *
 */
public class KvarGenerator {
	private static String[] opis = {"Baterija je prazna.", "Baterija je stara.", "Loš kontakt na beteriji.", 
			"Električni motor je pregrijan.", "Neispravne električne komponente.", 
			"Problem sa softverom na prevoznom sredstvu.", "Kočnice su neispravne.", 
			"Guma na prevoznom sredstvu je pukla.", "Guma na prevoznom sredstvu je izduvana.", 
			"Neispravna elektronika na prevozom sredstvu.", "Prevozno sredstvo se iznenada ugasilo."};
	
	/**
	 * Default-ni konstruktor.
	 */
	private KvarGenerator() {
		super();
	}
	
	/**
	 * Statička metoda koja generiše i vraća opis kvara koji se desio prevoznom sredstvu.
	 * @return opis kvara.
	 */
	public static String generateOpisKvara() {	//generisanje opisa kvara
		int x = Util.generateRandomInt(0, opis.length - 1);
		return opis[x];
	}
	
}
