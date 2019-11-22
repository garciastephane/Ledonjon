package fr.afpa.ledonjon.entites;

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

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @return the maze
	 */
	public Room[][] getMaze() {
		return maze;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	

}
