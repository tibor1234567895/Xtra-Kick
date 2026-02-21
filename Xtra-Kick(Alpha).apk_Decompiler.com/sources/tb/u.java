package tb;

import android.support.v4.media.h;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import pb.p0;
import sb.c;
import sb.g;
import xa.j;
import xb.s;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public final int f15022a = 5;

    /* renamed from: b  reason: collision with root package name */
    public final long f15023b;

    /* renamed from: c  reason: collision with root package name */
    public final c f15024c;

    /* renamed from: d  reason: collision with root package name */
    public final t f15025d;

    /* renamed from: e  reason: collision with root package name */
    public final ConcurrentLinkedQueue f15026e;

    static {
        new s(0);
    }

    public u(g gVar, TimeUnit timeUnit) {
        j.f("taskRunner", gVar);
        this.f15023b = timeUnit.toNanos(5);
        this.f15024c = gVar.f();
        this.f15025d = new t(this, h.p(new StringBuilder(), qb.h.f13495c, " ConnectionPool"));
        this.f15026e = new ConcurrentLinkedQueue();
    }

    public final int a(r rVar, long j10) {
        p0 p0Var = qb.h.f13493a;
        ArrayList arrayList = rVar.f15018r;
        int i10 = 0;
        while (i10 < arrayList.size()) {
            Reference reference = (Reference) arrayList.get(i10);
            if (reference.get() != null) {
                i10++;
            } else {
                s.f16851a.getClass();
                s.f16852b.j("A connection to " + rVar.f15003c.f13006a.f12763i + " was leaked. Did you forget to close a response body?", ((m) reference).f14978a);
                arrayList.remove(i10);
                rVar.f15012l = true;
                if (arrayList.isEmpty()) {
                    rVar.f15019s = j10 - this.f15023b;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }
}
