package com.sbktws.chaptermaster.fleets;

/**
 * Currently, a glorified container for a list of ships.
 * 
 * @author James
 */
public class Fleet {

	private short currentSize = 0;
	private Ship[] data;

	public Fleet(int i) {
		data = new Ship[i];
	}

	/**
	 * @param newSize
	 *            The size of the new fleet.
	 * @param copyOld
	 *            If true, copies all old ships over to the new fleet. Leaves uninitialised space if
	 *            old is shorter than new, and drops references if new is shorter.
	 */
	public void Resize(int newSize, boolean copyOld) {
		if (!copyOld) {
			data = new Ship[newSize];
			return;
		}

		Ship[] newData = new Ship[newSize];
		for (int i = 0; i < Math.min(newSize, currentSize); i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	/**
	 * @return A reference to the fleet's ships.
	 */
	public Ship[] GetShips() {
		return data;
	}
	
	/**
	 * @return A copy to the fleet's ships.
	 */
	public Ship[] GetShipsCopy() {
		Ship[] copy = new Ship[currentSize];
		
		for (int i = 0; i < currentSize; i++) {
			copy[i] = data[i];
		}
		
		return copy;
	}

	/**
	 * Get the fleet's current size. This is *different* to data.length in many cases.
	 * 
	 * @return The fleet's size.
	 */
	public int GetSize() {
		return currentSize;
	}

	/**
	 * Add a set of ships to the fleet.
	 * 
	 * @param s
	 *            A comma-seperated list of ships to add.
	 */
	public void Push(Ship... s) {
		assert (currentSize + s.length < data.length - 1) : "Too many ships added to fleet!";

		for (Ship ship : s) {
			data[currentSize] = ship;
			ship.AssignTo(this);
			currentSize++;
		}
	}

	/**
	 * Does not preserve list order.
	 * 
	 * @param s
	 *            A list of ships to remove.
	 */
	public void Remove(Ship... s) {
		assert (currentSize - s.length < data.length - 1) : "Too many ships added to fleet!";

		for (Ship ship : s) {
			for (int i = 0; i < currentSize; i++) {
				if (data[i] == ship) {
					data[i] = data[currentSize - 1];
					data[currentSize - 1] = null;
					ship.AssignTo(null);
					currentSize--;
					break;
				}
			}
		}
	}
}
