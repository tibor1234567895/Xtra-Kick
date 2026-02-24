package hb;

import mb.l;
import pa.a;
import pa.b;
import pa.g;
import pa.h;
import pa.i;
import pa.k;
import xa.j;

public abstract class d0 extends a implements g {

    /* renamed from: i  reason: collision with root package name */
    public static final c0 f7785i = new c0(0);

    public d0() {
        super(g.f12752g);
    }

    public abstract void M0(k kVar, Runnable runnable);

    public final h N(i iVar) {
        boolean z10;
        j.f("key", iVar);
        if (iVar instanceof b) {
            b bVar = (b) iVar;
            i iVar2 = this.f12745h;
            j.f("key", iVar2);
            if (iVar2 == bVar || bVar.f12747i == iVar2) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                h hVar = (h) bVar.f12746h.invoke(this);
                if (hVar instanceof h) {
                    return hVar;
                }
            }
        } else if (g.f12752g == iVar) {
            return this;
        }
        return null;
    }

    public void N0(k kVar, Runnable runnable) {
        M0(kVar, runnable);
    }

    public boolean O0(k kVar) {
        return !(this instanceof h2);
    }

    public d0 P0(int i10) {
        h0.x(i10);
        return new l(this, i10);
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + h0.r0(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        if (((pa.h) r3.f12746h.invoke(r2)) != null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        if (pa.g.f12752g == r3) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final pa.k w(pa.i r3) {
        /*
            r2 = this;
            java.lang.String r0 = "key"
            xa.j.f(r0, r3)
            boolean r1 = r3 instanceof pa.b
            if (r1 == 0) goto L_0x0027
            pa.b r3 = (pa.b) r3
            pa.i r1 = r2.f12745h
            xa.j.f(r0, r1)
            if (r1 == r3) goto L_0x0019
            pa.i r0 = r3.f12747i
            if (r0 != r1) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r0 = 0
            goto L_0x001a
        L_0x0019:
            r0 = 1
        L_0x001a:
            if (r0 == 0) goto L_0x002e
            wa.l r3 = r3.f12746h
            java.lang.Object r3 = r3.invoke(r2)
            pa.h r3 = (pa.h) r3
            if (r3 == 0) goto L_0x002e
            goto L_0x002b
        L_0x0027:
            pa.f r0 = pa.g.f12752g
            if (r0 != r3) goto L_0x002e
        L_0x002b:
            pa.l r3 = pa.l.f12754h
            goto L_0x002f
        L_0x002e:
            r3 = r2
        L_0x002f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.d0.w(pa.i):pa.k");
    }
}
