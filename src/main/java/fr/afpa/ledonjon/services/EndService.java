
package fr.afpa.ledonjon.services;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import fr.afpa.ledonjon.entites.Player;

public class EndService {
//	public static void main(String[] args) {
//		Player didier = new Player(0, 10, 10, true);
//		ecritureScore(didier);
//	}

	/**
	 * Methode qui permets de sauvergarder le score du joueur
	 * 
	 * @param didier
	 */
	public static void ecritureScore(Player didier) {
		try {
			Files.write(Paths.get("C:\\ENV\\Workspace\\Donjon\\SauvegardeScore.txt"),
					("nouveau score : "+ didier.getName() +" " + didier.getGold() + " gold ! Le"
							+ LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "\n").getBytes(),
					StandardOpenOption.APPEND);
		} catch (Exception e) {
			System.out.println("Erreur " + e);
		}
	}

	/**
	 * Methode qui permets de montrer les dix grands scores du jeu
	 * 
	 * @param didier
	 * @return
	 */
	public static ArrayList showHigh(Player didier) {
		ArrayList<Integer> meilleursScore = new ArrayList<Integer>(10);
		int pluspetit = 0;
		meilleursScore.add(new Integer(didier.getGold()));
		return meilleursScore;
	}
}
