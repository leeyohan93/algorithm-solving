package baekjoon.greedy;

import java.util.Scanner;

public class Problem1541 {

    // https://www.acmicpc.net/problem/1541
    public static void main(String[] args) {
        // given
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // when
        String[] split = input.split("-");

        int result = 0;
        String[] plusinputumbers = split[0].split("\\+");
        for (String number : plusinputumbers) {
            result += Integer.parseInt(number);
        }

        for (int i = 1; i < split.length; i++) {
            String[] numbers = split[i].split("\\+");
            for (String number : numbers) {
                result -= Integer.parseInt(number);
            }
        }

        // then
        System.out.println(result);
    }
}
