package baekjoon.greedy;

import java.util.Scanner;

public class Problem11047 {

    // https://www.acmicpc.net/problem/11047
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // given
        int coinTypeCount = scanner.nextInt();
        int targetMoney = scanner.nextInt();

        int[] coinTypes = new int[coinTypeCount];
        for (int i = 0; i < coinTypeCount; i++) {
            coinTypes[i] = scanner.nextInt();

        }

        // when
        int moneyCount = 0;
        for (int i = coinTypeCount - 1; i >= 0; i--) {
            moneyCount += targetMoney / coinTypes[i];
            targetMoney = targetMoney % coinTypes[i];
        }

        // then
        System.out.println(moneyCount);
    }
}
