package programmers.bf.exam;

public class Student {
    private final int index;
    private final ExamSolution examSolution;

    public Student(final int index, final ExamSolution examSolution) {
        this.index = index;
        this.examSolution = examSolution;
    }

    public int playExam(int[] answers) {
        return examSolution.getResult(answers);
    }

    public int getIndex() {
        return index;
    }
}
