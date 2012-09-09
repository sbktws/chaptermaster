package com.sbktws.chaptermaster.world;

public class Sector {
	
	public static int CURRENT_SECTOR_ID = 0;
	
	public int sectorID;
	public final int x, y;
	
	public Sector(int x, int y) {
		sectorID = CURRENT_SECTOR_ID;
		++CURRENT_SECTOR_ID;
		
		this.x = x;
		this.y = y;
	}
}