package programmers.greedy.gymsuit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Students {
    private final List<Student> students;

    public static Students of(int n, int[] lost, int[] reserve) {
        List<Student> students = IntStream.range(0, n)
                .mapToObj(Student::new)
                .collect(Collectors.toList());

        for (int lostIndex : lost) {
            students.get(lostIndex - 1).lostGymSuit();
        }

        for (int reserveIndex : reserve) {
            students.get(reserveIndex - 1).enoughGymSuit();
        }

        return new Students(students);
    }

    public Students(final List<Student> students) {
        this.students = new ArrayList<>(Collections.unmodifiableList(students));
    }

    public int getPlayCount() {
        IntStream.range(0, students.size())
                .filter(index -> students.get(index).isLostGymSuit())
                .forEach(index -> {
                    Student lostStudent = students.get(index);
                    if (index > 0 && students.get(index - 1).isEnoughGymSuit()) {
                        students.get(index - 1).lendGymSuit();
                        lostStudent.receiveGymSuit();
                    }

                    if (lostStudent.isGymSuit()) {
                        return;
                    }

                    if (index < students.size() - 1 && students.get(index + 1).isEnoughGymSuit()) {
                        students.get(index + 1).lendGymSuit();
                        lostStudent.receiveGymSuit();
                    }
                });

        return (int) students.stream()
                .filter(Student::isGymSuit)
                .count();
    }
}
