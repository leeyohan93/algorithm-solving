package baekjoon.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Problem1931 {

    // https://www.acmicpc.net/problem/1931
    public static void main(String[] args) {
        // given
        Scanner scanner = new Scanner(System.in);

        int conferenceCount = scanner.nextInt();
        List<Conference> conferences = new ArrayList<>();
        for (int i = 0; i < conferenceCount; i++) {
            conferences.add(new Conference(scanner.nextInt(), scanner.nextInt()));
        }

        // when
        conferences.sort(Comparator.comparingInt(o -> o.startTime));
        conferences.sort(Comparator.comparingInt(o -> o.endTime));

        int count = 0;
        int availableTime = 0;
        for (Conference conference : conferences) {
            if (conference.getStartTime() >= availableTime) {
                count++;
                availableTime = conference.getEndTime();
            }
        }

        // then
        System.out.println(count);
    }

    public static class Conference {

        private int startTime;
        private int endTime;

        public Conference(final int startTime, final int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }
    }
}
