package d9;

import c9.w;
import java.io.Serializable;
import java.util.ArrayList;

public final class h1 implements w, Serializable {

    /* renamed from: h  reason: collision with root package name */
    public final int f4622h;

    public h1(int i10) {
        u.a(i10, "expectedValuesPerKey");
        this.f4622h = i10;
    }

    public final Object get() {
        return new ArrayList(this.f4622h);
    }
}
