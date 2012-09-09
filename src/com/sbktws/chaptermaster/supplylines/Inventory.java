package com.sbktws.chaptermaster.supplylines;

import java.util.HashMap;

import com.sbktws.chaptermaster.Resource;

public class Inventory {

	private HashMap<Resource, Integer> cargo;
	
	public Inventory() {
		cargo = new HashMap<Resource, Integer>();
		for (Resource r : Resource.values()) {
			cargo.put(r, 0);
		}
	}
	
	public void setCargo(Resource r, int amount) {
		cargo.put(r, amount);
	}
	
	public int getCargo(Resource r) {
		return cargo.get(r);
	}
	
	public Inventory move(Resource r, int amount, Inventory to) {
		amount = Math.min(cargo.get(r), amount);
		
		cargo.put(r, cargo.get(r)-amount);
		to.setCargo(r, to.getCargo(r) + amount);
		
		return to;
	}

}
