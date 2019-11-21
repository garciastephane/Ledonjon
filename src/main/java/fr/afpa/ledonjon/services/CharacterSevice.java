package fr.afpa.ledonjon.services;

import fr.afpa.ledonjon.entites.Character;

public class CharacterSevice {
	public static void LoseHealth(Character defender, int damages) {
		defender.setHealthPoint(defender.getHealthPoint() - damages);	
	}

}
