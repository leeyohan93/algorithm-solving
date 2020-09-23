package programmers.sort.bignumber;

import java.util.Objects;

public class AppendNumber implements Comparable<AppendNumber> {
    private final int number;

    public AppendNumber(final int number) {
        this.number = number;
    }

    private int getNumber(final int numberIndex) {
        String numberString = String.valueOf(number);
        if (isLengthOver(numberIndex)) {
            return Integer.parseInt(numberString.substring(numberIndex - 1, numberIndex));
        }
        return Integer.parseInt(numberString.substring(numberIndex, numberIndex + 1));
    }

    public boolean isLengthOver(int numberIndex) {
        return numberIndex > String.valueOf(number).length() - 1;
    }

    @Override
    public int compareTo(final AppendNumber other) {
        if (this.equals(other)) {
            return 0;
        }

        int result = 0;
        int numberIndex = 0;
        while (result == 0) {
            result = other.getNumber(numberIndex) - getNumber(numberIndex);
            numberIndex++;
        }
        return result;
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
}
