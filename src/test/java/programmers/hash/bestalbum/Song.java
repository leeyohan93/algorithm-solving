package programmers.hash.bestalbum;

import java.util.Objects;

public class Song implements Comparable<Song> {
    private final int index;
    private final Genre genre;
    private final int playCount;

    public static Song of(final int index, final String genre, final int playCount) {
        return new Song(index, new Genre(genre), playCount);
    }

    public Song(final int index, final Genre genre, final int playCount) {
        this.index = index;
        this.genre = genre;
        this.playCount = playCount;
    }

    public int getIndex() {
        return index;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getPlayCount() {
        return playCount;
    }

    public boolean isMatchGenre(Genre genre) {
        return genre.equals(this.genre);
    }

    @Override
    public int compareTo(final Song other) {
        if (this.playCount == other.playCount) {
            return this.index - other.index;
        }
        return other.playCount - this.playCount;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        final Song song = (Song) o;
        return index == song.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
