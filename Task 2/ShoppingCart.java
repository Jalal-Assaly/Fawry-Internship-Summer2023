import java.math.BigDecimal;
import java.util.ArrayList;

public class ShoppingCart {
    // Fields & Attributes
    final ArrayList<Product> products = new ArrayList<>();
    private BigDecimal totalCost = BigDecimal.ZERO;

    // Getters
    public BigDecimal getTotalCost(){ return totalCost; }
    public ArrayList<Product> getProducts(){ return products; }

    // Methods
    public void addItem(Product product){
        products.add(product);
    }
    public void removeItem(Product product){
        products.remove(product);
    }
    public BigDecimal calculateTotalCost(){
        for(Product product:products){
            totalCost = totalCost.add(product.getPrice());
        }

        return totalCost;
    }
}
