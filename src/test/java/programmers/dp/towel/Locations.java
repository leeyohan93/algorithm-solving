package programmers.dp.towel;

import java.util.List;

public class Locations {
    private final List<Player> locations;

    public Locations(final List<Player> locations) {
        this.locations = locations;
    }

    public Player tag(Player player, int location) {
        Player nextTagger = locations.get(location);
        locations.set(location, player);
        return nextTagger;
    }

    public int getSize() {
        return locations.size();
    }

    public List<Player> getLocations() {
        return locations;
    }
}
