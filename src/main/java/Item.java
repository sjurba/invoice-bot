public class Item {

    public final String id;
    public final String name;
    public final int price;


    public Item(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Item(String[] strings) {
        this(strings[0], strings[1], Integer.parseInt(strings[2]));
    }
}
