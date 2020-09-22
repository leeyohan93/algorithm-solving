package programmers.sort.k;

public class Command {
    private final int fromIndex;
    private final int toIndex;
    private final int resultIndex;

    public Command(final int fromIndex, final int toIndex, final int resultIndex) {
        this.fromIndex = fromIndex;
        this.toIndex = toIndex;
        this.resultIndex = resultIndex;
    }

    public int getNumber(Numbers numbers) {
        return numbers.subNumbers(fromIndex, toIndex)
                .getNumber(resultIndex);
    }
}
