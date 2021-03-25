package etc.y;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {

    @Test
    void sum() {
        int[] A = {6, 2, 3, 5, 6, 3};
        Arrays.sort(A);

        int sum = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            int target = i + 1;
            int current = A[i];
            sum += Math.abs(current - target);
        }
        System.out.println(sum);
    }
}
