package z1;

import android.content.Context;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import d9.b0;
import d9.p1;
import d9.r0;
import d9.r1;
import g1.a0;
import g1.h;
import g1.v1;
import g1.w1;
import g1.y1;
import j0.a;
import j1.l0;
import j1.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import m1.u0;
import p1.i0;
import v1.l1;

public final class q extends v {

    /* renamed from: j  reason: collision with root package name */
    public static final p1 f17467j;

    /* renamed from: k  reason: collision with root package name */
    public static final p1 f17468k;

    /* renamed from: c  reason: collision with root package name */
    public final Object f17469c;

    /* renamed from: d  reason: collision with root package name */
    public final Context f17470d;

    /* renamed from: e  reason: collision with root package name */
    public final b f17471e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f17472f;

    /* renamed from: g  reason: collision with root package name */
    public j f17473g;

    /* renamed from: h  reason: collision with root package name */
    public final i0 f17474h;

    /* renamed from: i  reason: collision with root package name */
    public h f17475i;

    static {
        p1 p1Var;
        p1 p1Var2;
        a aVar = new a(5);
        if (aVar instanceof p1) {
            p1Var = (p1) aVar;
        } else {
            p1Var = new b0(aVar);
        }
        f17467j = p1Var;
        a aVar2 = new a(6);
        if (aVar2 instanceof p1) {
            p1Var2 = (p1) aVar2;
        } else {
            p1Var2 = new b0(aVar2);
        }
        f17468k = p1Var2;
    }

    @Deprecated
    public q() {
        this(j.f17415x0, new b(), (Context) null);
    }

    public static void h(l1 l1Var, j jVar, HashMap hashMap) {
        for (int i10 = 0; i10 < l1Var.f15716h; i10++) {
            w1 w1Var = (w1) jVar.F.get(l1Var.i(i10));
            if (w1Var != null) {
                v1 v1Var = w1Var.f6686h;
                w1 w1Var2 = (w1) hashMap.get(Integer.valueOf(v1Var.f6675j));
                if (w1Var2 == null || (w1Var2.f6687i.isEmpty() && !w1Var.f6687i.isEmpty())) {
                    hashMap.put(Integer.valueOf(v1Var.f6675j), w1Var);
                }
            }
        }
    }

    public static int i(a0 a0Var, String str, boolean z10) {
        if (!TextUtils.isEmpty(str) && str.equals(a0Var.f6267j)) {
            return 4;
        }
        String l10 = l(str);
        String l11 = l(a0Var.f6267j);
        if (l11 == null || l10 == null) {
            if (!z10 || l11 != null) {
                return 0;
            }
            return 1;
        } else if (l11.startsWith(l10) || l10.startsWith(l11)) {
            return 3;
        } else {
            int i10 = l0.f8453a;
            if (l11.split("-", 2)[0].equals(l10.split("-", 2)[0])) {
                return 2;
            }
            return 0;
        }
    }

    public static boolean j(int i10, boolean z10) {
        int i11 = i10 & 7;
        return i11 == 4 || (z10 && i11 == 3);
    }

    public static String l(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    public static Pair m(int i10, u uVar, int[][][] iArr, n nVar, a aVar) {
        Object obj;
        u uVar2 = uVar;
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 < uVar2.f17479a) {
            if (i10 == uVar2.f17480b[i11]) {
                l1 l1Var = uVar2.f17481c[i11];
                int i12 = 0;
                while (i12 < l1Var.f15716h) {
                    v1 i13 = l1Var.i(i12);
                    r1 a10 = nVar.a(i11, i13, iArr[i11][i12]);
                    int i14 = i13.f6673h;
                    boolean[] zArr = new boolean[i14];
                    int i15 = 0;
                    while (i15 < i14) {
                        o oVar = (o) a10.get(i15);
                        int a11 = oVar.a();
                        if (!zArr[i15] && a11 != 0) {
                            if (a11 == 1) {
                                obj = r0.n(oVar);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(oVar);
                                int i16 = i15 + 1;
                                while (i16 < i14) {
                                    o oVar2 = (o) a10.get(i16);
                                    if (oVar2.a() == 2 && oVar.b(oVar2)) {
                                        arrayList2.add(oVar2);
                                        zArr[i16] = true;
                                    }
                                    i16++;
                                    u uVar3 = uVar;
                                }
                                obj = arrayList2;
                            }
                            arrayList.add(obj);
                        }
                        i15++;
                        u uVar4 = uVar;
                    }
                    i12++;
                    u uVar5 = uVar;
                }
            }
            n nVar2 = nVar;
            i11++;
            uVar2 = uVar;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, aVar);
        int[] iArr2 = new int[list.size()];
        for (int i17 = 0; i17 < list.size(); i17++) {
            iArr2[i17] = ((o) list.get(i17)).f17451j;
        }
        o oVar3 = (o) list.get(0);
        return Pair.create(new r(0, oVar3.f17450i, iArr2), Integer.valueOf(oVar3.f17449h));
    }

