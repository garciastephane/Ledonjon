package fr.afpa.ledonjon;

import fr.afpa.ledonjon.entites.Donjon;
import fr.afpa.ledonjon.ihm.DonjonIhm;
import fr.afpa.ledonjon.services.DonjonService;

/**
 * Hello world!
 *
 */
public class Gameplay {
	public static void main(String[] args) {
		int tailleX = 10;
		int tailleY = 10;
		Donjon donjon = new Donjon(tailleX, tailleY);
		DonjonService.generateMaze(donjon, tailleX / 2, tailleY / 2);
		DonjonIhm.DisplayDonjon(donjon);
	}

}
