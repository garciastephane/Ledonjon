package fr.afpa.ledonjon.services;

import fr.afpa.ledonjon.entites.Character;
import fr.afpa.ledonjon.entites.Coordonate;
import fr.afpa.ledonjon.entites.Mob;
import fr.afpa.ledonjon.entites.Room;

public class MobService {
	/**
	 * Methode qui permets de creer un mob
	 * @param map
	 * @return
	 */
	public static Mob CreateMob(Coordonate map) {
		Room room = RoomServices.FindValidRoom(map);
		return new Mob(7 + UtilService.RamdomNumberGenerator(5), 2 + UtilService.RamdomNumberGenerator(2),
				UtilService.RamdomNumberGenerator(9), true, room);

	}

	/**
	 * Methode qui permets à un mob d'attaquer un player
	 * 
	 * @param attacker
	 * @param defender
	 */
	public static void Attack(Character attacker, Character defender) {
		System.out.println("---------------------\n");
		System.out.println("The filthy monster attack you for " + attacker.getStrength() + " damages");
		if(CharacterSevice.LoseHealth(defender, attacker.getStrength())) {
			System.out.println("You got" + attacker.getHealthPoint() + " HP left");
		}else {
			System.out.println("he is dead");
		}
		
		System.out.println();
	}

}
