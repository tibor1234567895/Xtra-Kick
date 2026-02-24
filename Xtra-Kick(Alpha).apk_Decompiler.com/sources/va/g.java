package va;

import eb.h;
import java.io.File;
import java.util.Iterator;
import q0.f;

public final class g implements h {

    /* renamed from: a  reason: collision with root package name */
    public final File f15984a;

    /* renamed from: b  reason: collision with root package name */
    public final int f15985b = 2;

    /* renamed from: c  reason: collision with root package name */
    public final int f15986c = Integer.MAX_VALUE;

    public g(File file) {
        f.j("direction", 2);
        this.f15984a = file;
    }

    public final Iterator iterator() {
        return new e(this);
    }
}
