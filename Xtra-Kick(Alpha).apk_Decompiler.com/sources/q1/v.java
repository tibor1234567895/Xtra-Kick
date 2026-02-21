package q1;

import a2.e;
import a2.i;
import a2.j;
import a2.k;
import a2.l;
import a2.o;
import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import d2.u0;
import d2.y;
import d9.v0;
import g1.a0;
import g1.a1;
import g1.u;
import g1.v1;
import g1.y0;
import g1.z;
import j1.l0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import p1.n;
import p1.q;
import v1.b;
import v1.d1;
import v1.f0;
import v1.l1;
import v1.r;
import v1.w;
import v1.z0;
import x1.a;
import z1.s;

public final class v implements l, o, d1, y, z0 {

    /* renamed from: f0  reason: collision with root package name */
    public static final Set f13251f0 = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{1, 2, 5})));
    public final Map A;
    public a B;
    public u[] C;
    public int[] D = new int[0];
    public final HashSet E;
    public final SparseIntArray F;
    public t G;
    public int H;
    public int I;
    public boolean J;
    public boolean K;
    public int L;
    public a0 M;
    public a0 N;
    public boolean O;
    public l1 P;
    public Set Q;
    public int[] R;
    public int S;
    public boolean T;
    public boolean[] U;
    public boolean[] V;
    public long W;
    public long X;
    public boolean Y;
    public boolean Z;

    /* renamed from: a0  reason: collision with root package name */
    public boolean f13252a0;

    /* renamed from: b0  reason: collision with root package name */
    public boolean f13253b0;

    /* renamed from: c0  reason: collision with root package name */
    public long f13254c0;

    /* renamed from: d0  reason: collision with root package name */
    public u f13255d0;

    /* renamed from: e0  reason: collision with root package name */
    public n f13256e0;

    /* renamed from: h  reason: collision with root package name */
    public final String f13257h;

    /* renamed from: i  reason: collision with root package name */
    public final int f13258i;

    /* renamed from: j  reason: collision with root package name */
    public final e.a f13259j;

    /* renamed from: k  reason: collision with root package name */
    public final k f13260k;

    /* renamed from: l  reason: collision with root package name */
    public final e f13261l;

    /* renamed from: m  reason: collision with root package name */
    public final a0 f13262m;

    /* renamed from: n  reason: collision with root package name */
    public final p1.u f13263n;

    /* renamed from: o  reason: collision with root package name */
    public final q f13264o;

    /* renamed from: p  reason: collision with root package name */
    public final i f13265p;

    /* renamed from: q  reason: collision with root package name */
    public final a2.q f13266q = new a2.q("Loader:HlsSampleStreamWrapper");

    /* renamed from: r  reason: collision with root package name */
    public final f0 f13267r;

    /* renamed from: s  reason: collision with root package name */
    public final int f13268s;

    /* renamed from: t  reason: collision with root package name */
    public final g f13269t = new g();

    /* renamed from: u  reason: collision with root package name */
    public final ArrayList f13270u;

    /* renamed from: v  reason: collision with root package name */
    public final List f13271v;

    /* renamed from: w  reason: collision with root package name */
    public final s f13272w;

    /* renamed from: x  reason: collision with root package name */
    public final s f13273x;

    /* renamed from: y  reason: collision with root package name */
    public final Handler f13274y;

    /* renamed from: z  reason: collision with root package name */
    public final ArrayList f13275z;

    public v(String str, int i10, e.a aVar, k kVar, Map map, e eVar, long j10, a0 a0Var, p1.u uVar, q qVar, i iVar, f0 f0Var, int i11) {
        this.f13257h = str;
        this.f13258i = i10;
        this.f13259j = aVar;
        this.f13260k = kVar;
        this.A = map;
        this.f13261l = eVar;
        this.f13262m = a0Var;
        this.f13263n = uVar;
        this.f13264o = qVar;
        this.f13265p = iVar;
        this.f13267r = f0Var;
        this.f13268s = i11;
        Set set = f13251f0;
        this.E = new HashSet(set.size());
        this.F = new SparseIntArray(set.size());
        this.C = new u[0];
        this.V = new boolean[0];
        this.U = new boolean[0];
        ArrayList arrayList = new ArrayList();
        this.f13270u = arrayList;
        this.f13271v = Collections.unmodifiableList(arrayList);
        this.f13275z = new ArrayList();
        this.f13272w = new s(0, this);
        this.f13273x = new s(1, this);
        this.f13274y = l0.k((Handler.Callback) null);
        this.W = j10;
        this.X = j10;
    }

    public static d2.u q(int i10, int i11) {
        j1.v.g("HlsSampleStreamWrapper", "Unmapped track with id " + i10 + " of type " + i11);
        return new d2.u();
    }

    public static a0 s(a0 a0Var, a0 a0Var2, boolean z10) {
        String str;
        String str2;
        int i10;
        int i11;
        if (a0Var == null) {
            return a0Var2;
        }
        String str3 = a0Var2.f6276s;
        int h10 = a1.h(str3);
        String str4 = a0Var.f6273p;
        if (l0.n(h10, str4) == 1) {
            str2 = l0.o(h10, str4);
            str = a1.d(str2);
        } else {
            String b10 = a1.b(str4, str3);
            str = str3;
            str2 = b10;
        }
        z zVar = new z(a0Var2);
        zVar.f6744a = a0Var.f6265h;
        zVar.f6745b = a0Var.f6266i;
        zVar.f6746c = a0Var.f6267j;
        zVar.f6747d = a0Var.f6268k;
        zVar.f6748e = a0Var.f6269l;
        if (z10) {
            i10 = a0Var.f6270m;
        } else {
            i10 = -1;
        }
        zVar.f6749f = i10;
        if (z10) {
            i11 = a0Var.f6271n;
        } else {
            i11 = -1;
        }
        zVar.f6750g = i11;
        zVar.f6751h = str2;
        if (h10 == 2) {
            zVar.f6759p = a0Var.f6281x;
            zVar.f6760q = a0Var.f6282y;
            zVar.f6761r = a0Var.f6283z;
        }
        if (str != null) {
            zVar.f6754k = str;
        }
        int i12 = a0Var.F;
        if (i12 != -1 && h10 == 1) {
            zVar.f6767x = i12;
        }
        g1.z0 z0Var = a0Var.f6274q;
        if (z0Var != null) {
            g1.z0 z0Var2 = a0Var2.f6274q;
            if (z0Var2 != null) {
                y0[] y0VarArr = z0Var.f6770h;
                if (y0VarArr.length == 0) {
                    z0Var = z0Var2;
                } else {
                    y0[] y0VarArr2 = z0Var2.f6770h;
                    Object[] copyOf = Arrays.copyOf(y0VarArr2, y0VarArr2.length + y0VarArr.length);
                    System.arraycopy(y0VarArr, 0, copyOf, y0VarArr2.length, y0VarArr.length);
                    z0Var = new g1.z0(z0Var2.f6771i, (y0[]) copyOf);
                }
            }
            zVar.f6752i = z0Var;
        }
        return new a0(zVar);
    }

    public static int x(int i10) {
        if (i10 == 1) {
            return 2;
        }
        if (i10 != 2) {
            return i10 != 3 ? 0 : 1;
        }
        return 3;
    }

    public final void A() {
        boolean z10;
        int i10;
        a0 a0Var;
        boolean z11;
        if (!this.O && this.R == null && this.J) {
            u[] uVarArr = this.C;
            int length = uVarArr.length;
            int i11 = 0;
            while (i11 < length) {
                if (uVarArr[i11].r() != null) {
                    i11++;
                } else {
                    return;
                }
            }
            l1 l1Var = this.P;
            if (l1Var != null) {
                int i12 = l1Var.f15716h;
                int[] iArr = new int[i12];
                this.R = iArr;
                Arrays.fill(iArr, -1);
                for (int i13 = 0; i13 < i12; i13++) {
                    int i14 = 0;
                    while (true) {
                        u[] uVarArr2 = this.C;
                        if (i14 >= uVarArr2.length) {
                            break;
                        }
                        a0 r10 = uVarArr2[i14].r();
                        j1.a.f(r10);
                        a0 a0Var2 = this.P.i(i13).f6676k[0];
                        String str = a0Var2.f6276s;
                        String str2 = r10.f6276s;
                        int h10 = a1.h(str2);
                        if (h10 == 3 ? l0.a(str2, str) && ((!"application/cea-608".equals(str2) && !"application/cea-708".equals(str2)) || r10.K == a0Var2.K) : h10 == a1.h(str)) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z11) {
                            this.R[i13] = i14;
                            break;
                        }
                        i14++;
                    }
                }
                Iterator it = this.f13275z.iterator();
                while (it.hasNext()) {
                    ((r) it.next()).e();
                }
                return;
            }
            int length2 = this.C.length;
            int i15 = 0;
            int i16 = -2;
            int i17 = -1;
            while (true) {
                int i18 = 2;
                if (i15 >= length2) {
                    break;
                }
                a0 r11 = this.C[i15].r();
                j1.a.f(r11);
                String str3 = r11.f6276s;
                if (!a1.k(str3)) {
                    if (a1.i(str3)) {
                        i18 = 1;
                    } else if (a1.j(str3)) {
                        i18 = 3;
                    } else {
                        i18 = -2;
                    }
                }
                if (x(i18) > x(i16)) {
                    i17 = i15;
                    i16 = i18;
                } else if (i18 == i16 && i17 != -1) {
                    i17 = -1;
                }
                i15++;
            }
            v1 v1Var = this.f13260k.f13174h;
            int i19 = v1Var.f6673h;
            this.S = -1;
            this.R = new int[length2];
            for (int i20 = 0; i20 < length2; i20++) {
                this.R[i20] = i20;
            }
            v1[] v1VarArr = new v1[length2];
            for (int i21 = 0; i21 < length2; i21++) {
                a0 r12 = this.C[i21].r();
                j1.a.f(r12);
                a0 a0Var3 = this.f13262m;
                String str4 = this.f13257h;
                if (i21 == i17) {
                    a0[] a0VarArr = new a0[i19];
                    for (int i22 = 0; i22 < i19; i22++) {
                        a0 a0Var4 = v1Var.f6676k[i22];
                        if (i16 == 1 && a0Var3 != null) {
                            a0Var4 = a0Var4.m(a0Var3);
                        }
                        if (i19 == 1) {
                            a0Var = r12.m(a0Var4);
                        } else {
                            a0Var = s(a0Var4, r12, true);
                        }
                        a0VarArr[i22] = a0Var;
                    }
                    v1VarArr[i21] = new v1(str4, a0VarArr);
                    this.S = i21;
                } else {
                    if (i16 != 2 || !a1.i(r12.f6276s)) {
                        a0Var3 = null;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str4);
                    sb2.append(":muxed:");
                    if (i21 < i17) {
                        i10 = i21;
                    } else {
                        i10 = i21 - 1;
                    }
                    sb2.append(i10);
                    v1VarArr[i21] = new v1(sb2.toString(), s(a0Var3, r12, false));
                }
            }
            this.P = r(v1VarArr);
            if (this.Q == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            j1.a.e(z10);
            this.Q = Collections.emptySet();
            this.K = true;
            this.f13259j.H();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0307  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x030e  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x031c  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x031e  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0348  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x034b  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0354  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0357  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x035b  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0365  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x036a  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0375  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x037b  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x03bf  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x03d9  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0424  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0453  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x048b  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x0498  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x025f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean C(long r59) {
        /*
            r58 = this;
            r0 = r58
            boolean r1 = r0.f13252a0
            r10 = 0
            if (r1 != 0) goto L_0x052e
            a2.q r11 = r0.f13266q
            boolean r1 = r11.d()
            if (r1 != 0) goto L_0x052e
            boolean r1 = r11.c()
            if (r1 == 0) goto L_0x0017
            goto L_0x052e
        L_0x0017:
            boolean r1 = r58.z()
            if (r1 == 0) goto L_0x0035
            java.util.List r1 = java.util.Collections.emptyList()
            long r2 = r0.X
            q1.u[] r4 = r0.C
            int r5 = r4.length
            r6 = 0
        L_0x0027:
            if (r6 >= r5) goto L_0x0032
            r7 = r4[r6]
            long r8 = r0.X
            r7.f15582t = r8
            int r6 = r6 + 1
            goto L_0x0027
        L_0x0032:
            r8 = r1
            r14 = r2
            goto L_0x004c
        L_0x0035:
            q1.n r1 = r58.w()
            boolean r2 = r1.H
            if (r2 == 0) goto L_0x0040
            long r1 = r1.f16561h
            goto L_0x0048
        L_0x0040:
            long r2 = r0.W
            long r4 = r1.f16560g
            long r1 = java.lang.Math.max(r2, r4)
        L_0x0048:
            r2 = r1
            java.util.List r1 = r0.f13271v
            goto L_0x0032
        L_0x004c:
            q1.g r13 = r0.f13269t
            r12 = 0
            r13.f13155a = r12
            r13.f13156b = r10
            r13.f13157c = r12
            boolean r1 = r0.K
            if (r1 != 0) goto L_0x0063
            boolean r1 = r8.isEmpty()
            if (r1 != 0) goto L_0x0060
            goto L_0x0063
        L_0x0060:
            r20 = 0
            goto L_0x0065
        L_0x0063:
            r20 = 1
        L_0x0065:
            q1.k r6 = r0.f13260k
            r6.getClass()
            boolean r1 = r8.isEmpty()
            if (r1 == 0) goto L_0x0072
            r7 = r12
            goto L_0x0079
        L_0x0072:
            java.lang.Object r1 = d9.v0.a(r8)
            q1.n r1 = (q1.n) r1
            r7 = r1
        L_0x0079:
            if (r7 != 0) goto L_0x007d
            r5 = -1
            goto L_0x0086
        L_0x007d:
            g1.v1 r1 = r6.f13174h
            g1.a0 r2 = r7.f16557d
            int r1 = r1.i(r2)
            r5 = r1
        L_0x0086:
            long r1 = r14 - r59
            r17 = r5
            long r4 = r6.f13184r
            r21 = r11
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r3 == 0) goto L_0x0099
            r3 = 1
            goto L_0x009a
        L_0x0099:
            r3 = 0
        L_0x009a:
            if (r3 == 0) goto L_0x009f
            long r4 = r4 - r59
            goto L_0x00a0
        L_0x009f:
            r4 = r10
        L_0x00a0:
            if (r7 == 0) goto L_0x00c4
            boolean r3 = r6.f13182p
            if (r3 != 0) goto L_0x00c4
            r18 = r13
            long r12 = r7.f16561h
            long r9 = r7.f16560g
            long r12 = r12 - r9
            long r1 = r1 - r12
            r9 = 0
            long r1 = java.lang.Math.max(r9, r1)
            r22 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            if (r3 == 0) goto L_0x00c6
            long r4 = r4 - r12
            long r3 = java.lang.Math.max(r9, r4)
            r9 = r3
            goto L_0x00c7
        L_0x00c4:
            r18 = r13
        L_0x00c6:
            r9 = r4
        L_0x00c7:
            r4 = r1
            x1.d[] r11 = r6.a(r7, r14)
            z1.s r1 = r6.f13183q
            r2 = r59
            r13 = r17
            r12 = -1
            r0 = r6
            r59 = r7
            r6 = r9
            r10 = 1
            r9 = r11
            r1.c(r2, r4, r6, r8, r9)
            z1.s r1 = r0.f13183q
            int r5 = r1.k()
            if (r13 == r5) goto L_0x00e6
            r9 = 1
            goto L_0x00e7
        L_0x00e6:
            r9 = 0
        L_0x00e7:
            android.net.Uri[] r1 = r0.f13171e
            r2 = r1[r5]
            r1.x r3 = r0.f13173g
            boolean r4 = r3.e(r2)
            if (r4 != 0) goto L_0x0107
            r4 = r18
            r4.f13157c = r2
            boolean r1 = r0.f13185s
            android.net.Uri r3 = r0.f13181o
            boolean r3 = r2.equals(r3)
            r1 = r1 & r3
            r0.f13185s = r1
            r0.f13181o = r2
            r0 = r4
            goto L_0x0483
        L_0x0107:
            r4 = r18
            r1.l r6 = r3.m(r10, r2)
            r6.getClass()
            boolean r7 = r6.f13623c
            r0.f13182p = r7
            boolean r7 = r6.f13593o
            r17 = r13
            long r12 = r6.f13586h
            if (r7 == 0) goto L_0x0122
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x012b
        L_0x0122:
            long r7 = r6.f13599u
            long r7 = r7 + r12
            long r24 = r3.o()
            long r7 = r7 - r24
        L_0x012b:
            r0.f13184r = r7
            long r7 = r3.o()
            long r7 = r12 - r7
            r11 = 0
            r13 = -1
            r12 = r0
            r26 = r4
            r4 = r17
            r11 = -1
            r13 = r59
            r24 = r14
            r14 = r9
            r15 = r6
            r16 = r7
            r18 = r24
            android.util.Pair r12 = r12.c(r13, r14, r15, r16, r18)
            java.lang.Object r13 = r12.first
            java.lang.Long r13 = (java.lang.Long) r13
            long r13 = r13.longValue()
            java.lang.Object r12 = r12.second
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            r15 = r12
            long r11 = r6.f13589k
            int r16 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            r11 = r59
            if (r16 >= 0) goto L_0x0194
            if (r11 == 0) goto L_0x0194
            if (r9 == 0) goto L_0x0194
            r2 = r1[r4]
            r1.l r6 = r3.m(r10, r2)
            r6.getClass()
            long r7 = r6.f13586h
            long r12 = r3.o()
            long r7 = r7 - r12
            r14 = 0
            r12 = r0
            r13 = r11
            r15 = r6
            r16 = r7
            r18 = r24
            android.util.Pair r1 = r12.c(r13, r14, r15, r16, r18)
            java.lang.Object r3 = r1.first
            java.lang.Long r3 = (java.lang.Long) r3
            long r13 = r3.longValue()
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r15 = r1
            r5 = r4
        L_0x0194:
            long r3 = r6.f13589k
            int r1 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x01a3
            v1.b r1 = new v1.b
            r1.<init>()
            r0.f13180n = r1
            goto L_0x02e9
        L_0x01a3:
            long r3 = r13 - r3
            int r1 = (int) r3
            d9.r0 r3 = r6.f13596r
            int r4 = r3.size()
            d9.r0 r9 = r6.f13597s
            r16 = 1
            if (r1 != r4) goto L_0x01c9
            r4 = -1
            if (r15 == r4) goto L_0x01b6
            goto L_0x01b7
        L_0x01b6:
            r15 = 0
        L_0x01b7:
            int r1 = r9.size()
            if (r15 >= r1) goto L_0x021a
            q1.j r12 = new q1.j
            java.lang.Object r1 = r9.get(r15)
            r1.j r1 = (r1.j) r1
            r12.<init>(r1, r13, r15)
            goto L_0x021b
        L_0x01c9:
            java.lang.Object r4 = r3.get(r1)
            r1.i r4 = (r1.i) r4
            r12 = -1
            if (r15 != r12) goto L_0x01d9
            q1.j r1 = new q1.j
            r1.<init>(r4, r13, r12)
        L_0x01d7:
            r12 = r1
            goto L_0x021b
        L_0x01d9:
            d9.r0 r12 = r4.f13565t
            int r12 = r12.size()
            if (r15 >= r12) goto L_0x01ef
            q1.j r1 = new q1.j
            d9.r0 r4 = r4.f13565t
            java.lang.Object r4 = r4.get(r15)
            r1.j r4 = (r1.j) r4
            r1.<init>(r4, r13, r15)
            goto L_0x01d7
        L_0x01ef:
            int r1 = r1 + r10
            int r4 = r3.size()
            if (r1 >= r4) goto L_0x0205
            q1.j r12 = new q1.j
            java.lang.Object r1 = r3.get(r1)
            r1.j r1 = (r1.j) r1
            long r13 = r13 + r16
            r4 = -1
            r12.<init>(r1, r13, r4)
            goto L_0x021b
        L_0x0205:
            boolean r1 = r9.isEmpty()
            if (r1 != 0) goto L_0x021a
            q1.j r12 = new q1.j
            r1 = 0
            java.lang.Object r4 = r9.get(r1)
            r1.j r4 = (r1.j) r4
            long r13 = r13 + r16
            r12.<init>(r4, r13, r1)
            goto L_0x021b
        L_0x021a:
            r12 = 0
        L_0x021b:
            if (r12 != 0) goto L_0x025f
            boolean r1 = r6.f13593o
            if (r1 != 0) goto L_0x0234
            r1 = r26
            r1.f13157c = r2
            boolean r3 = r0.f13185s
            android.net.Uri r4 = r0.f13181o
            boolean r4 = r2.equals(r4)
            r3 = r3 & r4
            r0.f13185s = r3
            r0.f13181o = r2
            goto L_0x02e9
        L_0x0234:
            r1 = r26
            if (r20 != 0) goto L_0x0258
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x023f
            goto L_0x0258
        L_0x023f:
            q1.j r12 = new q1.j
            java.lang.Object r4 = d9.v0.a(r3)
            r1.j r4 = (r1.j) r4
            int r3 = r3.size()
            long r13 = (long) r3
            r59 = r11
            long r10 = r6.f13589k
            long r10 = r10 + r13
            long r10 = r10 - r16
            r9 = -1
            r12.<init>(r4, r10, r9)
            goto L_0x0263
        L_0x0258:
            r0 = 1
            r1.f13156b = r0
        L_0x025b:
            r26 = r1
            goto L_0x02e9
        L_0x025f:
            r59 = r11
            r1 = r26
        L_0x0263:
            r4 = 0
            r0.f13185s = r4
            r4 = 0
            r0.f13181o = r4
            r1.j r9 = r12.f13163a
            r1.i r9 = r9.f13567i
            java.lang.String r10 = r6.f13621a
            if (r9 == 0) goto L_0x027b
            java.lang.String r9 = r9.f13572n
            if (r9 != 0) goto L_0x0276
            goto L_0x027b
        L_0x0276:
            android.net.Uri r9 = j1.j0.d(r10, r9)
            goto L_0x027c
        L_0x027b:
            r9 = r4
        L_0x027c:
            q1.f r11 = r0.d(r9, r5)
            r1.f13155a = r11
            if (r11 == 0) goto L_0x0285
        L_0x0284:
            goto L_0x025b
        L_0x0285:
            r1.j r11 = r12.f13163a
            if (r11 == 0) goto L_0x0293
            java.lang.String r13 = r11.f13572n
            if (r13 != 0) goto L_0x028e
            goto L_0x0293
        L_0x028e:
            android.net.Uri r13 = j1.j0.d(r10, r13)
            goto L_0x0294
        L_0x0293:
            r13 = r4
        L_0x0294:
            q1.f r14 = r0.d(r13, r5)
            r1.f13155a = r14
            if (r14 == 0) goto L_0x029d
            goto L_0x0284
        L_0x029d:
            if (r59 != 0) goto L_0x02a4
            java.util.concurrent.atomic.AtomicInteger r14 = q1.n.L
            r14 = r59
            goto L_0x02b2
        L_0x02a4:
            r14 = r59
            android.net.Uri r15 = r14.f13191m
            boolean r15 = r2.equals(r15)
            if (r15 == 0) goto L_0x02b8
            boolean r15 = r14.H
            if (r15 == 0) goto L_0x02b8
        L_0x02b2:
            r26 = r1
            r15 = r2
            r56 = 0
            goto L_0x02e3
        L_0x02b8:
            long r3 = r11.f13570l
            long r3 = r3 + r7
            boolean r15 = r11 instanceof r1.g
            r26 = r1
            boolean r1 = r6.f13623c
            if (r15 == 0) goto L_0x02d4
            r15 = r11
            r1.g r15 = (r1.g) r15
            boolean r15 = r15.f13559s
            if (r15 != 0) goto L_0x02d3
            int r15 = r12.f13165c
            if (r15 != 0) goto L_0x02d1
            if (r1 == 0) goto L_0x02d1
            goto L_0x02d3
        L_0x02d1:
            r1 = 0
            goto L_0x02d4
        L_0x02d3:
            r1 = 1
        L_0x02d4:
            r15 = r2
            if (r1 == 0) goto L_0x02e0
            long r1 = r14.f16561h
            int r16 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r16 >= 0) goto L_0x02de
            goto L_0x02e0
        L_0x02de:
            r1 = 0
            goto L_0x02e1
        L_0x02e0:
            r1 = 1
        L_0x02e1:
            r56 = r1
        L_0x02e3:
            boolean r1 = r12.f13166d
            if (r56 == 0) goto L_0x02ed
            if (r1 == 0) goto L_0x02ed
        L_0x02e9:
            r0 = r26
            goto L_0x0483
        L_0x02ed:
            q1.l r2 = r0.f13167a
            g1.a0[] r3 = r0.f13172f
            r31 = r3[r5]
            java.util.List r4 = r0.f13175i
            z1.s r3 = r0.f13183q
            int r38 = r3.n()
            z1.s r3 = r0.f13183q
            java.lang.Object r39 = r3.q()
            boolean r5 = r0.f13178l
            e.a r3 = r0.f13176j
            if (r13 != 0) goto L_0x030e
            r3.getClass()
            r59 = r15
            r13 = 0
            goto L_0x031a
        L_0x030e:
            r59 = r15
            java.lang.Object r15 = r3.f4852i
            java.util.LinkedHashMap r15 = (java.util.LinkedHashMap) r15
            java.lang.Object r13 = r15.get(r13)
            byte[] r13 = (byte[]) r13
        L_0x031a:
            if (r9 != 0) goto L_0x031e
            r3 = 0
            goto L_0x0328
        L_0x031e:
            java.lang.Object r3 = r3.f4852i
            java.util.LinkedHashMap r3 = (java.util.LinkedHashMap) r3
            java.lang.Object r3 = r3.get(r9)
            byte[] r3 = (byte[]) r3
        L_0x0328:
            n1.f0 r9 = r0.f13177k
            java.util.concurrent.atomic.AtomicInteger r15 = q1.n.L
            k1.l r15 = new k1.l
            r15.<init>()
            r16 = r9
            java.lang.String r9 = r11.f13566h
            android.net.Uri r9 = j1.j0.d(r10, r9)
            r15.f9013a = r9
            r9 = r4
            r17 = r5
            long r4 = r11.f13574p
            r15.f9017e = r4
            long r4 = r11.f13575q
            r15.f9018f = r4
            if (r1 == 0) goto L_0x034b
            r4 = 8
            goto L_0x034c
        L_0x034b:
            r4 = 0
        L_0x034c:
            r15.f9020h = r4
            k1.m r30 = r15.a()
            if (r13 == 0) goto L_0x0357
            r32 = 1
            goto L_0x0359
        L_0x0357:
            r32 = 0
        L_0x0359:
            if (r32 == 0) goto L_0x0365
            java.lang.String r4 = r11.f13573o
            r4.getClass()
            byte[] r4 = q1.n.d(r4)
            goto L_0x0366
        L_0x0365:
            r4 = 0
        L_0x0366:
            k1.h r5 = r0.f13168b
            if (r13 == 0) goto L_0x0375
            r4.getClass()
            q1.a r15 = new q1.a
            r15.<init>(r5, r13, r4)
            r29 = r15
            goto L_0x0377
        L_0x0375:
            r29 = r5
        L_0x0377:
            r1.i r4 = r11.f13567i
            if (r4 == 0) goto L_0x03bf
            if (r3 == 0) goto L_0x037f
            r13 = 1
            goto L_0x0380
        L_0x037f:
            r13 = 0
        L_0x0380:
            if (r13 == 0) goto L_0x038e
            java.lang.String r15 = r4.f13573o
            r15.getClass()
            byte[] r15 = q1.n.d(r15)
            r60 = r13
            goto L_0x0391
        L_0x038e:
            r60 = r13
            r15 = 0
        L_0x0391:
            java.lang.String r13 = r4.f13566h
            android.net.Uri r41 = j1.j0.d(r10, r13)
            k1.m r10 = new k1.m
            r13 = r0
            r18 = r1
            long r0 = r4.f13574p
            r20 = r12
            r24 = r13
            long r12 = r4.f13575q
            r40 = r10
            r42 = r0
            r44 = r12
            r40.<init>(r41, r42, r44)
            if (r3 == 0) goto L_0x03b9
            r15.getClass()
            q1.a r0 = new q1.a
            r0.<init>(r5, r3, r15)
            r12 = r0
            goto L_0x03ba
        L_0x03b9:
            r12 = r5
        L_0x03ba:
            r35 = r60
            r33 = r12
            goto L_0x03ca
        L_0x03bf:
            r24 = r0
            r18 = r1
            r20 = r12
            r10 = 0
            r33 = 0
            r35 = 0
        L_0x03ca:
            long r0 = r11.f13570l
            long r40 = r7 + r0
            long r0 = r11.f13568j
            long r42 = r40 + r0
            int r0 = r6.f13588j
            int r1 = r11.f13569k
            int r0 = r0 + r1
            if (r14 == 0) goto L_0x0424
            k1.m r1 = r14.f13195q
            if (r10 == r1) goto L_0x03f6
            if (r10 == 0) goto L_0x03f4
            if (r1 == 0) goto L_0x03f4
            android.net.Uri r3 = r10.f9022a
            android.net.Uri r4 = r1.f9022a
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x03f4
            long r3 = r10.f9027f
            long r5 = r1.f9027f
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x03f4
            goto L_0x03f6
        L_0x03f4:
            r1 = 0
            goto L_0x03f7
        L_0x03f6:
            r1 = 1
        L_0x03f7:
            android.net.Uri r3 = r14.f13191m
            r4 = r59
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0407
            boolean r3 = r14.H
            if (r3 == 0) goto L_0x0407
            r3 = 1
            goto L_0x0408
        L_0x0407:
            r3 = 0
        L_0x0408:
            if (r1 == 0) goto L_0x0418
            if (r3 == 0) goto L_0x0418
            boolean r1 = r14.J
            if (r1 != 0) goto L_0x0418
            int r1 = r14.f13190l
            if (r1 != r0) goto L_0x0418
            q1.o r1 = r14.C
            r12 = r1
            goto L_0x0419
        L_0x0418:
            r12 = 0
        L_0x0419:
            o2.o r1 = r14.f13203y
            j1.b0 r3 = r14.f13204z
            r54 = r1
            r55 = r3
            r53 = r12
            goto L_0x0438
        L_0x0424:
            r4 = r59
            o2.o r1 = new o2.o
            r1.<init>()
            j1.b0 r3 = new j1.b0
            r5 = 10
            r3.<init>((int) r5)
            r54 = r1
            r55 = r3
            r53 = 0
        L_0x0438:
            q1.n r1 = new q1.n
            r12 = r20
            long r5 = r12.f13164b
            int r7 = r12.f13165c
            r3 = 1
            r47 = r18 ^ 1
            boolean r8 = r11.f13576r
            r12 = r24
            q1.a0 r12 = r12.f13170d
            android.util.SparseArray r12 = r12.f13134a
            java.lang.Object r13 = r12.get(r0)
            j1.h0 r13 = (j1.h0) r13
            if (r13 != 0) goto L_0x0460
            j1.h0 r13 = new j1.h0
            r14 = 9223372036854775806(0x7ffffffffffffffe, double:NaN)
            r13.<init>(r14)
            r12.put(r0, r13)
        L_0x0460:
            r51 = r13
            g1.u r11 = r11.f13571m
            r52 = r11
            r27 = r1
            r28 = r2
            r34 = r10
            r36 = r4
            r37 = r9
            r44 = r5
            r46 = r7
            r48 = r0
            r49 = r8
            r50 = r17
            r57 = r16
            r27.<init>(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r42, r44, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57)
            r0 = r26
            r0.f13155a = r1
        L_0x0483:
            boolean r1 = r0.f13156b
            x1.a r2 = r0.f13155a
            android.net.Uri r0 = r0.f13157c
            if (r1 == 0) goto L_0x0498
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r1 = r58
            r1.X = r4
            r0 = 1
            r1.f13252a0 = r0
            return r0
        L_0x0498:
            r1 = r58
            if (r2 != 0) goto L_0x04ab
            if (r0 == 0) goto L_0x04a9
            e.a r2 = r1.f13259j
            java.lang.Object r2 = r2.f4852i
            q1.p r2 = (q1.p) r2
            r1.x r2 = r2.f13206i
            r2.k(r0)
        L_0x04a9:
            r0 = 0
            return r0
        L_0x04ab:
            boolean r0 = r2 instanceof q1.n
            if (r0 == 0) goto L_0x0503
            r0 = r2
            q1.n r0 = (q1.n) r0
            r1.f13256e0 = r0
            g1.a0 r4 = r0.f16557d
            r1.M = r4
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r1.X = r4
            java.util.ArrayList r4 = r1.f13270u
            r4.add(r0)
            d9.p0 r4 = d9.r0.f4657i
            d9.o0 r4 = new d9.o0
            r4.<init>()
            q1.u[] r5 = r1.C
            int r6 = r5.length
            r7 = 0
        L_0x04cf:
            if (r7 >= r6) goto L_0x04e2
            r8 = r5[r7]
            int r9 = r8.f15579q
            int r8 = r8.f15578p
            int r9 = r9 + r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r9)
            r4.c(r8)
            int r7 = r7 + 1
            goto L_0x04cf
        L_0x04e2:
            d9.r1 r4 = r4.e()
            r0.D = r1
            r0.I = r4
            q1.u[] r4 = r1.C
            int r5 = r4.length
            r10 = 0
        L_0x04ee:
            if (r10 >= r5) goto L_0x0503
            r6 = r4[r10]
            r6.getClass()
            int r7 = r0.f13189k
            r6.C = r7
            boolean r7 = r0.f13192n
            if (r7 == 0) goto L_0x0500
            r3 = 1
            r6.G = r3
        L_0x0500:
            int r10 = r10 + 1
            goto L_0x04ee
        L_0x0503:
            r1.B = r2
            a2.i r0 = r1.f13265p
            int r4 = r2.f16556c
            int r0 = r0.b(r4)
            r4 = r21
            r4.g(r2, r1, r0)
            v1.f0 r5 = r1.f13267r
            v1.r r6 = new v1.r
            k1.m r0 = r2.f16555b
            r6.<init>(r0)
            int r7 = r2.f16556c
            int r8 = r1.f13258i
            g1.a0 r9 = r2.f16557d
            int r10 = r2.f16558e
            java.lang.Object r11 = r2.f16559f
            long r12 = r2.f16560g
            long r14 = r2.f16561h
            r5.n(r6, r7, r8, r9, r10, r11, r12, r14)
            r0 = 1
            return r0
        L_0x052e:
            r1 = r0
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.v.C(long):boolean");
    }

    public final void D(long j10) {
        int i10;
        boolean z10;
        a2.q qVar = this.f13266q;
        if (!qVar.c() && !z()) {
            boolean d10 = qVar.d();
            k kVar = this.f13260k;
            List list = this.f13271v;
            if (d10) {
                this.B.getClass();
                a aVar = this.B;
                if (kVar.f13180n != null) {
                    z10 = false;
                } else {
                    z10 = kVar.f13183q.i(j10, aVar, list);
                }
                if (z10) {
                    qVar.a();
                    return;
                }
                return;
            }
            int size = list.size();
            while (size > 0) {
                int i11 = size - 1;
                if (kVar.b((n) list.get(i11)) != 2) {
                    break;
                }
                size = i11;
            }
            if (size < list.size()) {
                t(size);
            }
            if (kVar.f13180n != null || kVar.f13183q.length() < 2) {
                i10 = list.size();
            } else {
                i10 = kVar.f13183q.h(j10, list);
            }
            if (i10 < this.f13270u.size()) {
                t(i10);
            }
        }
    }

    public final void E() {
        this.f13266q.e();
        k kVar = this.f13260k;
        b bVar = kVar.f13180n;
        if (bVar == null) {
            Uri uri = kVar.f13181o;
            if (uri != null && kVar.f13185s) {
                kVar.f13173g.i(uri);
                return;
            }
            return;
        }
        throw bVar;
    }

    public final void F(v1[] v1VarArr, int... iArr) {
        this.P = r(v1VarArr);
        this.Q = new HashSet();
        for (int i10 : iArr) {
            this.Q.add(this.P.i(i10));
        }
        this.S = 0;
        Handler handler = this.f13274y;
        e.a aVar = this.f13259j;
        Objects.requireNonNull(aVar);
        handler.post(new s(2, aVar));
        this.K = true;
    }

    public final void G() {
        for (u x10 : this.C) {
            x10.x(this.Y);
        }
        this.Y = false;
    }

    public final boolean H(long j10, boolean z10) {
        boolean z11;
        this.W = j10;
        if (z()) {
            this.X = j10;
            return true;
        }
        if (this.J && !z10) {
            int length = this.C.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    z11 = true;
                    break;
                } else if (this.C[i10].A(j10, false) || (!this.V[i10] && this.T)) {
                    i10++;
                }
            }
            z11 = false;
            if (z11) {
                return false;
            }
        }
        this.X = j10;
        this.f13252a0 = false;
        this.f13270u.clear();
        a2.q qVar = this.f13266q;
        if (qVar.d()) {
            if (this.J) {
                for (u i11 : this.C) {
                    i11.i();
                }
            }
            qVar.a();
        } else {
            qVar.f76c = null;
            G();
        }
        return true;
    }

    public final void I(long j10) {
        if (this.f13254c0 != j10) {
            this.f13254c0 = j10;
            for (u uVar : this.C) {
                if (uVar.F != j10) {
                    uVar.F = j10;
                    uVar.f15588z = true;
                }
            }
        }
    }

    public final void a() {
        this.f13253b0 = true;
        this.f13274y.post(this.f13273x);
    }

    public final void b() {
        for (u uVar : this.C) {
            uVar.x(true);
            n nVar = uVar.f15570h;
            if (nVar != null) {
                nVar.d(uVar.f15567e);
                uVar.f15570h = null;
                uVar.f15569g = null;
            }
        }
    }

    public final boolean c() {
        return this.f13266q.d();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00fb A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final d2.x0 d(int r12, int r13) {
        /*
            r11 = this;
            java.lang.Integer r0 = java.lang.Integer.valueOf(r13)
            java.util.Set r1 = f13251f0
            boolean r0 = r1.contains(r0)
            java.util.HashSet r2 = r11.E
            android.util.SparseIntArray r3 = r11.F
            r4 = 0
            if (r0 == 0) goto L_0x0042
            java.lang.Integer r0 = java.lang.Integer.valueOf(r13)
            boolean r0 = r1.contains(r0)
            j1.a.b(r0)
            r0 = -1
            int r1 = r3.get(r13, r0)
            if (r1 != r0) goto L_0x0024
            goto L_0x0054
        L_0x0024:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r13)
            boolean r0 = r2.add(r0)
            if (r0 == 0) goto L_0x0032
            int[] r0 = r11.D
            r0[r1] = r12
        L_0x0032:
            int[] r0 = r11.D
            r0 = r0[r1]
            if (r0 != r12) goto L_0x003d
            q1.u[] r0 = r11.C
            r0 = r0[r1]
            goto L_0x0055
        L_0x003d:
            d2.u r0 = q(r12, r13)
            goto L_0x0055
        L_0x0042:
            r0 = 0
        L_0x0043:
            q1.u[] r1 = r11.C
            int r5 = r1.length
            if (r0 >= r5) goto L_0x0054
            int[] r5 = r11.D
            r5 = r5[r0]
            if (r5 != r12) goto L_0x0051
            r0 = r1[r0]
            goto L_0x0055
        L_0x0051:
            int r0 = r0 + 1
            goto L_0x0043
        L_0x0054:
            r0 = 0
        L_0x0055:
            if (r0 != 0) goto L_0x00e8
            boolean r0 = r11.f13253b0
            if (r0 == 0) goto L_0x0060
            d2.u r12 = q(r12, r13)
            return r12
        L_0x0060:
            q1.u[] r0 = r11.C
            int r0 = r0.length
            r1 = 1
            if (r13 == r1) goto L_0x0069
            r5 = 2
            if (r13 != r5) goto L_0x006a
        L_0x0069:
            r4 = 1
        L_0x006a:
            q1.u r5 = new q1.u
            p1.q r6 = r11.f13264o
            java.util.Map r7 = r11.A
            a2.e r8 = r11.f13261l
            p1.u r9 = r11.f13263n
            r5.<init>(r8, r9, r6, r7)
            long r6 = r11.W
            r5.f15582t = r6
            if (r4 == 0) goto L_0x0083
            g1.u r6 = r11.f13255d0
            r5.I = r6
            r5.f15588z = r1
        L_0x0083:
            long r6 = r11.f13254c0
            long r8 = r5.F
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 == 0) goto L_0x008f
            r5.F = r6
            r5.f15588z = r1
        L_0x008f:
            q1.n r6 = r11.f13256e0
            if (r6 == 0) goto L_0x0097
            int r6 = r6.f13189k
            r5.C = r6
        L_0x0097:
            r5.f15568f = r11
            int[] r6 = r11.D
            int r7 = r0 + 1
            int[] r6 = java.util.Arrays.copyOf(r6, r7)
            r11.D = r6
            r6[r0] = r12
            q1.u[] r12 = r11.C
            int r6 = j1.l0.f8453a
            int r6 = r12.length
            int r6 = r6 + r1
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r12, r6)
            int r12 = r12.length
            r1[r12] = r5
            q1.u[] r1 = (q1.u[]) r1
            r11.C = r1
            boolean[] r12 = r11.V
            boolean[] r12 = java.util.Arrays.copyOf(r12, r7)
            r11.V = r12
            r12[r0] = r4
            boolean r12 = r11.T
            r12 = r12 | r4
            r11.T = r12
            java.lang.Integer r12 = java.lang.Integer.valueOf(r13)
            r2.add(r12)
            r3.append(r13, r0)
            int r12 = x(r13)
            int r1 = r11.H
            int r1 = x(r1)
            if (r12 <= r1) goto L_0x00df
            r11.I = r0
            r11.H = r13
        L_0x00df:
            boolean[] r12 = r11.U
            boolean[] r12 = java.util.Arrays.copyOf(r12, r7)
            r11.U = r12
            r0 = r5
        L_0x00e8:
            r12 = 5
            if (r13 != r12) goto L_0x00fb
            q1.t r12 = r11.G
            if (r12 != 0) goto L_0x00f8
            q1.t r12 = new q1.t
            int r13 = r11.f13268s
            r12.<init>(r0, r13)
            r11.G = r12
        L_0x00f8:
            q1.t r12 = r11.G
            return r12
        L_0x00fb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.v.d(int, int):d2.x0");
    }

    public final void e() {
        this.f13274y.post(this.f13272w);
    }

    public final void g(u0 u0Var) {
    }

    public final k h(a2.n nVar, long j10, long j11, IOException iOException, int i10) {
        boolean z10;
        k kVar;
        boolean z11;
        int i11;
        IOException iOException2 = iOException;
        a aVar = (a) nVar;
        boolean z12 = aVar instanceof n;
        if (z12 && !((n) aVar).K && (iOException2 instanceof k1.z) && ((i11 = ((k1.z) iOException2).f9070k) == 410 || i11 == 404)) {
            return a2.q.f71d;
        }
        long j12 = aVar.f16562i.f8991b;
        Uri uri = aVar.f16562i.f8992c;
        r rVar = new r();
        j1.z zVar = new j1.z(rVar, new w(aVar.f16556c, this.f13258i, aVar.f16557d, aVar.f16558e, aVar.f16559f, l0.Q(aVar.f16560g), l0.Q(aVar.f16561h)), iOException2, i10);
        k kVar2 = this.f13260k;
        j a10 = z1.w.a(kVar2.f13183q);
        this.f13265p.getClass();
        k a11 = i.a(a10, zVar);
        boolean z13 = false;
        if (a11 == null || a11.f59a != 2) {
            z10 = false;
        } else {
            s sVar = kVar2.f13183q;
            z10 = sVar.a(sVar.t(kVar2.f13174h.i(aVar.f16557d)), a11.f60b);
        }
        if (z10) {
            if (z12 && j12 == 0) {
                ArrayList arrayList = this.f13270u;
                if (((n) arrayList.remove(arrayList.size() - 1)) == aVar) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                j1.a.e(z11);
                if (arrayList.isEmpty()) {
                    this.X = this.W;
                } else {
                    ((n) v0.a(arrayList)).J = true;
                }
            }
            kVar = a2.q.f72e;
        } else {
            long c10 = i.c(zVar);
            if (c10 != -9223372036854775807L) {
                kVar = a2.q.b(c10, false);
            } else {
                kVar = a2.q.f73f;
            }
        }
        k kVar3 = kVar;
        int i12 = kVar3.f59a;
        if (i12 == 0 || i12 == 1) {
            z13 = true;
        }
        boolean z14 = !z13;
        this.f13267r.j(rVar, aVar.f16556c, this.f13258i, aVar.f16557d, aVar.f16558e, aVar.f16559f, aVar.f16560g, aVar.f16561h, iOException, z14);
        if (z14) {
            this.B = null;
        }
        if (z10) {
            if (!this.K) {
                C(this.W);
            } else {
                this.f13259j.r(this);
            }
        }
        return kVar3;
    }

    public final void i() {
        j1.a.e(this.K);
        this.P.getClass();
        this.Q.getClass();
    }

    public final long j() {
        if (z()) {
            return this.X;
        }
        if (this.f13252a0) {
            return Long.MIN_VALUE;
        }
        return w().f16561h;
    }

    public final void l(a2.n nVar, long j10, long j11, boolean z10) {
        a aVar = (a) nVar;
        this.B = null;
        long j12 = aVar.f16554a;
        Uri uri = aVar.f16562i.f8992c;
        r rVar = new r();
        this.f13265p.getClass();
        this.f13267r.e(rVar, aVar.f16556c, this.f13258i, aVar.f16557d, aVar.f16558e, aVar.f16559f, aVar.f16560g, aVar.f16561h);
        if (!z10) {
            if (z() || this.L == 0) {
                G();
            }
            if (this.L > 0) {
                this.f13259j.r(this);
            }
        }
    }

    public final void n(a2.n nVar, long j10, long j11) {
        a aVar = (a) nVar;
        this.B = null;
        k kVar = this.f13260k;
        kVar.getClass();
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            kVar.f13179m = fVar.f13152j;
            e.a aVar2 = kVar.f13176j;
            Uri uri = fVar.f16555b.f9022a;
            byte[] bArr = fVar.f13154l;
            bArr.getClass();
            uri.getClass();
            byte[] bArr2 = (byte[]) ((LinkedHashMap) aVar2.f4852i).put(uri, bArr);
        }
        long j12 = aVar.f16554a;
        Uri uri2 = aVar.f16562i.f8992c;
        r rVar = new r();
        this.f13265p.getClass();
        this.f13267r.h(rVar, aVar.f16556c, this.f13258i, aVar.f16557d, aVar.f16558e, aVar.f16559f, aVar.f16560g, aVar.f16561h);
        if (!this.K) {
            C(this.W);
        } else {
            this.f13259j.r(this);
        }
    }

    public final l1 r(v1[] v1VarArr) {
        for (int i10 = 0; i10 < v1VarArr.length; i10++) {
            v1 v1Var = v1VarArr[i10];
            a0[] a0VarArr = new a0[v1Var.f6673h];
            for (int i11 = 0; i11 < v1Var.f6673h; i11++) {
                a0 a0Var = v1Var.f6676k[i11];
                int b10 = this.f13263n.b(a0Var);
                z i12 = a0Var.i();
                i12.F = b10;
                a0VarArr[i11] = i12.a();
            }
            v1VarArr[i10] = new v1(v1Var.f6674i, a0VarArr);
        }
        return new l1(v1VarArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0048, code lost:
        r4 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void t(int r27) {
        /*
            r26 = this;
            r0 = r26
            a2.q r1 = r0.f13266q
            boolean r1 = r1.d()
            r2 = 1
            r1 = r1 ^ r2
            j1.a.e(r1)
            r1 = r27
        L_0x000f:
            java.util.ArrayList r3 = r0.f13270u
            int r4 = r3.size()
            r5 = -1
            if (r1 >= r4) goto L_0x0054
            r4 = r1
        L_0x0019:
            int r7 = r3.size()
            if (r4 >= r7) goto L_0x002d
            java.lang.Object r7 = r3.get(r4)
            q1.n r7 = (q1.n) r7
            boolean r7 = r7.f13192n
            if (r7 == 0) goto L_0x002a
            goto L_0x0048
        L_0x002a:
            int r4 = r4 + 1
            goto L_0x0019
        L_0x002d:
            java.lang.Object r4 = r3.get(r1)
            q1.n r4 = (q1.n) r4
            r7 = 0
        L_0x0034:
            q1.u[] r8 = r0.C
            int r8 = r8.length
            if (r7 >= r8) goto L_0x004d
            int r8 = r4.e(r7)
            q1.u[] r9 = r0.C
            r9 = r9[r7]
            int r10 = r9.f15579q
            int r9 = r9.f15581s
            int r10 = r10 + r9
            if (r10 <= r8) goto L_0x004a
        L_0x0048:
            r4 = 0
            goto L_0x004e
        L_0x004a:
            int r7 = r7 + 1
            goto L_0x0034
        L_0x004d:
            r4 = 1
        L_0x004e:
            if (r4 == 0) goto L_0x0051
            goto L_0x0055
        L_0x0051:
            int r1 = r1 + 1
            goto L_0x000f
        L_0x0054:
            r1 = -1
        L_0x0055:
            if (r1 != r5) goto L_0x0058
            return
        L_0x0058:
            q1.n r4 = r26.w()
            long r4 = r4.f16561h
            java.lang.Object r7 = r3.get(r1)
            q1.n r7 = (q1.n) r7
            int r8 = r3.size()
            int r9 = j1.l0.f8453a
            if (r1 < 0) goto L_0x0131
            int r9 = r3.size()
            if (r8 > r9) goto L_0x0131
            if (r1 > r8) goto L_0x0131
            if (r1 == r8) goto L_0x007d
            java.util.List r1 = r3.subList(r1, r8)
            r1.clear()
        L_0x007d:
            r1 = 0
        L_0x007e:
            q1.u[] r8 = r0.C
            int r8 = r8.length
            if (r1 >= r8) goto L_0x00f6
            int r8 = r7.e(r1)
            q1.u[] r9 = r0.C
            r9 = r9[r1]
            long r10 = r9.j(r8)
            v1.w0 r8 = r9.f15563a
            long r12 = r8.f15831g
            int r9 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r9 > 0) goto L_0x0099
            r9 = 1
            goto L_0x009a
        L_0x0099:
            r9 = 0
        L_0x009a:
            j1.a.b(r9)
            r8.f15831g = r10
            r12 = 0
            int r9 = r8.f15826b
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 == 0) goto L_0x00df
            v1.v0 r12 = r8.f15828d
            long r13 = r12.f15814a
            int r15 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r15 != 0) goto L_0x00b0
            goto L_0x00df
        L_0x00b0:
            long r10 = r8.f15831g
            long r13 = r12.f15815b
            int r15 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r15 <= 0) goto L_0x00bb
            v1.v0 r12 = r12.f15817d
            goto L_0x00b0
        L_0x00bb:
            v1.v0 r10 = r12.f15817d
            r10.getClass()
            r8.a(r10)
            v1.v0 r11 = new v1.v0
            long r13 = r12.f15815b
            r11.<init>(r9, r13)
            r12.f15817d = r11
            long r13 = r8.f15831g
            r15 = r7
            long r6 = r12.f15815b
            int r9 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r9 != 0) goto L_0x00d6
            r12 = r11
        L_0x00d6:
            r8.f15830f = r12
            v1.v0 r6 = r8.f15829e
            if (r6 != r10) goto L_0x00f2
            r8.f15829e = r11
            goto L_0x00f2
        L_0x00df:
            r15 = r7
            v1.v0 r6 = r8.f15828d
            r8.a(r6)
            v1.v0 r6 = new v1.v0
            long r10 = r8.f15831g
            r6.<init>(r9, r10)
            r8.f15828d = r6
            r8.f15829e = r6
            r8.f15830f = r6
        L_0x00f2:
            int r1 = r1 + 1
            r7 = r15
            goto L_0x007e
        L_0x00f6:
            r15 = r7
            boolean r1 = r3.isEmpty()
            if (r1 == 0) goto L_0x0102
            long r1 = r0.W
            r0.X = r1
            goto L_0x010a
        L_0x0102:
            java.lang.Object r1 = d9.v0.a(r3)
            q1.n r1 = (q1.n) r1
            r1.J = r2
        L_0x010a:
            r1 = 0
            r0.f13252a0 = r1
            int r1 = r0.H
            r7 = r15
            long r2 = r7.f16560g
            v1.w r6 = new v1.w
            r17 = 1
            r19 = 0
            r20 = 3
            r21 = 0
            v1.f0 r7 = r0.f13267r
            long r22 = r7.a(r2)
            long r24 = r7.a(r4)
            r16 = r6
            r18 = r1
            r16.<init>(r17, r18, r19, r20, r21, r22, r24)
            r7.p(r6)
            return
        L_0x0131:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.v.t(int):void");
    }

    public final long u() {
        if (this.f13252a0) {
            return Long.MIN_VALUE;
        }
        if (z()) {
            return this.X;
        }
        long j10 = this.W;
        n w10 = w();
        if (!w10.H) {
            ArrayList arrayList = this.f13270u;
            if (arrayList.size() > 1) {
                w10 = (n) arrayList.get(arrayList.size() - 2);
            } else {
                w10 = null;
            }
        }
        if (w10 != null) {
            j10 = Math.max(j10, w10.f16561h);
        }
        if (this.J) {
            for (u m10 : this.C) {
                j10 = Math.max(j10, m10.m());
            }
        }
        return j10;
    }

    public final n w() {
        ArrayList arrayList = this.f13270u;
        return (n) arrayList.get(arrayList.size() - 1);
    }

    public final boolean z() {
        return this.X != -9223372036854775807L;
    }
}
