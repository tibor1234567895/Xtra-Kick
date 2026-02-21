package h3;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.IBinder;
import b0.j;
import j1.l0;
import java.util.Arrays;

public final class m4 implements k4 {

    /* renamed from: q  reason: collision with root package name */
    public static final String f7203q = l0.C(0);

    /* renamed from: r  reason: collision with root package name */
    public static final String f7204r = l0.C(1);

    /* renamed from: s  reason: collision with root package name */
    public static final String f7205s = l0.C(2);

    /* renamed from: t  reason: collision with root package name */
    public static final String f7206t = l0.C(3);

    /* renamed from: u  reason: collision with root package name */
    public static final String f7207u = l0.C(4);

    /* renamed from: v  reason: collision with root package name */
    public static final String f7208v = l0.C(5);

    /* renamed from: w  reason: collision with root package name */
    public static final String f7209w = l0.C(6);

    /* renamed from: x  reason: collision with root package name */
    public static final String f7210x = l0.C(7);

    /* renamed from: y  reason: collision with root package name */
    public static final String f7211y = l0.C(8);

    /* renamed from: h  reason: collision with root package name */
    public final int f7212h;

    /* renamed from: i  reason: collision with root package name */
    public final int f7213i;

    /* renamed from: j  reason: collision with root package name */
    public final int f7214j;

    /* renamed from: k  reason: collision with root package name */
    public final int f7215k;

    /* renamed from: l  reason: collision with root package name */
    public final String f7216l;

    /* renamed from: m  reason: collision with root package name */
    public final String f7217m;

    /* renamed from: n  reason: collision with root package name */
    public final ComponentName f7218n;

    /* renamed from: o  reason: collision with root package name */
    public final IBinder f7219o;

    /* renamed from: p  reason: collision with root package name */
    public final Bundle f7220p;

    static {
        new j3(16);
    }

    public m4(int i10, int i11, int i12, int i13, String str, String str2, ComponentName componentName, IBinder iBinder, Bundle bundle) {
        this.f7212h = i10;
        this.f7213i = i11;
        this.f7214j = i12;
        this.f7215k = i13;
        this.f7216l = str;
        this.f7217m = str2;
        this.f7218n = componentName;
        this.f7219o = iBinder;
        this.f7220p = bundle;
    }

    public final int a() {
        return this.f7212h;
    }

    public final boolean b() {
        return false;
    }

    public final ComponentName c() {
        return this.f7218n;
    }

    public final Object d() {
        return this.f7219o;
    }

    public final String e() {
        return this.f7217m;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r4 = (h3.m4) r4;
        r0 = r4.f7212h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof h3.m4
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            h3.m4 r4 = (h3.m4) r4
            int r0 = r4.f7212h
            int r2 = r3.f7212h
            if (r2 != r0) goto L_0x0049
            int r0 = r3.f7213i
            int r2 = r4.f7213i
            if (r0 != r2) goto L_0x0049
            int r0 = r3.f7214j
            int r2 = r4.f7214j
            if (r0 != r2) goto L_0x0049
            int r0 = r3.f7215k
            int r2 = r4.f7215k
            if (r0 != r2) goto L_0x0049
            java.lang.String r0 = r3.f7216l
            java.lang.String r2 = r4.f7216l
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 == 0) goto L_0x0049
            java.lang.String r0 = r3.f7217m
            java.lang.String r2 = r4.f7217m
            boolean r0 = android.text.TextUtils.equals(r0, r2)
            if (r0 == 0) goto L_0x0049
            android.content.ComponentName r0 = r3.f7218n
            android.content.ComponentName r2 = r4.f7218n
            boolean r0 = j1.l0.a(r0, r2)
            if (r0 == 0) goto L_0x0049
            android.os.IBinder r0 = r3.f7219o
            android.os.IBinder r4 = r4.f7219o
            boolean r4 = j1.l0.a(r0, r4)
            if (r4 == 0) goto L_0x0049
            r1 = 1
        L_0x0049:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.m4.equals(java.lang.Object):boolean");
    }

    public final Bundle f() {
        return new Bundle(this.f7220p);
    }

    public final String g() {
        return this.f7216l;
    }

    public final int getType() {
        return this.f7213i;
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putInt(f7203q, this.f7212h);
        bundle.putInt(f7204r, this.f7213i);
        bundle.putInt(f7205s, this.f7214j);
        bundle.putString(f7206t, this.f7216l);
        bundle.putString(f7207u, this.f7217m);
        j.b(bundle, f7209w, this.f7219o);
        bundle.putParcelable(f7208v, this.f7218n);
        bundle.putBundle(f7210x, this.f7220p);
        bundle.putInt(f7211y, this.f7215k);
        return bundle;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f7212h), Integer.valueOf(this.f7213i), Integer.valueOf(this.f7214j), Integer.valueOf(this.f7215k), this.f7216l, this.f7217m, this.f7218n, this.f7219o});
    }

    public final String toString() {
        return "SessionToken {pkg=" + this.f7216l + " type=" + this.f7213i + " libraryVersion=" + this.f7214j + " interfaceVersion=" + this.f7215k + " service=" + this.f7217m + " IMediaSession=" + this.f7219o + " extras=" + this.f7220p + "}";
    }
}
