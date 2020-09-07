package programmers.hash.bestalbum;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    @Test
    void solve() {
        String[] generes = "classic, pop, classic, classic, pop".split(", ");
        int[] plays = {500, 600, 150, 800, 2500};
        int[] expected = {4, 1, 3, 0};

        Songs songs = Songs.of(generes, plays);
        BestAlbum bestAlbum = songs.getBestAlbum();
        int[] answer = bestAlbum.getAnswer();

        assertThat(answer).isEqualTo(expected);
    }
}
