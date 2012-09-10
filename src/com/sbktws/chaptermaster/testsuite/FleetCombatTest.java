package com.sbktws.chaptermaster.testsuite;

import org.junit.Test;

import com.sbktws.chaptermaster.fleets.Fleet;
import com.sbktws.chaptermaster.fleets.FleetCombat;
import com.sbktws.chaptermaster.fleets.Ship;
import com.sbktws.chaptermaster.fleets.ShipData;
import com.sbktws.chaptermaster.fleets.ShipWeapon;

public class FleetCombatTest {
	
	@Test
	public void Test5FleetCombats() {
		for (int i = 1; i <= 5; ++i) {
			TestFleetCombat(i);
			System.out.println("~~~~~~~~~~~~~~~~~~");
		}
	}
	
	public void TestFleetCombat(int defenderSize) {

		Fleet attacker = new Fleet(1), defender = new Fleet(defenderSize);

		attacker.Push(new Ship(ShipData.MARINE_BATTLE_BARGE));

		for (int i = 0; i < defenderSize; ++i) {
			defender.Push(new Ship(ShipData.MARINE_STRIKE_CRUISER));
		}

		for (Ship s : attacker.GetShips()) {
			for (int i = 0; i < s.weapons.length; ++i) {
				s.weapons[i] = ShipWeapon.MARINE_BOMBARDMENT_CANNON;
			}
		}
		
		for (Ship s : defender.GetShips()) {
			for (int i = 0; i < s.weapons.length; ++i) {
				s.weapons[i] = ShipWeapon.MARINE_BOMBARDMENT_CANNON;
			}
		}

		FleetCombat fc = new FleetCombat(attacker, defender);
		fc.DoBattle();
	}

}
