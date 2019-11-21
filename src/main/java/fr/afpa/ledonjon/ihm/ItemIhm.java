package fr.afpa.ledonjon.ihm;

public class ItemIhm {
	public static void HealDisplay(int receavedHp) {
		System.out.println("you drink the sweet liquid and gain " + receavedHp + "HP !");
	}

	public static void GainStrengthDisplay() {
		System.out.println("you drink the bitter bavrage and feel stronger");
	}

	public static void LootGoldDisplay(int receavedGold) {
		if (receavedGold == 1) {
			System.out.println("you get one pityful coin");
		} else if (receavedGold > 1 && receavedGold < 5) {
			System.out.println("you get " + receavedGold + " delightful coins");
		} else {
			System.out.println("THE LOOT !!!! THE LOOT !!!! You get " + receavedGold + " shiny gold coins ");
		}
	}

	public static void RewardDisplay(int d100) {
		if (d100 > 55 && d100 <= 60) {
			System.out.println("Nothing happen....Ah!!..no nothing.");
		} else if (d100 > 60 && d100 <= 65) {
			System.out.println(
					"A spider jump out from the slot machine and bite your face, an enormous bubo appear on your cheek, you lose one HP and you're disfigured, you cry for a while.");
		} else if (d100 > 65 && d100 <= 65) {
			System.out.println("An ecorn come out... Nice!!");
		} else if (d100 > 70 && d100 <= 76) {
			System.out.println("An picture come out, you look at it, you blush and put it discreatly in your pocket.");
		} else if (d100 == 77) {
			System.out.println("JACKPOT!!!!  A thousen Gold coins come out , Life is woderful!!!");
		} else if (d100 > 78 && d100 <= 80) {
			System.out.println("Something come out, you have absolutly no idea what ,but is blue and sticky");
		} else if (d100 > 80 && d100 <= 85) {
			System.out.println(
					"Nothing come out but you can ear someone say 'help me' from the inside of the slotmachine");
		} else if (d100 > 85 && d100 <= 95) {
			System.out.println(
					"A little piece of paper come out ,write on it you can read 'I am warning thee, dont eat th' the rest of the paper is covert in ink.");
		} else if (d100 > 95 && d100 <= 97) {
			System.out.println(
					"A fairy come out and say 'Du hast mich gerettet' she sparkle and a ray of light hit you. a light glow appear around you and you feel better. you get 5 HP");
		} else if (d100 == 98) {
			System.out.println("YOU ARE STRICK BY A LIGHTNINGBOLT!!! It letf you with 1 HP!");
		} else if (d100 == 99) {
			System.out.println("THE MACHINE EXPLOSE AND KILL YOU !!!!");
		} else if (d100 == 100) {
			System.out.println(
					"BONK!!The shot machine Explose in firework and an another slot machine appear in is place...ok.");
		}
	}
}
