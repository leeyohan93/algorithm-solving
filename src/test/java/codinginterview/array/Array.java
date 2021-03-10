package codinginterview.array;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

// 출처 : https://www.inflearn.com/course/%EA%B0%9C%EB%B0%9C%EC%9E%90-%EC%9D%B8%ED%84%B0%EB%B7%B0
public class Array {

    /*
     * 배열 문제 1
     * 숫자로 구성된 배열이 주어졌을 때 그 배열에 중복된 숫자가 있는지 확인하는 함수를 작성하라.
     * 중복된 숫자가 있다면 true 없다면 false
     *
     * 미션: 배열과 리스트 자료 구조에 대해 학습하세요.
     */

    @Test
    void solution1() {
        // given
        int[] numbers = {1, 5, 3, 4, 1};

        // when
        Arrays.sort(numbers); // // O(NlogN), O(logN)
        boolean result = false;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                result = true;
                break;
            }
        }

        // then
        assertThat(result).isTrue();
    }

    /*
     * 배열 문제 2
     * 주어진 문자열을 거꾸로 뒤집은 문자열을 만드는 함수를 작성하라.
     *
     * 미션: String, StringBuilder, StringBuffer 등에 대해 학습하세요.
     */
    @CsvSource(value = "hello")
    @ParameterizedTest
    void solution2(String message) {
        // when
        char[] messages = message.toCharArray();
        for (int i = 0; i < messages.length / 2; i++) {
            char temp = messages[i];
            messages[i] = messages[messages.length - 1 - i];
            messages[messages.length - 1 - i] = temp;
        }
        // then / O(n), O(1)
        assertThat(messages).containsExactly('o', 'l', 'l', 'e', 'h');

        // when
        StringBuilder messageBuilder = new StringBuilder(message);
        String result = messageBuilder.reverse().toString();
        // then / O(n), O(n)
        assertThat(result).isEqualTo("olleh");
    }

    /*
     * 배열 문제 3
     * 숫자로 구성된 배열 numbers 와 target 숫자 하나가 주어졌을 때 numbers 배열에 들어있는 두 수를 더해
     * target 숫자를 만들 수있는 인덱스 두개를 찾는 함수를 작성하라.
     *
     * 예) number = [2, 3, 5, 7] target = 8, 8을 만들 수 있는 3과 5의 인덱스인 1, 2를 리턴해야 한다.
     *
     * numbers 배열에 중복되는 숫자는 없으며 target 숫자를 만들 수 있는 조합은 하나 뿐이라고 가정해도 좋다.
     *
     * 미션
     * 숫자로 구성된 배열 numbers와 target 숫자 하나가 주어졌을 때
     * numbers 배열에 들어있는 수 세개를 더해서 target 숫자를 만들 수 있는 인덱스를 찾는 함수를 작성하라.
     * 예) numbers = [2, 3, 5, 7] target = 7, 7을 만들 수 있는 2, 3, 5의 인덱스인 0, 1, 2를 배열로 리턴해야 한다.
     */
    @Test
    void solution3() {
        // given
        int[] numbers = {2, 3, 5, 7};
        int target = 8;
        int target2 = 10;

        // when
        int[] result = null;
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            numberMap.put(numbers[i], i);

            int numberToFind = target - numbers[i];
            if (numberMap.containsKey(numberToFind) && numberMap.get(numberToFind) != i) {
                result = new int[]{i, numberMap.get(numberToFind)};
            }
        }

        // then O(n), O(n)
        assertThat(result).contains(1, 2);

        // when
        int[] result2 = null;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int numberToFind = target2 - numbers[i] - numbers[j];

                if (numberMap.containsKey(numberToFind)) {
                    result2 = new int[]{i, j, numberMap.get(numberToFind)};
                }
            }
        }

        // then
        assertThat(result2).contains(0, 1, 2);
    }

    /*
     * 배열 문제 4
     * 1부터 100까지의 숫자 중에 50개의 랜덤한 숫자가 들어있는 배열이 있다. 이 배열을 O(n)의 시간복잡도로 정렬하라.
     */
    @Test
    void solution4() {
        // given
        int[] numbers = {1, 5, 10, 22, 4, 9, 8};

        // when
        boolean[] booleans = new boolean[100];
        for (int number : numbers) {
            booleans[number] = true;
        }

        int index = 0;
        for (int i = 0; i < booleans.length; i++) {
            if (booleans[i]) {
                numbers[index++] = i;
            }
        }

        // then
        assertThat(numbers).containsExactly(1, 4, 5, 8, 9, 10, 22);
    }
}
