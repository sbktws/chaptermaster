package com.sbktws.chaptermaster.world;

public class System {

	public Planet[] planets;

	public System(int numPlanets) {
		assert (numPlanets > 0) : "NumPlanets cannot be negative.";

		planets = new Planet[numPlanets];
	}

	public int getPosition(Planet p) {
		for (int i = 0; i < planets.length; i++) {
			if (p == planets[i]) {
				return i;
			}
		}
		return -1;
	}
}