package programmers.sort.hindex;

public class Paper implements Comparable<Paper> {
    private final int quoteCount;

    public Paper(final int quoteCount) {
        this.quoteCount = quoteCount;
    }

    public boolean isEqualOrMoreQuote(Paper otherPaper) {
        return this.quoteCount >= otherPaper.quoteCount;
    }

    public boolean isEqualOrMoreQuote(int quoteCount) {
        return this.quoteCount > quoteCount;
    }

    public int getQuoteCount() {
        return quoteCount;
    }

    @Override
    public int compareTo(final Paper o) {
        return o.quoteCount - this.quoteCount;
    }
}
