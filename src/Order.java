import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private int orderId;
    private LocalDateTime placedDate;
    private int quantity;

    private Client orderClient;
    private Product orderProduct;

    // Mapa przechowująca już istniejące orderID w powiązaniu z konkretnymi
    // obiektami, których dotyczą.
    private static Map<Integer, Order> existingOrderIds = new HashMap<>();

    // Konstruktor bez tworzenia powiązań
    public Order(int orderId, LocalDateTime placedDate, int quantity) throws Exception {
        if (existingOrderIds.containsKey(orderId)) {
            throw new Exception("Zamówienie o takim ID już istnieje");
        }
        // Dodanie nowego elementu mapy
        existingOrderIds.put(orderId, this);
        setOrderId(orderId);
        setPlacedDate(placedDate);
        setQuantity(quantity);
    }

    // Konstruktor automatycznie tworzący powiązania z klasami Client i Product
    public Order(int orderId, LocalDateTime placedDate, int quantity, Client orderClient, Product orderProduct) throws Exception {
        if (existingOrderIds.containsKey(orderId)) {
            throw new Exception("Zamówienie o takim ID już istnieje");
        }
        // Dodanie nowego elementu mapy
        existingOrderIds.put(orderId, this);
        setOrderId(orderId);
        setPlacedDate(placedDate);
        setQuantity(quantity);

        setClient(orderClient);
        setProduct(orderProduct);

        // Tworzymy połączenie zwrotne
        orderClient.addOrder(this);
        orderProduct.addToOrder(this);
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public static Map<Integer, Order> getExistingOrderIds() {
        return existingOrderIds;
    }

    public LocalDateTime getPlacedDate() {
        return placedDate;
    }

    public void setPlacedDate(LocalDateTime placedDate) {
        this.placedDate = placedDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public Client getOrderClient() {
        return orderClient;
    }

    public void setClient(Client newClient) {
        // Jeśli zamówienie ma przypisanego klienta ...
        if (orderClient != null){
            // ... i jest to inny klient niż "nowy" ...
            if(orderClient != newClient){
                // ... to usuwamy połączenie
                newClient.removeOrder(this);
            }
        }
        orderClient = newClient;
        newClient.addOrder(this);
    }

    public Product getOrderProduct() {
        return orderProduct;
    }

    public void setProduct(Product newProduct) {
        if (orderProduct != null){
            // ... i jest to inny klient niż "nowy" ...
            if(orderProduct != newProduct){
                // ... to usuwamy połączenie
                newProduct.removeOrder(this);
            }
        }
        orderProduct = newProduct;
        newProduct.addToOrder(this);
    }

    public void removeClient(){
        orderClient = null;
    }

    public void removeProduct(){
        orderClient = null;
    }

    public static Order getOrderById(int searchID) {
        return existingOrderIds.get(searchID);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", placedDate=" + placedDate +
                ", quantity=" + quantity +
                '}';
    }
}
