package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2839 {

    // https://www.acmicpc.net/problem/2839
    public static void main(String[] args) throws IOException {
        // given
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        int input = Integer.parseInt(tokenizer.nextToken());

        // when
        if (input == 4 || input == 7) {
            System.out.println(-1);
        } else if (input % 5 == 0) {
            System.out.println(input / 5);
        } else if (input % 5 == 1 || input % 5 == 3) {
            System.out.println((input / 5) + 1);
        } else if (input % 5 == 2 || input % 5 == 4) {
            System.out.println((input / 5) + 2);
        }
    }
}
