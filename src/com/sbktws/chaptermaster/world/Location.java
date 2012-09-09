package com.sbktws.chaptermaster.world;

public class Location {
	public int sector, system, planet;
	
	public Location (Sector sc, System s, Planet p) {
		planet = s.getPosition(p);
		// system = sc.getPosition (s);
		sector = sc.sectorID;
	}
}
