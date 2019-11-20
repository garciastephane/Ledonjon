package fr.afpa.ledonjon.services;

import fr.afpa.ledonjon.entites.Player;
import fr.afpa.ledonjon.entites.Start;

public class ServicePlayer {
	public static Player CreatePlayer(Start start) {
		return new Player(9 + UtilService.RamdomNumberGenerator(5), 2 + UtilService.RamdomNumberGenerator(2), 0, true, start);
	}
}