    public final y1 a() {
        j jVar;
        synchronized (this.f17469c) {
            jVar = this.f17473g;
        }
        return jVar;
    }

    public final void c() {
        i0 i0Var;
        synchronized (this.f17469c) {
            if (l0.f8453a >= 32 && (i0Var = this.f17474h) != null) {
                Object obj = i0Var.f12467l;
                if (((Spatializer.OnSpatializerStateChangedListener) obj) != null) {
                    if (((Handler) i0Var.f12466k) != null) {
                        ((Spatializer) i0Var.f12465j).removeOnSpatializerStateChangedListener((Spatializer.OnSpatializerStateChangedListener) obj);
                        ((Handler) i0Var.f12466k).removeCallbacksAndMessages((Object) null);
                        i0Var.f12466k = null;
                        i0Var.f12467l = null;
                    }
                }
            }
        }
        super.c();
    }

    public final void e(h hVar) {
        boolean z10;
        synchronized (this.f17469c) {
            z10 = !this.f17475i.equals(hVar);
            this.f17475i = hVar;
        }
        if (z10) {
            k();
        }
    }

    public final void f(y1 y1Var) {
        j jVar;
        if (y1Var instanceof j) {
            n((j) y1Var);
        }
        synchronized (this.f17469c) {
            jVar = this.f17473g;
        }
        i iVar = new i(jVar);
        iVar.e(y1Var);
        n(new j(iVar));
    }

