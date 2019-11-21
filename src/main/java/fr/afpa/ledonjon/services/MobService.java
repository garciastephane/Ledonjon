package fr.afpa.ledonjon.services;

import fr.afpa.ledonjon.entites.Coordonate;
import fr.afpa.ledonjon.entites.Mob;
import fr.afpa.ledonjon.entites.Room;

public class MobService {
	public static Mob CreateMob(Coordonate map) {
		Room room = RoomServices.FindValidRoom(map);
		return new Mob(7 + UtilService.RamdomNumberGenerator(5), 2 + UtilService.RamdomNumberGenerator(2), UtilService.RamdomNumberGenerator(9), true, room );

	}

}
