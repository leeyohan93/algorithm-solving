package programmers.dfsandbfs.targetnumber;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OtherSolution {

    @Test
    public void solve() {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        int answer = 0;
        answer = dfs(numbers, 0, 0, target);

        assertThat(answer).isEqualTo(5);
    }

    int dfs(int[] numbers, int n, int sum, int target) {
        if (n == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }
}
