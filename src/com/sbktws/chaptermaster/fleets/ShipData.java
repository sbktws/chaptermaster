package com.sbktws.chaptermaster.fleets;

public enum ShipData {

	MARINE_BATTLE_BARGE(24, 3, 3, 8, 300, 25, 3),
	MARINE_STRIKE_CRUISER(12, 4, 2, 5, 100, 10, 3);

	public final byte hull, armour, shields, weapons;
	public final short marines, vehicles;

	public final byte accuracy;

	ShipData(int hull, int armour, int shields, int weapons, int marines, int vehicles, int accuracy) {
		this.hull = (byte) hull;
		this.armour = (byte) armour;
		this.shields = (byte) shields;
		this.weapons = (byte) weapons;

		this.marines = (short) marines;
		this.vehicles = (short) vehicles;

		this.accuracy = (byte) accuracy;
	}
}
