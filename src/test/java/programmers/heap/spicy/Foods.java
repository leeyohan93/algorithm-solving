package programmers.heap.spicy;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Foods {
    private final PriorityQueue<Integer> foods;

    public static Foods from(int[] scoville) {
        return Arrays.stream(scoville)
                .sorted()
                .boxed()
                .collect(Collectors.collectingAndThen(toLinkedList(), Foods::new));
    }

    private static Collector<Integer, ?, LinkedList<Integer>> toLinkedList() {
        return Collector.of(LinkedList::new,
                LinkedList::add,
                (first, second) -> {
                    first.addAll(second);
                    return first;
                });
    }

    private Foods(final LinkedList<Integer> foods) {
        this.foods = new PriorityQueue<>(Collections.unmodifiableList(foods));
    }

    int getMixCount(int targetScoville) {
        int count = 0;
        while (foods.peek() < targetScoville) {
            if (foods.size() < 2) {
                return -1;
            }
            Integer first = foods.poll();
            Integer second = foods.poll();
            foods.add(first + (second * 2));
            count++;
        }
        return count;
    }
}
