package fr.afpa.ledonjon.controles;

import fr.afpa.ledonjon.entites.End;
import fr.afpa.ledonjon.entites.Player;
import fr.afpa.ledonjon.entites.Room;

public class DonjonControl {

	/**
	 * Methode qui confirme si le joueur a perdu la partie ou si le joueur a gagnee
	 * 
	 * @param didier
	 * @param room
	 * @return
	 */

	public static void EndGame(Player didier,Room room) {
		if (didier.getHealthPoint() <= 0) {
			System.out.println("You are dead! GAME OVER");
		}else if (room instanceof End) {
			System.out.println("Congratulation, you win!!!!");	
		}	
	}
}
