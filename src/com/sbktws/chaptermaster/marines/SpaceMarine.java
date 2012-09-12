package com.sbktws.chaptermaster.marines;

import java.util.ArrayList;

import com.sbktws.chaptermaster.util.NameGenerator;

//SpaceMarine class
//
//used for all space marines
//
//there are no marine stats stored here, because they don't need to be stored here.
//all titles have the appropriate health and attackSkill values.
//all weapons have the appropriate stats for rolling to wound.
//all armours have the appropriate saves.
//
//all marines have toughness 4.
//
public class SpaceMarine {
	
	//
	//kills and awards are ArrayLists because I don't want to cap the number of kills recorded or awards gained,
	//or have a long, but mostly empty array sitting around for every marine in the chapter.
	//
	//a marine can only have 2 weapons,
	//weapons[0] is the 'ranged' weapon slot, and
	//weapons[1] is the 'melee' weapon slot.
	//
	//Armour is designated by squad (sorry Black Templars)
	//
	private Title title;
	private String name;
	private ArrayList<Kill> kills;
	private ArrayList<String> awards;
	private Weapon[] weapons = new Weapon[1];
	
	
	//
	//sensible 'getters' for the marine's variables
	//
	public String getTitle(){return title.getTitle();}
	public int getHealth(){return title.getHealth();}
	public String getName(){return name;}
	public ArrayList<Kill> getKills(){return kills;}
	public ArrayList<String> getAwards(){return awards;}
	public Weapon[] getWeapons(){return weapons;}
	
	
/*	SpaceMarine,
	default constructor, no return value
	constructs a standard space marine, armed with a bolter.
	
	used at the beginning of a new game, to generate the ~1000 marines in the chapter.
	
	assign the marine as a battle brother
	generate a name for the marine
	give the marine a boltgun
	initiate the marine's kill arraylist, empty with a length of 1
	initiate the marine's awards arraylist, empty with a length of 1
*/
	SpaceMarine(){
		title = Title.BATTLE_BROTHER;
		name = NameGenerator.nameMarine();
		weapons[0] = Weapon.BOLTGUN;
		kills= new ArrayList<Kill>(1);
		awards = new ArrayList<String>(1);
	}
	
	
/*	giveWeapon,
	give the marine a weapon, takes 1 Weapon as a parameter.
	return true if the weapon is given to the marine, return false if the weapon is not given to the marine.
	
	used when the user is customising the Marine's weapons.
	
	if the weapon is ranged, and the marine's 'ranged' weapon slot is 'empty', give him the weapon.
	if the weapon is not ranged, and the marines's 'melee' weapon slot is 'empty', give him the weapon.
	if the above conditions were not met, print a message showing that there is a problem.	
*/	
	public boolean giveWeapon(Weapon newWeapon){
		if(newWeapon.checkRanged() && weapons[0] == Weapon.UNARMED){
			weapons[0] = newWeapon;
			return true;
		}else if(!newWeapon.checkRanged() && weapons[1] == Weapon.UNARMED){
			weapons[1] = newWeapon;
			return true;
		}else{		
		System.out.println("Failed giveWeapon(" + newWeapon.getName()+") to " + this.getTitle() + " " + this.getName());
		return false;
		}
	}
}
