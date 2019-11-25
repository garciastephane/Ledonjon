package fr.afpa.ledonjon.services;

import fr.afpa.ledonjon.entites.Donjon;
import fr.afpa.ledonjon.entites.GoldPouch;
import fr.afpa.ledonjon.entites.HealthPotion;
import fr.afpa.ledonjon.entites.Item;
import fr.afpa.ledonjon.entites.Mob;
import fr.afpa.ledonjon.entites.Room;
import fr.afpa.ledonjon.entites.SlotMachine;
import fr.afpa.ledonjon.entites.StrengthPotion;
import fr.afpa.ledonjon.ihm.PlayerIhm;

public class MenuService {
	public static int Choix(char choix, Donjon donjon, int yPlayer, int xPlayer) {
		Room roomS = null;
		int i = 0;
		switch (choix) {
		case 'L':
			PlayerIhm.LookAround(donjon.getMaze()[yPlayer][xPlayer]);
			break;
		case 'A':
			for (@SuppressWarnings("unused")
			Mob mob : donjon.getMaze()[yPlayer][xPlayer].getMobs()) {
				System.out.println(++i + ") Monster");
			}
			break;
		case 'U':
			for (Item item : donjon.getMaze()[yPlayer][xPlayer].getItems()) {
				if (item instanceof HealthPotion) {
					System.out.println(++i + ") Health Potion");
				} else if (item instanceof StrengthPotion) {
					System.out.println(++i + ") Strength Potion");
				} else if (item instanceof GoldPouch) {
					System.out.println(++i + ") Gold Pouch");
				} else if (item instanceof SlotMachine) {
					System.out.println(++i + ") Slot Machine");
				}
			}
			break;
		case 'N':
			if (donjon.getMaze()[yPlayer][xPlayer].isNorth()) {
				roomS = DonjonService.findRoomAdj(donjon, yPlayer, xPlayer, choix);
				PlayerService.Move(donjon.getMaze()[yPlayer][xPlayer], roomS);
				return yPlayer - 1;
			}
			System.out.println("Ouch !! You just hit the wall.");
			return yPlayer;
		case 'E':
			if (donjon.getMaze()[yPlayer][xPlayer].isEst()) {
				roomS = DonjonService.findRoomAdj(donjon, yPlayer, xPlayer, choix);
				PlayerService.Move(donjon.getMaze()[yPlayer][xPlayer], roomS);
				return xPlayer + 1;
			}
			System.out.println("Ouch !! You just hit the wall.");
			return xPlayer;
		case 'S':
			if (donjon.getMaze()[yPlayer][xPlayer].isSouth()) {
				roomS = DonjonService.findRoomAdj(donjon, yPlayer, xPlayer, choix);
				PlayerService.Move(donjon.getMaze()[yPlayer][xPlayer], roomS);
				return yPlayer + 1;
			}
			System.out.println("Ouch !! You just hit the wall.");
			return yPlayer;
		case 'W':
			if (donjon.getMaze()[yPlayer][xPlayer].isWest()) {
				roomS = DonjonService.findRoomAdj(donjon, yPlayer, xPlayer, choix);
				PlayerService.Move(donjon.getMaze()[yPlayer][xPlayer], roomS);
				return xPlayer -1;
			}
			System.out.println("Ouch !! You just hit the wall.");
			return xPlayer;
		default:
			break;
		}
		return 0;
	}

}
