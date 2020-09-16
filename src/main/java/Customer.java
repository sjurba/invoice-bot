import java.util.*;

public class Customer {
    public final String id;
    public final String name;
    public final float discount;
    public final String address;
    private final List<OrderLine> lines = new ArrayList<>();

    public Customer(String id, String name, float discount, String address) {
        this.id = id;
        this.name = name;
        this.discount = discount;
        this.address = address;
    }

    public Customer(String[] strings) {
        this(strings[0], strings[1], Float.parseFloat(strings[2]), strings[3]);
    }

    public void addOrderLine(Item item, int quantity) {
        lines.add(new OrderLine(item, quantity));
    }

    public void print(Printer printer) {
        printer.print("\tCustomer: " + name);
        printer.print("\tShipping address: " + address);
        int total = 0;
        printer.print("\tItems:");
        for(var line: lines) {
            line.print(printer);
            total += line.itemTotal;
        }
        printer.print("\tSum: " + total);
        printer.print("\tDiscount: " + discount + "%");
        printer.print("\tTotal: "+ Math.round(total * (1.0 - discount/100)));
    }

    public boolean hasOrders() {
        return !lines.isEmpty();
    }

    private static class OrderLine{
        private final Item item;
        private final int quantity;
        private final int itemTotal;

        private OrderLine(Item item, int quantity) {
            this.item = item;
            this.quantity = quantity;
            itemTotal = quantity * item.price;
        }

        private void print(Printer printer) {
            printer.print("\t\t" + item.name + ": " + quantity + " á " + item.price + " = " + itemTotal);
        }
    }
}
