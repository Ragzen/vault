package bankuti.robert.vault;

import domains.VaultDomain;
import services.DataBaseService;

public class App {
    public static void main(String[] args) {
        DataBaseService service = DataBaseService.getInstance();
        for (int i = 0; i < 2; i++) {
            VaultDomain address = new VaultDomain();
            address.setCapacity(100);
            address.setLocation("teszt");
            address.setDefenseLvl(100);
            address.setFoodCap(100);
            address.setWaterCap(100);
            service.save(address);
        }
        service.close();
        service.off();
    }
}
