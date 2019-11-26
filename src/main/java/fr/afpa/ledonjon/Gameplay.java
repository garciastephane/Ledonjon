package fr.afpa.ledonjon;

import java.util.Scanner;

import fr.afpa.ledonjon.entites.Donjon;
import fr.afpa.ledonjon.ihm.DonjonIhm;
import fr.afpa.ledonjon.ihm.MenuIhm;
import fr.afpa.ledonjon.services.DonjonService;
import fr.afpa.ledonjon.services.MenuService;

/**
 * Creer un donjon
 *
 */
public class Gameplay {
	public static void main(String[] args) {
//		Donjon donjon = new Donjon(DonjonService.configXMaze(), DonjonService.configYMaze());
//		DonjonService.generateMaze(donjon, donjon.getX()/ 2, donjon.getY()/ 2);
		Scanner sc = new Scanner(System.in);
		int tailleX = 3;
		int tailleY = 4;
		
		Donjon donjon = new Donjon(tailleX, tailleY);
		DonjonService.DonjonContainGenerator(donjon,tailleX,tailleY);
		int xPlayer = 0;
		int yPlayer = 0;
		int win = 0;
		MenuIhm.DisplayTitle();
		
		
		
		DonjonIhm.DisplayDonjon(donjon);
		
		
		do {
			DonjonIhm.DisplayDonjon(donjon);
			DonjonIhm.DisplayFullDonjon(donjon);
			MenuIhm.DisplayPlayerMenu(donjon.getMaze()[yPlayer][xPlayer]);
			char choix = '0';
			try {
				choix = sc.nextLine().toUpperCase().charAt(0);
			}catch (Exception e) {
				
			}
			
			if (choix == 'E'||choix == 'W') {
				xPlayer = MenuService.Choix(choix, donjon, yPlayer, xPlayer , sc);
			}else if (choix == 'N'||choix == 'S') {
				yPlayer = MenuService.Choix(choix, donjon, yPlayer, xPlayer , sc);
			} else {
				win = MenuService.Choix(choix, donjon, xPlayer, yPlayer , sc);
			}
		} while (win != -1);
		sc.close();
	}

}
