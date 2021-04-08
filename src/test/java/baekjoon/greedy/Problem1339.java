package baekjoon.greedy;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Problem1339 {

    // https://www.acmicpc.net/problem/1339
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words.add(scanner.nextLine());

        }

        Map<String, Integer> alphabetMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String word = words.get(i);
            String[] split = word.split("");
            for (int j = 0; j < split.length; j++) {
                String key = split[j];
                int digit = split.length - (j + 1);
                alphabetMap.put(key, alphabetMap.getOrDefault(key, 0) + (int) Math.pow(10, digit));
            }
        }
        List<Integer> alphabetCounts = alphabetMap.entrySet()
                .stream()
                .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Entry::getValue)
                .collect(Collectors.toList());

        int maxNumber = 9;
        int sum = 0;
        for (Integer alphabetCount : alphabetCounts) {
            sum += alphabetCount * maxNumber;
            maxNumber--;
        }

        System.out.println(sum);
    }
}
