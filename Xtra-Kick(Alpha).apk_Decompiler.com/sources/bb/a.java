package bb;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import xa.j;

public final class a extends ab.a {
    public final Random c() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        j.e("current()", current);
        return current;
    }
}
