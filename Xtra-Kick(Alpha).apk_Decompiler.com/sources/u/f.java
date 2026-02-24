package u;

import android.support.v4.media.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import s.d;
import s.e;
import v.c;
import v.l;
import v.n;

public class f {
    public float A;
    public int B;
    public float C;
    public final int[] D;
    public float E;
    public boolean F;
    public boolean G;
    public int H;
    public int I;
    public final e J;
    public final e K;
    public final e L;
    public final e M;
    public final e N;
    public final e O;
    public final e P;
    public final e Q;
    public final e[] R;
    public final ArrayList S;
    public final boolean[] T;
    public f U;
    public int V;
    public int W;
    public float X;
    public int Y;
    public int Z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f15080a = false;

    /* renamed from: a0  reason: collision with root package name */
    public int f15081a0;

    /* renamed from: b  reason: collision with root package name */
    public c f15082b;

    /* renamed from: b0  reason: collision with root package name */
    public int f15083b0;

    /* renamed from: c  reason: collision with root package name */
    public c f15084c;

    /* renamed from: c0  reason: collision with root package name */
    public int f15085c0;

    /* renamed from: d  reason: collision with root package name */
    public l f15086d = null;

    /* renamed from: d0  reason: collision with root package name */
    public int f15087d0;

    /* renamed from: e  reason: collision with root package name */
    public n f15088e = null;

    /* renamed from: e0  reason: collision with root package name */
    public float f15089e0;

    /* renamed from: f  reason: collision with root package name */
    public final boolean[] f15090f = {true, true};

    /* renamed from: f0  reason: collision with root package name */
    public float f15091f0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15092g = true;

    /* renamed from: g0  reason: collision with root package name */
    public Object f15093g0;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f15094h = true;

    /* renamed from: h0  reason: collision with root package name */
    public int f15095h0;

    /* renamed from: i  reason: collision with root package name */
    public int f15096i = -1;

    /* renamed from: i0  reason: collision with root package name */
    public String f15097i0;

    /* renamed from: j  reason: collision with root package name */
    public int f15098j = -1;

    /* renamed from: j0  reason: collision with root package name */
    public int f15099j0;

    /* renamed from: k  reason: collision with root package name */
    public String f15100k;

    /* renamed from: k0  reason: collision with root package name */
    public int f15101k0;

    /* renamed from: l  reason: collision with root package name */
    public boolean f15102l;

    /* renamed from: l0  reason: collision with root package name */
    public final float[] f15103l0;

    /* renamed from: m  reason: collision with root package name */
    public boolean f15104m;

    /* renamed from: m0  reason: collision with root package name */
    public final f[] f15105m0;

    /* renamed from: n  reason: collision with root package name */
    public boolean f15106n;

    /* renamed from: n0  reason: collision with root package name */
    public final f[] f15107n0;

    /* renamed from: o  reason: collision with root package name */
    public boolean f15108o;

    /* renamed from: o0  reason: collision with root package name */
    public int f15109o0;

    /* renamed from: p  reason: collision with root package name */
    public int f15110p;

    /* renamed from: p0  reason: collision with root package name */
    public int f15111p0;

    /* renamed from: q  reason: collision with root package name */
    public int f15112q;

    /* renamed from: q0  reason: collision with root package name */
    public final int[] f15113q0;

    /* renamed from: r  reason: collision with root package name */
    public int f15114r;

    /* renamed from: s  reason: collision with root package name */
    public int f15115s;

    /* renamed from: t  reason: collision with root package name */
    public int f15116t;

    /* renamed from: u  reason: collision with root package name */
    public final int[] f15117u;

    /* renamed from: v  reason: collision with root package name */
    public int f15118v;

    /* renamed from: w  reason: collision with root package name */
    public int f15119w;

    /* renamed from: x  reason: collision with root package name */
    public float f15120x;

    /* renamed from: y  reason: collision with root package name */
    public int f15121y;

    /* renamed from: z  reason: collision with root package name */
    public int f15122z;

    public f() {
        new HashMap();
        this.f15102l = false;
        this.f15104m = false;
        this.f15106n = false;
        this.f15108o = false;
        this.f15110p = -1;
        this.f15112q = -1;
        this.f15114r = 0;
        this.f15115s = 0;
        this.f15116t = 0;
        this.f15117u = new int[2];
        this.f15118v = 0;
        this.f15119w = 0;
        this.f15120x = 1.0f;
        this.f15121y = 0;
        this.f15122z = 0;
        this.A = 1.0f;
        this.B = -1;
        this.C = 1.0f;
        this.D = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.E = 0.0f;
        this.F = false;
        this.G = false;
        this.H = 0;
        this.I = 0;
        e eVar = new e(this, d.LEFT);
        this.J = eVar;
        e eVar2 = new e(this, d.TOP);
        this.K = eVar2;
        e eVar3 = new e(this, d.RIGHT);
        this.L = eVar3;
        e eVar4 = new e(this, d.BOTTOM);
        this.M = eVar4;
        e eVar5 = new e(this, d.BASELINE);
        this.N = eVar5;
        e eVar6 = new e(this, d.CENTER_X);
        this.O = eVar6;
        e eVar7 = new e(this, d.CENTER_Y);
        this.P = eVar7;
        e eVar8 = new e(this, d.CENTER);
        this.Q = eVar8;
        this.R = new e[]{eVar, eVar3, eVar2, eVar4, eVar5, eVar8};
        ArrayList arrayList = new ArrayList();
        this.S = arrayList;
        this.T = new boolean[2];
        this.f15113q0 = new int[]{1, 1};
        this.U = null;
        this.V = 0;
        this.W = 0;
        this.X = 0.0f;
        this.Y = -1;
        this.Z = 0;
        this.f15081a0 = 0;
        this.f15083b0 = 0;
        this.f15089e0 = 0.5f;
        this.f15091f0 = 0.5f;
        this.f15095h0 = 0;
        this.f15097i0 = null;
        this.f15099j0 = 0;
        this.f15101k0 = 0;
        this.f15103l0 = new float[]{-1.0f, -1.0f};
        this.f15105m0 = new f[]{null, null};
        this.f15107n0 = new f[]{null, null};
        this.f15109o0 = -1;
        this.f15111p0 = -1;
        arrayList.add(eVar);
        arrayList.add(eVar2);
        arrayList.add(eVar3);
        arrayList.add(eVar4);
        arrayList.add(eVar6);
        arrayList.add(eVar7);
        arrayList.add(eVar8);
        arrayList.add(eVar5);
    }

    public static void G(int i10, int i11, String str, StringBuilder sb2) {
        if (i10 != i11) {
            sb2.append(str);
            sb2.append(" :   ");
            sb2.append(i10);
            sb2.append(",\n");
        }
    }

    public static void H(StringBuilder sb2, String str, float f10, float f11) {
        if (f10 != f11) {
            sb2.append(str);
            sb2.append(" :   ");
            sb2.append(f10);
            sb2.append(",\n");
        }
    }

    public static void o(StringBuilder sb2, String str, int i10, int i11, int i12, int i13, int i14, float f10) {
        sb2.append(str);
        sb2.append(" :  {\n");
        G(i10, 0, "      size", sb2);
        G(i11, 0, "      min", sb2);
        G(i12, Integer.MAX_VALUE, "      max", sb2);
        G(i13, 0, "      matchMin", sb2);
        G(i14, 0, "      matchDef", sb2);
        H(sb2, "      matchPercent", f10, 1.0f);
        sb2.append("    },\n");
    }

    public static void p(StringBuilder sb2, String str, e eVar) {
        if (eVar.f15076f != null) {
            sb2.append("    ");
            sb2.append(str);
            sb2.append(" : [ '");
            sb2.append(eVar.f15076f);
            sb2.append("'");
            if (!(eVar.f15078h == Integer.MIN_VALUE && eVar.f15077g == 0)) {
                sb2.append(",");
                sb2.append(eVar.f15077g);
                if (eVar.f15078h != Integer.MIN_VALUE) {
                    sb2.append(",");
                    sb2.append(eVar.f15078h);
                    sb2.append(",");
                }
            }
            sb2.append(" ] ,\n");
        }
    }

    public boolean A() {
        if (this.f15102l || (this.J.f15073c && this.L.f15073c)) {
            return true;
        }
        return false;
    }

    public boolean B() {
        if (this.f15104m || (this.K.f15073c && this.M.f15073c)) {
            return true;
        }
        return false;
    }

    public void C() {
        this.J.j();
        this.K.j();
        this.L.j();
        this.M.j();
        this.N.j();
        this.O.j();
        this.P.j();
        this.Q.j();
        this.U = null;
        this.E = 0.0f;
        this.V = 0;
        this.W = 0;
        this.X = 0.0f;
        this.Y = -1;
        this.Z = 0;
        this.f15081a0 = 0;
        this.f15083b0 = 0;
        this.f15085c0 = 0;
        this.f15087d0 = 0;
        this.f15089e0 = 0.5f;
        this.f15091f0 = 0.5f;
        int[] iArr = this.f15113q0;
        iArr[0] = 1;
        iArr[1] = 1;
        this.f15093g0 = null;
        this.f15095h0 = 0;
        this.f15099j0 = 0;
        this.f15101k0 = 0;
        float[] fArr = this.f15103l0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f15110p = -1;
        this.f15112q = -1;
        int[] iArr2 = this.D;
        iArr2[0] = Integer.MAX_VALUE;
        iArr2[1] = Integer.MAX_VALUE;
        this.f15115s = 0;
        this.f15116t = 0;
        this.f15120x = 1.0f;
        this.A = 1.0f;
        this.f15119w = Integer.MAX_VALUE;
        this.f15122z = Integer.MAX_VALUE;
        this.f15118v = 0;
        this.f15121y = 0;
        this.B = -1;
        this.C = 1.0f;
        boolean[] zArr = this.f15090f;
        zArr[0] = true;
        zArr[1] = true;
        this.G = false;
        boolean[] zArr2 = this.T;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f15092g = true;
        int[] iArr3 = this.f15117u;
        iArr3[0] = 0;
        iArr3[1] = 0;
        this.f15096i = -1;
        this.f15098j = -1;
    }

