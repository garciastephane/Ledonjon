package fr.afpa.ledonjon.controles;

import fr.afpa.ledonjon.entites.End;
import fr.afpa.ledonjon.entites.Item;
import fr.afpa.ledonjon.entites.Mob;
import fr.afpa.ledonjon.entites.Room;
import fr.afpa.ledonjon.entites.Start;

public class RoomControl {

	/**
	 * Methode qui permets de valider si c est une salle
	 * 
	 * @param room
	 * @return
	 */

	public static boolean isValidRoom(Room room) {
		if (room instanceof Start || room instanceof End)
			return false;
		return true;
	}
	
	/**
	 * Methode qui permets de compter le nombre de mobs vivants dans une salle
	 * @param room
	 * @return
	 */

	public static int numbAliveMob(Room room) {
		int count = 0;
		for (Mob mob : room.getMobs()) {
			if (mob.isAlive()) {
				count++;
			}
		}

		return count;
	}
	
	/**
	 * Methode qui permets de compter le nombre de items presents dans une salle
	 * @param room
	 * @return
	 */
	public static int numbItem(Room room) {
		int count = 0;
		for (@SuppressWarnings("unused") Item item : room.getItems()) {
				count++;
		}

		return count;
	}
}
