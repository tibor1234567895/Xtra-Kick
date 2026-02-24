package h3;

import android.os.Bundle;
import d9.r0;
import d9.r1;
import g1.m;
import j1.a;
import j1.l0;
import java.util.Arrays;

public final class f4 implements m {

    /* renamed from: k  reason: collision with root package name */
    public static final r1 f7029k = r0.n(40010);

    /* renamed from: l  reason: collision with root package name */
    public static final String f7030l = l0.C(0);

    /* renamed from: m  reason: collision with root package name */
    public static final String f7031m = l0.C(1);

    /* renamed from: n  reason: collision with root package name */
    public static final String f7032n = l0.C(2);

    /* renamed from: o  reason: collision with root package name */
    public static final j3 f7033o = new j3(11);

    /* renamed from: h  reason: collision with root package name */
    public final int f7034h;

    /* renamed from: i  reason: collision with root package name */
    public final String f7035i;

    /* renamed from: j  reason: collision with root package name */
    public final Bundle f7036j;

    static {
        r0.i(50000, 50001, 50002, 50003, 50004, 50005, 50006);
    }

    public f4(int i10) {
        a.a("commandCode shouldn't be COMMAND_CODE_CUSTOM", i10 != 0);
        this.f7034h = i10;
        this.f7035i = "";
        this.f7036j = Bundle.EMPTY;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r4 = (h3.f4) r4;
        r0 = r4.f7034h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof h3.f4
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            h3.f4 r4 = (h3.f4) r4
            int r0 = r4.f7034h
            int r2 = r3.f7034h
            if (r2 != r0) goto L_0x0019
            java.lang.String r0 = r3.f7035i
            java.lang.String r4 = r4.f7035i
            boolean r4 = android.text.TextUtils.equals(r0, r4)
            if (r4 == 0) goto L_0x0019
            r1 = 1
        L_0x0019:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.f4.equals(java.lang.Object):boolean");
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putInt(f7030l, this.f7034h);
        bundle.putString(f7031m, this.f7035i);
        bundle.putBundle(f7032n, this.f7036j);
        return bundle;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f7035i, Integer.valueOf(this.f7034h)});
    }

    public f4(Bundle bundle, String str) {
        this.f7034h = 0;
        str.getClass();
        this.f7035i = str;
        bundle.getClass();
        this.f7036j = new Bundle(bundle);
    }
}
