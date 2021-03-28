package baekjoon;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Greedy {

    //// https://www.acmicpc.net/problem/11047
    public static void 동전_0(Scanner scanner) {
        // given
        String input = scanner.nextLine();
        String[] inputs = input.split(" ");
        int moneyTypeCount = Integer.parseInt(inputs[0]);
        int targetMoney = Integer.parseInt(inputs[1]);
        List<Integer> moneyTypes = IntStream.range(0, moneyTypeCount)
                .map(index -> Integer.parseInt(scanner.nextLine()))
                .boxed()
                .collect(Collectors.toList());
        Collections.reverse(moneyTypes);

        // when
        int moneyCount = 0;
        for (Integer moneyType : moneyTypes) {
            if (targetMoney >= moneyType) {
                moneyCount += targetMoney / moneyType;
                targetMoney = targetMoney % moneyType;
            }
        }

        // then
        System.out.println(moneyCount);
    }
}
