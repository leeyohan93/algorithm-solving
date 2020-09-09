package programmers.stackandqueue.stock;

public class StockPrice {
    private final int price;

    public StockPrice(final int price) {
        this.price = price;
    }

    public boolean isDrop(final StockPrice other) {
        return this.price > other.price;
    }
}
