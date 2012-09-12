package com.sbktws.chaptermaster.supplylines;

import java.util.HashMap;

import com.sbktws.chaptermaster.Resource;

/**
 * 
 * @author James
 */
public class Inventory {

	/**
	 * Key-value pairs for each type of cargo.
	 */
	private HashMap<Resource, Integer> cargo;

	/**
	 * The maximum capacity of the cargo types.
	 */
	public final HashMap<Resource, Integer> max;

	/**
	 * Default constructor; initialises all cargo types to zero.
	 */
	public Inventory(int... maxValues) {
		cargo = new HashMap<Resource, Integer>();
		for (Resource r : Resource.values()) {
			cargo.put(r, 0);
		}

		max = new HashMap<Resource, Integer>();
		for (int i = 0; i < Resource.values().length; i++) {
			max.put(Resource.values()[i], (i < maxValues.length ? maxValues[i] : Integer.MAX_VALUE));
		}
	}

	/**
	 * @param r
	 *            The cargo type to set.
	 * @param amount
	 *            The amount to insert. AssertErrors if amount is larger than maximum.
	 */
	public void setCargo(Resource r, int amount) {
		assert (amount < max.get(r));

		cargo.put(r, amount);
	}

	/**
	 * @param r
	 *            The resource to check.
	 * @return The current cargo level.
	 */
	public int getCargo(Resource r) {
		return cargo.get(r);
	}

	/**
	 * @param r The type of cargo to move.
	 * @param amount The amount to move across.
	 * @param to The inventory to move it to.
	 * @return The modified reference to 'to'.
	 */
	public Inventory move(Resource r, int amount, Inventory to) {		
		amount = Math.min(cargo.get(r), amount);
		assert(to.getCargo(r) + amount < to.max.get(r));

		cargo.put(r, cargo.get(r) - amount);
		to.setCargo(r, to.getCargo(r) + amount);

		return to;
	}

}
