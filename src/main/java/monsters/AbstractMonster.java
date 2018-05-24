package monsters;

public abstract class AbstractMonster implements Monster {

	private String Name;

	private String Location;

	private int DamageLvl;

	private int Number;

	private int DangerLvl;

	public AbstractMonster(String name, String location, int number, int damageLvl) {
		Name = name;
		Location = location;
		DamageLvl = damageLvl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see monsters.Monster#getName()
	 */
	public String getName() {
		return Name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see monsters.Monster#Location()
	 */
	public String Location() {
		return Location;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see monsters.Monster#DamageLvl()
	 */
	public int getDamageLvl() {
		return DamageLvl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see monsters.Monster#getNumber()
	 */
	public int getNumber() {
		return Number;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see monsters.Monster#setDangerLvl()
	 */
	public void setDangerLvl() {
		DangerLvl = DamageLvl * Number;
	}
	
	public boolean isDangerous() {
		if(DamageLvl>0) {
		return true;
		}
		return false;
	}

}
