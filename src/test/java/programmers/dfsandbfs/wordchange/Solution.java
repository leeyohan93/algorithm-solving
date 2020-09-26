package programmers.dfsandbfs.wordchange;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    @Test
    void solve() {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        int length = words.length;
        int answer = length + 1;

        boolean[] visited = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (isConvert(begin, words[i])) {
                answer = Math.min(answer, dfs(words[i], target, i, words, visited, 1));
            }
        }
        assertThat(answer).isEqualTo(4);
    }

    private int dfs(final String presentWord, final String target, final int index, final String[] words, final boolean[] visited, final int count) {
        if (presentWord.equals(target) || visited[index]) {
            return count;
        }

        visited[index] = true;
        int answer = 0;
        for (int i = 0; i < words.length; i++) {
            if (index != i && !visited[i] && isConvert(presentWord, words[i])) {
                answer = dfs(words[i], target, i, words, visited, count + 1);
            }
        }
        return answer;
    }

    private boolean isConvert(final String presentWord, final String convertTarget) {
        return (int) IntStream.range(0, presentWord.length())
                .filter(index -> presentWord.charAt(index) != convertTarget.charAt(index))
                .count() == 1;
    }
}
