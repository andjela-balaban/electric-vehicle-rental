package org.unibl.etf.kompanija;

import java.io.*;
import java.nio.file.Paths;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.unibl.etf.korisnik.*;
import org.unibl.etf.korisnikgenerator.*;
import org.unibl.etf.prevoznasredstva.*;
import static org.unibl.etf.util.SimulacioniParametri.*;

/**
 * Klasa koja predstavlja e-mobility kompaniju koja iznajmljuje električna prevozna sredstva. Osnovi zadatak kompanije je iznajmljivanje prevoznih sredstava i generisanje računa.
 * @author andjelabalaban
 *
 */
public class Kompanija {
	public Map<String, Korisnik> korisnici;
	private Map<String, PrevoznoSredstvo> prevoznaSredstva;
	private List<Iznajmljivanje> iznajmljivanja;
	private Object[][] mapa;
	private List<Racun> racuni;
	private LocalDateTime trenutniDatumVrijeme;
	private boolean krajSimulacije;

	/**
	 * Konstruktor koji prima listu prevoznih sredstava, listu iznajmljivaja i veličinu grada. Na osnovu ovih parametara konstruiše objekat Komapanije.
	 * @param pS
	 * @param iznajmljivanja
	 * @param sirinaGrada
	 * @param duzinaGrada
	 */
	public Kompanija(List<PrevoznoSredstvo> pS, List<Iznajmljivanje> iznajmljivanja, int sirinaGrada, int duzinaGrada) {
		super();
		this.mapa = new Object[sirinaGrada][duzinaGrada];
		this.prevoznaSredstva = new HashMap<>();
		for(PrevoznoSredstvo p : pS) {
			// ako vrati != null, bilo je nesto prije, i nije dodao -> ispis poruke
			if(prevoznaSredstva.putIfAbsent(p.getId(), p) != null) {
				System.err.println("Dupli ID prevoznog sredstva.");
			}
		}
		this.iznajmljivanja = iznajmljivanja;
		this.korisnici = new HashMap<>();
		// Proverite da li prevozno sredstvo postoji u mapi prevoznih sredstava
		List<Iznajmljivanje> nevalidnaIznajmljivanja = new ArrayList<>();
		for(Iznajmljivanje i : iznajmljivanja) {
			try {
				if (!prevoznaSredstva.containsKey(i.getIdPrevoznogSredstva())) {
					nevalidnaIznajmljivanja.add(i);
					throw new VoziloNePostojiUListiPrevoznihSredstavaException("Vozilo sa ID  " + i.getIdPrevoznogSredstva() + " ne postoji u listi prevoznih sredstava");
				}
				Korisnik korisnik = KorisnikGenerator.generateKorisnik();		
				korisnik.setKorisnikID(i.getKorisnikID());
				korisnici.putIfAbsent(i.getKorisnikID(), korisnik);
				i.setKorisnikID(korisnik.getKorisnikID());
				i.setPrevoznoSredstvo(prevoznaSredstva.get(i.getIdPrevoznogSredstva()));
				i.setMapa(mapa);					
			}catch (VoziloNePostojiUListiPrevoznihSredstavaException e) {
				e.printStackTrace();
			}
		}
		iznajmljivanja.removeAll(nevalidnaIznajmljivanja);
		this.racuni = new ArrayList<>();
		sortIznajmljivanja();
	}
	
	/**
	 * Privatna metoda koja sortira iznajmljivanja po datumu.
	 */
	private void sortIznajmljivanja() {
		Collections.sort(iznajmljivanja, Comparator.comparing(Iznajmljivanje::getDatum));
	}
	
