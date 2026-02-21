package t6;

import h9.e0;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f14575h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ e0 f14576i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ l f14577j;

    public /* synthetic */ c(e0 e0Var, l lVar, int i10) {
        this.f14575h = i10;
        this.f14576i = e0Var;
        this.f14577j = lVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: t6.a0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: t6.d0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: t6.a0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: t6.a0} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r0v19 */
    /* JADX WARNING: type inference failed for: r0v20, types: [java.io.Serializable] */
    /* JADX WARNING: type inference failed for: r0v21, types: [java.io.Serializable] */
    /* JADX WARNING: type inference failed for: r0v28 */
    /* JADX WARNING: type inference failed for: r0v29, types: [java.io.Serializable] */
    /* JADX WARNING: type inference failed for: r0v30, types: [java.io.Serializable] */
    /* JADX WARNING: type inference failed for: r0v36 */
    /* JADX WARNING: type inference failed for: r0v37, types: [java.io.Serializable] */
    /* JADX WARNING: type inference failed for: r0v38, types: [java.io.Serializable] */
    /* JADX WARNING: type inference failed for: r5v16 */
    /* JADX WARNING: type inference failed for: r5v17 */
    /* JADX WARNING: type inference failed for: r5v18 */
    /* JADX WARNING: type inference failed for: r5v19 */
    /* JADX WARNING: type inference failed for: r5v20 */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a1, code lost:
        if ((r0 instanceof t6.a0) != false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d5, code lost:
        if ((r0 instanceof t6.a0) != false) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0174, code lost:
        if ((r0 instanceof t6.a0) != false) goto L_0x0176;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r11 = this;
            r0 = 0
            int r1 = r11.f14575h
            java.lang.String r2 = "closeOnPip"
            r3 = 1
            r4 = 33
            r5 = 0
            java.lang.String r6 = "result"
            t6.l r7 = r11.f14577j
            java.lang.String r8 = "this$0"
            h9.e0 r9 = r11.f14576i
            java.lang.String r10 = "$result"
            switch(r1) {
                case 0: goto L_0x014b;
                case 1: goto L_0x00e0;
                case 2: goto L_0x00ac;
                case 3: goto L_0x0078;
                case 4: goto L_0x0018;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x0182
        L_0x0018:
            t6.f r1 = t6.l.f14620w0
            xa.j.f(r10, r9)
            xa.j.f(r8, r7)
            java.lang.Object r1 = r9.get()
            h3.j4 r1 = (h3.j4) r1
            int r1 = r1.f7143h
            if (r1 != 0) goto L_0x0077
            java.lang.Object r1 = r9.get()
            h3.j4 r1 = (h3.j4) r1
            android.os.Bundle r1 = r1.f7144i
            java.lang.String[] r1 = r1.getStringArray(r6)
            if (r1 == 0) goto L_0x003d
            java.util.List r1 = ma.p.j(r1)
            goto L_0x003e
        L_0x003d:
            r1 = r5
        L_0x003e:
            java.lang.Object r4 = r9.get()
            h3.j4 r4 = (h3.j4) r4
            android.os.Bundle r4 = r4.f7144i
            java.lang.String r6 = "index"
            int r4 = r4.getInt(r6)
            if (r1 == 0) goto L_0x0056
            boolean r6 = r1.isEmpty()
            if (r6 == 0) goto L_0x0055
            goto L_0x0056
        L_0x0055:
            r3 = 0
        L_0x0056:
            if (r3 != 0) goto L_0x0077
            s7.g r3 = s7.g.f14374a
            androidx.fragment.app.c1 r6 = r7.u()
            java.lang.String r7 = "childFragmentManager"
            xa.j.e(r7, r6)
            r3.getClass()
            java.lang.String r3 = "labels"
            xa.j.f(r3, r1)
            l6.z r3 = l6.b0.f9590w0
            r3.getClass()
            l6.b0 r0 = l6.z.a(r0, r1, r5, r4)
            r0.q0(r6, r2)
        L_0x0077:
            return
        L_0x0078:
            t6.f r0 = t6.l.f14620w0
            xa.j.f(r10, r9)
            xa.j.f(r8, r7)
            java.lang.Object r0 = r9.get()
            h3.j4 r0 = (h3.j4) r0
            int r0 = r0.f7143h
            if (r0 != 0) goto L_0x00ab
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.Object r1 = r9.get()
            h3.j4 r1 = (h3.j4) r1
            android.os.Bundle r1 = r1.f7144i
            if (r0 < r4) goto L_0x009b
            java.io.Serializable r0 = r1.getSerializable("result", t6.a0.class)
            goto L_0x00a3
        L_0x009b:
            java.io.Serializable r0 = r1.getSerializable(r6)
            boolean r1 = r0 instanceof t6.a0
            if (r1 == 0) goto L_0x00a6
        L_0x00a3:
            r5 = r0
            t6.a0 r5 = (t6.a0) r5
        L_0x00a6:
            if (r5 == 0) goto L_0x00ab
            r7.p0(r5)
        L_0x00ab:
            return
        L_0x00ac:
            t6.f r0 = t6.l.f14620w0
            xa.j.f(r10, r9)
            xa.j.f(r8, r7)
            java.lang.Object r0 = r9.get()
            h3.j4 r0 = (h3.j4) r0
            int r0 = r0.f7143h
            if (r0 != 0) goto L_0x00df
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.Object r1 = r9.get()
            h3.j4 r1 = (h3.j4) r1
            android.os.Bundle r1 = r1.f7144i
            if (r0 < r4) goto L_0x00cf
            java.io.Serializable r0 = r1.getSerializable("result", t6.a0.class)
            goto L_0x00d7
        L_0x00cf:
            java.io.Serializable r0 = r1.getSerializable(r6)
            boolean r1 = r0 instanceof t6.a0
            if (r1 == 0) goto L_0x00da
        L_0x00d7:
            r5 = r0
            t6.a0 r5 = (t6.a0) r5
        L_0x00da:
            if (r5 == 0) goto L_0x00df
            r7.p0(r5)
        L_0x00df:
            return
        L_0x00e0:
            t6.f r1 = t6.l.f14620w0
            xa.j.f(r10, r9)
            xa.j.f(r8, r7)
            java.lang.Object r1 = r9.get()
            h3.j4 r1 = (h3.j4) r1
            int r1 = r1.f7143h
            if (r1 != 0) goto L_0x014a
            java.lang.Object r1 = r9.get()
            h3.j4 r1 = (h3.j4) r1
            android.os.Bundle r1 = r1.f7144i
            java.lang.String r1 = r1.getString(r6)
            androidx.fragment.app.c1 r4 = r7.u()
            androidx.fragment.app.c0 r2 = r4.E(r2)
            boolean r4 = r2 instanceof t6.d0
            if (r4 == 0) goto L_0x010d
            r5 = r2
            t6.d0 r5 = (t6.d0) r5
        L_0x010d:
            if (r5 == 0) goto L_0x014a
            z5.l r2 = r5.f14581v0
            xa.j.c(r2)
            if (r1 == 0) goto L_0x011f
            boolean r4 = fb.w.h(r1)
            if (r4 == 0) goto L_0x011d
            goto L_0x011f
        L_0x011d:
            r4 = 0
            goto L_0x0120
        L_0x011f:
            r4 = 1
        L_0x0120:
            if (r4 != 0) goto L_0x014a
            java.lang.String r4 = "menuQuality"
            android.widget.LinearLayout r6 = r2.f17702g
            xa.j.e(r4, r6)
            int r4 = r6.getVisibility()
            if (r4 != 0) goto L_0x0130
            goto L_0x0131
        L_0x0130:
            r3 = 0
        L_0x0131:
            if (r3 == 0) goto L_0x014a
            java.lang.String r3 = "qualityValue"
            android.widget.TextView r2 = r2.f17712q
            xa.j.e(r3, r2)
            r2.setVisibility(r0)
            r2.setText(r1)
            t6.b0 r0 = new t6.b0
            r1 = 17
            r0.<init>(r5, r1)
            r6.setOnClickListener(r0)
        L_0x014a:
            return
        L_0x014b:
            t6.f r0 = t6.l.f14620w0
            xa.j.f(r10, r9)
            xa.j.f(r8, r7)
            java.lang.Object r0 = r9.get()
            h3.j4 r0 = (h3.j4) r0
            int r0 = r0.f7143h
            if (r0 != 0) goto L_0x0181
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.Object r1 = r9.get()
            h3.j4 r1 = (h3.j4) r1
            android.os.Bundle r1 = r1.f7144i
            if (r0 < r4) goto L_0x016e
            java.io.Serializable r0 = r1.getSerializable("result", t6.a0.class)
            goto L_0x0176
        L_0x016e:
            java.io.Serializable r0 = r1.getSerializable(r6)
            boolean r1 = r0 instanceof t6.a0
            if (r1 == 0) goto L_0x0179
        L_0x0176:
            r5 = r0
            t6.a0 r5 = (t6.a0) r5
        L_0x0179:
            if (r5 == 0) goto L_0x0181
            r7.p0(r5)
            r7.B0()
        L_0x0181:
            return
        L_0x0182:
            t6.f r0 = t6.l.f14620w0
            xa.j.f(r10, r9)
            xa.j.f(r8, r7)
            java.lang.Object r0 = r9.get()
            h3.j4 r0 = (h3.j4) r0
            int r0 = r0.f7143h
            if (r0 != 0) goto L_0x01ca
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.Object r1 = r9.get()
            h3.j4 r1 = (h3.j4) r1
            android.os.Bundle r1 = r1.f7144i
            if (r0 < r4) goto L_0x01a5
            java.io.Serializable r0 = r1.getSerializable("result", t6.a0.class)
            goto L_0x01ad
        L_0x01a5:
            java.io.Serializable r0 = r1.getSerializable(r6)
            boolean r1 = r0 instanceof t6.a0
            if (r1 == 0) goto L_0x01b0
        L_0x01ad:
            t6.a0 r0 = (t6.a0) r0
            goto L_0x01b1
        L_0x01b0:
            r0 = r5
        L_0x01b1:
            if (r0 == 0) goto L_0x01ca
            r7.p0(r0)
            androidx.fragment.app.c1 r0 = r7.u()
            androidx.fragment.app.c0 r0 = r0.E(r2)
            boolean r1 = r0 instanceof t6.d0
            if (r1 == 0) goto L_0x01c5
            r5 = r0
            t6.d0 r5 = (t6.d0) r5
        L_0x01c5:
            if (r5 == 0) goto L_0x01ca
            r7.C0()
        L_0x01ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.c.run():void");
    }
}
