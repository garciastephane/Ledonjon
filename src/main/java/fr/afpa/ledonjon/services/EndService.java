package fr.afpa.ledonjon.services;

import java.awt.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

import fr.afpa.ledonjon.entites.Player;

public class EndService {
	public static void main (String[] args) {
		Player didier = new Player(0, 10, 10, true);
		ecritureScore(didier);
	}

	public static void ecritureScore(Player didier) {
		try{
			Files.write(Paths.get("C:\\ENV\\Workspace\\ledonjon\\SauvegardeScore.txt"), ("nouveau score : "+didier.getGold()+" "+LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+"\n").getBytes(), StandardOpenOption.APPEND);}
		catch (Exception e){ System.out.println("Erreur "+e);}
	}
	public static ArrayList showHigh(Player didier) {
		ArrayList<Integer> meilleursScore = new ArrayList<Integer>(10);
		int pluspetit=0;
		meilleursScore.add(new Integer(didier.getGold()));
		return meilleursScore;
	
	
}
}

