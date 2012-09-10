package com.sbktws.chaptermaster.fleets;

public enum ShipData {

	MARINE_BATTLE_BARGE("Space Marine Battle Barge", 40, 3, 5, 8, 300, 25, 3),
	MARINE_STRIKE_CRUISER("Space Marine Strike Cruiser", 12, 4, 2, 5, 100, 10, 3);
	
	public final String name;
	
	public final byte hull, armour, shields, weapons;
	public final short marines, vehicles;

	public final byte accuracy;

	ShipData(String name, int hull, int armour, int shields, int weapons, int marines, int vehicles, int accuracy) {
		this.name = name;
		
		this.hull = (byte) hull;
		this.armour = (byte) armour;
		this.shields = (byte) shields;
		this.weapons = (byte) weapons;

		this.marines = (short) marines;
		this.vehicles = (short) vehicles;

		this.accuracy = (byte) accuracy;
	}
}
