package com.sbktws.chaptermaster.world;

import com.sbktws.chaptermaster.Faction;

/**
 * Represents an inhabited planet.
 * 
 * @author James
 */
public class Planet {

	private Faction owner = null;

	/**
	 * The working population of the planet.
	 */
	public int workers = 0;
	/**
	 * The fighting population of this planet.
	 */
	public int warriors = 0;

	/**
	 * What type of planet is this?
	 */
	public final PlanetClassification type;

	/**
	 * Sets workers and warriors to type-appropriate values.
	 * 
	 * @param type
	 *            The type of planet to set.
	 * @param population
	 *            The total population, unmodified for world type.
	 */
	public Planet(PlanetClassification type, int population) {
		this.type = type;

		int modifiedPopulation = (int) (population * type.populationModifier);

		this.workers = (int) (modifiedPopulation * type.workers);
		this.warriors = (int) (modifiedPopulation * type.warriors);
	}

	/**
	 * @return The current owner of the planet.
	 */
	public Faction getOwner() {
		return owner;
	}

	/**
	 * @param owner
	 *            The new owner of the planet.
	 */
	public void setOwner(Faction owner) {
		this.owner = owner;
	}

	/**
	 * @return The ratio of warriors to workers.
	 */
	public float getWarriorRatio() {
		return ((float) warriors) / ((float) workers);
	}
}