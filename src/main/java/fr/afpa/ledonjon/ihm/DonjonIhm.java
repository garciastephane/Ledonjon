package fr.afpa.ledonjon.ihm;

import fr.afpa.ledonjon.entites.Donjon;

public class DonjonIhm {

	/**
	 * Methode qui permets de afficher le donjon
	 * 
	 * @param donjon
	 */

	public static void DisplayDonjon(Donjon donjon) {
		for (int i = 0; i < donjon.getY(); i++) {
			// draw the north edge
			for (int j = 0; j < donjon.getX(); j++) {
				System.out.print((donjon.getMaze()[j][i].getBit() & 1) == 0 ? "+-----" : "+     ");
				
			}
			System.out.println("+");
			// draw the west edge
			for (int j = 0; j < donjon.getX(); j++) {
				if (j==0 && i ==0) {
					System.out.print("      ");
				}
				//else 
				else System.out.print((donjon.getMaze()[j][i].getBit() & 8) == 0 ? "|     " : "      ");
			}
			if (i == donjon.getY() - 1) {
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
}
