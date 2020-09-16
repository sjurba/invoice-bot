import java.io.*;
import java.util.*;
import java.util.stream.*;

public class InvoiceBot {

    private final File folder;
    private final Printer printer;

    public InvoiceBot(File folder, Printer printer) {
        this.folder = folder;
        this.printer = printer;
    }

    public void parseData() throws IOException {
        Map<String, Customer> customers = parseFile("Customers.csv", Customer::new).collect(Collectors.toMap(customer -> customer.id, customer -> customer));
        Map<String, Item> items = parseFile("Items.csv", Item::new).collect(Collectors.toMap(item -> item.id, item -> item));
        var orders = parseFile("Orders.csv", Order::new).collect(Collectors.toList());
        for (var order : orders) {
            Customer customer = customers.get(order.customerId);
            customer.addOrderLine(items.get(order.itemId), order.quantity);
        }
        printInvoice(customers);
    }

    private void printInvoice(Map<String, Customer> customers) {
        int i = 0;
        boolean found = false;
        for (var customer: customers.values()) {
            if (!customer.hasOrders()) continue;
            found = true;
            printer.print("Order " + i++);
            customer.print(printer);
        }
        if (!found) {
            printer.print("No orders");
        }
    }

    private <T> Stream<T> parseFile(String file, LineParser<T> lineParser) {
        try {
            return new BufferedReader(new FileReader(new File(folder, file)))
                .lines()
                .filter((line)->!line.startsWith("#"))
                .map((line)-> lineParser.parseLine(line.split(";")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FunctionalInterface
    interface LineParser<T> {

        T parseLine(String[] parts);
    }

    public static void main(String[] args) throws Exception {
        //Don't change this function
        new InvoiceBot(new File("src/main/resources/test3"), System.out::println)
            .parseData();
    }

}
