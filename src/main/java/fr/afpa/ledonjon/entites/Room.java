package fr.afpa.ledonjon.entites;

import java.util.ArrayList;

public class Room {
	private int bit;
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

	
	
}
