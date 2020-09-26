package programmers.bf.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Students {
    private final List<Student> students;

    public Students(final List<Student> students) {
        this.students = new ArrayList<>(Collections.unmodifiableList(students));
    }

    public int[] getBestExamStudentIndex(int[] answer) {
        Map<Integer, List<Student>> studentsByScore = students.stream()
                .collect(Collectors.groupingBy(student -> student.playExam(answer)));
        List<Student> students = studentsByScore.entrySet()
                .stream()
                .sorted((a, b) -> b.getKey() - a.getKey())
                .map(Entry::getValue)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        return students.stream()
                .mapToInt(Student::getIndex)
                .toArray();
    }
}
