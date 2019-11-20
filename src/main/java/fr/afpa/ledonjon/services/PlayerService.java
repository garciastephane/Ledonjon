package fr.afpa.ledonjon.services;

import fr.afpa.ledonjon.entites.Player;
import fr.afpa.ledonjon.entites.Start;

public class PlayerService {
	public static Player CreatePlayer(Start start) {
		return new Player(9 + UtilService.RamdomNumberGenerator(5), 2 + UtilService.RamdomNumberGenerator(2), 0, true, start);
	}
	
	public static void Heal(Player didier) {
		didier.setHealthPoint(didier.getHealthPoint()+1+ UtilService.RamdomNumberGenerator(2));
	}
}
