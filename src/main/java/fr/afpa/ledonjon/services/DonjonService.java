package fr.afpa.ledonjon.services;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import fr.afpa.ledonjon.entites.Donjon;
import fr.afpa.ledonjon.entites.HighScore;
import fr.afpa.ledonjon.entites.Player;
import fr.afpa.ledonjon.entites.Room;

public class DonjonService {

	/**
	 * Methode qui permets de generer un donjon avec un player
	 * 
	 * @param name
	 * @param donjon
	 * @param tailleX
	 * @param tailleY
	 */

	public static boolean DonjonContainGenerator(Donjon donjon, int tailleX, int tailleY, String diff, String name) {
		generateMaze(donjon, tailleX / 2, tailleY / 2);
		GenerateWall(donjon);
		PlayerService.CreatePlayer(name, donjon.getMaze()[0][0]);
		generateMob(donjon, tailleX, tailleY, diff);
		generateItem(donjon, tailleX, tailleY);
		return true;
	}

	/**
	 * Methode qui permets de generer la map
	 * 
	 * @param donjon
	 * @param cx
	 * @param cy
	 */

	public static boolean generateMaze(Donjon donjon, int cx, int cy) {
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
		return true;
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
	public static boolean generateMob(Donjon donjon, int tailleX, int tailleY, String diff) {
		int numMob = 0;
		switch (diff) {
		case "1":
			numMob = UtilService.RamdomNumberGenerator(tailleY / 2) + tailleX / 2;
			break;
		case "2":
			numMob = UtilService.RamdomNumberGenerator(tailleY) + tailleX;
			break;
		case "3":
			numMob = UtilService.RamdomNumberGenerator(tailleY) + tailleX * 2;
			break;
		default:
			break;
		}
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

	public static boolean generateItem(Donjon donjon, int tailleX, int tailleY) {
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
		return true;
	}

	/**
	 * Methode qui permets de trouver une salle specifique
	 * 
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
	 * 
	 * @param donjon
	 */
	public static boolean GenerateWall(Donjon donjon) {
		for (int i = 0; i < donjon.getX(); i++) {
			for (int j = 1; j < donjon.getY(); j++) {
				if (!((donjon.getMaze()[i][j].getBit() & 1) == 0)) {
					donjon.getMaze()[i][j].setWest(true);
					donjon.getMaze()[i][j - 1].setEst(true);
				}
			}
		}
		for (int i = 1; i < donjon.getX(); i++) {
			for (int j = 0; j < donjon.getY(); j++) {
				if (!((donjon.getMaze()[i][j].getBit() & 8) == 0)) {
					donjon.getMaze()[i][j].setNorth(true);
					donjon.getMaze()[i - 1][j].setSouth(true);
				}
			}
		}
		return true;
	}

	/**
	 * Methode qui permets de sauvergarder le score du joueur
	 * 
	 * @param didier
	 */
	public static void WriteScore(Donjon donjon) {
		DataOutputStream dataOutput = null;
		try {
			dataOutput = new DataOutputStream(new FileOutputStream(".\\save\\SauvegardeScore.save"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			for (HighScore hs : donjon.getHighScores()) {
				dataOutput.writeUTF(hs.getNamePlayer());
				dataOutput.writeInt(hs.getScore());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dataOutput.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static ArrayList<HighScore> ReadScore() {
		ArrayList<HighScore> highScores = new ArrayList<>();
		DataInputStream dataInput = null;
		try {
			dataInput = new DataInputStream(new FileInputStream(".\\save\\SauvegardeScore.save"));
			try {
				while (true) {
					String namePlayer = dataInput.readUTF();
					int score = dataInput.readInt();
					HighScore hs = new HighScore(namePlayer, score);
					highScores.add(hs);
				}
			} catch (EOFException ex) {
				
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return highScores;
	}

	public static boolean ChangeHighScore(Donjon donjon, Player didier) {
		
		if (donjon.getHighScores().size() == 0) {
			donjon.getHighScores().add(0, new HighScore(didier.getName(), didier.getGold()));
		} else {
				donjon.getHighScores().add(new HighScore(didier.getName(), didier.getGold()));
		}
		HighScore temp = null;
		for (int i = 0;i < donjon.getHighScores().size() ;i++ ) {
			for (int j = 0;j < donjon.getHighScores().size()-1 ;j++ ) {
				if (donjon.getHighScores().get(j).getScore()<donjon.getHighScores().get(j+1).getScore()) {
					temp = donjon.getHighScores().get(j);
					donjon.getHighScores().set(j, donjon.getHighScores().get(j+1));
					donjon.getHighScores().set(j+1, temp);
				}
			}
		}
		return true;
	}
}
