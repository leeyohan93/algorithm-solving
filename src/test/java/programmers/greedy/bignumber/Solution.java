package programmers.greedy.bignumber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    @ParameterizedTest
    @CsvSource(value = {"1924,2,94", "1231234,4,4332", "4177252841,6,877544"})
    void solve(long number, int k, int expected) {
        List<String> numbers = new ArrayList<>();
        int length = String.valueOf(number).length();
        for (int i = 0; i < length; i++) {
            numbers.add(String.valueOf(number % 10));
            number = number / 10;
        }
        String result = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .limit(k)
                .collect(Collectors.joining());
        assertThat(Integer.parseInt(result)).isEqualTo(expected);
    }
}
