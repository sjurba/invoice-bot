public class Order {
    public final String customerId;
    public final String itemId;
    public final int quantity;

    public Order(String customerId, String itemId, int quantity) {
        this.customerId = customerId;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public Order(String[] strings) {
        this(strings[0], strings[1], Integer.parseInt(strings[2]));
    }
}
