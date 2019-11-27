package fr.afpa.ledonjon.services;

import java.util.Scanner;

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
	public static int Choix(char choix, Donjon donjon, int xPlayer, int yPlayer , Scanner sc) {
		Room roomS = null;
		int i = 0;
		int which = 0;
		switch (choix) {
		case 'L':
			PlayerIhm.LookAround(donjon.getMaze()[xPlayer][yPlayer]);
			break;
		case 'A':
			for (@SuppressWarnings("unused")
			Mob mob : donjon.getMaze()[xPlayer][yPlayer].getMobs()) {
				System.out.println(++i + ") Monster");
			}
			do {
				System.out.println("Which Monster will you attack ?");
				try {
					which = sc.nextInt();
					sc.nextLine();
				} catch (Exception e) {
					System.out.println("invalide");
				}
			}while (which == 0 || which > donjon.getMaze()[xPlayer][yPlayer].getMobs().size());
			PlayerService.Attack(donjon.getMaze()[xPlayer][yPlayer].getDidier(), donjon.getMaze()[yPlayer][xPlayer].getMobs().get(which -1));
			break;
		case 'U':
			for (Item item : donjon.getMaze()[xPlayer][yPlayer].getItems()) {
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
		case'N' :
			if (donjon.getMaze()[xPlayer][yPlayer].isNorth()) {
				roomS = DonjonService.findRoomAdj(donjon, xPlayer, yPlayer, choix);
				PlayerService.Move(donjon.getMaze()[xPlayer][yPlayer], roomS);
				return xPlayer - 1;
			}
			System.out.println("Ouch !! You just hit the wall.");
			return xPlayer;
		case 'E':
			if (donjon.getMaze()[xPlayer][yPlayer].isEst()) {
				roomS = DonjonService.findRoomAdj(donjon, xPlayer, yPlayer, choix);
				PlayerService.Move(donjon.getMaze()[xPlayer][yPlayer], roomS);
				return yPlayer + 1;
			}
			System.out.println("Ouch !! You just hit the wall.");
			return yPlayer;
		case 'S':
			if (donjon.getMaze()[xPlayer][yPlayer].isSouth()) {
				roomS = DonjonService.findRoomAdj(donjon, xPlayer, yPlayer, choix);
				PlayerService.Move(donjon.getMaze()[xPlayer][yPlayer], roomS);
				return xPlayer + 1;
			}
			System.out.println("Ouch !! You just hit the wall.");
			return xPlayer;
		case 'W':
			if (donjon.getMaze()[xPlayer][yPlayer].isWest()) {
				roomS = DonjonService.findRoomAdj(donjon, xPlayer, yPlayer, choix);
				PlayerService.Move(donjon.getMaze()[xPlayer][yPlayer], roomS);
				return yPlayer -1;
			}
			System.out.println("Ouch !! You just hit the wall.");
			return yPlayer;
		default:
			break;
		}
		return 0;
	}

}
