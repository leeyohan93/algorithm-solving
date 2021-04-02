package baekjoon.greedy;

import java.util.Scanner;

public class Problem13305 {

    // https://www.acmicpc.net/problem/13305
    public static void main(String[] args) {
        // given
        Scanner scanner = new Scanner(System.in);

        int cityCount = scanner.nextInt();
        int[] cityDistance = new int[cityCount - 1];
        int[] cityPrice = new int[cityCount];

        for (int i = 0; i < cityCount - 1; i++) {
            cityDistance[i] = scanner.nextInt();
        }

        for (int i = 0; i < cityCount; i++) {
            cityPrice[i] = scanner.nextInt();
        }

        // when
        long minPrice = Integer.MAX_VALUE;
        long price = 0;
        for (int i = 0; i < cityCount - 1; i++) {
            if (minPrice > cityPrice[i]) {
                minPrice = cityPrice[i];
            }
            price += minPrice * cityDistance[i];
        }

        // then
        System.out.println(price);
    }
}
