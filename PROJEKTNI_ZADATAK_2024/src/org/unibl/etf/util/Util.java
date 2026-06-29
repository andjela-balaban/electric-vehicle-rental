package org.unibl.etf.util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

/**
 * Ova klasa je pomoćna klasa koja sadrži razne statičke metode namjenjene za pomoć u radu. 
 * @author andjelabalaban
 *
 */
public class Util {
	/**
	 * Privatni default-ni konstruktor.
	 */
	private Util() {
		super();
	}
	
	/**
	 * Statička metoda nemjenjena za generisanje slučajnog cijelog broja.
	 * @param min
	 * @param max
	 * @return slučajni cijeli broj.
	 */
	public static int generateRandomInt(int min, int max) {
		return (int)(Math.random() * (max - min)) + min;       
	}
	
	
	/**
	 * Statička metoda nemjenjena za generisanje slučajne boolean vrijednosti.
	 * @return slučajna boolean vrijednost.
	 */
	public static boolean generateRandomBoolean() { 
		Random random = new Random();
		return random.nextBoolean();
	}
	
	/**
	 * Statička metoda nemjenjena za generisanje slučajne vjerovatnoće.
	 * @param vjerovatnoca
	 * @return slučajna vjerovatnoća.
	 */
	public static boolean generateVjerovatnoca(int vjerovatnoca) {
		double vjerovatnoca2 = Math.random();
		
		return (vjerovatnoca2 < ((double)vjerovatnoca/100));		
	}
	
	/**
	 * Statička metoda nemjenjena za generisanje putanje (objekat Path) od paramtra koji je poslat kao String vrijednost.
	 * @param path
	 * @return Path objekat poslate String putanje.
	 */
	public static Path generateStringToPath(String path) {
		String[] parts = path.split("/"); 
		return Paths.get(parts[0], Arrays.copyOfRange(parts, 1, parts.length));
	}
	
	/**
	 * Statička metoda nemjenjena za kreiranje putanje bez obzira na operativni sistem na kojem se program izvršava. Putanja se šalje preko String parametra koji je poslat.
	 * @param input
	 * @return kreirana putanja.
	 */
	public static String buildPath(String input) {
        // Zamjena svih pojava "\" i "/" s odgovarajućim separatorom za trenutni OS
        String separator = File.separator;
        String path = input.replaceAll("[\\\\/]", separator);
        
        // Ako je zadnji znak separator, ukloni ga
        if (path.endsWith(separator)) {
            path = path.substring(0, path.length() - 1);
        }
        
        return path;
    }

}
