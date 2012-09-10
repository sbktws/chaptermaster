package com.sbktws.chaptermaster.fleets;

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
	 *            If true, copies all old ships over to the new fleet. Leaves uninitialised space if old is shorter than new, and
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

	public Ship[] GetShips() {
		return data;
	}
	
	public int GetSize() {
		return currentSize;
	}

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
	 * @param s A list of ships to remove.
	 */
	public void Remove (Ship... s) {
		assert (currentSize - s.length < data.length - 1) : "Too many ships added to fleet!";

		for (Ship ship : s) {
			for (int i = 0; i < currentSize; i++) {
				if (data[i] == ship) {
					data[i] = data[currentSize-1];
					ship.AssignTo(null);
					currentSize--;
					break;
				}
			}
		}
	}
}
