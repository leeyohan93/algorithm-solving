package programmers.dfsandbfs.wordchange;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BfsSolution {

    @Test
    void solve() {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(new Node(begin, 0));

        int length = words.length;
        boolean[] visited = new boolean[length];
        int answer = 0;

        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            if (node.word.equals(target)) {
                answer = node.edge;
            }

            for (int i = 0; i < length; i++) {
                if (!visited[i] && isConvert(node.word, words[i])) {
                    visited[i] = true;
                    nodes.add(new Node(words[i], node.edge + 1));
                }
            }
        }
        Assertions.assertThat(answer).isEqualTo(4);
    }

    private boolean isConvert(final String presentWord, final String convertTarget) {
        return (int) IntStream.range(0, presentWord.length())
                .filter(index -> presentWord.charAt(index) != convertTarget.charAt(index))
                .count() == 1;
    }

    public static class Node {
        private final String word;
        private final int edge;

        public Node(final String word, final int edge) {
            this.word = word;
            this.edge = edge;
        }
    }
}
