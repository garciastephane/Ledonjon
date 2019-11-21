package fr.afpa.ledonjon.services;

import fr.afpa.ledonjon.entites.Player;
import fr.afpa.ledonjon.entites.Start;
import fr.afpa.ledonjon.entites.Character;

public class PlayerService {
	/**
	 * Methode qui permets de creer un joueur
	 * @param start
	 * @return
	 */
	public static Player CreatePlayer(Start start) {
		return new Player(9 + UtilService.RamdomNumberGenerator(5), 2 + UtilService.RamdomNumberGenerator(2), 0, true, start);
	}
	
	
	
	
	public static  void Attack(Character attacker, Character defender) {
		System.out.println("---------------------\n");
		System.out.println("You attack the monster for "+  attacker.getStrength() + " damages");
		CharacterSevice.LoseHealth(defender, attacker.getStrength());
		System.out.println("Now, that disgusting and ugly monster got" + defender.getHealthPoint() + " HealthPoint");
		System.out.println();
		
	}
	
	
}
