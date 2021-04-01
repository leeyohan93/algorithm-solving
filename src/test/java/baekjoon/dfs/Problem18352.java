package baekjoon.dfs;

import java.util.*;

public class Problem18352 {

    private static int n, m, k, x;
    private static List<List<Integer>> graph = new ArrayList<>(new ArrayList<>());
    private static int[] distance = new int[300001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        x = scanner.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            distance[i] = -1;
        }

        // 도로 입력
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
        }

        distance[x] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < graph.get(now).size(); i++) {
                Integer nextNode = graph.get(now).get(i);
                if (distance[nextNode] == -1) {
                    distance[nextNode] = distance[now] + 1;
                    queue.offer(nextNode);
                }
            }
        }

        boolean check = false;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                System.out.println(i);
                check = true;
            }
        }

        if (!check) System.out.println(-1);
    }
}
