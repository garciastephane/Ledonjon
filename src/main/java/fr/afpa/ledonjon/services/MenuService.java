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
	public static int Choix(char choix, Donjon donjon, int yPlayer, int xPlayer , Scanner sc) {
		Room roomS = null;
		int i = 0;
		int which = 0;
		switch (choix) {
		case 'L':
			PlayerIhm.LookAround(donjon.getMaze()[yPlayer][xPlayer]);
			break;
		case 'A':
			for (@SuppressWarnings("unused")
			Mob mob : donjon.getMaze()[yPlayer][xPlayer].getMobs()) {
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
			}while (which == 0 || which > donjon.getMaze()[yPlayer][xPlayer].getMobs().size());
			PlayerService.Attack(donjon.getMaze()[yPlayer][xPlayer].getDidier(), donjon.getMaze()[yPlayer][xPlayer].getMobs().get(which -1));
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
		case'W' :
			if (donjon.getMaze()[yPlayer][xPlayer].isNorth()) {
				roomS = DonjonService.findRoomAdj(donjon, yPlayer, xPlayer, choix);
				PlayerService.Move(donjon.getMaze()[yPlayer][xPlayer], roomS);
				return yPlayer - 1;
			}
			System.out.println("Ouch !! You just hit the wall.");
			return yPlayer;
		case 'S':
			if (donjon.getMaze()[yPlayer][xPlayer].isEst()) {
				roomS = DonjonService.findRoomAdj(donjon, yPlayer, xPlayer, choix);
				PlayerService.Move(donjon.getMaze()[yPlayer][xPlayer], roomS);
				return xPlayer + 1;
			}
			System.out.println("Ouch !! You just hit the wall.");
			return xPlayer;
		case 'E':
			if (donjon.getMaze()[yPlayer][xPlayer].isSouth()) {
				roomS = DonjonService.findRoomAdj(donjon, yPlayer, xPlayer, choix);
				PlayerService.Move(donjon.getMaze()[yPlayer][xPlayer], roomS);
				return yPlayer + 1;
			}
			System.out.println("Ouch !! You just hit the wall.");
			return yPlayer;
		case 'N':
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

	
//	for (int j = 0; j < donjon.getY(); j++) {
//	// draw the north edge
//	for (int i = 0; i < donjon.getX(); i++) {
//		System.out.print((donjon.getMaze()[i][j].getBit() & 1) == 0 ? "+-----" : "+     ");
//
//	}
//	System.out.println("+");
//	// draw the west edge
//	for (int i = 0; i < donjon.getX(); i++) {
	
//		if (j == 0 && i == 0) {
//			System.out.print("   ");
//			if (donjon.getMaze()[i][j].getDidier() != null) {
//				System.out.print("P");
//			} else {
//				System.out.print(" ");
//			}
//			System.out.print("  ");
//		}
//		// else
//		else {
//			if ((donjon.getMaze()[i][j].getBit() & 8) == 0) {
//				System.out.print("|");
//			} else {
//				System.out.print(" ");
//			}
//				if (donjon.getMaze()[i][j].getMobs().isEmpty()) {
//					System.out.print("  ");
//				} else {
//					System.out.print(donjon.getMaze()[i][j].getMobs().size() + "M");
//				}
//				if (donjon.getMaze()[i][j].getDidier() != null) {
//					System.out.print("P");
//				} else {
//					System.out.print(" ");
//				}
//				if (donjon.getMaze()[i][j].getItems().isEmpty()) {
//					System.out.print("  ");
//				} else {
//					System.out.print(donjon.getMaze()[i][j].getItems().size() + "O");
//				}
//		}
//	}
//	if (j == donjon.getY() - 1) {
//		System.out.println(" ");
//	} else
//		System.out.println("|");
//}
//// draw the bottom line
//for (int j = 0; j < donjon.getX(); j++) {
//	System.out.print("+-----");
//}
//System.out.println("+");
}
