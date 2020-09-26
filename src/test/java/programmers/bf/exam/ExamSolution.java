package programmers.bf.exam;

public class ExamSolution {
    private final int[] solutions;

    public static ExamSolution form(int... solutions) {
        return new ExamSolution(solutions);
    }

    public ExamSolution(final int[] solutions) {
        this.solutions = solutions;
    }

    public int getResult(final int[] answers) {
        int result = 0;
        for (int i = 0; i < answers.length; i++) {
            int solution = getSolution(i, solutions.length);
            if (solution == answers[i]) {
                result++;
            }
        }
        return result;
    }

    private int getSolution(final int i, final int length) {
        if (i > length - 1) {
            return solutions[i % length];
        }
        return solutions[i];
    }
}
