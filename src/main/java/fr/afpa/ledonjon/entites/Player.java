package fr.afpa.ledonjon.entites;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player extends Character {
	private String name;

	/**
	 * @param name
	 * @param healthPoint
	 * @param strength
	 * @param gold
	 * @param alive
	 * @param room
	 */
	public Player(String name, int healthPoint, int strength, int gold, boolean alive) {
		super(healthPoint, strength, gold, alive);
		this.name = name;
	}

}
