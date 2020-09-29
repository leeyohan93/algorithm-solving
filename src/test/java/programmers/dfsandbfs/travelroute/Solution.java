package programmers.dfsandbfs.travelroute;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {

    @Test
    void solve() {
        String[][] input = {{"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"},{"ICN", "SFO"},{"ICN", "ATL"}};
        Tickets tickets = Tickets.from(input);
        String[] travelRoute = tickets.getTravelRoute();
        Arrays.stream(travelRoute).forEach(System.out::println);

    }
}
