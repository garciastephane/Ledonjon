package fr.afpa.ledonjon.ihm;

import fr.afpa.ledonjon.entites.Coordonate;

public class CoordonateIhm {
	
	/**
	 * Methode qui permets l affichage de la map pleine
	 */

	public static void affichageMazePlein() {
		
		for (int i=0; i<Coordonate.getOrdonate();i++) {
			//barriere up
			for (int j=0; j<Coordonate.getAbsciss();j++) {
					System.out.print("+-----");
			}
			System.out.println("+   ");
			//barriere left
			for (int k=0;k<Coordonate.getAbsciss();k++) {
				
				System.out.print("|     ");
			
			}
			System.out.println("|");
		}
		for(int l=0;l<Coordonate.getAbsciss();l++) {
			System.out.print("+-----");
		}
		System.out.println("+");
	}
}
