package fr.afpa.ledonjon.services;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import fr.afpa.ledonjon.entites.Donjon;
import fr.afpa.ledonjon.entites.Room;

public class DonjonService {

	public static int configXMaze() {
		Scanner in = new Scanner(System.in);
		System.out.println("largeur du labyrinthe ?");
		int x=in.nextInt();
		in.nextLine();
		return x;
	}
	
	public static int configYMaze() {
		Scanner in = new Scanner(System.in);
		System.out.println("hauteur du labyrinthe ?");
		int y=in.nextInt();
		in.nextLine();
		return y;
	}
	
	public static void generateMaze(Donjon donjon , int cx, int cy) {
		DIR[] dirs = DIR.values();
		Collections.shuffle(Arrays.asList(dirs));
		for (DIR dir : dirs) {
			int nx = cx + dir.dx;
			int ny = cy + dir.dy;
			if (between(nx, donjon.getX()) && between(ny, donjon.getY()) && (donjon.getMaze()[nx][ny].getBit() == 0)) {
				donjon.getMaze()[cx][cy].setBit(donjon.getMaze()[cx][cy].getBit() + dir.bit);
				donjon.getMaze()[nx][ny].setBit(donjon.getMaze()[nx][ny].getBit() + dir.opposite.bit);
				generateMaze(donjon,nx, ny);
			}
		}
	}
 
	private static boolean between(int v, int upper) {
		return (v >= 0) && (v < upper);
	}
 
	private enum DIR {
		N(1, 0, -1), S(2, 0, 1), E(4, 1, 0), W(8, -1, 0);
		private final int bit;
		private final int dx;
		private final int dy;
		private DIR opposite;
 
		// use the static initializer to resolve forward references
		static {
			N.opposite = S;
			S.opposite = N;
			E.opposite = W;
			W.opposite = E;
		}
 
		private DIR(int bit, int dx, int dy) {
			this.bit = bit;
			this.dx = dx;
			this.dy = dy;
		}
	};
 
	
	public static boolean generateMob(Donjon donjon) {

		int numMob = UtilService.RamdomNumberGenerator(7) + 1;

		for (int i = 0; i < numMob; i++) {

			donjon.getMobs().add(MobService.CreateMob(donjon));
		}
		return true;
	}

	public static void generateItem(Donjon donjon) {
		int numItem = UtilService.RamdomNumberGenerator(7) + 1;

		for (int i = 0; i < numItem; i++) {
			int typeItem = UtilService.RamdomNumberGenerator(4);
			Room room = RoomServices.FindValidRoom(donjon);
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
