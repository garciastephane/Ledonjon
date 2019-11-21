package fr.afpa.ledonjon.services;

import fr.afpa.ledonjon.entites.Donjon;

public class DonjonService {

	public static boolean generateMob(Donjon donjon) {

		int numMob = UtilService.RamdomNumberGenerator(7) + 1;

		for (int i = 0; i < numMob; i++) {
			donjon.getMobs().add(MobService.CreateMob(donjon.getMap()));
		}
		return true;
	}
}
