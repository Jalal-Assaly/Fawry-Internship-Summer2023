import java.math.BigDecimal;

public class Product {
    // Fields & Attributes
    private String name;
    private BigDecimal price;

    // Getters
    public String getName() { return name; }
    public BigDecimal getPrice() {
        return price;
    }

    // Constructor
    public Product(String name, BigDecimal price){
        this.name = name;
        this.price = price;
    }
}
