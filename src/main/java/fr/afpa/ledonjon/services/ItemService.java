package fr.afpa.ledonjon.services;

import fr.afpa.ledonjon.entites.Mob;
import fr.afpa.ledonjon.entites.Player;
import fr.afpa.ledonjon.ihm.ItemIhm;

public class ItemService {
	public static void Heal(Player didier) {
		int receavedHp = UtilService.RamdomNumberGenerator(2) + 1;
		didier.setHealthPoint(didier.getHealthPoint() + receavedHp);
		ItemIhm.HealDisplay(receavedHp);
	}

	public static void GainStrength(Mob mob) {
		mob.setStrength(mob.getStrength() + 1);
		ItemIhm.GainStrengthDisplay();
	}

	public static void LootGold(Player didier) {
		int receavedGold = UtilService.RamdomNumberGenerator(8) + 1;
		didier.setHealthPoint(didier.getGold() + receavedGold);
		ItemIhm.LootGoldDisplay(receavedGold);
	}

}
