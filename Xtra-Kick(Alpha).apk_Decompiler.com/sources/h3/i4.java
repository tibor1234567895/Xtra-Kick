package h3;

import android.os.Bundle;
import g1.j1;
import g1.m;
import g1.s0;
import j1.a;
import j1.l0;
import java.util.Arrays;

public final class i4 implements m {
    public static final String A = l0.C(7);
    public static final String B = l0.C(8);
    public static final String C = l0.C(9);
    public static final j3 D = new j3(13);

    /* renamed from: r  reason: collision with root package name */
    public static final j1 f7108r;

    /* renamed from: s  reason: collision with root package name */
    public static final i4 f7109s;

    /* renamed from: t  reason: collision with root package name */
    public static final String f7110t = l0.C(0);

    /* renamed from: u  reason: collision with root package name */
    public static final String f7111u = l0.C(1);

    /* renamed from: v  reason: collision with root package name */
    public static final String f7112v = l0.C(2);

    /* renamed from: w  reason: collision with root package name */
    public static final String f7113w = l0.C(3);

    /* renamed from: x  reason: collision with root package name */
    public static final String f7114x = l0.C(4);

    /* renamed from: y  reason: collision with root package name */
    public static final String f7115y = l0.C(5);

    /* renamed from: z  reason: collision with root package name */
    public static final String f7116z = l0.C(6);

    /* renamed from: h  reason: collision with root package name */
    public final j1 f7117h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f7118i;

    /* renamed from: j  reason: collision with root package name */
    public final long f7119j;

    /* renamed from: k  reason: collision with root package name */
    public final long f7120k;

    /* renamed from: l  reason: collision with root package name */
    public final long f7121l;

    /* renamed from: m  reason: collision with root package name */
    public final int f7122m;

    /* renamed from: n  reason: collision with root package name */
    public final long f7123n;

    /* renamed from: o  reason: collision with root package name */
    public final long f7124o;

    /* renamed from: p  reason: collision with root package name */
    public final long f7125p;

    /* renamed from: q  reason: collision with root package name */
    public final long f7126q;

    static {
        j1 j1Var = r0;
        j1 j1Var2 = new j1((Object) null, 0, (s0) null, (Object) null, 0, 0, 0, -1, -1);
        f7108r = j1Var2;
        f7109s = new i4(j1Var, false, -9223372036854775807L, -9223372036854775807L, 0, 0, 0, -9223372036854775807L, -9223372036854775807L, 0);
    }

    public i4(j1 j1Var, boolean z10, long j10, long j11, long j12, int i10, long j13, long j14, long j15, long j16) {
        j1 j1Var2 = j1Var;
        boolean z11 = z10;
        a.b(z11 != (j1Var2.f6437o != -1) ? false : true);
        this.f7117h = j1Var2;
        this.f7118i = z11;
        this.f7119j = j10;
        this.f7120k = j11;
        this.f7121l = j12;
        this.f7122m = i10;
        this.f7123n = j13;
        this.f7124o = j14;
        this.f7125p = j15;
        this.f7126q = j16;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i4.class != obj.getClass()) {
            return false;
        }
        i4 i4Var = (i4) obj;
        return this.f7117h.equals(i4Var.f7117h) && this.f7118i == i4Var.f7118i && this.f7119j == i4Var.f7119j && this.f7120k == i4Var.f7120k && this.f7121l == i4Var.f7121l && this.f7122m == i4Var.f7122m && this.f7123n == i4Var.f7123n && this.f7124o == i4Var.f7124o && this.f7125p == i4Var.f7125p && this.f7126q == i4Var.f7126q;
    }

    public final Bundle h() {
        return i(true, true);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f7117h, Boolean.valueOf(this.f7118i)});
    }

    public final Bundle i(boolean z10, boolean z11) {
        Bundle bundle = new Bundle();
        bundle.putBundle(f7110t, this.f7117h.i(z10, z11));
        int i10 = 0;
        bundle.putBoolean(f7111u, z10 && this.f7118i);
        bundle.putLong(f7112v, this.f7119j);
        long j10 = -9223372036854775807L;
        bundle.putLong(f7113w, z10 ? this.f7120k : -9223372036854775807L);
        long j11 = 0;
        bundle.putLong(f7114x, z10 ? this.f7121l : 0);
        if (z10) {
            i10 = this.f7122m;
        }
        bundle.putInt(f7115y, i10);
        bundle.putLong(f7116z, z10 ? this.f7123n : 0);
        bundle.putLong(A, z10 ? this.f7124o : -9223372036854775807L);
        if (z10) {
            j10 = this.f7125p;
        }
        bundle.putLong(B, j10);
        if (z10) {
            j11 = this.f7126q;
        }
        bundle.putLong(C, j11);
        return bundle;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("SessionPositionInfo {PositionInfo {mediaItemIndex=");
        j1 j1Var = this.f7117h;
        sb2.append(j1Var.f6431i);
        sb2.append(", periodIndex=");
        sb2.append(j1Var.f6434l);
        sb2.append(", positionMs=");
        sb2.append(j1Var.f6435m);
        sb2.append(", contentPositionMs=");
        sb2.append(j1Var.f6436n);
        sb2.append(", adGroupIndex=");
        sb2.append(j1Var.f6437o);
        sb2.append(", adIndexInAdGroup=");
        sb2.append(j1Var.f6438p);
        sb2.append("}, isPlayingAd=");
        sb2.append(this.f7118i);
        sb2.append(", eventTimeMs=");
        sb2.append(this.f7119j);
        sb2.append(", durationMs=");
        sb2.append(this.f7120k);
        sb2.append(", bufferedPositionMs=");
        sb2.append(this.f7121l);
        sb2.append(", bufferedPercentage=");
        sb2.append(this.f7122m);
        sb2.append(", totalBufferedDurationMs=");
        sb2.append(this.f7123n);
        sb2.append(", currentLiveOffsetMs=");
        sb2.append(this.f7124o);
        sb2.append(", contentDurationMs=");
        sb2.append(this.f7125p);
        sb2.append(", contentBufferedPositionMs=");
        sb2.append(this.f7126q);
        sb2.append("}");
        return sb2.toString();
    }
}
