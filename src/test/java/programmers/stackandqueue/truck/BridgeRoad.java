package programmers.stackandqueue.truck;

public class BridgeRoad {
    private final Bridge bridge;
    private final Trucks trucks;

    public static BridgeRoad init(Bridge bridge) {
        return new BridgeRoad(bridge, Trucks.empty());
    }

    public BridgeRoad(final Bridge bridge, final Trucks trucks) {
        this.bridge = bridge;
        this.trucks = trucks;
    }

    public boolean isCross(Truck truck) {
        return bridge.isCrossWeight(trucks.getWeightSum() + truck.getWeight());
    }

    public BridgeRoad onBoard(Truck nextTruck) {
        if (!isCross(nextTruck)) {
            throw new IllegalArgumentException("다리 무너진다.");
        }
        return new BridgeRoad(bridge, trucks.add(nextTruck.move()));
    }

    public BridgeRoad move() {
        Trucks movedTruck = trucks.move(bridge);
        return new BridgeRoad(bridge, movedTruck);
    }
}
