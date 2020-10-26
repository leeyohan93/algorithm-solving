package programmers.dp.towel;

import java.util.Objects;

public class Player {
    private final String name;
    private final boolean quick;
    private int taggerCount;

    public static Player normal(final String name) {
        return new Player(name, false, 0);
    }

    public static Player quick(final String name) {
        return new Player(name, true, 0);
    }

    public Player(final String name, final boolean quick, final int taggerCount) {
        this.name = name;
        this.quick = quick;
        this.taggerCount = taggerCount;
    }

    public void tag() {
        taggerCount += 1;
    }

    public String getName() {
        return name;
    }

    public boolean isQuick() {
        return quick;
    }

    public int getTaggerCount() {
        return taggerCount;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        final Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
