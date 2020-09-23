package programmers.sort.bignumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AppendNumbers {
    private final List<AppendNumber> appendNumbers;

    public static AppendNumbers from(int[] numbers) {
        return Arrays.stream(numbers)
                .mapToObj(AppendNumber::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), AppendNumbers::new));
    }

    public AppendNumbers(final List<AppendNumber> appendNumbers) {
        this.appendNumbers = new ArrayList<>(Collections.unmodifiableList(appendNumbers));
    }

    public String append() {
        appendNumbers.sort((a, b) -> -a.append(b).minus(b.append(a)));

        String appendedNumber = appendNumbers.stream()
                .map(AppendNumber::toString)
                .reduce((a, b) -> a + b)
                .orElse("");

        if (appendedNumber.charAt(0) == '0') {
            return "0";
        }
        return appendedNumber;
    }
}
