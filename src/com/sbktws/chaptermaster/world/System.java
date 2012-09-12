package com.sbktws.chaptermaster.world;

import com.sbktws.chaptermaster.Faction;

/**
 * A subsector; a single collection of planets.
 * @author James
 */
public class System {

	public final int systemID;
	public final Sector parent;
	public Faction owner;
	public Planet[] planets;

	public System(int numPlanets, Sector parent) {
		assert (numPlanets > 0) : "NumPlanets cannot be negative.";

		this.parent = parent;
		this.systemID = parent.nextSystemID(this);
		
		planets = new Planet[numPlanets];
	}

	/**
	 * @param p The planet to find.
	 * @return Its position in the planets array.
	 */
	public int getPosition(Planet p) {
		for (int i = 0; i < planets.length; i++) {
			if (p == planets[i]) {
				return i;
			}
		}
		return -1;
	}
}