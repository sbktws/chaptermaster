package com.sbktws.chaptermaster.world;

/**
 * Stores a location (a combination of Sector, System and Planet) in gamespace.
 * @author James
 *
 */
public class Location {
	public int sector, system, planet;

	public Location(Sector sc, System s, Planet p) {
		planet = s.getPosition(p);
		system = s.systemID;
		sector = sc.sectorID;
	}
}
