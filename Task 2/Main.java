import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        // Create Sample Products
        Product p1 = new Product("Galaxy S21", BigDecimal.valueOf(20000).
                setScale(2, RoundingMode.CEILING));
        Product p2 = new Product("Black Ink Pen 0.7mm", BigDecimal.valueOf(15.05)
                .setScale(2, RoundingMode.CEILING));
        Product p3 = new Product("Notebook A4 - 250 pages", BigDecimal.valueOf(45.55)
                .setScale(2, RoundingMode.CEILING));
        Product p4 = new Product("\"Atomic Habits\" by James Clear - Penguin House", BigDecimal.valueOf(299.99)
                .setScale(2, RoundingMode.CEILING));
        
        // Create Shopping Cart
        ShoppingCart myCart = new ShoppingCart();
        
        // Add products to cart
        myCart.addItem(p1);
        myCart.addItem(p2);
        myCart.addItem(p3);
        myCart.addItem(p4);
        
        // Display total cost
        System.out.println("\n" + "Shopping Cart Total Cost: " + myCart.calculateTotalCost() + "\n");
        
        // Place Order
        OrderProcessor myOrder = new OrderProcessor();
        myOrder.placeOrder(myCart);
    }
}