package programmers.dp.n;

public class CreatableNumber {
    private final int index;
    private final int number;
    private final int baseNumber;

    public CreatableNumber(final int index, final int number, final int baseNumber) {
        this.index = index;
        this.number = number;
        this.baseNumber = baseNumber;
    }

    public CreatableNumber add() {
        return new CreatableNumber(index + 1, this.number + baseNumber, baseNumber);
    }

    public CreatableNumber subtract() {
        return new CreatableNumber(index + 1, this.number - baseNumber, baseNumber);
    }

    public CreatableNumber divide() {
        return new CreatableNumber(index + 1, this.number / baseNumber, baseNumber);
    }

    public CreatableNumber multiply() {
        return new CreatableNumber(index + 1, this.number * baseNumber, baseNumber);
    }

    public CreatableNumber append() {
        return new CreatableNumber(index + 1, (baseNumber * 10) + 5, baseNumber);
    }

    public int getIndex() {
        return index;
    }

    public boolean isEqualNumber(int number) {
        return this.number == number;
    }

    public boolean isRange() {
        return number >= 1 && number <= 32000;
    }
}
