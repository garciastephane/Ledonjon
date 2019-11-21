package fr.afpa.ledonjon.services;

import fr.afpa.ledonjon.entites.Character;

public class CharacterSevice {
	public static boolean LoseHealth(Character defender, int damages) {
		defender.setHealthPoint(defender.getHealthPoint() - damages);	
		if(defender.isAlive()) return true;
		return false;
	}
}

