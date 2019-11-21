package fr.afpa.ledonjon.controles;
import fr.afpa.ledonjon.entites.Character;
public class CharacterControl {
	
	/**
	 * Methode qui permets de savoir si un caractère est encore vivant
	 * @param character
	 * @return
	 */
	public static boolean isAlive(Character character) {
		return character.getHealthPoint() > 0;
	}

}
