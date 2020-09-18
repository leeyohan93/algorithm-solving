package programmers.heap.disk;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Tasks {
    private final LinkedList<Task> tasks;

    public static Tasks form(final int[][] jobs) {
        LinkedList<Task> tasks = Arrays.stream(jobs)
                .map(job -> new Task(job[0], job[1]))
                .sorted()
                .collect(toLinkedList());
        return new Tasks(tasks);
    }

    private static Collector<Task, ?, LinkedList<Task>> toLinkedList() {
        return Collector.of(LinkedList::new,
                LinkedList::add,
                (first, second) -> {
                    first.addAll(second);
                    return first;
                });
    }

    private Tasks(final LinkedList<Task> tasks) {
        this.tasks = new LinkedList<>(Collections.unmodifiableList(tasks));
    }

    public int getAverageTime() {
        List<Integer> completedTimes = new ArrayList<>();
        Task firstTask = tasks.removeFirst();
        int nextTime = firstTask.getWaitAndRunTime();
        completedTimes.add(nextTime);
        while (!tasks.isEmpty()) {
            final int finalNextTime = nextTime;
            tasks.sort(Comparator.comparingInt(o -> o.comparePriority(finalNextTime)));
            Task task = tasks.removeFirst();
            int waitAndRunTime = task.getWaitAndRunTime(nextTime);
            completedTimes.add(waitAndRunTime);
            nextTime = task.getInputTime() + waitAndRunTime;
        }
        return completedTimes.stream()
                .mapToInt(Integer::intValue)
                .sum() / completedTimes.size();
    }
}
