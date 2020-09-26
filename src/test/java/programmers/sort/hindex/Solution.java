package programmers.sort.hindex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    @Test
    void solve() {
        int[] citations = {12, 11, 10, 9, 8, 1};

        Papers papers = Papers.from(citations);
        int hindex = papers.getHindex();

        assertThat(hindex).isEqualTo(5);
    }
}
