package dc;

import ec.l;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import xa.j;

public final class f0 implements Comparable {

    /* renamed from: i  reason: collision with root package name */
    public static final e0 f4761i = new e0(0);

    /* renamed from: j  reason: collision with root package name */
    public static final String f4762j;

    /* renamed from: h  reason: collision with root package name */
    public final n f4763h;

    static {
        String str = File.separator;
        j.e("separator", str);
        f4762j = str;
    }

    public f0(n nVar) {
        j.f("bytes", nVar);
        this.f4763h = nVar;
    }

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList();
        int a10 = l.a(this);
        n nVar = this.f4763h;
        if (a10 == -1) {
            a10 = 0;
        } else if (a10 < nVar.d() && nVar.i(a10) == 92) {
            a10++;
        }
        int d10 = nVar.d();
        int i10 = a10;
        while (a10 < d10) {
            if (nVar.i(a10) == 47 || nVar.i(a10) == 92) {
                arrayList.add(nVar.n(i10, a10));
                i10 = a10 + 1;
            }
            a10++;
        }
        if (i10 < nVar.d()) {
            arrayList.add(nVar.n(i10, nVar.d()));
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0092, code lost:
        if (r1.m(0, r3, r3.d()) != false) goto L_0x00c8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final dc.f0 b() {
        /*
            r9 = this;
            dc.n r0 = ec.l.f5389d
            dc.n r1 = r9.f4763h
            boolean r2 = xa.j.a(r1, r0)
            if (r2 != 0) goto L_0x00c8
            dc.n r2 = ec.l.f5386a
            boolean r3 = xa.j.a(r1, r2)
            if (r3 != 0) goto L_0x00c8
            dc.n r3 = ec.l.f5387b
            boolean r4 = xa.j.a(r1, r3)
            if (r4 != 0) goto L_0x00c8
            dc.n r4 = ec.l.f5390e
            r1.getClass()
            java.lang.String r5 = "suffix"
            xa.j.f(r5, r4)
            int r5 = r1.d()
            byte[] r6 = r4.f4804h
            int r7 = r6.length
            int r5 = r5 - r7
            int r6 = r6.length
            boolean r4 = r1.m(r5, r4, r6)
            r5 = 1
            r6 = 0
            r7 = 2
            if (r4 == 0) goto L_0x0058
            int r4 = r1.d()
            if (r4 != r7) goto L_0x003d
            goto L_0x0056
        L_0x003d:
            int r4 = r1.d()
            int r4 = r4 + -3
            boolean r4 = r1.m(r4, r2, r5)
            if (r4 == 0) goto L_0x004a
            goto L_0x0056
        L_0x004a:
            int r4 = r1.d()
            int r4 = r4 + -3
            boolean r4 = r1.m(r4, r3, r5)
            if (r4 == 0) goto L_0x0058
        L_0x0056:
            r4 = 1
            goto L_0x0059
        L_0x0058:
            r4 = 0
        L_0x0059:
            if (r4 == 0) goto L_0x005d
            goto L_0x00c8
        L_0x005d:
            int r2 = dc.n.k(r1, r2)
            r4 = -1
            if (r2 == r4) goto L_0x0065
            goto L_0x0069
        L_0x0065:
            int r2 = dc.n.k(r1, r3)
        L_0x0069:
            if (r2 != r7) goto L_0x0083
            java.lang.Character r8 = r9.f()
            if (r8 == 0) goto L_0x0083
            int r0 = r1.d()
            r2 = 3
            if (r0 != r2) goto L_0x0079
            goto L_0x00c8
        L_0x0079:
            dc.f0 r0 = new dc.f0
            dc.n r1 = dc.n.o(r1, r6, r2, r5)
            r0.<init>(r1)
            goto L_0x00c6
        L_0x0083:
            if (r2 != r5) goto L_0x0095
            java.lang.String r8 = "prefix"
            xa.j.f(r8, r3)
            int r8 = r3.d()
            boolean r3 = r1.m(r6, r3, r8)
            if (r3 == 0) goto L_0x0095
            goto L_0x00c8
        L_0x0095:
            if (r2 != r4) goto L_0x00ae
            java.lang.Character r3 = r9.f()
            if (r3 == 0) goto L_0x00ae
            int r0 = r1.d()
            if (r0 != r7) goto L_0x00a4
            goto L_0x00c8
        L_0x00a4:
            dc.f0 r0 = new dc.f0
            dc.n r1 = dc.n.o(r1, r6, r7, r5)
            r0.<init>(r1)
            goto L_0x00c6
        L_0x00ae:
            if (r2 != r4) goto L_0x00b6
            dc.f0 r1 = new dc.f0
            r1.<init>(r0)
            goto L_0x00c9
        L_0x00b6:
            dc.f0 r0 = new dc.f0
            if (r2 != 0) goto L_0x00bf
            dc.n r1 = dc.n.o(r1, r6, r5, r5)
            goto L_0x00c3
        L_0x00bf:
            dc.n r1 = dc.n.o(r1, r6, r2, r5)
        L_0x00c3:
            r0.<init>(r1)
        L_0x00c6:
            r1 = r0
            goto L_0x00c9
        L_0x00c8:
            r1 = 0
        L_0x00c9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.f0.b():dc.f0");
    }

    public final f0 c(String str) {
        j.f("child", str);
        j jVar = new j();
        jVar.X0(str);
        return l.b(this, l.d(jVar, false), false);
    }

    public final int compareTo(Object obj) {
        f0 f0Var = (f0) obj;
        j.f("other", f0Var);
        return this.f4763h.compareTo(f0Var.f4763h);
    }

    public final File d() {
        return new File(toString());
    }

    public final Path e() {
        Path s10 = Paths.get(toString(), new String[0]);
        j.e("get(toString())", s10);
        return s10;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f0) || !j.a(((f0) obj).f4763h, this.f4763h)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003b, code lost:
        if (r0 == false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Character f() {
        /*
            r4 = this;
            dc.n r0 = ec.l.f5386a
            dc.n r1 = r4.f4763h
            int r0 = dc.n.g(r1, r0)
            r2 = -1
            if (r0 == r2) goto L_0x000c
            goto L_0x003d
        L_0x000c:
            int r0 = r1.d()
            r2 = 2
            if (r0 >= r2) goto L_0x0014
            goto L_0x003d
        L_0x0014:
            r0 = 1
            byte r2 = r1.i(r0)
            r3 = 58
            if (r2 == r3) goto L_0x001e
            goto L_0x003d
        L_0x001e:
            r2 = 0
            byte r1 = r1.i(r2)
            char r1 = (char) r1
            r3 = 97
            if (r3 > r1) goto L_0x002e
            r3 = 123(0x7b, float:1.72E-43)
            if (r1 >= r3) goto L_0x002e
            r3 = 1
            goto L_0x002f
        L_0x002e:
            r3 = 0
        L_0x002f:
            if (r3 != 0) goto L_0x003f
            r3 = 65
            if (r3 > r1) goto L_0x003a
            r3 = 91
            if (r1 >= r3) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r0 = 0
        L_0x003b:
            if (r0 != 0) goto L_0x003f
        L_0x003d:
            r0 = 0
            goto L_0x0043
        L_0x003f:
            java.lang.Character r0 = java.lang.Character.valueOf(r1)
        L_0x0043:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.f0.f():java.lang.Character");
    }

    public final int hashCode() {
        return this.f4763h.hashCode();
    }

    public final String toString() {
        return this.f4763h.q();
    }
}
