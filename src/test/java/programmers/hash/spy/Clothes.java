package programmers.hash.spy;

import java.util.*;

import static java.util.stream.Collectors.*;

public class Clothes {
    private final List<Cloth> clothes;

    public static Clothes from(String[][] clothes) {
        return Arrays.stream(clothes)
                .map(cloth -> new Cloth(cloth[1], cloth[0]))
                .collect(collectingAndThen(toList(), Clothes::new));
    }

    public Clothes(final List<Cloth> clothes) {
        this.clothes = new ArrayList<>(Collections.unmodifiableList(clothes));
    }

    public int getMatchCount() {
        Map<ClothType, Long> countByClothType = clothes.stream()
                .collect(groupingBy(Cloth::getClothType, mapping(Cloth::getName, counting())));

        int matchCount = countByClothType.values()
                .stream()
                .reduce(1L, (x, y) -> x * (y + 1))       // y + 1 : 옷을 입지 않은 경우의 수
                .intValue();

        return matchCount - 1;                              // 옷을 모두 입지 않은 경우의 수 제거
    }
}
