package i1;

import android.os.Bundle;
import d9.o0;
import d9.p0;
import d9.r0;
import d9.r1;
import g1.m;
import j1.c;
import j1.l0;
import java.util.List;

public final class d implements m {

    /* renamed from: j  reason: collision with root package name */
    public static final d f7990j = new d(0, r1.f4658l);

    /* renamed from: k  reason: collision with root package name */
    public static final String f7991k = l0.C(0);

    /* renamed from: l  reason: collision with root package name */
    public static final String f7992l = l0.C(1);

    /* renamed from: m  reason: collision with root package name */
    public static final c f7993m = new c(0);

    /* renamed from: h  reason: collision with root package name */
    public final r0 f7994h;

    /* renamed from: i  reason: collision with root package name */
    public final long f7995i;

    static {
        p0 p0Var = r0.f4657i;
    }

    public d(long j10, List list) {
        this.f7994h = r0.j(list);
        this.f7995i = j10;
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        p0 p0Var = r0.f4657i;
        o0 o0Var = new o0();
        int i10 = 0;
        while (true) {
            r0 r0Var = this.f7994h;
            if (i10 < r0Var.size()) {
                if (((b) r0Var.get(i10)).f7975k == null) {
                    o0Var.c((b) r0Var.get(i10));
                }
                i10++;
            } else {
                bundle.putParcelableArrayList(f7991k, c.b(o0Var.e()));
                bundle.putLong(f7992l, this.f7995i);
                return bundle;
            }
        }
    }
}
