@FunctionalInterface
interface LineHandler<T> {
    T handleLine(String[] parts);
}
