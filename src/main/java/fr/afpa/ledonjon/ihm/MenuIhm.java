package fr.afpa.ledonjon.ihm;

import java.util.Scanner;

import fr.afpa.ledonjon.controles.CharacterControl;
import fr.afpa.ledonjon.controles.RoomControl;
import fr.afpa.ledonjon.entites.Donjon;
import fr.afpa.ledonjon.entites.End;
import fr.afpa.ledonjon.entites.GoldPouch;
import fr.afpa.ledonjon.entites.HealthPotion;
import fr.afpa.ledonjon.entites.Item;
import fr.afpa.ledonjon.entites.Mob;
import fr.afpa.ledonjon.entites.Room;
import fr.afpa.ledonjon.entites.SlotMachine;
import fr.afpa.ledonjon.entites.StrengthPotion;
import fr.afpa.ledonjon.services.DonjonService;
import fr.afpa.ledonjon.services.PlayerService;

public class MenuIhm {

	
	
	/**
	 * Methode qui permets d afficher le menu initial au joueur
	 */

	public static void DisplayPlayerMenu(Room room) {
		System.out.println("*************MENU*************");

		System.out.println("\n What do you want to do?\n");
		System.out.println("Lock around");

		if (RoomControl.numbAliveMob(room) > 0) {
			System.out.println("Attack");
		} else {
			if (RoomControl.numbItem(room) > 0) {
				System.out.println("Use Item");
			}
			if (room.isNorth())
				System.out.println("Move North");
			if (room.isEst())
				System.out.println("Move Est");
			if (room.isSouth())
				System.out.println("Move South");
			if (room.isWest())
				System.out.println("Move West");
			if (room instanceof End)
				System.out.println("Finish");

		}
	}
	
	public static void MenuInit() {
		System.out.println("1-Quick PLay");
		System.out.println("2-Choose difficulty");
		}
	
	public static void MenuDifficulte() {
		System.out.println("1-Easy Mode");
		System.out.println("2-Medium Mode");
		System.out.println("3-Hard Mode");
	}
		
	

