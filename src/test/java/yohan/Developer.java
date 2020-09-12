package yohan;

import java.util.Arrays;

import static yohan.DevelopField.BACK_END;
import static yohan.Skill.*;

public class Developer {
    private final DevelopField developField;
    private final Skills skils;
    private final Moto moto;

    public static Developer yohan() {
        return new Developer(
                BACK_END,
                new Skills(Arrays.asList(JAVA, SPRING, JPA, PREPARING_AWS_ASSOCIATE, TDD, DDD, ETC)),
                Moto.fromJobs() // "Stay hungry, Stay foolish"
        );
    }

    public Developer(final DevelopField developField, final Skills skils, final Moto moto) {
        this.developField = developField;
        this.skils = skils;
        this.moto = moto;
    }
}
