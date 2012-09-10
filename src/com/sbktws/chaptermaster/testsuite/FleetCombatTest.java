package com.sbktws.chaptermaster.testsuite;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sbktws.chaptermaster.fleets.Fleet;
import com.sbktws.chaptermaster.fleets.Ship;
import com.sbktws.chaptermaster.fleets.ShipData;
import com.sbktws.chaptermaster.fleets.ShipType;
import com.sbktws.chaptermaster.fleets.ShipWeapon;

public class FleetCombatTest {

	@Test
	public void TestFleetCombat() {

		Fleet attacker = new Fleet(1), defender = new Fleet(3);

		attacker.Push(new Ship(ShipType.MARINE_BATTLE_BARGE, ShipData.MARINE_BATTLE_BARGE));
		defender.Push(new Ship(ShipType.MARINE_STRIKE_CRUISER, ShipData.MARINE_STRIKE_CRUISER), new Ship(ShipType.MARINE_STRIKE_CRUISER, ShipData.MARINE_STRIKE_CRUISER), new Ship(ShipType.MARINE_STRIKE_CRUISER, ShipData.MARINE_STRIKE_CRUISER));

		attacker.GetShips()[0].weapons[0] = ShipWeapon.MARINE_BOMBARDMENT_CANNON;
		attacker.GetShips()[0].weapons[1] = ShipWeapon.MARINE_BOMBARDMENT_CANNON;
		attacker.GetShips()[0].weapons[2] = ShipWeapon.MARINE_BOMBARDMENT_CANNON;
		
		for (Ship s : defender.GetShips()) {
			
		}

	}

}
