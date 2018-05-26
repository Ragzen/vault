package survivals;

public abstract class AbstractSurvival implements Survival{

	private String Name;
	
	private String Specialization;
	
	protected int EquipmentLvl;

	public AbstractSurvival(String name, String specialization) {
		Name = name;
		Specialization = specialization;
		
	}

	/* (non-Javadoc)
	 * @see survivals.Survival#getName()
	 */
	public String getName() {
		return Name;
	}
	/* (non-Javadoc)
	 * @see survivals.Survival#setName(java.lang.String)
	 */
	public void setName(String name) {
		if(name.isEmpty()||name==null) {
			Name="unknown";
		}
		Name=name;
		
	}

	public int getEquipmentLvl() {
		return EquipmentLvl;
	}
	
	
	/* (non-Javadoc)
	 * @see survivals.Survival#setEquipmentLvl()
	 */
	public void setEquipmentLvl() {
	}

	/* (non-Javadoc)
	 * @see survivals.Survival#Specialization()
	 */
	public String getSpecialization() {
		return Specialization;
	}

	/* (non-Javadoc)
	 * @see survivals.Survival#havePowerArmor()
	 */
	public boolean havePowerArmor() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see survivals.Survival#haveWeapon()
	 */
	public boolean haveWeapon() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see survivals.Survival#isSetler()
	 */
	public boolean isSetler() {
		// TODO Auto-generated method stub
		return false;
	}

	

	
	
	
	
}
