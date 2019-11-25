package fr.afpa.ledonjon.ihm;

import fr.afpa.ledonjon.controles.RoomControl;
import fr.afpa.ledonjon.entites.Room;

public class MenuIhm {

	/**
	 * Methode qui permets d afficher le menu initial au joueur
	 */

	public static void DisplayPlayerMenu(Room room ) {
		System.out.println("*************MENU*************");

		System.out.println("\n What do you want to do?\n");
		System.out.println("Lock around");

		if (RoomControl.numbAliveMob(room) > 0) {
			System.out.println("Attack");
		} else {
			if (RoomControl.numbItem(room) > 0) {
				System.out.println("Use Item");
			} 
			if (room.isNorth()) System.out.println("Move North");
			if (room.isEst()) System.out.println("Move Est");
			if (room.isSouth())System.out.println("Move South");
			if (room.isWest())System.out.println("Move West");
			
		}
	}

	public static void DisplayTitle() {
		System.out.println("" + "THE SACRED LAIR OF THE ANCIENT ELDER MAGIC SORCEROR DRAGON LORD OF THE ULTIMATE \r\n"
				+ "         STRONGHOLD OF THE NORTHERN LAND OF THE INFINITE SOUTHEN COST,\r\n"
				+ "LOYAL VASAL OF THE MAGNIFICENT ROYAL EMPEROR OF THE EIGHTEEN CONQUERED KINGDOMS \r\n"
				+ " AND THE HIGH CASTLE OF THE GREATEST EMPIRE THE FORBIDEN PLANETE OF THE HIGHER \r\n"
				+ "           DEVILISH GALAXIE OF THE BRIGTEST RISING LOST LAST STAR,\r\n"
				+ "             POWERFUL GUADIAN OF THE GREAT AND STRONG DONJON OF \r\n"
				+ "             THE MISTIC HEROIC SECRET LEGEND OF THE FINAL QUEST \r\n\n");
	}

}
