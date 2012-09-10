package com.sbktws.chaptermaster.marines;

import java.util.ArrayList;
import util.NameGenerator;

public class SpaceMarine {
	private Title title;
	private String name;
	private ArrayList<Kill> kills;
	private ArrayList<String> awards;
	private Weapon[] weapons = new Weapon[1];
	
	public String getTitle(){return title.getTitle();}
	public int getHealth(){return title.getHealth();}
	public String getName(){return name;}
	public ArrayList<Kill> getKills(){return kills;}
	public ArrayList<String> getAwards(){return awards;}
	public Weapon[] getWeapons(){return weapons;}
	
	SpaceMarine(){
		title = Title.BATTLE_BROTHER;
		name = NameGenerator.nameMarine();
		weapons[0] = Weapon.BOLTGUN;
		kills= new ArrayList<Kill>(1);
		awards = new ArrayList<String>(1);
	}
}
