package programmers.hash.unfinishedplayer;

import java.util.Objects;
import java.util.regex.Pattern;

public class Participant {
    private static final int NAME_LENGTH_LIMIT = 20;
    private static final String NAME_PATTERN = "^[a-z]*$";

    private final String name;

    public Participant(final String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException("이름을 입력 하세요.");
        }

        if (!isAvailableName(name)) {
            throw new IllegalArgumentException("20자 이내의 알파벳 소문자로 입력하세요.");
        }
        this.name = name;
    }

    private boolean isAvailableName(final String name) {
        return name.length() <= NAME_LENGTH_LIMIT && Pattern.matches(NAME_PATTERN, name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Participant)) return false;
        final Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
