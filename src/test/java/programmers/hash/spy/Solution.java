package programmers.hash.spy;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void solve() {
        String[][] input = new String[2][2];
        input[0][0] = "crow_mask";
        input[0][1] = "face";
        input[1][0] = "blue_sunglasses";
        input[1][1] = "face";

        Clothes clothes = Clothes.from(input);
        System.out.println(clothes.getMatchCount());
    }
}
