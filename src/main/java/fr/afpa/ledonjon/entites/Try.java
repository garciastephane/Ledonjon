package fr.afpa.ledonjon.entites;

import java.util.Collections;
import java.util.Arrays;
 
public class Try {
	private final int x;
	private final int y;
	private final Room[][] maze;
 
	public static void main(String[] args) {
		int x = args.length >= 1 ? (Integer.parseInt(args[0])) : 10;
		int y = args.length == 2 ? (Integer.parseInt(args[1])) : 10;
		Try maze = new Try(x, y);
		maze.display();
	}
	
	public Try(int x, int y) {
		this.x = x;
		this.y = y;
		maze = new Room[this.x][this.y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				maze[i][j]= new Room();
			}
		}
		maze[0][0]=new Start();
		maze[x-1][y-1]=new End();
		generateMaze(5, 5);
	}
 
	public void display() {
		for (int i = 0; i < y; i++) {
			// draw the north edge
			for (int j = 0; j < x; j++) {
				System.out.print((maze[j][i].getBit() & 1) == 0 ? "+---" : "+   ");
				
			}
			System.out.println("+");
			// draw the west edge
			for (int j = 0; j < x; j++) {
				if (j==0 && i ==0) {
					System.out.print("    ");
				}
				//else 
				else System.out.print((maze[j][i].getBit() & 8) == 0 ? "|   " : "    ");
			}
			if (i == y-1) {System.out.println(" ");}
			else System.out.println("|");
		}
		// draw the bottom line
		for (int j = 0; j < x; j++) {
			System.out.print("+---");
		}
		System.out.println("+");
		
	}
 
	private void generateMaze(int cx, int cy) {
		DIR[] dirs = DIR.values();
		Collections.shuffle(Arrays.asList(dirs));
		for (DIR dir : dirs) {
			int nx = cx + dir.dx;
			int ny = cy + dir.dy;
			if (between(nx, x) && between(ny, y) && (maze[nx][ny].getBit() == 0)) {
				maze[cx][cy].setBit(maze[cx][cy].getBit() + dir.bit);
				maze[nx][ny].setBit(maze[nx][ny].getBit() + dir.opposite.bit);
				generateMaze(nx, ny);
			}
		}
	}
 
	private static boolean between(int v, int upper) {
		return (v >= 0) && (v < upper);
	}
 
	private enum DIR {
		N(1, 0, -1), S(2, 0, 1), E(4, 1, 0), W(8, -1, 0);
		private final int bit;
		private final int dx;
		private final int dy;
		private DIR opposite;
 
		// use the static initializer to resolve forward references
		static {
			N.opposite = S;
			S.opposite = N;
			E.opposite = W;
			W.opposite = E;
		}
 
		private DIR(int bit, int dx, int dy) {
			this.bit = bit;
			this.dx = dx;
			this.dy = dy;
		}
	};
 
	
 
}