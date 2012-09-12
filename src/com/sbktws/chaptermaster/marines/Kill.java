package com.sbktws.chaptermaster.marines;

//Kill class
//
//used for all space marines
//
//Kills carry a 'point' value, this is used for generating Award/promotion recommendations for marines.
//This isn't an enum because i didn't want to go code all the possible kills a marine could make,
//i also didn't want to go write code to assign the right kill enum to the marine,
//as it would take an even longer switch statement.
//
//it's easier just to pass the 'title' and 'points' value of the deceased.
//
public class Kill {
	//the variables are self explanatory here
	private String target;
	private byte points;
	
	
	//
	//simple getters for the kill's variables
	//
	public String getTarget(){return target;}
	public byte getPoints(){return points;}
	
/*	Kill,
	sets the variables of the marine's kill.
	
	used when a Marine gets a kill in combat.
 */
	Kill(String target, byte points){
		this.target = target;
		this.points = points;
	}
}
