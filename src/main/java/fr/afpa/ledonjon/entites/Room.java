package fr.afpa.ledonjon.entites;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room {
	private int bit;
	Player didier;
	ArrayList<Mob> mobs;
	ArrayList<Item> items;
	boolean north;
	boolean est;
	boolean south;
	boolean west;

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



	
}
