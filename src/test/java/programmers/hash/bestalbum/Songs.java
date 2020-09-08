package programmers.hash.bestalbum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class Songs {
    private final List<Song> songs;

    public static Songs of(String[] genres, int[] plays) {
        int size = genres.length;
        return IntStream.range(0, size)
                .mapToObj(index -> Song.of(index, genres[index], plays[index]))
                .collect(collectingAndThen(toList(), Songs::new));

    }

    public Songs(final List<Song> songs) {
        this.songs = new ArrayList<>(Collections.unmodifiableList(songs));
    }

    public BestAlbum getBestAlbum() {
        return songs.stream()
                .collect(groupingBy(Song::getGenre))
                .entrySet()
                .stream()
                .sorted((a, b) -> sumSongPlayCount(b.getValue()) - sumSongPlayCount(a.getValue()))
                .map(entry -> BestAlbumTrack.from(entry.getKey(), entry.getValue()))
                .collect(collectingAndThen(toList(), BestAlbum::new));
    }

    private int sumSongPlayCount(List<Song> songs) {
        return songs.stream()
                .map(Song::getPlayCount)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
