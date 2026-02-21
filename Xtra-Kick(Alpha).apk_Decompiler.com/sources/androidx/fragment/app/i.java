package androidx.fragment.app;

import g.h0;
import i0.f;

public final class i extends h0 {

    /* renamed from: c  reason: collision with root package name */
    public final boolean f1460c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1461d;

    /* renamed from: e  reason: collision with root package name */
    public n0 f1462e;

    public i(h2 h2Var, f fVar, boolean z10) {
        super(h2Var, fVar);
        this.f1460c = z10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.fragment.app.n0 h(android.content.Context r10) {
        /*
            r9 = this;
            boolean r0 = r9.f1461d
            if (r0 == 0) goto L_0x0008
            androidx.fragment.app.n0 r10 = r9.f1462e
            goto L_0x0109
        L_0x0008:
            java.lang.Object r0 = r9.f6079a
            androidx.fragment.app.h2 r0 = (androidx.fragment.app.h2) r0
            androidx.fragment.app.c0 r1 = r0.f1455c
            androidx.fragment.app.g2 r0 = r0.f1453a
            androidx.fragment.app.g2 r2 = androidx.fragment.app.g2.VISIBLE
            r3 = 1
            r4 = 0
            if (r0 != r2) goto L_0x0018
            r0 = 1
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            androidx.fragment.app.x r2 = r1.P
            if (r2 != 0) goto L_0x001f
            r5 = 0
            goto L_0x0021
        L_0x001f:
            int r5 = r2.f1602f
        L_0x0021:
            boolean r6 = r9.f1460c
            if (r6 == 0) goto L_0x0034
            if (r0 == 0) goto L_0x002e
            if (r2 != 0) goto L_0x002b
        L_0x0029:
            r2 = 0
            goto L_0x0041
        L_0x002b:
            int r2 = r2.f1600d
            goto L_0x0041
        L_0x002e:
            if (r2 != 0) goto L_0x0031
            goto L_0x0029
        L_0x0031:
            int r2 = r2.f1601e
            goto L_0x0041
        L_0x0034:
            if (r0 == 0) goto L_0x003c
            if (r2 != 0) goto L_0x0039
            goto L_0x0029
        L_0x0039:
            int r2 = r2.f1598b
            goto L_0x0041
        L_0x003c:
            if (r2 != 0) goto L_0x003f
            goto L_0x0029
        L_0x003f:
            int r2 = r2.f1599c
        L_0x0041:
            r1.i0(r4, r4, r4, r4)
            android.view.ViewGroup r6 = r1.L
            r7 = 0
            if (r6 == 0) goto L_0x0057
            r8 = 2131362616(0x7f0a0338, float:1.8345018E38)
            java.lang.Object r6 = r6.getTag(r8)
            if (r6 == 0) goto L_0x0057
            android.view.ViewGroup r6 = r1.L
            r6.setTag(r8, r7)
        L_0x0057:
            android.view.ViewGroup r1 = r1.L
            if (r1 == 0) goto L_0x0063
            android.animation.LayoutTransition r1 = r1.getLayoutTransition()
            if (r1 == 0) goto L_0x0063
            goto L_0x0104
        L_0x0063:
            if (r2 != 0) goto L_0x00c0
            if (r5 == 0) goto L_0x00c0
            r1 = 4097(0x1001, float:5.741E-42)
            if (r5 == r1) goto L_0x00b7
            r1 = 8194(0x2002, float:1.1482E-41)
            if (r5 == r1) goto L_0x00ad
            r1 = 8197(0x2005, float:1.1486E-41)
            r2 = -1
            if (r5 == r1) goto L_0x0091
            r1 = 4099(0x1003, float:5.744E-42)
            if (r5 == r1) goto L_0x0087
            r1 = 4100(0x1004, float:5.745E-42)
            if (r5 == r1) goto L_0x007d
            goto L_0x00c0
        L_0x007d:
            if (r0 == 0) goto L_0x0083
            r0 = 16842936(0x10100b8, float:2.3694074E-38)
            goto L_0x009a
        L_0x0083:
            r0 = 16842937(0x10100b9, float:2.3694076E-38)
            goto L_0x009a
        L_0x0087:
            if (r0 == 0) goto L_0x008d
            r2 = 2130837509(0x7f020005, float:1.7279974E38)
            goto L_0x00c0
        L_0x008d:
            r2 = 2130837510(0x7f020006, float:1.7279976E38)
            goto L_0x00c0
        L_0x0091:
            if (r0 == 0) goto L_0x0097
            r0 = 16842938(0x10100ba, float:2.369408E-38)
            goto L_0x009a
        L_0x0097:
            r0 = 16842939(0x10100bb, float:2.3694082E-38)
        L_0x009a:
            int[] r1 = new int[r3]
            r1[r4] = r0
            r0 = 16973825(0x1030001, float:2.4060903E-38)
            android.content.res.TypedArray r0 = r10.obtainStyledAttributes(r0, r1)
            int r2 = r0.getResourceId(r4, r2)
            r0.recycle()
            goto L_0x00c0
        L_0x00ad:
            if (r0 == 0) goto L_0x00b3
            r2 = 2130837507(0x7f020003, float:1.727997E38)
            goto L_0x00c0
        L_0x00b3:
            r2 = 2130837508(0x7f020004, float:1.7279972E38)
            goto L_0x00c0
        L_0x00b7:
            if (r0 == 0) goto L_0x00bd
            r2 = 2130837511(0x7f020007, float:1.7279978E38)
            goto L_0x00c0
        L_0x00bd:
            r2 = 2130837512(0x7f020008, float:1.727998E38)
        L_0x00c0:
            if (r2 == 0) goto L_0x0104
            android.content.res.Resources r0 = r10.getResources()
            java.lang.String r0 = r0.getResourceTypeName(r2)
            java.lang.String r1 = "anim"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x00e4
            android.view.animation.Animation r1 = android.view.animation.AnimationUtils.loadAnimation(r10, r2)     // Catch:{ NotFoundException -> 0x00e2, RuntimeException -> 0x00e0 }
            if (r1 == 0) goto L_0x00de
            androidx.fragment.app.n0 r5 = new androidx.fragment.app.n0     // Catch:{ NotFoundException -> 0x00e2, RuntimeException -> 0x00e0 }
            r5.<init>((android.view.animation.Animation) r1)     // Catch:{ NotFoundException -> 0x00e2, RuntimeException -> 0x00e0 }
            goto L_0x00f1
        L_0x00de:
            r4 = 1
            goto L_0x00e4
        L_0x00e0:
            goto L_0x00e4
        L_0x00e2:
            r10 = move-exception
            throw r10
        L_0x00e4:
            if (r4 != 0) goto L_0x0104
            android.animation.Animator r1 = android.animation.AnimatorInflater.loadAnimator(r10, r2)     // Catch:{ RuntimeException -> 0x00f3 }
            if (r1 == 0) goto L_0x0104
            androidx.fragment.app.n0 r5 = new androidx.fragment.app.n0     // Catch:{ RuntimeException -> 0x00f3 }
            r5.<init>((android.animation.Animator) r1)     // Catch:{ RuntimeException -> 0x00f3 }
        L_0x00f1:
            r10 = r5
            goto L_0x0105
        L_0x00f3:
            r1 = move-exception
            if (r0 != 0) goto L_0x0103
            android.view.animation.Animation r10 = android.view.animation.AnimationUtils.loadAnimation(r10, r2)
            if (r10 == 0) goto L_0x0104
            androidx.fragment.app.n0 r0 = new androidx.fragment.app.n0
            r0.<init>((android.view.animation.Animation) r10)
            r10 = r0
            goto L_0x0105
        L_0x0103:
            throw r1
        L_0x0104:
            r10 = r7
        L_0x0105:
            r9.f1462e = r10
            r9.f1461d = r3
        L_0x0109:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.i.h(android.content.Context):androidx.fragment.app.n0");
    }
}
