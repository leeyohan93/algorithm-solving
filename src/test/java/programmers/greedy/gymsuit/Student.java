package programmers.greedy.gymsuit;

public class Student {
    private final int index;
    private int gymSuitCount;

    public Student(final int index) {
        this(index, 1);
    }

    public Student(final int index, int gymSuitCount) {
        this.index = index;
        this.gymSuitCount = gymSuitCount;
    }

    public void lostGymSuit() {
        gymSuitCount--;
    }

    public void enoughGymSuit() {
        gymSuitCount++;
    }

    public void lendGymSuit() {
        if (gymSuitCount < 2) {
            throw new IllegalArgumentException();
        }
        gymSuitCount--;
    }

    public void receiveGymSuit() {
        if (gymSuitCount != 0) {
            throw new IllegalArgumentException();
        }
        gymSuitCount++;
    }

    public boolean isLostGymSuit() {
        return gymSuitCount == 0;
    }

    public boolean isEnoughGymSuit() {
        return gymSuitCount == 2;
    }

    public boolean isGymSuit() {
        return gymSuitCount >= 1;
    }
}
