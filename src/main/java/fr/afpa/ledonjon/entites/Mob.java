package fr.afpa.ledonjon.entites;

public class Mob extends Character {

	/**
	 * @param healthPoint
	 * @param strength
	 * @param gold
	 * @param alive
	 * @param room
	 */
	public Mob(int healthPoint, int strength, int gold, boolean alive, Room room) {
		super(healthPoint, strength, gold, alive, room);
	}

}
