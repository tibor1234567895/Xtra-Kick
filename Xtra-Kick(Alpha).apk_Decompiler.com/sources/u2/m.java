package u2;

import android.support.v4.media.h;
import android.util.SparseArray;
import d2.p0;
import d2.v;
import d2.w;
import d2.x0;
import d2.y;
import g1.a0;
import g1.b1;
import g1.t;
import g1.u;
import g1.z;
import j1.b0;
import j1.h0;
import j1.l0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import l2.d;

public final class m implements v {
    public static final byte[] I = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    public static final a0 J;
    public int A;
    public int B;
    public int C;
    public boolean D;
    public y E;
    public x0[] F;
    public x0[] G;
    public boolean H;

    /* renamed from: a  reason: collision with root package name */
    public final int f15241a;

    /* renamed from: b  reason: collision with root package name */
    public final u f15242b;

    /* renamed from: c  reason: collision with root package name */
    public final List f15243c;

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray f15244d;

    /* renamed from: e  reason: collision with root package name */
    public final b0 f15245e;

    /* renamed from: f  reason: collision with root package name */
    public final b0 f15246f;

    /* renamed from: g  reason: collision with root package name */
    public final b0 f15247g;

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f15248h;

    /* renamed from: i  reason: collision with root package name */
    public final b0 f15249i;

    /* renamed from: j  reason: collision with root package name */
    public final h0 f15250j;

    /* renamed from: k  reason: collision with root package name */
    public final d f15251k;

    /* renamed from: l  reason: collision with root package name */
    public final b0 f15252l;

    /* renamed from: m  reason: collision with root package name */
    public final ArrayDeque f15253m;

    /* renamed from: n  reason: collision with root package name */
    public final ArrayDeque f15254n;

    /* renamed from: o  reason: collision with root package name */
    public final x0 f15255o;

    /* renamed from: p  reason: collision with root package name */
    public int f15256p;

    /* renamed from: q  reason: collision with root package name */
    public int f15257q;

    /* renamed from: r  reason: collision with root package name */
    public long f15258r;

    /* renamed from: s  reason: collision with root package name */
    public int f15259s;

    /* renamed from: t  reason: collision with root package name */
    public b0 f15260t;

    /* renamed from: u  reason: collision with root package name */
    public long f15261u;

    /* renamed from: v  reason: collision with root package name */
    public int f15262v;

    /* renamed from: w  reason: collision with root package name */
    public long f15263w;

    /* renamed from: x  reason: collision with root package name */
    public long f15264x;

    /* renamed from: y  reason: collision with root package name */
    public long f15265y;

    /* renamed from: z  reason: collision with root package name */
    public l f15266z;

    static {
        z zVar = new z();
        zVar.f6754k = "application/x-emsg";
        J = zVar.a();
    }

    public m() {
        this(0);
    }

