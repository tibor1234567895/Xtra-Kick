package androidx.lifecycle;

import android.os.Handler;
import androidx.activity.e;
import xa.j;

public final class y0 implements d0 {

    /* renamed from: p  reason: collision with root package name */
    public static final u0 f1792p = new u0(0);

    /* renamed from: q  reason: collision with root package name */
    public static final y0 f1793q = new y0();

    /* renamed from: h  reason: collision with root package name */
    public int f1794h;

    /* renamed from: i  reason: collision with root package name */
    public int f1795i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1796j = true;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1797k = true;

    /* renamed from: l  reason: collision with root package name */
    public Handler f1798l;

    /* renamed from: m  reason: collision with root package name */
    public final g0 f1799m = new g0(this);

    /* renamed from: n  reason: collision with root package name */
    public final e f1800n = new e(7, this);

    /* renamed from: o  reason: collision with root package name */
    public final x0 f1801o = new x0(this);

    private y0() {
    }

    public final void b() {
        int i10 = this.f1795i + 1;
        this.f1795i = i10;
        if (i10 != 1) {
            return;
        }
        if (this.f1796j) {
            this.f1799m.f(r.ON_RESUME);
            this.f1796j = false;
            return;
        }
        Handler handler = this.f1798l;
        j.c(handler);
        handler.removeCallbacks(this.f1800n);
    }

    public final t o() {
        return this.f1799m;
    }
}
