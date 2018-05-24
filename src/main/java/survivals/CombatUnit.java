package survivals;

public class CombatUnit extends AbstractSurvival {

	private int WeaponStrenght;

	public CombatUnit(String name, String specialization, int weaponStrenght) {
		super(name, specialization);
		WeaponStrenght = weaponStrenght;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see survivals.AbstractSurvival#haveWeapon()
	 */
	@Override
	public boolean haveWeapon() {
		return true;
	}

	/* (non-Javadoc)
	 * @see survivals.AbstractSurvival#setEquipmentLvl()
	 */
	@Override
	public void setEquipmentLvl() {
		EquipmentLvl+=(WeaponStrenght*1.5);
	}
	
	

}
