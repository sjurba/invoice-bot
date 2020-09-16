import java.io.*;

public class InvoiceBot {

    private final File folder;
    private final Printer printer;

    public InvoiceBot(File folder, Printer printer) {
        //Don't change this constructor
        this.folder = folder;
        this.printer = printer;
    }

    public void parseData() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(folder, "Orders.csv")));
        boolean foundOrders = false;
        String line;
        while ((line = reader.readLine()) != null) {
            foundOrders = true;
        }
        if (!foundOrders) {
            printer.print("No orders");
        }
    }


    public static void main(String[] args) throws Exception {
        //Don't change this function
        new InvoiceBot(new File("src/main/resources/test3"), System.out::println)
            .parseData();
    }

}
