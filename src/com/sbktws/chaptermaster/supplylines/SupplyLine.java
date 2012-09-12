package com.sbktws.chaptermaster.supplylines;

public class SupplyLine {

	/**
	 * A list of SupplyPoints that make up this route.
	 */
	private SupplyPoint[] waypoints;

	/**
	 * Internal storage for the current position.
	 */
	private int current = 0;

	public SupplyLine(SupplyPoint[] points) {
		waypoints = points;
	}

	/**
	 * Restart the current path.
	 */
	public void reset() {
		current = 0;
	}

	/**
	 * @return The waypoint at x
	 */
	public SupplyPoint getWaypoints(int x) {
		return waypoints[x];
	}

	/**
	 * @param x
	 *            The position to set.
	 * @param waypoint
	 *            The new SupplyPoint at x.
	 */
	public void setWaypoint(int x, SupplyPoint waypoint) {
		waypoints[x] = waypoint;
	}

	/**
	 * @return The next SupplyPoint on this path.
	 */
	public SupplyPoint next() {
		int pos = current;
		// Set current to 0 if it is already at max; else, increment.
		current = (current + 1 == waypoints.length) ? 0 : current + 1;
		return waypoints[pos];
	}
}
