package f3;

import android.support.v4.media.n;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import d2.e0;
import d2.p;
import d2.s0;
import d2.u0;
import d2.v;
import d2.w;
import d2.y;
import g1.b1;
import g2.a;
import j1.b0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class h0 implements v {

    /* renamed from: a  reason: collision with root package name */
    public final int f5589a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5590b;

    /* renamed from: c  reason: collision with root package name */
    public final List f5591c;

    /* renamed from: d  reason: collision with root package name */
    public final b0 f5592d;

    /* renamed from: e  reason: collision with root package name */
    public final SparseIntArray f5593e;

    /* renamed from: f  reason: collision with root package name */
    public final h f5594f;

    /* renamed from: g  reason: collision with root package name */
    public final SparseArray f5595g;

    /* renamed from: h  reason: collision with root package name */
    public final SparseBooleanArray f5596h;

    /* renamed from: i  reason: collision with root package name */
    public final SparseBooleanArray f5597i;

    /* renamed from: j  reason: collision with root package name */
    public final f0 f5598j;

    /* renamed from: k  reason: collision with root package name */
    public a f5599k;

    /* renamed from: l  reason: collision with root package name */
    public y f5600l;

    /* renamed from: m  reason: collision with root package name */
    public int f5601m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f5602n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f5603o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f5604p;

    /* renamed from: q  reason: collision with root package name */
    public k0 f5605q;

    /* renamed from: r  reason: collision with root package name */
    public int f5606r;

    /* renamed from: s  reason: collision with root package name */
    public int f5607s;

    public h0() {
        this(1, new j1.h0(0), new h(0), 112800);
    }

    public final void a() {
    }

    public final void c(long j10, long j11) {
        a aVar;
        j1.a.e(this.f5589a != 2);
        List list = this.f5591c;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            j1.h0 h0Var = (j1.h0) list.get(i10);
            boolean z10 = h0Var.d() == -9223372036854775807L;
            if (!z10) {
                long c10 = h0Var.c();
                z10 = (c10 == -9223372036854775807L || c10 == 0 || c10 == j11) ? false : true;
            }
            if (z10) {
                h0Var.e(j11);
            }
        }
        if (!(j11 == 0 || (aVar = this.f5599k) == null)) {
            aVar.c(j11);
        }
        this.f5592d.D(0);
        this.f5593e.clear();
        int i11 = 0;
        while (true) {
            SparseArray sparseArray = this.f5595g;
            if (i11 < sparseArray.size()) {
                ((k0) sparseArray.valueAt(i11)).a();
                i11++;
            } else {
                this.f5606r = 0;
                return;
            }
        }
    }

    public final int d(w wVar, s0 s0Var) {
        int i10;
        boolean z10;
        boolean z11;
        int i11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        char c10;
        boolean z16;
        boolean z17;
        u0 u0Var;
        y yVar;
        int i12;
        long j10;
        long j11;
        boolean z18;
        w wVar2 = wVar;
        s0 s0Var2 = s0Var;
        long c11 = wVar.c();
        boolean z19 = this.f5602n;
        int i13 = this.f5589a;
        if (z19) {
            if (c11 == -1 || i13 == 2) {
                z16 = false;
            } else {
                z16 = true;
            }
            int i14 = i13;
            f0 f0Var = this.f5598j;
            if (!z16 || f0Var.f5554d) {
                if (!this.f5603o) {
                    this.f5603o = true;
                    long j12 = f0Var.f5559i;
                    if (j12 != -9223372036854775807L) {
                        z10 = false;
                        i10 = i14;
                        a aVar = new a(f0Var.f5552b, j12, c11, this.f5607s, this.f5590b);
                        this.f5599k = aVar;
                        yVar = this.f5600l;
                        u0Var = aVar.f4219a;
                    } else {
                        i10 = i14;
                        z10 = false;
                        yVar = this.f5600l;
                        u0Var = new e0(j12);
                    }
                    yVar.g(u0Var);
                } else {
                    i10 = i14;
                    z10 = false;
                }
                if (this.f5604p) {
                    this.f5604p = z10;
                    c(0, 0);
                    if (wVar.p() != 0) {
                        s0Var2.f4296a = 0;
                        return 1;
                    }
                }
                a aVar2 = this.f5599k;
                if (aVar2 != null) {
                    if (aVar2.f4221c != null) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        return aVar2.a(wVar2, s0Var2);
                    }
                }
            } else {
                int i15 = this.f5607s;
                if (i15 <= 0) {
                    f0Var.a(wVar2);
                    return 0;
                }
                boolean z20 = f0Var.f5556f;
                b0 b0Var = f0Var.f5553c;
                int i16 = f0Var.f5551a;
                if (!z20) {
                    long c12 = wVar.c();
                    int min = (int) Math.min((long) i16, c12);
                    long j13 = c12 - ((long) min);
                    if (wVar.p() != j13) {
                        s0Var2.f4296a = j13;
                    } else {
                        b0Var.D(min);
                        wVar.f();
                        wVar2.m(b0Var.f8414a, 0, min);
                        int i17 = b0Var.f8415b;
                        int i18 = b0Var.f8416c;
                        int i19 = i18 - 188;
                        while (true) {
                            if (i19 < i17) {
                                j11 = -9223372036854775807L;
                                break;
                            }
                            byte[] bArr = b0Var.f8414a;
                            int i20 = -4;
                            int i21 = 0;
                            while (true) {
                                if (i20 > 4) {
                                    z18 = false;
                                    break;
                                }
                                int i22 = (i20 * 188) + i19;
                                if (i22 < i17 || i22 >= i18 || bArr[i22] != 71) {
                                    i21 = 0;
                                } else {
                                    i21++;
                                    if (i21 == 5) {
                                        z18 = true;
                                        break;
                                    }
                                }
                                i20++;
                            }
                            if (z18) {
                                long a10 = l0.a(i19, i15, b0Var);
                                if (a10 != -9223372036854775807L) {
                                    j11 = a10;
                                    break;
                                }
                            }
                            i19--;
                        }
                        f0Var.f5558h = j11;
                        f0Var.f5556f = true;
                        i12 = 0;
                        return i12;
                    }
                } else {
                    if (f0Var.f5558h != -9223372036854775807L) {
                        if (!f0Var.f5555e) {
                            int min2 = (int) Math.min((long) i16, wVar.c());
                            long j14 = (long) 0;
                            if (wVar.p() != j14) {
                                s0Var2.f4296a = j14;
                            } else {
                                b0Var.D(min2);
                                wVar.f();
                                wVar2.m(b0Var.f8414a, 0, min2);
                                int i23 = b0Var.f8415b;
                                int i24 = b0Var.f8416c;
                                while (true) {
                                    if (i23 >= i24) {
                                        j10 = -9223372036854775807L;
                                        break;
                                    }
                                    if (b0Var.f8414a[i23] == 71) {
                                        long a11 = l0.a(i23, i15, b0Var);
                                        if (a11 != -9223372036854775807L) {
                                            j10 = a11;
                                            break;
                                        }
                                    }
                                    i23++;
                                }
                                f0Var.f5557g = j10;
                                f0Var.f5555e = true;
                                i12 = 0;
                                return i12;
                            }
                        } else {
                            long j15 = f0Var.f5557g;
                            if (j15 != -9223372036854775807L) {
                                j1.h0 h0Var = f0Var.f5552b;
                                long b10 = h0Var.b(f0Var.f5558h) - h0Var.b(j15);
                                f0Var.f5559i = b10;
                                if (b10 < 0) {
                                    j1.v.g("TsDurationReader", "Invalid duration: " + f0Var.f5559i + ". Using TIME_UNSET instead.");
                                    f0Var.f5559i = -9223372036854775807L;
                                }
                            }
                        }
                    }
                    f0Var.a(wVar2);
                    return 0;
                }
                i12 = 1;
                return i12;
            }
        } else {
            i10 = i13;
            z10 = false;
        }
        b0 b0Var2 = this.f5592d;
        byte[] bArr2 = b0Var2.f8414a;
        int i25 = b0Var2.f8415b;
        if (9400 - i25 < 188) {
            int i26 = b0Var2.f8416c - i25;
            if (i26 > 0) {
                System.arraycopy(bArr2, i25, bArr2, z10, i26);
            }
            b0Var2.E(i26, bArr2);
        }
        while (true) {
            int i27 = b0Var2.f8416c;
            if (i27 - b0Var2.f8415b >= 188) {
                z11 = true;
                break;
            }
            int o10 = wVar2.o(bArr2, i27, 9400 - i27);
            if (o10 == -1) {
                z11 = false;
                break;
            }
            b0Var2.F(i27 + o10);
        }
        if (!z11) {
            return -1;
        }
        int i28 = b0Var2.f8415b;
        int i29 = b0Var2.f8416c;
        byte[] bArr3 = b0Var2.f8414a;
        int i30 = i28;
        while (i30 < i29 && bArr3[i30] != 71) {
            i30++;
        }
        b0Var2.G(i30);
        int i31 = i30 + 188;
        k0 k0Var = null;
        if (i31 > i29) {
            int i32 = (i30 - i28) + this.f5606r;
            this.f5606r = i32;
            i11 = i10;
            if (i11 == 2 && i32 > 376) {
                throw b1.a("Cannot find sync byte. Most likely not a Transport Stream.", (Exception) null);
            }
        } else {
            i11 = i10;
            this.f5606r = z10;
        }
        int i33 = b0Var2.f8416c;
        if (i31 > i33) {
            return z10;
        }
        int f10 = b0Var2.f();
        if ((8388608 & f10) != 0) {
            b0Var2.G(i31);
            return z10;
        }
        if ((4194304 & f10) != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        boolean z21 = z12 | z10;
        int i34 = (2096896 & f10) >> 8;
        if ((f10 & 32) != 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        if ((f10 & 16) != 0) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z14) {
            k0Var = (k0) this.f5595g.get(i34);
        }
        if (k0Var == null) {
            b0Var2.G(i31);
            return z10;
        }
        if (i11 != 2) {
            int i35 = f10 & 15;
            SparseIntArray sparseIntArray = this.f5593e;
            int i36 = sparseIntArray.get(i34, i35 - 1);
            sparseIntArray.put(i34, i35);
            if (i36 == i35) {
                b0Var2.G(i31);
                return z10;
            } else if (i35 != ((i36 + 1) & 15)) {
                k0Var.a();
            }
        }
        if (z13) {
            int v10 = b0Var2.v();
            if ((b0Var2.v() & 64) != 0) {
                c10 = 2;
            } else {
                c10 = 0;
            }
            z21 |= c10;
            b0Var2.H(v10 - 1);
        }
        boolean z22 = this.f5602n;
        if (i11 == 2 || z22 || !this.f5597i.get(i34, z10)) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z15) {
            b0Var2.F(i31);
            k0Var.c(z21 ? 1 : 0, b0Var2);
            b0Var2.F(i33);
        }
        if (i11 != 2 && !z22 && this.f5602n && c11 != -1) {
            this.f5604p = true;
        }
        b0Var2.G(i31);
        return z10 ? 1 : 0;
    }

    public final void e(y yVar) {
        this.f5600l = yVar;
    }

    public final boolean h(w wVar) {
        boolean z10;
        byte[] bArr = this.f5592d.f8414a;
        p pVar = (p) wVar;
        pVar.k(bArr, 0, 940, false);
        for (int i10 = 0; i10 < 188; i10++) {
            int i11 = 0;
            while (true) {
                if (i11 >= 5) {
                    z10 = true;
                    break;
                } else if (bArr[(i11 * 188) + i10] != 71) {
                    z10 = false;
                    break;
                } else {
                    i11++;
                }
            }
            if (z10) {
                pVar.g(i10);
                return true;
            }
        }
        return false;
    }

    public h0(int i10, j1.h0 h0Var, h hVar, int i11) {
        this.f5594f = hVar;
        this.f5590b = i11;
        this.f5589a = i10;
        if (i10 == 1 || i10 == 2) {
            this.f5591c = Collections.singletonList(h0Var);
        } else {
            ArrayList arrayList = new ArrayList();
            this.f5591c = arrayList;
            arrayList.add(h0Var);
        }
        this.f5592d = new b0(0, new byte[9400]);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.f5596h = sparseBooleanArray;
        this.f5597i = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.f5595g = sparseArray;
        this.f5593e = new SparseIntArray();
        this.f5598j = new f0(i11);
        this.f5600l = y.f4307a;
        this.f5607s = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray sparseArray2 = new SparseArray();
        int size = sparseArray2.size();
        for (int i12 = 0; i12 < size; i12++) {
            sparseArray.put(sparseArray2.keyAt(i12), (k0) sparseArray2.valueAt(i12));
        }
        sparseArray.put(0, new e0(new n(this)));
        this.f5605q = null;
    }
}
