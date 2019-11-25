package fr.afpa.ledonjon.controles;

import fr.afpa.ledonjon.entites.End;
import fr.afpa.ledonjon.entites.Player;
import fr.afpa.ledonjon.entites.Room;

public class DonjonControl {

	/**
	 * Methode qui confirme si le joueur a perdu la partie
	 * 
	 * @param didier
	 * @return
	 */

	public static int isGameLost(Player didier) {
		if (didier.getHealthPoint() <= 0) {
			System.out.println("You are dead! GAME OVER");
			return -1;
		}
		return 0;
	}

	/**
	 * Methode qui permets de confirmer si le joueur a gagnee
	 * 
	 * @param didier
	 * @param room
	 * @return
	 */

	public static int isGameWin(Player didier, Room room) {

		if (room instanceof End) {
			System.out.println("Congratulation, you win!!!!");
			return -1;
		}
		return 0;
	}

}
