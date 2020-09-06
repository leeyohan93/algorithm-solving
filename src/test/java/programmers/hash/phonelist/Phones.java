package programmers.hash.phonelist;

import java.util.*;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Phones {
    private static final int MIN_SIZE = 1;
    private static final int MAX_SIZE = 1000000;

    private final List<Phone> phones;

    public static Phones from(final String[] phones) {
        if (!isRightSize(phones.length)) {
            throw new IllegalArgumentException(String.format("Phones 길이는 %d와 %d 사이입니다", MIN_SIZE, MAX_SIZE));
        }
        return Arrays.stream(phones)
                .map(Phone::new)
                .collect(collectingAndThen(toList(), Phones::new));
    }

    private static boolean isRightSize(final int size) {
        return size >= MIN_SIZE && size <= MAX_SIZE;
    }

    public Phones(final List<Phone> phones) {
        this.phones = new ArrayList<>(Collections.unmodifiableList(phones));
    }

    public boolean isNoneDuplicatePrefix() {
        return phones.stream()
                .noneMatch(phone -> getPrefixPhones(phone).contains(phone));
    }

    private Phones getPrefixPhones(final Phone standard) {
        return phones.stream()
                .filter(phone -> !phone.equals(standard))
                .filter(phone -> phone.getNumberLength() >= standard.getNumberLength())
                .map(phone -> Phone.createPrefixPhone(phone, standard.getNumberLength()))
                .collect(collectingAndThen(toList(), Phones::new));
    }

    public boolean contains(Phone phone) {
        return phones.contains(phone);
    }
}
