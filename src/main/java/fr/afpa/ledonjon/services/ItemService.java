package fr.afpa.ledonjon.services;

import fr.afpa.ledonjon.entites.Player;
import fr.afpa.ledonjon.ihm.ItemIhm;

public class ItemService {
	public static void Heal(Player didier) {
		int receavedHp = UtilService.RamdomNumberGenerator(2) + 1;
		PlayerService.GainHp(didier, receavedHp);
		ItemIhm.HealDisplay(receavedHp);
	}

	public static void GainStrength(Player didier) {
		didier.setStrength(didier.getStrength() + 1);
		PlayerService.BeinStrongther(didier , 1);
		ItemIhm.GainStrengthDisplay();
	}

	public static void LootGold(Player didier) {
		int receavedGold = UtilService.RamdomNumberGenerator(8) + 1;
		PlayerService.WinGold(didier,receavedGold);
		ItemIhm.LootGoldDisplay(receavedGold);
	}

	public static void Gamble(Player didier) {
		int d100 = UtilService.RamdomNumberGenerator(100) + 1;
		if (d100 <= 30) {
			LootGold(didier);
		} else if (d100 > 30 && d100 <= 50) {
			Heal(didier);
		} else if (d100 > 50 && d100 <= 55) {
			GainStrength(didier);
		} else if (d100 > 55 && d100 <= 100) {
			if (d100 > 55 && d100 <= 60) {

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

			} else if (d100 == 100) {

			}
			ItemIhm.RewardDisplay(d100);
		}
	}
}
