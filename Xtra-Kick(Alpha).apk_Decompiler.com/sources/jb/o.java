package jb;

import android.support.v4.media.h;
import androidx.fragment.app.y;
import hb.h0;
import la.a;
import pa.e;
import wa.l;
import xa.v;

public final class o extends c {

    /* renamed from: s  reason: collision with root package name */
    public final a f8927s;

    public o(int i10, a aVar, l lVar) {
        super(i10, lVar);
        boolean z10;
        this.f8927s = aVar;
        boolean z11 = false;
        if (aVar != a.SUSPEND) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (!(i10 >= 1 ? true : z11)) {
                throw new IllegalArgumentException(h.j("Buffered channel capacity must be at least 1, but ", i10, " was specified").toString());
            }
            return;
        }
        throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + v.a(c.class).b() + " instead").toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e1, code lost:
        r0 = jb.k.f8923a;
        r1 = la.v.f9814a;
        r0.getClass();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object E(java.lang.Object r20, boolean r21) {
        /*
            r19 = this;
            r8 = r19
            jb.a r0 = jb.a.DROP_LATEST
            jb.a r1 = r8.f8927s
            r9 = 0
            r10 = 1
            if (r1 != r0) goto L_0x0035
            java.lang.Object r0 = super.h(r20)
            jb.i r1 = jb.k.f8923a
            boolean r1 = r0 instanceof jb.j
            r1 = r1 ^ r10
            if (r1 != 0) goto L_0x00ea
            boolean r1 = r0 instanceof jb.h
            if (r1 == 0) goto L_0x001b
            goto L_0x00ea
        L_0x001b:
            if (r21 == 0) goto L_0x002b
            wa.l r0 = r8.f8898i
            if (r0 == 0) goto L_0x002b
            r11 = r20
            androidx.fragment.app.y r0 = hb.h0.v(r0, r11, r9)
            if (r0 != 0) goto L_0x002a
            goto L_0x002b
        L_0x002a:
            throw r0
        L_0x002b:
            jb.i r0 = jb.k.f8923a
            la.v r1 = la.v.f9814a
            r0.getClass()
        L_0x0032:
            r0 = r1
            goto L_0x00ea
        L_0x0035:
            r11 = r20
            h3.u1 r12 = jb.e.f8903d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = jb.c.f8892n
            java.lang.Object r0 = r0.get(r8)
            jb.l r0 = (jb.l) r0
        L_0x0041:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = jb.c.f8888j
            long r1 = r1.getAndIncrement(r8)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r13 = r1 & r3
            r3 = 0
            boolean r15 = r8.u(r1, r3)
            int r7 = jb.e.f8901b
            long r4 = (long) r7
            long r1 = r13 / r4
            long r9 = r13 % r4
            int r10 = (int) r9
            r16 = r4
            long r3 = r0.f10890j
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 == 0) goto L_0x0070
            jb.l r1 = jb.c.c(r8, r1, r0)
            if (r1 != 0) goto L_0x006e
            if (r15 == 0) goto L_0x006c
            goto L_0x00b6
        L_0x006c:
            r1 = 1
            goto L_0x0096
        L_0x006e:
            r9 = r1
            goto L_0x0071
        L_0x0070:
            r9 = r0
        L_0x0071:
            r0 = r19
            r1 = r9
            r2 = r10
            r3 = r20
            r4 = r13
            r6 = r12
            r18 = r7
            r7 = r15
            int r0 = jb.c.d(r0, r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto L_0x00de
            r1 = 1
            if (r0 == r1) goto L_0x00e1
            r2 = 2
            if (r0 == r2) goto L_0x00b1
            r2 = 3
            if (r0 == r2) goto L_0x00a5
            r2 = 4
            if (r0 == r2) goto L_0x0099
            r2 = 5
            if (r0 == r2) goto L_0x0092
            goto L_0x0095
        L_0x0092:
            r9.a()
        L_0x0095:
            r0 = r9
        L_0x0096:
            r9 = 0
            r10 = 1
            goto L_0x0041
        L_0x0099:
            long r0 = r19.q()
            int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x00b6
            r9.a()
            goto L_0x00b6
        L_0x00a5:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "unexpected"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00b1:
            if (r15 == 0) goto L_0x00c4
            r9.h()
        L_0x00b6:
            jb.i r0 = jb.k.f8923a
            java.lang.Throwable r1 = r19.r()
            r0.getClass()
            jb.h r0 = jb.i.a(r1)
            goto L_0x00ea
        L_0x00c4:
            boolean r0 = r12 instanceof hb.k2
            if (r0 == 0) goto L_0x00cc
            r0 = r12
            hb.k2 r0 = (hb.k2) r0
            goto L_0x00cd
        L_0x00cc:
            r0 = 0
        L_0x00cd:
            if (r0 == 0) goto L_0x00d4
            int r7 = r10 + r18
            r0.a(r9, r7)
        L_0x00d4:
            long r0 = r9.f10890j
            long r0 = r0 * r16
            long r2 = (long) r10
            long r0 = r0 + r2
            r8.k(r0)
            goto L_0x00e1
        L_0x00de:
            r9.a()
        L_0x00e1:
            jb.i r0 = jb.k.f8923a
            la.v r1 = la.v.f9814a
            r0.getClass()
            goto L_0x0032
        L_0x00ea:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jb.o.E(java.lang.Object, boolean):java.lang.Object");
    }

    public final Object g(Object obj, e eVar) {
        y v10;
        Object E = E(obj, true);
        boolean z10 = E instanceof h;
        if (!z10) {
            return la.v.f9814a;
        }
        i iVar = k.f8923a;
        if (z10) {
            h hVar = (h) E;
        }
        l lVar = this.f8898i;
        if (lVar == null || (v10 = h0.v(lVar, obj, (y) null)) == null) {
            throw r();
        }
        a.a(v10, r());
        throw v10;
    }

    public final Object h(Object obj) {
        return E(obj, false);
    }

    public final boolean v() {
        return this.f8927s == a.DROP_OLDEST;
    }
}
