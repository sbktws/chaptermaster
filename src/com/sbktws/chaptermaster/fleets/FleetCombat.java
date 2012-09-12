package com.sbktws.chaptermaster.fleets;

import java.util.HashMap;
import java.util.Random;

/**
 * Handles combats between fleets. Resolves targets pseudorandomly, then fires until one side is
 * defeated. Defenders always fire first.
 * 
 * @author James
 * 
 */
public class FleetCombat {

	/**
	 * Random generator for the combat component to utilise.
	 */
	private Random r;

	/**
	 * The attacking fleet in this engagement.
	 */
	public final Fleet attacker;
	/**
	 * The defending fleet in this engagement. The defender has a significant advantage.
	 */
	public final Fleet defender;

	/**
	 * The number of kills made this battle (for reporting purposes).
	 */
	private Integer killOrder = 1;
	/**
	 * The turn of the battle.
	 */
	private Integer turn = 0;

	/**
	 * keys is at least as long as attacker + defender. Stores null as a value for a destroyed or
	 * unassigned target.
	 */
	private HashMap<Ship, Ship> targeting;

	/**
	 * @param attacker
	 *            The attacking fleet.
	 * @param defender
	 *            The defending fleet.
	 */
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

	/**
	 * Start and run the battle, reporting ship destructions.
	 */
	public void DoBattle() {
		int dstart = defender.GetSize(), astart = attacker.GetSize();

		while (attacker.GetSize() > 0 && defender.GetSize() > 0) {
			++turn;

			for (Ship s2 : defender.GetShips()) {
				if (s2 != null) {
					s2.ResetShields();
					targeting.put(s2, Attack(s2, targeting.get(s2), false));
				}
			}

			for (Ship s1 : attacker.GetShips()) {
				if (s1 != null) {
					s1.ResetShields();
					targeting.put(s1, Attack(s1, targeting.get(s1), true));
				}
			}
		}

		dstart -= defender.GetSize();
		astart -= attacker.GetSize();
		boolean defenderWon = (defender.GetSize() != 0);
		System.out.println("Battle Report: Attacker lost " + astart + "/"
				+ attacker.GetShips().length + " ships, defender lost " + dstart + "/"
				+ defender.GetShips().length + " ships.");
		System.out.println("Battle Report: The " + (defenderWon ? "defenders" : "attackers")
				+ " won.");
	}

	/**
	 * @param shooter
	 *            The ship doing the attacking.
	 * @param isAttacker
	 *            Is the ship on the attacking team?
	 * @return A Ship on the other team, or null.
	 */
	private Ship ChooseTarget(Ship shooter, boolean isAttacker) {
		if (isAttacker) {
			return defender.GetSize() > 0 ? defender.GetShips()[r.nextInt(defender.GetSize())]
					: null;
		} else {
			return attacker.GetSize() > 0 ? attacker.GetShips()[r.nextInt(attacker.GetSize())]
					: null;
		}
	}

	/**
	 * @param shooter
	 *            Ship doing the attacking.
	 * @param target
	 *            Its target.
	 * @param isAttacker
	 *            Is this ship on the attacking team?
	 * @return A modified reference to target.
	 */
	private Ship Attack(Ship shooter, Ship target, boolean isAttacker) {

		for (ShipWeapon w : shooter.weapons) {
			if (target == null) {
				target = ChooseTarget(shooter, isAttacker);
				if (target == null) {
					return null;
				}
			}

			for (int i = 0; i < w.shots; i++) {
				if (r.nextInt(7) + 1 >= shooter.data.accuracy) {
					if (w.penetration <= target.data.armour
							|| r.nextInt(7) + 1 >= shooter.data.armour) {
						if (target.currentShields > 0) {
							--target.currentShields;
						} else {
							--target.currentHull;

							if (target.currentHull == 0) {
								System.out.println("A ship of type " + target.data.toString()
										+ " was destroyed! (Kill " + this.killOrder.toString()
										+ " on turn " + this.turn.toString() + ")");
								++killOrder;

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
