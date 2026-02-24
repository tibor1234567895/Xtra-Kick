package h5;

import java.net.URL;

public final class v0 implements i0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7616a;

    /* renamed from: b  reason: collision with root package name */
    public final i0 f7617b;

    public /* synthetic */ v0(i0 i0Var, int i10) {
        this.f7616a = i10;
        this.f7617b = i0Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0025, code lost:
        if (r0.getScheme() == null) goto L_0x0027;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final h5.h0 a(java.lang.Object r5, int r6, int r7, b5.n r8) {
        /*
            r4 = this;
            int r0 = r4.f7616a
            h5.i0 r1 = r4.f7617b
            switch(r0) {
                case 0: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x003e
        L_0x0008:
            java.lang.String r5 = (java.lang.String) r5
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r2 = 0
            if (r0 == 0) goto L_0x0013
            r0 = r2
            goto L_0x0030
        L_0x0013:
            r0 = 0
            char r0 = r5.charAt(r0)
            r3 = 47
            if (r0 != r3) goto L_0x001d
            goto L_0x0027
        L_0x001d:
            android.net.Uri r0 = android.net.Uri.parse(r5)
            java.lang.String r3 = r0.getScheme()
            if (r3 != 0) goto L_0x0030
        L_0x0027:
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            android.net.Uri r0 = android.net.Uri.fromFile(r0)
        L_0x0030:
            if (r0 == 0) goto L_0x003d
            boolean r5 = r1.b(r0)
            if (r5 != 0) goto L_0x0039
            goto L_0x003d
        L_0x0039:
            h5.h0 r2 = r1.a(r0, r6, r7, r8)
        L_0x003d:
            return r2
        L_0x003e:
            java.net.URL r5 = (java.net.URL) r5
            h5.x r0 = new h5.x
            r0.<init>((java.net.URL) r5)
            h5.h0 r5 = r1.a(r0, r6, r7, r8)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: h5.v0.a(java.lang.Object, int, int, b5.n):h5.h0");
    }

    public final /* bridge */ /* synthetic */ boolean b(Object obj) {
        switch (this.f7616a) {
            case 0:
                String str = (String) obj;
                return true;
            default:
                URL url = (URL) obj;
                return true;
        }
    }
}
