package fr.afpa.ledonjon.entites;

import java.util.ArrayList;

public class Room {
	private boolean north;
	private boolean south;
	private boolean est;
	private boolean west;
	private boolean stament;
	private boolean visited;
	ArrayList<Item> items;

	/**
	 * constructor
	 * 
	 * @param north
	 * @param south
	 * @param est
	 * @param west
	 * @param stament
	 * @param visited
	 */
	public Room(boolean north, boolean south, boolean est, boolean west, boolean stament, boolean visited) {
		super();
		this.north = north;
		this.south = south;
		this.est = est;
		this.west = west;
		this.stament = stament;
		this.visited = visited;
	}

	/**
	 * @return the north
	 */
	public boolean isNorth() {
		return north;
	}

	/**
	 * @param north the north to set
	 */
	public void setNorth(boolean north) {
		this.north = north;
	}

	/**
	 * @return the south
	 */
	public boolean isSouth() {
		return south;
	}

	/**
	 * @param south the south to set
	 */
	public void setSouth(boolean south) {
		this.south = south;
	}

	/**
	 * @return the est
	 */
	public boolean isEst() {
		return est;
	}

	/**
	 * @param est the est to set
	 */
	public void setEst(boolean est) {
		this.est = est;
	}

	/**
	 * @return the west
	 */
	public boolean isWest() {
		return west;
	}

	/**
	 * @param west the west to set
	 */
	public void setWest(boolean west) {
		this.west = west;
	}

	/**
	 * @return the stament
	 */
	public boolean isStament() {
		return stament;
	}

	/**
	 * @param stament the stament to set
	 */
	public void setStament(boolean stament) {
		this.stament = stament;
	}

	/**
	 * @return the visited
	 */
	public boolean isVisited() {
		return visited;
	}

	/**
	 * @param visited the visited to set
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	/**
	 * @return the items
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	
}
