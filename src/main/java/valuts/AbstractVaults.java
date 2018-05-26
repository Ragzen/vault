package valuts;

import java.security.Guard;
import java.util.ArrayList;
import java.util.List;

import survivals.CombatUnit;
import survivals.Guardian;
import survivals.Settler;
import survivals.Survival;

public class AbstractVaults implements Vault {

	private int ID;

	private int Capacity;

	private String Location;

	private int DefenseLvl;

	private int Food;

	private int Water;

	private List<CombatUnit> offense = new ArrayList<>();

	private List<Guardian> defense = new ArrayList<>();

	private List<Settler> resource = new ArrayList<>();

	private int Population = 0;

	public AbstractVaults(int id, int cap, String loc, int defLvl, int food, int water) {
		this.ID = id;
		this.Capacity = cap;
		this.Location = loc;
		this.DefenseLvl = defLvl;
		this.Food = food;
		this.Water = water;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see valuts.Vault#getID()
	 */
	public int getID() {
		return this.ID;
	}

	public void addOffense(CombatUnit unit) {
		if (!isFull()) {
			offense.add(unit);
			Population++;
		}
	}

	public void addDefense(Guardian unit) {
		if (!isFull()) {
			defense.add(unit);
			Population++;
		}
	}

	public void addResource(Settler unit) {
		if (!isFull()) {
			resource.add(unit);
			Food += unit.getFood();
			Water += unit.getWater();
			Population++;
		}
	}

	public void CalculateOverallDefense() {
		int def = 0;
		int off = 0;
		for (Guardian guardian : defense) {
			def += guardian.getEquipmentLvl();
		}
		for (CombatUnit combatUnit : offense) {
			off += combatUnit.getEquipmentLvl();
		}
		addDefenseLvl(def + off);
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(int iD) {
		this.ID = iD;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see valuts.Vault#getCapacity()
	 */
	public int getCapacity() {
		return this.Capacity;
	}

	public boolean isFull() {
		if (Population < Capacity) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see valuts.Vault#getDefenseLvl()
	 */
	public int getDefenseLvl() {
		return this.DefenseLvl;
	}

	public void addDefenseLvl(int dL) {
		this.DefenseLvl += dL;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see valuts.Vault#getLocation()
	 */
	public String getLocation() {
		return this.Location;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see valuts.Vault#isWater()
	 */
	public boolean isWater() {
		if (this.Water != 0) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see valuts.Vault#isFood()
	 */
	public boolean isFood() {
		if (this.Food != 0) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see valuts.Vault#isCapative()
	 */
	public boolean isCapative() {
		if (this.DefenseLvl > 0 || this.Food > 0 || this.Water > 0) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractVaults other = (AbstractVaults) obj;
		if (ID != other.ID)
			return false;
		return true;
	}

}
