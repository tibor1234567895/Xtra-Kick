package h3;

import android.os.Bundle;
import g1.m;
import j1.l0;
import java.util.Arrays;

public final class v3 implements m {

    /* renamed from: j  reason: collision with root package name */
    public static final v3 f7384j = new v3(false, false);

    /* renamed from: k  reason: collision with root package name */
    public static final String f7385k = l0.C(0);

    /* renamed from: l  reason: collision with root package name */
    public static final String f7386l = l0.C(1);

    /* renamed from: m  reason: collision with root package name */
    public static final j3 f7387m = new j3(10);

    /* renamed from: h  reason: collision with root package name */
    public final boolean f7388h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f7389i;

    public v3(boolean z10, boolean z11) {
        this.f7388h = z10;
        this.f7389i = z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (h3.v3) r5;
        r1 = r5.f7388h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof h3.v3
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            h3.v3 r5 = (h3.v3) r5
            boolean r1 = r5.f7388h
            boolean r3 = r4.f7388h
            if (r3 != r1) goto L_0x0019
            boolean r1 = r4.f7389i
            boolean r5 = r5.f7389i
            if (r1 != r5) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.v3.equals(java.lang.Object):boolean");
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(f7385k, this.f7388h);
        bundle.putBoolean(f7386l, this.f7389i);
        return bundle;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f7388h), Boolean.valueOf(this.f7389i)});
    }
}
