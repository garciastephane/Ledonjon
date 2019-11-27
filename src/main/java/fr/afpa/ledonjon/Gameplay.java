package fr.afpa.ledonjon;

import java.util.Scanner;

import fr.afpa.ledonjon.controles.DonjonControl;
import fr.afpa.ledonjon.entites.Donjon;
import fr.afpa.ledonjon.ihm.DonjonIhm;
import fr.afpa.ledonjon.ihm.MenuIhm;
import fr.afpa.ledonjon.ihm.PlayerIhm;
import fr.afpa.ledonjon.services.DonjonService;
import fr.afpa.ledonjon.services.EndService;

/**
 * Methode qui permets de creer un donjon
 *
 */
public class Gameplay {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MenuIhm.DisplayTitle();
		String name = PlayerIhm.askName(sc);
		String choixDiff = null;
		int tailleX = 8;
		int tailleY = 8;
		Donjon donjon = null;
		do {
			MenuIhm.MenuInit();
			choixDiff = sc.nextLine();
			switch (choixDiff) {
			case "1":
				donjon = new Donjon(tailleX, tailleY);
				DonjonService.DonjonContainGenerator(donjon, tailleX, tailleY, "2", name);
				break;
			case "2":
				System.out.println("Choose the weight");
				try {
					tailleY = sc.nextInt();
					sc.nextLine();
				} catch (Exception e) {
					sc.nextLine();
					System.out.println("invalid");
				}
				System.out.println("Choose the height");
				try {
					tailleX = sc.nextInt();
					sc.nextLine();
				} catch (Exception e) {
					sc.nextLine();
					System.out.println("invalid");
				}
				donjon = new Donjon(tailleX, tailleY);
				do {

					MenuIhm.MenuDifficulte();
					choixDiff = sc.nextLine();
					switch (choixDiff) {
					case "1":
						DonjonService.DonjonContainGenerator(donjon, tailleX, tailleY, "1", name);
						break;
					case "2":
						DonjonService.DonjonContainGenerator(donjon, tailleX, tailleY, "2", name);
						break;
					case "3":
						DonjonService.DonjonContainGenerator(donjon, tailleX, tailleY, "3", name);
						break;
					default:
						choixDiff = null;
						break;
					}
				} while (choixDiff == null);
				break;
			case "3":
				EndService.showHigh(null);
				break;
			default:
				choixDiff = null;
				break;
			}
		} while (choixDiff == null);
		int xPlayer = 0;
		int yPlayer = 0;
		int win = 0;

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