	public static int Choix(char choix, Donjon donjon, int xPlayer, int yPlayer, Scanner sc) {
		Room roomS = null;
		int i = 0;
		int which = 0;
		switch (choix) {
		case 'L':
			PlayerIhm.LookAround(donjon, donjon.getMaze()[xPlayer][yPlayer]);
			break;
		case 'A':
			if (RoomControl.numbAliveMob(donjon.getMaze()[xPlayer][yPlayer]) == 0) {
				System.out.println("There is no monster to attack");
				break;
			}
			for (Mob mob : donjon.getMaze()[xPlayer][yPlayer].getMobs()) {
				if (mob.isAlive()) {
					System.out.println(++i + ") Monster");
				} else {
					++i;
				}
			}
			do {
				System.out.println("Which Monster will you attack ?");
				try {
					which = sc.nextInt();
					sc.nextLine();
				} catch (Exception e) {
					sc.nextLine();
					System.out.println("invalide");
				}
			} while (which == 0 || which > donjon.getMaze()[xPlayer][yPlayer].getMobs().size());
			if(donjon.getMaze()[xPlayer][yPlayer].getMobs().get(which - 1).isAlive()) {
				PlayerService.Attack(donjon.getMaze()[xPlayer][yPlayer].getDidier(),
					donjon.getMaze()[xPlayer][yPlayer].getMobs().get(which - 1));
			}else {
				System.out.println("Stop it, he aready dead");
			}
			
			if (!CharacterControl.isAlive(donjon.getMaze()[xPlayer][yPlayer].getDidier()))
				return -1;
			break;
		case 'U':
			if (RoomControl.numbAliveMob(donjon.getMaze()[xPlayer][yPlayer]) > 0) {
				System.out.println("There is a monster to here");
				break;
			}
			if (RoomControl.numbItem(donjon.getMaze()[xPlayer][yPlayer]) == 0) {
				System.out.println("There is no item here");
				break;
			}
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
			do {
				System.out.println("Which item will you use ?");
				try {
					which = sc.nextInt();
					sc.nextLine();
				} catch (Exception e) {
					sc.nextLine();
					System.out.println("invalide");
				}
			} while (which == 0 || which > donjon.getMaze()[xPlayer][yPlayer].getItems().size());
			PlayerService.UseItem(donjon.getMaze()[xPlayer][yPlayer].getDidier(), donjon.getMaze()[xPlayer][yPlayer],
					donjon.getMaze()[xPlayer][yPlayer].getItems().get(which - 1));
			if (!CharacterControl.isAlive(donjon.getMaze()[xPlayer][yPlayer].getDidier()))
				return -1;
			break;
		case 'N':
			if (RoomControl.numbAliveMob(donjon.getMaze()[xPlayer][yPlayer]) > 0) {
				System.out.println("There is a monster to here");
				return xPlayer;
			}
			if (donjon.getMaze()[xPlayer][yPlayer].isNorth()) {
				roomS = DonjonService.findRoomAdj(donjon, xPlayer, yPlayer, choix);
				PlayerService.Move(donjon.getMaze()[xPlayer][yPlayer], roomS);
				return xPlayer - 1;
			}
			System.out.println("Ouch !! You just hit the wall.");
			return xPlayer;
		case 'E':
			if (RoomControl.numbAliveMob(donjon.getMaze()[xPlayer][yPlayer]) > 0) {
				System.out.println("There is a monster to here");
				return yPlayer;
			}
			if (donjon.getMaze()[xPlayer][yPlayer].isEst()) {
				roomS = DonjonService.findRoomAdj(donjon, xPlayer, yPlayer, choix);
				PlayerService.Move(donjon.getMaze()[xPlayer][yPlayer], roomS);
				return yPlayer + 1;
			}
			System.out.println("Ouch !! You just hit the wall.");
			return yPlayer;
		case 'S':
			if (RoomControl.numbAliveMob(donjon.getMaze()[xPlayer][yPlayer]) > 0) {
				System.out.println("There is a monster to here");
				return xPlayer;
			}
			if (donjon.getMaze()[xPlayer][yPlayer].isSouth()) {
				roomS = DonjonService.findRoomAdj(donjon, xPlayer, yPlayer, choix);
				PlayerService.Move(donjon.getMaze()[xPlayer][yPlayer], roomS);
				return xPlayer + 1;
			}
			System.out.println("Ouch !! You just hit the wall.");
			return xPlayer;
		case 'W':
			if (RoomControl.numbAliveMob(donjon.getMaze()[xPlayer][yPlayer]) > 0) {
				System.out.println("There is a monster to here");
				return yPlayer;
			}
			if (donjon.getMaze()[xPlayer][yPlayer].isWest()) {
				roomS = DonjonService.findRoomAdj(donjon, xPlayer, yPlayer, choix);
				PlayerService.Move(donjon.getMaze()[xPlayer][yPlayer], roomS);
				return yPlayer - 1;
			}
			System.out.println("Ouch !! You just hit the wall.");
			return yPlayer;
		case 'F':
			if (donjon.getMaze()[xPlayer][yPlayer] instanceof End)
				return -1;
			break;
		default:
			break;
		}
		return 0;
	}
	
	/**
	 * Methode qui affiche le nom du jeu
	 */

	public static void DisplayTitle() {
		System.out.println("" + "THE SACRED LAIR OF THE ANCIENT ELDER MAGIC SORCEROR DRAGON LORD OF THE ULTIMATE \r\n"
				+ "         STRONGHOLD OF THE NORTHERN LAND OF THE INFINITE SOUTHERN COST,\r\n"
				+ "LOYAL VASAL OF THE MAGNIFICENT ROYAL EMPEROR OF THE EIGHTEEN CONQUERED KINGDOMS \r\n"
				+ " AND THE HIGH CASTLE OF THE GREATEST EMPIRE THE FORBIDEN PLANETE OF THE HIGHER \r\n"
				+ "           DEVILISH GALAXIE OF THE BRIGTEST RISING LOST LAST STAR,\r\n"
				+ "             POWERFUL GUARDIAN OF THE GREAT AND STRONG DONJON OF \r\n"
				+ "             THE MISTIC HEROIC SECRET LEGEND OF THE FINAL QUEST \r\n\n");
	}

	

}