	/**
	* Metoda zaduzena za simuliranje iznajmljivanja u razlicitim vremenskim intervalima 
	* @throws IOException
	*/
	public void iznajmljivanjeSimulacija() throws IOException {
//		Pre svakog iznajmljivanja se proverava da li su koordinate ispravne i da li vozilo već nije iznajmljeno u tom vremenskom intervalu
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	    LocalDate trenutniDatum = null, prethodniDatum = null;
	    int brojIznajmljivanja = 1;
	    // Map-a za grupisanje iznajmljivanja po datumu i vremenu  (TreeMap - da bi se automatski sortiralo po kljucu)
	    Map<LocalDateTime, List<Iznajmljivanje>> iznajmljivanjaPoVremenu = new TreeMap<>();	

	    // grupisanje iznajmljivanja po datumu i vremenu
	    for (Iznajmljivanje i : iznajmljivanja) {
	        LocalDateTime datumVreme = i.getDatum();
	        iznajmljivanjaPoVremenu.computeIfAbsent(datumVreme, k -> new ArrayList<>()).add(i);	// dodavanje iznajmljivanja po datumu i vremenu
	    }

	    for (Map.Entry<LocalDateTime, List<Iznajmljivanje>> entry : iznajmljivanjaPoVremenu.entrySet()) {
	        List<Iznajmljivanje> grupa = entry.getValue();	// grupa iznajmljivanja koja se iznajmljuje u isto vrijeme
	        Set<String> iznajmljeniID = new HashSet<>();	// Set za cuvanje ID-eva prevoznih sredstava koja se trenutno iznajmljuju

	        trenutniDatum = entry.getKey().toLocalDate();  // ----- GUI DATUM I VRIJEME
	        this.trenutniDatumVrijeme = entry.getKey();
	        String formatiraniDatum = trenutniDatum.format(formatter);

	        // provjera da li je novi dan - tj. da li je trenutni datum razlicit od prethodnog
	        if (!trenutniDatum.equals(prethodniDatum)) { // novi je datum
	            System.out.println("\t \033[1m  Iznajmljivanje datum: " + formatiraniDatum + "\033[0m \n");
	            if (prethodniDatum != null) {
	                try {
	                    Thread.sleep(PAUZA_NAREDNI_DAN);	// pauza izmedju razlicitih dana
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	            prethodniDatum = trenutniDatum;	// postavljanje prethodnog datuma na trenutni
	        }

	        for (Iznajmljivanje i : grupa) {	// iteriranje kroz iznajmljivanja koja su se desila u istom vremenskom trenutku
	            try {
	            	// provjera da li koordinate kojima ce se prevozno sredstvo kretati pripadaju mapi grada
	                if (i.getPocetnaLokacija()[0] >= 0 && i.getPocetnaLokacija()[0] < mapa.length &&
	                    i.getOdrediste()[0] >= 0 && i.getOdrediste()[1] < mapa[0].length) {

//	                    // proveri da li je vozilo vec iznajmljeno u ovom intervalu
//	                    if (iznajmljeniID.contains(i.getPrevoznoSredstvo().getId())) {
//	                        System.err.println("Vozilo sa ID " + i.getPrevoznoSredstvo().getId() + " je već iznajmljeno u ovom intervalu.");
//	                        continue;	// preskace ostatak oetlje i ide na sljedece iznajmljivanje
//	                    }
	                	
	                	 // Proverava da li je vozilo već iznajmljeno u ovom intervalu
	                    if (iznajmljeniID.contains(i.getIdPrevoznogSredstva())) {
	                        throw new VoziloVecIznajmljenoException("Vozilo sa ID " + i.getIdPrevoznogSredstva() + " je već iznajmljeno u ovom intervalu.");
	                    }

	                    // dodaj vozilo u set iznajmljenih vozila
	                    iznajmljeniID.add(i.getPrevoznoSredstvo().getId());

	                    // za svaki novi dan baterija svih prevoznih sredstava je napunjena 100%
	                    if (!trenutniDatum.equals(prethodniDatum)) {
	                        i.getPrevoznoSredstvo().napuniPotpunoBateriju(); 
	                    }
	                    
	                    // iznajmljivanje prevoznog sredstva
	                    iznajmiPrevoznoSredstvo(i, (brojIznajmljivanja % 10 == 0));
	                    brojIznajmljivanja++;
	                    
	                } else {
	                    throw new KoordinataVanOpsegaGradaException("Koordinate su van opsega grada.");
	                }
	            } catch (KoordinataVanOpsegaGradaException | VoziloVecIznajmljenoException e) {
	                e.printStackTrace();
	            }
	        }

	        // Pauza od par sekundi pre prelaska na sledeći vremenski interval
	        try {
	            Thread.sleep(PAUZA_NAREDNI_SAT);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    pronadjiNajveceGubitke();
	    ispisMatrice();
	    krajSimulacije = true;
	    serijalizujNajveceGubitke();
	}

	/**
	* Privatna, pomocna metoda zaduzena za ispis matrice grada.
	*/
	private void ispisMatrice() {
		for(int i = 0; i < mapa.length; i++) {
			for(int j = 0; j < mapa[i].length; j++) {
				System.out.print(mapa[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * Metoda za iznajmljivanje prevoznog sredstva. Metoda je zaduzena za pokretanje pojedinacnog thread-a iznajmljivanja i generisanje racuna za to iznajmljivanje.
	 * @param iznajmljivanje
	 * @throws IOException 
	 */	
	private void iznajmiPrevoznoSredstvo(Iznajmljivanje iznajmljivanje, boolean desetiIznajmljen) throws IOException {		
		iznajmljivanje.start();
		generisiRacun(iznajmljivanje, desetiIznajmljen);
	}
	
	/**
	 * Metoda zaduzena za generisanje racuna nakon iznajmljivanja prevoznog sredstva.
	 * Prilikom iznajmljivanja evidentiraju se datum i vrijeme iznajmljivanja, ime korisnika, trenutna 
	 * lokacija gdje je prevozno sredstvo preuzeto, lokacija gdje se prevozno sredstvo ostavlja nakon korišćenja i trajanje korišćenja u sekundama.
	 * Prilikom iznajmljivanja automobila dostavlja se identifikacioni dokument (pasoš za strane državljane i ličnu kartu za domaće) i vozačku dozvolu (broj). 
	 * Na osnovu ovih podataka generiše se račun za plaćanje koji se dostavlja korisnicima kao txt fajl.
	 * @param iznajmljivanje
	 * @param desetiIznajmljen
	 * @throws IOException
	 */
	private void generisiRacun(Iznajmljivanje iznajmljivanje, boolean desetiIznajmljen) throws IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy_hh-mm");
		String formatiraniDatum = iznajmljivanje.getDatum().format(formatter);
		File racuniFile = Paths.get(RACUNI_PUTANJA, iznajmljivanje.getKorisnikID() + "_" + formatiraniDatum + "_racun.txt").toFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(racuniFile));
		double cijenaIznajmljivanja = generisiCijenuIznajmljivanja(iznajmljivanje, desetiIznajmljen);
		double promocija = (iznajmljivanje.isPromocija() ? POPUST_PROMOCIJA : 0) * generisiIznosIznajmljivanja(iznajmljivanje);
		double popust = (desetiIznajmljen ? POPUST : 0) * generisiIznosIznajmljivanja(iznajmljivanje);
		Racun racun = new Racun(iznajmljivanje.getDatum(), korisnici.get(iznajmljivanje.getKorisnikID()), iznajmljivanje, desetiIznajmljen, cijenaIznajmljivanja, generisiIznosIznajmljivanja(iznajmljivanje), popust, promocija);
		racuni.add(racun);
		writer.write(racun.toString());
		writer.close();
	}
	
	/**
	 * Privatna metoda zaduzena za generisanje krajnje cijene iznajmljivanja i obracunavanja popusta, promocija i utvrdjivanje da li se desio kvar na prevoznom sredstvu.
	 * @param iznajmljivanje
	 * @param desetiIznajmljen
	 * @return krajnja cijena iznajmljivanja prevoznog sredstva.
	 */
	private double generisiCijenuIznajmljivanja(Iznajmljivanje iznajmljivanje, boolean desetiIznajmljen) {
		double cijenaUkupno = 0;
		if(iznajmljivanje.isKvar()) {	// ako postoji kvar ukupno = 0
			cijenaUkupno = 0;
		}
		else {
			double promocija = (iznajmljivanje.isPromocija() ? POPUST_PROMOCIJA : 0) * generisiIznosIznajmljivanja(iznajmljivanje);
			double popust = (desetiIznajmljen ? POPUST : 0) * generisiIznosIznajmljivanja(iznajmljivanje);
			cijenaUkupno = generisiIznosIznajmljivanja(iznajmljivanje) - promocija - popust;
		}
		return cijenaUkupno;
	}
	
	/**
	 * Privatna metoda zaduzena za generisanje iznosa jednog iznajmljivanja.
	 * @param iznajmljivanje
	 * @return iznos odredjenog iznajmljivanja.
	 */
	private double generisiIznosIznajmljivanja(Iznajmljivanje iznajmljivanje) {   // cijenaIznajmljivanjaUdaljenost
		double cijena = osnovnaCijena(iznajmljivanje);  
		// cijena iznajmljivanja zavisi od polja po kojima je prevozno sredstvo vozeno tj. uzeg ili sireg dijela grada
		if(iznajmljivanje.daLiJeVoziloBiloUSiremDijeluGrada()) {
			cijena *= DISTANCA_SIRI_DIO;
		}
		else {
			cijena *= DISTANCA_UZI_DIO;
		}
		return cijena;
	}
	
	/**
	 * Privatna metoda zaduzena za racunanje osnovne cijene iznajmljivanja.
	 * @param iznajmljivanje
	 * @return osnovna cijena iznajmljivanja.
	 */
	private double osnovnaCijena(Iznajmljivanje iznajmljivanje) {
		double osnovnaCijena = 0;
		PrevoznoSredstvo vozilo = iznajmljivanje.getPrevoznoSredstvo();
		if(vozilo instanceof ElektricniAutomobil)
			osnovnaCijena = AUTO_UNIT_CIJENA;
		else if(vozilo instanceof ElektricniBicikl)
			osnovnaCijena = BICIKL_UNIT_CIJENA;
		else if(vozilo instanceof ElektricniTrotinet)
			osnovnaCijena = TROTINET_UNIT_CIJENA;
		return (osnovnaCijena * iznajmljivanje.getTrajanje());
	}
	
	/**
	* Metoda koja geneise sumarni izvjetaj za kompaniju.
	* @return sumarni izvjestaj.
	*/
	public String sumarniIzvjestaj() {
		double ukupanPrihod = 0;
		double ukupanPopust = 0;
		double ukupnoPromocija = 0;
		double ukupanIznosVoznjiPoSiremIUzemDijelu = 0;
		double ukupanIznosZaPopravkeKvarova = 0;
		for(Racun r : racuni) {
			ukupanPrihod += r.getCijenaIznajmljivanja();
			ukupanPopust += r.getPopust();
			ukupnoPromocija += r.getPromocija();
			ukupanIznosVoznjiPoSiremIUzemDijelu += r.getIznos();
		}
		StringBuffer bw = new StringBuffer();
//		bw.append("\t \033[1m  SUMARNI IZVJESTAJ: \033[0m \n\n");
		bw.append("\t\t\t\t  SUMARNI IZVJESTAJ:\n\n");
		bw.append("Ukupan prihod: " + String.format("%05.2f", ukupanPrihod) + "KM\n");
		bw.append("Ukupan popust: " + String.format("%05.2f", ukupanPopust) + "KM\n");
		bw.append("Ukupno promocije: " + String.format("%05.2f", ukupnoPromocija) + "KM\n");
		bw.append("Ukupan iznos svih voznji u uzem i sirem dijelu grada: " + String.format("%05.2f", ukupanIznosVoznjiPoSiremIUzemDijelu) + "KM");
		double ukupnoOdrzavanje = ukupanPrihod * 0.02;
		bw.append("Ukupan iznos za odrzavanje: " + String.format("%05.2f", ukupnoOdrzavanje) + "KM\n");
		for(Iznajmljivanje i : iznajmljivanja) {
			if(i.isKvar()) {
				ukupanIznosZaPopravkeKvarova += koeficijentPopravke(i) * i.getPrevoznoSredstvo().getCijenaNabavke();
			}
		}
		bw.append("Ukupan iznos za popravke kvarova: " + String.format("%05.2f", ukupanIznosZaPopravkeKvarova) + "KM\n");
		double ukupniTroskovi = ukupanPrihod * 0.2;
		bw.append("Ukupni troskovi kompanije: " + String.format("%05.2f", ukupniTroskovi) + "KM\n");
		bw.append("Ukupan porez: " + String.format("%05.2f", ((ukupanPrihod - ukupnoOdrzavanje - ukupanIznosZaPopravkeKvarova - ukupniTroskovi) * 0.1)) + "KM\n");
		return bw.toString();
	}
	
	/**
	 * Metoda za generisanje dnevnog izvjestaja za datum koji je poslat kao parametar metode.
	 * @param izabraniDatum
	 * @return izvjestaj za trazeni dan.
	 */
	public String dnevniIzvjestaj(LocalDate izabraniDatum) {
		double ukupanPrihod = 0;
		double ukupanPopust = 0;
		double ukupnoPromocija = 0;
		double ukupanIznosVoznjiPoSiremIUzemDijelu = 0;
		double ukupanIznosZaPopravkeKvarova = 0;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		String formatiraniDatum = izabraniDatum.format(formatter);
		sortRacune();	// sortiram racune po datumu zatim ih iteriram
		StringBuffer bw = new StringBuffer();
		for(Racun r : racuni) {
			if(r.getDatum().toLocalDate().equals(izabraniDatum)) {
				ukupanPrihod += r.getCijenaIznajmljivanja();
				ukupanPopust += r.getPopust();
				ukupnoPromocija += r.getPromocija();
				ukupanIznosVoznjiPoSiremIUzemDijelu += r.getIznos();

				
			}
		}
//			bw.append("\t \033[1m  DNEVNI IZVJESTAJ ZA DAN: " + formatiraniDatum  + " \033[0m \n\n");
		bw.append("\t\t DNEVNI IZVJESTAJ ZA DAN: " + formatiraniDatum  + "\n\n");
		bw.append("Ukupan prihod: " + String.format("%05.2f", ukupanPrihod) + "KM\n");
		bw.append("Ukupan popust: " + String.format("%05.2f", ukupanPopust) + "KM\n");
		bw.append("Ukupno promocije: " + String.format("%05.2f", ukupnoPromocija) + "KM\n");
		bw.append("Ukupan iznos svih voznji u uzem i sirem dijelu grada: " + String.format("%05.2f", ukupanIznosVoznjiPoSiremIUzemDijelu) + "KM\n");
		double ukupnoOdrzavanje = ukupanPrihod * 0.02;
		bw.append("Ukupan iznos za odrzavanje: " + String.format("%05.2f", ukupnoOdrzavanje) + "KM\n");
		for(Iznajmljivanje i : iznajmljivanja) {
			if(i.isKvar()) {
				ukupanIznosZaPopravkeKvarova += koeficijentPopravke(i) * i.getPrevoznoSredstvo().getCijenaNabavke();
			}
		}
		bw.append("Ukupan iznos za popravke kvarova: " + String.format("%05.2f", ukupanIznosZaPopravkeKvarova) + "KM\n");
				
		return bw.toString();
	}
	
	/**
	 * Privatna metoda zaduzena za sortiranje racuna po vremenu iznajmljivanja.
	 */
	private void sortRacune() {
		Collections.sort(racuni, Comparator.comparing(Racun::getDatum));
	}
	
	/**
	 * Privatna metoda koja izracunava i vraca koji je koeficijent popravke na osnovu tipa prevoznog sredstva.
	 * @param iznajmljivanje
	 * @return koeficijent popravke.
	 */
	private double koeficijentPopravke(Iznajmljivanje iznajmljivanje) {
		double koeficijent = 0;
		PrevoznoSredstvo vozilo = iznajmljivanje.getPrevoznoSredstvo();
		if(vozilo instanceof ElektricniAutomobil)
			koeficijent = KOEFICIJENT_POPRAVKE_AUTOMOBIL;
		else if(vozilo instanceof ElektricniBicikl)
			koeficijent = KOEFICIJENT_POPRAVKE_BICIKL;
		else if(vozilo instanceof ElektricniTrotinet)
			koeficijent = KOEFICIJENT_POPRAVKE_TROTINET;
		return koeficijent;
	}
	
	
	/**
	 * Metoda koja pronalazi prevozna sredstva koja su donijela najvise gubitaka kompaniji.
	 * @return mapa prevoznih sredstava sa najvise kvarova.
	 */
	public  Map<String, PrevoznoSredstvo> pronadjiNajveceGubitke() {
        Map<PrevoznoSredstvo, Long> kvarovi = new HashMap<>();	// mapira prevozno sredstvo sa brojem kvarova
        
        for(PrevoznoSredstvo vozilo : prevoznaSredstva.values()) {
        	kvarovi.put(vozilo, iznajmljivanja.stream().filter(i -> i.isKvar() && i.getPrevoznoSredstvo() == vozilo && i.isIznajmljen()).count());
        }
        
        Map<String, PrevoznoSredstvo> rezultat = new HashMap<>();
        Map.Entry<PrevoznoSredstvo, Long> trotinet = kvarovi.entrySet().stream().filter(p -> p.getKey() instanceof ElektricniTrotinet && p.getValue() > 0).sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).findFirst().orElse(null);
		rezultat.put("Trotinet", trotinet != null ? trotinet.getKey() : null);
		Map.Entry<PrevoznoSredstvo, Long> automobil = kvarovi.entrySet().stream().filter(p -> p.getKey() instanceof ElektricniAutomobil && p.getValue() > 0).sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).findFirst().orElse(null);
		rezultat.put("Automobil", automobil != null ? automobil.getKey() : null);
		Map.Entry<PrevoznoSredstvo, Long> 	bicikl = kvarovi.entrySet().stream().filter(p -> p.getKey() instanceof ElektricniBicikl && p.getValue() > 0).sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).findFirst().orElse(null);
		rezultat.put("Bicikl", bicikl != null ? bicikl.getKey() : null);
        return rezultat;
    }
	
	/**
	 * Serijalizacija prevoznih sredstava koja su imala najvise gubitaka u toku simulacije.
	 * @throws IOException
	 */
	public void serijalizujNajveceGubitke() throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(NAJVECI_GUBITAK_PREVOZNA_SREDSTVA_SERIJALIZACIJA_PUTANJA));
		out.writeObject(pronadjiNajveceGubitke());
		out.close();
	}
	
	/**
	 * Deserijalizacij prevoznih sredstava koji su donijeli najvise gubitaka kompaniji.
	 * @return mapa prevoznih sredstava.
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, PrevoznoSredstvo> deserijalizujNajveceGubitke() throws IOException, ClassNotFoundException {
		Map<String, PrevoznoSredstvo> rezultat = new HashMap<>();
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(NAJVECI_GUBITAK_PREVOZNA_SREDSTVA_SERIJALIZACIJA_PUTANJA));
		rezultat = (Map<String, PrevoznoSredstvo>) in.readObject();
		in.close();
		return rezultat;
	}

	/**
	 * Get-er za prevozna sredstva koja kompanija iznajmljuje.
	 * @return mapa prevoznih sredstava, mapiran ID prevoznog sredstva sa prevoznim sredstvom.
	 */
	public Map<String, PrevoznoSredstvo> getPrevoznaSredstva() {
		return prevoznaSredstva;
	}

	/**
	 * Set-er prevoznih sredstava koja se koriste za iznajmljivanje.
	 * @param prevoznaSredstva
	 */
	public void setPrevoznaSredstva(Map<String, PrevoznoSredstvo> prevoznaSredstva) {
		this.prevoznaSredstva = prevoznaSredstva;
	}

	/**
	 * Get-er iznajmljivanja prevoznih sredstava.
	 * @return lista iznajmljivanja.
	 */
	public List<Iznajmljivanje> getIznajmljivanja() {
		return iznajmljivanja;
	}

	/**
	 * Set-er liste iznajmljivanja.
	 * @param iznajmljivanja
	 */
	public void setIznajmljivanja(List<Iznajmljivanje> iznajmljivanja) {
		this.iznajmljivanja = iznajmljivanja;
	}

	/**
	 * Get-er mape po kojoj se odvija iznajmljivanje prevoznih sredstava.
	 * @return mapa po kojoj se odvija simulacija.
	 */
	public Object[][] getMapa() {
		return mapa;
	}

	/**
	 * Set-er mape po kojoj se odvija iznajmljivanje.
	 * @param mapa
	 */
	public void setMapa(Object[][] mapa) {
		this.mapa = mapa;
	}

	/**
	 * Get-er liste racuna.
	 * @return lista iznajmljenih racuna. 
	 */
	public List<Racun> getRacuni() {
		return racuni;
	}

	/**
	 * Get-er za trenutno vrijeme. 
	 * @return trenutno vrijeme.
	 */
	public LocalDateTime getTrenutniDatumVrijeme() {
		return trenutniDatumVrijeme;
	}
	
	/**
	 * Get-er sa kojim dobijeamo informaciju da li je zavrseno simuliranje ili nije.
	 * @return
	 */
	public boolean getDaLiJeKrajSimulacije() {
		return krajSimulacije;
	}
}
