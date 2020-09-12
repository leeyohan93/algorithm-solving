package programmers.stackandqueue.truck;

public class Bridge {
    private final int length;
    private final int weightLimit;

    public Bridge(final int length, final int weightLimit) {
        this.length = length;
        this.weightLimit = weightLimit;
    }

    public boolean isCrossWeight(int weightSum) {
        return  weightLimit >= weightSum;
    }

    public int getLength() {
        return length;
    }
}
