package programmers.greedy.gymsuit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    @Test
    void solve() {
        int n = 10;
        int[] lost = {1, 3,5};
        int[] reserve = {2, 7, 8};

        Students students = Students.of(n, lost, reserve);
        int playCount = students.getPlayCount();

        assertThat(playCount).isEqualTo(5);
    }
}
