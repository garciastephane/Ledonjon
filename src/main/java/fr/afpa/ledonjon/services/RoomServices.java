package fr.afpa.ledonjon.services;

import fr.afpa.ledonjon.controles.RoomControl;
import fr.afpa.ledonjon.entites.Donjon;
import fr.afpa.ledonjon.entites.Room;

public class RoomServices {

	/**
	 * Methode qui permets de trouver une room valide
	 * @param tailleY 
	 * @param tailleX 
	 * @param map
	 * @return
	 */
	public static Room FindValidRoom(Donjon donjon,int tailleX,int tailleY) {
		Room room = null;
		do {
			room = donjon.getMaze()[UtilService.RamdomNumberGenerator(tailleX)][UtilService
					.RamdomNumberGenerator(tailleY)];
			if (!RoomControl.isValidRoom(room)) {
				room = null;
			}
		} while (room == null);
		return room;
	}
}
