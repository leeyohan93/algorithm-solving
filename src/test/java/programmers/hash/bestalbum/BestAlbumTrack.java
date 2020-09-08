package programmers.hash.bestalbum;

import java.util.List;
import java.util.stream.Collectors;

public class BestAlbumTrack {
    private static final int TRACK_LIMIT = 2;

    private final Genre genre;
    private final List<Song> tracks;

    public static BestAlbumTrack from(final Genre genre, final List<Song> songs) {
        return songs.stream()
                .sorted()
                .limit(TRACK_LIMIT)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        tracks -> new BestAlbumTrack(genre, tracks)));
    }

    public BestAlbumTrack(final Genre genre, final List<Song> tracks) {
        if (tracks.size() > TRACK_LIMIT) {
            throw new IllegalArgumentException();
        }

        if (!isMatchGenre(genre, tracks)) {
            throw new IllegalArgumentException();
        }

        this.genre = genre;
        this.tracks = tracks;
    }

    private boolean isMatchGenre(final Genre genre, final List<Song> tracks) {
        return tracks.stream()
                .allMatch(track -> track.isMatchGenre(genre));
    }

    public List<Integer> getTrackIndexs() {
        return tracks.stream()
                .map(Song::getIndex)
                .collect(Collectors.toList());
    }
}
