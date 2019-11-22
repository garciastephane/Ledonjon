package fr.afpa.ledonjon;

import fr.afpa.ledonjon.entites.Donjon;
import fr.afpa.ledonjon.ihm.DonjonIhm;
import fr.afpa.ledonjon.services.DonjonService;
import fr.afpa.ledonjon.services.PlayerService;

/**
 * Creer un donjon
 *
 */
public class Gameplay {
	public static void main(String[] args) {
//		Donjon donjon = new Donjon(DonjonService.configXMaze(), DonjonService.configYMaze());
//		DonjonService.generateMaze(donjon, donjon.getX()/ 2, donjon.getY()/ 2);
		int tailleX = 10;
		int tailleY = 10;
		Donjon donjon = new Donjon(tailleX, tailleY);
		DonjonService.generateMaze(donjon, tailleX / 2, tailleY / 2);
		DonjonIhm.DisplayDonjon(donjon);
		PlayerService.CreatePlayer(donjon.getMaze()[0][0]);
		DonjonService.generateMob(donjon, tailleX ,tailleY);
		DonjonService.generateItem(donjon, tailleX ,tailleY);
		DonjonIhm.DisplayFullDonjon(donjon);
		System.out.println("oui");
	}

}
