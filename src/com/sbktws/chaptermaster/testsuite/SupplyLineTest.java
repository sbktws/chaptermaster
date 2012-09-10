package com.sbktws.chaptermaster.testsuite;

import com.sbktws.chaptermaster.Resource;
import com.sbktws.chaptermaster.supplylines.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class SupplyLineTest {

	Inventory[] spinv = new Inventory[2];
	SupplyPoint[] sps = new SupplyPoint[2];
	SupplyLine sl = new SupplyLine(sps);

	@Test
	public void TestSupplyLines() {

		Inventory inv = new Inventory();
		spinv[0] = new Inventory();
		spinv[1] = new Inventory();
		sps[0] = new SupplyPoint(2);
		sps[1] = new SupplyPoint(2);

		spinv[0].setCargo(Resource.MANPOWER, 200);
		spinv[0].setCargo(Resource.VEHICLES, 200);
		spinv[1].setCargo(Resource.MANPOWER, 200);
		spinv[1].setCargo(Resource.VEHICLES, 200);

		sps[0].localInv = spinv[0];
		sps[1].localInv = spinv[1];

		sps[0].addCommand(SupplyLineCommand.LOADXY, Resource.MANPOWER, 100);
		sps[0].addCommand(SupplyLineCommand.LOADXY, Resource.VEHICLES, 100);
		sps[1].addCommand(SupplyLineCommand.DROPXY, Resource.MANPOWER, 100);
		sps[1].addCommand(SupplyLineCommand.DROPXY, Resource.VEHICLES, 100);

		inv = sl.next().activate(inv);
		inv = sl.next().activate(inv);

		assertEquals(0, inv.getCargo(Resource.MANPOWER));
		assertEquals(0, inv.getCargo(Resource.VEHICLES));

		assertEquals(100, spinv[0].getCargo(Resource.MANPOWER));
		assertEquals(100, spinv[0].getCargo(Resource.VEHICLES));

		assertEquals(300, spinv[1].getCargo(Resource.MANPOWER));
		assertEquals(300, spinv[1].getCargo(Resource.VEHICLES));

		inv = sl.next().activate(inv);
		inv = sl.next().activate(inv);

		assertEquals(0, inv.getCargo(Resource.MANPOWER));
		assertEquals(0, inv.getCargo(Resource.VEHICLES));

		assertEquals(0, spinv[0].getCargo(Resource.MANPOWER));
		assertEquals(0, spinv[0].getCargo(Resource.VEHICLES));

		assertEquals(400, spinv[1].getCargo(Resource.MANPOWER));
		assertEquals(400, spinv[1].getCargo(Resource.VEHICLES));
	}

}
