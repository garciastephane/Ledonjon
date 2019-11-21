package fr.afpa.ledonjon.entites;
import java.util.ArrayList;

import fr.afpa.ledonjon.entites.Mob;
import fr.afpa.ledonjon.entites.Player;

public class Donjon {
	Player didier;
	ArrayList<Mob> mobs;
	private int x;
	private int y;
	private final Room[][] maze;
	
	/**
	 * @param didier
	 * @param mobs
	 * @param map
	 */
	public Donjon(int x, int y) {
		super();
		this.didier = null;
		this.mobs = null;
		this.x = x;
		this.y = y;
		maze = new Room[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				maze[i][j]= new Room();
			}
		}
		maze[0][0]=new Start();
		maze[x-1][y-1]=new End();
	}

	/**
	 * @return the didier
	 */
	public Player getDidier() {
		return didier;
	}

	/**
	 * @param didier the didier to set
	 */
	public void setDidier(Player didier) {
		this.didier = didier;
	}

	/**
	 * @return the mobs
	 */
	public ArrayList<Mob> getMobs() {
		return mobs;
	}

	/**
	 * @param mobs the mobs to set
	 */
	public void setMobs(ArrayList<Mob> mobs) {
		this.mobs = mobs;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @return the maze
	 */
	public Room[][] getMaze() {
		return maze;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	

}
