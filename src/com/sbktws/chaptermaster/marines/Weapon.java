package com.sbktws.chaptermaster.marines;

//Weapon enum
//
//used for all space marines and vehicles
//
//All possible space marine / space marine vehicle weapons are here
//
//since 
//
public enum Weapon {
	//format:
	//WEAPON_NAME(strength, ap, attacks/shots, "weapon name", ranged),
	BOLT_PISTOL(3,5,1,"Bolt Pistol", true),
	BOLTGUN(4,5,1,"Boltgun", true),
	STORM_BOLTER(4,5,2,"Storm Bolter", true),
	HEAVY_BOLTER(5,4,3,"Heavy Bolter", true),
	ASSAULT_CANNON(6,4,4,"Assault Cannon", true),
	AUTOCANNON(7,4,2,"Autocannon", true),
	LASCANNON(9,2,1,"Lascannon", true),
	FLAMER(4,5,5,"Flamer", true),
	HEAVY_FLAMER(5,4,5,"Heavy Flamer", true),
	MELTAGUN(8,1,1,"Meltagun", true),
	MULTIMELTA(8,1,2,"Multi Melta", true),
	SHOTGUN(3,6,2,"Shotgun", true),
	SNIPER_RIFLE(10,6,1,"Sniper Rifle", true),
	MISSILE_LAUNCHER_KRAK(8,3,1,"Missile Launcher (krak)", true),
	MISSILE_LAUNCHER_FRAG(4,6,3,"Missile Launcher (frag)", true),
	PLASMA_PISTOL(6,2,1,"Plasma Pistol", true),
	PLASMA_GUN(7,2,1,"Plasma Gun", true),
	PLASMA_CANNON(7,2,3,"Plasma Cannon", true),
	CHAINSWORD(4,7,1,"Chainsword", false),
	POWER_WEAPON(4,1,1,"Power Weapon", false),
	POWER_FIST(8,3,1,"Power Fist", false),
	CHAINFIST(8,1,1,"Chainfist", false),
	LIGHTNING_CLAW(8,1,2,"Lightning Claw", false),
	THUNDER_HAMMER(10,1,1,"Thunder Hammer", false),
	UNARMED(3,7,1,"Unarmed",false);
	
	//the variables are self explanatory here
	private byte strength, penetration, attacks;
	private String name;
	private boolean ranged;
	
	//
	//sensible getters/checkers for the weapon's variables.
	//
	public int getStrength(){return strength;}
	public int getPenetration(){return penetration;}
	public int getAttacks(){return attacks;}
	public String getName(){return name;}
	public boolean checkRanged(){return ranged;}
	
/*	Weapon,
	sets the variables of this weapon to the values of the chosen weapon.
	
	used when a Marine or Vehicle is given a new weapon.
 */
	Weapon(int str,int pen, int att, String name, boolean ranged){
		strength = (byte) str;
		penetration = (byte) pen;
		attacks = (byte) att;
		this.name = name;
		this.ranged = ranged;
	}	
}
