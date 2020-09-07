package programmers.hash.bestalbum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BestAlbum {
    private final Map<Genre, BestAlbumTrack> bestAlbumTracks;

    public BestAlbum(final Map<Genre, BestAlbumTrack> bestAlbumTracks) {
        this.bestAlbumTracks = bestAlbumTracks;
    }

    public int[] getAnswer() {
        List<Integer> result = new ArrayList<>();
        bestAlbumTracks.forEach((key, value) -> result.addAll(value.getTrackIndexs()));
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
