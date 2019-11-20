import java.util.ArrayList;

import fr.afpa.ledonjon.entites.Coordonate;
import fr.afpa.ledonjon.entites.Mob;
import fr.afpa.ledonjon.entites.Player;

public class Donjon {
	Player didier;
	ArrayList<Mob> mobs;
	Coordonate map;
	
	/**
	 *
	 */
	public Donjon(Player didier, ArrayList<Mob> mobs, Coordonate map) {
		super();
		this.didier = didier;
		this.mobs = mobs;
		this.map = map;
	}
	
}
