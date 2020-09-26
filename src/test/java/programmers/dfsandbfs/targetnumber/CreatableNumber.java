package programmers.dfsandbfs.targetnumber;

public class CreatableNumber {
    private final int index;
    private final int number;

    public CreatableNumber(final int index, final int number) {
        this.index = index;
        this.number = number;
    }

    public CreatableNumber add(int number) {
        return new CreatableNumber(index + 1, this.number + number);
    }

    public CreatableNumber subtract(int number) {
        return new CreatableNumber(index + 1, this.number - number);
    }

    public int getIndex() {
        return index;
    }

    public boolean isFinal(int index) {
        return this.index == index;
    }

    public boolean isEqualNumber(int number) {
        return this.number == number;
    }
}
