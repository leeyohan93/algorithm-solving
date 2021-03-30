package codingtestbook;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Greedy {

    static void 큰_수의_법칙() {
        // given
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int K = Integer.parseInt(inputs[2]);

        String[] inputNumbers = scanner.nextLine().split(" ");

        List<Integer> numbers = Arrays.stream(inputNumbers)
                .map(Integer::parseInt)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        Integer first = numbers.get(0);
        Integer second = numbers.get(1);

        // v2
        int firstCount = (M / (K + 1)) * K + M % (K + 1);
        int secondCount = M - firstCount;

        int sum2 = first * firstCount + second * secondCount;

        // v1
        int sum = 0;
        while (M > 0) {
            sum += first * K;
            M -= K;
            if (M != 0) {
                sum += second;
                M -= 1;
            }
        }

        // then
        System.out.println(sum);
        System.out.println(sum2);
    }


    static void 숫자_카드_게임() {
        // given
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int result = 0;

        // when
        for (int i = 0; i < n; i++) {
            int minNumber = 10001;
            for (int j = 0; j < m; j++) {
                minNumber = Math.min(minNumber, scanner.nextInt());
            }
            result = Math.max(result, minNumber);
        }

        // then
        System.out.println(result);
    }
}
