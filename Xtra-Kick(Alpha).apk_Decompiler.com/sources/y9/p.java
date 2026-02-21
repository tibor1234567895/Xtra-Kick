package y9;

import android.os.Handler;
import androidx.activity.h;
import androidx.lifecycle.p1;
import la.q;
import la.v;
import wa.a;
import xa.j;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final Object f17276a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public boolean f17277b;

    /* renamed from: c  reason: collision with root package name */
    public int f17278c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f17279d = ((Handler) new p1(23, this).b());

    /* renamed from: e  reason: collision with root package name */
    public final String f17280e;

    public p(String str) {
        j.g("namespace", str);
        this.f17280e = str;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:2|3|(3:5|6|7)|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0019 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f17276a
            monitor-enter(r0)
            boolean r1 = r3.f17277b     // Catch:{ all -> 0x001d }
            if (r1 != 0) goto L_0x0019
            r1 = 1
            r3.f17277b = r1     // Catch:{ all -> 0x001d }
            android.os.Handler r1 = r3.f17279d     // Catch:{ Exception -> 0x0019 }
            r2 = 0
            r1.removeCallbacksAndMessages(r2)     // Catch:{ Exception -> 0x0019 }
            android.os.Handler r1 = r3.f17279d     // Catch:{ Exception -> 0x0019 }
            android.os.Looper r1 = r1.getLooper()     // Catch:{ Exception -> 0x0019 }
            r1.quit()     // Catch:{ Exception -> 0x0019 }
        L_0x0019:
            la.v r1 = la.v.f9814a     // Catch:{ all -> 0x001d }
            monitor-exit(r0)
            return
        L_0x001d:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: y9.p.a():void");
    }

    public final void b() {
        synchronized (this.f17276a) {
            if (!this.f17277b) {
                int i10 = this.f17278c;
                if (i10 != 0) {
                    this.f17278c = i10 - 1;
                } else {
                    return;
                }
            }
            v vVar = v.f9814a;
        }
    }

    public final void c() {
        synchronized (this.f17276a) {
            if (!this.f17277b) {
                this.f17278c++;
            }
            v vVar = v.f9814a;
        }
    }

    public final void d(a aVar) {
        synchronized (this.f17276a) {
            if (!this.f17277b) {
                this.f17279d.post(new h(20, aVar));
            }
            v vVar = v.f9814a;
        }
    }

    public final void e(Runnable runnable) {
        j.g("runnable", runnable);
        synchronized (this.f17276a) {
            if (!this.f17277b) {
                this.f17279d.removeCallbacks(runnable);
            }
            v vVar = v.f9814a;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!j.a(p.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            return !(j.a(this.f17280e, ((p) obj).f17280e) ^ true);
        }
        throw new q("null cannot be cast to non-null type com.tonyodev.fetch2core.HandlerWrapper");
    }

    public final int f() {
        int i10;
        synchronized (this.f17276a) {
            i10 = !this.f17277b ? this.f17278c : 0;
        }
        return i10;
    }

    public final int hashCode() {
        return this.f17280e.hashCode();
    }
}
