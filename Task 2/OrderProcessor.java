public class OrderProcessor {
    // Method
    public void placeOrder(ShoppingCart cart){
        System.out.println("--------------------------Receipt---------------------------");

        for(Product product:cart.getProducts()){
            String formattedName = String.format("%-50s", product.getName());
            String formattedPrice = String.format("%10s", "$" + product.getPrice());
            System.out.println(formattedName + formattedPrice);
        }

        System.out.println("\n" + " ".repeat(38) + "Total Price: $" + cart.getTotalCost());
    }
}
