package ab;

import java.util.Random;

public abstract class a extends e {
    public final int a() {
        return (c().nextInt() >>> 0) & -1;
    }

    public final int b() {
        return c().nextInt();
    }

    public abstract Random c();
}
