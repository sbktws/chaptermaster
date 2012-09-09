package com.sbktws.chaptermaster.supplylines;

public class SupplyLine {

	public SupplyPoint[] waypoints;
	private int current = 0;

	public SupplyLine(SupplyPoint[] points) {
		waypoints = points;
	}

	public void reset() {
		current = 0;
	}

	public SupplyPoint next() {
		int pos = current;
		// Set current to 0 if it is already at max; else, increment.
		current = (current+1 == waypoints.length) ? 0 : current+1;
		return waypoints[pos];
	}
}
