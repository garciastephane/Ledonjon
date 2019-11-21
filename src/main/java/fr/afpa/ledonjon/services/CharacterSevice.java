package fr.afpa.ledonjon.services;

import fr.afpa.ledonjon.entites.Character;

public class CharacterSevice {
	
	/**
	 * Methode qui inflige une perte de points de vie a un personnaje
	 * @param defender
	 * @param damages
	 * @return
	 */
	public static boolean LoseHealth(Character defender, int damages) {
		defender.setHealthPoint(defender.getHealthPoint() - damages);	
		if(defender.isAlive()) return true;
		return false;
	}
}

