package org.unibl.etf.prevoznasredstvagenerator;

import java.util.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.io.*;
import static org.unibl.etf.util.SimulacioniParametri.*;
import org.unibl.etf.prevoznasredstva.*;

/**
 *  <p>PrevoznaSredstvaGenerator je klasa koja je zadužena za generisanje prevoznih sredstava. Ova klasa generiše, tj. učitava prevozna sredstva 
 * iz csv file-a. </p>
 * @author andjelabalaban
 *
 */
public class PrevoznaSredstvaGenerator {
	private static String putanja = PREVOZNA_SREDSTVA_PUTANJA;
	
	/**
	 * Privatni default-ni konstruktor klase PrevoznaSredstvaGenerator
	 */
	private PrevoznaSredstvaGenerator() {
		super();
	}
	
	/**
	 * Statička metoda koja učitava prevozna sredstva iz file-a i vraća listu prevoznih sredstava.
	 * @return lista prevoznih sredstava učitanih iz csv file-a.
	 * @throws IOException
	 */
	public static List<PrevoznoSredstvo> generatePrevoznaSredstva() throws IOException {
		List<PrevoznoSredstvo> prevoznaSredstva = new ArrayList<>();
		List<String> linije = Files.readAllLines(Path.of(putanja));
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
