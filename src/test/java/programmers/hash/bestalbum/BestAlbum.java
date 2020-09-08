package programmers.hash.bestalbum;

import java.util.ArrayList;
import java.util.List;

public class BestAlbum {
    private final List<BestAlbumTrack> bestAlbumTracks;

    public BestAlbum(final List<BestAlbumTrack> bestAlbumTracks) {
        this.bestAlbumTracks = bestAlbumTracks;
    }

    public int[] getAnswer() {
        List<Integer> result = new ArrayList<>();
        bestAlbumTracks.forEach(track -> result.addAll(track.getTrackIndexs()));
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
