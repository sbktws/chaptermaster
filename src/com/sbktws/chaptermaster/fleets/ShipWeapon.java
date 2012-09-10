package com.sbktws.chaptermaster.fleets;

public enum ShipWeapon {

	MARINE_BOMBARDMENT_CANNON(1, 1, 1, true);

	byte shots, penetration, cooldown;
	boolean bombards;

	ShipWeapon(int shots, int penetration, int cooldown, boolean bombards) {
		this.shots = (byte) shots;
		this.penetration = (byte) penetration;
		this.cooldown = (byte) cooldown;
		this.bombards = bombards;
	}
}
