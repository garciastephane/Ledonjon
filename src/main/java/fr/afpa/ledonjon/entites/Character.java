package fr.afpa.ledonjon.entites;

public abstract class Character {
	protected int heathPoint;
	protected int strength;
	protected int gold;
	protected boolean alive;
	
	/**
	 * Construtor
	 * @param heathPoint
	 * @param strength
	 * @param gold
	 * @param alive
	 */
	public Character(int heathPoint, int strength, int gold, boolean alive) {
		super();
		this.heathPoint = heathPoint;
		this.strength = strength;
		this.gold = gold;
		this.alive = alive;
	}

	public int getHeathPoint() {
		return heathPoint;
	}

	public void setHeathPoint(int heathPoint) {
		this.heathPoint = heathPoint;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	
}
