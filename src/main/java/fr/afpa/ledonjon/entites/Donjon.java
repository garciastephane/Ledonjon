package fr.afpa.ledonjon.entites;
import java.util.ArrayList;

import fr.afpa.ledonjon.entites.Coordonate;
import fr.afpa.ledonjon.entites.Mob;
import fr.afpa.ledonjon.entites.Player;

public class Donjon {
	Player didier;
	ArrayList<Mob> mobs;
	Coordonate map;
	
	/**
	 * @param didier
	 * @param mobs
	 * @param map
	 */
	public Donjon(Player didier, ArrayList<Mob> mobs, Coordonate map) {
		super();
		this.didier = didier;
		this.mobs = mobs;
		this.map = map;
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
	 * @return the map
	 */
	public Coordonate getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(Coordonate map) {
		this.map = map;
	}
	
	
	
	
	
}
