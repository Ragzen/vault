package valuts;

public interface Vault {

	int getID();
	
	void setID(int iD);
	
	int getCapacity();
	
	int getDefenseLvl();
	
	void setDefenseLvl(int dL);
	
	String getLocation();
	
	boolean isWater();
	
	boolean isFood();
	
	boolean isCapative();
	
	
	
}
