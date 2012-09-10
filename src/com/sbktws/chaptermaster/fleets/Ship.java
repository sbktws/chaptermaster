package com.sbktws.chaptermaster.fleets;

import com.sbktws.chaptermaster.supplylines.Inventory;

public class Ship {

	public final ShipType type;
	public final Inventory inv;
	public final ShipData data;
	public final ShipWeapon[] weapons;

	private Fleet fl;

	public Ship(ShipType type, ShipData data) {
		this.inv = new Inventory();
		this.type = type;
		this.data = data;
		weapons = new ShipWeapon[data.weapons];
	}

	public void AssignTo(Fleet f) {
		this.fl = f;
	}

	public Fleet GetAssigned() {
		return fl;
	}
}
