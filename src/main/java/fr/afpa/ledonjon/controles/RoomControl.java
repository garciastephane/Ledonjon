package fr.afpa.ledonjon.controles;

import fr.afpa.ledonjon.entites.End;
import fr.afpa.ledonjon.entites.Room;
import fr.afpa.ledonjon.entites.Start;

public class RoomControl {

	public static boolean isValidRoom(Room room) {
		if (room instanceof Start || room instanceof End)
			return false;
		return true;
	}

}
