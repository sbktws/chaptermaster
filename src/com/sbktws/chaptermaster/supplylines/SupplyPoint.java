package com.sbktws.chaptermaster.supplylines;

import com.sbktws.chaptermaster.Resource;
import com.sbktws.chaptermaster.world.Location;

/**
 * Represents a point on a SupplyLine.
 * 
 * @author James
 */
public class SupplyPoint {

	/**
	 * Stores a particular command and its variables.
	 * 
	 * @author James
	 */
	private class SupplyCommand {
		public SupplyLineCommand command;
		public Resource res;
		public int amount;
	}

	/**
	 * Position in the SupplyCommand array.
	 */
	private int current;

	/**
	 * Where is this SupplyPoint?
	 */
	public final Location loc;
	/**
	 * The commands to perform at this point.
	 */
	public SupplyCommand[] commands;

	/**
	 * A reference to the local inventory (the planet, base, etc.)
	 */
	public Inventory localInv;

	public SupplyPoint(int numCommands, Location loc) {
		commands = new SupplyCommand[numCommands];
		current = 0;

		this.loc = loc;
	}

	/**
	 * Valid only for DUMP.
	 * 
	 * @param command
	 *            The command to add.
	 */
	public void addCommand(SupplyLineCommand command) {
		assert (command == SupplyLineCommand.DUMP);

		commands[current] = new SupplyCommand();
		commands[current].command = command;

		++current;
	}

	/**
	 * Valid for FILL and EMPTY
	 * 
	 * @param command
	 *            The command to add.
	 * @param res
	 *            The cargo type to move.
	 */
	public void addCommand(SupplyLineCommand command, Resource res) {
		assert (command == SupplyLineCommand.FILLY || command == SupplyLineCommand.EMPTYY);

		commands[current] = new SupplyCommand();
		commands[current].command = command;
		commands[current].res = res;

		++current;
	}

	/**
	 * Valid for LOADXY and DROPXY
	 * 
	 * @param command
	 *            The command to add.
	 * @param res
	 *            The cargo type to move.
	 * @param amount
	 *            How much to transfer.
	 */
	public void addCommand(SupplyLineCommand command, Resource res, int amount) {
		assert (command == SupplyLineCommand.LOADXY || command == SupplyLineCommand.DROPXY);

		commands[current] = new SupplyCommand();
		commands[current].command = command;
		commands[current].amount = amount;
		commands[current].res = res;

		++current;
	}

	/**
	 * @param transfer
	 *            A list of two Inventories. The first should be the cargo ship and the second the
	 *            dock/planet.
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
