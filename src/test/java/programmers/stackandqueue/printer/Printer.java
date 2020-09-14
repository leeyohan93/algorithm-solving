package programmers.stackandqueue.printer;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Printer {
    private final LinkedList<Page> pages;

    public static Printer from(int[] priorities) {
        int length = priorities.length;
        return IntStream.range(0, length)
                .mapToObj(index -> new Page(index, priorities[index]))
                .collect(Collectors.collectingAndThen(toLinkedList(), Printer::new));
    }

    private static Collector<Page, ?, LinkedList<Page>> toLinkedList() {
        return Collector.of(LinkedList::new,
                LinkedList::add,
                (first, second) -> {
                    first.addAll(second);
                    return first;
                });
    }

    public Printer(final LinkedList<Page> pages) {
        this.pages = new LinkedList<>(Collections.unmodifiableList(pages));
    }

    public List<Page> print() {
        LinkedList<Page> printQueue = new LinkedList(pages);
        List<Page> printedPage = new ArrayList<>();
        while (!printQueue.isEmpty()) {
            Page page = printQueue.removeFirst();
            if (isBiggerPrioritiesThen(printQueue, page)) {
                printQueue.addLast(page);
                continue;
            }
            printedPage.add(page);
        }
        return printedPage;
    }

    private boolean isBiggerPrioritiesThen(final List<Page> printQueue, final Page standardPage) {
        return printQueue.stream()
                .anyMatch(page -> page.compareTo(standardPage) > 0);
    }

    public int getPrintOrder(int location) {
        Page target = pages.get(location);

        List<Page> printedPage = print();
        return IntStream.range(0, printedPage.size())
                .filter(index -> printedPage.get(index).equals(target))
                .findAny()
                .orElseThrow(IllegalArgumentException::new)
                + 1;
    }
}
