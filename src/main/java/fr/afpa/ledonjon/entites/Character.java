package fr.afpa.ledonjon.entites;

public abstract class Character {
	private int healthPoint;
	private int strength;
	private int gold;
	private boolean alive;
	private Room room;

	/**
	 * @param healthPoint
	 * @param strength
	 * @param gold
	 * @param alive
	 * @param room
	 */
	public Character(int healthPoint, int strength, int gold, boolean alive, Room room) {
		super();
		this.healthPoint = healthPoint;
		this.strength = strength;
		this.gold = gold;
		this.alive = alive;
		this.room = room;
	}

	/**
	 * @return the healthPoint
	 */
	public int getHealthPoint() {
		return healthPoint;
	}

	/**
	 * @param healthPoint the healthPoint to set
	 */
	public void setHealthPoint(int healthPoint) {
		this.healthPoint = healthPoint;
	}

	/**
	 * @return the strength
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * @param strength the strength to set
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}

	/**
	 * @return the gold
	 */
	public int getGold() {
		return gold;
	}

	/**
	 * @param gold the gold to set
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}

	/**
	 * @return the alive
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * @param alive the alive to set
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	/**
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(Room room) {
		this.room = room;
	}

}
