package programmers.hash.spy;

import java.util.Objects;

public class ClothType {
    private final String name;

    public ClothType(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof ClothType)) return false;
        final ClothType that = (ClothType) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
