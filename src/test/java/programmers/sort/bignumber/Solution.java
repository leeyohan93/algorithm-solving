package programmers.sort.bignumber;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void solve() {
        int[] numbers = {131, 13,33};
        AppendNumbers appendNumbers = AppendNumbers.from(numbers);
        String appendedNumber = appendNumbers.append();

        System.out.println(appendedNumber);
    }
}
