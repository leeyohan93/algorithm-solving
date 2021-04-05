package baekjoon.greedy;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem22137 {

    //https://www.acmicpc.net/status?user_id=yohaness&problem_id=2217&from_mine=1
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> ropes = IntStream.range(0, n)
                .map(index -> scanner.nextInt())
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int max = ropes.get(0);
        for (int i = 1; i < ropes.size(); i++) {
            max = Math.max(max, ropes.get(i) * (i + 1));
        }

        System.out.println(max);
    }
}
