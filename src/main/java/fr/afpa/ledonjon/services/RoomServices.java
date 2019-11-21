package fr.afpa.ledonjon.services;

import fr.afpa.ledonjon.controles.RoomControl;
import fr.afpa.ledonjon.entites.Donjon;
import fr.afpa.ledonjon.entites.Room;

public class RoomServices {

	/**
	 * Methode qui permets de trouver une room valide
	 * @param map
	 * @return
	 */
	public static Room FindValidRoom(Donjon donjon) {
		Room room = null;
		do {
			room = donjon.getMaze()[UtilService.RamdomNumberGenerator(6)][UtilService
					.RamdomNumberGenerator(3)];
			if (!RoomControl.isValidRoom(room)) {
				room = null;
			}
		} while (room == null);
		return room;
	}
}
