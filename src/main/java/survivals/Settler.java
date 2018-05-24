package survivals;

public class Settler extends AbstractSurvival{
	
	private int FoodQuantity;
	
	private int WaterQuantity;

	public Settler(String name, String specialization, int food,int water) {
		super(name, specialization);
		FoodQuantity=food;
		WaterQuantity=water;
	}

	/* (non-Javadoc)
	 * @see survivals.AbstractSurvival#isSetler()
	 */
	@Override
	public boolean isSetler() {
		return true;
	}

	/* (non-Javadoc)
	 * @see survivals.AbstractSurvival#setEquipmentLvl()
	 */
	@Override
	public void setEquipmentLvl() {
		EquipmentLvl=0;
	}
	
	public int getFood() {
		return FoodQuantity;
	}
	
	public int getWater() {
		return WaterQuantity;
	}

}
