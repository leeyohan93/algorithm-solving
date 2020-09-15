package programmers.heap.spicy;


public class Food implements Comparable<Food> {
    private final int scoville;

    public Food(final int scoville) {
        this.scoville = scoville;
    }

    public Food mix(final Food other) {
        if (scoville > other.scoville) {
            return new Food((scoville * 2) + other.scoville);
        }
        return new Food(scoville + (other.scoville * 2));
    }

    public boolean biggerOrEqual(final int scoville){
        return this.scoville >= scoville;
    }

    @Override
    public int compareTo(final Food other) {
        return  this.scoville - other.scoville;
    }
}
