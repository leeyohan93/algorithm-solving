package programmers.stackandqueue.feature;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    @Test
    void solve() {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        Features features = Features.of(progresses, speeds);
        int[] distributes = features.getDistributes();

        assertThat(distributes).containsExactly(1,3,2);
    }
}
