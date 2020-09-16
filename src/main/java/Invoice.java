import java.util.*;

public class Invoice {
    public final Customer customer;
    public final List<Order> orders = new ArrayList<>();

    public Invoice(Customer customer) {
        this.customer = customer;
    }

}
