package programmers.stackandqueue.truck;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Trucks {
    private final LinkedList<Truck> trucks;

    public static Trucks empty() {
        return new Trucks(new LinkedList<>());
    }

    public static Trucks from(int[] truckWeights) {
        return Arrays.stream(truckWeights)
                .mapToObj(truckWeight -> new Truck(truckWeight, 0))
                .collect(Collectors.collectingAndThen(toLinkedList(), Trucks::new));
    }

    private static Collector<Truck, ?, LinkedList<Truck>> toLinkedList() {
        return Collector.of(LinkedList::new,
                LinkedList::add,
                (first, second) -> {
                    first.addAll(second);
                    return first;
                });
    }

    public Trucks(final List<Truck> trucks) {
        this.trucks = new LinkedList<>(Collections.unmodifiableList(trucks));
    }

    public int getWeightSum() {
        return trucks.stream()
                .mapToInt(Truck::getWeight)
                .sum();
    }

    public Trucks move(final Bridge bridge) {
        return trucks.stream()
                .map(Truck::move)
                .filter(truck -> truck.getDistance() <= bridge.getLength())
                .collect(Collectors.collectingAndThen(toLinkedList(), Trucks::new));
    }

    public Trucks add(final Truck nextTruck) {
        LinkedList<Truck> newTrucks = new LinkedList<>(this.trucks);
        newTrucks.add(nextTruck);
        return new Trucks(newTrucks);
    }

    public int getTimeCrossBridge(Bridge bridge) {
        int time = 0;
        BridgeRoad bridgeRoad = BridgeRoad.init(bridge);

        while (!trucks.isEmpty()) {
            time++;
            bridgeRoad = bridgeRoad.move();
            if (bridgeRoad.isCross(trucks.getFirst())) {
                bridgeRoad = bridgeRoad.onBoard(trucks.removeFirst());
            }
        }

        return time + bridge.getLength();
    }
}
