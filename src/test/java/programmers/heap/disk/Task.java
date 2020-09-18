package programmers.heap.disk;

public class Task implements Comparable<Task> {
    private final int inputTime;
    private final int runTime;

    public Task(final int inputTime, final int runTime) {
        this.inputTime = inputTime;
        this.runTime = runTime;
    }

    public int getInputTime() {
        return inputTime;
    }

    public int getWaitAndRunTime() {
        return getWaitAndRunTime(inputTime);
    }

    public int getWaitAndRunTime(int startTime) {
        if (startTime >= inputTime) {
            return (startTime - inputTime) + runTime;
        }
        return 0;
    }

    public int comparePriority(int startTime) {
        if (startTime >= inputTime) {
            return runTime;
        }
        return 100000;
    }

    @Override
    public int compareTo(final Task other) {
        return this.inputTime - other.inputTime;
    }
}
