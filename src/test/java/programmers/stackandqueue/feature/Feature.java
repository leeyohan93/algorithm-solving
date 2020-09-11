package programmers.stackandqueue.feature;

public class Feature {
    private final int progress;
    private final int speed;

    public Feature(final int progress, final int speed) {
        this.progress = progress;
        this.speed = speed;
    }

    public boolean isComplete(int afterDays) {
        int progress = this.progress + (speed * afterDays);
        return progress >= 100;
    }

    public int getRequiredDay() {
        return (int) Math.ceil((100D - progress) / speed);
    }
}
