package programmers.dp.towel;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {

    @Test
    void solve() {
        int[] numOfMovesPerGame = {3,-2};
        Players players = Players.create(6, Arrays.asList("B", "C"));
        TowelGame towelGame = TowelGame.init(players, 2, numOfMovesPerGame);
        towelGame.play(2);
        System.out.println(players);
    }
}