    public static u b(ArrayList arrayList) {
        UUID uuid;
        int size = arrayList.size();
        ArrayList arrayList2 = null;
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = (b) arrayList.get(i10);
            if (bVar.f15201b == 1886614376) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                byte[] bArr = bVar.f15199c.f8414a;
                d0.d b10 = q.b(bArr);
                if (b10 == null) {
                    uuid = null;
                } else {
                    uuid = (UUID) b10.f4091i;
                }
                if (uuid == null) {
                    j1.v.g("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList2.add(new t(uuid, (String) null, "video/mp4", bArr));
                }
            }
        }
        if (arrayList2 == null) {
            return null;
        }
        return new u((String) null, false, (t[]) arrayList2.toArray(new t[0]));
    }

    public static void f(b0 b0Var, int i10, w wVar) {
        boolean z10;
        b0Var.G(i10 + 8);
        int f10 = b0Var.f() & 16777215;
        if ((f10 & 1) == 0) {
            if ((f10 & 2) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            int y10 = b0Var.y();
            if (y10 == 0) {
                Arrays.fill(wVar.f15332l, 0, wVar.f15325e, false);
            } else if (y10 == wVar.f15325e) {
                Arrays.fill(wVar.f15332l, 0, y10, z10);
                int i11 = b0Var.f8416c - b0Var.f8415b;
                b0 b0Var2 = wVar.f15334n;
                b0Var2.D(i11);
                wVar.f15331k = true;
                wVar.f15335o = true;
                b0Var.d(b0Var2.f8414a, 0, b0Var2.f8416c);
                b0Var2.G(0);
                wVar.f15335o = false;
            } else {
                StringBuilder r10 = h.r("Senc sample count ", y10, " is different from fragment sample count");
                r10.append(wVar.f15325e);
                throw b1.a(r10.toString(), (Exception) null);
            }
        } else {
            throw b1.c("Overriding TrackEncryptionBox parameters is unsupported.");
        }
    }

    public final void a() {
    }

    public final void c(long j10, long j11) {
        SparseArray sparseArray = this.f15244d;
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((l) sparseArray.valueAt(i10)).d();
        }
        this.f15254n.clear();
        this.f15262v = 0;
        this.f15263w = j11;
        this.f15253m.clear();
        this.f15256p = 0;
        this.f15259s = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:146:0x02fe, code lost:
        if (r2.b() == false) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0302, code lost:
        r1.f15256p = 3;
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0102, code lost:
        if (r2.b() == false) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0104, code lost:
        r1.f15266z = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01d6, code lost:
        if ((r12 & 31) != 6) goto L_0x01db;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x0610  */
    /* JADX WARNING: Removed duplicated region for block: B:364:0x0796 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:371:0x078a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x078c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d(d2.w r27, d2.s0 r28) {
        /*
            r26 = this;
            r1 = r26
            r0 = r27
        L_0x0004:
            int r2 = r1.f15256p
            java.util.ArrayDeque r3 = r1.f15253m
            android.util.SparseArray r4 = r1.f15244d
            r5 = 2
            r7 = 1
            r9 = 1701671783(0x656d7367, float:7.0083103E22)
            r10 = 1936286840(0x73696478, float:1.8491255E31)
            if (r2 == 0) goto L_0x0599
            java.util.ArrayDeque r11 = r1.f15254n
            j1.h0 r12 = r1.f15250j
            java.lang.String r13 = "FragmentedMp4Extractor"
            if (r2 == r7) goto L_0x035b
            r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r2 == r5) goto L_0x030a
            u2.l r2 = r1.f15266z
            if (r2 != 0) goto L_0x00af
            int r2 = r4.size()
            r3 = 0
            r3 = 0
            r5 = 0
        L_0x002e:
            if (r5 >= r2) goto L_0x0067
            java.lang.Object r7 = r4.valueAt(r5)
            u2.l r7 = (u2.l) r7
            boolean r14 = r7.f15240l
            if (r14 != 0) goto L_0x0042
            int r15 = r7.f15234f
            u2.x r6 = r7.f15232d
            int r6 = r6.f15339b
            if (r15 == r6) goto L_0x0064
        L_0x0042:
            u2.w r6 = r7.f15230b
            if (r14 == 0) goto L_0x004d
            int r15 = r7.f15236h
            int r8 = r6.f15324d
            if (r15 != r8) goto L_0x004d
            goto L_0x0064
        L_0x004d:
            if (r14 != 0) goto L_0x0058
            u2.x r6 = r7.f15232d
            long[] r6 = r6.f15340c
            int r8 = r7.f15234f
            r14 = r6[r8]
            goto L_0x005e
        L_0x0058:
            long[] r6 = r6.f15326f
            int r8 = r7.f15236h
            r14 = r6[r8]
        L_0x005e:
            int r6 = (r14 > r9 ? 1 : (r14 == r9 ? 0 : -1))
            if (r6 >= 0) goto L_0x0064
            r3 = r7
            r9 = r14
        L_0x0064:
            int r5 = r5 + 1
            goto L_0x002e
        L_0x0067:
            if (r3 != 0) goto L_0x0086
            long r2 = r1.f15261u
            long r4 = r27.p()
            long r2 = r2 - r4
            int r3 = (int) r2
            if (r3 < 0) goto L_0x007e
            r0.g(r3)
            r2 = 0
            r1.f15256p = r2
            r1.f15259s = r2
            r2 = 0
            goto L_0x0306
        L_0x007e:
            java.lang.String r0 = "Offset to end of mdat was negative."
            r2 = 0
            g1.b1 r0 = g1.b1.a(r0, r2)
            throw r0
        L_0x0086:
            boolean r2 = r3.f15240l
            if (r2 != 0) goto L_0x0093
            u2.x r2 = r3.f15232d
            long[] r2 = r2.f15340c
            int r4 = r3.f15234f
            r4 = r2[r4]
            goto L_0x009b
        L_0x0093:
            u2.w r2 = r3.f15230b
            long[] r2 = r2.f15326f
            int r4 = r3.f15236h
            r4 = r2[r4]
        L_0x009b:
            long r6 = r27.p()
            long r4 = r4 - r6
            int r2 = (int) r4
            if (r2 >= 0) goto L_0x00a9
            java.lang.String r2 = "Ignoring negative offset to sample data."
            j1.v.g(r13, r2)
            r2 = 0
        L_0x00a9:
            r0.g(r2)
            r1.f15266z = r3
            r2 = r3
        L_0x00af:
            int r3 = r1.f15256p
            r4 = 3
            if (r3 != r4) goto L_0x0158
            boolean r3 = r2.f15240l
            u2.w r4 = r2.f15230b
            if (r3 != 0) goto L_0x00c3
            u2.x r3 = r2.f15232d
            int[] r3 = r3.f15341d
            int r5 = r2.f15234f
            r3 = r3[r5]
            goto L_0x00c9
        L_0x00c3:
            int[] r3 = r4.f15328h
            int r5 = r2.f15234f
            r3 = r3[r5]
        L_0x00c9:
            r1.A = r3
            int r5 = r2.f15234f
            int r6 = r2.f15237i
            if (r5 >= r6) goto L_0x0109
            r0.g(r3)
            u2.v r3 = r2.a()
            if (r3 != 0) goto L_0x00db
            goto L_0x00fe
        L_0x00db:
            j1.b0 r5 = r4.f15334n
            int r3 = r3.f15319d
            if (r3 == 0) goto L_0x00e4
            r5.H(r3)
        L_0x00e4:
            int r3 = r2.f15234f
            boolean r6 = r4.f15331k
            if (r6 == 0) goto L_0x00f2
            boolean[] r4 = r4.f15332l
            boolean r3 = r4[r3]
            if (r3 == 0) goto L_0x00f2
            r3 = 1
            goto L_0x00f3
        L_0x00f2:
            r3 = 0
        L_0x00f3:
            if (r3 == 0) goto L_0x00fe
            int r3 = r5.A()
            int r3 = r3 * 6
            r5.H(r3)
        L_0x00fe:
            boolean r2 = r2.b()
            if (r2 != 0) goto L_0x0302
        L_0x0104:
            r2 = 0
            r1.f15266z = r2
            goto L_0x0302
        L_0x0109:
            u2.x r4 = r2.f15232d
            u2.u r4 = r4.f15338a
            int r4 = r4.f15311g
            r5 = 1
            if (r4 != r5) goto L_0x011b
            int r3 = r3 + -8
            r1.A = r3
            r3 = 8
            r0.g(r3)
        L_0x011b:
            u2.x r3 = r2.f15232d
            u2.u r3 = r3.f15338a
            g1.a0 r3 = r3.f15310f
            java.lang.String r3 = r3.f6276s
            java.lang.String r4 = "audio/ac4"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0145
            int r3 = r1.A
            r4 = 7
            int r3 = r2.c(r3, r4)
            r1.B = r3
            int r3 = r1.A
            j1.b0 r5 = r1.f15249i
            d2.d.a(r3, r5)
            d2.x0 r3 = r2.f15229a
            r3.d(r4, r5)
            int r3 = r1.B
            int r3 = r3 + r4
            r4 = 0
            goto L_0x014c
        L_0x0145:
            int r3 = r1.A
            r4 = 0
            int r3 = r2.c(r3, r4)
        L_0x014c:
            r1.B = r3
            int r5 = r1.A
            int r5 = r5 + r3
            r1.A = r5
            r3 = 4
            r1.f15256p = r3
            r1.C = r4
        L_0x0158:
            u2.x r3 = r2.f15232d
            u2.u r4 = r3.f15338a
            d2.x0 r5 = r2.f15229a
            boolean r6 = r2.f15240l
            u2.w r7 = r2.f15230b
            if (r6 != 0) goto L_0x016b
            long[] r3 = r3.f15343f
            int r6 = r2.f15234f
            r8 = r3[r6]
            goto L_0x0171
        L_0x016b:
            int r3 = r2.f15234f
            long[] r6 = r7.f15329i
            r8 = r6[r3]
        L_0x0171:
            if (r12 == 0) goto L_0x0177
            long r8 = r12.a(r8)
        L_0x0177:
            int r3 = r4.f15314j
            if (r3 == 0) goto L_0x0261
            j1.b0 r6 = r1.f15246f
            byte[] r10 = r6.f8414a
            r13 = 0
            r10[r13] = r13
            r14 = 1
            r10[r14] = r13
            r14 = 2
            r10[r14] = r13
            int r13 = r3 + 1
            int r3 = 4 - r3
        L_0x018c:
            int r14 = r1.B
            int r15 = r1.A
            if (r14 >= r15) goto L_0x025e
            int r14 = r1.C
            java.lang.String r15 = "video/hevc"
            r16 = r12
            g1.a0 r12 = r4.f15310f
            if (r14 != 0) goto L_0x020b
            r0.readFully(r10, r3, r13)
            r14 = 0
            r6.G(r14)
            int r14 = r6.f()
            r17 = r4
            r4 = 1
            if (r14 < r4) goto L_0x0203
            int r14 = r14 + -1
            r1.C = r14
            j1.b0 r4 = r1.f15245e
            r14 = 0
            r4.G(r14)
            r14 = 4
            r5.d(r14, r4)
            r4 = 1
            r5.d(r4, r6)
            d2.x0[] r4 = r1.G
            int r4 = r4.length
            if (r4 <= 0) goto L_0x01f0
            java.lang.String r4 = r12.f6276s
            byte r12 = r10[r14]
            byte[] r14 = d2.p0.f4278a
            java.lang.String r14 = "video/avc"
            boolean r14 = r14.equals(r4)
            if (r14 == 0) goto L_0x01d9
            r14 = r12 & 31
            r18 = r6
            r6 = 6
            if (r14 == r6) goto L_0x01e9
            goto L_0x01db
        L_0x01d9:
            r18 = r6
        L_0x01db:
            boolean r4 = r15.equals(r4)
            if (r4 == 0) goto L_0x01eb
            r4 = r12 & 126(0x7e, float:1.77E-43)
            int r4 = r4 >> 1
            r6 = 39
            if (r4 != r6) goto L_0x01eb
        L_0x01e9:
            r4 = 1
            goto L_0x01ec
        L_0x01eb:
            r4 = 0
        L_0x01ec:
            if (r4 == 0) goto L_0x01f2
            r4 = 1
            goto L_0x01f3
        L_0x01f0:
            r18 = r6
        L_0x01f2:
            r4 = 0
        L_0x01f3:
            r1.D = r4
            int r4 = r1.B
            int r4 = r4 + 5
            r1.B = r4
            int r4 = r1.A
            int r4 = r4 + r3
            r1.A = r4
            r28 = r3
            goto L_0x0254
        L_0x0203:
            java.lang.String r0 = "Invalid NAL length"
            r2 = 0
            g1.b1 r0 = g1.b1.a(r0, r2)
            throw r0
        L_0x020b:
            r17 = r4
            r18 = r6
            boolean r4 = r1.D
            if (r4 == 0) goto L_0x0243
            j1.b0 r4 = r1.f15247g
            r4.D(r14)
            byte[] r6 = r4.f8414a
            int r14 = r1.C
            r28 = r3
            r3 = 0
            r0.readFully(r6, r3, r14)
            int r3 = r1.C
            r5.d(r3, r4)
            int r3 = r1.C
            byte[] r6 = r4.f8414a
            int r14 = r4.f8416c
            int r6 = d2.p0.f(r14, r6)
            java.lang.String r12 = r12.f6276s
            boolean r12 = r15.equals(r12)
            r4.G(r12)
            r4.F(r6)
            d2.x0[] r6 = r1.G
            d2.m.a(r8, r4, r6)
            goto L_0x024a
        L_0x0243:
            r28 = r3
            r3 = 0
            int r3 = r5.c(r0, r14, r3)
        L_0x024a:
            int r4 = r1.B
            int r4 = r4 + r3
            r1.B = r4
            int r4 = r1.C
            int r4 = r4 - r3
            r1.C = r4
        L_0x0254:
            r3 = r28
            r12 = r16
            r4 = r17
            r6 = r18
            goto L_0x018c
        L_0x025e:
            r16 = r12
            goto L_0x0275
        L_0x0261:
            r16 = r12
        L_0x0263:
            int r3 = r1.B
            int r4 = r1.A
            if (r3 >= r4) goto L_0x0275
            int r4 = r4 - r3
            r3 = 0
            int r3 = r5.c(r0, r4, r3)
            int r4 = r1.B
            int r4 = r4 + r3
            r1.B = r4
            goto L_0x0263
        L_0x0275:
            boolean r3 = r2.f15240l
            if (r3 != 0) goto L_0x0282
            u2.x r3 = r2.f15232d
            int[] r3 = r3.f15344g
            int r4 = r2.f15234f
            r3 = r3[r4]
            goto L_0x028d
        L_0x0282:
            boolean[] r3 = r7.f15330j
            int r4 = r2.f15234f
            boolean r3 = r3[r4]
            if (r3 == 0) goto L_0x028c
            r3 = 1
            goto L_0x028d
        L_0x028c:
            r3 = 0
        L_0x028d:
            u2.v r4 = r2.a()
            if (r4 == 0) goto L_0x0296
            r4 = 1073741824(0x40000000, float:2.0)
            r3 = r3 | r4
        L_0x0296:
            r20 = r3
            u2.v r3 = r2.a()
            if (r3 == 0) goto L_0x02a1
            d2.w0 r3 = r3.f15318c
            goto L_0x02a2
        L_0x02a1:
            r3 = 0
        L_0x02a2:
            r23 = r3
            int r3 = r1.A
            r22 = 0
            r17 = r5
            r18 = r8
            r21 = r3
            r17.e(r18, r20, r21, r22, r23)
        L_0x02b1:
            boolean r3 = r11.isEmpty()
            if (r3 != 0) goto L_0x02fa
            java.lang.Object r3 = r11.removeFirst()
            u2.k r3 = (u2.k) r3
            int r4 = r1.f15262v
            int r5 = r3.f15228c
            int r4 = r4 - r5
            r1.f15262v = r4
            boolean r4 = r3.f15227b
            long r5 = r3.f15226a
            if (r4 == 0) goto L_0x02cb
            long r5 = r5 + r8
        L_0x02cb:
            r4 = r16
            if (r16 == 0) goto L_0x02d3
            long r5 = r4.a(r5)
        L_0x02d3:
            d2.x0[] r7 = r1.F
            int r10 = r7.length
            r12 = 0
            r15 = 0
        L_0x02d8:
            if (r15 >= r10) goto L_0x02f7
            r12 = r7[r15]
            r16 = 1
            int r13 = r3.f15228c
            int r14 = r1.f15262v
            r18 = 0
            r17 = r13
            r19 = r14
            r13 = r5
            r20 = r15
            r15 = r16
            r16 = r17
            r17 = r19
            r12.e(r13, r15, r16, r17, r18)
            int r15 = r20 + 1
            goto L_0x02d8
        L_0x02f7:
            r16 = r4
            goto L_0x02b1
        L_0x02fa:
            boolean r2 = r2.b()
            if (r2 != 0) goto L_0x0302
            goto L_0x0104
        L_0x0302:
            r2 = 3
            r1.f15256p = r2
            r2 = 1
        L_0x0306:
            if (r2 == 0) goto L_0x0333
            r0 = 0
            return r0
        L_0x030a:
            int r2 = r4.size()
            r3 = 0
            r5 = 0
        L_0x0310:
            if (r5 >= r2) goto L_0x032e
            java.lang.Object r6 = r4.valueAt(r5)
            u2.l r6 = (u2.l) r6
            u2.w r6 = r6.f15230b
            boolean r7 = r6.f15335o
            if (r7 == 0) goto L_0x032b
            long r6 = r6.f15323c
            int r8 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r8 >= 0) goto L_0x032b
            java.lang.Object r3 = r4.valueAt(r5)
            u2.l r3 = (u2.l) r3
            r9 = r6
        L_0x032b:
            int r5 = r5 + 1
            goto L_0x0310
        L_0x032e:
            if (r3 != 0) goto L_0x0336
            r2 = 3
            r1.f15256p = r2
        L_0x0333:
            r7 = r1
            goto L_0x078c
        L_0x0336:
            long r4 = r27.p()
            long r9 = r9 - r4
            int r2 = (int) r9
            if (r2 < 0) goto L_0x0353
            r0.g(r2)
            u2.w r2 = r3.f15230b
            j1.b0 r3 = r2.f15334n
            byte[] r4 = r3.f8414a
            int r5 = r3.f8416c
            r6 = 0
            r0.readFully(r4, r6, r5)
            r3.G(r6)
            r2.f15335o = r6
            goto L_0x0333
        L_0x0353:
            java.lang.String r0 = "Offset to encryption data was negative."
            r2 = 0
            g1.b1 r0 = g1.b1.a(r0, r2)
            throw r0
        L_0x035b:
            r4 = r12
            long r5 = r1.f15258r
            int r2 = (int) r5
            int r5 = r1.f15259s
            int r2 = r2 - r5
            j1.b0 r5 = r1.f15260t
            if (r5 == 0) goto L_0x058c
            byte[] r6 = r5.f8414a
            r7 = 8
            r0.readFully(r6, r7, r2)
            u2.b r2 = new u2.b
            int r6 = r1.f15257q
            r2.<init>(r6, r5)
            long r7 = r27.p()
            boolean r12 = r3.isEmpty()
            if (r12 != 0) goto L_0x038c
            java.lang.Object r3 = r3.peek()
            u2.a r3 = (u2.a) r3
            java.util.ArrayList r3 = r3.f15197d
            r3.add(r2)
            r7 = r1
            goto L_0x0590
        L_0x038c:
            if (r6 != r10) goto L_0x0459
            r2 = 8
            r5.G(r2)
            int r2 = r5.f()
            int r2 = r2 >> 24
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 4
            r5.H(r3)
            long r3 = r5.w()
            if (r2 != 0) goto L_0x03ae
            long r9 = r5.w()
            long r11 = r5.w()
            goto L_0x03b6
        L_0x03ae:
            long r9 = r5.z()
            long r11 = r5.z()
        L_0x03b6:
            r15 = r9
            long r7 = r7 + r11
            r11 = 1000000(0xf4240, double:4.940656E-318)
            r9 = r15
            r13 = r3
            long r17 = j1.l0.M(r9, r11, r13)
            r2 = 2
            r5.H(r2)
            int r2 = r5.A()
            int[] r6 = new int[r2]
            long[] r13 = new long[r2]
            long[] r14 = new long[r2]
            long[] r11 = new long[r2]
            r9 = 0
            r9 = r15
            r19 = r17
            r15 = 0
        L_0x03d6:
            if (r15 >= r2) goto L_0x042e
            int r12 = r5.f()
            r16 = -2147483648(0xffffffff80000000, float:-0.0)
            r16 = r12 & r16
            if (r16 != 0) goto L_0x0426
            long r21 = r5.w()
            r16 = 2147483647(0x7fffffff, float:NaN)
            r12 = r12 & r16
            r6[r15] = r12
            r13[r15] = r7
            r11[r15] = r19
            long r19 = r9 + r21
            r21 = 1000000(0xf4240, double:4.940656E-318)
            r9 = r19
            r28 = r2
            r2 = r11
            r11 = r21
            r16 = r0
            r0 = r13
            r1 = r14
            r13 = r3
            long r9 = j1.l0.M(r9, r11, r13)
            r11 = r2[r15]
            long r11 = r9 - r11
            r1[r15] = r11
            r11 = 4
            r5.H(r11)
            r11 = r6[r15]
            long r11 = (long) r11
            long r7 = r7 + r11
            int r15 = r15 + 1
            r13 = r0
            r14 = r1
            r11 = r2
            r0 = r16
            r1 = r26
            r2 = r28
            r24 = r9
            r9 = r19
            r19 = r24
            goto L_0x03d6
        L_0x0426:
            java.lang.String r0 = "Unhandled indirect reference"
            r1 = 0
            g1.b1 r0 = g1.b1.a(r0, r1)
            throw r0
        L_0x042e:
            r16 = r0
            r2 = r11
            r0 = r13
            r1 = r14
            java.lang.Long r3 = java.lang.Long.valueOf(r17)
            d2.n r4 = new d2.n
            r4.<init>(r6, r0, r1, r2)
            android.util.Pair r0 = android.util.Pair.create(r3, r4)
            java.lang.Object r1 = r0.first
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            r7 = r26
            r7.f15265y = r1
            d2.y r1 = r7.E
            java.lang.Object r0 = r0.second
            d2.u0 r0 = (d2.u0) r0
            r1.g(r0)
            r0 = 1
            r7.H = r0
            goto L_0x0463
        L_0x0459:
            r16 = r0
            r7 = r1
            if (r6 != r9) goto L_0x0589
            d2.x0[] r0 = r7.F
            int r0 = r0.length
            if (r0 != 0) goto L_0x0467
        L_0x0463:
            r0 = r16
            goto L_0x0590
        L_0x0467:
            r0 = 8
            r5.G(r0)
            int r0 = r5.f()
            int r0 = r0 >> 24
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 == 0) goto L_0x04b2
            r3 = 1
            if (r0 == r3) goto L_0x0484
            java.lang.String r1 = "Skipping unsupported emsg version: "
            android.support.v4.media.h.z(r1, r0, r13)
            goto L_0x0463
        L_0x0484:
            long r8 = r5.w()
            long r17 = r5.z()
            r19 = 1000000(0xf4240, double:4.940656E-318)
            r21 = r8
            long r12 = j1.l0.M(r17, r19, r21)
            long r17 = r5.w()
            r19 = 1000(0x3e8, double:4.94E-321)
            long r8 = j1.l0.M(r17, r19, r21)
            long r14 = r5.w()
            java.lang.String r0 = r5.p()
            r0.getClass()
            java.lang.String r3 = r5.p()
            r3.getClass()
            goto L_0x04ec
        L_0x04b2:
            java.lang.String r0 = r5.p()
            r0.getClass()
            java.lang.String r3 = r5.p()
            r3.getClass()
            long r8 = r5.w()
            long r12 = r5.w()
            r14 = 1000000(0xf4240, double:4.940656E-318)
            r16 = r8
            long r18 = j1.l0.M(r12, r14, r16)
            long r12 = r7.f15265y
            int r6 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r6 == 0) goto L_0x04d9
            long r1 = r12 + r18
        L_0x04d9:
            long r12 = r5.w()
            r14 = 1000(0x3e8, double:4.94E-321)
            r16 = r8
            long r8 = j1.l0.M(r12, r14, r16)
            long r14 = r5.w()
            r12 = r1
            r1 = r18
        L_0x04ec:
            int r6 = r5.f8416c
            int r10 = r5.f8415b
            int r6 = r6 - r10
            byte[] r10 = new byte[r6]
            r16 = r4
            r4 = 0
            r5.d(r10, r4, r6)
            l2.b r4 = new l2.b
            j1.b0 r4 = new j1.b0
            l2.d r5 = r7.f15251k
            java.io.ByteArrayOutputStream r6 = r5.f9532a
            r6.reset()
            java.io.DataOutputStream r5 = r5.f9533b
            r5.writeBytes(r0)     // Catch:{ IOException -> 0x0582 }
            r0 = 0
            r5.writeByte(r0)     // Catch:{ IOException -> 0x0582 }
            r5.writeBytes(r3)     // Catch:{ IOException -> 0x0582 }
            r5.writeByte(r0)     // Catch:{ IOException -> 0x0582 }
            r5.writeLong(r8)     // Catch:{ IOException -> 0x0582 }
            r5.writeLong(r14)     // Catch:{ IOException -> 0x0582 }
            r5.write(r10)     // Catch:{ IOException -> 0x0582 }
            r5.flush()     // Catch:{ IOException -> 0x0582 }
            byte[] r0 = r6.toByteArray()     // Catch:{ IOException -> 0x0582 }
            r4.<init>((byte[]) r0)
            int r0 = r4.f8416c
            int r3 = r4.f8415b
            int r0 = r0 - r3
            d2.x0[] r3 = r7.F
            int r5 = r3.length
            r6 = 0
        L_0x052f:
            if (r6 >= r5) goto L_0x053d
            r8 = r3[r6]
            r9 = 0
            r4.G(r9)
            r8.d(r0, r4)
            int r6 = r6 + 1
            goto L_0x052f
        L_0x053d:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x054d
            u2.k r3 = new u2.k
            r4 = 1
            r3.<init>(r0, r1, r4)
            goto L_0x0559
        L_0x054d:
            boolean r1 = r11.isEmpty()
            if (r1 != 0) goto L_0x0562
            u2.k r3 = new u2.k
            r1 = 0
            r3.<init>(r0, r12, r1)
        L_0x0559:
            r11.addLast(r3)
            int r1 = r7.f15262v
            int r1 = r1 + r0
            r7.f15262v = r1
            goto L_0x0589
        L_0x0562:
            if (r16 == 0) goto L_0x056a
            r1 = r16
            long r12 = r1.a(r12)
        L_0x056a:
            d2.x0[] r1 = r7.F
            int r2 = r1.length
            r3 = 0
        L_0x056e:
            if (r3 >= r2) goto L_0x0589
            r17 = r1[r3]
            r20 = 1
            r22 = 0
            r23 = 0
            r18 = r12
            r21 = r0
            r17.e(r18, r20, r21, r22, r23)
            int r3 = r3 + 1
            goto L_0x056e
        L_0x0582:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        L_0x0589:
            r0 = r27
            goto L_0x0590
        L_0x058c:
            r7 = r1
            r0.g(r2)
        L_0x0590:
            long r1 = r27.p()
            r7.g(r1)
            goto L_0x078c
        L_0x0599:
            r7 = r1
            r1 = 2
            int r2 = r7.f15259s
            j1.b0 r5 = r7.f15252l
            if (r2 != 0) goto L_0x05c1
            byte[] r2 = r5.f8414a
            r6 = 8
            r8 = 1
            r9 = 0
            boolean r2 = r0.b(r2, r9, r6, r8)
            if (r2 != 0) goto L_0x05b0
            r1 = 0
            goto L_0x0788
        L_0x05b0:
            r7.f15259s = r6
            r5.G(r9)
            long r8 = r5.w()
            r7.f15258r = r8
            int r2 = r5.f()
            r7.f15257q = r2
        L_0x05c1:
            long r8 = r7.f15258r
            r10 = 1
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 != 0) goto L_0x05da
            byte[] r2 = r5.f8414a
            r6 = 8
            r0.readFully(r2, r6, r6)
            int r2 = r7.f15259s
            int r2 = r2 + r6
            r7.f15259s = r2
            long r8 = r5.z()
            goto L_0x0605
        L_0x05da:
            r10 = 0
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 != 0) goto L_0x0607
            long r8 = r27.c()
            r10 = -1
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 != 0) goto L_0x05f8
            boolean r2 = r3.isEmpty()
            if (r2 != 0) goto L_0x05f8
            java.lang.Object r2 = r3.peek()
            u2.a r2 = (u2.a) r2
            long r8 = r2.f15196c
        L_0x05f8:
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x0607
            long r10 = r27.p()
            long r8 = r8 - r10
            int r2 = r7.f15259s
            long r10 = (long) r2
            long r8 = r8 + r10
        L_0x0605:
            r7.f15258r = r8
        L_0x0607:
            long r8 = r7.f15258r
            int r2 = r7.f15259s
            long r10 = (long) r2
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 < 0) goto L_0x0796
            long r8 = r27.p()
            int r2 = r7.f15259s
            long r10 = (long) r2
            long r8 = r8 - r10
            int r2 = r7.f15257q
            r6 = 1835295092(0x6d646174, float:4.4175247E27)
            r10 = 1836019558(0x6d6f6f66, float:4.6313494E27)
            if (r2 == r10) goto L_0x0624
            if (r2 != r6) goto L_0x0637
        L_0x0624:
            boolean r2 = r7.H
            if (r2 != 0) goto L_0x0637
            d2.y r2 = r7.E
            d2.e0 r11 = new d2.e0
            long r12 = r7.f15264x
            r11.<init>(r12, r8)
            r2.g(r11)
            r2 = 1
            r7.H = r2
        L_0x0637:
            int r2 = r7.f15257q
            if (r2 != r10) goto L_0x0654
            int r2 = r4.size()
            r11 = 0
        L_0x0640:
            if (r11 >= r2) goto L_0x0654
            java.lang.Object r12 = r4.valueAt(r11)
            u2.l r12 = (u2.l) r12
            u2.w r12 = r12.f15230b
            r12.getClass()
            r12.f15323c = r8
            r12.f15322b = r8
            int r11 = r11 + 1
            goto L_0x0640
        L_0x0654:
            int r2 = r7.f15257q
            if (r2 != r6) goto L_0x0662
            r2 = 0
            r7.f15266z = r2
            long r2 = r7.f15258r
            long r8 = r8 + r2
            r7.f15261u = r8
            goto L_0x0785
        L_0x0662:
            r1 = 0
            r4 = 1836019574(0x6d6f6f76, float:4.631354E27)
            if (r2 == r4) goto L_0x0690
            r4 = 1953653099(0x7472616b, float:7.681346E31)
            if (r2 == r4) goto L_0x0690
            r4 = 1835297121(0x6d646961, float:4.4181236E27)
            if (r2 == r4) goto L_0x0690
            r4 = 1835626086(0x6d696e66, float:4.515217E27)
            if (r2 == r4) goto L_0x0690
            r4 = 1937007212(0x7374626c, float:1.9362132E31)
            if (r2 == r4) goto L_0x0690
            if (r2 == r10) goto L_0x0690
            r4 = 1953653094(0x74726166, float:7.6813435E31)
            if (r2 == r4) goto L_0x0690
            r4 = 1836475768(0x6d766578, float:4.7659988E27)
            if (r2 == r4) goto L_0x0690
            r4 = 1701082227(0x65647473, float:6.742798E22)
            if (r2 != r4) goto L_0x068e
            goto L_0x0690
        L_0x068e:
            r4 = 0
            goto L_0x0691
        L_0x0690:
            r4 = 1
        L_0x0691:
            if (r4 == 0) goto L_0x06bc
            long r1 = r27.p()
            long r4 = r7.f15258r
            long r1 = r1 + r4
            r4 = 8
            long r1 = r1 - r4
            u2.a r4 = new u2.a
            int r5 = r7.f15257q
            r4.<init>(r5, r1)
            r3.push(r4)
            long r3 = r7.f15258r
            int r5 = r7.f15259s
            long r5 = (long) r5
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 != 0) goto L_0x06b5
            r7.g(r1)
            goto L_0x0787
        L_0x06b5:
            r1 = 0
            r7.f15256p = r1
            r7.f15259s = r1
            goto L_0x0787
        L_0x06bc:
            r3 = 1751411826(0x68646c72, float:4.3148E24)
            if (r2 == r3) goto L_0x074b
            r3 = 1835296868(0x6d646864, float:4.418049E27)
            if (r2 == r3) goto L_0x074b
            r3 = 1836476516(0x6d766864, float:4.7662196E27)
            if (r2 == r3) goto L_0x074b
            r3 = 1936286840(0x73696478, float:1.8491255E31)
            if (r2 == r3) goto L_0x074b
            r3 = 1937011556(0x73747364, float:1.9367383E31)
            if (r2 == r3) goto L_0x074b
            r3 = 1937011827(0x73747473, float:1.9367711E31)
            if (r2 == r3) goto L_0x074b
            r3 = 1668576371(0x63747473, float:4.5093966E21)
            if (r2 == r3) goto L_0x074b
            r3 = 1937011555(0x73747363, float:1.9367382E31)
            if (r2 == r3) goto L_0x074b
            r3 = 1937011578(0x7374737a, float:1.936741E31)
            if (r2 == r3) goto L_0x074b
            r3 = 1937013298(0x73747a32, float:1.9369489E31)
            if (r2 == r3) goto L_0x074b
            r3 = 1937007471(0x7374636f, float:1.9362445E31)
            if (r2 == r3) goto L_0x074b
            r3 = 1668232756(0x636f3634, float:4.4126776E21)
            if (r2 == r3) goto L_0x074b
            r3 = 1937011571(0x73747373, float:1.9367401E31)
            if (r2 == r3) goto L_0x074b
            r3 = 1952867444(0x74666474, float:7.3014264E31)
            if (r2 == r3) goto L_0x074b
            r3 = 1952868452(0x74666864, float:7.301914E31)
            if (r2 == r3) goto L_0x074b
            r3 = 1953196132(0x746b6864, float:7.46037E31)
            if (r2 == r3) goto L_0x074b
            r3 = 1953654136(0x74726578, float:7.6818474E31)
            if (r2 == r3) goto L_0x074b
            r3 = 1953658222(0x7472756e, float:7.683823E31)
            if (r2 == r3) goto L_0x074b
            r3 = 1886614376(0x70737368, float:3.013775E29)
            if (r2 == r3) goto L_0x074b
            r3 = 1935763834(0x7361697a, float:1.785898E31)
            if (r2 == r3) goto L_0x074b
            r3 = 1935763823(0x7361696f, float:1.7858967E31)
            if (r2 == r3) goto L_0x074b
            r3 = 1936027235(0x73656e63, float:1.8177412E31)
            if (r2 == r3) goto L_0x074b
            r3 = 1970628964(0x75756964, float:3.1109627E32)
            if (r2 == r3) goto L_0x074b
            r3 = 1935828848(0x73626770, float:1.7937577E31)
            if (r2 == r3) goto L_0x074b
            r3 = 1936158820(0x73677064, float:1.8336489E31)
            if (r2 == r3) goto L_0x074b
            r3 = 1701606260(0x656c7374, float:6.9788014E22)
            if (r2 == r3) goto L_0x074b
            r3 = 1835362404(0x6d656864, float:4.4373917E27)
            if (r2 == r3) goto L_0x074b
            r3 = 1701671783(0x656d7367, float:7.0083103E22)
            if (r2 != r3) goto L_0x0749
            goto L_0x074b
        L_0x0749:
            r2 = 0
            goto L_0x074c
        L_0x074b:
            r2 = 1
        L_0x074c:
            r3 = 2147483647(0x7fffffff, double:1.060997895E-314)
            if (r2 == 0) goto L_0x077c
            int r1 = r7.f15259s
            r2 = 8
            if (r1 != r2) goto L_0x0775
            long r8 = r7.f15258r
            int r1 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x076e
            j1.b0 r1 = new j1.b0
            long r3 = r7.f15258r
            int r4 = (int) r3
            r1.<init>((int) r4)
            byte[] r3 = r5.f8414a
            byte[] r4 = r1.f8414a
            r5 = 0
            java.lang.System.arraycopy(r3, r5, r4, r5, r2)
            goto L_0x0782
        L_0x076e:
            java.lang.String r0 = "Leaf atom with length > 2147483647 (unsupported)."
            g1.b1 r0 = g1.b1.c(r0)
            throw r0
        L_0x0775:
            java.lang.String r0 = "Leaf atom defines extended atom size (unsupported)."
            g1.b1 r0 = g1.b1.c(r0)
            throw r0
        L_0x077c:
            long r5 = r7.f15258r
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x078f
        L_0x0782:
            r7.f15260t = r1
            r1 = 1
        L_0x0785:
            r7.f15256p = r1
        L_0x0787:
            r1 = 1
        L_0x0788:
            if (r1 != 0) goto L_0x078c
            r0 = -1
            return r0
        L_0x078c:
            r1 = r7
            goto L_0x0004
        L_0x078f:
            java.lang.String r0 = "Skipping atom with length > 2147483647 (unsupported)."
            g1.b1 r0 = g1.b1.c(r0)
            throw r0
        L_0x0796:
            java.lang.String r0 = "Atom size less than header length (unsupported)."
            g1.b1 r0 = g1.b1.c(r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.m.d(d2.w, d2.s0):int");
    }

    public final void e(y yVar) {
        int i10;
        this.E = yVar;
        this.f15256p = 0;
        this.f15259s = 0;
        x0[] x0VarArr = new x0[2];
        this.F = x0VarArr;
        x0 x0Var = this.f15255o;
        if (x0Var != null) {
            x0VarArr[0] = x0Var;
            i10 = 1;
        } else {
            i10 = 0;
        }
        int i11 = 100;
        if ((this.f15241a & 4) != 0) {
            x0VarArr[i10] = yVar.d(100, 5);
            i11 = 101;
            i10++;
        }
        x0[] x0VarArr2 = (x0[]) l0.J(i10, this.F);
        this.F = x0VarArr2;
        for (x0 a10 : x0VarArr2) {
            a10.a(J);
        }
        List list = this.f15243c;
        this.G = new x0[list.size()];
        int i12 = 0;
        while (i12 < this.G.length) {
            x0 d10 = this.E.d(i11, 3);
            d10.a((a0) list.get(i12));
            this.G[i12] = d10;
            i12++;
            i11++;
        }
        u uVar = this.f15242b;
        if (uVar != null) {
            this.f15244d.put(0, new l(yVar.d(0, uVar.f15306b), new x(this.f15242b, new long[0], new int[0], 0, new long[0], new int[0], 0), new i(0, 0, 0, 0)));
            this.E.a();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:155:0x03a1, code lost:
        if (j1.l0.M(r31 + r5[0], 1000000, r13.f15308d) >= r13.f15309e) goto L_0x03a3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x03af  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x03c1  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x03c3  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x03d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(long r47) {
        /*
            r46 = this;
            r0 = r46
            r1 = r0
        L_0x0003:
            java.util.ArrayDeque r2 = r0.f15253m
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x07cc
            java.lang.Object r3 = r2.peek()
            u2.a r3 = (u2.a) r3
            long r3 = r3.f15196c
            int r5 = (r3 > r47 ? 1 : (r3 == r47 ? 0 : -1))
            if (r5 != 0) goto L_0x07cc
            java.lang.Object r3 = r2.pop()
            r4 = r3
            u2.a r4 = (u2.a) r4
            int r3 = r4.f15201b
            android.util.SparseArray r12 = r0.f15244d
            java.util.ArrayList r5 = r4.f15197d
            r6 = 12
            r7 = 1836019574(0x6d6f6f76, float:4.631354E27)
            u2.u r8 = r0.f15242b
            if (r3 != r7) goto L_0x0188
            if (r8 != 0) goto L_0x0031
            r2 = 1
            goto L_0x0032
        L_0x0031:
            r2 = 0
        L_0x0032:
            if (r2 == 0) goto L_0x0180
            g1.u r8 = b(r5)
            r2 = 1836475768(0x6d766578, float:4.7659988E27)
            u2.a r2 = r4.i(r2)
            r2.getClass()
            android.util.SparseArray r3 = new android.util.SparseArray
            r3.<init>()
            java.util.ArrayList r2 = r2.f15197d
            int r5 = r2.size()
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = 0
        L_0x0053:
            if (r7 >= r5) goto L_0x00c2
            java.lang.Object r11 = r2.get(r7)
            u2.b r11 = (u2.b) r11
            int r13 = r11.f15201b
            r14 = 1953654136(0x74726578, float:7.6818474E31)
            j1.b0 r11 = r11.f15199c
            if (r13 != r14) goto L_0x009c
            r11.G(r6)
            int r6 = r11.f()
            int r13 = r11.f()
            int r13 = r13 + -1
            int r14 = r11.f()
            int r15 = r11.f()
            int r11 = r11.f()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r16 = r2
            u2.i r2 = new u2.i
            r2.<init>(r13, r14, r15, r11)
            android.util.Pair r2 = android.util.Pair.create(r6, r2)
            java.lang.Object r6 = r2.first
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.lang.Object r2 = r2.second
            u2.i r2 = (u2.i) r2
            r3.put(r6, r2)
            goto L_0x00bb
        L_0x009c:
            r16 = r2
            r2 = 1835362404(0x6d656864, float:4.4373917E27)
            if (r13 != r2) goto L_0x00bb
            r2 = 8
            r11.G(r2)
            int r2 = r11.f()
            int r2 = r2 >> 24
            r2 = r2 & 255(0xff, float:3.57E-43)
            if (r2 != 0) goto L_0x00b7
            long r9 = r11.w()
            goto L_0x00bb
        L_0x00b7:
            long r9 = r11.z()
        L_0x00bb:
            int r7 = r7 + 1
            r6 = 12
            r2 = r16
            goto L_0x0053
        L_0x00c2:
            d2.g0 r5 = new d2.g0
            r5.<init>()
            int r2 = r0.f15241a
            r2 = r2 & 16
            if (r2 == 0) goto L_0x00cf
            r2 = 1
            goto L_0x00d0
        L_0x00cf:
            r2 = 0
        L_0x00d0:
            r11 = 0
            u2.j r13 = new u2.j
            r13.<init>(r0)
            r6 = r9
            r9 = r2
            r10 = r11
            r11 = r13
            java.util.ArrayList r2 = u2.h.e(r4, r5, r6, r8, r9, r10, r11)
            int r4 = r2.size()
            int r5 = r12.size()
            if (r5 != 0) goto L_0x0130
            r5 = 0
        L_0x00e9:
            if (r5 >= r4) goto L_0x012a
            java.lang.Object r6 = r2.get(r5)
            u2.x r6 = (u2.x) r6
            u2.u r7 = r6.f15338a
            u2.l r8 = new u2.l
            d2.y r9 = r0.E
            int r10 = r7.f15306b
            d2.x0 r9 = r9.d(r5, r10)
            int r10 = r3.size()
            int r11 = r7.f15305a
            r13 = 1
            if (r10 != r13) goto L_0x010e
            r10 = 0
            java.lang.Object r10 = r3.valueAt(r10)
            u2.i r10 = (u2.i) r10
            goto L_0x0117
        L_0x010e:
            java.lang.Object r10 = r3.get(r11)
            u2.i r10 = (u2.i) r10
            r10.getClass()
        L_0x0117:
            r8.<init>(r9, r6, r10)
            r12.put(r11, r8)
            long r8 = r0.f15264x
            long r6 = r7.f15309e
            long r6 = java.lang.Math.max(r8, r6)
            r0.f15264x = r6
            int r5 = r5 + 1
            goto L_0x00e9
        L_0x012a:
            d2.y r2 = r0.E
            r2.a()
            goto L_0x017c
        L_0x0130:
            int r5 = r12.size()
            if (r5 != r4) goto L_0x0138
            r5 = 1
            goto L_0x0139
        L_0x0138:
            r5 = 0
        L_0x0139:
            j1.a.e(r5)
            r5 = 0
        L_0x013d:
            if (r5 >= r4) goto L_0x017c
            java.lang.Object r6 = r2.get(r5)
            u2.x r6 = (u2.x) r6
            u2.u r7 = r6.f15338a
            int r8 = r7.f15305a
            java.lang.Object r8 = r12.get(r8)
            u2.l r8 = (u2.l) r8
            int r9 = r3.size()
            r10 = 1
            if (r9 != r10) goto L_0x015e
            r7 = 0
            java.lang.Object r7 = r3.valueAt(r7)
            u2.i r7 = (u2.i) r7
            goto L_0x0169
        L_0x015e:
            int r7 = r7.f15305a
            java.lang.Object r7 = r3.get(r7)
            u2.i r7 = (u2.i) r7
            r7.getClass()
        L_0x0169:
            r8.f15232d = r6
            r8.f15233e = r7
            u2.u r6 = r6.f15338a
            g1.a0 r6 = r6.f15310f
            d2.x0 r7 = r8.f15229a
            r7.a(r6)
            r8.d()
            int r5 = r5 + 1
            goto L_0x013d
        L_0x017c:
            r5 = r46
            goto L_0x0003
        L_0x0180:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Unexpected moov box."
            r0.<init>(r1)
            throw r0
        L_0x0188:
            r6 = 1836019558(0x6d6f6f66, float:4.6313494E27)
            if (r3 != r6) goto L_0x07b7
            if (r8 == 0) goto L_0x0191
            r2 = 1
            goto L_0x0192
        L_0x0191:
            r2 = 0
        L_0x0192:
            java.util.ArrayList r3 = r4.f15198e
            int r4 = r3.size()
            r6 = 0
            r6 = r1
            r7 = 0
            r1 = r0
        L_0x019c:
            if (r7 >= r4) goto L_0x0716
            java.lang.Object r8 = r3.get(r7)
            u2.a r8 = (u2.a) r8
            int r9 = r8.f15201b
            r10 = 1953653094(0x74726166, float:7.6813435E31)
            if (r9 != r10) goto L_0x06f6
            r9 = 1952868452(0x74666864, float:7.301914E31)
            u2.b r9 = r8.j(r9)
            r9.getClass()
            j1.b0 r9 = r9.f15199c
            r10 = 8
            r9.G(r10)
            int r10 = r9.f()
            r11 = 16777215(0xffffff, float:2.3509886E-38)
            r10 = r10 & r11
            int r11 = r9.f()
            if (r2 == 0) goto L_0x01d0
            r11 = 0
            java.lang.Object r11 = r12.valueAt(r11)
            goto L_0x01d4
        L_0x01d0:
            java.lang.Object r11 = r12.get(r11)
        L_0x01d4:
            u2.l r11 = (u2.l) r11
            if (r11 != 0) goto L_0x01e0
            r11 = 0
            r16 = r0
            r13 = r2
            r15 = r3
            r17 = r4
            goto L_0x023a
        L_0x01e0:
            r13 = r10 & 1
            u2.w r14 = r11.f15230b
            if (r13 == 0) goto L_0x01f1
            r13 = r2
            r15 = r3
            long r2 = r9.z()
            r14.f15322b = r2
            r14.f15323c = r2
            goto L_0x01f3
        L_0x01f1:
            r13 = r2
            r15 = r3
        L_0x01f3:
            u2.i r2 = r11.f15233e
            r3 = r10 & 2
            if (r3 == 0) goto L_0x0200
            int r3 = r9.f()
            int r3 = r3 + -1
            goto L_0x0202
        L_0x0200:
            int r3 = r2.f15221a
        L_0x0202:
            r16 = r10 & 8
            if (r16 == 0) goto L_0x0211
            int r16 = r9.f()
            r45 = r16
            r16 = r0
            r0 = r45
            goto L_0x0215
        L_0x0211:
            r16 = r0
            int r0 = r2.f15222b
        L_0x0215:
            r17 = r10 & 16
            if (r17 == 0) goto L_0x0224
            int r17 = r9.f()
            r45 = r17
            r17 = r4
            r4 = r45
            goto L_0x0228
        L_0x0224:
            r17 = r4
            int r4 = r2.f15223c
        L_0x0228:
            r10 = r10 & 32
            if (r10 == 0) goto L_0x0231
            int r2 = r9.f()
            goto L_0x0233
        L_0x0231:
            int r2 = r2.f15224d
        L_0x0233:
            u2.i r9 = new u2.i
            r9.<init>(r3, r0, r4, r2)
            r14.f15321a = r9
        L_0x023a:
            if (r11 != 0) goto L_0x0248
            r26 = r5
            r23 = r7
            r25 = r12
            r18 = r13
            r22 = r15
            goto L_0x0704
        L_0x0248:
            u2.w r0 = r11.f15230b
            long r2 = r0.f15336p
            boolean r4 = r0.f15337q
            r11.d()
            r6 = 1
            r11.f15240l = r6
            r6 = 1952867444(0x74666474, float:7.3014264E31)
            u2.b r6 = r8.j(r6)
            int r1 = r1.f15241a
            if (r6 == 0) goto L_0x027f
            r9 = r1 & 2
            if (r9 != 0) goto L_0x027f
            j1.b0 r2 = r6.f15199c
            r3 = 8
            r2.G(r3)
            int r3 = r2.f()
            int r3 = r3 >> 24
            r3 = r3 & 255(0xff, float:3.57E-43)
            r4 = 1
            if (r3 != r4) goto L_0x027a
            long r2 = r2.z()
            goto L_0x027e
        L_0x027a:
            long r2 = r2.w()
        L_0x027e:
            r4 = 1
        L_0x027f:
            r0.f15336p = r2
            r0.f15337q = r4
            java.util.ArrayList r2 = r8.f15197d
            int r3 = r2.size()
            r4 = 0
            r6 = 0
            r9 = 0
        L_0x028c:
            r10 = 1953658222(0x7472756e, float:7.683823E31)
            if (r4 >= r3) goto L_0x02b2
            java.lang.Object r14 = r2.get(r4)
            u2.b r14 = (u2.b) r14
            r18 = r13
            int r13 = r14.f15201b
            if (r13 != r10) goto L_0x02ad
            j1.b0 r10 = r14.f15199c
            r13 = 12
            r10.G(r13)
            int r10 = r10.y()
            if (r10 <= 0) goto L_0x02ad
            int r9 = r9 + r10
            int r6 = r6 + 1
        L_0x02ad:
            int r4 = r4 + 1
            r13 = r18
            goto L_0x028c
        L_0x02b2:
            r18 = r13
            r4 = 0
            r11.f15236h = r4
            r11.f15235g = r4
            r11.f15234f = r4
            r0.f15324d = r6
            r0.f15325e = r9
            int[] r4 = r0.f15327g
            int r4 = r4.length
            if (r4 >= r6) goto L_0x02cc
            long[] r4 = new long[r6]
            r0.f15326f = r4
            int[] r4 = new int[r6]
            r0.f15327g = r4
        L_0x02cc:
            int[] r4 = r0.f15328h
            int r4 = r4.length
            if (r4 >= r9) goto L_0x02e5
            int r9 = r9 * 125
            int r9 = r9 / 100
            int[] r4 = new int[r9]
            r0.f15328h = r4
            long[] r4 = new long[r9]
            r0.f15329i = r4
            boolean[] r4 = new boolean[r9]
            r0.f15330j = r4
            boolean[] r4 = new boolean[r9]
            r0.f15332l = r4
        L_0x02e5:
            r4 = 0
            r6 = 0
            r9 = 0
            r13 = r11
        L_0x02e9:
            r19 = 0
            if (r4 >= r3) goto L_0x04ce
            java.lang.Object r14 = r2.get(r4)
            u2.b r14 = (u2.b) r14
            r16 = r3
            int r3 = r14.f15201b
            if (r3 != r10) goto L_0x04a4
            int r3 = r9 + 1
            j1.b0 r10 = r14.f15199c
            r14 = 8
            r10.G(r14)
            int r14 = r10.f()
            r21 = 16777215(0xffffff, float:2.3509886E-38)
            r14 = r14 & r21
            u2.x r13 = r13.f15232d
            u2.u r13 = r13.f15338a
            r21 = r3
            u2.i r3 = r0.f15321a
            int r22 = j1.l0.f8453a
            r22 = r15
            int[] r15 = r0.f15327g
            int r23 = r10.y()
            r15[r9] = r23
            long[] r15 = r0.f15326f
            r23 = r7
            r24 = r8
            long r7 = r0.f15322b
            r15[r9] = r7
            r25 = r14 & 1
            if (r25 == 0) goto L_0x033c
            r25 = r12
            int r12 = r10.f()
            r27 = r4
            r26 = r5
            long r4 = (long) r12
            long r7 = r7 + r4
            r15[r9] = r7
            goto L_0x0342
        L_0x033c:
            r27 = r4
            r26 = r5
            r25 = r12
        L_0x0342:
            r4 = r14 & 4
            if (r4 == 0) goto L_0x0348
            r4 = 1
            goto L_0x0349
        L_0x0348:
            r4 = 0
        L_0x0349:
            int r5 = r3.f15224d
            if (r4 == 0) goto L_0x0351
            int r5 = r10.f()
        L_0x0351:
            r7 = r14 & 256(0x100, float:3.59E-43)
            if (r7 == 0) goto L_0x0357
            r7 = 1
            goto L_0x0358
        L_0x0357:
            r7 = 0
        L_0x0358:
            r8 = r14 & 512(0x200, float:7.175E-43)
            if (r8 == 0) goto L_0x035e
            r8 = 1
            goto L_0x035f
        L_0x035e:
            r8 = 0
        L_0x035f:
            r12 = r14 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0365
            r12 = 1
            goto L_0x0366
        L_0x0365:
            r12 = 0
        L_0x0366:
            r14 = r14 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x036c
            r14 = 1
            goto L_0x036d
        L_0x036c:
            r14 = 0
        L_0x036d:
            long[] r15 = r13.f15312h
            r28 = r5
            long[] r5 = r13.f15313i
            r29 = r2
            if (r15 == 0) goto L_0x03a9
            int r2 = r15.length
            r30 = r11
            r11 = 1
            if (r2 != r11) goto L_0x03a5
            if (r5 != 0) goto L_0x0380
            goto L_0x03a5
        L_0x0380:
            r2 = 0
            r31 = r15[r2]
            int r11 = (r31 > r19 ? 1 : (r31 == r19 ? 0 : -1))
            if (r11 != 0) goto L_0x038b
            r31 = r12
            r2 = r14
            goto L_0x03a3
        L_0x038b:
            r33 = r5[r2]
            long r35 = r31 + r33
            r37 = 1000000(0xf4240, double:4.940656E-318)
            r2 = r14
            long r14 = r13.f15308d
            r39 = r14
            long r14 = j1.l0.M(r35, r37, r39)
            r31 = r12
            long r11 = r13.f15309e
            int r32 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r32 < 0) goto L_0x03ac
        L_0x03a3:
            r11 = 1
            goto L_0x03ad
        L_0x03a5:
            r31 = r12
            r2 = r14
            goto L_0x03ac
        L_0x03a9:
            r30 = r11
            goto L_0x03a5
        L_0x03ac:
            r11 = 0
        L_0x03ad:
            if (r11 == 0) goto L_0x03b2
            r11 = 0
            r19 = r5[r11]
        L_0x03b2:
            int[] r5 = r0.f15328h
            long[] r11 = r0.f15329i
            boolean[] r12 = r0.f15330j
            int r14 = r13.f15306b
            r15 = 2
            if (r14 != r15) goto L_0x03c3
            r14 = r1 & 1
            if (r14 == 0) goto L_0x03c3
            r14 = 1
            goto L_0x03c4
        L_0x03c3:
            r14 = 0
        L_0x03c4:
            int[] r15 = r0.f15327g
            r9 = r15[r9]
            int r9 = r9 + r6
            r15 = r12
            long r12 = r13.f15307c
            r38 = r14
            r39 = r15
            long r14 = r0.f15336p
        L_0x03d2:
            if (r6 >= r9) goto L_0x0496
            if (r7 == 0) goto L_0x03e1
            int r32 = r10.f()
            r40 = r1
            r41 = r7
            r1 = r32
            goto L_0x03e7
        L_0x03e1:
            r40 = r1
            int r1 = r3.f15222b
            r41 = r7
        L_0x03e7:
            java.lang.String r7 = "Unexpected negative value: "
            if (r1 < 0) goto L_0x0484
            if (r8 == 0) goto L_0x03f6
            int r32 = r10.f()
            r42 = r8
            r8 = r32
            goto L_0x03fa
        L_0x03f6:
            r42 = r8
            int r8 = r3.f15223c
        L_0x03fa:
            if (r8 < 0) goto L_0x0472
            if (r31 == 0) goto L_0x0403
            int r7 = r10.f()
            goto L_0x040c
        L_0x0403:
            if (r6 != 0) goto L_0x040a
            if (r4 == 0) goto L_0x040a
            r7 = r28
            goto L_0x040c
        L_0x040a:
            int r7 = r3.f15224d
        L_0x040c:
            if (r2 == 0) goto L_0x0419
            int r32 = r10.f()
            r43 = r2
            r44 = r3
            r2 = r32
            goto L_0x0420
        L_0x0419:
            r32 = 0
            r43 = r2
            r44 = r3
            r2 = 0
        L_0x0420:
            long r2 = (long) r2
            long r2 = r2 + r14
            long r32 = r2 - r19
            r34 = 1000000(0xf4240, double:4.940656E-318)
            r36 = r12
            long r2 = j1.l0.M(r32, r34, r36)
            r11[r6] = r2
            r32 = r4
            boolean r4 = r0.f15337q
            if (r4 != 0) goto L_0x0443
            r4 = r30
            r30 = r9
            u2.x r9 = r4.f15232d
            r33 = r10
            long r9 = r9.f15345h
            long r2 = r2 + r9
            r11[r6] = r2
            goto L_0x0449
        L_0x0443:
            r33 = r10
            r4 = r30
            r30 = r9
        L_0x0449:
            r5[r6] = r8
            int r2 = r7 >> 16
            r2 = r2 & 1
            if (r2 != 0) goto L_0x0457
            if (r38 == 0) goto L_0x0455
            if (r6 != 0) goto L_0x0457
        L_0x0455:
            r2 = 1
            goto L_0x0458
        L_0x0457:
            r2 = 0
        L_0x0458:
            r39[r6] = r2
            long r1 = (long) r1
            long r14 = r14 + r1
            int r6 = r6 + 1
            r9 = r30
            r10 = r33
            r1 = r40
            r7 = r41
            r8 = r42
            r2 = r43
            r3 = r44
            r30 = r4
            r4 = r32
            goto L_0x03d2
        L_0x0472:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r7)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            r1 = 0
            g1.b1 r0 = g1.b1.a(r0, r1)
            throw r0
        L_0x0484:
            r0 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r7)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            g1.b1 r0 = g1.b1.a(r1, r0)
            throw r0
        L_0x0496:
            r40 = r1
            r4 = r30
            r30 = r9
            r0.f15336p = r14
            r13 = r4
            r9 = r21
            r6 = r30
            goto L_0x04b5
        L_0x04a4:
            r40 = r1
            r29 = r2
            r27 = r4
            r26 = r5
            r23 = r7
            r24 = r8
            r4 = r11
            r25 = r12
            r22 = r15
        L_0x04b5:
            int r1 = r27 + 1
            r10 = 1953658222(0x7472756e, float:7.683823E31)
            r11 = r4
            r3 = r16
            r15 = r22
            r7 = r23
            r8 = r24
            r12 = r25
            r5 = r26
            r2 = r29
            r4 = r1
            r1 = r40
            goto L_0x02e9
        L_0x04ce:
            r29 = r2
            r26 = r5
            r23 = r7
            r24 = r8
            r4 = r11
            r25 = r12
            r22 = r15
            u2.x r1 = r4.f15232d
            u2.u r1 = r1.f15338a
            u2.i r2 = r0.f15321a
            r2.getClass()
            u2.v[] r1 = r1.f15315k
            if (r1 != 0) goto L_0x04ea
            r1 = 0
            goto L_0x04ee
        L_0x04ea:
            int r2 = r2.f15221a
            r1 = r1[r2]
        L_0x04ee:
            r2 = 1935763834(0x7361697a, float:1.785898E31)
            r8 = r24
            u2.b r2 = r8.j(r2)
            if (r2 == 0) goto L_0x0572
            r1.getClass()
            j1.b0 r2 = r2.f15199c
            r3 = 8
            r2.G(r3)
            int r4 = r2.f()
            r5 = 16777215(0xffffff, float:2.3509886E-38)
            r4 = r4 & r5
            r5 = 1
            r4 = r4 & r5
            if (r4 != r5) goto L_0x0512
            r2.H(r3)
        L_0x0512:
            int r3 = r2.v()
            int r4 = r2.y()
            int r5 = r0.f15325e
            if (r4 > r5) goto L_0x055b
            int r5 = r1.f15319d
            if (r3 != 0) goto L_0x0537
            boolean[] r3 = r0.f15332l
            r6 = 0
            r7 = 0
        L_0x0526:
            if (r6 >= r4) goto L_0x0546
            int r9 = r2.v()
            int r7 = r7 + r9
            if (r9 <= r5) goto L_0x0531
            r9 = 1
            goto L_0x0532
        L_0x0531:
            r9 = 0
        L_0x0532:
            r3[r6] = r9
            int r6 = r6 + 1
            goto L_0x0526
        L_0x0537:
            if (r3 <= r5) goto L_0x053b
            r2 = 1
            goto L_0x053c
        L_0x053b:
            r2 = 0
        L_0x053c:
            int r3 = r3 * r4
            r5 = 0
            int r7 = r3 + 0
            boolean[] r3 = r0.f15332l
            java.util.Arrays.fill(r3, r5, r4, r2)
        L_0x0546:
            r2 = 0
            boolean[] r3 = r0.f15332l
            int r5 = r0.f15325e
            java.util.Arrays.fill(r3, r4, r5, r2)
            if (r7 <= 0) goto L_0x0572
            j1.b0 r2 = r0.f15334n
            r2.D(r7)
            r2 = 1
            r0.f15331k = r2
            r0.f15335o = r2
            goto L_0x0572
        L_0x055b:
            java.lang.String r1 = "Saiz sample count "
            java.lang.String r2 = " is greater than fragment sample count"
            java.lang.StringBuilder r1 = android.support.v4.media.h.r(r1, r4, r2)
            int r0 = r0.f15325e
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 0
            g1.b1 r0 = g1.b1.a(r0, r1)
            throw r0
        L_0x0572:
            r2 = 1935763823(0x7361696f, float:1.7858967E31)
            u2.b r2 = r8.j(r2)
            if (r2 == 0) goto L_0x05c0
            j1.b0 r2 = r2.f15199c
            r3 = 8
            r2.G(r3)
            int r4 = r2.f()
            r5 = 16777215(0xffffff, float:2.3509886E-38)
            r5 = r5 & r4
            r6 = 1
            r5 = r5 & r6
            if (r5 != r6) goto L_0x0591
            r2.H(r3)
        L_0x0591:
            int r3 = r2.y()
            if (r3 != r6) goto L_0x05ac
            int r3 = r4 >> 24
            r3 = r3 & 255(0xff, float:3.57E-43)
            long r4 = r0.f15323c
            if (r3 != 0) goto L_0x05a4
            long r2 = r2.w()
            goto L_0x05a8
        L_0x05a4:
            long r2 = r2.z()
        L_0x05a8:
            long r4 = r4 + r2
            r0.f15323c = r4
            goto L_0x05c0
        L_0x05ac:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unexpected saio entry count: "
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r1 = 0
            g1.b1 r0 = g1.b1.a(r0, r1)
            throw r0
        L_0x05c0:
            r2 = 0
            r3 = 1936027235(0x73656e63, float:1.8177412E31)
            u2.b r3 = r8.j(r3)
            if (r3 == 0) goto L_0x05d0
            j1.b0 r3 = r3.f15199c
            r4 = 0
            f(r3, r4, r0)
        L_0x05d0:
            if (r1 == 0) goto L_0x05d6
            java.lang.String r1 = r1.f15317b
            r5 = r1
            goto L_0x05d7
        L_0x05d6:
            r5 = r2
        L_0x05d7:
            r1 = 0
            r3 = r2
            r4 = r3
        L_0x05da:
            int r6 = r29.size()
            r11 = r29
            if (r1 >= r6) goto L_0x0615
            java.lang.Object r6 = r11.get(r1)
            u2.b r6 = (u2.b) r6
            j1.b0 r7 = r6.f15199c
            r8 = 1935828848(0x73626770, float:1.7937577E31)
            r9 = 1936025959(0x73656967, float:1.817587E31)
            int r6 = r6.f15201b
            r10 = 12
            if (r6 != r8) goto L_0x0601
            r7.G(r10)
            int r6 = r7.f()
            if (r6 != r9) goto L_0x0610
            r3 = r7
            goto L_0x0610
        L_0x0601:
            r8 = 1936158820(0x73677064, float:1.8336489E31)
            if (r6 != r8) goto L_0x0610
            r7.G(r10)
            int r6 = r7.f()
            if (r6 != r9) goto L_0x0610
            r4 = r7
        L_0x0610:
            int r1 = r1 + 1
            r29 = r11
            goto L_0x05da
        L_0x0615:
            if (r3 == 0) goto L_0x06b9
            if (r4 != 0) goto L_0x061b
            goto L_0x06b9
        L_0x061b:
            r1 = 8
            r3.G(r1)
            int r1 = r3.f()
            int r1 = r1 >> 24
            r1 = r1 & 255(0xff, float:3.57E-43)
            r6 = 4
            r3.H(r6)
            r7 = 1
            if (r1 != r7) goto L_0x0632
            r3.H(r6)
        L_0x0632:
            int r1 = r3.f()
            if (r1 != r7) goto L_0x06b2
            r1 = 8
            r4.G(r1)
            int r1 = r4.f()
            int r1 = r1 >> 24
            r1 = r1 & 255(0xff, float:3.57E-43)
            r4.H(r6)
            if (r1 != r7) goto L_0x065a
            long r6 = r4.w()
            int r1 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r1 == 0) goto L_0x0653
            goto L_0x0660
        L_0x0653:
            java.lang.String r0 = "Variable length description in sgpd found (unsupported)"
            g1.b1 r0 = g1.b1.c(r0)
            throw r0
        L_0x065a:
            r3 = 2
            if (r1 < r3) goto L_0x0660
            r4.H(r6)
        L_0x0660:
            long r6 = r4.w()
            r8 = 1
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 != 0) goto L_0x06ab
            r1 = 1
            r4.H(r1)
            int r3 = r4.v()
            r6 = r3 & 240(0xf0, float:3.36E-43)
            int r8 = r6 >> 4
            r9 = r3 & 15
            int r3 = r4.v()
            if (r3 != r1) goto L_0x0680
            r1 = 1
            goto L_0x0681
        L_0x0680:
            r1 = 0
        L_0x0681:
            if (r1 != 0) goto L_0x0684
            goto L_0x06b9
        L_0x0684:
            int r6 = r4.v()
            r3 = 16
            byte[] r7 = new byte[r3]
            r10 = 0
            r4.d(r7, r10, r3)
            if (r6 != 0) goto L_0x069d
            int r2 = r4.v()
            byte[] r3 = new byte[r2]
            r4.d(r3, r10, r2)
            r10 = r3
            goto L_0x069e
        L_0x069d:
            r10 = r2
        L_0x069e:
            r2 = 1
            r0.f15331k = r2
            u2.v r2 = new u2.v
            r3 = r2
            r4 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            r0.f15333m = r2
            goto L_0x06b9
        L_0x06ab:
            java.lang.String r0 = "Entry count in sgpd != 1 (unsupported)."
            g1.b1 r0 = g1.b1.c(r0)
            throw r0
        L_0x06b2:
            java.lang.String r0 = "Entry count in sbgp != 1 (unsupported)."
            g1.b1 r0 = g1.b1.c(r0)
            throw r0
        L_0x06b9:
            int r1 = r11.size()
            r2 = 0
        L_0x06be:
            if (r2 >= r1) goto L_0x06f0
            java.lang.Object r3 = r11.get(r2)
            u2.b r3 = (u2.b) r3
            int r4 = r3.f15201b
            r5 = 1970628964(0x75756964, float:3.1109627E32)
            if (r4 != r5) goto L_0x06eb
            j1.b0 r3 = r3.f15199c
            r4 = 8
            r3.G(r4)
            r5 = r46
            byte[] r4 = r5.f15248h
            r6 = 16
            r7 = 0
            r3.d(r4, r7, r6)
            byte[] r7 = I
            boolean r4 = java.util.Arrays.equals(r4, r7)
            if (r4 != 0) goto L_0x06e7
            goto L_0x06ed
        L_0x06e7:
            f(r3, r6, r0)
            goto L_0x06ed
        L_0x06eb:
            r5 = r46
        L_0x06ed:
            int r2 = r2 + 1
            goto L_0x06be
        L_0x06f0:
            r5 = r46
            r0 = r5
            r1 = r0
            r6 = r1
            goto L_0x0708
        L_0x06f6:
            r16 = r0
            r18 = r2
            r22 = r3
            r17 = r4
            r26 = r5
            r23 = r7
            r25 = r12
        L_0x0704:
            r5 = r46
            r0 = r16
        L_0x0708:
            int r7 = r23 + 1
            r4 = r17
            r2 = r18
            r3 = r22
            r12 = r25
            r5 = r26
            goto L_0x019c
        L_0x0716:
            r16 = r0
            r26 = r5
            r25 = r12
            r5 = r46
            r0 = 0
            g1.u r2 = b(r26)
            if (r2 == 0) goto L_0x0771
            int r3 = r25.size()
            r4 = 0
        L_0x072a:
            if (r4 >= r3) goto L_0x0771
            r7 = r25
            java.lang.Object r8 = r7.valueAt(r4)
            u2.l r8 = (u2.l) r8
            u2.x r9 = r8.f15232d
            u2.u r9 = r9.f15338a
            u2.w r10 = r8.f15230b
            u2.i r10 = r10.f15321a
            int r11 = j1.l0.f8453a
            int r10 = r10.f15221a
            u2.v[] r9 = r9.f15315k
            if (r9 != 0) goto L_0x0746
            r9 = r0
            goto L_0x0748
        L_0x0746:
            r9 = r9[r10]
        L_0x0748:
            if (r9 == 0) goto L_0x074d
            java.lang.String r9 = r9.f15317b
            goto L_0x074e
        L_0x074d:
            r9 = r0
        L_0x074e:
            g1.u r9 = r2.u(r9)
            u2.x r10 = r8.f15232d
            u2.u r10 = r10.f15338a
            g1.a0 r10 = r10.f15310f
            r10.getClass()
            g1.z r11 = new g1.z
            r11.<init>(r10)
            r11.f6757n = r9
            g1.a0 r9 = new g1.a0
            r9.<init>(r11)
            d2.x0 r8 = r8.f15229a
            r8.a(r9)
            int r4 = r4 + 1
            r25 = r7
            goto L_0x072a
        L_0x0771:
            r7 = r25
            long r2 = r1.f15263w
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x07b2
            int r0 = r7.size()
            r2 = 0
        L_0x0783:
            if (r2 >= r0) goto L_0x07ab
            java.lang.Object r3 = r7.valueAt(r2)
            u2.l r3 = (u2.l) r3
            long r8 = r1.f15263w
            int r4 = r3.f15234f
        L_0x078f:
            u2.w r10 = r3.f15230b
            int r11 = r10.f15325e
            if (r4 >= r11) goto L_0x07a8
            long[] r11 = r10.f15329i
            r12 = r11[r4]
            int r11 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r11 > 0) goto L_0x07a8
            boolean[] r10 = r10.f15330j
            boolean r10 = r10[r4]
            if (r10 == 0) goto L_0x07a5
            r3.f15237i = r4
        L_0x07a5:
            int r4 = r4 + 1
            goto L_0x078f
        L_0x07a8:
            int r2 = r2 + 1
            goto L_0x0783
        L_0x07ab:
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r1.f15263w = r2
        L_0x07b2:
            r1 = r6
            r0 = r16
            goto L_0x0003
        L_0x07b7:
            r5 = r46
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x0003
            java.lang.Object r2 = r2.peek()
            u2.a r2 = (u2.a) r2
            java.util.ArrayList r2 = r2.f15198e
            r2.add(r4)
            goto L_0x0003
        L_0x07cc:
            r5 = r46
            r0 = 0
            r1.f15256p = r0
            r1.f15259s = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.m.g(long):void");
    }

    public final boolean h(w wVar) {
        return t.a(wVar, true, false);
    }

    public m(int i10) {
        this(0, (h0) null, Collections.emptyList());
    }

    public m(int i10, h0 h0Var, List list) {
        this.f15241a = i10;
        this.f15250j = h0Var;
        this.f15242b = null;
        this.f15243c = Collections.unmodifiableList(list);
        this.f15255o = null;
        this.f15251k = new d();
        this.f15252l = new b0(16);
        this.f15245e = new b0(p0.f4278a);
        this.f15246f = new b0(5);
        this.f15247g = new b0();
        byte[] bArr = new byte[16];
        this.f15248h = bArr;
        this.f15249i = new b0(bArr);
        this.f15253m = new ArrayDeque();
        this.f15254n = new ArrayDeque();
        this.f15244d = new SparseArray();
        this.f15264x = -9223372036854775807L;
        this.f15263w = -9223372036854775807L;
        this.f15265y = -9223372036854775807L;
        this.E = y.f4307a;
        this.F = new x0[0];
        this.G = new x0[0];
    }
}
