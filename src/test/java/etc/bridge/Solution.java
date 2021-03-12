package etc.bridge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    @Test
    void test() {
        // given
        String[] numbersInput = {"10", "20", "30", "40", "50", "60", "70"};

        int count = 7;
        List<Integer> numbers = new ArrayList<>();
        for (String numberInput : numbersInput) {
            numbers.add(Integer.parseInt(numberInput));
        }

        int sum = 0;
        int size = numbers.size();
        for (int i = 1; i < size; i++) {
            sum += numbers.get(i);
        }

        if (size % 2 != 0) {
            sum += numbers.get(0);
        }
        System.out.println(sum);
    }
}
