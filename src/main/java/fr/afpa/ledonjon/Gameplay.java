package fr.afpa.ledonjon;

import java.util.Scanner;

import fr.afpa.ledonjon.controles.DonjonControl;
import fr.afpa.ledonjon.entites.Donjon;
import fr.afpa.ledonjon.ihm.DonjonIhm;
import fr.afpa.ledonjon.ihm.MenuIhm;
import fr.afpa.ledonjon.ihm.PlayerIhm;

/**
 * Methode qui permets de creer un donjon
 *
 */
public class Gameplay {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MenuIhm.DisplayTitle();
		String name = PlayerIhm.askName(sc);
		
		Donjon donjon = DonjonIhm.ConfigDonjon(name , sc);
		
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
		DonjonControl.EndGame(donjon,donjon.getMaze()[xPlayer][yPlayer].getDidier(), donjon.getMaze()[xPlayer][yPlayer]);
		sc.close();
	}

}
