package com.sbktws.chaptermaster.testsuite;

import org.junit.Assert;
import org.junit.Test;

import com.sbktws.chaptermaster.fleets.Fleet;
import com.sbktws.chaptermaster.fleets.Ship;
import com.sbktws.chaptermaster.fleets.ShipData;
import com.sbktws.chaptermaster.fleets.ShipType;

/**
 * @author James
 * 
 */
public class FleetShipTest {

	Ship[] testShips = new Ship[2];

	@Test
	public void testResize() {
		testShips[0] = new Ship(ShipType.MARINE_BATTLE_BARGE, ShipData.MARINE_BATTLE_BARGE);
		testShips[1] = new Ship(ShipType.MARINE_STRIKE_CRUISER, ShipData.MARINE_BATTLE_BARGE);

		Fleet f = new Fleet(2);
		f.Push(testShips[0], testShips[1]);

		Ship[] data = f.GetShips();
		Assert.assertSame((Object) data[0], (Object) testShips[0]);
		Assert.assertSame((Object) f, (Object) testShips[0].GetAssigned());
		Assert.assertSame((Object) data[1], (Object) testShips[1]);
		Assert.assertSame((Object) f, (Object) testShips[1].GetAssigned());

		f.Resize(1, true);

		Assert.assertSame((Object) data[0], (Object) testShips[0]);
		Assert.assertSame((Object) f, (Object) testShips[0].GetAssigned());
	}
}
