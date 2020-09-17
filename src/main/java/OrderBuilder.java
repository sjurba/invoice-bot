public class OrderBuilder implements LineHandler<Order> {
    @Override
    public Order handleLine(String[] parts) {
        return new Order(parts);
    }
}
