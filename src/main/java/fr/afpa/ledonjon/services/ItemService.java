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
			if (d100 > 60 && d100 <= 65) {
				CharacterSevice.LoseHealth(didier, 1);
			} else if (d100 == 77) {
				PlayerService.WinGold(didier, 1000);
			} else if (d100 > 95 && d100 <= 97) {
				PlayerService.GainHp(didier, 5);
			} else if (d100 == 98) {
				CharacterSevice.LoseHealth(didier, didier.getHealthPoint()-1);
			} else if (d100 == 99) {
				CharacterSevice.LoseHealth(didier, didier.getHealthPoint());
			} else if (d100 == 100) {
				//useItem(new SlotMachine());
			}
			ItemIhm.RewardDisplay(d100);
		}
	}
}
