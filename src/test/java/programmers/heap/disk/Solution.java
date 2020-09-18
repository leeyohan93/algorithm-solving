package programmers.heap.disk;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    @Test
    void solve() {
        int[][] jobs = {{1, 10}, {3, 3}, {10, 3}};
        Tasks tasks = Tasks.form(jobs);
        int averageTime = tasks.getAverageTime();

        assertThat(averageTime).isEqualTo(9);
    }
}
