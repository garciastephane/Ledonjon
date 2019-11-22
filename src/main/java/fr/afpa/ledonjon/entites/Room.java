package fr.afpa.ledonjon.entites;

import java.util.ArrayList;

public class Room {
	private int bit;
	Player didier;
	ArrayList<Mob> mobs;
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
	public Room() {
		super();
		this.bit = 0;
		mobs = new ArrayList<Mob>();
		items = new ArrayList<Item>();
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

	public int getBit() {
		return bit;
	}

	public void setBit(int bit) {
		this.bit = bit;
	}

	@Override
	public String toString() {
		return "Room [bit=" + bit + "]";
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

	
}
