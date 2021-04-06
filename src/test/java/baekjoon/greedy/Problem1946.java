package baekjoon.greedy;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem1946 {

    /**
     * https://www.acmicpc.net/problem/1946
     * 시간복잡도 n으로 풀어야했던 문제
      */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCaseCount = scanner.nextInt();

        for (int count = 0; count < testCaseCount; count++) {
            int n = scanner.nextInt();
            List<Employee> employees = IntStream.range(0, n)
                    .mapToObj(index -> new Employee(scanner.nextInt(), scanner.nextInt()))
                    .sorted(Comparator.comparing(Employee::getDocumentRank))
                    .collect(Collectors.toList());

            int result = 1;
            int bestInterviewRank = employees.get(0).interviewRank;
            for (int i = 1; i < employees.size(); i++) {
                Employee employee = employees.get(i);
                if (employee.getInterviewRank() < bestInterviewRank) {
                    bestInterviewRank = employee.getInterviewRank();
                    result++;
                }
            }
            System.out.println(result);
        }
    }


    private static class Employee {
        private final int documentRank;
        private final int interviewRank;

        public Employee(final int documentRank, final int interviewRank) {
            this.documentRank = documentRank;
            this.interviewRank = interviewRank;
        }

        public int getDocumentRank() {
            return documentRank;
        }

        public int getInterviewRank() {
            return interviewRank;
        }
    }
}

