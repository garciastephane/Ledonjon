package fr.afpa.ledonjon.ihm;

import fr.afpa.ledonjon.entites.Donjon;
import fr.afpa.ledonjon.entites.GoldPouch;
import fr.afpa.ledonjon.entites.HealthPotion;
import fr.afpa.ledonjon.entites.Item;
import fr.afpa.ledonjon.entites.Mob;
import fr.afpa.ledonjon.entites.SlotMachine;
import fr.afpa.ledonjon.entites.StrengthPotion;

public class PlayerIhm {
	public void LookAround(Donjon donjon) {
		System.out.println("Player\n   HP       : " + donjon.getDidier().getHealthPoint() + "\n   Strength : "
				+ donjon.getDidier().getStrength() + "\n   Gold     : " + donjon.getDidier().getGold());
		int killcount = 0;
		for (Mob mob : donjon.getMobs()) {
			if (mob.getRoom().equals(donjon.getDidier().getRoom())) {
				if (mob.isAlive()) {
					System.out.println("Monster\n   HP       : " + mob.getHealthPoint());
				}else {
					killcount++;
				}
			}
		}
		if (killcount > 0) {
			if (killcount == 1) {
				System.out.println("There is a dead monster on the floor and the walls");
			}else {
				System.out.println("There is "+killcount+" dead monsters on the floor and the walls");
			}
		}
		int Hp = 0;
		int Sp = 0;
		int Gp = 0;
		int Sm = 0;
		for (Item item : donjon.getDidier().getRoom().getItems()) {
			if (item instanceof HealthPotion) {
				Hp++;
			}else if (item instanceof StrengthPotion) {
				Sp++;
			}else if (item instanceof GoldPouch) {
				Gp++;
			}else if (item instanceof SlotMachine) {
				Sm++;
			}
		}
		if (Hp > 0) {
			if (Hp == 1) {
				System.out.println("There is a health potion on a table");
			}else {
				System.out.println("There is "+Hp+" health potions on a table");
			}
		}
		if (Sp > 0) {
			if (Sp == 1) {
				System.out.println("There is a strength potion on a table");
			}else {
				System.out.println("There is "+Sp+" strength potions on a table");
			}
		}
		if (Gp > 0) {
			if (Gp == 1) {
				System.out.println("There is a Gold pouch on a table");
			}else {
				System.out.println("There is "+Gp+" Gold pouches on a table");
			}
		}
		if (Sm > 0) {
			if (Sm == 1) {
				System.out.println("There is a shiny slot machine on a table");
			}else {
				System.out.println("There is "+Sm+" shiny slot machines on a table");
			}
		}
	}
}
