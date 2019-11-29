package fr.afpa.ledonjon.services;

import fr.afpa.ledonjon.entites.GoldPouch;
import fr.afpa.ledonjon.entites.HealthPotion;
import fr.afpa.ledonjon.entites.Item;
import fr.afpa.ledonjon.entites.Player;
import fr.afpa.ledonjon.entites.Room;
import fr.afpa.ledonjon.entites.SlotMachine;
import fr.afpa.ledonjon.entites.StrengthPotion;
import fr.afpa.ledonjon.ihm.ItemIhm;

public class ItemService {

	/**
	 * Methode pour creer une potion de vie
	 * 
	 * @param room
	 */
	public static void CreateHealthPotion(Room room) {
		room.getItems().add(new HealthPotion());
	}

	/**
	 * Methode pour creer une potion de force
	 * 
	 * @param room
	 */
	public static void CreateStrengthPotion(Room room) {
		room.getItems().add(new StrengthPotion());
	}

	/**
	 * Methode pour creer une poche d or
	 * 
	 * @param room
	 */

	public static void CreateGoldPouch(Room room) {
		room.getItems().add(new GoldPouch());
	}

	/**
	 * Methode pour creer une machine a sous
	 */
	public static void CreateSlotMachine(Room room) {
		room.getItems().add(new SlotMachine());

	}

	/**
	 * Methode pour faire gagner des points de vie au joueur
	 * 
	 * @param didier
	 */

	public static void Heal(Player didier) {
		int receavedHp = UtilService.RamdomNumberGenerator(5) + 1;
		PlayerService.GainHp(didier, receavedHp);
		ItemIhm.HealDisplay(receavedHp);
	}

	/**
	 * Methode pour faire gagner de la force au joueur
	 * 
	 * @param didier
	 */
	public static void GainStrength(Player didier) {
		didier.setStrength(didier.getStrength() + 1);
		PlayerService.BeinStrongther(didier, 1);
		ItemIhm.GainStrengthDisplay();
	}

	/**
	 * Methode pour donner de l or au joueur
	 * 
	 * @param didier
	 */
	public static void LootGold(Player didier) {
		int receavedGold = UtilService.RamdomNumberGenerator(8) + 1;
		PlayerService.WinGold(didier, receavedGold);
		ItemIhm.LootGoldDisplay(receavedGold);
	}

	/**
	 * Methode pour creer une machine a sous
	 * 
	 * @param didier
	 */

	public static boolean Gamble(Player didier) {
		int d100 = UtilService.RamdomNumberGenerator(100) + 1;
		ItemIhm.RewardDisplay(d100);
		if (didier.getGold() > 0) {
			didier.setGold(didier.getGold()-1);
			if (d100 <= 30) {
				LootGold(didier);
			} else if (d100 > 30 && d100 <= 50) {
				Heal(didier);
			} else if (d100 > 50 && d100 <= 55) {
				GainStrength(didier);
			} else if (d100 > 55 && d100 <= 60) {

			} else if (d100 > 60 && d100 <= 65) {

			} else if (d100 > 60 && d100 <= 65) {

			} else if (d100 > 65 && d100 <= 65) {

			} else if (d100 > 70 && d100 <= 76) {

			} else if (d100 == 77) {

			} else if (d100 > 78 && d100 <= 80) {

			} else if (d100 > 80 && d100 <= 85) {

			} else if (d100 > 85 && d100 <= 95) {

			} else if (d100 > 95 && d100 <= 97) {

			} else if (d100 == 98) {

			} else if (d100 == 99) {
				CharacterSevice.LoseHealth(didier, didier.getHealthPoint());
			} else if (d100 == 100) {
				ItemService.Gamble(didier);
			}
		}

		return true;
	}

	/**
	 * Methode pour retirer un item a un personnage
	 * 
	 * @param room
	 * @param item
	 */
	public static void RemoveItem(Room room, Item item) {
		room.getItems().remove(item);
	}
}
