package programmers.stackandqueue.stock;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;

public class StockPrices {
    private final List<StockPrice> stockPrices;

    public static StockPrices from(int[] prices) {
        return Arrays.stream(prices)
                .mapToObj(StockPrice::new)
                .collect(collectingAndThen(Collectors.toList(), StockPrices::new));
    }

    public StockPrices(final List<StockPrice> stockPrices) {
        this.stockPrices = new ArrayList<>(Collections.unmodifiableList(stockPrices));
    }

    public int[] getNoneDropTimes() {
        int size = stockPrices.size();
        return IntStream.range(0, size)
                .map(this::getNoneDropTime)
                .toArray();
    }

    private int getNoneDropTime(final int startIndex) {
        int size = stockPrices.size();
        int noneDropTime = 0;
        for (int i = startIndex + 1; i < size; i++) {
            noneDropTime++;

            StockPrice standardStockPrice = stockPrices.get(startIndex);
            StockPrice changedStockPrice = stockPrices.get(i);
            if (standardStockPrice.isDrop(changedStockPrice)) {
                return noneDropTime;
            }
        }
        return noneDropTime;
    }
}
