package programmers.stackandqueue.printer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    @Test
    void solve() {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        Printer printer = Printer.from(priorities);
        int printOrder = printer.getPrintOrder(location);

        assertThat(printOrder).isEqualTo(5);
    }
}
