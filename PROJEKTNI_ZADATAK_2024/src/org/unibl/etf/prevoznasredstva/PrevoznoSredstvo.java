package org.unibl.etf.prevoznasredstva;

import java.io.Serializable;

import org.unibl.etf.util.Util;

/**
 * Apstraktna klasa koja predstavlja prevozno sredstvo koje korisnik može da iznajmi. Ova klasa predstavlja roditeljsku klasu
 * svih prevoznih sredstava iz koje se izvode konkretna prevozna sredstva.
 * @author andjelabalaban
 *
 */
public abstract class PrevoznoSredstvo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String proizvodjac;
	private String model;
	private double cijenaNabavke;
	private int trenutniNivoBaterije;
	private int maxKorisnika;
	
	/**
	 * Default-ni konstruktor.
	 */
	public PrevoznoSredstvo() {
		super();
	}
	/**
	 * Konstruktor sa jednim parametrom koji predstavlja koliko maksimalno korisnika može da koristi prevozno sredstvo.
	 * @param maxKorisnika
	 */
	public PrevoznoSredstvo(int maxKorisnika) {
		this.maxKorisnika = maxKorisnika;
	}
	
	/**
	 * Konstruktor sa četiri parametra koji predstavljaju ID, proizvođač, model i cijena prevoznog sredstva.
	 * @param id
	 * @param proizvodjac
	 * @param model
	 * @param cijenaNabavke
	 */
	public PrevoznoSredstvo(String id, String proizvodjac, String model, double cijenaNabavke) {
		this.id = id;
		this.proizvodjac = proizvodjac;
		this.model = model;
		this.cijenaNabavke = cijenaNabavke;
		this.trenutniNivoBaterije = 100;
	}
	
	/**
	 * Konstruktor sa pet parametra koji predstavljaju ID, proizvođač, model, cijenu prevoznog sredstva i makismalan broj korisnika koji mogu da se prevoze u prevoznom sredstvu.
	 * @param id
	 * @param proizvodjac
	 * @param model
	 * @param cijenaNabavke
	 * @param maxKorisnika
	 */
	public PrevoznoSredstvo(String id, String proizvodjac, String model, double cijenaNabavke, int maxKorisnika) {
		this.id = id;
		this.proizvodjac = proizvodjac;
		this.model = model;
		this.cijenaNabavke = cijenaNabavke;
		this.trenutniNivoBaterije = 100;
		this.maxKorisnika = maxKorisnika;
	}
	
	/**
	 * Get-er ID-a prevoznog sredstva.
	 * @return ID prevoznog sredstva.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set-er za ID prevoznog sredstva.
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get-er proizvođača prevoznog sredstva.
	 * @return proizvođač prevoznog sredstva.
	 */
	public String getProizvodjac() {
		return proizvodjac;
	}

	/**
	 * Set-er proizvođača prevoznog sredstva.
	 * @param proizvodjac
	 */
	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	/**
	 * Get-er modela prevoznog sredstva.
	 * @return model prevoznog sredstva.
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Set-er modela prevoznog sredstva.
	 * @param model
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Get-er cijene nabavke prevoznog sredstva.
	 * @return cijena nabavke prevoznog sredstva.
	 */
	public double getCijenaNabavke() {
		return cijenaNabavke;
	}

	/**
	 * Set-er cijene nabavke prevoznog sredstva.
	 * @param cijenaNabavke
	 */
	public void setCijenaNabavke(double cijenaNabavke) {
		this.cijenaNabavke = cijenaNabavke;
	}

	/**
	 * Get-er za trenutni nivo baterije prevoznog sredstva.
	 * @return trenutni nivo baterije prevoznog sredstva.
	 */
	public int getTrenutniNivoBaterije() {
		return trenutniNivoBaterije;
	}

	/**
	 * Set-er za trenutni nivo baterije prevoznog sredstva.
	 * @param trenutniNivoBaterije.
	 */
	public void setTrenutniNivoBaterije(int trenutniNivoBaterije) {
		this.trenutniNivoBaterije = trenutniNivoBaterije;
	}

	/**
	 * Set-er makimalni broj korisnika koji se može voziti u prevoznom sredstvu.
	 * @param maxBrojKorisnika
	 */
	public void setMaxKorisnika(int maxBrojKorisnika) {
		maxKorisnika = maxBrojKorisnika;
	}

	/**
	 * Get-er pomoću kojeg dobijam broj korisnika koji se može voziti u prevoznom sredstvu.
	 * @return broj korisnika koji se može voziti u prevoznom sredstvu.
	 */
	public int getMaxKorisnika() {
		return maxKorisnika;
	}

	/**
	 * Metoda kojom se puni baterije prevoznog sredstva.
	 */
	public void punjenjeBaterije() {
		this.trenutniNivoBaterije = Util.generateRandomInt(81, 101);
	}
	
	/**
	 * Metoda kojom se prazni trenutni nivo baterije za neki random broj između 1 i 3.
	 */
	public void praznjenjeBaterije() {
		this.trenutniNivoBaterije -= Util.generateRandomInt(1, 3);
	}
	
	/**
	 * Metoda kojom se baterija u potpunosti napuni.
	 */
	public void napuniPotpunoBateriju() {
		this.trenutniNivoBaterije = 100;
	}

	/**
	 * Override-ovana toString metoda za ispis prevoznog sredstva(ispisuje samo model).
	 */
	@Override
	public String toString(){		
//		return "\033[1mID: " + id + "\033[0m\n - Proizvođač: " + proizvodjac + "\n - Model: " 
//		+ model + "\n - Trenutni nivo baterije: " + trenutniNivoBaterije + "%";
		return id;
	}
	
	/**
	 * Pomocna metoda za ispis potrebnih atributa prevoznog sredstva - potrebna za GUI.
	 * @return ispis informacija za prevozno sredstvo
	 */
	public String voziloInfo() {
		return "ID: " + id + "\n - Proizvođač: " + proizvodjac + "\n - Model: " 
				+ model + "\n - Trenutni nivo baterije: " + trenutniNivoBaterije + "%" + 
				"\n - Cijena nabavke: " + String.format("%05.2f", cijenaNabavke) + "KM";
	}
}
