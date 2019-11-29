package fr.afpa.ledonjon.ihm;

import java.util.ArrayList;
import java.util.Scanner;

import fr.afpa.ledonjon.controles.RoomControl;
import fr.afpa.ledonjon.entites.Donjon;
import fr.afpa.ledonjon.entites.HighScore;
import fr.afpa.ledonjon.services.DonjonService;

public class DonjonIhm {

	public static Donjon ConfigDonjon(String name, Scanner sc) {
		String choixDiff = null;
		int tailleX = 8;
		int tailleY = 8;
		Donjon donjon = null;
		do {
			MenuIhm.MenuInit();
			choixDiff = sc.nextLine();
			switch (choixDiff) {
			case "1":
				donjon = new Donjon(tailleX, tailleY);
				DonjonService.DonjonContainGenerator(donjon, tailleX, tailleY, "2", name);
				break;
			case "2":
				System.out.println("Choose the weight");
				try {
					tailleY = sc.nextInt();
					sc.nextLine();
				} catch (Exception e) {
					sc.nextLine();
					System.out.println("invalid");
				}
				System.out.println("Choose the height");
				try {
					tailleX = sc.nextInt();
					sc.nextLine();
				} catch (Exception e) {
					sc.nextLine();
					System.out.println("invalid");
				}
				donjon = new Donjon(tailleX, tailleY);
				do {

					MenuIhm.MenuDifficulte();
					choixDiff = sc.nextLine();
					switch (choixDiff) {
					case "1":
						DonjonService.DonjonContainGenerator(donjon, tailleX, tailleY, "1", name);
						break;
					case "2":
						DonjonService.DonjonContainGenerator(donjon, tailleX, tailleY, "2", name);
						break;
					case "3":
						DonjonService.DonjonContainGenerator(donjon, tailleX, tailleY, "3", name);
						break;
					default:
						choixDiff = null;
						break;
					}
				} while (choixDiff == null);
				break;
			default:
				choixDiff = null;
				break;
			}
		} while (choixDiff == null);
		return donjon;
	}

	/**
	 * Methode qui permets de afficher le donjon
	 * 
	 * @param donjon
	 */

	public static void DisplayDonjon(Donjon donjon) {
		for (int j = 0; j < donjon.getX(); j++) {
			// draw the north edge
			for (int i = 0; i < donjon.getY(); i++) {
				System.out.print((donjon.getMaze()[j][i].getBit() & 8) == 0 ? "+-----" : "+     ");

			}
			System.out.println("+");
			// draw the west edge
			for (int i = 0; i < donjon.getY(); i++) {
				if (j == 0 && i == 0) {
					System.out.print("      ");
				}
				// else
				else
					System.out.print((donjon.getMaze()[j][i].getBit() & 1) == 0 ? "|     " : "      ");
			}
			if (j == donjon.getX() - 1) {
				System.out.println(" ");
			} else
				System.out.println("|");
		}
		// draw the bottom line
		for (int j = 0; j < donjon.getY(); j++) {
			System.out.print("+-----");
		}
		System.out.println("+");
	}

	/**
	 * Methode qui permets d'afficher le donjon complet(avec joueur/monstres/items)
	 * 
	 * @param donjon
	 */

	public static void DisplayFullDonjon(Donjon donjon) {
		for (int j = 0; j < donjon.getX(); j++) {
			// draw the north edge
			for (int i = 0; i < donjon.getY(); i++) {
				System.out.print((donjon.getMaze()[j][i].getBit() & 8) == 0 ? "+-----" : "+     ");
			}
			System.out.println("+");
			// draw the west edge
			for (int i = 0; i < donjon.getY(); i++) {
				if (j == 0 && i == 0) {
					System.out.print("   ");
					if (donjon.getMaze()[j][i].getDidier() != null) {
						System.out.print("P");
					} else {
						System.out.print(" ");
					}
					System.out.print("  ");
				}
				// else
				else {
					if ((donjon.getMaze()[j][i].getBit() & 1) == 0) {
						System.out.print("|");
					} else {
						System.out.print(" ");
					}
					if (RoomControl.numbAliveMob(donjon.getMaze()[j][i]) == 0) {
						System.out.print("  ");
					} else {
						System.out.print(RoomControl.numbAliveMob(donjon.getMaze()[j][i]) + "M");
					}
					if (donjon.getMaze()[j][i].getDidier() != null) {
						System.out.print("P");
					} else {
						System.out.print(" ");
					}
					if (donjon.getMaze()[j][i].getItems().isEmpty()) {
						System.out.print("  ");
					} else {
						System.out.print(donjon.getMaze()[j][i].getItems().size() + "O");
					}
				}
			}
			if (j == donjon.getX() - 1) {
				System.out.println(" ");
			} else
				System.out.println("|");
		}
		// draw the bottom line
		for (int j = 0; j < donjon.getY(); j++) {
			System.out.print("+-----");
		}
		System.out.println("+");
	}

