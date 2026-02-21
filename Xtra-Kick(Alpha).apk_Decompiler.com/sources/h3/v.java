package h3;

import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import b0.j;
import f3.a;
import g1.k;
import g1.m;
import g1.s0;
import j1.c;
import j1.l0;

public final class v implements m {

    /* renamed from: m  reason: collision with root package name */
    public static final String f7366m = l0.C(0);

    /* renamed from: n  reason: collision with root package name */
    public static final String f7367n = l0.C(1);

    /* renamed from: o  reason: collision with root package name */
    public static final String f7368o = l0.C(2);

    /* renamed from: p  reason: collision with root package name */
    public static final String f7369p = l0.C(3);

    /* renamed from: q  reason: collision with root package name */
    public static final String f7370q = l0.C(4);

    /* renamed from: r  reason: collision with root package name */
    public static final a f7371r = new a(13);

    /* renamed from: h  reason: collision with root package name */
    public final int f7372h;

    /* renamed from: i  reason: collision with root package name */
    public final long f7373i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f7374j;

    /* renamed from: k  reason: collision with root package name */
    public final int f7375k;

    /* renamed from: l  reason: collision with root package name */
    public final p1 f7376l;

    public v(int i10, long j10, p1 p1Var, Object obj, int i11) {
        this.f7372h = i10;
        this.f7373i = j10;
        this.f7376l = p1Var;
        this.f7374j = obj;
        this.f7375k = i11;
    }

    public static v i(Bundle bundle, Integer num) {
        p1 p1Var;
        Object obj;
        Object obj2;
        boolean z10 = false;
        int i10 = bundle.getInt(f7366m, 0);
        long j10 = bundle.getLong(f7367n, SystemClock.elapsedRealtime());
        Bundle bundle2 = bundle.getBundle(f7368o);
        if (bundle2 == null) {
            p1Var = null;
        } else {
            p1Var = (p1) p1.f7279p.e(bundle2);
        }
        int i11 = bundle.getInt(f7370q);
        if (i11 != 1) {
            String str = f7369p;
            if (i11 == 2) {
                if (num == null || num.intValue() == 2) {
                    z10 = true;
                }
                j1.a.e(z10);
                Bundle bundle3 = bundle.getBundle(str);
                if (bundle3 != null) {
                    obj2 = s0.f6555t.e(bundle3);
                }
            } else if (i11 == 3) {
                if (num == null || num.intValue() == 3) {
                    z10 = true;
                }
                j1.a.e(z10);
                IBinder a10 = j.a(bundle, str);
                if (a10 != null) {
                    obj2 = c.a(s0.f6555t, k.a(a10));
                }
            } else if (i11 != 4) {
                throw new IllegalStateException();
            }
            obj = obj2;
            return new v(i10, j10, p1Var, obj, i11);
        }
        obj = null;
        return new v(i10, j10, p1Var, obj, i11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        if (r2 != 4) goto L_0x0053;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle h() {
        /*
            r5 = this;
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = f7366m
            int r2 = r5.f7372h
            r0.putInt(r1, r2)
            java.lang.String r1 = f7367n
            long r2 = r5.f7373i
            r0.putLong(r1, r2)
            h3.p1 r1 = r5.f7376l
            if (r1 == 0) goto L_0x0020
            android.os.Bundle r1 = r1.h()
            java.lang.String r2 = f7368o
            r0.putBundle(r2, r1)
        L_0x0020:
            java.lang.String r1 = f7370q
            int r2 = r5.f7375k
            r0.putInt(r1, r2)
            java.lang.Object r1 = r5.f7374j
            if (r1 != 0) goto L_0x002c
            return r0
        L_0x002c:
            r3 = 1
            if (r2 == r3) goto L_0x0054
            r3 = 2
            java.lang.String r4 = f7369p
            if (r2 == r3) goto L_0x004a
            r3 = 3
            if (r2 == r3) goto L_0x003b
            r1 = 4
            if (r2 == r1) goto L_0x0054
            goto L_0x0053
        L_0x003b:
            g1.k r2 = new g1.k
            d9.r0 r1 = (d9.r0) r1
            d9.r1 r1 = j1.c.c(r1)
            r2.<init>(r1)
            b0.j.b(r0, r4, r2)
            goto L_0x0053
        L_0x004a:
            g1.s0 r1 = (g1.s0) r1
            android.os.Bundle r1 = r1.h()
            r0.putBundle(r4, r1)
        L_0x0053:
            return r0
        L_0x0054:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.v.h():android.os.Bundle");
    }
}
