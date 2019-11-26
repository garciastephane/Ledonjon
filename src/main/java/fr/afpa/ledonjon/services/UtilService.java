package fr.afpa.ledonjon.services;

import java.util.Random;

public class UtilService {
	
	/**
	 * Methode qui permets de generer un numero aleatoire
	 * @param nbMax
	 * @return
	 */
	public static int RamdomNumberGenerator(int nbMax) {
		return new Random().nextInt(nbMax);
	}
}
