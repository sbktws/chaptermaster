package com.sbktws.chaptermaster.fleets;

import com.sbktws.chaptermaster.supplylines.Inventory;

public class Ship {

	public final Inventory inv;
	public final ShipData data;
	public final ShipWeapon[] weapons;
	
	public byte currentShields;
	public byte currentHull;

	private Fleet fl;

	public Ship(ShipData data) {
		this.inv = new Inventory();
		this.data = data;
		weapons = new ShipWeapon[data.weapons];
		
		this.currentShields = data.shields;
		this.currentHull = data.hull;
	}
	
	public void ResetShields() {
		this.currentShields = data.shields;
	}
	
	public void ResetHull() {
		this.currentHull = data.hull;
	}

	public void AssignTo(Fleet f) {
		this.fl = f;
	}

	public Fleet GetAssigned() {
		return fl;
	}
}
