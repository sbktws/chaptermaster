package com.sbktws.chaptermaster.fleets;

import com.sbktws.chaptermaster.supplylines.Inventory;

/**
 * @author James
 *
 */
public class Ship {

	/**
	 * This ship's inventory. null if the ship lacks transport capacity.
	 */
	public final Inventory inv;
	/**
	 * This ship's model data. Not duplicated in the ship itself.
	 */
	public final ShipData data;
	/**
	 * The ship's weapons, stored here for customisation.
	 */
	public final ShipWeapon[] weapons;
	
	/**
	 * The current shield level of the ship.
	 */
	public byte currentShields;
	/**
	 * The current hull integrity of the ship.
	 */
	public byte currentHull;

	/**
	 * Internal reference to the fleet this ship is assigned to.
	 */
	private Fleet fl;

	/**
	 * @param data The type of ship to instantiate.
	 */
	public Ship(ShipData data) {
		this.inv = new Inventory();
		this.data = data;
		weapons = data.getWeapons(data);
		
		this.currentShields = data.shields;
		this.currentHull = data.hull;
	}
	
	/**
	 * Sets the shields back to maximum.
	 */
	public void ResetShields() {
		this.currentShields = data.shields;
	}
	
	/**
	 * Sets the hull back to maximum.
	 */
	public void ResetHull() {
		this.currentHull = data.hull;
	}

	/**
	 * @param f The fleet to reference. Set to null to unassign.
	 */
	public void AssignTo(Fleet f) {
		this.fl = f;
	}

	/**
	 * @return The assigned fleet.
	 */
	public Fleet GetAssigned() {
		return fl;
	}
}
