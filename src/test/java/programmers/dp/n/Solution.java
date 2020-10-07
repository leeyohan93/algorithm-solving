package programmers.dp.n;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    @Test
    void solve() {
        int N = 5;
        int number = 12;

        Queue<CreatableNumber> queue = new LinkedList<>();
        queue.add(new CreatableNumber(1, N, N));
        int answer = 0;

        while (!queue.isEmpty()) {
            CreatableNumber creatableNumber = queue.poll();

            if (creatableNumber.isEqualNumber(number)) {
                answer = creatableNumber.getIndex();
                break;
            }

            queue.add(creatableNumber.add());

            CreatableNumber subtract = creatableNumber.subtract();
            if (subtract.isRange()) {
                queue.add(subtract);
            }

            CreatableNumber divide = creatableNumber.divide();
            if (divide.isRange()) {
                queue.add(divide);
            }

            CreatableNumber multiply = creatableNumber.multiply();
            if (multiply.isRange()) {
                queue.add(multiply);
            }

            CreatableNumber append = creatableNumber.append();
            if (append.isRange()) {
                queue.add(append);
            }
        }

        assertThat(answer).isEqualTo(4);
    }
}
