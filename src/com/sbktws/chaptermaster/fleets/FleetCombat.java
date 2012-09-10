package com.sbktws.chaptermaster.fleets;

import java.util.HashMap;
import java.util.Random;

public class FleetCombat {

	public Random r;

	public Fleet attacker;
	public Fleet defender;

	private HashMap<Ship, Ship> targeting;

	public FleetCombat(Fleet attacker, Fleet defender) {
		this.attacker = attacker;
		this.defender = defender;

		targeting = new HashMap<Ship, Ship>();
		r = new Random();

		for (Ship s1 : attacker.GetShips()) {
			targeting.put(s1, null);
		}

		for (Ship s2 : defender.GetShips()) {
			targeting.put(s2, null);
		}
	}

	public void DoBattle() {
		while (attacker.GetSize() > 0 && defender.GetSize() > 0) {
			for (Ship s2 : defender.GetShips()) {
				Attack (s2, targeting.get(s2), false);
			}
			
			for (Ship s1 : attacker.GetShips()) {
				Attack (s1, targeting.get(s1), true);
			}
		}
	}

	private Ship ChooseTarget(Ship shooter, boolean isAttacker) {		
		if (isAttacker) {
			return defender.GetShips()[r.nextInt(defender.GetSize())];
		} else {
			return attacker.GetShips()[r.nextInt(attacker.GetSize())];
		}
	}

	private Ship Attack(Ship shooter, Ship target, boolean isAttacker) {
		
		for (ShipWeapon w : shooter.weapons) {
			if (target == null) {
				target = ChooseTarget(shooter, isAttacker);
			}
			if (target == null) {
				return null;
			}
			
			for (int i = 0; i < w.shots; i++) {
				if (r.nextInt(7) + 1 >= shooter.data.accuracy) {
					if (w.penetration <= target.data.armour || r.nextInt(7) + 1 >= shooter.data.armour) {
						if (target.currentShields > 0) {
							--target.currentShields;
						} else {
							--target.currentHull;
							
							if (target.currentHull == 0) {
								System.out.println("A ship was destroyed!");
								
								target.GetAssigned().Remove(target);
								target = null;
								
								break;
							}
						}
					}
				}
			}
		}

		return target;
	}
}
