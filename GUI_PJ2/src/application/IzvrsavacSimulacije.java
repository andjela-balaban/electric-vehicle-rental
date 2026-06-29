package application;

import static org.unibl.etf.util.SimulacioniParametri.DUZINA_GRADA;
import static org.unibl.etf.util.SimulacioniParametri.IZNAJMLJIVANJE_PUTANJA;
import static org.unibl.etf.util.SimulacioniParametri.PREVOZNA_SREDSTVA_PUTANJA;
import static org.unibl.etf.util.SimulacioniParametri.SIRINA_GRADA;

import java.io.IOException;
import java.util.*;
import org.unibl.etf.kompanija.Iznajmljivanje;
import org.unibl.etf.kompanija.Kompanija;
import org.unibl.etf.prevoznasredstva.PrevoznoSredstvo;
import org.unibl.etf.util.Loader;

public class IzvrsavacSimulacije {

	static Kompanija kompanija;
	
	static {
		List<PrevoznoSredstvo> ps;
		try {
			ps = Loader.ucitajPrevoznaSredstva(PREVOZNA_SREDSTVA_PUTANJA);
			List<Iznajmljivanje> iznajmljivanja = Loader.ucitajIznajmljivaje(IZNAJMLJIVANJE_PUTANJA);
			kompanija = new Kompanija(ps, iznajmljivanja, SIRINA_GRADA, DUZINA_GRADA);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void pokreni() {
			
		System.out.println("---------------------------------------------------------------------");
//		System.out.println(kompanija.getTrenutniDatumVrijeme());
//		System.out.println("---------------------------------------------------------------------");
		
		
		Thread thread = new Thread(() -> {
			try {
				kompanija.iznajmljivanjeSimulacija();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		thread.start();
	}
}