	public static void DisplayLADonjon(Donjon donjon) {

		for (int j = 0; j < donjon.getX(); j++) {
			// draw the north edge
			for (int i = 0; i < donjon.getY(); i++) {
				System.out.print((donjon.getMaze()[j][i].getBit() & 8) == 0 ? "+-----" : "+     ");
			}
			System.out.println("+");
			// draw the west edge
			for (int i = 0; i < donjon.getY(); i++) {
				if (j == 0 && i == 0) {
					System.out.print("   ");
					if (donjon.getMaze()[j][i].getDidier() != null) {
						System.out.print("P");
					} else {
						System.out.print(" ");
					}
					System.out.print("  ");
				}
				// else
				else {
					if ((donjon.getMaze()[j][i].getBit() & 1) == 0) {
						System.out.print("|");
					} else {
						System.out.print(" ");
					}
					System.out.print("  ");
					if (donjon.getMaze()[j][i].getDidier() != null) {
						System.out.print("P");
					} else {
						System.out.print(" ");
					}
					System.out.print("  ");
				}
			}
			if (j == donjon.getX() - 1) {
				System.out.println(" ");
			} else
				System.out.println("|");
		}
		// draw the bottom line
		for (int j = 0; j < donjon.getY(); j++) {
			System.out.print("+-----");
		}
		System.out.println("+");

	}

	/**
	 * Methode qui permets d afficher le joueur dans le donjon
	 * 
	 * @param donjon
	 */

	public static void DisplayPlayerInDonjon(Donjon donjon) {
		for (int j = 0; j < donjon.getX(); j++) {
			// draw the north edge
			for (int i = 0; i < donjon.getY(); i++) {
				System.out.print((donjon.getMaze()[j][i].getBit() & 8) == 0 ? "+-----" : "+     ");
			}
			System.out.println("+");
			// draw the west edge
			for (int i = 0; i < donjon.getY(); i++) {
				if (j == 0 && i == 0) {
					System.out.print("   ");
					if (donjon.getMaze()[j][i].getDidier() != null) {
						System.out.print("P");
					} else {
						System.out.print(" ");
					}
					System.out.print("  ");
				}
				// else
				else {
					if ((donjon.getMaze()[j][i].getBit() & 1) == 0) {
						System.out.print("|");
					} else {
						System.out.print(" ");
					}
					System.out.print("  ");
					if (donjon.getMaze()[j][i].getDidier() != null) {
						System.out.print("P");
					} else {
						System.out.print(" ");
					}
					System.out.print("  ");
				}
			}
			if (j == donjon.getX() - 1) {
				System.out.println(" ");
			} else
				System.out.println("|");
		}
		// draw the bottom line
		for (int j = 0; j < donjon.getY(); j++) {
			System.out.print("+-----");
		}
		System.out.println("+");
	}

	/**
	 * Methode qui permets de montrer les dix grands scores du jeu
	 * 
	 * @param didier
	 * @return
	 */
	public static void ShowHigh(ArrayList<HighScore> highScores) {
		System.out.println("High Score");
		for (int i = 0; i < highScores.size() && i < 10; i++) {
			System.out.println(highScores.get(i).getNamePlayer() + "\t" + highScores.get(i).getScore());
		}

	}

}
