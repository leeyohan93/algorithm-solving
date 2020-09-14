package programmers.stackandqueue.printer;

import java.util.Objects;

public class Page implements Comparable<Page> {
    private final int index;
    private final int priorities;

    public Page(final int index, final int priorities) {
        this.index = index;
        this.priorities = priorities;
    }

    @Override
    public int compareTo(final Page other) {
        return this.priorities - other.priorities;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Page)) return false;
        final Page page = (Page) o;
        return index == page.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
