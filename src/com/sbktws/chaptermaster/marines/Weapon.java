package com.sbktws.chaptermaster.marines;

public enum Weapon {
	BOLT_PISTOL(3,5,1,"Bolt Pistol"),
	BOLTGUN(4,5,1,"Boltgun"),
	STORM_BOLTER(4,5,2,"Storm Bolter"),
	HEAVY_BOLTER(5,4,3,"Heavy Bolter"),
	ASSAULT_CANNON(6,4,4,"Assault Cannon"),
	AUTOCANNON(7,4,2,"Autocannon"),
	LASCANNON(9,2,1,"Lascannon"),
	FLAMER(4,5,5,"Flamer"),
	HEAVY_FLAMER(5,4,5,"Heavy Flamer"),
	MELTAGUN(8,1,1,"Meltagun"),
	MULTIMELTA(8,1,2,"Multi Melta"),
	SHOTGUN(3,6,2,"Shotgun"),
	SNIPER_RIFLE(10,6,1,"Sniper Rifle"),
	MISSILE_LAUNCHER_KRAK(8,3,1,"Missile Launcher (krak)"),
	MISSILE_LAUNCHER_FRAG(4,6,3,"Missile Launcher (frag)"),
	PLASMA_PISTOL(6,2,1,"Plasma Pistol"),
	PLASMA_GUN(7,2,1,"Plasma Gun"),
	PLASMA_CANNON(7,2,3,"Plasma Cannon"),
	CHAINSWORD(4,7,1,"Chainsword", false),
	POWER_WEAPON(4,1,1,"Power Weapon", false),
	POWER_FIST(8,3,1,"Power Fist", false),
	CHAINFIST(8,1,1,"Chainfist", false),
	LIGHTNING_CLAW(8,1,2,"Lightning Claw", false),
	THUNDER_HAMMER(10,1,1,"Thunder Hammer", false);
	
	private byte strength, penetration, attacks;
	private String name;
	private boolean ranged;
	
	public int getStrength(){return strength;}
	public int getPenetration(){return penetration;}
	public int getAttacks(){return attacks;}
	public String getName(){return name;}
	public boolean checkRanged(){return ranged;}
	
	Weapon(int str,int pen, int att, String name, boolean ranged){
		strength = (byte) str;
		penetration = (byte) pen;
		attacks = (byte) att;
		this.name = name;
		this.ranged = ranged;
	}
	
	Weapon(int str,int pen, int att, String name){
		strength = (byte) str;
		penetration = (byte) pen;
		attacks = (byte) att;
		this.name = name;
		this.ranged = true;
	}
}
