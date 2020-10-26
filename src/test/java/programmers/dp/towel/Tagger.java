package programmers.dp.towel;

import java.util.List;

public class Tagger {
    private final int num;
    private final List<Integer> numOfMovesPerGame;
    private final Player taggerPlayer;
    private final int startLocation;

    public static Tagger first(final List<Integer> numOfMovesPerGame, final Player player) {
        return new Tagger(0, numOfMovesPerGame, player, 0);
    }

    public Tagger(final int num, final List<Integer> numOfMovesPerGame, final Player taggerPlayer, final int startLocation) {
        this.num = num;
        this.numOfMovesPerGame = numOfMovesPerGame;
        this.taggerPlayer = taggerPlayer;
        this.startLocation = startLocation;
    }

    public Tagger tag(Locations locations) {
        int tagLocation = tagLocation(locations.getSize());
        Player target = locations.tag(taggerPlayer, tagLocation);

        if (target.isQuick()) {
            locations.tag(target, tagLocation);
            taggerPlayer.tag();
            return new Tagger(num + 1, numOfMovesPerGame, taggerPlayer, tagLocation);
        }

        target.tag();
        return new Tagger(num + 1, numOfMovesPerGame, target, tagLocation);

    }

    private int tagLocation(int locationSize) {
        Integer move = numOfMovesPerGame.get(num);
        if (move > 0) {
            return (startLocation + move) % locationSize;
        }
        return (startLocation + (locationSize + move)) % locationSize;
    }

    public Player getTaggerPlayer() {
        return taggerPlayer;
    }
}
