import java.util.ArrayList;
import java.util.List;

public class Product {
    private String productName;
    private float price;
    private List<Order> productOrders;

    public Product(String productName, float price) {
        this.productName = productName;
        this.price = price;
        productOrders = new ArrayList<>();
    }

    public void addToOrder(Order newOrder) {
        if (!productOrders.contains(newOrder)) {
            productOrders.add(newOrder);

            newOrder.setProduct(this);
        }
    }

    public void removeOrder(Order oldOrder) {
        productOrders.remove(oldOrder);
        oldOrder.removeProduct();
    }

    public String getProductName() {
        return productName;
    }

    public float getPrice() {
        return price;
    }
}
