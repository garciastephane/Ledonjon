package fr.afpa.ledonjon.ihm;

public class ItemIhm {
	public static void HealDisplay(int receavedHp) {
		System.out.println("you drink the sweet liquid and gain "+receavedHp+"HP !");
	}

	public static void GainStrengthDisplay() {
		System.out.println("you drink the bitter bavrage and feel stronger");
	}

	public static void LootGoldDisplay(int receavedGold) {
		if (receavedGold == 1) {
			System.out.println("you get one pityful coin");
		}else if(receavedGold > 1 && receavedGold < 5){
			System.out.println("you get "+receavedGold+" delightful coins");
		}else{
			System.out.println("THE LOOT !!!! THE LOOT !!!! You get "+receavedGold+" shiny gold coins ");
		}
	}
	
}
