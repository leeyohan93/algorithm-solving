package programmers.heap.disk;

import java.util.Objects;

public class Task implements Comparable<Task> {
    private final int index;
    private final int inputTime;
    private final int runTime;

    public Task(final int index, final int inputTime, final int runTime) {
        this.index = index;
        this.inputTime = inputTime;
        this.runTime = runTime;
    }

    public int getWaitAndRunTime() {
        return getWaitAndRunTime(inputTime);
    }

    public int getWaitAndRunTime(int startTime) {
        if (inputTime > startTime) {
            throw new IllegalArgumentException();
        }

        return (startTime - inputTime) + runTime;
    }

    public int getRunTime() {
        return runTime;
    }

    public int getInputTime() {
        return inputTime;
    }

    public boolean readyToStart(int time) {
        return time >= inputTime;
    }

    @Override
    public int compareTo(final Task other) {
        return this.runTime - other.runTime;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        final Task task = (Task) o;
        return index == task.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
