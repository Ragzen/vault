package valuts;

public class AbstractVaults implements Vault {

	private int ID;

	private int Capacity;

	private String Location;

	private int DefenseLvl;

	private int isthereFood;

	private int isthereWater;

	public AbstractVaults(int id, int cap, String loc, int defLvl, int food, int water) {
		this.ID = id;
		this.Capacity = cap;
		this.Location = loc;
		this.DefenseLvl = defLvl;
		this.isthereFood = food;
		this.isthereWater = water;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see valuts.Vault#getID()
	 */
	public int getID() {
		return this.ID;
	}

	
	/**
	 * @param iD the iD to set
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see valuts.Vault#getDefenseLvl()
	 */
	public int getDefenseLvl() {
		return this.DefenseLvl;
	}

	public void setDefenseLvl(int dL) {
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
		if (this.isthereWater != 0) {
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
		if (this.isthereFood != 0) {
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
		if (this.DefenseLvl > 0 || this.isthereFood != 0 || this.isthereWater != 0) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Capacity;
		result = prime * result + DefenseLvl;
		result = prime * result + ID;
		result = prime * result + ((Location == null) ? 0 : Location.hashCode());
		result = prime * result + isthereFood;
		result = prime * result + isthereWater;
		return result;
	}

	/* (non-Javadoc)
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
		if (Capacity != other.Capacity)
			return false;
		if (DefenseLvl != other.DefenseLvl)
			return false;
		if (ID != other.ID)
			return false;
		if (Location == null) {
			if (other.Location != null)
				return false;
		} else if (!Location.equals(other.Location))
			return false;
		if (isthereFood != other.isthereFood)
			return false;
		if (isthereWater != other.isthereWater)
			return false;
		return true;
	}
	
	

}
