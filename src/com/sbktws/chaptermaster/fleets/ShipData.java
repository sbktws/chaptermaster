package com.sbktws.chaptermaster.fleets;

/**
 * Contains all the data required for a simulated ship.
 * 
 * @author James
 */
public enum ShipData {

	/* Space Marine Ships */
	MARINE_FORTRESS_MONASTERY(
			"Space Marine Fortress-Monastery",
			48,
			2,
			16,
			16,
			1000,
			150,
			3),
	MARINE_BATTLE_BARGE(
			"Space Marine Battle Barge",
			12,
			2,
			4,
			4,
			300,
			30,
			3),
	MARINE_STRIKE_CRUISER(
			"Space Marine Strike Cruiser",
			6,
			2,
			2,
			3,
			100,
			10,
			3),
	MARINE_GLADIUS_FRIGATE(
			"Space Marine Gladius Frigate",
			1,
			3,
			1,
			2,
			10,
			0,
			3),

	/* Imperial Ships */
	IMPERIAL_COBRA_DESTROYER(
			"Imperial Cobra Destroyer",
			1,
			4,
			1,
			3,
			10,
			0,
			3),
	IMPERIAL_FIRESTORM_FRIGATE(
			"Imperial Firestorm Frigate",
			1,
			3,
			1,
			3,
			10,
			0,
			3),
	IMPERIAL_SWORD_FRIGATE(
			"Imperial Sword Frigate",
			1,
			3,
			1,
			2,
			10,
			0,
			3);

	/**
	 * A human-readable name for the ship class.
	 */
	public final String name;

	/**
	 * Values for the hull and shield maximums, the armour save, and the number of weapon mounts.
	 */
	public final byte hull, armour, shields, weapons;
	/**
	 * Carrying capacity.
	 */
	public final short marines, vehicles;

	/**
	 * To-hit roll, in n+ form.
	 */
	public final byte accuracy;

	ShipData(String name, int hull, int armour, int shields, int weapons, int marines,
			int vehicles, int accuracy) {
		this.name = name;

		this.hull = (byte) hull;
		this.armour = (byte) armour;
		this.shields = (byte) shields;
		this.weapons = (byte) weapons;

		this.marines = (short) marines;
		this.vehicles = (short) vehicles;

		this.accuracy = (byte) accuracy;
	}

	/**
	 * Get the standard armament for a ship.
	 * 
	 * @param sd
	 *            The ship type.
	 * @return A list of weapons for that type.
	 */
	public ShipWeapon[] getWeapons(ShipData sd) {
		ShipWeapon[] w = new ShipWeapon[sd.weapons];

		switch (sd) {
		case MARINE_FORTRESS_MONASTERY:
			w[0] = ShipWeapon.MARINE_FORTRESS_BASILICA_CANNONS;
			w[1] = ShipWeapon.MARINE_FORTRESS_BASILICA_CANNONS;
			for (int i = 2; i < sd.weapons; i++) {
				w[i] = ShipWeapon.MARINE_FORTRESS_TURRET_ARRAY;
			}
			break;
		case MARINE_BATTLE_BARGE:
			w[0] = ShipWeapon.MARINE_BOMBARDMENT_CANNON;
			w[1] = ShipWeapon.TURRET_BATTERY;
			w[2] = ShipWeapon.TURRET_BATTERY;
			w[3] = ShipWeapon.TORPEDO_LAUNCHERS;
			break;
		case MARINE_STRIKE_CRUISER:
			w[0] = ShipWeapon.MARINE_BOMBARDMENT_CANNON;
			w[1] = ShipWeapon.TURRET_BATTERY;
			w[2] = ShipWeapon.TURRET_BATTERY;
			break;
		case IMPERIAL_COBRA_DESTROYER:
			break;
		case IMPERIAL_FIRESTORM_FRIGATE:
			break;
		case IMPERIAL_SWORD_FRIGATE:
			break;
		case MARINE_GLADIUS_FRIGATE:
			break;
		default:
			break;

		}
		return w;
	}
}
