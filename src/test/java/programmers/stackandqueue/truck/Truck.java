package programmers.stackandqueue.truck;

public class Truck {
    private static final int SECOND_DISTANCE = 1;

    private final int weight;
    private final int distance;

    public Truck(final int weight, final int distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public Truck move() {
        return new Truck(weight, distance + SECOND_DISTANCE);
    }

    public int getWeight() {
        return weight;
    }

    public int getDistance() {
        return distance;
    }
}
