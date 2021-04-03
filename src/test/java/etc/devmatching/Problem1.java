package etc.devmatching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Problem1 {

    @DisplayName("")
    @Test
    void test() {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        int originCount = 0;
        int expectedCount = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                expectedCount++;
                continue;
            }
            for (int win_num : win_nums) {
                if (lotto == win_num) {
                    originCount++;
                    expectedCount++;
                }
            }
        }

        int[] ints = {getRank(expectedCount), getRank(originCount)};

        System.out.println(ints);
    }

    private int getRank(int count) {
        int rank = 7 - count;
        return Math.min(rank, 6);
    }
}
