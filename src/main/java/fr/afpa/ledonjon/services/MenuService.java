package fr.afpa.ledonjon.services;

import fr.afpa.ledonjon.entites.Donjon;
import fr.afpa.ledonjon.entites.Room;

public class MenuService {
	public static int Choix(char choix,Donjon donjon, int xPlayer, int yPlayer) {
		Room roomS = null;
		switch (choix) {
		case 'A':
			
			break;
		case 'N':
			roomS = DonjonService.findRoomAdj(donjon, xPlayer, yPlayer, choix);
			PlayerService.Move(donjon.getMaze()[xPlayer][yPlayer], roomS);
			return xPlayer - 1;
		case 'E':
			roomS = DonjonService.findRoomAdj(donjon, xPlayer, yPlayer, choix);
			PlayerService.Move(donjon.getMaze()[xPlayer][yPlayer], roomS);
			return yPlayer + 1;
		case 'S':
			roomS = DonjonService.findRoomAdj(donjon, xPlayer, yPlayer, choix);
			PlayerService.Move(donjon.getMaze()[xPlayer][yPlayer], roomS);
			return xPlayer + 1;
		case 'W':
			roomS = DonjonService.findRoomAdj(donjon, xPlayer, yPlayer, choix);
			PlayerService.Move(donjon.getMaze()[xPlayer][yPlayer], roomS);
			return yPlayer - 1;
		case 'U':

			break;
		default:
			break;
		}
		return 0;
	}

	
}
