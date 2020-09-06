package programmers.hash.spy;

import java.util.Objects;

public class Cloth {
    private final ClothType clothType;
    private final String name;

    public Cloth(final String clothType, final String name) {
        this(new ClothType(clothType), name);
    }


    public Cloth(final ClothType clothType, final String name) {
        this.clothType = clothType;
        this.name = name;
    }

    public ClothType getClothType() {
        return clothType;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Cloth)) return false;
        final Cloth cloth = (Cloth) o;
        return Objects.equals(clothType, cloth.clothType) &&
                Objects.equals(name, cloth.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clothType, name);
    }
}
