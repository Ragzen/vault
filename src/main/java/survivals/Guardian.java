package survivals;

public class Guardian extends AbstractSurvival{

	private int ArmorIntegrity;
	
	public Guardian(String name, String specialization, int armorIntegrity) {
		super(name, specialization);
		ArmorIntegrity=armorIntegrity;
	}

	/* (non-Javadoc)
	 * @see survivals.AbstractSurvival#havePowerArmor()
	 */
	@Override
	public boolean havePowerArmor() {
		return true;
	}

	/* (non-Javadoc)
	 * @see survivals.AbstractSurvival#setEquipmentLvl()
	 */
	@Override
	public void setEquipmentLvl() {
		EquipmentLvl+=ArmorIntegrity;
	}

	

	
}
