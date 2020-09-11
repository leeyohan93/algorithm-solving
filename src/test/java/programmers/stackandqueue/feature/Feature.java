package programmers.stackandqueue.feature;

public class Feature {
    private final int progress;
    private final int speed;

    public Feature(final int progress, final int speed) {
        this.progress = progress;
        this.speed = speed;
    }

    public Feature progress() {
        return progress(1);
    }

    public Feature progress(int days) {
        int progress = this.progress + (speed * days);
        if (progress >= 100) {
            return new Feature(100, speed);
        }
        return new Feature(progress, speed);
    }

    public boolean isComplete() {
        return progress == 100;
    }

    public int getRequiredDay() {
        return (100 - progress) / speed;
    }
}
