package com.sbktws.chaptermaster;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.sbktws.chaptermaster.rendering.SectorRenderer;
import com.sbktws.chaptermaster.world.Sector;

public class ChapterMaster {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JFrame f = new JFrame("Chapter Master");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// JApplet ap = new ChapterMaster();

		// ap.init();
		// ap.start();

		SectorRenderer sr = new SectorRenderer(10, 10);

		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				sr.grid[x][y] = new Sector(x, y);
				sr.grid[x][y].setMajorityOwner((x >= 5 ? Faction.SPACE_MARINE : Faction.IMPERIAL));
			}
		}

		f.getContentPane().add(sr, BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);

	}

}
