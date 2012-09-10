package com.sbktws.chaptermaster.marines;

public enum Title {
	BATTLE_BROTHER("Battle Brother", 1),
	SCOUT("Scout", 1);
	
	private String titleName;
	private byte health;
	
	public String getTitle(){return titleName;}
	public byte getHealth(){return health;}
	
	Title(String nm, int hp){
		titleName = nm;
		health = (byte) hp;
	}
}
