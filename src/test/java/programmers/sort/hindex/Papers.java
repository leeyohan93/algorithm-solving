package programmers.sort.hindex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Papers {
    private final List<Paper> papers;

    public static Papers from(int[] citations) {
        return Arrays.stream(citations)
                .mapToObj(Paper::new)
                .sorted()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Papers::new));
    }

    public Papers(final List<Paper> papers) {
        this.papers = new ArrayList<>(Collections.unmodifiableList(papers));
    }

    public int getHindex() {
        int maxQuot = papers.get(0).getQuoteCount();
        for (int i = maxQuot; i > 0; i--) {
            final int finalI = i;
            int equalOrMoreQuoteCount = (int) papers.stream()
                    .filter(otherPaper -> otherPaper.isEqualOrMoreQuote(finalI))
                    .count();
            if (equalOrMoreQuoteCount >= i) {
                return equalOrMoreQuoteCount;
            }
        }
        return 0;
    }
}
