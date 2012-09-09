package com.sbktws.chaptermaster.supplylines;

import com.sbktws.chaptermaster.Resource;
import com.sbktws.chaptermaster.world.Location;

public class SupplyPoint {

	private class SupplyCommand {
		public SupplyLineCommand command;
		public Resource res;
		public int amount;
	}

	private int current;

	public Location loc;
	public SupplyCommand[] commands;

	public Inventory localInv;

	public SupplyPoint(int numCommands) {
		commands = new SupplyCommand[numCommands];
		current = 0;
	}

	public boolean addCommand(SupplyLineCommand command) {
		assert (command == SupplyLineCommand.DUMP);

		commands[current] = new SupplyCommand();
		commands[current].command = command;
		
		++current;
		return true;
	}

	public boolean addCommand(SupplyLineCommand command, int amount) {
		assert (command == SupplyLineCommand.FILLY || command == SupplyLineCommand.EMPTYY);

		
		commands[current] = new SupplyCommand();
		commands[current].command = command;
		commands[current].amount = amount;
		
		++current;
		return true;
	}

	public boolean addCommand(SupplyLineCommand command, Resource res,
			int amount) {
		assert (command == SupplyLineCommand.LOADXY || command == SupplyLineCommand.DROPXY);

		commands[current] = new SupplyCommand();
		commands[current].command = command;
		commands[current].amount = amount;
		commands[current].res = res;
		
		++current;
		return true;
	}

	/**
	 * @param transfer
	 *            A list of two Inventories. The first should be the cargo ship
	 *            and the second the dock/planet.
	 */
	public Inventory activate(Inventory transfer) {
		for (SupplyCommand sc : commands) {
			switch (sc.command) {
			case DUMP:
				for (Resource r : Resource.values()) {
					localInv = transfer.move(r, transfer.getCargo(r), localInv);
				}
				break;
			case LOADXY:
				transfer = localInv.move(sc.res, sc.amount, transfer);
				break;
			case DROPXY:
				localInv = transfer.move(sc.res, sc.amount, localInv);
				break;
			case FILLY:
				transfer = localInv.move(sc.res, localInv.getCargo(sc.res), transfer);
				break;
			case EMPTYY:
				localInv = transfer.move(sc.res, transfer.getCargo(sc.res), localInv);
				break;
			}
		}
		return transfer;
	}
}
