package yohan;

public class Moto {
    private final String moto;

    public Moto(final String moto) {
        this.moto = moto;
    }

    public static Moto fromJobs() {
        return new Moto("Stay hungry, Stay foolish.");
    }
}
