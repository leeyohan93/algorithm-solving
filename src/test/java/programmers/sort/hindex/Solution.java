package programmers.sort.hindex;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    @Test
    void solve() {
        int[] citations = {12, 11, 10, 9, 8, 1};

        Papers papers = Papers.from(citations);
        int hindex = papers.getHindex();

        assertThat(hindex).isEqualTo(5);
    }

    @Test
    void otherSolve() {
        int[] citations = {12, 11, 10, 9, 8, 1};

        int answer = 0;
        Arrays.sort(citations);
        for(int i=0; i<citations.length; i++) {
            int smaller = Math.min(citations[i], citations.length - i);
            answer = Math.max(answer, smaller);
        }

        assertThat(answer).isEqualTo(5);
    }
}
