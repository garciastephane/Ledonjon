package fr.afpa.ledonjon.services;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import fr.afpa.ledonjon.entites.Donjon;
import fr.afpa.ledonjon.entites.Room;

public class DonjonService {
	
	/**
	 * Methode qui permets de generer un donjon avec un player
	 * @param name
	 * @param donjon
	 * @param tailleX
	 * @param tailleY
	 */

	public static void DonjonContainGenerator(Donjon donjon, int tailleX, int tailleY) {
		generateMaze(donjon, tailleX / 2, tailleY / 2);
		GenerateWall(donjon);
		PlayerService.CreatePlayer( donjon.getMaze()[0][0]);
		generateMob(donjon, tailleX, tailleY);
		generateItem(donjon, tailleX, tailleY);

	}

	/**
	 * Methode qui permets de configurer le parametre X sur la map
	 * 
	 * @return
	 */

	public static int configXMaze(Scanner in) {
		System.out.println("largeur du labyrinthe ?");
		int x = in.nextInt();
		in.nextLine();
		return x;
	}

	/**
	 * Methode qui permets de configurer le parametre Y sur la map
	 * 
	 * @return
	 */
	public static int configYMaze(Scanner in) {
		System.out.println("hauteur du labyrinthe ?");
		int y = in.nextInt();
		in.nextLine();
		return y;
	}

	/**
	 * Methode qui permets de generer la map
	 * 
	 * @param donjon
	 * @param cx
	 * @param cy
	 */

	public static void generateMaze(Donjon donjon, int cx, int cy) {
		DIR[] dirs = DIR.values();
		Collections.shuffle(Arrays.asList(dirs));
		for (DIR dir : dirs) {
			int nx = cx + dir.dx;
			int ny = cy + dir.dy;
			if (between(nx, donjon.getX()) && between(ny, donjon.getY()) && (donjon.getMaze()[nx][ny].getBit() == 0)) {
				donjon.getMaze()[cx][cy].setBit(donjon.getMaze()[cx][cy].getBit() + dir.bit);
				donjon.getMaze()[nx][ny].setBit(donjon.getMaze()[nx][ny].getBit() + dir.opposite.bit);
				generateMaze(donjon, nx, ny);
			}
		}
	}

	/**
	 * Methode qui confirme si c est entre deux choses
	 * 
	 * @param v
	 * @param upper
	 * @return
	 */
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
	}

	/**
	 * Methode pour generer un mob
	 * 
	 * @param donjon
	 * @param tailleY
	 * @param tailleX
	 * @return
	 */
	public static boolean generateMob(Donjon donjon, int tailleX, int tailleY) {
		int numMob = UtilService.RamdomNumberGenerator(tailleX) + tailleY;
		for (int i = 0; i < numMob; i++) {
			MobService.CreateMob(donjon, tailleX, tailleY);
		}
		return true;
	}

	/**
	 * Methode pour generer un item
	 * 
	 * @param donjon
	 */

	public static void generateItem(Donjon donjon, int tailleX, int tailleY) {
		int numItem = UtilService.RamdomNumberGenerator(tailleY) + tailleX;

		for (int i = 0; i < numItem; i++) {
			int typeItem = UtilService.RamdomNumberGenerator(4);
			Room room = RoomServices.FindValidRoom(donjon, tailleX, tailleY);
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

	/**
	 * Methode qui permets de trouver une salle specifique
	 * @param donjon
	 * @param x
	 * @param y
	 * @param choix
	 * @return
	 */
	public static Room findRoomAdj(Donjon donjon, int x, int y, char choix) {
		if (choix == 'N') {
			return donjon.getMaze()[x - 1][y];
		} else if (choix == 'E') {
			return donjon.getMaze()[x][y + 1];
		} else if (choix == 'S') {
			return donjon.getMaze()[x + 1][y];
		} else if (choix == 'W') {
			return donjon.getMaze()[x][y - 1];
		} else
			return null;
	}

	/**
	 * Methode qui permets de generer un mur
	 * @param donjon
	 */
	public static void GenerateWall(Donjon donjon) {
		for (int i = 0; i < donjon.getX(); i++) {
			// draw the north edge
			for (int j = 1; j < donjon.getY(); j++) {
				if (!((donjon.getMaze()[i][j].getBit() & 1) == 0)) {
					donjon.getMaze()[i][j].setWest(true);
					donjon.getMaze()[i][j-1].setEst(true);
				} 
			}
			// draw the west edge
		}
		for (int i = 1; i < donjon.getX() ; i++) {
			for (int j = 0; j < donjon.getY(); j++) {
				if (!((donjon.getMaze()[i][j].getBit() & 8) == 0)) {
					donjon.getMaze()[i][j].setNorth(true);
					donjon.getMaze()[i-1][j].setSouth(true);
				} 
			}
		}
		
		// draw the bottom line
		
	}

}
