
package Beans;

/**
 *
 * @author User
 */
public class HotelCost {
    private int acSingleCost,acDoubleCost,NonAcSingleCost,NonAcDoubleCost;
    
    public int getAcSingleCost() {
        return acSingleCost;
    }

    public void setAcSingleCost(int acSingleCost) {
        this.acSingleCost = acSingleCost;
    }

    public int getAcDoubleCost() {
        return acDoubleCost;
    }

    public void setAcDoubleCost(int acDoubleCost) {
        this.acDoubleCost = acDoubleCost;
    }

    public int getNonAcSingleCost() {
        return NonAcSingleCost;
    }

    public void setNonAcSingleCost(int NonAcSingleCost) {
        this.NonAcSingleCost = NonAcSingleCost;
    }

    public int getNonAcDoubleCost() {
        return NonAcDoubleCost;
    }

    public void setNonAcDoubleCost(int NonAcDoubleCost) {
        this.NonAcDoubleCost = NonAcDoubleCost;
    }

    public HotelCost(int acSingleCost, int acDoubleCost, int NonAcSingleCost, int NonAcDoubleCost) {
        this.acSingleCost = acSingleCost;
        this.acDoubleCost = acDoubleCost;
        this.NonAcSingleCost = NonAcSingleCost;
        this.NonAcDoubleCost = NonAcDoubleCost;
    }
    public HotelCost(){
        
    }
    
}
