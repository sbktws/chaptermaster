package com.sbktws.chaptermaster.world;

public enum PlanetClassification {

	DEATH(0.5f, 0.1f, 0.9f, 2),
	HIVE(4f, 0.75f, 0.25f, 6),
	RESOURCE(1f, 0.9f, 0.1f, 8),
	FORGE(1f, 0.9f, 0.1f, 10),
	IMPERIAL(1f, 0.5f, 0.5f, 5);

	public float populationModifier, workers, warriors;
	public int production;

	PlanetClassification(float _populationModifier, float _workers, float _warriors, int _production) {
		populationModifier = _populationModifier;
		workers = _workers;
		warriors = _warriors;
		production = _production;
	}
}
