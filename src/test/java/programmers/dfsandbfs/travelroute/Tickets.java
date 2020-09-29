package programmers.dfsandbfs.travelroute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Tickets {
    private final List<Ticket> tickets;

    public static Tickets from(String[][] tickets) {
        return Arrays.stream(tickets)
                .map(ticket -> new Ticket(ticket[0], ticket[1]))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Tickets::new));
    }

    public Tickets(final List<Ticket> tickets) {
        this.tickets = new ArrayList<>(Collections.unmodifiableList(tickets));
    }

    public String[] getTravelRoute() {
        List<String> travelRoutes = new ArrayList<>();
        int size = tickets.size();
        for (int i = 0; i < size; i++) {
            boolean[] visited = new boolean[size];
            Ticket ticket = tickets.get(i);
            String route = ticket.getStartPoint() + ",";
            if (ticket.isFirstStartPoint()) {
                visited[i] = true;
                dfs(visited, ticket, route, 1, travelRoutes);
            }
        }

        return travelRoutes.stream()
                .sorted()
                .findFirst()
                .orElse("")
                .split(",");
    }

    private void dfs(final boolean[] visited, Ticket currentTicket, String route, int count, List<String> travelRoutes) {
        route += currentTicket.getEndPoint() + ",";

        if (count == tickets.size()) {
            travelRoutes.add(route);
        }

        for (int i = 0; i < tickets.size(); i++) {
            Ticket nextTicket = tickets.get(i);
            if (!visited[i] && currentTicket.isUse(nextTicket)) {
                visited[i] = true;
                dfs(visited, nextTicket, route, count + 1, travelRoutes);
                visited[i] = false;
            }
        }
    }
}
