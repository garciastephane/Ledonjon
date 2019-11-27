package fr.afpa.ledonjon.controles;

public class PlayerControl {

	/**
	 * Methode qui permets de valider le nom du joueur
	 * 
	 * @param name
	 * @return
	 */

	public static boolean validNamePlayer(String name) {
		if (name != null && name.matches("[a-zA-Z]{1,12}"))
			return true;

		return false;
	}
}
