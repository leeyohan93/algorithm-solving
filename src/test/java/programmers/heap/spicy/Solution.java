package programmers.heap.spicy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    @Test
    void solve() {
        int[] scoville ={1, 2, 3, 9, 10, 12};
        int k = 7;

        Foods foods = Foods.from(scoville);
        int mixCount = foods.getMixCount(k);

        assertThat(mixCount).isEqualTo(2);
    }
}
