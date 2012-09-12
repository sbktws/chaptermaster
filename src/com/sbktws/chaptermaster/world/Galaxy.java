package com.sbktws.chaptermaster.world;

/**
 * A full-static class for handling the entire game world.
 * @author James
 */
public class Galaxy {
	
	public static final int GALAXY_WIDTH = 30;
	public static final int GALAXY_HEIGHT = 30;
	
	/**
	 * Square array of sectors, populated by the Sector constructor.
	 */
	public static Sector[][] sectors = new Sector[GALAXY_WIDTH][GALAXY_HEIGHT];

	/**
	 * @param s The sector to find.
	 * @return int[] {x, y}
	 */
	public static int[] findSectorPosition(Sector s) {
		for (int x = 0; x < sectors.length; x++) {
			for (int y = 0; y < sectors[x].length; y++) {
				if (s == sectors[x][y]) {
					return new int[] {x, y};
				}
			}
		}
		return null;
	}
	
	/**
	 * @param id The id to search for.
	 * @return The sector with that ID.
	 */
	public static Sector findSectorWith(int id) {
		for (int x = 0; x < sectors.length; x++) {
			for (int y = 0; y < sectors[x].length; y++) {
				if (sectors[x][y].sectorID == id) {
					return sectors[x][y];
				}
			}
		}
		return null;
	}
}
