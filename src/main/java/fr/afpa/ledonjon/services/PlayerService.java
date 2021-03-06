
package fr.afpa.ledonjon.services;

import fr.afpa.ledonjon.entites.Player;
import fr.afpa.ledonjon.entites.Room;
import fr.afpa.ledonjon.entites.SlotMachine;
import fr.afpa.ledonjon.entites.StrengthPotion;
import fr.afpa.ledonjon.ihm.ItemIhm;
import fr.afpa.ledonjon.controles.CharacterControl;
import fr.afpa.ledonjon.entites.Character;
import fr.afpa.ledonjon.entites.GoldPouch;
import fr.afpa.ledonjon.entites.HealthPotion;
import fr.afpa.ledonjon.entites.Item;

public class PlayerService {
	/**
	 * Methode qui permets de creer un joueur
	 * 
	 * @param start
	 * @return
	 */
	public static void CreatePlayer(String name, Room room) {
		room.setDidier(new Player(name, 21 + UtilService.RamdomNumberGenerator(5),
				4 + UtilService.RamdomNumberGenerator(3), 0, true));

	}

	/**
	 * Methode qui permets d utiliser un objet
	 * 
	 * @param didier
	 * @param room
	 * @param item
	 */
	public static void UseItem(Player didier, Room room, Item item) {
		if (item instanceof HealthPotion) {
			ItemService.Heal(didier);
		} else if (item instanceof StrengthPotion) {
			ItemService.GainStrength(didier);
		} else if (item instanceof GoldPouch) {
			ItemService.LootGold(didier);
		} else if (item instanceof SlotMachine) {
			if (didier.getGold() > 0) {
				ItemService.Gamble(didier);
			}else {
				ItemIhm.RewardDisplay(-1);
			}
		}
		ItemService.RemoveItem(room, item);
	}

	/**
	 * Methode qui permets a un personnaGe d'attaquer un mob
	 * 
	 * @param attacker
	 * @param defender
	 */
	public static void Attack(Character attacker, Character defender) {
		System.out.println("---------------------\n");
		System.out.println("You attack the monster for " + attacker.getStrength() + " damages");
		CharacterSevice.LoseHealth(defender, attacker.getStrength());
		if (!CharacterControl.isAlive(defender)) {
			System.out.println("\nCongratulations! you beat the monster ! " + defender.getGold() + " gold! \n");
			WinGold((Player) attacker, defender.getGold());
		} else {
			System.out.println("that filthy creature got " + defender.getHealthPoint() + " HP left");
			MobService.Attack(defender, attacker);
		}
	}

	/**
	 * Methode qui permets de gagner des points de vie
	 * 
	 * @param didier
	 * @param receavedHp
	 */
	public static void GainHp(Player didier, int receavedHp) {
		didier.setHealthPoint(didier.getHealthPoint() + receavedHp);
	}

	/**
	 * Methode qui permets de gagner de la force
	 * 
	 * @param didier
	 * @param strengthGain
	 */
	public static void BeinStrongther(Player didier, int strengthGain) {
		didier.setStrength(didier.getStrength() + strengthGain);
	}

	/**
	 * Methode qui permets de gagner des pieces d or
	 * 
	 * @param didier
	 * @param receavedGold
	 */

	public static void WinGold(Player didier, int receavedGold) {
		didier.setGold(didier.getGold() + receavedGold);
	}

	/**
	 * Methode qui permets de se deplacer
	 * 
	 * @param room
	 * @param roomS
	 */

	public static void Move(Room room, Room roomS) {
		roomS.setDidier(room.getDidier());
		room.setDidier(null);
	}



}
