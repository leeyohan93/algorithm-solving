package programmers.sort.bignumber;

import org.junit.jupiter.api.Test;

public class Soluction {

    @Test
    void solve() {
        int[] numbers = {3, 9, 34, 5, 30};
        AppendNumbers appendNumbers = AppendNumbers.from(numbers);
        String appendedNumber = appendNumbers.append();

        System.out.println(appendedNumber);
    }
}
