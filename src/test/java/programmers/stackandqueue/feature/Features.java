package programmers.stackandqueue.feature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;

public class Features {
    private final LinkedList<Feature> features;

    public static Features of(int[] progresses, int[] speeds) {
        Collector<Feature, ?, LinkedList<Feature>> toLinkedList =
                Collector.of(LinkedList::new,
                        LinkedList::add,
                        (first, second) -> {
                            first.addAll(second);
                            return first;
                        });

        return IntStream.range(0, progresses.length)
                .mapToObj(index -> new Feature(progresses[index], speeds[index]))
                .collect(collectingAndThen(toLinkedList, Features::new));

    }

    public Features(final LinkedList<Feature> features) {
        this.features = new LinkedList<>(Collections.unmodifiableList(features));
    }

    public int[] getDistributes() {
        List<Integer> distributes = new ArrayList<>();

        while (!features.isEmpty()) {
            int requiredDay = features.removeFirst().getRequiredDay();
            int completeCount = 1;
            while (true) {
                if (features.isEmpty()) {
                    distributes.add(completeCount);
                    break;
                }

                if (features.getFirst().isComplete(requiredDay)) {
                    features.removeFirst();
                    completeCount++;
                    continue;
                }
                distributes.add(completeCount);
                break;
            }
        }
        return distributes.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
