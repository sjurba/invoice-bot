import java.io.*;
import java.util.List;

public class InvoiceBot {

    private final File folder;
    private final Printer printer;

    public InvoiceBot(File folder, Printer printer) {
        this.folder = folder;
        this.printer = printer;
    }

    public void parseData() throws IOException {
        List<Customer> customers = new FileParser<>(new CustomerBuilder()).parseFile(folder, "Customers.csv");
        List<Item> items = new FileParser<>(new ItemBuilder()).parseFile(folder, "Items.csv");
        List<Order> orders = new FileParser<>( new OrderBuilder()).parseFile(folder, "Orders.csv");
        for (Customer customer : customers) {
            for (Order order : orders) {
                if (order.customerId.equals(customer.id)) {
                    for (Item item : items) {
                        if (order.itemId.equals(item.id)) {
                            customer.addOrderLine(item, order.quantity);
                        }
                    }
                }
            }
        }
        printInvoice(customers);
    }

    private void printInvoice(List<Customer> customers) {
        int i = 0;
        boolean found = false;
        for (Customer customer: customers) {
            if (!customer.hasOrders()) continue;
            found = true;
            printer.print("Order " + i++);
            customer.print(printer);
        }
        if (!found) {
            printer.print("No orders");
        }
    }

    public static void main(String[] args) throws Exception {
        //Don't change this function
        new InvoiceBot(new File("src/main/resources/test3"), System.out::println)
            .parseData();
    }

}