    /* JADX WARNING: type inference failed for: r9v11, types: [z1.t] */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x04ae, code lost:
        if (r5 == 2) goto L_0x04b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0115, code lost:
        if (d9.e0.f4608a.c(r10.f17414i, r7.f17414i).c(r10.f17413h, r7.f17413h).e() > 0) goto L_0x011a;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair g(z1.u r41, int[][][] r42, int[] r43) {
        /*
            r40 = this;
            r1 = r40
            r0 = r41
            r2 = r42
            java.lang.Object r3 = r1.f17469c
            monitor-enter(r3)
            z1.j r4 = r1.f17473g     // Catch:{ all -> 0x0512 }
            boolean r5 = r4.f17427r0     // Catch:{ all -> 0x0512 }
            r6 = 32
            if (r5 == 0) goto L_0x0023
            int r5 = j1.l0.f8453a     // Catch:{ all -> 0x0512 }
            if (r5 < r6) goto L_0x0023
            p1.i0 r5 = r1.f17474h     // Catch:{ all -> 0x0512 }
            if (r5 == 0) goto L_0x0023
            android.os.Looper r7 = android.os.Looper.myLooper()     // Catch:{ all -> 0x0512 }
            j1.a.f(r7)     // Catch:{ all -> 0x0512 }
            r5.f(r1, r7)     // Catch:{ all -> 0x0512 }
        L_0x0023:
            monitor-exit(r3)     // Catch:{ all -> 0x0512 }
            int r3 = r0.f17479a
            z1.r[] r5 = new z1.r[r3]
            androidx.fragment.app.g r7 = new androidx.fragment.app.g
            r8 = 12
            r9 = r43
            r7.<init>(r4, r8, r9)
            j0.a r8 = new j0.a
            r9 = 3
            r8.<init>(r9)
            r10 = 2
            android.util.Pair r7 = m(r10, r0, r2, r7, r8)
            if (r7 == 0) goto L_0x004c
            java.lang.Object r8 = r7.second
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            java.lang.Object r7 = r7.first
            z1.r r7 = (z1.r) r7
            r5[r8] = r7
        L_0x004c:
            r7 = 0
            r8 = 0
        L_0x004e:
            int r11 = r0.f17479a
            v1.l1[] r12 = r0.f17481c
            int[] r13 = r0.f17480b
            r14 = 1
            if (r8 >= r11) goto L_0x0066
            r11 = r13[r8]
            if (r10 != r11) goto L_0x0063
            r11 = r12[r8]
            int r11 = r11.f15716h
            if (r11 <= 0) goto L_0x0063
            r8 = 1
            goto L_0x0067
        L_0x0063:
            int r8 = r8 + 1
            goto L_0x004e
        L_0x0066:
            r8 = 0
        L_0x0067:
            z1.e r11 = new z1.e
            r11.<init>(r1, r4, r8, r7)
            j0.a r8 = new j0.a
            r8.<init>(r10)
            android.util.Pair r8 = m(r14, r0, r2, r11, r8)
            if (r8 == 0) goto L_0x0085
            java.lang.Object r11 = r8.second
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            java.lang.Object r15 = r8.first
            z1.r r15 = (z1.r) r15
            r5[r11] = r15
        L_0x0085:
            if (r8 != 0) goto L_0x0089
            r8 = 0
            goto L_0x0099
        L_0x0089:
            java.lang.Object r8 = r8.first
            z1.r r8 = (z1.r) r8
            g1.v1 r15 = r8.f17476a
            int[] r8 = r8.f17477b
            r8 = r8[r7]
            g1.a0[] r15 = r15.f6676k
            r8 = r15[r8]
            java.lang.String r8 = r8.f6267j
        L_0x0099:
            androidx.fragment.app.g r15 = new androidx.fragment.app.g
            r6 = 13
            r15.<init>(r4, r6, r8)
            j0.a r6 = new j0.a
            r8 = 4
            r6.<init>(r8)
            android.util.Pair r6 = m(r9, r0, r2, r15, r6)
            if (r6 == 0) goto L_0x00ba
            java.lang.Object r8 = r6.second
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            java.lang.Object r6 = r6.first
            z1.r r6 = (z1.r) r6
            r5[r8] = r6
        L_0x00ba:
            r6 = 0
        L_0x00bb:
            if (r6 >= r3) goto L_0x015a
            r8 = r13[r6]
            if (r8 == r10) goto L_0x014e
            if (r8 == r14) goto L_0x014e
            if (r8 == r9) goto L_0x014e
            r8 = r12[r6]
            r15 = r2[r6]
            r9 = 0
            r10 = 0
            r16 = 0
            r17 = 0
        L_0x00cf:
            int r11 = r8.f15716h
            if (r9 >= r11) goto L_0x013a
            g1.v1 r11 = r8.i(r9)
            r19 = r15[r9]
            r21 = r8
            r7 = r16
            r14 = 0
        L_0x00de:
            int r8 = r11.f6673h
            if (r14 >= r8) goto L_0x012d
            r8 = r19[r14]
            r22 = r10
            boolean r10 = r4.f17428s0
            boolean r8 = j(r8, r10)
            if (r8 == 0) goto L_0x0120
            g1.a0[] r8 = r11.f6676k
            r8 = r8[r14]
            z1.h r10 = new z1.h
            r23 = r11
            r11 = r19[r14]
            r10.<init>(r8, r11)
            if (r7 == 0) goto L_0x0118
            d9.c0 r8 = d9.e0.f4608a
            boolean r11 = r7.f17414i
            r24 = r12
            boolean r12 = r10.f17414i
            d9.e0 r8 = r8.c(r12, r11)
            boolean r11 = r10.f17413h
            boolean r12 = r7.f17413h
            d9.e0 r8 = r8.c(r11, r12)
            int r8 = r8.e()
            if (r8 <= 0) goto L_0x0124
            goto L_0x011a
        L_0x0118:
            r24 = r12
        L_0x011a:
            r7 = r10
            r17 = r14
            r10 = r23
            goto L_0x0126
        L_0x0120:
            r23 = r11
            r24 = r12
        L_0x0124:
            r10 = r22
        L_0x0126:
            int r14 = r14 + 1
            r11 = r23
            r12 = r24
            goto L_0x00de
        L_0x012d:
            r22 = r10
            r24 = r12
            int r9 = r9 + 1
            r16 = r7
            r8 = r21
            r7 = 0
            r14 = 1
            goto L_0x00cf
        L_0x013a:
            r24 = r12
            if (r10 != 0) goto L_0x0140
            r7 = 0
            goto L_0x014b
        L_0x0140:
            z1.r r7 = new z1.r
            r8 = 1
            int[] r9 = new int[r8]
            r8 = 0
            r9[r8] = r17
            r7.<init>(r8, r10, r9)
        L_0x014b:
            r5[r6] = r7
            goto L_0x0150
        L_0x014e:
            r24 = r12
        L_0x0150:
            int r6 = r6 + 1
            r12 = r24
            r7 = 0
            r9 = 3
            r10 = 2
            r14 = 1
            goto L_0x00bb
        L_0x015a:
            int r6 = r0.f17479a
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            r8 = 0
        L_0x0162:
            v1.l1[] r9 = r0.f17481c
            if (r8 >= r6) goto L_0x016e
            r9 = r9[r8]
            h(r9, r4, r7)
            int r8 = r8 + 1
            goto L_0x0162
        L_0x016e:
            v1.l1 r8 = r0.f17484f
            h(r8, r4, r7)
            r8 = 0
        L_0x0174:
            r10 = -1
            if (r8 >= r6) goto L_0x01ab
            int[] r11 = r0.f17480b
            r11 = r11[r8]
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            java.lang.Object r11 = r7.get(r11)
            g1.w1 r11 = (g1.w1) r11
            if (r11 != 0) goto L_0x0188
            goto L_0x01a8
        L_0x0188:
            d9.r0 r12 = r11.f6687i
            boolean r13 = r12.isEmpty()
            if (r13 != 0) goto L_0x01a5
            r13 = r9[r8]
            g1.v1 r11 = r11.f6686h
            int r13 = r13.j(r11)
            if (r13 == r10) goto L_0x01a5
            z1.r r10 = new z1.r
            int[] r12 = g9.b.d(r12)
            r13 = 0
            r10.<init>(r13, r11, r12)
            goto L_0x01a6
        L_0x01a5:
            r10 = 0
        L_0x01a6:
            r5[r8] = r10
        L_0x01a8:
            int r8 = r8 + 1
            goto L_0x0174
        L_0x01ab:
            int r6 = r0.f17479a
            r7 = 0
        L_0x01ae:
            if (r7 >= r6) goto L_0x01f7
            v1.l1[] r8 = r0.f17481c
            r8 = r8[r7]
            android.util.SparseArray r9 = r4.f17431v0
            java.lang.Object r9 = r9.get(r7)
            java.util.Map r9 = (java.util.Map) r9
            if (r9 == 0) goto L_0x01c6
            boolean r9 = r9.containsKey(r8)
            if (r9 == 0) goto L_0x01c6
            r9 = 1
            goto L_0x01c7
        L_0x01c6:
            r9 = 0
        L_0x01c7:
            if (r9 != 0) goto L_0x01ca
            goto L_0x01f4
        L_0x01ca:
            android.util.SparseArray r9 = r4.f17431v0
            java.lang.Object r9 = r9.get(r7)
            java.util.Map r9 = (java.util.Map) r9
            if (r9 == 0) goto L_0x01db
            java.lang.Object r9 = r9.get(r8)
            z1.k r9 = (z1.k) r9
            goto L_0x01dc
        L_0x01db:
            r9 = 0
        L_0x01dc:
            if (r9 == 0) goto L_0x01f1
            int[] r11 = r9.f17437i
            int r12 = r11.length
            if (r12 == 0) goto L_0x01f1
            z1.r r12 = new z1.r
            int r13 = r9.f17436h
            g1.v1 r8 = r8.i(r13)
            int r9 = r9.f17438j
            r12.<init>(r9, r8, r11)
            goto L_0x01f2
        L_0x01f1:
            r12 = 0
        L_0x01f2:
            r5[r7] = r12
        L_0x01f4:
            int r7 = r7 + 1
            goto L_0x01ae
        L_0x01f7:
            r6 = 0
        L_0x01f8:
            if (r6 >= r3) goto L_0x021b
            int[] r7 = r0.f17480b
            r7 = r7[r6]
            android.util.SparseBooleanArray r8 = r4.f17432w0
            boolean r8 = r8.get(r6)
            if (r8 != 0) goto L_0x0215
            d9.u0 r8 = r4.G
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            boolean r7 = r8.contains(r7)
            if (r7 == 0) goto L_0x0213
            goto L_0x0215
        L_0x0213:
            r7 = 0
            goto L_0x0218
        L_0x0215:
            r7 = 0
            r5[r6] = r7
        L_0x0218:
            int r6 = r6 + 1
            goto L_0x01f8
        L_0x021b:
            r7 = 0
            z1.b r6 = r1.f17471e
            a2.d r8 = r1.f17486b
            j1.a.f(r8)
            r6.getClass()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r11 = 0
        L_0x022c:
            r12 = 0
            if (r11 >= r3) goto L_0x0251
            r14 = r5[r11]
            if (r14 == 0) goto L_0x024a
            int[] r14 = r14.f17477b
            int r14 = r14.length
            r15 = 1
            if (r14 <= r15) goto L_0x024a
            d9.p0 r14 = d9.r0.f4657i
            d9.o0 r14 = new d9.o0
            r14.<init>()
            z1.a r15 = new z1.a
            r15.<init>(r12, r12)
            r14.c(r15)
            goto L_0x024b
        L_0x024a:
            r14 = r7
        L_0x024b:
            r9.add(r14)
            int r11 = r11 + 1
            goto L_0x022c
        L_0x0251:
            long[][] r11 = new long[r3][]
            r14 = 0
        L_0x0254:
            r17 = -1
            if (r14 >= r3) goto L_0x029a
            r15 = r5[r14]
            if (r15 != 0) goto L_0x0262
            r7 = 0
            long[] r15 = new long[r7]
            r11[r14] = r15
            goto L_0x028f
        L_0x0262:
            int[] r7 = r15.f17477b
            int r12 = r7.length
            long[] r12 = new long[r12]
            r11[r14] = r12
            r12 = 0
        L_0x026a:
            int r13 = r7.length
            if (r12 >= r13) goto L_0x028a
            r13 = r7[r12]
            g1.v1 r10 = r15.f17476a
            g1.a0[] r10 = r10.f6676k
            r10 = r10[r13]
            int r10 = r10.f6272o
            long r1 = (long) r10
            r10 = r11[r14]
            int r13 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r13 != 0) goto L_0x0280
            r1 = 0
        L_0x0280:
            r10[r12] = r1
            int r12 = r12 + 1
            r1 = r40
            r2 = r42
            r10 = -1
            goto L_0x026a
        L_0x028a:
            r1 = r11[r14]
            java.util.Arrays.sort(r1)
        L_0x028f:
            int r14 = r14 + 1
            r1 = r40
            r2 = r42
            r7 = 0
            r10 = -1
            r12 = 0
            goto L_0x0254
        L_0x029a:
            int[] r1 = new int[r3]
            long[] r2 = new long[r3]
            r7 = 0
        L_0x029f:
            if (r7 >= r3) goto L_0x02b1
            r10 = r11[r7]
            int r12 = r10.length
            if (r12 != 0) goto L_0x02a9
            r13 = 0
            goto L_0x02ac
        L_0x02a9:
            r12 = 0
            r13 = r10[r12]
        L_0x02ac:
            r2[r7] = r13
            int r7 = r7 + 1
            goto L_0x029f
        L_0x02b1:
            z1.c.u(r9, r2)
            d9.o1 r7 = d9.o1.f4642h
            r7.getClass()
            d9.g1 r10 = new d9.g1
            r10.<init>(r7)
            java.lang.String r7 = "expectedValuesPerKey"
            r12 = 2
            d9.u.a(r12, r7)
            d9.j1 r7 = new d9.j1
            r7.<init>(r10)
            java.util.Map r7 = r10.a()
            d9.h1 r10 = new d9.h1
            r10.<init>(r12)
            d9.m1 r12 = new d9.m1
            r12.<init>(r7, r10)
            r7 = 0
        L_0x02d8:
            if (r7 >= r3) goto L_0x0385
            r10 = r11[r7]
            int r13 = r10.length
            r14 = 1
            if (r13 > r14) goto L_0x02e6
            r38 = r4
            r39 = r5
            goto L_0x037d
        L_0x02e6:
            int r10 = r10.length
            double[] r13 = new double[r10]
            r14 = 0
        L_0x02ea:
            r15 = r11[r7]
            r38 = r4
            int r4 = r15.length
            r21 = 0
            r39 = r5
            if (r14 >= r4) goto L_0x030a
            r4 = r15[r14]
            int r15 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r15 != 0) goto L_0x02fc
            goto L_0x0301
        L_0x02fc:
            double r4 = (double) r4
            double r21 = java.lang.Math.log(r4)
        L_0x0301:
            r13[r14] = r21
            int r14 = r14 + 1
            r4 = r38
            r5 = r39
            goto L_0x02ea
        L_0x030a:
            int r10 = r10 + -1
            r4 = r13[r10]
            r14 = 0
            r23 = r13[r14]
            double r4 = r4 - r23
            r14 = 0
        L_0x0314:
            if (r14 >= r10) goto L_0x037d
            r23 = r13[r14]
            int r14 = r14 + 1
            r25 = r13[r14]
            double r23 = r23 + r25
            r25 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r23 = r23 * r25
            int r15 = (r4 > r21 ? 1 : (r4 == r21 ? 0 : -1))
            if (r15 != 0) goto L_0x0329
            r23 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            goto L_0x0330
        L_0x0329:
            r15 = 0
            r25 = r13[r15]
            double r23 = r23 - r25
            double r23 = r23 / r4
        L_0x0330:
            java.lang.Double r15 = java.lang.Double.valueOf(r23)
            r23 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            java.util.Map r5 = r12.f4592l
            java.lang.Object r25 = r5.get(r15)
            r26 = r10
            r10 = r25
            java.util.Collection r10 = (java.util.Collection) r10
            if (r10 != 0) goto L_0x036a
            c9.w r10 = r12.f4633n
            java.lang.Object r10 = r10.get()
            java.util.List r10 = (java.util.List) r10
            boolean r4 = r10.add(r4)
            if (r4 == 0) goto L_0x0362
            int r4 = r12.f4593m
            r20 = 1
            int r4 = r4 + 1
            r12.f4593m = r4
            r5.put(r15, r10)
            goto L_0x0378
        L_0x0362:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.String r1 = "New Collection violated the Collection spec"
            r0.<init>(r1)
            throw r0
        L_0x036a:
            r20 = 1
            boolean r4 = r10.add(r4)
            if (r4 == 0) goto L_0x0378
            int r4 = r12.f4593m
            int r4 = r4 + 1
            r12.f4593m = r4
        L_0x0378:
            r4 = r23
            r10 = r26
            goto L_0x0314
        L_0x037d:
            int r7 = r7 + 1
            r4 = r38
            r5 = r39
            goto L_0x02d8
        L_0x0385:
            r38 = r4
            r39 = r5
            java.util.Collection r4 = r12.j()
            d9.r0 r4 = d9.r0.j(r4)
            r5 = 0
        L_0x0392:
            int r7 = r4.size()
            if (r5 >= r7) goto L_0x03b4
            java.lang.Object r7 = r4.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r10 = r1[r7]
            r12 = 1
            int r10 = r10 + r12
            r1[r7] = r10
            r12 = r11[r7]
            r13 = r12[r10]
            r2[r7] = r13
            z1.c.u(r9, r2)
            int r5 = r5 + 1
            goto L_0x0392
        L_0x03b4:
            r1 = 0
        L_0x03b5:
            if (r1 >= r3) goto L_0x03c8
            java.lang.Object r4 = r9.get(r1)
            if (r4 == 0) goto L_0x03c5
            r4 = r2[r1]
            r10 = 2
            long r4 = r4 * r10
            r2[r1] = r4
        L_0x03c5:
            int r1 = r1 + 1
            goto L_0x03b5
        L_0x03c8:
            z1.c.u(r9, r2)
            d9.o0 r1 = new d9.o0
            r1.<init>()
            r2 = 0
        L_0x03d1:
            int r4 = r9.size()
            if (r2 >= r4) goto L_0x03ec
            java.lang.Object r4 = r9.get(r2)
            d9.o0 r4 = (d9.o0) r4
            if (r4 != 0) goto L_0x03e2
            d9.r1 r4 = d9.r1.f4658l
            goto L_0x03e6
        L_0x03e2:
            d9.r1 r4 = r4.e()
        L_0x03e6:
            r1.c(r4)
            int r2 = r2 + 1
            goto L_0x03d1
        L_0x03ec:
            d9.r1 r1 = r1.e()
            z1.s[] r2 = new z1.s[r3]
            r4 = 0
        L_0x03f3:
            if (r4 >= r3) goto L_0x0456
            r5 = r39[r4]
            if (r5 == 0) goto L_0x0452
            int[] r7 = r5.f17477b
            int r9 = r7.length
            if (r9 != 0) goto L_0x03ff
            goto L_0x0452
        L_0x03ff:
            int r9 = r7.length
            r10 = 1
            if (r9 != r10) goto L_0x0410
            z1.t r9 = new z1.t
            r10 = 0
            r7 = r7[r10]
            int r11 = r5.f17478c
            g1.v1 r5 = r5.f17476a
            r9.<init>(r7, r11, r5)
            goto L_0x044f
        L_0x0410:
            r10 = 0
            g1.v1 r9 = r5.f17476a
            r22 = r9
            int r5 = r5.f17478c
            r24 = r5
            java.lang.Object r5 = r1.get(r4)
            r36 = r5
            d9.r0 r36 = (d9.r0) r36
            z1.c r9 = new z1.c
            r21 = r9
            int r5 = r6.f17364a
            long r11 = (long) r5
            r26 = r11
            int r5 = r6.f17365b
            long r11 = (long) r5
            r28 = r11
            int r5 = r6.f17366c
            long r11 = (long) r5
            r30 = r11
            int r5 = r6.f17367d
            r32 = r5
            int r5 = r6.f17368e
            r33 = r5
            float r5 = r6.f17369f
            r34 = r5
            float r5 = r6.f17370g
            r35 = r5
            j1.d r5 = r6.f17371h
            r37 = r5
            r23 = r7
            r25 = r8
            r21.<init>(r22, r23, r24, r25, r26, r28, r30, r32, r33, r34, r35, r36, r37)
        L_0x044f:
            r2[r4] = r9
            goto L_0x0453
        L_0x0452:
            r10 = 0
        L_0x0453:
            int r4 = r4 + 1
            goto L_0x03f3
        L_0x0456:
            r10 = 0
            m1.o1[] r1 = new m1.o1[r3]
            r8 = 0
        L_0x045a:
            if (r8 >= r3) goto L_0x0497
            int[] r4 = r0.f17480b
            r4 = r4[r8]
            r5 = r38
            android.util.SparseBooleanArray r6 = r5.f17432w0
            boolean r6 = r6.get(r8)
            if (r6 != 0) goto L_0x0479
            d9.u0 r6 = r5.G
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r4 = r6.contains(r4)
            if (r4 == 0) goto L_0x0477
            goto L_0x0479
        L_0x0477:
            r4 = 0
            goto L_0x047a
        L_0x0479:
            r4 = 1
        L_0x047a:
            if (r4 != 0) goto L_0x0489
            int[] r4 = r0.f17480b
            r4 = r4[r8]
            r6 = -2
            if (r4 == r6) goto L_0x0487
            r4 = r2[r8]
            if (r4 == 0) goto L_0x0489
        L_0x0487:
            r4 = 1
            goto L_0x048a
        L_0x0489:
            r4 = 0
        L_0x048a:
            if (r4 == 0) goto L_0x048f
            m1.o1 r4 = m1.o1.f10418b
            goto L_0x0490
        L_0x048f:
            r4 = 0
        L_0x0490:
            r1[r8] = r4
            int r8 = r8 + 1
            r38 = r5
            goto L_0x045a
        L_0x0497:
            r5 = r38
            boolean r3 = r5.f17429t0
            if (r3 == 0) goto L_0x050d
            r3 = -1
            r4 = -1
            r8 = 0
        L_0x04a0:
            int r5 = r0.f17479a
            if (r8 >= r5) goto L_0x04f6
            int[] r5 = r0.f17480b
            r5 = r5[r8]
            r6 = r2[r8]
            r7 = 1
            if (r5 == r7) goto L_0x04b4
            r7 = 2
            if (r5 != r7) goto L_0x04b1
            goto L_0x04b5
        L_0x04b1:
            r14 = 32
            goto L_0x04f3
        L_0x04b4:
            r7 = 2
        L_0x04b5:
            if (r6 == 0) goto L_0x04b1
            r9 = r42[r8]
            v1.l1[] r11 = r0.f17481c
            r11 = r11[r8]
            g1.v1 r12 = r6.l()
            int r11 = r11.j(r12)
            r12 = 0
        L_0x04c6:
            int r13 = r6.length()
            if (r12 >= r13) goto L_0x04de
            r13 = r9[r11]
            int r14 = r6.g(r12)
            r13 = r13[r14]
            r14 = 32
            r13 = r13 & r14
            if (r13 == r14) goto L_0x04db
            r6 = 0
            goto L_0x04e1
        L_0x04db:
            int r12 = r12 + 1
            goto L_0x04c6
        L_0x04de:
            r14 = 32
            r6 = 1
        L_0x04e1:
            if (r6 == 0) goto L_0x04f3
            r6 = 1
            if (r5 != r6) goto L_0x04ec
            r5 = -1
            if (r4 == r5) goto L_0x04ea
            goto L_0x04ef
        L_0x04ea:
            r4 = r8
            goto L_0x04f3
        L_0x04ec:
            r5 = -1
            if (r3 == r5) goto L_0x04f2
        L_0x04ef:
            r0 = -1
            r8 = 0
            goto L_0x04f8
        L_0x04f2:
            r3 = r8
        L_0x04f3:
            int r8 = r8 + 1
            goto L_0x04a0
        L_0x04f6:
            r0 = -1
            r8 = 1
        L_0x04f8:
            if (r4 == r0) goto L_0x04fe
            if (r3 == r0) goto L_0x04fe
            r7 = 1
            goto L_0x04ff
        L_0x04fe:
            r7 = 0
        L_0x04ff:
            r0 = r8 & r7
            if (r0 == 0) goto L_0x050d
            m1.o1 r0 = new m1.o1
            r5 = 1
            r0.<init>(r5)
            r1[r4] = r0
            r1[r3] = r0
        L_0x050d:
            android.util.Pair r0 = android.util.Pair.create(r1, r2)
            return r0
        L_0x0512:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0512 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.q.g(z1.u, int[][][], int[]):android.util.Pair");
    }

    public final void k() {
        boolean z10;
        u0 u0Var;
        i0 i0Var;
        synchronized (this.f17469c) {
            if (!this.f17473g.f17427r0 || this.f17472f || l0.f8453a < 32 || (i0Var = this.f17474h) == null || !i0Var.f12464i) {
                z10 = false;
            } else {
                z10 = true;
            }
        }
        if (z10 && (u0Var = this.f17485a) != null) {
            u0Var.f10506o.d(10);
        }
    }

    public final void n(j jVar) {
        boolean z10;
        jVar.getClass();
        synchronized (this.f17469c) {
            if (!this.f17473g.equals(jVar)) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f17473g = jVar;
        }
        if (z10) {
            if (jVar.f17427r0 && this.f17470d == null) {
                v.g("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            u0 u0Var = this.f17485a;
            if (u0Var != null) {
                u0Var.f10506o.d(10);
            }
        }
    }

    public q(j jVar, b bVar, Context context) {
        j jVar2;
        this.f17469c = new Object();
        i0 i0Var = null;
        this.f17470d = context != null ? context.getApplicationContext() : null;
        this.f17471e = bVar;
        if (!(jVar instanceof j)) {
            if (context == null) {
                jVar2 = j.f17415x0;
            } else {
                j jVar3 = j.f17415x0;
                jVar2 = new i(context).b();
            }
            jVar2.getClass();
            i iVar = new i(jVar2);
            iVar.e(jVar);
            jVar = new j(iVar);
        }
        this.f17473g = jVar;
        this.f17475i = h.f6386n;
        boolean z10 = context != null && l0.F(context);
        this.f17472f = z10;
        if (!z10 && context != null && l0.f8453a >= 32) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            this.f17474h = audioManager != null ? new i0(audioManager.getSpatializer()) : i0Var;
        }
        if (this.f17473g.f17427r0 && context == null) {
            v.g("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }
}
