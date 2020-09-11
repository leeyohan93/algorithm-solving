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
        for (int i = 0; i < features.size(); i++) {
            progresses(features.getFirst().getRequiredDay());
        }
        return distributes
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private void progresses(int day) {
        features.forEach(feature -> feature.progress(day));
    }
}
