package domains;

import javax.persistence.*;

@Entity
@Table(name = "vault")
public class VaultDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    
    @Column(name = "capacity")
    private Integer capacity;
    
    @Column(name = "location")
    private String location;
    
    @Column(name = "defenseLvl")
    private Integer defenseLvl;
    
    @Column(name = "waterCap")
    private Integer waterCap;
    
    @Column(name = "foodCap")
    private Integer foodCap;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getCapacity() {
        return capacity;
    }
    
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public Integer getDefenseLvl() {
        return defenseLvl;
    }
    
    public void setDefenseLvl(Integer defenseLvl) {
        this.defenseLvl = defenseLvl;
    }
    
    public Integer getWaterCap() {
        return waterCap;
    }
    
    public void setWaterCap(Integer waterCap) {
        this.waterCap = waterCap;
    }
    
    public Integer getFoodCap() {
        return foodCap;
    }
    
    public void setFoodCap(Integer foodCap) {
        this.foodCap = foodCap;
    }
}