    public final void D() {
        f fVar = this.U;
        if (fVar != null && (fVar instanceof g)) {
            ((g) fVar).getClass();
        }
        ArrayList arrayList = this.S;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((e) arrayList.get(i10)).j();
        }
    }

    public final void E() {
        this.f15102l = false;
        this.f15104m = false;
        this.f15106n = false;
        this.f15108o = false;
        ArrayList arrayList = this.S;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            e eVar = (e) arrayList.get(i10);
            eVar.f15073c = false;
            eVar.f15072b = 0;
        }
    }

    public void F(d dVar) {
        this.J.k();
        this.K.k();
        this.L.k();
        this.M.k();
        this.N.k();
        this.Q.k();
        this.O.k();
        this.P.k();
    }

    public final void I(int i10, int i11) {
        if (!this.f15102l) {
            this.J.l(i10);
            this.L.l(i11);
            this.Z = i10;
            this.V = i11 - i10;
            this.f15102l = true;
        }
    }

    public final void J(int i10, int i11) {
        if (!this.f15104m) {
            this.K.l(i10);
            this.M.l(i11);
            this.f15081a0 = i10;
            this.W = i11 - i10;
            if (this.F) {
                this.N.l(i10 + this.f15083b0);
            }
            this.f15104m = true;
        }
    }

    public final void K(int i10) {
        this.W = i10;
        int i11 = this.f15087d0;
        if (i10 < i11) {
            this.W = i11;
        }
    }

    public final void L(int i10) {
        this.f15113q0[0] = i10;
    }

    public final void M(int i10) {
        this.f15113q0[1] = i10;
    }

    public final void N(int i10) {
        this.V = i10;
        int i11 = this.f15085c0;
        if (i10 < i11) {
            this.V = i11;
        }
    }

    public void O(boolean z10, boolean z11) {
        int i10;
        int i11;
        l lVar = this.f15086d;
        boolean z12 = z10 & lVar.f15547g;
        n nVar = this.f15088e;
        boolean z13 = z11 & nVar.f15547g;
        int i12 = lVar.f15548h.f15514g;
        int i13 = nVar.f15548h.f15514g;
        int i14 = lVar.f15549i.f15514g;
        int i15 = nVar.f15549i.f15514g;
        int i16 = i15 - i13;
        if (i14 - i12 < 0 || i16 < 0 || i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE || i14 == Integer.MIN_VALUE || i14 == Integer.MAX_VALUE || i15 == Integer.MIN_VALUE || i15 == Integer.MAX_VALUE) {
            i14 = 0;
            i15 = 0;
            i12 = 0;
            i13 = 0;
        }
        int i17 = i14 - i12;
        int i18 = i15 - i13;
        if (z12) {
            this.Z = i12;
        }
        if (z13) {
            this.f15081a0 = i13;
        }
        if (this.f15095h0 == 8) {
            this.V = 0;
            this.W = 0;
            return;
        }
        int[] iArr = this.f15113q0;
        if (z12) {
            if (iArr[0] == 1 && i17 < (i11 = this.V)) {
                i17 = i11;
            }
            this.V = i17;
            int i19 = this.f15085c0;
            if (i17 < i19) {
                this.V = i19;
            }
        }
        if (z13) {
            if (iArr[1] == 1 && i18 < (i10 = this.W)) {
                i18 = i10;
            }
            this.W = i18;
            int i20 = this.f15087d0;
            if (i18 < i20) {
                this.W = i20;
            }
        }
    }

    public void P(e eVar, boolean z10) {
        int i10;
        int i11;
        n nVar;
        l lVar;
        eVar.getClass();
        int o10 = e.o(this.J);
        int o11 = e.o(this.K);
        int o12 = e.o(this.L);
        int o13 = e.o(this.M);
        if (z10 && (lVar = this.f15086d) != null) {
            v.f fVar = lVar.f15548h;
            if (fVar.f15517j) {
                v.f fVar2 = lVar.f15549i;
                if (fVar2.f15517j) {
                    o10 = fVar.f15514g;
                    o12 = fVar2.f15514g;
                }
            }
        }
        if (z10 && (nVar = this.f15088e) != null) {
            v.f fVar3 = nVar.f15548h;
            if (fVar3.f15517j) {
                v.f fVar4 = nVar.f15549i;
                if (fVar4.f15517j) {
                    o11 = fVar3.f15514g;
                    o13 = fVar4.f15514g;
                }
            }
        }
        int i12 = o13 - o11;
        if (o12 - o10 < 0 || i12 < 0 || o10 == Integer.MIN_VALUE || o10 == Integer.MAX_VALUE || o11 == Integer.MIN_VALUE || o11 == Integer.MAX_VALUE || o12 == Integer.MIN_VALUE || o12 == Integer.MAX_VALUE || o13 == Integer.MIN_VALUE || o13 == Integer.MAX_VALUE) {
            o10 = 0;
            o11 = 0;
            o12 = 0;
            o13 = 0;
        }
        int i13 = o12 - o10;
        int i14 = o13 - o11;
        this.Z = o10;
        this.f15081a0 = o11;
        if (this.f15095h0 == 8) {
            this.V = 0;
            this.W = 0;
            return;
        }
        int[] iArr = this.f15113q0;
        int i15 = iArr[0];
        if (i15 == 1 && i13 < (i11 = this.V)) {
            i13 = i11;
        }
        if (iArr[1] == 1 && i14 < (i10 = this.W)) {
            i14 = i10;
        }
        this.V = i13;
        this.W = i14;
        int i16 = this.f15087d0;
        if (i14 < i16) {
            this.W = i16;
        }
        int i17 = this.f15085c0;
        if (i13 < i17) {
            this.V = i17;
        }
        int i18 = this.f15119w;
        if (i18 > 0 && i15 == 3) {
            this.V = Math.min(this.V, i18);
        }
        int i19 = this.f15122z;
        if (i19 > 0 && iArr[1] == 3) {
            this.W = Math.min(this.W, i19);
        }
        int i20 = this.V;
        if (i13 != i20) {
            this.f15096i = i20;
        }
        int i21 = this.W;
        if (i14 != i21) {
            this.f15098j = i21;
        }
    }

    public final void b(g gVar, e eVar, HashSet hashSet, int i10, boolean z10) {
        if (z10) {
            if (hashSet.contains(this)) {
                m.a(gVar, eVar, this);
                hashSet.remove(this);
                c(eVar, gVar.V(64));
            } else {
                return;
            }
        }
        if (i10 == 0) {
            HashSet hashSet2 = this.J.f15071a;
            if (hashSet2 != null) {
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).f15074d.b(gVar, eVar, hashSet, i10, true);
                }
            }
            HashSet hashSet3 = this.L.f15071a;
            if (hashSet3 != null) {
                Iterator it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    ((e) it2.next()).f15074d.b(gVar, eVar, hashSet, i10, true);
                }
                return;
            }
            return;
        }
        HashSet hashSet4 = this.K.f15071a;
        if (hashSet4 != null) {
            Iterator it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                ((e) it3.next()).f15074d.b(gVar, eVar, hashSet, i10, true);
            }
        }
        HashSet hashSet5 = this.M.f15071a;
        if (hashSet5 != null) {
            Iterator it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                ((e) it4.next()).f15074d.b(gVar, eVar, hashSet, i10, true);
            }
        }
        HashSet hashSet6 = this.N.f15071a;
        if (hashSet6 != null) {
            Iterator it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                ((e) it5.next()).f15074d.b(gVar, eVar, hashSet, i10, true);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00d9, code lost:
        if (r0.d() > ((u.e) r3.I0.get()).d()) goto L_0x00de;
     */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x02b5  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x02c0  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x02c8  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x02df  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x02e7  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x02e9  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0302  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0386  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x038a  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x0407  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x041d  */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x0427  */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x042c  */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x0443  */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x0445  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x0448  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x044a  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x047b  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x04c4  */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x0582  */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x05e4  */
    /* JADX WARNING: Removed duplicated region for block: B:357:0x05f8  */
    /* JADX WARNING: Removed duplicated region for block: B:358:0x05fa  */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x0601  */
    /* JADX WARNING: Removed duplicated region for block: B:395:0x067b  */
    /* JADX WARNING: Removed duplicated region for block: B:396:0x067e  */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x06bc  */
    /* JADX WARNING: Removed duplicated region for block: B:401:0x06c4  */
    /* JADX WARNING: Removed duplicated region for block: B:408:0x06e7  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(s.e r60, boolean r61) {
        /*
            r59 = this;
            r15 = r59
            r14 = r60
            u.e r0 = r15.J
            s.j r13 = r14.l(r0)
            u.e r1 = r15.L
            s.j r12 = r14.l(r1)
            u.e r2 = r15.K
            s.j r11 = r14.l(r2)
            u.e r10 = r15.M
            s.j r9 = r14.l(r10)
            u.e r8 = r15.N
            s.j r7 = r14.l(r8)
            u.f r3 = r15.U
            r4 = 2
            r6 = 0
            if (r3 == 0) goto L_0x004e
            int[] r3 = r3.f15113q0
            r5 = r3[r6]
            if (r5 != r4) goto L_0x0030
            r5 = 1
            goto L_0x0031
        L_0x0030:
            r5 = 0
        L_0x0031:
            r6 = 1
            r3 = r3[r6]
            if (r3 != r4) goto L_0x0039
            r19 = 1
            goto L_0x003b
        L_0x0039:
            r19 = 0
        L_0x003b:
            int r3 = r15.f15114r
            if (r3 == r6) goto L_0x0049
            if (r3 == r4) goto L_0x0050
            r6 = 3
            if (r3 == r6) goto L_0x004e
            r29 = r5
            r28 = r19
            goto L_0x0054
        L_0x0049:
            r29 = r5
            r28 = 0
            goto L_0x0054
        L_0x004e:
            r19 = 0
        L_0x0050:
            r28 = r19
            r29 = 0
        L_0x0054:
            int r3 = r15.f15095h0
            r6 = 8
            boolean[] r5 = r15.T
            if (r3 != r6) goto L_0x0094
            java.util.ArrayList r3 = r15.S
            int r4 = r3.size()
            r6 = 0
        L_0x0063:
            if (r6 >= r4) goto L_0x0086
            java.lang.Object r21 = r3.get(r6)
            r22 = r3
            r3 = r21
            u.e r3 = (u.e) r3
            java.util.HashSet r3 = r3.f15071a
            if (r3 != 0) goto L_0x0074
            goto L_0x007c
        L_0x0074:
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x007c
            r3 = 1
            goto L_0x007d
        L_0x007c:
            r3 = 0
        L_0x007d:
            if (r3 == 0) goto L_0x0081
            r3 = 1
            goto L_0x0087
        L_0x0081:
            int r6 = r6 + 1
            r3 = r22
            goto L_0x0063
        L_0x0086:
            r3 = 0
        L_0x0087:
            if (r3 != 0) goto L_0x0094
            r3 = 0
            boolean r4 = r5[r3]
            if (r4 != 0) goto L_0x0094
            r3 = 1
            boolean r4 = r5[r3]
            if (r4 != 0) goto L_0x0094
            return
        L_0x0094:
            boolean r3 = r15.f15102l
            if (r3 != 0) goto L_0x00a2
            boolean r4 = r15.f15104m
            if (r4 == 0) goto L_0x009d
            goto L_0x00a2
        L_0x009d:
            r22 = r5
            r6 = 5
            goto L_0x01ae
        L_0x00a2:
            boolean r4 = r15.f15094h
            if (r3 == 0) goto L_0x0117
            int r3 = r15.Z
            r14.d(r13, r3)
            int r3 = r15.Z
            int r6 = r15.V
            int r3 = r3 + r6
            r14.d(r12, r3)
            if (r29 == 0) goto L_0x0117
            u.f r3 = r15.U
            if (r3 == 0) goto L_0x0117
            if (r4 == 0) goto L_0x0109
            u.g r3 = (u.g) r3
            java.lang.ref.WeakReference r6 = r3.I0
            if (r6 == 0) goto L_0x00dc
            java.lang.Object r6 = r6.get()
            if (r6 == 0) goto L_0x00dc
            int r6 = r0.d()
            r22 = r5
            java.lang.ref.WeakReference r5 = r3.I0
            java.lang.Object r5 = r5.get()
            u.e r5 = (u.e) r5
            int r5 = r5.d()
            if (r6 <= r5) goto L_0x00e5
            goto L_0x00de
        L_0x00dc:
            r22 = r5
        L_0x00de:
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference
            r5.<init>(r0)
            r3.I0 = r5
        L_0x00e5:
            java.lang.ref.WeakReference r5 = r3.K0
            if (r5 == 0) goto L_0x0101
            java.lang.Object r5 = r5.get()
            if (r5 == 0) goto L_0x0101
            int r5 = r1.d()
            java.lang.ref.WeakReference r6 = r3.K0
            java.lang.Object r6 = r6.get()
            u.e r6 = (u.e) r6
            int r6 = r6.d()
            if (r5 <= r6) goto L_0x0119
        L_0x0101:
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference
            r5.<init>(r1)
            r3.K0 = r5
            goto L_0x0119
        L_0x0109:
            r22 = r5
            u.e r3 = r3.L
            s.j r3 = r14.l(r3)
            r5 = 5
            r6 = 0
            r14.f(r3, r12, r6, r5)
            goto L_0x0119
        L_0x0117:
            r22 = r5
        L_0x0119:
            boolean r3 = r15.f15104m
            if (r3 == 0) goto L_0x019f
            int r3 = r15.f15081a0
            r14.d(r11, r3)
            int r3 = r15.f15081a0
            int r5 = r15.W
            int r3 = r3 + r5
            r14.d(r9, r3)
            java.util.HashSet r3 = r8.f15071a
            if (r3 != 0) goto L_0x012f
            goto L_0x0137
        L_0x012f:
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x0137
            r3 = 1
            goto L_0x0138
        L_0x0137:
            r3 = 0
        L_0x0138:
            if (r3 == 0) goto L_0x0142
            int r3 = r15.f15081a0
            int r5 = r15.f15083b0
            int r3 = r3 + r5
            r14.d(r7, r3)
        L_0x0142:
            if (r28 == 0) goto L_0x019f
            u.f r3 = r15.U
            if (r3 == 0) goto L_0x019f
            if (r4 == 0) goto L_0x0193
            u.g r3 = (u.g) r3
            java.lang.ref.WeakReference r4 = r3.H0
            if (r4 == 0) goto L_0x0168
            java.lang.Object r4 = r4.get()
            if (r4 == 0) goto L_0x0168
            int r4 = r2.d()
            java.lang.ref.WeakReference r5 = r3.H0
            java.lang.Object r5 = r5.get()
            u.e r5 = (u.e) r5
            int r5 = r5.d()
            if (r4 <= r5) goto L_0x016f
        L_0x0168:
            java.lang.ref.WeakReference r4 = new java.lang.ref.WeakReference
            r4.<init>(r2)
            r3.H0 = r4
        L_0x016f:
            java.lang.ref.WeakReference r4 = r3.J0
            if (r4 == 0) goto L_0x018b
            java.lang.Object r4 = r4.get()
            if (r4 == 0) goto L_0x018b
            int r4 = r10.d()
            java.lang.ref.WeakReference r5 = r3.J0
            java.lang.Object r5 = r5.get()
            u.e r5 = (u.e) r5
            int r5 = r5.d()
            if (r4 <= r5) goto L_0x019f
        L_0x018b:
            java.lang.ref.WeakReference r4 = new java.lang.ref.WeakReference
            r4.<init>(r10)
            r3.J0 = r4
            goto L_0x019f
        L_0x0193:
            u.e r3 = r3.M
            s.j r3 = r14.l(r3)
            r4 = 0
            r6 = 5
            r14.f(r3, r9, r4, r6)
            goto L_0x01a1
        L_0x019f:
            r4 = 0
            r6 = 5
        L_0x01a1:
            boolean r3 = r15.f15102l
            if (r3 == 0) goto L_0x01ae
            boolean r3 = r15.f15104m
            if (r3 == 0) goto L_0x01ae
            r15.f15102l = r4
            r15.f15104m = r4
            return
        L_0x01ae:
            boolean[] r5 = r15.f15090f
            if (r61 == 0) goto L_0x023d
            v.l r3 = r15.f15086d
            if (r3 == 0) goto L_0x023d
            v.n r4 = r15.f15088e
            if (r4 == 0) goto L_0x023d
            v.f r6 = r3.f15548h
            r23 = r8
            boolean r8 = r6.f15517j
            if (r8 == 0) goto L_0x023f
            v.f r3 = r3.f15549i
            boolean r3 = r3.f15517j
            if (r3 == 0) goto L_0x023f
            v.f r3 = r4.f15548h
            boolean r3 = r3.f15517j
            if (r3 == 0) goto L_0x023f
            v.f r3 = r4.f15549i
            boolean r3 = r3.f15517j
            if (r3 == 0) goto L_0x023f
            int r0 = r6.f15514g
            r14.d(r13, r0)
            v.l r0 = r15.f15086d
            v.f r0 = r0.f15549i
            int r0 = r0.f15514g
            r14.d(r12, r0)
            v.n r0 = r15.f15088e
            v.f r0 = r0.f15548h
            int r0 = r0.f15514g
            r14.d(r11, r0)
            v.n r0 = r15.f15088e
            v.f r0 = r0.f15549i
            int r0 = r0.f15514g
            r14.d(r9, r0)
            v.n r0 = r15.f15088e
            v.f r0 = r0.f15525k
            int r0 = r0.f15514g
            r14.d(r7, r0)
            u.f r0 = r15.U
            if (r0 == 0) goto L_0x0237
            if (r29 == 0) goto L_0x021b
            r0 = 0
            boolean r1 = r5[r0]
            if (r1 == 0) goto L_0x021b
            boolean r1 = r59.x()
            if (r1 != 0) goto L_0x021b
            u.f r1 = r15.U
            u.e r1 = r1.L
            s.j r1 = r14.l(r1)
            r2 = 8
            r14.f(r1, r12, r0, r2)
        L_0x021b:
            if (r28 == 0) goto L_0x0237
            r0 = 1
            boolean r0 = r5[r0]
            if (r0 == 0) goto L_0x0237
            boolean r0 = r59.y()
            if (r0 != 0) goto L_0x0237
            u.f r0 = r15.U
            u.e r0 = r0.M
            s.j r0 = r14.l(r0)
            r1 = 8
            r2 = 0
            r14.f(r0, r9, r2, r1)
            goto L_0x0238
        L_0x0237:
            r2 = 0
        L_0x0238:
            r15.f15102l = r2
            r15.f15104m = r2
            return
        L_0x023d:
            r23 = r8
        L_0x023f:
            u.f r3 = r15.U
            if (r3 == 0) goto L_0x02b5
            r3 = 0
            boolean r4 = r15.w(r3)
            if (r4 == 0) goto L_0x0253
            u.f r4 = r15.U
            u.g r4 = (u.g) r4
            r4.R(r3, r15)
            r3 = 1
            goto L_0x0257
        L_0x0253:
            boolean r3 = r59.x()
        L_0x0257:
            r4 = 1
            boolean r6 = r15.w(r4)
            if (r6 == 0) goto L_0x0267
            u.f r6 = r15.U
            u.g r6 = (u.g) r6
            r6.R(r4, r15)
            r4 = 1
            goto L_0x026b
        L_0x0267:
            boolean r4 = r59.y()
        L_0x026b:
            if (r3 != 0) goto L_0x028d
            if (r29 == 0) goto L_0x028d
            int r6 = r15.f15095h0
            r8 = 8
            if (r6 == r8) goto L_0x028d
            u.e r6 = r0.f15076f
            if (r6 != 0) goto L_0x028d
            u.e r6 = r1.f15076f
            if (r6 != 0) goto L_0x028d
            u.f r6 = r15.U
            u.e r6 = r6.L
            s.j r6 = r14.l(r6)
            r24 = r3
            r3 = 0
            r8 = 1
            r14.f(r6, r12, r3, r8)
            goto L_0x028f
        L_0x028d:
            r24 = r3
        L_0x028f:
            if (r4 != 0) goto L_0x02b0
            if (r28 == 0) goto L_0x02b0
            int r3 = r15.f15095h0
            r6 = 8
            if (r3 == r6) goto L_0x02b0
            u.e r3 = r2.f15076f
            if (r3 != 0) goto L_0x02b0
            u.e r3 = r10.f15076f
            if (r3 != 0) goto L_0x02b0
            if (r23 != 0) goto L_0x02b0
            u.f r3 = r15.U
            u.e r3 = r3.M
            s.j r3 = r14.l(r3)
            r6 = 1
            r8 = 0
            r14.f(r3, r9, r8, r6)
        L_0x02b0:
            r30 = r4
            r31 = r24
            goto L_0x02b9
        L_0x02b5:
            r30 = 0
            r31 = 0
        L_0x02b9:
            int r3 = r15.V
            int r4 = r15.f15085c0
            if (r3 >= r4) goto L_0x02c0
            goto L_0x02c1
        L_0x02c0:
            r4 = r3
        L_0x02c1:
            int r6 = r15.W
            int r8 = r15.f15087d0
            if (r6 >= r8) goto L_0x02c8
            goto L_0x02c9
        L_0x02c8:
            r8 = r6
        L_0x02c9:
            r27 = r11
            int[] r11 = r15.f15113q0
            r24 = r4
            r18 = 0
            r4 = r11[r18]
            r32 = r7
            r7 = 3
            r26 = r8
            r16 = 1
            if (r4 == r7) goto L_0x02df
            r25 = 1
            goto L_0x02e1
        L_0x02df:
            r25 = 0
        L_0x02e1:
            r8 = r11[r16]
            r33 = r9
            if (r8 == r7) goto L_0x02e9
            r7 = 1
            goto L_0x02ea
        L_0x02e9:
            r7 = 0
        L_0x02ea:
            int r9 = r15.Y
            r15.B = r9
            r34 = r5
            float r5 = r15.X
            r15.C = r5
            r35 = r12
            int r12 = r15.f15115s
            r36 = r13
            int r13 = r15.f15116t
            r37 = 0
            int r37 = (r5 > r37 ? 1 : (r5 == r37 ? 0 : -1))
            if (r37 <= 0) goto L_0x0407
            int r14 = r15.f15095h0
            r38 = r11
            r11 = 8
            if (r14 == r11) goto L_0x0409
            r11 = 3
            if (r4 != r11) goto L_0x0310
            if (r12 != 0) goto L_0x0310
            r12 = 3
        L_0x0310:
            if (r8 != r11) goto L_0x0315
            if (r13 != 0) goto L_0x0315
            r13 = 3
        L_0x0315:
            r14 = 1065353216(0x3f800000, float:1.0)
            if (r4 != r11) goto L_0x03bf
            if (r8 != r11) goto L_0x03bf
            if (r12 != r11) goto L_0x03bf
            if (r13 != r11) goto L_0x03bf
            r11 = -1
            if (r9 != r11) goto L_0x0337
            if (r25 == 0) goto L_0x032a
            if (r7 != 0) goto L_0x032a
            r3 = 0
            r15.B = r3
            goto L_0x0337
        L_0x032a:
            if (r25 != 0) goto L_0x0337
            if (r7 == 0) goto L_0x0337
            r3 = 1
            r15.B = r3
            if (r9 != r11) goto L_0x0337
            float r3 = r14 / r5
            r15.C = r3
        L_0x0337:
            int r3 = r15.B
            if (r3 != 0) goto L_0x0349
            boolean r3 = r2.h()
            if (r3 == 0) goto L_0x0347
            boolean r3 = r10.h()
            if (r3 != 0) goto L_0x0349
        L_0x0347:
            r3 = 1
            goto L_0x035b
        L_0x0349:
            int r3 = r15.B
            r4 = 1
            if (r3 != r4) goto L_0x035d
            boolean r3 = r0.h()
            if (r3 == 0) goto L_0x035a
            boolean r3 = r1.h()
            if (r3 != 0) goto L_0x035d
        L_0x035a:
            r3 = 0
        L_0x035b:
            r15.B = r3
        L_0x035d:
            int r3 = r15.B
            r4 = -1
            if (r3 != r4) goto L_0x039f
            boolean r3 = r2.h()
            if (r3 == 0) goto L_0x037a
            boolean r3 = r10.h()
            if (r3 == 0) goto L_0x037a
            boolean r3 = r0.h()
            if (r3 == 0) goto L_0x037a
            boolean r3 = r1.h()
            if (r3 != 0) goto L_0x039f
        L_0x037a:
            boolean r2 = r2.h()
            if (r2 == 0) goto L_0x038a
            boolean r2 = r10.h()
            if (r2 == 0) goto L_0x038a
            r2 = 0
            r15.B = r2
            goto L_0x039f
        L_0x038a:
            boolean r0 = r0.h()
            if (r0 == 0) goto L_0x039f
            boolean r0 = r1.h()
            if (r0 == 0) goto L_0x039f
            float r0 = r15.C
            float r0 = r14 / r0
            r15.C = r0
            r0 = 1
            r15.B = r0
        L_0x039f:
            int r0 = r15.B
            r1 = -1
            if (r0 != r1) goto L_0x03fa
            int r0 = r15.f15118v
            if (r0 <= 0) goto L_0x03b0
            int r1 = r15.f15121y
            if (r1 != 0) goto L_0x03b0
            r1 = 0
            r15.B = r1
            goto L_0x03fa
        L_0x03b0:
            if (r0 != 0) goto L_0x03fa
            int r0 = r15.f15121y
            if (r0 <= 0) goto L_0x03fa
            float r0 = r15.C
            float r14 = r14 / r0
            r15.C = r14
            r0 = 1
            r15.B = r0
            goto L_0x03fa
        L_0x03bf:
            r0 = 4
            r1 = 3
            if (r4 != r1) goto L_0x03d7
            if (r12 != r1) goto L_0x03d7
            r2 = 0
            r15.B = r2
            float r2 = (float) r6
            float r5 = r5 * r2
            int r4 = (int) r5
            if (r8 == r1) goto L_0x03fc
            r41 = r13
            r40 = r26
            r39 = 0
            r42 = 4
            goto L_0x0413
        L_0x03d7:
            if (r8 != r1) goto L_0x03fa
            if (r13 != r1) goto L_0x03fa
            r2 = 1
            r15.B = r2
            r2 = -1
            if (r9 != r2) goto L_0x03e4
            float r14 = r14 / r5
            r15.C = r14
        L_0x03e4:
            float r2 = r15.C
            float r3 = (float) r3
            float r2 = r2 * r3
            int r8 = (int) r2
            if (r4 == r1) goto L_0x03f7
            r40 = r8
            r42 = r12
            r4 = r24
            r39 = 0
            r41 = 4
            goto L_0x0413
        L_0x03f7:
            r4 = r24
            goto L_0x03fe
        L_0x03fa:
            r4 = r24
        L_0x03fc:
            r8 = r26
        L_0x03fe:
            r40 = r8
            r42 = r12
            r41 = r13
            r39 = 1
            goto L_0x0413
        L_0x0407:
            r38 = r11
        L_0x0409:
            r42 = r12
            r41 = r13
            r4 = r24
            r40 = r26
            r39 = 0
        L_0x0413:
            int[] r0 = r15.f15117u
            r1 = 0
            r0[r1] = r42
            r1 = 1
            r0[r1] = r41
            if (r39 == 0) goto L_0x0427
            int r0 = r15.B
            r1 = -1
            if (r0 == 0) goto L_0x0424
            if (r0 != r1) goto L_0x0428
        L_0x0424:
            r37 = 1
            goto L_0x042a
        L_0x0427:
            r1 = -1
        L_0x0428:
            r37 = 0
        L_0x042a:
            if (r39 == 0) goto L_0x0437
            int r0 = r15.B
            r2 = 1
            if (r0 == r2) goto L_0x0433
            if (r0 != r1) goto L_0x0437
        L_0x0433:
            r0 = 0
            r43 = 1
            goto L_0x043a
        L_0x0437:
            r0 = 0
            r43 = 0
        L_0x043a:
            r1 = r38[r0]
            r0 = 2
            if (r1 != r0) goto L_0x0445
            boolean r0 = r15 instanceof u.g
            if (r0 == 0) goto L_0x0445
            r9 = 1
            goto L_0x0446
        L_0x0445:
            r9 = 0
        L_0x0446:
            if (r9 == 0) goto L_0x044a
            r13 = 0
            goto L_0x044b
        L_0x044a:
            r13 = r4
        L_0x044b:
            u.e r14 = r15.Q
            boolean r0 = r14.h()
            r1 = 1
            r44 = r0 ^ 1
            r0 = 0
            boolean r45 = r22[r0]
            boolean r46 = r22[r1]
            int r0 = r15.f15110p
            int[] r12 = r15.D
            r47 = 0
            r4 = 2
            if (r0 == r4) goto L_0x056c
            boolean r0 = r15.f15102l
            if (r0 != 0) goto L_0x056c
            if (r61 == 0) goto L_0x04c8
            v.l r0 = r15.f15086d
            if (r0 == 0) goto L_0x04c8
            v.f r1 = r0.f15548h
            boolean r2 = r1.f15517j
            if (r2 == 0) goto L_0x04c8
            v.f r0 = r0.f15549i
            boolean r0 = r0.f15517j
            if (r0 != 0) goto L_0x0479
            goto L_0x04c8
        L_0x0479:
            if (r61 == 0) goto L_0x04c4
            int r0 = r1.f15514g
            r11 = r60
            r8 = r36
            r11.d(r8, r0)
            v.l r0 = r15.f15086d
            v.f r0 = r0.f15549i
            int r0 = r0.f15514g
            r7 = r35
            r11.d(r7, r0)
            u.f r0 = r15.U
            if (r0 == 0) goto L_0x04ae
            if (r29 == 0) goto L_0x04ae
            r0 = 0
            boolean r1 = r34[r0]
            if (r1 == 0) goto L_0x04ae
            boolean r1 = r59.x()
            if (r1 != 0) goto L_0x04ae
            u.f r1 = r15.U
            u.e r1 = r1.L
            s.j r1 = r11.l(r1)
            r6 = 8
            r11.f(r1, r7, r0, r6)
            goto L_0x04b0
        L_0x04ae:
            r6 = 8
        L_0x04b0:
            r48 = r8
            r57 = r10
            r49 = r14
            r55 = r23
            r58 = r27
            r54 = r32
            r56 = r33
            r32 = r38
            r33 = r7
            goto L_0x057e
        L_0x04c4:
            r11 = r60
            goto L_0x056c
        L_0x04c8:
            r11 = r60
            r7 = r35
            r8 = r36
            r6 = 8
            u.f r0 = r15.U
            if (r0 == 0) goto L_0x04dd
            u.e r0 = r0.L
            s.j r0 = r11.l(r0)
            r19 = r0
            goto L_0x04df
        L_0x04dd:
            r19 = r47
        L_0x04df:
            u.f r0 = r15.U
            if (r0 == 0) goto L_0x04ec
            u.e r0 = r0.J
            s.j r0 = r11.l(r0)
            r18 = r0
            goto L_0x04ee
        L_0x04ec:
            r18 = r47
        L_0x04ee:
            r20 = 0
            boolean r5 = r34[r20]
            r22 = r38[r20]
            u.e r3 = r15.J
            u.e r1 = r15.L
            int r0 = r15.Z
            int r2 = r15.f15085c0
            r35 = r12[r20]
            r36 = r2
            float r2 = r15.f15089e0
            r17 = 1
            r4 = r38[r17]
            r6 = 3
            if (r4 != r6) goto L_0x050c
            r50 = 1
            goto L_0x050e
        L_0x050c:
            r50 = 0
        L_0x050e:
            int r4 = r15.f15118v
            r24 = r4
            int r4 = r15.f15119w
            r25 = r4
            float r4 = r15.f15120x
            r26 = r4
            r4 = 1
            r16 = r36
            r36 = r2
            r2 = r4
            r51 = r0
            r0 = r59
            r52 = r1
            r1 = r60
            r53 = r3
            r3 = r29
            r4 = r28
            r6 = r18
            r17 = r7
            r54 = r32
            r7 = r19
            r18 = r8
            r55 = r23
            r8 = r22
            r56 = r33
            r57 = r10
            r10 = r53
            r58 = r27
            r32 = r38
            r11 = r52
            r38 = r12
            r33 = r17
            r12 = r51
            r48 = r18
            r49 = r14
            r14 = r16
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r50
            r19 = r31
            r20 = r30
            r21 = r45
            r22 = r42
            r23 = r41
            r27 = r44
            r0.e(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            goto L_0x0580
        L_0x056c:
            r57 = r10
            r49 = r14
            r55 = r23
            r58 = r27
            r54 = r32
            r56 = r33
            r33 = r35
            r48 = r36
            r32 = r38
        L_0x057e:
            r38 = r12
        L_0x0580:
            if (r61 == 0) goto L_0x05e4
            r15 = r59
            v.n r0 = r15.f15088e
            if (r0 == 0) goto L_0x05d7
            v.f r1 = r0.f15548h
            boolean r2 = r1.f15517j
            if (r2 == 0) goto L_0x05d7
            v.f r0 = r0.f15549i
            boolean r0 = r0.f15517j
            if (r0 == 0) goto L_0x05d7
            int r0 = r1.f15514g
            r14 = r60
            r13 = r58
            r14.d(r13, r0)
            v.n r0 = r15.f15088e
            v.f r0 = r0.f15549i
            int r0 = r0.f15514g
            r12 = r56
            r14.d(r12, r0)
            v.n r0 = r15.f15088e
            v.f r0 = r0.f15525k
            int r0 = r0.f15514g
            r1 = r54
            r14.d(r1, r0)
            u.f r0 = r15.U
            if (r0 == 0) goto L_0x05d1
            if (r30 != 0) goto L_0x05d1
            if (r28 == 0) goto L_0x05d1
            r11 = 1
            boolean r2 = r34[r11]
            if (r2 == 0) goto L_0x05cd
            u.e r0 = r0.M
            s.j r0 = r14.l(r0)
            r2 = 8
            r10 = 0
            r14.f(r0, r12, r10, r2)
            goto L_0x05d5
        L_0x05cd:
            r2 = 8
            r10 = 0
            goto L_0x05d5
        L_0x05d1:
            r2 = 8
            r10 = 0
            r11 = 1
        L_0x05d5:
            r5 = 0
            goto L_0x05f3
        L_0x05d7:
            r14 = r60
            r1 = r54
            r12 = r56
            r13 = r58
            r2 = 8
            r10 = 0
            r11 = 1
            goto L_0x05f2
        L_0x05e4:
            r2 = 8
            r10 = 0
            r11 = 1
            r15 = r59
            r14 = r60
            r1 = r54
            r12 = r56
            r13 = r58
        L_0x05f2:
            r5 = 1
        L_0x05f3:
            int r0 = r15.f15112q
            r3 = 2
            if (r0 != r3) goto L_0x05fa
            r6 = 0
            goto L_0x05fb
        L_0x05fa:
            r6 = r5
        L_0x05fb:
            if (r6 == 0) goto L_0x06bc
            boolean r0 = r15.f15104m
            if (r0 != 0) goto L_0x06bc
            r0 = r32[r11]
            if (r0 != r3) goto L_0x060b
            boolean r0 = r15 instanceof u.g
            if (r0 == 0) goto L_0x060b
            r9 = 1
            goto L_0x060c
        L_0x060b:
            r9 = 0
        L_0x060c:
            if (r9 == 0) goto L_0x0610
            r40 = 0
        L_0x0610:
            u.f r0 = r15.U
            if (r0 == 0) goto L_0x061c
            u.e r0 = r0.M
            s.j r0 = r14.l(r0)
            r7 = r0
            goto L_0x061e
        L_0x061c:
            r7 = r47
        L_0x061e:
            u.f r0 = r15.U
            if (r0 == 0) goto L_0x062a
            u.e r0 = r0.K
            s.j r0 = r14.l(r0)
            r6 = r0
            goto L_0x062c
        L_0x062a:
            r6 = r47
        L_0x062c:
            int r0 = r15.f15083b0
            if (r0 > 0) goto L_0x0634
            int r3 = r15.f15095h0
            if (r3 != r2) goto L_0x0664
        L_0x0634:
            r3 = r55
            u.e r4 = r3.f15076f
            if (r4 == 0) goto L_0x0659
            r14.e(r1, r13, r0, r2)
            u.e r0 = r3.f15076f
            s.j r0 = r14.l(r0)
            int r3 = r3.e()
            r14.e(r1, r0, r3, r2)
            if (r28 == 0) goto L_0x0656
            r0 = r57
            s.j r0 = r14.l(r0)
            r1 = 5
            r14.f(r7, r0, r10, r1)
        L_0x0656:
            r27 = 0
            goto L_0x0666
        L_0x0659:
            int r4 = r15.f15095h0
            if (r4 != r2) goto L_0x0661
            int r0 = r3.e()
        L_0x0661:
            r14.e(r1, r13, r0, r2)
        L_0x0664:
            r27 = r44
        L_0x0666:
            boolean r5 = r34[r11]
            r8 = r32[r11]
            u.e r4 = r15.K
            u.e r3 = r15.M
            int r1 = r15.f15081a0
            int r0 = r15.f15087d0
            r16 = r38[r11]
            float r2 = r15.f15091f0
            r11 = r32[r10]
            r10 = 3
            if (r11 != r10) goto L_0x067e
            r18 = 1
            goto L_0x0680
        L_0x067e:
            r18 = 0
        L_0x0680:
            int r10 = r15.f15121y
            r24 = r10
            int r10 = r15.f15122z
            r25 = r10
            float r10 = r15.A
            r26 = r10
            r10 = 0
            r17 = r2
            r2 = r10
            r19 = r0
            r0 = r59
            r20 = r1
            r1 = r60
            r11 = r3
            r3 = r28
            r10 = r4
            r4 = r29
            r28 = r12
            r12 = r20
            r29 = r13
            r13 = r40
            r14 = r19
            r15 = r16
            r16 = r17
            r17 = r43
            r19 = r30
            r20 = r31
            r21 = r46
            r22 = r41
            r23 = r42
            r0.e(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            goto L_0x06c0
        L_0x06bc:
            r28 = r12
            r29 = r13
        L_0x06c0:
            r6 = r59
            if (r39 == 0) goto L_0x06e1
            int r0 = r6.B
            float r5 = r6.C
            r1 = 1
            if (r0 != r1) goto L_0x06d4
            r1 = r28
            r2 = r29
            r3 = r33
            r4 = r48
            goto L_0x06dc
        L_0x06d4:
            r3 = r28
            r4 = r29
            r1 = r33
            r2 = r48
        L_0x06dc:
            r0 = r60
            r0.h(r1, r2, r3, r4, r5)
        L_0x06e1:
            boolean r0 = r49.h()
            if (r0 == 0) goto L_0x07a0
            r0 = r49
            u.e r1 = r0.f15076f
            u.f r1 = r1.f15074d
            float r2 = r6.E
            r3 = 1119092736(0x42b40000, float:90.0)
            float r2 = r2 + r3
            double r2 = (double) r2
            double r2 = java.lang.Math.toRadians(r2)
            float r2 = (float) r2
            int r0 = r0.e()
            u.d r3 = u.d.LEFT
            u.e r4 = r6.j(r3)
            r5 = r60
            s.j r4 = r5.l(r4)
            u.d r7 = u.d.TOP
            u.e r8 = r6.j(r7)
            s.j r8 = r5.l(r8)
            u.d r9 = u.d.RIGHT
            u.e r10 = r6.j(r9)
            s.j r10 = r5.l(r10)
            u.d r11 = u.d.BOTTOM
            u.e r12 = r6.j(r11)
            s.j r12 = r5.l(r12)
            u.e r3 = r1.j(r3)
            s.j r3 = r5.l(r3)
            u.e r7 = r1.j(r7)
            s.j r7 = r5.l(r7)
            u.e r9 = r1.j(r9)
            s.j r9 = r5.l(r9)
            u.e r1 = r1.j(r11)
            s.j r1 = r5.l(r1)
            s.c r11 = r60.m()
            double r13 = (double) r2
            double r15 = java.lang.Math.sin(r13)
            r2 = r9
            r61 = r10
            double r9 = (double) r0
            r17 = r2
            r0 = r3
            double r2 = r15 * r9
            float r2 = (float) r2
            s.b r3 = r11.f13927d
            r15 = 1056964608(0x3f000000, float:0.5)
            r3.b(r7, r15)
            s.b r3 = r11.f13927d
            r3.b(r1, r15)
            s.b r1 = r11.f13927d
            r3 = -1090519040(0xffffffffbf000000, float:-0.5)
            r1.b(r8, r3)
            s.b r1 = r11.f13927d
            r1.b(r12, r3)
            float r1 = -r2
            r11.f13925b = r1
            r5.c(r11)
            s.c r1 = r60.m()
            double r7 = java.lang.Math.cos(r13)
            double r7 = r7 * r9
            float r2 = (float) r7
            s.b r7 = r1.f13927d
            r7.b(r0, r15)
            s.b r0 = r1.f13927d
            r7 = r17
            r0.b(r7, r15)
            s.b r0 = r1.f13927d
            r0.b(r4, r3)
            s.b r0 = r1.f13927d
            r4 = r61
            r0.b(r4, r3)
            float r0 = -r2
            r1.f13925b = r0
            r5.c(r1)
        L_0x07a0:
            r0 = 0
            r6.f15102l = r0
            r6.f15104m = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: u.f.c(s.e, boolean):void");
    }

    public boolean d() {
        return this.f15095h0 != 8;
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x019e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x034d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x035c  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x03a7  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x03bf  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x03d4 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x03f5  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x03f9 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0414 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x0463  */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x0483  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x048a  */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x049f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x04c3 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:350:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:354:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(s.e r29, boolean r30, boolean r31, boolean r32, boolean r33, s.j r34, s.j r35, int r36, boolean r37, u.e r38, u.e r39, int r40, int r41, int r42, int r43, float r44, boolean r45, boolean r46, boolean r47, boolean r48, boolean r49, int r50, int r51, int r52, int r53, float r54, boolean r55) {
        /*
            r28 = this;
            r0 = r28
            r10 = r29
            r11 = r34
            r12 = r35
            r13 = r38
            r14 = r39
            r15 = r42
            r1 = r43
            r2 = r51
            r3 = r52
            r4 = r53
            r5 = r54
            s.j r9 = r10.l(r13)
            s.j r8 = r10.l(r14)
            u.e r6 = r13.f15076f
            s.j r7 = r10.l(r6)
            u.e r6 = r14.f15076f
            s.j r6 = r10.l(r6)
            boolean r16 = r38.h()
            boolean r17 = r39.h()
            u.e r12 = r0.Q
            boolean r12 = r12.h()
            if (r17 == 0) goto L_0x003f
            int r18 = r16 + 1
            goto L_0x0041
        L_0x003f:
            r18 = r16
        L_0x0041:
            if (r12 == 0) goto L_0x0045
            int r18 = r18 + 1
        L_0x0045:
            r2 = r18
            if (r45 == 0) goto L_0x004b
            r14 = 3
            goto L_0x004d
        L_0x004b:
            r14 = r50
        L_0x004d:
            if (r36 == 0) goto L_0x0500
            r11 = -1
            r19 = r6
            int r6 = r36 + -1
            r11 = 1
            if (r6 == 0) goto L_0x0062
            if (r6 == r11) goto L_0x0062
            r11 = 2
            if (r6 == r11) goto L_0x005d
            goto L_0x0062
        L_0x005d:
            r11 = 4
            if (r14 == r11) goto L_0x0062
            r6 = 1
            goto L_0x0063
        L_0x0062:
            r6 = 0
        L_0x0063:
            int r11 = r0.f15096i
            r21 = r6
            r6 = -1
            if (r11 == r6) goto L_0x0072
            if (r30 == 0) goto L_0x0072
            r0.f15096i = r6
            r41 = r11
            r21 = 0
        L_0x0072:
            int r11 = r0.f15098j
            if (r11 == r6) goto L_0x007d
            if (r30 != 0) goto L_0x007d
            r0.f15098j = r6
            r21 = 0
            goto L_0x007f
        L_0x007d:
            r11 = r41
        L_0x007f:
            int r6 = r0.f15095h0
            r41 = r11
            r11 = 8
            if (r6 != r11) goto L_0x008b
            r6 = 0
            r21 = 0
            goto L_0x008d
        L_0x008b:
            r6 = r41
        L_0x008d:
            if (r55 == 0) goto L_0x00ab
            if (r16 != 0) goto L_0x009b
            if (r17 != 0) goto L_0x009b
            if (r12 != 0) goto L_0x009b
            r11 = r40
            r10.d(r9, r11)
            goto L_0x00ab
        L_0x009b:
            if (r16 == 0) goto L_0x00ab
            if (r17 != 0) goto L_0x00ab
            int r11 = r38.e()
            r22 = r12
            r12 = 8
            r10.e(r9, r7, r11, r12)
            goto L_0x00af
        L_0x00ab:
            r22 = r12
            r12 = 8
        L_0x00af:
            if (r21 != 0) goto L_0x00d0
            r5 = 3
            if (r37 == 0) goto L_0x00c6
            r11 = 0
            r10.e(r8, r9, r11, r5)
            if (r15 <= 0) goto L_0x00bd
            r10.f(r8, r9, r15, r12)
        L_0x00bd:
            r6 = 2147483647(0x7fffffff, float:NaN)
            if (r1 >= r6) goto L_0x00c9
            r10.g(r8, r9, r1, r12)
            goto L_0x00c9
        L_0x00c6:
            r10.e(r8, r9, r6, r12)
        L_0x00c9:
            r11 = r33
            r23 = r2
        L_0x00cd:
            r12 = r3
            goto L_0x019c
        L_0x00d0:
            r1 = 3
            r11 = 2
            if (r2 == r11) goto L_0x00f3
            if (r45 != 0) goto L_0x00f3
            r11 = 1
            if (r14 == r11) goto L_0x00db
            if (r14 != 0) goto L_0x00f3
        L_0x00db:
            int r5 = java.lang.Math.max(r3, r6)
            if (r4 <= 0) goto L_0x00e5
            int r5 = java.lang.Math.min(r4, r5)
        L_0x00e5:
            r6 = 8
            r10.e(r8, r9, r5, r6)
            r11 = r33
            r23 = r2
            r12 = r3
            r21 = 0
            goto L_0x019c
        L_0x00f3:
            r11 = -2
            if (r3 != r11) goto L_0x00f7
            r3 = r6
        L_0x00f7:
            if (r4 != r11) goto L_0x00fa
            r4 = r6
        L_0x00fa:
            if (r6 <= 0) goto L_0x0100
            r11 = 1
            if (r14 == r11) goto L_0x0100
            r6 = 0
        L_0x0100:
            if (r3 <= 0) goto L_0x010b
            r11 = 8
            r10.f(r8, r9, r3, r11)
            int r6 = java.lang.Math.max(r6, r3)
        L_0x010b:
            if (r4 <= 0) goto L_0x0124
            if (r31 == 0) goto L_0x0114
            r11 = 1
            if (r14 != r11) goto L_0x0114
            r11 = 0
            goto L_0x0115
        L_0x0114:
            r11 = 1
        L_0x0115:
            if (r11 == 0) goto L_0x011d
            r11 = 8
            r10.g(r8, r9, r4, r11)
            goto L_0x011f
        L_0x011d:
            r11 = 8
        L_0x011f:
            int r6 = java.lang.Math.min(r6, r4)
            goto L_0x0126
        L_0x0124:
            r11 = 8
        L_0x0126:
            r12 = 1
            if (r14 != r12) goto L_0x0137
            if (r31 == 0) goto L_0x012f
            r10.e(r8, r9, r6, r11)
            goto L_0x00c9
        L_0x012f:
            r5 = 5
            r10.e(r8, r9, r6, r5)
            r10.g(r8, r9, r6, r11)
            goto L_0x00c9
        L_0x0137:
            r6 = 2
            if (r14 != r6) goto L_0x0198
            u.d r6 = u.d.TOP
            u.d r11 = u.d.BOTTOM
            u.d r12 = r13.f15075e
            if (r12 == r6) goto L_0x015a
            if (r12 != r11) goto L_0x0145
            goto L_0x015a
        L_0x0145:
            u.f r6 = r0.U
            u.d r11 = u.d.LEFT
            u.e r6 = r6.j(r11)
            s.j r6 = r10.l(r6)
            u.f r11 = r0.U
            u.d r12 = u.d.RIGHT
            u.e r11 = r11.j(r12)
            goto L_0x016a
        L_0x015a:
            u.f r12 = r0.U
            u.e r6 = r12.j(r6)
            s.j r6 = r10.l(r6)
            u.f r12 = r0.U
            u.e r11 = r12.j(r11)
        L_0x016a:
            s.j r11 = r10.l(r11)
            s.c r12 = r29.m()
            s.b r1 = r12.f13927d
            r23 = r2
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1.b(r8, r2)
            s.b r1 = r12.f13927d
            r2 = 1065353216(0x3f800000, float:1.0)
            r1.b(r9, r2)
            s.b r1 = r12.f13927d
            r1.b(r11, r5)
            s.b r1 = r12.f13927d
            float r2 = -r5
            r1.b(r6, r2)
            r10.c(r12)
            if (r31 == 0) goto L_0x0194
            r21 = 0
        L_0x0194:
            r11 = r33
            goto L_0x00cd
        L_0x0198:
            r23 = r2
            r12 = r3
            r11 = 1
        L_0x019c:
            if (r55 == 0) goto L_0x04b5
            if (r47 == 0) goto L_0x01a2
            goto L_0x04b5
        L_0x01a2:
            if (r16 != 0) goto L_0x01b2
            if (r17 != 0) goto L_0x01b2
            if (r22 != 0) goto L_0x01b2
            r14 = r39
            r5 = r8
            r33 = r11
            r2 = r19
        L_0x01af:
            r3 = 5
            goto L_0x049a
        L_0x01b2:
            if (r16 == 0) goto L_0x01d0
            if (r17 != 0) goto L_0x01d0
            u.e r1 = r13.f15076f
            u.f r1 = r1.f15074d
            if (r31 == 0) goto L_0x01c3
            boolean r1 = r1 instanceof u.a
            if (r1 == 0) goto L_0x01c3
            r1 = 8
            goto L_0x01c4
        L_0x01c3:
            r1 = 5
        L_0x01c4:
            r14 = r39
            r5 = r8
            r33 = r11
            r2 = r19
            r11 = r1
            r1 = r31
            goto L_0x049d
        L_0x01d0:
            if (r16 != 0) goto L_0x01eb
            if (r17 == 0) goto L_0x01eb
            int r1 = r39.e()
            int r1 = -r1
            r6 = r19
            r2 = 8
            r10.e(r8, r6, r1, r2)
            if (r31 == 0) goto L_0x0492
            r5 = r34
            r1 = 5
            r2 = 0
            r10.f(r9, r5, r2, r1)
            goto L_0x0492
        L_0x01eb:
            r5 = r34
            r6 = r19
            r1 = -1
            if (r16 == 0) goto L_0x0492
            if (r17 == 0) goto L_0x0492
            u.e r2 = r13.f15076f
            u.f r3 = r2.f15074d
            r2 = r39
            u.e r1 = r2.f15076f
            u.f r1 = r1.f15074d
            u.f r13 = r0.U
            r16 = 6
            if (r21 == 0) goto L_0x02fd
            if (r14 != 0) goto L_0x025a
            if (r4 != 0) goto L_0x022f
            if (r12 != 0) goto L_0x022f
            boolean r4 = r7.f13964m
            if (r4 == 0) goto L_0x0224
            boolean r4 = r6.f13964m
            if (r4 == 0) goto L_0x0224
            int r1 = r38.e()
            r3 = 8
            r10.e(r9, r7, r1, r3)
            int r1 = r39.e()
            int r1 = -r1
            r10.e(r8, r6, r1, r3)
            return
        L_0x0224:
            r30 = 8
            r17 = 8
            r19 = 0
            r22 = 1
            r23 = 0
            goto L_0x0239
        L_0x022f:
            r30 = 5
            r17 = 5
            r19 = 1
            r22 = 0
            r23 = 1
        L_0x0239:
            boolean r4 = r3 instanceof u.a
            if (r4 != 0) goto L_0x024e
            boolean r4 = r1 instanceof u.a
            if (r4 == 0) goto L_0x0242
            goto L_0x024e
        L_0x0242:
            r15 = r17
            r24 = r22
            r4 = 6
            r17 = r14
            r22 = r19
            r19 = r30
            goto L_0x0282
        L_0x024e:
            r15 = r17
            r24 = r22
            r4 = 6
            r17 = r14
            r22 = r19
            r19 = 4
            goto L_0x0282
        L_0x025a:
            r15 = 2
            if (r14 != r15) goto L_0x0272
            boolean r4 = r3 instanceof u.a
            if (r4 != 0) goto L_0x026d
            boolean r4 = r1 instanceof u.a
            if (r4 == 0) goto L_0x0266
            goto L_0x026d
        L_0x0266:
            r17 = r14
            r4 = 6
            r15 = 5
            r19 = 5
            goto L_0x027c
        L_0x026d:
            r17 = r14
            r4 = 6
            r15 = 5
            goto L_0x027a
        L_0x0272:
            r15 = 1
            if (r14 != r15) goto L_0x0286
            r17 = r14
            r4 = 6
            r15 = 8
        L_0x027a:
            r19 = 4
        L_0x027c:
            r22 = 1
            r23 = 1
            r24 = 0
        L_0x0282:
            r14 = r35
            goto L_0x034b
        L_0x0286:
            r15 = 3
            if (r14 != r15) goto L_0x02f0
            int r15 = r0.B
            r17 = r14
            r14 = -1
            if (r15 != r14) goto L_0x02a8
            r14 = r35
            if (r48 == 0) goto L_0x029a
            if (r31 == 0) goto L_0x0298
            r4 = 5
            goto L_0x029c
        L_0x0298:
            r4 = 4
            goto L_0x029c
        L_0x029a:
            r4 = 8
        L_0x029c:
            r15 = 8
        L_0x029e:
            r19 = 5
        L_0x02a0:
            r22 = 1
            r23 = 1
            r24 = 1
            goto L_0x034b
        L_0x02a8:
            if (r45 == 0) goto L_0x02c9
            r14 = r51
            r15 = 2
            if (r14 == r15) goto L_0x02b5
            r4 = 1
            if (r14 != r4) goto L_0x02b3
            goto L_0x02b5
        L_0x02b3:
            r4 = 0
            goto L_0x02b6
        L_0x02b5:
            r4 = 1
        L_0x02b6:
            if (r4 != 0) goto L_0x02bc
            r4 = 8
            r14 = 5
            goto L_0x02be
        L_0x02bc:
            r4 = 5
            r14 = 4
        L_0x02be:
            r15 = r4
            r19 = r14
            r4 = 6
            r22 = 1
            r23 = 1
            r24 = 1
            goto L_0x0282
        L_0x02c9:
            if (r4 <= 0) goto L_0x02d0
            r14 = r35
            r4 = 6
            r15 = 5
            goto L_0x029e
        L_0x02d0:
            if (r4 != 0) goto L_0x02e9
            if (r12 != 0) goto L_0x02e9
            if (r48 != 0) goto L_0x02dd
            r14 = r35
            r4 = 6
            r15 = 5
            r19 = 8
            goto L_0x02a0
        L_0x02dd:
            if (r3 == r13) goto L_0x02e3
            if (r1 == r13) goto L_0x02e3
            r4 = 4
            goto L_0x02e4
        L_0x02e3:
            r4 = 5
        L_0x02e4:
            r14 = r35
            r15 = r4
            r4 = 6
            goto L_0x02ed
        L_0x02e9:
            r14 = r35
            r4 = 6
            r15 = 5
        L_0x02ed:
            r19 = 4
            goto L_0x02a0
        L_0x02f0:
            r17 = r14
            r14 = r35
            r4 = 6
            r15 = 5
            r19 = 4
            r22 = 0
            r23 = 0
            goto L_0x0349
        L_0x02fd:
            r17 = r14
            boolean r4 = r7.f13964m
            if (r4 == 0) goto L_0x033f
            boolean r4 = r6.f13964m
            if (r4 == 0) goto L_0x033f
            int r1 = r38.e()
            int r3 = r39.e()
            r4 = 8
            r45 = r29
            r46 = r9
            r47 = r7
            r48 = r1
            r49 = r44
            r50 = r6
            r51 = r8
            r52 = r3
            r53 = r4
            r45.b(r46, r47, r48, r49, r50, r51, r52, r53)
            if (r31 == 0) goto L_0x033e
            if (r11 == 0) goto L_0x033e
            u.e r1 = r2.f15076f
            if (r1 == 0) goto L_0x0335
            int r11 = r39.e()
            r14 = r35
            goto L_0x0338
        L_0x0335:
            r14 = r35
            r11 = 0
        L_0x0338:
            if (r6 == r14) goto L_0x033e
            r1 = 5
            r10.f(r14, r8, r11, r1)
        L_0x033e:
            return
        L_0x033f:
            r14 = r35
            r4 = 6
            r15 = 5
            r19 = 4
            r22 = 1
            r23 = 1
        L_0x0349:
            r24 = 0
        L_0x034b:
            if (r23 == 0) goto L_0x0356
            if (r7 != r6) goto L_0x0356
            if (r3 == r13) goto L_0x0356
            r23 = 0
            r25 = 0
            goto L_0x035a
        L_0x0356:
            r25 = r23
            r23 = 1
        L_0x035a:
            if (r22 == 0) goto L_0x03a7
            if (r21 != 0) goto L_0x036e
            if (r46 != 0) goto L_0x036e
            if (r48 != 0) goto L_0x036e
            if (r7 != r5) goto L_0x036e
            if (r6 != r14) goto L_0x036e
            r15 = 0
            r22 = 8
            r23 = 8
            r26 = 0
            goto L_0x0376
        L_0x036e:
            r22 = r15
            r26 = r23
            r15 = r31
            r23 = r4
        L_0x0376:
            int r4 = r38.e()
            int r27 = r39.e()
            r30 = r15
            r14 = 3
            r15 = r1
            r1 = r29
            r14 = r2
            r2 = r9
            r33 = r11
            r11 = r3
            r3 = r7
            r36 = r12
            r12 = r5
            r5 = r44
            r37 = r6
            r12 = r7
            r7 = r8
            r43 = r13
            r13 = r8
            r8 = r27
            r27 = r13
            r13 = r9
            r9 = r23
            r1.b(r2, r3, r4, r5, r6, r7, r8, r9)
            r1 = r30
            r4 = r22
            r23 = r26
            goto L_0x03b9
        L_0x03a7:
            r14 = r2
            r37 = r6
            r27 = r8
            r33 = r11
            r36 = r12
            r43 = r13
            r4 = r15
            r15 = r1
            r11 = r3
            r12 = r7
            r13 = r9
            r1 = r31
        L_0x03b9:
            int r2 = r0.f15095h0
            r3 = 8
            if (r2 != r3) goto L_0x03d0
            java.util.HashSet r2 = r14.f15071a
            if (r2 != 0) goto L_0x03c4
            goto L_0x03cc
        L_0x03c4:
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x03cc
            r2 = 1
            goto L_0x03cd
        L_0x03cc:
            r2 = 0
        L_0x03cd:
            if (r2 != 0) goto L_0x03d0
            return
        L_0x03d0:
            r2 = r37
            if (r25 == 0) goto L_0x03f5
            if (r1 == 0) goto L_0x03e3
            if (r12 == r2) goto L_0x03e3
            if (r21 != 0) goto L_0x03e3
            boolean r3 = r11 instanceof u.a
            if (r3 != 0) goto L_0x03e2
            boolean r3 = r15 instanceof u.a
            if (r3 == 0) goto L_0x03e3
        L_0x03e2:
            r4 = 6
        L_0x03e3:
            int r3 = r38.e()
            r10.f(r13, r12, r3, r4)
            int r3 = r39.e()
            int r3 = -r3
            r5 = r27
            r10.g(r5, r2, r3, r4)
            goto L_0x03f7
        L_0x03f5:
            r5 = r27
        L_0x03f7:
            if (r1 == 0) goto L_0x040c
            if (r49 == 0) goto L_0x040c
            boolean r3 = r11 instanceof u.a
            if (r3 != 0) goto L_0x040c
            boolean r3 = r15 instanceof u.a
            if (r3 != 0) goto L_0x040c
            r3 = r43
            if (r15 == r3) goto L_0x040e
            r4 = 6
            r6 = 6
            r20 = 1
            goto L_0x0412
        L_0x040c:
            r3 = r43
        L_0x040e:
            r6 = r19
            r20 = r23
        L_0x0412:
            if (r20 == 0) goto L_0x0461
            if (r24 == 0) goto L_0x043f
            if (r48 == 0) goto L_0x041a
            if (r32 == 0) goto L_0x043f
        L_0x041a:
            if (r11 == r3) goto L_0x0421
            if (r15 != r3) goto L_0x041f
            goto L_0x0421
        L_0x041f:
            r16 = r6
        L_0x0421:
            boolean r7 = r11 instanceof u.j
            if (r7 != 0) goto L_0x0429
            boolean r7 = r15 instanceof u.j
            if (r7 == 0) goto L_0x042b
        L_0x0429:
            r16 = 5
        L_0x042b:
            boolean r7 = r11 instanceof u.a
            if (r7 != 0) goto L_0x0433
            boolean r7 = r15 instanceof u.a
            if (r7 == 0) goto L_0x0435
        L_0x0433:
            r16 = 5
        L_0x0435:
            if (r48 == 0) goto L_0x0439
            r7 = 5
            goto L_0x043b
        L_0x0439:
            r7 = r16
        L_0x043b:
            int r6 = java.lang.Math.max(r7, r6)
        L_0x043f:
            if (r1 == 0) goto L_0x0451
            int r4 = java.lang.Math.min(r4, r6)
            if (r45 == 0) goto L_0x044f
            if (r48 != 0) goto L_0x044f
            if (r11 == r3) goto L_0x044d
            if (r15 != r3) goto L_0x044f
        L_0x044d:
            r11 = 4
            goto L_0x0452
        L_0x044f:
            r11 = r4
            goto L_0x0452
        L_0x0451:
            r11 = r6
        L_0x0452:
            int r3 = r38.e()
            r10.e(r13, r12, r3, r11)
            int r3 = r39.e()
            int r3 = -r3
            r10.e(r5, r2, r3, r11)
        L_0x0461:
            if (r1 == 0) goto L_0x0474
            r3 = r34
            r4 = r12
            if (r3 != r4) goto L_0x046d
            int r6 = r38.e()
            goto L_0x046e
        L_0x046d:
            r6 = 0
        L_0x046e:
            if (r4 == r3) goto L_0x0474
            r4 = 5
            r10.f(r13, r3, r6, r4)
        L_0x0474:
            if (r1 == 0) goto L_0x0490
            if (r21 == 0) goto L_0x0490
            if (r42 != 0) goto L_0x0490
            if (r36 != 0) goto L_0x0490
            if (r21 == 0) goto L_0x048a
            r3 = r17
            r4 = 3
            if (r3 != r4) goto L_0x048a
            r3 = 8
            r4 = 0
            r10.f(r5, r13, r4, r3)
            goto L_0x0490
        L_0x048a:
            r4 = 0
            r3 = 5
            r10.f(r5, r13, r4, r3)
            goto L_0x049c
        L_0x0490:
            r3 = 5
            goto L_0x049c
        L_0x0492:
            r14 = r39
            r2 = r6
            r5 = r8
            r33 = r11
            goto L_0x01af
        L_0x049a:
            r1 = r31
        L_0x049c:
            r11 = 5
        L_0x049d:
            if (r1 == 0) goto L_0x04b4
            if (r33 == 0) goto L_0x04b4
            u.e r1 = r14.f15076f
            if (r1 == 0) goto L_0x04ac
            int r1 = r39.e()
            r4 = r35
            goto L_0x04af
        L_0x04ac:
            r4 = r35
            r1 = 0
        L_0x04af:
            if (r2 == r4) goto L_0x04b4
            r10.f(r4, r5, r1, r11)
        L_0x04b4:
            return
        L_0x04b5:
            r3 = r34
            r4 = r35
            r5 = r8
            r13 = r9
            r33 = r11
            r1 = r23
            r2 = 3
            r6 = 2
            if (r1 >= r6) goto L_0x04ff
            if (r31 == 0) goto L_0x04ff
            if (r33 == 0) goto L_0x04ff
            r1 = 8
            r6 = 0
            r10.f(r13, r3, r6, r1)
            u.e r1 = r0.N
            if (r30 != 0) goto L_0x04d8
            u.e r3 = r1.f15076f
            if (r3 != 0) goto L_0x04d6
            goto L_0x04d8
        L_0x04d6:
            r11 = 0
            goto L_0x04d9
        L_0x04d8:
            r11 = 1
        L_0x04d9:
            if (r30 != 0) goto L_0x04f7
            u.e r1 = r1.f15076f
            if (r1 == 0) goto L_0x04f7
            u.f r1 = r1.f15074d
            float r3 = r1.X
            r6 = 0
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 == 0) goto L_0x04f6
            int[] r1 = r1.f15113q0
            r3 = 0
            r6 = r1[r3]
            if (r6 != r2) goto L_0x04f6
            r3 = 1
            r1 = r1[r3]
            if (r1 != r2) goto L_0x04f6
            r11 = 1
            goto L_0x04f7
        L_0x04f6:
            r11 = 0
        L_0x04f7:
            if (r11 == 0) goto L_0x04ff
            r1 = 8
            r2 = 0
            r10.f(r4, r5, r2, r1)
        L_0x04ff:
            return
        L_0x0500:
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: u.f.e(s.e, boolean, boolean, boolean, boolean, s.j, s.j, int, boolean, u.e, u.e, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x013a, code lost:
        if (r13 != null) goto L_0x018d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0161, code lost:
        if (r13.h() != false) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0188, code lost:
        if (r13.h() != false) goto L_0x018a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(u.d r11, u.f r12, u.d r13, int r14) {
        /*
            r10 = this;
            u.d r0 = u.d.CENTER
            u.d r1 = u.d.CENTER_Y
            u.d r2 = u.d.CENTER_X
            u.d r3 = u.d.LEFT
            u.d r4 = u.d.TOP
            u.d r5 = u.d.RIGHT
            u.d r6 = u.d.BOTTOM
            r7 = 0
            if (r11 != r0) goto L_0x0097
            if (r13 != r0) goto L_0x007b
            u.e r11 = r10.j(r3)
            u.e r13 = r10.j(r5)
            u.e r14 = r10.j(r4)
            u.e r8 = r10.j(r6)
            r9 = 1
            if (r11 == 0) goto L_0x002c
            boolean r11 = r11.h()
            if (r11 != 0) goto L_0x0034
        L_0x002c:
            if (r13 == 0) goto L_0x0036
            boolean r11 = r13.h()
            if (r11 == 0) goto L_0x0036
        L_0x0034:
            r11 = 0
            goto L_0x003d
        L_0x0036:
            r10.f(r3, r12, r3, r7)
            r10.f(r5, r12, r5, r7)
            r11 = 1
        L_0x003d:
            if (r14 == 0) goto L_0x0045
            boolean r13 = r14.h()
            if (r13 != 0) goto L_0x004d
        L_0x0045:
            if (r8 == 0) goto L_0x004f
            boolean r13 = r8.h()
            if (r13 == 0) goto L_0x004f
        L_0x004d:
            r9 = 0
            goto L_0x0055
        L_0x004f:
            r10.f(r4, r12, r4, r7)
            r10.f(r6, r12, r6, r7)
        L_0x0055:
            if (r11 == 0) goto L_0x0063
            if (r9 == 0) goto L_0x0063
            u.e r11 = r10.j(r0)
            u.e r12 = r12.j(r0)
            goto L_0x0116
        L_0x0063:
            if (r11 == 0) goto L_0x006f
            u.e r11 = r10.j(r2)
            u.e r12 = r12.j(r2)
            goto L_0x0116
        L_0x006f:
            if (r9 == 0) goto L_0x0193
            u.e r11 = r10.j(r1)
            u.e r12 = r12.j(r1)
            goto L_0x0116
        L_0x007b:
            if (r13 == r3) goto L_0x008b
            if (r13 != r5) goto L_0x0080
            goto L_0x008b
        L_0x0080:
            if (r13 == r4) goto L_0x0084
            if (r13 != r6) goto L_0x0193
        L_0x0084:
            r10.f(r4, r12, r13, r7)
            r10.f(r6, r12, r13, r7)
            goto L_0x0091
        L_0x008b:
            r10.f(r3, r12, r13, r7)
            r10.f(r5, r12, r13, r7)     // Catch:{ all -> 0x0194 }
        L_0x0091:
            u.e r11 = r10.j(r0)
            goto L_0x0112
        L_0x0097:
            if (r11 != r2) goto L_0x00b4
            if (r13 == r3) goto L_0x009d
            if (r13 != r5) goto L_0x00b4
        L_0x009d:
            u.e r11 = r10.j(r3)
            u.e r12 = r12.j(r13)
            u.e r13 = r10.j(r5)
            r11.a(r12, r7)
            r13.a(r12, r7)
            u.e r11 = r10.j(r2)
            goto L_0x0116
        L_0x00b4:
            if (r11 != r1) goto L_0x00d5
            if (r13 == r4) goto L_0x00ba
            if (r13 != r6) goto L_0x00d5
        L_0x00ba:
            u.e r11 = r12.j(r13)
            u.e r12 = r10.j(r4)
            r12.a(r11, r7)
            u.e r12 = r10.j(r6)
            r12.a(r11, r7)
            u.e r12 = r10.j(r1)
            r12.a(r11, r7)
            goto L_0x0193
        L_0x00d5:
            if (r11 != r2) goto L_0x00f4
            if (r13 != r2) goto L_0x00f4
            u.e r11 = r10.j(r3)
            u.e r14 = r12.j(r3)
            r11.a(r14, r7)
            u.e r11 = r10.j(r5)
            u.e r14 = r12.j(r5)
            r11.a(r14, r7)
            u.e r11 = r10.j(r2)
            goto L_0x0112
        L_0x00f4:
            if (r11 != r1) goto L_0x011b
            if (r13 != r1) goto L_0x011b
            u.e r11 = r10.j(r4)
            u.e r14 = r12.j(r4)
            r11.a(r14, r7)
            u.e r11 = r10.j(r6)
            u.e r14 = r12.j(r6)
            r11.a(r14, r7)
            u.e r11 = r10.j(r1)
        L_0x0112:
            u.e r12 = r12.j(r13)
        L_0x0116:
            r11.a(r12, r7)
            goto L_0x0193
        L_0x011b:
            u.e r7 = r10.j(r11)
            u.e r12 = r12.j(r13)
            boolean r13 = r7.i(r12)
            if (r13 == 0) goto L_0x0193
            u.d r13 = u.d.BASELINE
            if (r11 != r13) goto L_0x013d
            u.e r11 = r10.j(r4)
            u.e r13 = r10.j(r6)
            if (r11 == 0) goto L_0x013a
            r11.j()
        L_0x013a:
            if (r13 == 0) goto L_0x0190
            goto L_0x018d
        L_0x013d:
            if (r11 == r4) goto L_0x0164
            if (r11 != r6) goto L_0x0142
            goto L_0x0164
        L_0x0142:
            if (r11 == r3) goto L_0x0146
            if (r11 != r5) goto L_0x0190
        L_0x0146:
            u.e r13 = r10.j(r0)
            u.e r0 = r13.f15076f
            if (r0 == r12) goto L_0x0151
            r13.j()
        L_0x0151:
            u.e r11 = r10.j(r11)
            u.e r11 = r11.f()
            u.e r13 = r10.j(r2)
            boolean r0 = r13.h()
            if (r0 == 0) goto L_0x0190
            goto L_0x018a
        L_0x0164:
            u.e r13 = r10.j(r13)
            if (r13 == 0) goto L_0x016d
            r13.j()
        L_0x016d:
            u.e r13 = r10.j(r0)
            u.e r0 = r13.f15076f
            if (r0 == r12) goto L_0x0178
            r13.j()
        L_0x0178:
            u.e r11 = r10.j(r11)
            u.e r11 = r11.f()
            u.e r13 = r10.j(r1)
            boolean r0 = r13.h()
            if (r0 == 0) goto L_0x0190
        L_0x018a:
            r11.j()
        L_0x018d:
            r13.j()
        L_0x0190:
            r7.a(r12, r14)
        L_0x0193:
            return
        L_0x0194:
            r11 = move-exception
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: u.f.f(u.d, u.f, u.d, int):void");
    }

    public final void g(e eVar, e eVar2, int i10) {
        if (eVar.f15074d == this) {
            f(eVar.f15075e, eVar2.f15074d, eVar2.f15075e, i10);
        }
    }

    public final void h(e eVar) {
        eVar.l(this.J);
        eVar.l(this.K);
        eVar.l(this.L);
        eVar.l(this.M);
        if (this.f15083b0 > 0) {
            eVar.l(this.N);
        }
    }

    public final void i() {
        if (this.f15086d == null) {
            this.f15086d = new l(this);
        }
        if (this.f15088e == null) {
            this.f15088e = new n(this);
        }
    }

    public e j(d dVar) {
        switch (dVar.ordinal()) {
            case 0:
                return null;
            case 1:
                return this.J;
            case 2:
                return this.K;
            case 3:
                return this.L;
            case 4:
                return this.M;
            case Constants.MAX_COMPATIBILITY_VERSION:
                return this.N;
            case 6:
                return this.Q;
            case 7:
                return this.O;
            case 8:
                return this.P;
            default:
                throw new AssertionError(dVar.name());
        }
    }

    public final int k(int i10) {
        int[] iArr = this.f15113q0;
        if (i10 == 0) {
            return iArr[0];
        }
        if (i10 == 1) {
            return iArr[1];
        }
        return 0;
    }

    public final int l() {
        if (this.f15095h0 == 8) {
            return 0;
        }
        return this.W;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r3 = r2.M;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final u.f m(int r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x000f
            u.e r3 = r2.L
            u.e r0 = r3.f15076f
            if (r0 == 0) goto L_0x001f
            u.e r1 = r0.f15076f
            if (r1 != r3) goto L_0x001f
            u.f r3 = r0.f15074d
            return r3
        L_0x000f:
            r0 = 1
            if (r3 != r0) goto L_0x001f
            u.e r3 = r2.M
            u.e r0 = r3.f15076f
            if (r0 == 0) goto L_0x001f
            u.e r1 = r0.f15076f
            if (r1 != r3) goto L_0x001f
            u.f r3 = r0.f15074d
            return r3
        L_0x001f:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: u.f.m(int):u.f");
    }

    public void n(StringBuilder sb2) {
        sb2.append("  " + this.f15100k + ":{\n");
        StringBuilder sb3 = new StringBuilder("    actualWidth:");
        sb3.append(this.V);
        sb2.append(sb3.toString());
        sb2.append(Constants.WRITE_NEW_LINE);
        sb2.append("    actualHeight:" + this.W);
        sb2.append(Constants.WRITE_NEW_LINE);
        sb2.append("    actualLeft:" + this.Z);
        sb2.append(Constants.WRITE_NEW_LINE);
        sb2.append("    actualTop:" + this.f15081a0);
        sb2.append(Constants.WRITE_NEW_LINE);
        p(sb2, "left", this.J);
        p(sb2, "top", this.K);
        p(sb2, "right", this.L);
        p(sb2, "bottom", this.M);
        p(sb2, "baseline", this.N);
        p(sb2, "centerX", this.O);
        p(sb2, "centerY", this.P);
        int i10 = this.V;
        int i11 = this.f15085c0;
        int[] iArr = this.D;
        int i12 = iArr[0];
        int i13 = this.f15118v;
        int i14 = this.f15115s;
        float f10 = this.f15120x;
        float[] fArr = this.f15103l0;
        float f11 = fArr[0];
        o(sb2, "    width", i10, i11, i12, i13, i14, f10);
        int i15 = this.W;
        int i16 = this.f15087d0;
        int i17 = iArr[1];
        int i18 = this.f15121y;
        int i19 = this.f15116t;
        float f12 = this.A;
        float f13 = fArr[1];
        o(sb2, "    height", i15, i16, i17, i18, i19, f12);
        float f14 = this.X;
        int i20 = this.Y;
        if (f14 != 0.0f) {
            sb2.append("    dimensionRatio");
            sb2.append(" :  [");
            sb2.append(f14);
            sb2.append(",");
            sb2.append(i20);
            sb2.append("");
            sb2.append("],\n");
        }
        H(sb2, "    horizontalBias", this.f15089e0, 0.5f);
        H(sb2, "    verticalBias", this.f15091f0, 0.5f);
        G(this.f15099j0, 0, "    horizontalChainStyle", sb2);
        G(this.f15101k0, 0, "    verticalChainStyle", sb2);
        sb2.append("  }");
    }

    public final int q() {
        if (this.f15095h0 == 8) {
            return 0;
        }
        return this.V;
    }

    public final int r() {
        f fVar = this.U;
        return (fVar == null || !(fVar instanceof g)) ? this.Z : ((g) fVar).f15129y0 + this.Z;
    }

    public final int s() {
        f fVar = this.U;
        return (fVar == null || !(fVar instanceof g)) ? this.f15081a0 : ((g) fVar).f15130z0 + this.f15081a0;
    }

    public final boolean t(int i10) {
        if (i10 == 0) {
            return (this.J.f15076f != null ? 1 : 0) + (this.L.f15076f != null ? 1 : 0) < 2;
        }
        return ((this.K.f15076f != null ? 1 : 0) + (this.M.f15076f != null ? 1 : 0)) + (this.N.f15076f != null ? 1 : 0) < 2;
    }

    public String toString() {
        String str = "";
        StringBuilder q10 = h.q(str);
        if (this.f15097i0 != null) {
            str = h.p(new StringBuilder("id: "), this.f15097i0, " ");
        }
        q10.append(str);
        q10.append("(");
        q10.append(this.Z);
        q10.append(", ");
        q10.append(this.f15081a0);
        q10.append(") - (");
        q10.append(this.V);
        q10.append(" x ");
        return h.o(q10, this.W, ")");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        r2 = r5.M;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r2 = r5.L;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean u(int r6, int r7) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            if (r6 != 0) goto L_0x0032
            u.e r6 = r5.J
            u.e r2 = r6.f15076f
            if (r2 == 0) goto L_0x0060
            boolean r2 = r2.f15073c
            if (r2 == 0) goto L_0x0060
            u.e r2 = r5.L
            u.e r3 = r2.f15076f
            if (r3 == 0) goto L_0x0060
            boolean r4 = r3.f15073c
            if (r4 == 0) goto L_0x0060
            int r3 = r3.d()
            int r2 = r2.e()
            int r3 = r3 - r2
            u.e r2 = r6.f15076f
            int r2 = r2.d()
            int r6 = r6.e()
            int r6 = r6 + r2
            int r3 = r3 - r6
            if (r3 < r7) goto L_0x0030
            goto L_0x0031
        L_0x0030:
            r0 = 0
        L_0x0031:
            return r0
        L_0x0032:
            u.e r6 = r5.K
            u.e r2 = r6.f15076f
            if (r2 == 0) goto L_0x0060
            boolean r2 = r2.f15073c
            if (r2 == 0) goto L_0x0060
            u.e r2 = r5.M
            u.e r3 = r2.f15076f
            if (r3 == 0) goto L_0x0060
            boolean r4 = r3.f15073c
            if (r4 == 0) goto L_0x0060
            int r3 = r3.d()
            int r2 = r2.e()
            int r3 = r3 - r2
            u.e r2 = r6.f15076f
            int r2 = r2.d()
            int r6 = r6.e()
            int r6 = r6 + r2
            int r3 = r3 - r6
            if (r3 < r7) goto L_0x005e
            goto L_0x005f
        L_0x005e:
            r0 = 0
        L_0x005f:
            return r0
        L_0x0060:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: u.f.u(int, int):boolean");
    }

    public final void v(d dVar, f fVar, d dVar2, int i10, int i11) {
        j(dVar).b(fVar.j(dVar2), i10, i11, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r4 = r0[r4 + 1];
        r0 = r4.f15076f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean w(int r4) {
        /*
            r3 = this;
            int r4 = r4 * 2
            u.e[] r0 = r3.R
            r1 = r0[r4]
            u.e r2 = r1.f15076f
            if (r2 == 0) goto L_0x001b
            u.e r2 = r2.f15076f
            if (r2 == r1) goto L_0x001b
            r1 = 1
            int r4 = r4 + r1
            r4 = r0[r4]
            u.e r0 = r4.f15076f
            if (r0 == 0) goto L_0x001b
            u.e r0 = r0.f15076f
            if (r0 != r4) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r1 = 0
        L_0x001c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: u.f.w(int):boolean");
    }

    public final boolean x() {
        e eVar = this.J;
        e eVar2 = eVar.f15076f;
        if (eVar2 != null && eVar2.f15076f == eVar) {
            return true;
        }
        e eVar3 = this.L;
        e eVar4 = eVar3.f15076f;
        return eVar4 != null && eVar4.f15076f == eVar3;
    }

    public final boolean y() {
        e eVar = this.K;
        e eVar2 = eVar.f15076f;
        if (eVar2 != null && eVar2.f15076f == eVar) {
            return true;
        }
        e eVar3 = this.M;
        e eVar4 = eVar3.f15076f;
        return eVar4 != null && eVar4.f15076f == eVar3;
    }

    public final boolean z() {
        return this.f15092g && this.f15095h0 != 8;
    }
}
