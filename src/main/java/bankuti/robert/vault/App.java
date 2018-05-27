package bankuti.robert.vault;

import domains.VaultDomain;
import org.hibernate.query.Query;
import services.DataBaseService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class App {
    private static DataBaseService service;
    
    public static void main(String[] args) throws IOException, SQLException {
        DataBaseInit.executeScriptUsingStatement();
        service = DataBaseService.getInstance();
    
        /**
         * INSERT INTO
         */
        // lényegében létrehozod és lemented :)
        VaultDomain data = insert();
    
        /**
         * DELETE
         */
        // vagy ID-t adsz át
        service.deleteById(VaultDomain.class, data.getId());
        
        // vagy egy komplett objektumot
        data = insert();
        service.delete(data);
        
        // 3. lehetőség az SQL hívás például.
    
        /**
         * SELECT
         */
        // lekéred ID-val
        data = service.selectById(VaultDomain.class, 3);
        System.out.println(data.getLocation());
        
        // vagy: https://www.mkyong.com/hibernate/hibernate-query-examples-hql/
        Query query = service.getSession().createQuery(
            "FROM VaultDomain VD WHERE VD.capacity > :zsiraf",
            VaultDomain.class
        );
        query.setParameter("zsiraf", 0);
        List<VaultDomain> list = query.list();
        for(VaultDomain vaultDomain : list) {
            System.out.println(vaultDomain.getLocation());
        }
        
    
        // UPDATE
        // Lekéred SELECT-tel, módosítod és vissza mented -.-
        data = service.selectById(VaultDomain.class, 3);
        data.setCapacity(200);
        service.save(data);
        
        // vagy: https://www.mkyong.com/hibernate/hibernate-query-examples-hql/
        
        
        // AFTER ALL
        service.shutdown();
    }
    
    private static VaultDomain insert() {
        VaultDomain data = new VaultDomain();
        data.setLocation("teszt");
        data.setCapacity(100);
        data.setDefenseLvl(100);
        data.setFoodCap(100);
        data.setWaterCap(100);
        service.save(data); // kész :)
        System.out.println("Itt meg már lesz ID-ja is: " + data.getId());
        
        return data;
    }
}
