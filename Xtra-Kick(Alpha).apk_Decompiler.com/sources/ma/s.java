package ma;

import java.util.Collection;
import xa.j;

public class s extends r {
    public static final int i(Iterable iterable) {
        j.f("<this>", iterable);
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return 10;
    }
}
