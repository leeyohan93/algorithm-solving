package programmers.dp.towel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private final static List<String> fixedPlayerNames = new ArrayList<>();
    private final List<Player> players;

    static {
        for (int i = 0; i < 26; i++) {
            char alphabet = (char) ('A' + i);
            fixedPlayerNames.add(String.valueOf(alphabet));
        }
    }

    public static Players create(int numberOfPlay, List<String> quickPlayerNames) {
        return IntStream.range(0, numberOfPlay)
                .mapToObj(fixedPlayerNames::get)
                .map(name -> quickPlayerNames.contains(name) ? Player.quick(name) : Player.normal(name))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Players::new));
    }

    public Players(final List<Player> players) {
        this.players = players;
    }

    public Locations getFirsLocations() {
        return new Locations(getFirstGameNoneTaggerPlayers());
    }

    private List<Player> getFirstGameNoneTaggerPlayers() {
        List<Player> noneTagger = new ArrayList<>(players);
        noneTagger.remove(0);
        return noneTagger;
    }

    public Tagger getFirstTagger(List<Integer> numOfMovesPerGame) {
        Player firstTagger = players.get(0);
        firstTagger.tag();
        return Tagger.first(numOfMovesPerGame, firstTagger);
    }
}
