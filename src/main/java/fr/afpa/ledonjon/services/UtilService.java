package fr.afpa.ledonjon.services;

import java.util.Random;

public class UtilService {
	public static int RamdomNumberGenerator(int nbMax) {
		return new Random().nextInt(nbMax);
	}
}
