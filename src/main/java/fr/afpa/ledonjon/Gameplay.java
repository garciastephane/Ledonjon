package fr.afpa.ledonjon;

import java.util.Scanner;

import fr.afpa.ledonjon.controles.DonjonControl;
import fr.afpa.ledonjon.entites.Donjon;
import fr.afpa.ledonjon.ihm.DonjonIhm;
import fr.afpa.ledonjon.ihm.MenuIhm;
import fr.afpa.ledonjon.services.DonjonService;
import fr.afpa.ledonjon.services.EndService;

/**
 * Methode qui permets de creer un donjon
 *
 */
public class Gameplay {
	public static void main(String[] args) {
		MenuIhm.MenuInit();
		Scanner in = new Scanner(System.in);
		String choix = in.nextLine();
		switch (choix) {
		case "1" : partieRapide();break;
		case "2" : partieConfig();break;
		case "3" : EndService.showHigh(null);break;
		default : break;
		}
			
		}	
		public static void partieRapide() {
//		Donjon donjon = new Donjon(DonjonService.configXMaze(), DonjonService.configYMaze());
//		DonjonService.generateMaze(donjon, donjon.getX()/ 2, donjon.getY()/ 2);
		Scanner sc = new Scanner(System.in);
		int tailleX = 8;
		int tailleY = 8;

		Donjon donjon = new Donjon(tailleX, tailleY);
		DonjonService.DonjonContainGenerator(donjon, tailleX, tailleY);
		int xPlayer = 0;
		int yPlayer = 0;
		int win = 0;
		MenuIhm.DisplayTitle();

		do {
			DonjonIhm.DisplayPlayerInDonjon(donjon);
			MenuIhm.DisplayPlayerMenu(donjon.getMaze()[xPlayer][yPlayer]);
			char choix = '0';
			try {
				choix = sc.nextLine().toUpperCase().charAt(0);
			} catch (Exception e) {

			}

			if (choix == 'E' || choix == 'W') {
				yPlayer = MenuIhm.Choix(choix, donjon, xPlayer, yPlayer, sc);
			} else if (choix == 'N' || choix == 'S') {
				xPlayer = MenuIhm.Choix(choix, donjon, xPlayer, yPlayer, sc);
			} else {
				win = MenuIhm.Choix(choix, donjon, xPlayer, yPlayer, sc);
			}
			
		} while (win != -1);
		DonjonControl.EndGame(donjon.getMaze()[xPlayer][yPlayer].getDidier(), donjon.getMaze()[xPlayer][yPlayer]);
		sc.close();
	}
		
		public static void partieConfig() {
//			Donjon donjon = new Donjon(DonjonService.configXMaze(), DonjonService.configYMaze());
//			DonjonService.generateMaze(donjon, donjon.getX()/ 2, donjon.getY()/ 2);
			Scanner sc = new Scanner(System.in);
			//int tailleX = 8;
			//int tailleY = 8;
			System.out.println("hauteur du labyrinthe ?");
			int tailleX = sc.nextInt();
			sc.nextLine();
			System.out.println("largueur du labyrinthe ?");
			int tailleY = sc.nextInt();
			sc.nextLine();
//			MenuIhm.MenuDifficulte();
//			String choix2 = sc.nextLine();
//			switch (choix2) {
//			case "1" : 
//			}
			Donjon donjon = new Donjon(tailleX, tailleY);
			DonjonService.DonjonContainGenerator(donjon, tailleX, tailleY);
			int xPlayer = 0;
			int yPlayer = 0;
			int win = 0;
			MenuIhm.DisplayTitle();

			do {
				DonjonIhm.DisplayPlayerInDonjon(donjon);
				MenuIhm.DisplayPlayerMenu(donjon.getMaze()[xPlayer][yPlayer]);
				char choix = '0';
				try {
					choix = sc.nextLine().toUpperCase().charAt(0);
				} catch (Exception e) {

				}

				if (choix == 'E' || choix == 'W') {
					yPlayer = MenuIhm.Choix(choix, donjon, xPlayer, yPlayer, sc);
				} else if (choix == 'N' || choix == 'S') {
					xPlayer = MenuIhm.Choix(choix, donjon, xPlayer, yPlayer, sc);
				} else {
					win = MenuIhm.Choix(choix, donjon, xPlayer, yPlayer, sc);
				}
				
			} while (win != -1);
			DonjonControl.EndGame(donjon.getMaze()[xPlayer][yPlayer].getDidier(), donjon.getMaze()[xPlayer][yPlayer]);
			sc.close();
		}
		

}
