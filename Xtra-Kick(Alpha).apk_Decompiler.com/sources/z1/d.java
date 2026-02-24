package z1;

import android.os.SystemClock;
import g1.a0;
import g1.v1;
import j1.a;
import j1.l0;
import java.util.Arrays;
import java.util.List;

public abstract class d implements s {

    /* renamed from: a  reason: collision with root package name */
    public final v1 f17387a;

    /* renamed from: b  reason: collision with root package name */
    public final int f17388b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f17389c;

    /* renamed from: d  reason: collision with root package name */
    public final a0[] f17390d;

    /* renamed from: e  reason: collision with root package name */
    public final long[] f17391e;

    /* renamed from: f  reason: collision with root package name */
    public int f17392f;

    public d(v1 v1Var, int[] iArr) {
        boolean z10;
        int i10 = 0;
        if (iArr.length > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.e(z10);
        v1Var.getClass();
        this.f17387a = v1Var;
        int length = iArr.length;
        this.f17388b = length;
        this.f17390d = new a0[length];
        for (int i11 = 0; i11 < iArr.length; i11++) {
            this.f17390d[i11] = v1Var.f6676k[iArr[i11]];
        }
        Arrays.sort(this.f17390d, new j0.a(1));
        this.f17389c = new int[this.f17388b];
        while (true) {
            int i12 = this.f17388b;
            if (i10 < i12) {
                this.f17389c[i10] = v1Var.i(this.f17390d[i10]);
                i10++;
            } else {
                this.f17391e = new long[i12];
                return;
            }
        }
    }

    public final boolean a(int i10, long j10) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean b10 = b(i10, elapsedRealtime);
        int i11 = 0;
        while (i11 < this.f17388b && !b10) {
            b10 = i11 != i10 && !b(i11, elapsedRealtime);
            i11++;
        }
        if (!b10) {
            return false;
        }
        long[] jArr = this.f17391e;
        long j11 = jArr[i10];
        int i12 = l0.f8453a;
        long j12 = elapsedRealtime + j10;
        if (((j10 ^ j12) & (elapsedRealtime ^ j12)) < 0) {
            j12 = Long.MAX_VALUE;
        }
        jArr[i10] = Math.max(j11, j12);
        return true;
    }

    public final boolean b(int i10, long j10) {
        return this.f17391e[i10] > j10;
    }

    public final /* synthetic */ void d(boolean z10) {
    }

    public final a0 e(int i10) {
        return this.f17390d[i10];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f17387a == dVar.f17387a && Arrays.equals(this.f17389c, dVar.f17389c);
    }

    public void f() {
    }

    public final int g(int i10) {
        return this.f17389c[i10];
    }

    public int h(long j10, List list) {
        return list.size();
    }

    public final int hashCode() {
        if (this.f17392f == 0) {
            this.f17392f = Arrays.hashCode(this.f17389c) + (System.identityHashCode(this.f17387a) * 31);
        }
        return this.f17392f;
    }

    public final /* synthetic */ boolean i(long j10, x1.a aVar, List list) {
        return false;
    }

    public void j() {
    }

    public final int k() {
        return this.f17389c[o()];
    }

    public final v1 l() {
        return this.f17387a;
    }

    public final int length() {
        return this.f17389c.length;
    }

    public final a0 m() {
        return this.f17390d[o()];
    }

    public void p(float f10) {
    }

    public final /* synthetic */ void r() {
    }

    public final /* synthetic */ void s() {
    }

    public final int t(int i10) {
        for (int i11 = 0; i11 < this.f17388b; i11++) {
            if (this.f17389c[i11] == i10) {
                return i11;
            }
        }
        return -1;
    }
}
