package programmers.sort.k;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private final List<Integer> numbers;

    public static Numbers from(int[] numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Numbers::new));
    }

    public Numbers(final List<Integer> numbers) {
        this.numbers = new ArrayList<>(Collections.unmodifiableList(numbers));
    }

    public Numbers subNumbers(int fromIndex, int toIndex) {
        return numbers.subList(fromIndex, toIndex)
                .stream()
                .sorted()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Numbers::new));
    }

    public int getNumber(int index) {
        return numbers.get(index);
    }
}
