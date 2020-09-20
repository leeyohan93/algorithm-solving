package programmers.heap.disk;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class Tasks {
    private final LinkedList<Task> tasks;

    static Tasks form(final int[][] jobs) {
        LinkedList<Task> tasks = IntStream.range(0, jobs.length)
                .mapToObj(index -> new Task(index, jobs[index][0], jobs[index][1]))
                .sorted(Comparator.comparingInt(Task::getInputTime))
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
        int completedTime = 0;
        while (!tasks.isEmpty()) {
            final int nextStartTime = completedTime;
            Task activeTask = getActiveTask(nextStartTime);
            if (activeTask.getInputTime() > nextStartTime) {
                completedTime = activeTask.getInputTime();
            }

            int waitAndRunTime = activeTask.getWaitAndRunTime(completedTime);
            completedTimes.add(waitAndRunTime);
            completedTime += activeTask.getRunTime();
        }
        return completedTimes.stream()
                .mapToInt(Integer::intValue)
                .sum() / completedTimes.size();
    }

    private Task getActiveTask(final int nextStartTime) {
        Task activeTask = tasks.stream()
                .filter(task -> task.readyToStart(nextStartTime))
                .sorted()
                .findFirst()
                .orElseGet(this::getActiveTask);

        if (tasks.remove(activeTask)) {
            return activeTask;
        }

        throw new IllegalArgumentException();
    }

    private Task getActiveTask() {
        int inputTime = tasks.getFirst().getInputTime();
        return tasks.stream()
                .filter(task -> task.readyToStart(inputTime))
                .sorted()
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
