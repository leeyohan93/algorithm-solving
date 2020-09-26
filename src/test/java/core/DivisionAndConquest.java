package core;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 분할 정복 알고리즘
 * - 거듭 제곱
 */
public class DivisionAndConquest {


    @ParameterizedTest
    @CsvSource(value = {"2,5,32", "3,4,81", "4,0,1", "4,3,64"})
    void power(int number, int pow, int expected) {
        assertThat(calculatePow(number, pow)).isEqualTo(expected);
    }

    private int calculatePow(int number, int pow) {
        if (pow == 0) {
            return 1;
        }

        int calculatedEvenHarfPow = calculatePow(number, pow / 2);
        int calculatedEvenPow = calculatedEvenHarfPow * calculatedEvenHarfPow;

        if (pow % 2 == 1) {
            return calculatedEvenPow * number;
        }
        return calculatedEvenPow;
    }
}
