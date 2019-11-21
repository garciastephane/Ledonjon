package fr.afpa.ledonjon;

import fr.afpa.ledonjon.entites.Donjon;
import fr.afpa.ledonjon.ihm.DonjonIhm;
import fr.afpa.ledonjon.services.DonjonService;

/**
 * Creer un donjon
 *
 */
public class Gameplay {
	public static void main(String[] args) {
		Donjon donjon = new Donjon(DonjonService.configXMaze(), DonjonService.configYMaze());
		DonjonService.generateMaze(donjon, donjon.getX()/ 2, donjon.getY()/ 2);
		DonjonIhm.DisplayDonjon(donjon);
	}

}
