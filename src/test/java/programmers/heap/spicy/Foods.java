package programmers.heap.spicy;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Foods {
    private final LinkedList<Food> foods;

    public static Foods from(int[] scoville) {
        return Arrays.stream(scoville)
                .sorted()
                .mapToObj(Food::new)
                .collect(Collectors.collectingAndThen(toLinkedList(), Foods::new));
    }

    private static Collector<Food, ?, LinkedList<Food>> toLinkedList() {
        return Collector.of(LinkedList::new,
                LinkedList::add,
                (first, second) -> {
                    first.addAll(second);
                    return first;
                });
    }


    public Foods(final LinkedList<Food> foods) {
        this.foods = new LinkedList<>(Collections.unmodifiableList(foods));
    }

    public int getMixCount(int targetScoville) {
        LinkedList<Food> mixTarget = new LinkedList<>(foods);
        int count = 0;
        while (!mixTarget.getFirst().biggerOrEqual(targetScoville)) {
            if (mixTarget.size() < 2) {
                return -1;
            }
            Food first = mixTarget.removeFirst();
            Food second = mixTarget.removeFirst();
            Food mixedFood = first.mix(second);
            mixTarget.addFirst(mixedFood);
            mixTarget.sort(Food::compareTo);
            count++;
        }
        return count;
    }
}
