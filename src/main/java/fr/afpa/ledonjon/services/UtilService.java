package fr.afpa.ledonjon.services;

import java.util.Random;

public class UtilService {
	
	/**
	 * Methode qui permets de generer un numero aleatoire
	 * @param nbMax
	 * @return
	 */
	public static int RamdomNumberGenerator(int nbMax) {
		if (nbMax > 0) {
			return new Random().nextInt(nbMax);
		}
		return 0;
	}
}
