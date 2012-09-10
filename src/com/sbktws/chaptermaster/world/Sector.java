package com.sbktws.chaptermaster.world;

import java.awt.Color;
import java.awt.Graphics2D;
import com.sbktws.chaptermaster.Faction;

public class Sector {
	public static final int SECTOR_DRAW_DIM = 20;

	public static int CURRENT_SECTOR_ID = 0;

	public int sectorID;
	public final int x, y;

	private Faction majorityOwner;

	public Sector(int x, int y) {
		sectorID = CURRENT_SECTOR_ID;
		++CURRENT_SECTOR_ID;

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
	 * @return the majorityOwner
	 */
	public Faction getMajorityOwner() {
		return majorityOwner;
	}

	/**
	 * @param majorityOwner
	 *            the majorityOwner to set
	 */
	public void setMajorityOwner(Faction majorityOwner) {
		this.majorityOwner = majorityOwner;
	}
}