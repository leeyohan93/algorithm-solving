package baekjoon.greedy;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem1715 {

    // https://www.acmicpc.net/problem/1715
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // 우선순위 큐 사용
        PriorityQueue<Integer> queue = IntStream.range(0, n)
                .map(index -> scanner.nextInt())
                .boxed()
                .sorted()
                .collect(Collectors.toCollection(PriorityQueue::new));

        int sum = 0;
        while (queue.size() > 1) {
            int i = queue.poll() + queue.poll();
            queue.offer(i);
            sum += i;
        }

        System.out.println(sum);
    }
}
