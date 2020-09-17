public class ItemBuilder implements LineHandler<Item> {
    @Override
    public Item handleLine(String[] parts) {
        return new Item(parts);
    }
}
