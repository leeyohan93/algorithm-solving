package baekjoon.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem11399 {

    // https://www.acmicpc.net/problem/11399
    public static void main(String[] args) {
        // given
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(scanner.nextInt());
        }
        Collections.sort(numbers);

        // when
        int sum = 0;
        int preinputumber = 0;
        for (Integer number : numbers) {
            int total = number + preinputumber;
            sum += total;
            preinputumber = total;
        }

        // then
        System.out.println(sum);
    }
}
