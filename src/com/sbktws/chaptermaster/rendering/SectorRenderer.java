package com.sbktws.chaptermaster.rendering;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class SectorRenderer extends Component {

	public SectorRenderer() {
		// TODO Auto-generated constructor stub
	}
	
	 public void paint(Graphics g) {
	        Graphics2D g2 = (Graphics2D) g;
	        
	        g2.fillRect(0, 0, 10, 10);
	 }

}
