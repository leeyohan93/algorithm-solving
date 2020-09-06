package programmers.hash.phonelist;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    @Test
    void solve() {
        String line = "119, 97674223, 1195524421";
        String[] input = line.split(", ");

        Phones phoneBook = Phones.from(input);
        boolean answer = phoneBook.isNoneDuplicatePrefix();

        assertThat(answer).isFalse();
    }
}
