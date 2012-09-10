package com.sbktws.chaptermaster.fleets;

public enum ShipWeapon {

	MARINE_BOMBARDMENT_CANNON(10, 1, 2, true);

	byte strength, penetration, cooldown;
	boolean bombards;

	ShipWeapon(int strength, int penetration, int cooldown, boolean bombards) {
		this.strength = (byte) strength;
		this.penetration = (byte) penetration;
		this.cooldown = (byte) cooldown;
		this.bombards = bombards;
	}
}
