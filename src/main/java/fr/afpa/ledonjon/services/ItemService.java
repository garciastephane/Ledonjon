package fr.afpa.ledonjon.services;

import fr.afpa.ledonjon.entites.Player;

public class ItemService {
	public static void Heal(Player didier) {
		didier.setHealthPoint(didier.getHealthPoint() + UtilService.RamdomNumberGenerator(2) + 1);
	}

	public static void LootGold(Player didier) {
		didier.setHealthPoint(didier.getGold() + UtilService.RamdomNumberGenerator(8) + 1);
	}
}
