package baekjoon.greedy;


import java.util.Scanner;

public class Problem4796 {

    // https://www.acmicpc.net/problem/4796
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 1;
        while (true) {
            String param = scanner.nextLine();
            if (param.equals("0 0 0")) {
                break;
            }

            String[] split = param.split(" ");

            int l = Integer.parseInt(split[0]);
            int p = Integer.parseInt(split[1]);
            int v = Integer.parseInt(split[2]);

            System.out.println(String.format("Case %d: %d", count, (v / p) * l + Math.min(v % p, l)));
            count++;
        }
    }
}
