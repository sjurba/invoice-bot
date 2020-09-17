public class CustomerBuilder implements LineHandler<Customer> {
    @Override
    public Customer handleLine(String[] parts) {
        return new Customer(parts);
    }
}
