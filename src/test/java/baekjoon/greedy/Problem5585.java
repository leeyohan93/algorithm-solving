package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Problem5585 {

    // https://www.acmicpc.net/problem/5585
    public static void main(String[] args) throws IOException {
        // given
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int input = 1000 - Integer.parseInt(bufferedReader.readLine());
        List<Integer> coins = Arrays.asList(500, 100, 50, 10, 5, 1);

        // when
        int count = 0;
        for (Integer coin : coins) {
            count += input / coin;
            input %= coin;
        }

        // then
        System.out.println(count);
    }
}
