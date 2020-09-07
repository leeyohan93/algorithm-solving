package programmers.hash.bestalbum;

import java.util.List;
import java.util.stream.Collectors;

public class BestAlbumTrack {
    private static final int TRACK_LIMIT = 2;

    private final List<Song> tracks;

    public static BestAlbumTrack from(final List<Song> songs) {
        songs.sort((x, y) -> y.comparePlayCount(x));                         // 오름차순
        songs.sort(BestAlbumTrack::indexSort);
        if (songs.size() > 2) {
            return new BestAlbumTrack(songs.subList(0, TRACK_LIMIT));
        }
        return new BestAlbumTrack(songs);
    }

    private static int indexSort(final Song first, final Song second) {
        if (first.getPlayCount() == second.getPlayCount()) {
            return Integer.compare(first.getIndex(), second.getIndex());    // 내림차순
        }
        return 0;
    }

    public BestAlbumTrack(final List<Song> tracks) {
        if (tracks.size() > 2) {
            throw new IllegalArgumentException();
        }
        this.tracks = tracks;
    }

    public List<Integer> getTrackIndexs() {
        return tracks.stream()
                .map(Song::getIndex)
                .collect(Collectors.toList());
    }
}
