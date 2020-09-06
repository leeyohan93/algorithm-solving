package programmers.hash.phonelist;

import java.util.Objects;

public class Phone {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 20;

    private final String number;

    public static Phone createPrefixPhone(final Phone phone, final int length) {
        return new Phone(phone.getNumber().substring(0, length));
    }

    public Phone(final String number) {
        if (Objects.isNull(number) || number.isEmpty()) {
            throw new IllegalArgumentException("번호를 입력해 주세요");
        }

        if (!isNumber(number)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }

        if (!isRightLength(number.length())) {
            throw new IllegalArgumentException(String.format("%d~%d 자리만 입력 가능합니다.", MIN_LENGTH, MAX_LENGTH));
        }
        this.number = number;
    }

    public boolean isNumber(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException ignore) {
            return false;
        }
    }

    private boolean isRightLength(final int length) {
        return length >= MIN_LENGTH && length <= MAX_LENGTH;
    }

    public String getNumber() {
        return number;
    }

    public int getNumberLength() {
        return number.length();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;
        final Phone phone = (Phone) o;
        return Objects.equals(number, phone.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
