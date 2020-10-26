package programmers.dp.towel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TowelGame {
    private Locations locations;
    private Tagger tagger;

    public static TowelGame init(final Players players, final int numOfGame, final int[] numOfMovesPerGame) {
        List<Integer> numOfMovesPerGameList = Arrays.stream(numOfMovesPerGame)
                .boxed()
                .collect(Collectors.toList());
        return new TowelGame(players.getFirsLocations(), players.getFirstTagger(numOfMovesPerGameList));
    }

    public TowelGame(final Locations locations, final Tagger tagger) {
        this.locations = locations;
        this.tagger = tagger;
    }

    public void play(int playCount) {
        IntStream.range(0, playCount)
                .forEach(value -> tagger = tagger.tag(locations));
        List<Player> players = this.locations.getLocations();
        players.add(tagger.getTaggerPlayer());
        players.forEach(player -> System.out.println(player.getName() + " " + player.getTaggerCount()));
    }
}
