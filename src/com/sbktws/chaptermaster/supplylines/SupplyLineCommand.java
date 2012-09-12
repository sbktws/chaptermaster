package com.sbktws.chaptermaster.supplylines;

/**
 * Represents a command at a SupplyPoint. In all definitions, X is an amount and Y is a type.
 * 
 * @author James
 */
public enum SupplyLineCommand {
	/**
	 * Load X of Y.
	 */
	LOADXY,
	/**
	 * Unload X of Y.
	 */
	DROPXY,
	/**
	 * Load all available Y.
	 */
	FILLY,
	/**
	 * Unload all of Y.
	 */
	EMPTYY,
	/**
	 * Unload all of everything.
	 */
	DUMP
}
