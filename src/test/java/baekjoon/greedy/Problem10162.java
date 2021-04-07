package baekjoon.greedy;

import java.util.Scanner;

public class Problem10162 {

    // https://www.acmicpc.net/problem/10162
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] seconds = {300, 60, 10};
        int input = scanner.nextInt();

        if (input % 10 != 0) {
            System.out.println(-1);
            return;
        }

        for (int second : seconds) {
            System.out.print(input / second + " ");
            input %= second;
        }
    }
}
