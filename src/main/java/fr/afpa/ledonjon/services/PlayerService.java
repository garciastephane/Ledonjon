package fr.afpa.ledonjon.services;

import fr.afpa.ledonjon.entites.Player;
import fr.afpa.ledonjon.entites.Start;
import fr.afpa.ledonjon.entites.Character;

public class PlayerService {
	/**
	 * Methode qui permets de creer un joueur
	 * 
	 * @param start
	 * @return
	 */
	public static Player CreatePlayer(Start start) {
		return new Player(9 + UtilService.RamdomNumberGenerator(5), 2 + UtilService.RamdomNumberGenerator(2), 0, true,
				start);
	}

	/**
	 * Methode qui permets a un player d'attaquer un mob
	 * 
	 * @param attacker
	 * @param defender
	 */
	public static void Attack(Character attacker, Character defender) {
		System.out.println("---------------------\n");
		System.out.println("You attack the monster for " + attacker.getStrength() + " damages");
		if(CharacterSevice.LoseHealth(defender, attacker.getStrength())) {
			System.out.println("\nCongratulations! you beat that little bastard!" + defender.getGold() + "gold! \n");
			WinGold((Player)attacker, defender.getGold());
		}else {
			System.out.println("that filthy creature got" + attacker.getHealthPoint() + " HP left");
			MobService.Attack(defender, attacker );
		}
	}

	public static void GainHp(Player didier, int receavedHp) {
		didier.setHealthPoint(didier.getHealthPoint() + receavedHp);
	}

	public static void BeinStrongther(Player didier, int strengthGain) {
		didier.setStrength(didier.getStrength() + strengthGain);
	}

	public static void WinGold(Player didier, int receavedGold) {
		didier.setGold(didier.getGold() + receavedGold);
	}
}
