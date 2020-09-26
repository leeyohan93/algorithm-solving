package programmers.dfsandbfs.network;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    @Test
    void solve() {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        boolean[] visited = new boolean[n];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, visited, i);
                answer++;
            }
        }

        assertThat(answer).isEqualTo(2);
    }

    private void dfs(final int[][] computers, final boolean[] visited, final int v) {
        if (visited[v]) {
            return;
        }

        visited[v] = true;
        for (int i = 0; i < computers.length; i++) {
            if (i != v && computers[v][i] == 1) {
                dfs(computers, visited, i);
            }
        }
    }
}
