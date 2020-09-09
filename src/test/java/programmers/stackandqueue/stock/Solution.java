package programmers.stackandqueue.stock;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    @Test
    void solve() {
        int[] prices = {1, 2, 3, 2, 3};
        StockPrices stockPrices = StockPrices.from(prices);
        int[] result = stockPrices.getNoneDropTimes();

        assertThat(result).containsExactly(4, 3, 1, 1, 0);
    }
}
