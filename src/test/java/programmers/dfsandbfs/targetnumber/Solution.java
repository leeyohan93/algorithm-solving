package programmers.dfsandbfs.targetnumber;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    @Test
    void solve() {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        Queue<CreatableNumber> queue = new LinkedList<>();
        int firstNumber = numbers[0];
        queue.add(new CreatableNumber(0, firstNumber));
        queue.add(new CreatableNumber(0, -firstNumber));

        int answer = 0;
        int index = numbers.length - 1;
        while (!queue.isEmpty()) {
            CreatableNumber creatableNumber = queue.poll();
            if (creatableNumber.isFinal(index)) {
                if (creatableNumber.isEqualNumber(target)) {
                    answer++;
                }
                continue;
            }

            int nextIndex = creatableNumber.getIndex() + 1;
            queue.add(creatableNumber.subtract(numbers[nextIndex]));
            queue.add(creatableNumber.add(numbers[nextIndex]));
        }

        assertThat(answer).isEqualTo(5);
    }
}
