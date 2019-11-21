package fr.afpa.ledonjon.entites;

public class Coordonate {
	
	public static final int absciss = 9;
	public static final int ordonate = 5;
	Room[][] coordonate;
	
	/**
	 * 
	 */
	public Coordonate() {
		super();
		this.coordonate = new Room[absciss][ordonate];
	}
	
	/**
	 * @return the coordonate
	 */
	public Room[][] getCoordonate() {
		return coordonate;
	}

	/**
	 * @param coordonate the coordonate to set
	 */
	public void setCoordonate(Room[][] coordonate) {
		this.coordonate = coordonate;
	}

	/**
	 * @return the absciss
	 */
	public static int getAbsciss() {
		return absciss;
	}

	/**
	 * @return the ordonate
	 */
	public static int getOrdonate() {
		return ordonate;
	}


	
	
	
}
