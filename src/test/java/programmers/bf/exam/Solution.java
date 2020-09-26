package programmers.bf.exam;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    @Test
    void solve() {
        int[] answers = {1,3,2,4,2};

        Students students = new Students(Arrays.asList(
                new Student(1, ExamSolution.form(1, 2, 3, 4, 5)),
                new Student(2, ExamSolution.form(2, 1, 2, 3, 2, 4, 2, 5)),
                new Student(3, ExamSolution.form(3, 3, 1, 1, 2, 2, 4, 4, 5, 5))
        ));

        int[] bestExamStudentIndex = students.getBestExamStudentIndex(answers);

        assertThat(bestExamStudentIndex).containsExactly(1,2,3);
    }
}
