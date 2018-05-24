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
	public String Specialization() {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + EquipmentLvl;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((Specialization == null) ? 0 : Specialization.hashCode());
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
		AbstractSurvival other = (AbstractSurvival) obj;
		if (EquipmentLvl != other.EquipmentLvl)
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Specialization == null) {
			if (other.Specialization != null)
				return false;
		} else if (!Specialization.equals(other.Specialization))
			return false;
		return true;
	}

	
	
	
	
}
