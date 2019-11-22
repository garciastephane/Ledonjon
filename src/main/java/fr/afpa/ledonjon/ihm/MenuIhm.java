package fr.afpa.ledonjon.ihm;

import fr.afpa.ledonjon.controles.RoomControl;
import fr.afpa.ledonjon.entites.Room;


public class MenuIhm {

	/**
	 * Methode qui permets d afficher le menu
	 */

	public static void DisplayPlayerMenu() {
		Room room = null;

		System.out.println("*************MENU*************");

		System.out.println("\n What do you want to do?\n");
		System.out.println("Lock around");

		if (RoomControl.numbAliveMob(room) > 0) {
			System.out.println("Attack");
		} else {
			System.out.println("Move North");
			System.out.println("Move Est");
			System.out.println("Move West");
			System.out.println("Move South");
		}
	}

}
