package d3;

import j1.a;
import java.util.Collections;
import java.util.List;
import w2.d;

public final class b implements d {

    /* renamed from: i  reason: collision with root package name */
    public static final b f4323i = new b();

    /* renamed from: h  reason: collision with root package name */
    public final List f4324h;

    private b() {
        this.f4324h = Collections.emptyList();
    }

    public final int a(long j10) {
        return j10 < 0 ? 0 : -1;
    }

    public final long b(int i10) {
        a.b(i10 == 0);
        return 0;
    }

    public final List c(long j10) {
        return j10 >= 0 ? this.f4324h : Collections.emptyList();
    }

    public final int d() {
        return 1;
    }

    public b(i1.b bVar) {
        this.f4324h = Collections.singletonList(bVar);
    }
}
