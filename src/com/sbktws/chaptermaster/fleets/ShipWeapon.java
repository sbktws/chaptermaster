package com.sbktws.chaptermaster.fleets;

/**
 * Contains data about various weaponry.
 * @author James
 */
public enum ShipWeapon {
	
	/* Generic Imperial weaponry */
	TURRET_BATTERY(2, 5),
	LANCE(1, 3),
	TORPEDO_LAUNCHERS(5, 7),
	
	/* Space Marine Weaponry */
	MARINE_FORTRESS_TURRET_ARRAY(5, 4),
	MARINE_FORTRESS_BASILICA_CANNONS(2, 4),
	MARINE_BOMBARDMENT_CANNON(1, 1, true);

	byte shots, penetration;
	boolean bombards;

	ShipWeapon(int shots, int penetration) {
		this.shots = (byte) shots;
		this.penetration = (byte) penetration;
		this.bombards = false;
	}
	
	ShipWeapon(int shots, int penetration, boolean bombards) {
		this.shots = (byte) shots;
		this.penetration = (byte) penetration;
		this.bombards = bombards;
	}
}
