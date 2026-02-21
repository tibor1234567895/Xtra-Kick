package dc;

import ec.g;
import ec.l;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ma.z;
import xa.j;

public final class u0 extends r {

    /* renamed from: e  reason: collision with root package name */
    public static final f0 f4826e = f0.f4761i.getClass();

    /* renamed from: b  reason: collision with root package name */
    public final f0 f4827b;

    /* renamed from: c  reason: collision with root package name */
    public final r f4828c;

    /* renamed from: d  reason: collision with root package name */
    public final Map f4829d;

    static {
        new t0(0);
    }

    public u0(f0 f0Var, z zVar, LinkedHashMap linkedHashMap) {
        this.f4827b = f0Var;
        this.f4828c = zVar;
        this.f4829d = linkedHashMap;
    }

    public final n0 a(f0 f0Var) {
        throw new IOException("zip file systems are read-only");
    }

    public final void b(f0 f0Var, f0 f0Var2) {
        j.f("source", f0Var);
        j.f("target", f0Var2);
        throw new IOException("zip file systems are read-only");
    }

    public final void c(f0 f0Var) {
        throw new IOException("zip file systems are read-only");
    }

    public final void d(f0 f0Var) {
        j.f("path", f0Var);
        throw new IOException("zip file systems are read-only");
    }

    public final List g(f0 f0Var) {
        j.f("dir", f0Var);
        f0 f0Var2 = f4826e;
        f0Var2.getClass();
        g gVar = (g) this.f4829d.get(l.b(f0Var2, f0Var, true));
        if (gVar != null) {
            List J = z.J(gVar.f5374h);
            j.c(J);
            return J;
        }
        throw new IOException("not a directory: " + f0Var);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final dc.p i(dc.f0 r13) {
        /*
            r12 = this;
            java.lang.String r0 = "path"
            xa.j.f(r0, r13)
            dc.f0 r0 = f4826e
            r0.getClass()
            r1 = 1
            dc.f0 r13 = ec.l.b(r0, r13, r1)
            java.util.Map r0 = r12.f4829d
            java.lang.Object r13 = r0.get(r13)
            ec.g r13 = (ec.g) r13
            r0 = 0
            if (r13 != 0) goto L_0x001b
            return r0
        L_0x001b:
            dc.p r10 = new dc.p
            boolean r3 = r13.f5368b
            r2 = r3 ^ 1
            r4 = 0
            if (r3 == 0) goto L_0x0026
            r5 = r0
            goto L_0x002d
        L_0x0026:
            long r5 = r13.f5370d
            java.lang.Long r1 = java.lang.Long.valueOf(r5)
            r5 = r1
        L_0x002d:
            r6 = 0
            java.lang.Long r7 = r13.f5372f
            r8 = 0
            r9 = 128(0x80, float:1.794E-43)
            r1 = r10
            r1.<init>((boolean) r2, (boolean) r3, (dc.f0) r4, (java.lang.Long) r5, (java.lang.Long) r6, (java.lang.Long) r7, (java.lang.Long) r8, (int) r9)
            r1 = -1
            long r3 = r13.f5373g
            int r13 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r13 != 0) goto L_0x0040
            return r10
        L_0x0040:
            dc.r r13 = r12.f4828c
            dc.f0 r1 = r12.f4827b
            dc.y r13 = r13.j(r1)
            dc.o r1 = r13.k(r3)     // Catch:{ all -> 0x0056 }
            dc.i0 r1 = hb.h0.o(r1)     // Catch:{ all -> 0x0056 }
            r13.close()     // Catch:{ all -> 0x0054 }
            goto L_0x0064
        L_0x0054:
            r0 = move-exception
            goto L_0x0064
        L_0x0056:
            r1 = move-exception
            if (r13 == 0) goto L_0x0061
            r13.close()     // Catch:{ all -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r13 = move-exception
            la.a.a(r1, r13)
        L_0x0061:
            r11 = r1
            r1 = r0
            r0 = r11
        L_0x0064:
            if (r0 != 0) goto L_0x0071
            xa.j.c(r1)
            dc.p r13 = hb.h0.q1(r1, r10)
            xa.j.c(r13)
            return r13
        L_0x0071:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.u0.i(dc.f0):dc.p");
    }

    public final y j(f0 f0Var) {
        j.f("file", f0Var);
        throw new UnsupportedOperationException("not implemented yet!");
    }

    public final n0 k(f0 f0Var) {
        j.f("file", f0Var);
        throw new IOException("zip file systems are read-only");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final dc.p0 l(dc.f0 r9) {
        /*
            r8 = this;
            java.lang.String r0 = "file"
            xa.j.f(r0, r9)
            dc.f0 r0 = f4826e
            r0.getClass()
            r1 = 1
            dc.f0 r0 = ec.l.b(r0, r9, r1)
            java.util.Map r2 = r8.f4829d
            java.lang.Object r0 = r2.get(r0)
            ec.g r0 = (ec.g) r0
            if (r0 == 0) goto L_0x006e
            dc.r r9 = r8.f4828c
            dc.f0 r2 = r8.f4827b
            dc.y r9 = r9.j(r2)
            r2 = 0
            long r3 = r0.f5373g     // Catch:{ all -> 0x0033 }
            dc.o r3 = r9.k(r3)     // Catch:{ all -> 0x0033 }
            dc.i0 r3 = hb.h0.o(r3)     // Catch:{ all -> 0x0033 }
            r9.close()     // Catch:{ all -> 0x0031 }
            r9 = r2
            goto L_0x0040
        L_0x0031:
            r9 = move-exception
            goto L_0x0040
        L_0x0033:
            r3 = move-exception
            if (r9 == 0) goto L_0x003e
            r9.close()     // Catch:{ all -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r9 = move-exception
            la.a.a(r3, r9)
        L_0x003e:
            r9 = r3
            r3 = r2
        L_0x0040:
            if (r9 != 0) goto L_0x006d
            xa.j.c(r3)
            hb.h0.q1(r3, r2)
            int r9 = r0.f5371e
            long r4 = r0.f5370d
            if (r9 != 0) goto L_0x0054
            ec.b r9 = new ec.b
            r9.<init>(r3, r4, r1)
            goto L_0x006c
        L_0x0054:
            dc.x r9 = new dc.x
            ec.b r2 = new ec.b
            long r6 = r0.f5369c
            r2.<init>(r3, r6, r1)
            java.util.zip.Inflater r0 = new java.util.zip.Inflater
            r0.<init>(r1)
            r9.<init>((dc.p0) r2, (java.util.zip.Inflater) r0)
            ec.b r0 = new ec.b
            r1 = 0
            r0.<init>(r9, r4, r1)
            r9 = r0
        L_0x006c:
            return r9
        L_0x006d:
            throw r9
        L_0x006e:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "no such file: "
            r1.<init>(r2)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.u0.l(dc.f0):dc.p0");
    }
}
