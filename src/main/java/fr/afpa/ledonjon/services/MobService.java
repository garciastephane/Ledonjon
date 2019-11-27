package fr.afpa.ledonjon.services;

import fr.afpa.ledonjon.controles.CharacterControl;
import fr.afpa.ledonjon.entites.Character;
import fr.afpa.ledonjon.entites.Donjon;
import fr.afpa.ledonjon.entites.Mob;
import fr.afpa.ledonjon.entites.Room;

public class MobService {
	/**
	 * Methode qui permets de creer un mob
	 * @param tailleY 
	 * @param tailleX 
	 * @param map
	 * @return
	 */
	public static void CreateMob(Donjon donjon, int tailleX, int tailleY) {
		Room room = RoomServices.FindValidRoom(donjon, tailleX, tailleY);
		room.getMobs().add(new Mob(7 + UtilService.RamdomNumberGenerator(6), 2 + UtilService.RamdomNumberGenerator(3),
				UtilService.RamdomNumberGenerator(9), true)) ;

	}

	/**
	 * Methode qui permets a un mob d'attaquer un player
	 * 
	 * @param attacker
	 * @param defender
	 */
	public static void Attack(Character attacker, Character defender) {
		System.out.println("---------------------\n");
		System.out.println("The filthy monster attack you for " + attacker.getStrength() + " damages");
		CharacterSevice.LoseHealth(defender, attacker.getStrength());
		if(CharacterControl.isAlive(defender)) {
			System.out.println("You got " + defender.getHealthPoint() + " HP left");
		}else {
			System.out.println("he is dead");
		}
		
		System.out.println();
	}

}
