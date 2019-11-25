package fr.afpa.ledonjon.entites;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Donjon {
	private int x;
	private int y;
	private final Room[][] maze;
	
	/**
	 * @param didier
	 * @param mobs
	 * @param map
	 */
	public Donjon(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		maze = new Room[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				maze[i][j]= new Room();
			}
		}
		maze[0][0]=new Start();
		maze[x-1][y-1]=new End();
		
	}

}
