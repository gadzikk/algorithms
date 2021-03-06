package zobjects;

/**
 * Created by gadzik on 04.08.20.
 */
public class Pair<U, V> {
    public final U first;
    public final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public static <U, V> Pair<U, V> of(U a, V b) {
        return new Pair<>(a, b);
    }

    public U getKey() {
        return first;
    }

    public V getValue() {
        return second;
    }
}
