package com.sbktws.chaptermaster;

import java.awt.Color;

public enum Faction {

	SPACE_MARINE(new Color(50, 255, 50)),
	IMPERIAL(new Color(255, 255, 0));

	public Color rgb;

	Faction(Color drawColour) {
		rgb = drawColour;
	}

}
