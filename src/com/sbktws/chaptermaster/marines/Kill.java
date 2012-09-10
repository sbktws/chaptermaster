package com.sbktws.chaptermaster.marines;

public class Kill {
	private String target;
	private int points;
	
	public String getTarget(){return target;}
	public int getPoints(){return points;}
	
	Kill(String target, int points){
		this.target = target;
		this.points = points;
	}
}
