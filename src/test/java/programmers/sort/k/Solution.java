package programmers.sort.k;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    @Test
    void solve() {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] inputCommands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        Numbers numbers = Numbers.from(array);
        Commands commands = Commands.from(inputCommands);
        int[] answer = commands.getCommandNumbers(numbers);

        assertThat(answer).containsExactly(5, 6, 3);
    }
}
