package b4;

import android.animation.Animator;
import android.view.View;
import java.util.HashMap;

public abstract class q0 extends u {
    public static final String[] G = {"android:visibility:visibility", "android:visibility:parent"};
    public int F = 3;

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006d, code lost:
        if (r9 == 0) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0077, code lost:
        if (r0.f2578e == null) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0087, code lost:
        if (r0.f2576c == 0) goto L_0x0089;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0059 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static b4.p0 I(b4.c0 r8, b4.c0 r9) {
        /*
            b4.p0 r0 = new b4.p0
            r0.<init>()
            r1 = 0
            r0.f2574a = r1
            r0.f2575b = r1
            java.lang.String r2 = "android:visibility:parent"
            r3 = 0
            r4 = -1
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L_0x002f
            java.util.HashMap r6 = r8.f2521a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L_0x002f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.f2576c = r7
            java.lang.Object r6 = r6.get(r2)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f2578e = r6
            goto L_0x0033
        L_0x002f:
            r0.f2576c = r4
            r0.f2578e = r3
        L_0x0033:
            if (r9 == 0) goto L_0x0052
            java.util.HashMap r6 = r9.f2521a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L_0x0052
            java.lang.Object r3 = r6.get(r5)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r0.f2577d = r3
            java.lang.Object r2 = r6.get(r2)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f2579f = r2
            goto L_0x0056
        L_0x0052:
            r0.f2577d = r4
            r0.f2579f = r3
        L_0x0056:
            r2 = 1
            if (r8 == 0) goto L_0x007a
            if (r9 == 0) goto L_0x007a
            int r8 = r0.f2576c
            int r9 = r0.f2577d
            if (r8 != r9) goto L_0x0068
            android.view.ViewGroup r3 = r0.f2578e
            android.view.ViewGroup r4 = r0.f2579f
            if (r3 != r4) goto L_0x0068
            return r0
        L_0x0068:
            if (r8 == r9) goto L_0x0070
            if (r8 != 0) goto L_0x006d
            goto L_0x0089
        L_0x006d:
            if (r9 != 0) goto L_0x008d
            goto L_0x0080
        L_0x0070:
            android.view.ViewGroup r8 = r0.f2579f
            if (r8 != 0) goto L_0x0075
            goto L_0x0089
        L_0x0075:
            android.view.ViewGroup r8 = r0.f2578e
            if (r8 != 0) goto L_0x008d
            goto L_0x0080
        L_0x007a:
            if (r8 != 0) goto L_0x0083
            int r8 = r0.f2577d
            if (r8 != 0) goto L_0x0083
        L_0x0080:
            r0.f2575b = r2
            goto L_0x008b
        L_0x0083:
            if (r9 != 0) goto L_0x008d
            int r8 = r0.f2576c
            if (r8 != 0) goto L_0x008d
        L_0x0089:
            r0.f2575b = r1
        L_0x008b:
            r0.f2574a = r2
        L_0x008d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.q0.I(b4.c0, b4.c0):b4.p0");
    }

    public final void H(c0 c0Var) {
        View view = c0Var.f2522b;
        int visibility = view.getVisibility();
        HashMap hashMap = c0Var.f2521a;
        hashMap.put("android:visibility:visibility", Integer.valueOf(visibility));
        hashMap.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        hashMap.put("android:visibility:screenLocation", iArr);
    }

    public Animator J(View view, c0 c0Var) {
        return null;
    }

    public Animator K(View view, c0 c0Var) {
        return null;
    }

    public final void d(c0 c0Var) {
        H(c0Var);
    }

    public void g(c0 c0Var) {
        H(c0Var);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: b4.o0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: b4.n0} */
    /* JADX WARNING: type inference failed for: r16v4, types: [android.view.ViewParent] */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        if (I(n(r3, false), q(r3, false)).f2574a != false) goto L_0x0046;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.animation.Animator k(android.view.ViewGroup r21, b4.c0 r22, b4.c0 r23) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            b4.p0 r4 = I(r22, r23)
            boolean r5 = r4.f2574a
            if (r5 == 0) goto L_0x0284
            android.view.ViewGroup r5 = r4.f2578e
            if (r5 != 0) goto L_0x0018
            android.view.ViewGroup r5 = r4.f2579f
            if (r5 == 0) goto L_0x0284
        L_0x0018:
            boolean r5 = r4.f2575b
            r7 = 1
            r8 = 0
            if (r5 == 0) goto L_0x0048
            int r1 = r0.F
            r1 = r1 & r7
            if (r1 != r7) goto L_0x0046
            if (r3 != 0) goto L_0x0026
            goto L_0x0046
        L_0x0026:
            android.view.View r1 = r3.f2522b
            if (r2 != 0) goto L_0x0041
            android.view.ViewParent r3 = r1.getParent()
            android.view.View r3 = (android.view.View) r3
            b4.c0 r4 = r0.n(r3, r8)
            b4.c0 r3 = r0.q(r3, r8)
            b4.p0 r3 = I(r4, r3)
            boolean r3 = r3.f2574a
            if (r3 == 0) goto L_0x0041
            goto L_0x0046
        L_0x0041:
            android.animation.Animator r6 = r0.J(r1, r2)
            goto L_0x0047
        L_0x0046:
            r6 = 0
        L_0x0047:
            return r6
        L_0x0048:
            int r4 = r4.f2577d
            int r5 = r0.F
            r9 = 2
            r5 = r5 & r9
            if (r5 == r9) goto L_0x0051
            goto L_0x0053
        L_0x0051:
            if (r2 != 0) goto L_0x0056
        L_0x0053:
            r2 = r0
            goto L_0x0282
        L_0x0056:
            if (r3 == 0) goto L_0x005b
            android.view.View r3 = r3.f2522b
            goto L_0x005c
        L_0x005b:
            r3 = 0
        L_0x005c:
            android.view.View r5 = r2.f2522b
            r10 = 2131362391(0x7f0a0257, float:1.8344561E38)
            java.lang.Object r11 = r5.getTag(r10)
            android.view.View r11 = (android.view.View) r11
            if (r11 == 0) goto L_0x006e
            r19 = r4
            r3 = 0
            goto L_0x01f6
        L_0x006e:
            if (r3 == 0) goto L_0x007f
            android.view.ViewParent r11 = r3.getParent()
            if (r11 != 0) goto L_0x0077
            goto L_0x007f
        L_0x0077:
            r11 = 4
            if (r4 != r11) goto L_0x007b
            goto L_0x007d
        L_0x007b:
            if (r5 != r3) goto L_0x0085
        L_0x007d:
            r11 = 0
            goto L_0x0083
        L_0x007f:
            if (r3 == 0) goto L_0x0085
            r11 = r3
            r3 = 0
        L_0x0083:
            r12 = 0
            goto L_0x0088
        L_0x0085:
            r3 = 0
            r11 = 0
            r12 = 1
        L_0x0088:
            if (r12 == 0) goto L_0x01ef
            android.view.ViewParent r12 = r5.getParent()
            if (r12 != 0) goto L_0x0097
            r18 = r3
            r19 = r4
            r11 = r5
            goto L_0x01f3
        L_0x0097:
            android.view.ViewParent r12 = r5.getParent()
            boolean r12 = r12 instanceof android.view.View
            if (r12 == 0) goto L_0x01ef
            android.view.ViewParent r12 = r5.getParent()
            android.view.View r12 = (android.view.View) r12
            b4.c0 r13 = r0.q(r12, r7)
            b4.c0 r14 = r0.n(r12, r7)
            b4.p0 r13 = I(r13, r14)
            boolean r13 = r13.f2574a
            if (r13 != 0) goto L_0x01da
            boolean r11 = b4.b0.f2518a
            android.graphics.Matrix r11 = new android.graphics.Matrix
            r11.<init>()
            int r13 = r12.getScrollX()
            int r13 = -r13
            float r13 = (float) r13
            int r12 = r12.getScrollY()
            int r12 = -r12
            float r12 = (float) r12
            r11.setTranslate(r13, r12)
            b4.i0 r12 = b4.g0.f2543a
            r12.e(r5, r11)
            r12.f(r1, r11)
            android.graphics.RectF r12 = new android.graphics.RectF
            int r13 = r5.getWidth()
            float r13 = (float) r13
            int r14 = r5.getHeight()
            float r14 = (float) r14
            r15 = 0
            r12.<init>(r15, r15, r13, r14)
            r11.mapRect(r12)
            float r13 = r12.left
            int r13 = java.lang.Math.round(r13)
            float r14 = r12.top
            int r14 = java.lang.Math.round(r14)
            float r15 = r12.right
            int r15 = java.lang.Math.round(r15)
            float r6 = r12.bottom
            int r6 = java.lang.Math.round(r6)
            android.widget.ImageView r10 = new android.widget.ImageView
            android.content.Context r9 = r5.getContext()
            r10.<init>(r9)
            android.widget.ImageView$ScaleType r9 = android.widget.ImageView.ScaleType.CENTER_CROP
            r10.setScaleType(r9)
            boolean r9 = b4.b0.f2518a
            if (r9 == 0) goto L_0x011a
            boolean r9 = r5.isAttachedToWindow()
            r9 = r9 ^ r7
            boolean r16 = r21.isAttachedToWindow()
            goto L_0x011d
        L_0x011a:
            r9 = 0
            r16 = 0
        L_0x011d:
            boolean r17 = b4.b0.f2519b
            if (r17 == 0) goto L_0x0142
            if (r9 == 0) goto L_0x0142
            if (r16 != 0) goto L_0x012c
            r18 = r3
            r19 = r4
            r0 = 0
            goto L_0x01bf
        L_0x012c:
            android.view.ViewParent r16 = r5.getParent()
            r7 = r16
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            int r16 = r7.indexOfChild(r5)
            android.view.ViewGroupOverlay r8 = r21.getOverlay()
            r8.add(r5)
            r8 = r16
            goto L_0x0144
        L_0x0142:
            r7 = 0
            r8 = 0
        L_0x0144:
            float r16 = r12.width()
            r18 = r3
            int r3 = java.lang.Math.round(r16)
            float r16 = r12.height()
            r19 = r4
            int r4 = java.lang.Math.round(r16)
            if (r3 <= 0) goto L_0x01b0
            if (r4 <= 0) goto L_0x01b0
            int r0 = r3 * r4
            float r0 = (float) r0
            r16 = 1233125376(0x49800000, float:1048576.0)
            float r0 = r16 / r0
            r2 = 1065353216(0x3f800000, float:1.0)
            float r0 = java.lang.Math.min(r2, r0)
            float r2 = (float) r3
            float r2 = r2 * r0
            int r2 = java.lang.Math.round(r2)
            float r3 = (float) r4
            float r3 = r3 * r0
            int r3 = java.lang.Math.round(r3)
            float r4 = r12.left
            float r4 = -r4
            float r12 = r12.top
            float r12 = -r12
            r11.postTranslate(r4, r12)
            r11.postScale(r0, r0)
            boolean r0 = b4.b0.f2520c
            if (r0 == 0) goto L_0x019e
            android.graphics.Picture r0 = new android.graphics.Picture
            r0.<init>()
            android.graphics.Canvas r2 = r0.beginRecording(r2, r3)
            r2.concat(r11)
            r5.draw(r2)
            r0.endRecording()
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0)
            goto L_0x01b1
        L_0x019e:
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r2, r3, r0)
            android.graphics.Canvas r2 = new android.graphics.Canvas
            r2.<init>(r0)
            r2.concat(r11)
            r5.draw(r2)
            goto L_0x01b1
        L_0x01b0:
            r0 = 0
        L_0x01b1:
            if (r17 == 0) goto L_0x01bf
            if (r9 == 0) goto L_0x01bf
            android.view.ViewGroupOverlay r2 = r21.getOverlay()
            r2.remove(r5)
            r7.addView(r5, r8)
        L_0x01bf:
            if (r0 == 0) goto L_0x01c4
            r10.setImageBitmap(r0)
        L_0x01c4:
            int r0 = r15 - r13
            r2 = 1073741824(0x40000000, float:2.0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r2)
            int r3 = r6 - r14
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
            r10.measure(r0, r2)
            r10.layout(r13, r14, r15, r6)
            r11 = r10
            goto L_0x01f3
        L_0x01da:
            r18 = r3
            r19 = r4
            int r0 = r12.getId()
            android.view.ViewParent r2 = r12.getParent()
            if (r2 != 0) goto L_0x01f3
            r2 = -1
            if (r0 == r2) goto L_0x01f3
            r1.findViewById(r0)
            goto L_0x01f3
        L_0x01ef:
            r18 = r3
            r19 = r4
        L_0x01f3:
            r3 = r18
            r7 = 0
        L_0x01f6:
            if (r11 == 0) goto L_0x0257
            r0 = r22
            if (r7 != 0) goto L_0x0234
            java.util.HashMap r2 = r0.f2521a
            java.lang.String r3 = "android:visibility:screenLocation"
            java.lang.Object r2 = r2.get(r3)
            int[] r2 = (int[]) r2
            r3 = 0
            r4 = r2[r3]
            r6 = 1
            r2 = r2[r6]
            r8 = 2
            int[] r8 = new int[r8]
            r1.getLocationOnScreen(r8)
            r3 = r8[r3]
            int r4 = r4 - r3
            int r3 = r11.getLeft()
            int r4 = r4 - r3
            r11.offsetLeftAndRight(r4)
            r3 = r8[r6]
            int r2 = r2 - r3
            int r3 = r11.getTop()
            int r2 = r2 - r3
            r11.offsetTopAndBottom(r2)
            b4.e0 r2 = new b4.e0
            r2.<init>((android.view.ViewGroup) r1)
            java.lang.Object r2 = r2.f2538i
            android.view.ViewGroupOverlay r2 = (android.view.ViewGroupOverlay) r2
            r2.add(r11)
        L_0x0234:
            r2 = r20
            android.animation.Animator r6 = r2.K(r11, r0)
            if (r7 != 0) goto L_0x0283
            if (r6 != 0) goto L_0x024b
            b4.e0 r0 = new b4.e0
            r0.<init>((android.view.ViewGroup) r1)
            java.lang.Object r0 = r0.f2538i
            android.view.ViewGroupOverlay r0 = (android.view.ViewGroupOverlay) r0
            r0.remove(r11)
            goto L_0x0283
        L_0x024b:
            r0 = 2131362391(0x7f0a0257, float:1.8344561E38)
            r5.setTag(r0, r11)
            b4.n0 r0 = new b4.n0
            r0.<init>(r2, r1, r11, r5)
            goto L_0x027a
        L_0x0257:
            r2 = r20
            r0 = r22
            if (r3 == 0) goto L_0x0282
            int r1 = r3.getVisibility()
            b4.i0 r4 = b4.g0.f2543a
            r5 = 0
            r4.b(r3, r5)
            android.animation.Animator r6 = r2.K(r3, r0)
            if (r6 == 0) goto L_0x027e
            b4.o0 r0 = new b4.o0
            r1 = r19
            r0.<init>(r3, r1)
            r6.addListener(r0)
            r6.addPauseListener(r0)
        L_0x027a:
            r2.a(r0)
            goto L_0x0283
        L_0x027e:
            r4.b(r3, r1)
            goto L_0x0283
        L_0x0282:
            r6 = 0
        L_0x0283:
            return r6
        L_0x0284:
            r2 = r0
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.q0.k(android.view.ViewGroup, b4.c0, b4.c0):android.animation.Animator");
    }

    public final String[] p() {
        return G;
    }

    public final boolean r(c0 c0Var, c0 c0Var2) {
        if (c0Var == null && c0Var2 == null) {
            return false;
        }
        if (c0Var != null && c0Var2 != null && c0Var2.f2521a.containsKey("android:visibility:visibility") != c0Var.f2521a.containsKey("android:visibility:visibility")) {
            return false;
        }
        p0 I = I(c0Var, c0Var2);
        if (I.f2574a) {
            return I.f2576c == 0 || I.f2577d == 0;
        }
        return false;
    }
}
