package org.unibl.etf.util;

import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.util.*;
import org.unibl.etf.kompanija.*;
import org.unibl.etf.prevoznasredstva.ElektricniAutomobil;
import org.unibl.etf.prevoznasredstva.ElektricniBicikl;
import org.unibl.etf.prevoznasredstva.ElektricniTrotinet;
import org.unibl.etf.prevoznasredstva.PrevoznoSredstvo;
//import org.unibl.etf.prevoznasredstva.*;

/**
 * Klasa namjenjena za učitavanje csv file-ova.
 * @author andjelabalaban
 *
 */
public class Loader {
	/**
	 * Privatni default-ni konstruktor.
	 */
	private Loader() {
		super();
	}
	
	/**
	 * Statička metoda koja učitava iznajmljivanja iz csv file-a i vraća listu iznajmljivanja. 
	 * @return lista iznajmljjivaja.
	 * @throws IOException
	 */
	public static List<Iznajmljivanje> ucitajIznajmljivaje(String putanjaIznajmljivanja) throws IOException {
		List<Iznajmljivanje> iznajmljivanja = new ArrayList<>();
		List<String> linije = Files.readAllLines(Path.of(putanjaIznajmljivanja));
		
		for(int i = 1; i < linije.size(); i++) {
//			System.out.println(linije.get(i));
			String parts[] = linije.get(i).split(",");
			if(parts.length < 8) {
				System.err.println("Linija prilikom ucitavanja nema dovoljno podataka.");
				continue;
			}
			int pocetnaLokacija[] =  new int[2];
			int odrediste[] =  new int[2];
			int trajanje = 0;
			boolean kvar = false, promocija = false;
			// generisanje datuma
			String dateTime = parts[0];
			String date = dateTime.split(" ")[0];
			String danMjesecGodina[] = date.split("[.]");
			String vrijeme[] = dateTime.split(" ")[1].split(":");
			LocalDateTime datum = LocalDateTime.of(Integer.valueOf(danMjesecGodina[2].split(" ")[0]), Integer.valueOf(danMjesecGodina[1]), Integer.valueOf(danMjesecGodina[0]), Integer.valueOf(vrijeme[0]), Integer.valueOf(vrijeme[1]));
			
			if(parts[3].startsWith("\"")) {
				parts[3] = parts[3].replace("\"", "");
				parts[4] = parts[4].replace("\"", "");
				pocetnaLokacija[0] = Integer.valueOf(parts[3]);
				pocetnaLokacija[1] = Integer.valueOf(parts[4]);
				if(parts[5].startsWith("\"")) {
					parts[5] = parts[5].replace("\"", "");
					parts[6] = parts[6].replace("\"", "");
					odrediste[0] = Integer.valueOf(parts[5]);
					odrediste[1] = Integer.valueOf(parts[6]);
					trajanje = Integer.valueOf(parts[7]); 
					kvar = parts[8].equalsIgnoreCase("da") ? true : false;
					promocija = parts[9].equalsIgnoreCase("da") ? true : false;
				}else {
					odrediste[0] = Integer.valueOf(parts[5]);
					odrediste[1] = 0;
					trajanje = Integer.valueOf(parts[6]); 
					kvar = parts[7].equalsIgnoreCase("da") ? true : false;
					promocija = parts[8].equalsIgnoreCase("da") ? true : false;
				}
			}
			else {
				pocetnaLokacija[0] = Integer.valueOf(parts[3]);
				pocetnaLokacija[1] = 0;
				if(parts[4].startsWith("\"")) {
					parts[4] = parts[4].replace("\"", "");
					parts[5] = parts[5].replace("\"", "");
					odrediste[0] = Integer.valueOf(parts[4]);
					odrediste[1] = Integer.valueOf(parts[5]);
					trajanje = Integer.valueOf(parts[6]); 
					kvar = parts[7].equalsIgnoreCase("da") ? true : false;
					promocija = parts[8].equalsIgnoreCase("da") ? true : false;
				}else {
					odrediste[0] = Integer.valueOf(parts[4]);
					odrediste[1] = 0;
					trajanje = Integer.valueOf(parts[5]); 
					kvar = parts[6].equalsIgnoreCase("da") ? true : false;
					promocija = parts[7].equalsIgnoreCase("da") ? true : false;
				}
			}
			 
			iznajmljivanja.add(new Iznajmljivanje(datum, parts[1], parts[2], pocetnaLokacija, odrediste, trajanje, kvar, promocija));
			
		}
		return iznajmljivanja;	
	}
	
	
	/**
	 * Statička metoda koja učitava prevozna sredstva iz file-a i vraća listu prevoznih sredstava.
	 * @return lista prevoznih sredstava učitanih iz csv file-a.
	 * @throws IOException
	 */
	public static List<PrevoznoSredstvo> ucitajPrevoznaSredstva(String putanjaPrevoznaSredstva) throws IOException {
		List<PrevoznoSredstvo> prevoznaSredstva = new ArrayList<>();
		List<String> linije = Files.readAllLines(Path.of(putanjaPrevoznaSredstva));
		for(int i = 1; i < linije.size(); i++) {
			String parts[] = linije.get(i).split(",");
			String vrsta = parts[8];
			if(vrsta.equalsIgnoreCase("automobil")) {	// prevozno sredstvo je automobil
				String date = parts[3];
				String danMjesecGodina[] = date.split("[.]");
				LocalDate datum = LocalDate.of(Integer.valueOf(danMjesecGodina[2]), Integer.valueOf(danMjesecGodina[1]), Integer.valueOf(danMjesecGodina[0]));
				prevoznaSredstva.add(new ElektricniAutomobil(parts[0], parts[1], parts[2], datum, Double.valueOf(parts[4]), parts[7]));
			}
			else if(vrsta.equalsIgnoreCase("bicikl")) {	// prevozno sredstvo je biciklo
				prevoznaSredstva.add(new ElektricniBicikl(parts[0], parts[1], parts[2], Double.valueOf(parts[4]), Integer.valueOf(parts[5])));
			}
			else {		// prevozno sredstvo je trotinet
				prevoznaSredstva.add(new ElektricniTrotinet(parts[0], parts[1], parts[2], Double.valueOf(parts[4]), Integer.valueOf(parts[6])));
			}
		}
		return prevoznaSredstva;
	}
	
	
}
