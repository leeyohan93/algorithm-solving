package baekjoon;

import java.util.*;

public class Greedy {

    // https://www.acmicpc.net/problem/11047
    public static void 동전_0(Scanner scanner) {
        // given
        int coinTypeCount = scanner.nextInt();
        int targetMoney = scanner.nextInt();

        int[] coinTypes = new int[coinTypeCount];
        for (int i = 0; i < coinTypeCount; i++) {
            coinTypes[i] = scanner.nextInt();

        }

        // when
        int moneyCount = 0;
        for (int i = coinTypeCount - 1; i >= 0; i--) {
            moneyCount += targetMoney / coinTypes[i];
            targetMoney = targetMoney % coinTypes[i];
        }

        // then
        System.out.println(moneyCount);
    }

    // https://www.acmicpc.net/problem/1931
    public static void 회의실_배정(Scanner scanner) {
        // given
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

    // https://www.acmicpc.net/problem/11399
    public static void atm(Scanner scanner) {
        // given
        int count = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(scanner.nextInt());
        }
        Collections.sort(numbers);

        // when
        int sum = 0;
        int preNumber = 0;
        for (Integer number : numbers) {
            int total = number + preNumber;
            sum += total;
            preNumber = total;
        }

        // then
        System.out.println(sum);
    }

    // https://www.acmicpc.net/problem/1541
    public static void 잃어버린_괄호(Scanner scanner) {
        // given
        String input = scanner.nextLine();

        // when
        String[] split = input.split("-");

        int result = 0;
        String[] plusNumbers = split[0].split("\\+");
        for (String number : plusNumbers) {
            result += Integer.parseInt(number);
        }

        for (int i = 1; i < split.length; i++) {
            String[] numbers = split[i].split("\\+");
            for (String number : numbers) {
                result -= Integer.parseInt(number);
            }
        }

        // then
        System.out.println(result);
    }

    // https://www.acmicpc.net/problem/13305
    public static void 주유소(Scanner scanner) {
        // given
        int cityCount = scanner.nextInt();
        int[] cityDistance = new int[cityCount - 1];
        int[] cityPrice = new int[cityCount];

        for (int i = 0; i < cityCount - 1; i++) {
            cityDistance[i] = scanner.nextInt();
        }

        for (int i = 0; i < cityCount; i++) {
            cityPrice[i] = scanner.nextInt();
        }

        // when
        long minPrice = Integer.MAX_VALUE;
        long price = 0;
        for (int i = 0; i < cityCount - 1; i++) {
            if (minPrice > cityPrice[i]) {
                minPrice = cityPrice[i];
            }
            price += minPrice * cityDistance[i];
        }

        // then
        System.out.println(price);
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
