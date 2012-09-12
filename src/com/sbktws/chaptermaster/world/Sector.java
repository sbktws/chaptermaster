package com.sbktws.chaptermaster.world;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.HashMap;

import com.sbktws.chaptermaster.Faction;

/**
 * A sector is the largest gameplay location and is a collection of systems.
 * 
 * @author James
 */
public class Sector {
	/**
	 * How big to draw sectors on the galaxy map.
	 */
	public static final int SECTOR_DRAW_DIM = 20;

	/**
	 * Sets sector IDs based on their construction order.
	 */
	private static int CURRENT_SECTOR_ID = 0;

	private int currentSystemID = -1;
	private final System[] systems;

	public final int sectorID;
	public final int x, y;

	private Faction majorityOwner;

	public Sector(int x, int y, int numSystems) {
		sectorID = CURRENT_SECTOR_ID;
		Galaxy.sectors[x][y] = this;
		++CURRENT_SECTOR_ID;

		systems = new System[numSystems];

		this.x = x;
		this.y = y;
	}

	public void paintComponent(Graphics2D g2) {
		g2.setColor(majorityOwner.rgb);
		g2.fillRect(x * SECTOR_DRAW_DIM, y * SECTOR_DRAW_DIM, SECTOR_DRAW_DIM, SECTOR_DRAW_DIM);

		g2.setColor(Color.black);
		g2.drawRect(x * SECTOR_DRAW_DIM, y * SECTOR_DRAW_DIM, SECTOR_DRAW_DIM, SECTOR_DRAW_DIM);
	}

	/**
	 * Adds this system to the list of systems.
	 * 
	 * @param s
	 *            The system to assign the ID.
	 * @return The ID.
	 */
	public int nextSystemID(System s) {
		currentSystemID++;

		systems[currentSystemID] = s;
		return currentSystemID;
	}

	/**
	 * Exception if id is not small enough for systems.
	 * 
	 * @param id
	 *            The system ID.
	 * @return The system with that ID.
	 */
	public System getSystemWithID(int id) {
		return systems[id];
	}

	/**
	 * @return the majorityOwner
	 */
	public Faction getMajorityOwner() {
		return majorityOwner;
	}

	/**
	 * Examines all the planets in all the systems in this sector and calculates the owner
	 * accordingly.
	 */
	public void recalculateMajorityOwner() {
		HashMap<Faction, Integer> ownedPlanets = new HashMap<Faction, Integer>();
		for (System s : systems) {
			for (Planet p : s.planets) {
				if (!ownedPlanets.containsKey(p.getOwner())) {
					ownedPlanets.put(p.getOwner(), 1);
				} else {
					ownedPlanets.put(p.getOwner(), ownedPlanets.get(p.getOwner()) + 1);
				}
			}
		}

		int max = 0;
		for (Faction f : ownedPlanets.keySet()) {
			if (ownedPlanets.get(f) > max) {
				majorityOwner = f;
				max = ownedPlanets.get(f);
			}
		}
		setMajorityOwner(majorityOwner);
	}

	/**
	 * @param majorityOwner
	 *            the majorityOwner to set
	 */
	public void setMajorityOwner(Faction majorityOwner) {
		this.majorityOwner = majorityOwner;
	}
}