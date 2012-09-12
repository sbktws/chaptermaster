package com.sbktws.chaptermaster.testsuite;

import org.junit.Test;

import com.sbktws.chaptermaster.fleets.Fleet;
import com.sbktws.chaptermaster.fleets.FleetCombat;
import com.sbktws.chaptermaster.fleets.Ship;
import com.sbktws.chaptermaster.fleets.ShipData;

public class FleetCombatTest {
	
	@Test
	public void Test5FleetCombats() {
		for (int i = 1; i <= 5; ++i) {
			TestFleetCombat(i);
			System.out.println("~~~~~~~~~~~~~~~~~~");
		}
		
		for (int i = 10; i <= 15; ++i) {
			TestFortressMonasteryCombat(i);
			System.out.println("~~~~~~~~~~~~~~~~~~");
		}
	}
	
	public void TestFleetCombat(int defenderSize) {

		Fleet attacker = new Fleet(1), defender = new Fleet(defenderSize);

		attacker.Push(new Ship(ShipData.MARINE_BATTLE_BARGE));

		for (int i = 0; i < defenderSize; ++i) {
			defender.Push(new Ship(ShipData.MARINE_STRIKE_CRUISER));
		}

		FleetCombat fc = new FleetCombat(attacker, defender);
		fc.DoBattle();
	}
	
	public void TestFortressMonasteryCombat(int attackerSize) {

		Fleet defender = new Fleet(1), attacker = new Fleet(attackerSize);

		defender.Push(new Ship(ShipData.MARINE_FORTRESS_MONASTERY));

		for (int i = 0; i < attackerSize; ++i) {
			attacker.Push(new Ship(ShipData.MARINE_BATTLE_BARGE));
		}

		FleetCombat fc = new FleetCombat(attacker, defender);
		fc.DoBattle();
	}

}
