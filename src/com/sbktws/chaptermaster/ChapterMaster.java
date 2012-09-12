package com.sbktws.chaptermaster;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.sbktws.chaptermaster.rendering.SectorRenderer;
import com.sbktws.chaptermaster.world.Galaxy;
import com.sbktws.chaptermaster.world.Sector;

public class ChapterMaster {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JFrame f = new JFrame("Chapter Master");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SectorRenderer sr = new SectorRenderer(Galaxy.GALAXY_WIDTH, Galaxy.GALAXY_HEIGHT);

		for (int x = 0; x < Galaxy.GALAXY_WIDTH; x++) {
			for (int y = 0; y < Galaxy.GALAXY_HEIGHT; y++) {
				sr.grid[x][y] = new Sector(x, y, 0);
				sr.grid[x][y].setMajorityOwner((x >= 5 ? Faction.SPACE_MARINE : Faction.IMPERIAL));
			}
		}

		f.getContentPane().add(sr, BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);

	}

}
