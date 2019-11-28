package fr.afpa.ledonjon.controles;

import fr.afpa.ledonjon.entites.Donjon;
import fr.afpa.ledonjon.entites.End;
import fr.afpa.ledonjon.entites.Player;
import fr.afpa.ledonjon.entites.Room;
import fr.afpa.ledonjon.ihm.DonjonIhm;
import fr.afpa.ledonjon.services.DonjonService;

public class DonjonControl {

	/**
	 * Methode qui confirme si le joueur a perdu la partie ou si le joueur a gagnee
	 * 
	 * @param didier
	 * @param room
	 * @return
	 */

	public static boolean EndGame(Donjon donjon, Player didier,Room room) {
		if (didier.getHealthPoint() <= 0) {
			System.out.println("You are dead! GAME OVER");
			return false;
		}else if (room instanceof End) {
			System.out.println("Congratulation, you win!!!!");	
			DonjonService.ChangeHighScore(donjon,didier);
			DonjonIhm.ShowHigh(donjon.getHighScores());
			DonjonService.WriteScore(donjon);
			return true;
		}
		return false;
	}

}
