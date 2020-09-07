package programmers.hash.bestalbum;

import java.util.*;
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
        Map<Genre, List<Song>> songsByGenre = songs.stream()
                .collect(groupingBy(Song::getGenre));

        List<Genre> genreRank = getGenreRank(songsByGenre);

        return new BestAlbum(genreRank.stream()
                .collect(toMap(
                        genre -> genre,
                        genre -> BestAlbumTrack.from(songsByGenre.get(genre)),
                        (x, y) -> y,
                        LinkedHashMap::new)
                ));
    }

    private List<Genre> getGenreRank(final Map<Genre, List<Song>> songsByGenre) {
        List<Genre> genres = new ArrayList<>(songsByGenre.keySet());
        genres.sort((x, y) -> sumSongPlayCount(songsByGenre.get(y)).compareTo(sumSongPlayCount(songsByGenre.get(x))));
        return genres;
    }

    private Integer sumSongPlayCount(List<Song> songs) {
        return songs.stream()
                .map(Song::getPlayCount)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
