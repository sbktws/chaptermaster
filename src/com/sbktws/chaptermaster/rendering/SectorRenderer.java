package com.sbktws.chaptermaster.rendering;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.sbktws.chaptermaster.world.Sector;

public class SectorRenderer extends JPanel {

	private static final long serialVersionUID = 903936090715158071L;

	public Sector[][] grid;

	public SectorRenderer(int w, int h) {
		setBorder(BorderFactory.createLineBorder(Color.black));
		grid = new Sector[w][h];
	}

	public Dimension getPreferredSize() {
		return new Dimension(250, 200);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		for (Sector[] row : grid) {
			for (Sector spot : row) {
				spot.paintComponent(g2);
			}
		}
	}
}
