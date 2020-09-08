package programmers.hash.bestalbum;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 스트림의 활용과 map() vs flatMap()의 차이점을 확실히 알 수 있도록 한다.
 * sort 의 활용도를 생각하고 Comparable 구현을 통한 방법은 코드를 많이 깔끔하게 만든다.
 */
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
