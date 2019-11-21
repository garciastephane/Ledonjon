package fr.afpa.ledonjon.services;

import fr.afpa.ledonjon.controles.RoomControl;
import fr.afpa.ledonjon.entites.Coordonate;
import fr.afpa.ledonjon.entites.Room;

public class RoomServices {

	public static Room FindValidRoom(Coordonate map) {
		Room room = null;
		do {
			room = map.getCoordonate()[UtilService.RamdomNumberGenerator(6)][UtilService
					.RamdomNumberGenerator(3)];
			if (!RoomControl.isValidRoom(room)) {
				room = null;
			}
		} while (room == null);
		return room;
	}
}
