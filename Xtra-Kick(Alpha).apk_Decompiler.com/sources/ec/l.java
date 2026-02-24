package ec;

import android.support.v4.media.h;
import dc.f0;
import dc.m;
import dc.n;
import xa.j;

public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    public static final n f5386a = m.b(Constants.LIST_SEPARATOR);

    /* renamed from: b  reason: collision with root package name */
    public static final n f5387b = m.b("\\");

    /* renamed from: c  reason: collision with root package name */
    public static final n f5388c = m.b("/\\");

    /* renamed from: d  reason: collision with root package name */
    public static final n f5389d = m.b(".");

    /* renamed from: e  reason: collision with root package name */
    public static final n f5390e = m.b("..");

    static {
        n.f4802k.getClass();
    }

    public static final int a(f0 f0Var) {
        boolean z10;
        if (f0Var.f4763h.d() == 0) {
            return -1;
        }
        n nVar = f0Var.f4763h;
        boolean z11 = false;
        if (nVar.i(0) != 47) {
            if (nVar.i(0) == 92) {
                if (nVar.d() > 2 && nVar.i(1) == 92) {
                    n nVar2 = f5387b;
                    j.f("other", nVar2);
                    int f10 = nVar.f(2, nVar2.f4804h);
                    if (f10 == -1) {
                        return nVar.d();
                    }
                    return f10;
                }
            } else if (nVar.d() <= 2 || nVar.i(1) != 58 || nVar.i(2) != 92) {
                return -1;
            } else {
                char i10 = (char) nVar.i(0);
                if ('a' > i10 || i10 >= '{') {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (!z10) {
                    if ('A' <= i10 && i10 < '[') {
                        z11 = true;
                    }
                    if (!z11) {
                        return -1;
                    }
                }
                return 3;
            }
        }
        return 1;
    }

    public static final f0 b(f0 f0Var, f0 f0Var2, boolean z10) {
        boolean z11;
        j.f("<this>", f0Var);
        j.f("child", f0Var2);
        if (a(f0Var2) != -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 || f0Var2.f() != null) {
            return f0Var2;
        }
        n c10 = c(f0Var);
        if (c10 == null && (c10 = c(f0Var2)) == null) {
            c10 = f(f0.f4762j);
        }
        dc.j jVar = new dc.j();
        jVar.N0(f0Var.f4763h);
        if (jVar.f4787i > 0) {
            jVar.N0(c10);
        }
        jVar.N0(f0Var2.f4763h);
        return d(jVar, z10);
    }

    public static final n c(f0 f0Var) {
        n nVar = f0Var.f4763h;
        n nVar2 = f5386a;
        if (n.g(nVar, nVar2) != -1) {
            return nVar2;
        }
        n nVar3 = f5387b;
        if (n.g(f0Var.f4763h, nVar3) != -1) {
            return nVar3;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0093, code lost:
        if (r4 != false) goto L_0x0098;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0122 A[EDGE_INSN: B:101:0x0122->B:83:0x0122 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x013f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final dc.f0 d(dc.j r18, boolean r19) {
        /*
            r0 = r18
            dc.j r1 = new dc.j
            r1.<init>()
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x000a:
            dc.n r5 = f5386a
            r6 = 0
            boolean r5 = r0.E(r6, r5)
            if (r5 != 0) goto L_0x014c
            dc.n r5 = f5387b
            boolean r8 = r0.E(r6, r5)
            if (r8 == 0) goto L_0x001e
            goto L_0x014c
        L_0x001e:
            r8 = 2
            r9 = 1
            if (r4 < r8) goto L_0x002a
            boolean r8 = xa.j.a(r2, r5)
            if (r8 == 0) goto L_0x002a
            r8 = 1
            goto L_0x002b
        L_0x002a:
            r8 = 0
        L_0x002b:
            dc.n r10 = f5388c
            r11 = -1
            if (r8 == 0) goto L_0x0038
            xa.j.c(r2)
            r1.N0(r2)
            goto L_0x003d
        L_0x0038:
            if (r4 <= 0) goto L_0x0042
            xa.j.c(r2)
        L_0x003d:
            r1.N0(r2)
            goto L_0x00a8
        L_0x0042:
            long r13 = r0.z(r10)
            if (r2 != 0) goto L_0x005b
            int r2 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r2 != 0) goto L_0x0053
            java.lang.String r2 = dc.f0.f4762j
            dc.n r2 = f(r2)
            goto L_0x005b
        L_0x0053:
            byte r2 = r0.v(r13)
            dc.n r2 = e(r2)
        L_0x005b:
            boolean r4 = xa.j.a(r2, r5)
            r11 = 2
            if (r4 != 0) goto L_0x0064
            goto L_0x0096
        L_0x0064:
            long r4 = r0.f4787i
            int r17 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r17 >= 0) goto L_0x006b
            goto L_0x0096
        L_0x006b:
            r4 = 1
            byte r4 = r0.v(r4)
            r5 = 58
            if (r4 == r5) goto L_0x0076
            goto L_0x0096
        L_0x0076:
            byte r4 = r0.v(r6)
            char r4 = (char) r4
            r5 = 97
            if (r5 > r4) goto L_0x0085
            r5 = 123(0x7b, float:1.72E-43)
            if (r4 >= r5) goto L_0x0085
            r5 = 1
            goto L_0x0086
        L_0x0085:
            r5 = 0
        L_0x0086:
            if (r5 != 0) goto L_0x0098
            r5 = 65
            if (r5 > r4) goto L_0x0092
            r5 = 91
            if (r4 >= r5) goto L_0x0092
            r4 = 1
            goto L_0x0093
        L_0x0092:
            r4 = 0
        L_0x0093:
            if (r4 == 0) goto L_0x0096
            goto L_0x0098
        L_0x0096:
            r4 = 0
            goto L_0x0099
        L_0x0098:
            r4 = 1
        L_0x0099:
            if (r4 == 0) goto L_0x00a8
            int r4 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r4 != 0) goto L_0x00a5
            r4 = 3
            r1.o0(r0, r4)
            goto L_0x00a8
        L_0x00a5:
            r1.o0(r0, r11)
        L_0x00a8:
            long r4 = r1.f4787i
            int r11 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r11 <= 0) goto L_0x00b0
            r4 = 1
            goto L_0x00b1
        L_0x00b0:
            r4 = 0
        L_0x00b1:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
        L_0x00b6:
            boolean r11 = r18.R()
            dc.n r12 = f5389d
            if (r11 != 0) goto L_0x0122
            long r13 = r0.z(r10)
            r15 = -1
            int r11 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r11 != 0) goto L_0x00cd
            dc.n r11 = r18.m()
            goto L_0x00d4
        L_0x00cd:
            dc.n r11 = r0.n(r13)
            r18.readByte()
        L_0x00d4:
            dc.n r13 = f5390e
            boolean r14 = xa.j.a(r11, r13)
            if (r14 == 0) goto L_0x0110
            if (r4 == 0) goto L_0x00e4
            boolean r12 = r5.isEmpty()
            if (r12 != 0) goto L_0x00b6
        L_0x00e4:
            if (r19 == 0) goto L_0x011e
            if (r4 != 0) goto L_0x00f9
            boolean r12 = r5.isEmpty()
            if (r12 != 0) goto L_0x011e
            java.lang.Object r12 = ma.z.z(r5)
            boolean r12 = xa.j.a(r12, r13)
            if (r12 == 0) goto L_0x00f9
            goto L_0x011e
        L_0x00f9:
            if (r8 == 0) goto L_0x0101
            int r11 = r5.size()
            if (r11 == r9) goto L_0x00b6
        L_0x0101:
            boolean r11 = r5.isEmpty()
            if (r11 == 0) goto L_0x0108
            goto L_0x00b6
        L_0x0108:
            int r11 = ma.r.d(r5)
            r5.remove(r11)
            goto L_0x00b6
        L_0x0110:
            boolean r12 = xa.j.a(r11, r12)
            if (r12 != 0) goto L_0x00b6
            dc.n r12 = dc.n.f4803l
            boolean r12 = xa.j.a(r11, r12)
            if (r12 != 0) goto L_0x00b6
        L_0x011e:
            r5.add(r11)
            goto L_0x00b6
        L_0x0122:
            int r0 = r5.size()
        L_0x0126:
            if (r3 >= r0) goto L_0x0139
            if (r3 <= 0) goto L_0x012d
            r1.N0(r2)
        L_0x012d:
            java.lang.Object r4 = r5.get(r3)
            dc.n r4 = (dc.n) r4
            r1.N0(r4)
            int r3 = r3 + 1
            goto L_0x0126
        L_0x0139:
            long r2 = r1.f4787i
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0142
            r1.N0(r12)
        L_0x0142:
            dc.f0 r0 = new dc.f0
            dc.n r1 = r1.m()
            r0.<init>(r1)
            return r0
        L_0x014c:
            byte r5 = r18.readByte()
            if (r2 != 0) goto L_0x0156
            dc.n r2 = e(r5)
        L_0x0156:
            int r4 = r4 + 1
            goto L_0x000a
        */
        throw new UnsupportedOperationException("Method not decompiled: ec.l.d(dc.j, boolean):dc.f0");
    }

    public static final n e(byte b10) {
        if (b10 == 47) {
            return f5386a;
        }
        if (b10 == 92) {
            return f5387b;
        }
        throw new IllegalArgumentException(h.i("not a directory separator: ", b10));
    }

    public static final n f(String str) {
        if (j.a(str, Constants.LIST_SEPARATOR)) {
            return f5386a;
        }
        if (j.a(str, "\\")) {
            return f5387b;
        }
        throw new IllegalArgumentException(h.m("not a directory separator: ", str));
    }
}
