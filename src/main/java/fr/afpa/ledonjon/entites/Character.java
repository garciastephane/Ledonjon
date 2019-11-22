
package fr.afpa.ledonjon.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class Character {
	private int healthPoint;
	private int strength;
	private int gold;
	private boolean alive;
}
