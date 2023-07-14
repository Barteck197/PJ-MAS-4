import java.util.ArrayList;
import java.util.List;

public class Client {
    private static int globalClientID = 0;
    private int clientID;
    private String clientName;
    private List<Order> clientOrders;

    public Client(String clientName) {
        this.clientName = clientName;
        this.clientID = ++globalClientID;
        clientOrders = new ArrayList<>();
    }

    public void addOrder(Order newOrder) {
        if (!clientOrders.contains(newOrder)) {
            clientOrders.add(newOrder);

            newOrder.setClient(this);
        }
    }

    public void removeOrder(Order oldOrder) {
        clientOrders.remove(oldOrder);
        oldOrder.removeClient();
    }

    public int getClientID() {
        return clientID;
    }

    public String getClientName() {
        return clientName;
    }
}
