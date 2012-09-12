package com.sbktws.chaptermaster.marines;

//Title enum
//
//used for all space marines
//
//All possible space marine titles are here,
//because in the codex, a marine's wounds seems to be connected with the marine's title,
//that is the way i have implemented it here.
//
//weapon skill and ballistic skill are also attached to a marine's title,
//they also are always equal so i have combined them into one value, 'attackSkill'.
//
public enum Title {
	//format
	//TITLE_NAME("Title Name", health, attack skill);
	BATTLE_BROTHER("Battle Brother", 1, 4),
	SCOUT("Scout", 1, 4);
	
	//the variables are self explanatory here
	private String titleName;
	private byte health, attackSkill;
	
	//
	//simple getters for the title's variables
	//
	public String getTitle(){return titleName;}
	public byte getHealth(){return health;}
	public byte getBallisticSkill(){return attackSkill;}
	
/*	Title,
	sets the variables of the marine's title to the values of the chosen title.
	
	used when a Marine is given a new title.
 */
	Title(String name, int health, int attackSkill){
		titleName = name;
		this.health = (byte) health;
		this.attackSkill = (byte) attackSkill;
	}
}
