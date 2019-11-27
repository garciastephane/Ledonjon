package fr.afpa.ledonjon.ihm;

import fr.afpa.ledonjon.controles.RoomControl;
import fr.afpa.ledonjon.entites.Donjon;

public class DonjonIhm {

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

	/**
	 * Methode qui permets d'afficher le donjon complet
	 * @param donjon
	 */
	public static void DisplayFullDonjonV(Donjon donjon) {
		for (int j = 0; j < donjon.getY(); j++) {
			// draw the north edge
			for (int i = 0; i < donjon.getX(); i++) {
				System.out.print((donjon.getMaze()[i][j].getBit() & 1) == 0 ? "+-----" : "+     ");

			}
			System.out.println("+");
			// draw the west edge
			for (int i = 0; i < donjon.getX(); i++) {
				if (j == 0 && i == 0) {
					System.out.print("   ");
					if (donjon.getMaze()[i][j].getDidier() != null) {
						System.out.print("P");
					} else {
						System.out.print(" ");
					}
					System.out.print("  ");
				}
				// else
				else {
					if ((donjon.getMaze()[i][j].getBit() & 8) == 0) {
						System.out.print("|");
					} else {
						System.out.print(" ");
					}
					if (RoomControl.numbAliveMob(donjon.getMaze()[i][j]) == 0) {
						System.out.print("  ");
					} else {
						System.out.print(RoomControl.numbAliveMob(donjon.getMaze()[i][j]) + "M");
					}
					if (donjon.getMaze()[i][j].getDidier() != null) {
						System.out.print("P");
					} else {
						System.out.print(" ");
					}
					if (donjon.getMaze()[i][j].getItems().isEmpty()) {
						System.out.print("  ");
					} else {
						System.out.print(donjon.getMaze()[i][j].getItems().size() + "O");
					}
				}
			}
			if (j == donjon.getY() - 1) {
				System.out.println(" ");
			} else
				System.out.println("|");
		}
		// draw the bottom line
		for (int j = 0; j < donjon.getX(); j++) {
			System.out.print("+-----");
		}
		System.out.println("+");

	}
	
	/**
	 * Methode qui permets d afficher le joueur dans le donjon
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

}
