package programmers.stackandqueue.truck;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    @Test
    void solve() {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

        Trucks trucks = Trucks.from(truck_weights);
        Bridge bridge = new Bridge(bridge_length, weight);
        int timeCrossBridge = trucks.getTimeCrossBridge(bridge);

        assertThat(timeCrossBridge).isEqualTo(8);
    }
}
