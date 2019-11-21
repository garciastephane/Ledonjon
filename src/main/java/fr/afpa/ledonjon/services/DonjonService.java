package fr.afpa.ledonjon.services;

import fr.afpa.ledonjon.entites.Coordonate;
import fr.afpa.ledonjon.entites.Donjon;
import fr.afpa.ledonjon.entites.Room;

public class DonjonService {

	public static boolean generateMob(Donjon donjon) {

		int numMob = UtilService.RamdomNumberGenerator(7) + 1;

		for (int i = 0; i < numMob; i++) {

			donjon.getMobs().add(MobService.CreateMob(donjon.getMap()));
		}
		return true;
	}

	public static void generateItem(Coordonate map) {
		int numItem = UtilService.RamdomNumberGenerator(7) + 1;

		for (int i = 0; i < numItem; i++) {
			int typeItem = UtilService.RamdomNumberGenerator(4);
			Room room = RoomServices.FindValidRoom(map);
			switch (typeItem) {
			case 0:
				ItemService.CreateHealthPotion(room);
				break;
			case 1:
				ItemService.CreateStrengthPotion(room);
				break;
			case 2:
				ItemService.CreateGoldPouch(room);
				break;
			case 3:
				ItemService.CreateSlotMachine(room);
				break;
			default:
				break;
			}
		}
	}
}
