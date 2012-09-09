package com.sbktws.chaptermaster.world;

import com.sbktws.chaptermaster.Faction;

public class Planet {
	
	private Faction owner = null;
	
	public int workers = 0;
	public int warriors = 0;

	public final PlanetClassification type;
	
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
	 * This method notifies the old and new owners of their changes in territory.
	 * @param owner The new owner of the planet.
	 */
	public void setOwner(Faction owner) {
		this.owner = owner;
	}
	
	public float getWarriorRatio () {
		return ((float) warriors)/((float) workers);
	}
}