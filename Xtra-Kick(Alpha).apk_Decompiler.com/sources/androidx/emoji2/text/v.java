package androidx.emoji2.text;

import android.util.SparseArray;
import java.util.Arrays;
import v0.a;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    public int f1286a = 1;

    /* renamed from: b  reason: collision with root package name */
    public final d0 f1287b;

    /* renamed from: c  reason: collision with root package name */
    public d0 f1288c;

    /* renamed from: d  reason: collision with root package name */
    public d0 f1289d;

    /* renamed from: e  reason: collision with root package name */
    public int f1290e;

    /* renamed from: f  reason: collision with root package name */
    public int f1291f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f1292g;

    /* renamed from: h  reason: collision with root package name */
    public final int[] f1293h;

    public v(d0 d0Var, boolean z10, int[] iArr) {
        this.f1287b = d0Var;
        this.f1288c = d0Var;
        this.f1292g = z10;
        this.f1293h = iArr;
    }

    public final int a(int i10) {
        d0 d0Var;
        boolean z10;
        SparseArray sparseArray = this.f1288c.f1247a;
        if (sparseArray == null) {
            d0Var = null;
        } else {
            d0Var = (d0) sparseArray.get(i10);
        }
        int i11 = 2;
        if (this.f1286a == 2) {
            if (d0Var != null) {
                this.f1288c = d0Var;
                this.f1291f++;
            } else {
                boolean z11 = false;
                if (i10 == 65038) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    if (i10 == 65039) {
                        z11 = true;
                    }
                    if (!z11) {
                        d0 d0Var2 = this.f1288c;
                        if (d0Var2.f1248b != null) {
                            if (this.f1291f == 1) {
                                if (c()) {
                                    d0Var2 = this.f1288c;
                                }
                            }
                            this.f1289d = d0Var2;
                            b();
                            i11 = 3;
                        }
                    }
                }
            }
            this.f1290e = i10;
            return i11;
        } else if (d0Var != null) {
            this.f1286a = 2;
            this.f1288c = d0Var;
            this.f1291f = 1;
            this.f1290e = i10;
            return i11;
        }
        b();
        i11 = 1;
        this.f1290e = i10;
        return i11;
    }

    public final void b() {
        this.f1286a = 1;
        this.f1288c = this.f1287b;
        this.f1291f = 0;
    }

    public final boolean c() {
        boolean z10;
        boolean z11;
        int[] iArr;
        a d10 = this.f1288c.f1248b.d();
        int a10 = d10.a(6);
        if (a10 == 0 || d10.f15552b.get(a10 + d10.f15551a) == 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            return true;
        }
        if (this.f1290e == 65039) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return true;
        }
        if (!this.f1292g || ((iArr = this.f1293h) != null && Arrays.binarySearch(iArr, this.f1288c.f1248b.a(0)) >= 0)) {
            return false;
        }
        return true;
    }
}
