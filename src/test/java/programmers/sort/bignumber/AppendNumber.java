package programmers.sort.bignumber;

import java.util.Objects;

public class AppendNumber {
    private final int number;

    public AppendNumber(final String number) {
        this.number = Integer.parseInt(number);
    }

    public AppendNumber(final int number) {
        this.number = number;
    }

    public AppendNumber append(final AppendNumber other) {
        return new AppendNumber(number + String.valueOf(other.number));
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof AppendNumber)) return false;
        final AppendNumber that = (AppendNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public int minus(final AppendNumber other) {
        return this.number - other.number;
    }
}
