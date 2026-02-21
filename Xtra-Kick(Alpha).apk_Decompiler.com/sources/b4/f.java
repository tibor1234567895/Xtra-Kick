package b4;

import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import androidx.appcompat.widget.n4;
import java.util.HashMap;
import java.util.WeakHashMap;
import m0.c1;
import m0.l0;

public final class f extends u {
    public static final String[] F = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final n4 G;
    public static final n4 H;
    public static final n4 I;
    public static final n4 J;
    public static final n4 K;

    static {
        new b();
        Class<PointF> cls = PointF.class;
        G = new n4(cls, "topLeft", 1);
        H = new n4(cls, "bottomRight", 2);
        I = new n4(cls, "bottomRight", 3);
        J = new n4(cls, "topLeft", 4);
        K = new n4(cls, "position", 5);
        new o();
    }

    public final void H(c0 c0Var) {
        WeakHashMap weakHashMap = c1.f10054a;
        View view = c0Var.f2522b;
        if (l0.c(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            HashMap hashMap = c0Var.f2521a;
            hashMap.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            hashMap.put("android:changeBounds:parent", view.getParent());
        }
    }

    public final void d(c0 c0Var) {
        H(c0Var);
    }

    public final void g(c0 c0Var) {
        H(c0Var);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: android.animation.ObjectAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: android.animation.AnimatorSet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: android.animation.ObjectAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v14, resolved type: android.animation.ObjectAnimator} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x010e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.animation.Animator k(android.view.ViewGroup r19, b4.c0 r20, b4.c0 r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            r2 = r21
            if (r1 == 0) goto L_0x0126
            if (r2 != 0) goto L_0x000c
            goto L_0x0126
        L_0x000c:
            java.util.HashMap r1 = r1.f2521a
            java.util.HashMap r4 = r2.f2521a
            java.lang.String r5 = "android:changeBounds:parent"
            java.lang.Object r6 = r1.get(r5)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            java.lang.Object r5 = r4.get(r5)
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            if (r6 == 0) goto L_0x0124
            if (r5 != 0) goto L_0x0024
            goto L_0x0124
        L_0x0024:
            java.lang.String r5 = "android:changeBounds:bounds"
            java.lang.Object r6 = r1.get(r5)
            android.graphics.Rect r6 = (android.graphics.Rect) r6
            java.lang.Object r5 = r4.get(r5)
            android.graphics.Rect r5 = (android.graphics.Rect) r5
            int r7 = r6.left
            int r8 = r5.left
            int r9 = r6.top
            int r10 = r5.top
            int r11 = r6.right
            int r12 = r5.right
            int r6 = r6.bottom
            int r5 = r5.bottom
            int r13 = r11 - r7
            int r14 = r6 - r9
            int r15 = r12 - r8
            int r3 = r5 - r10
            java.lang.String r0 = "android:changeBounds:clip"
            java.lang.Object r1 = r1.get(r0)
            android.graphics.Rect r1 = (android.graphics.Rect) r1
            java.lang.Object r0 = r4.get(r0)
            android.graphics.Rect r0 = (android.graphics.Rect) r0
            r4 = 1
            if (r13 == 0) goto L_0x005d
            if (r14 != 0) goto L_0x0061
        L_0x005d:
            if (r15 == 0) goto L_0x0072
            if (r3 == 0) goto L_0x0072
        L_0x0061:
            if (r7 != r8) goto L_0x0069
            if (r9 == r10) goto L_0x0066
            goto L_0x0069
        L_0x0066:
            r16 = 0
            goto L_0x006b
        L_0x0069:
            r16 = 1
        L_0x006b:
            if (r11 != r12) goto L_0x006f
            if (r6 == r5) goto L_0x0074
        L_0x006f:
            int r16 = r16 + 1
            goto L_0x0074
        L_0x0072:
            r16 = 0
        L_0x0074:
            if (r1 == 0) goto L_0x007c
            boolean r17 = r1.equals(r0)
            if (r17 == 0) goto L_0x0080
        L_0x007c:
            if (r1 != 0) goto L_0x0082
            if (r0 == 0) goto L_0x0082
        L_0x0080:
            int r16 = r16 + 1
        L_0x0082:
            r0 = r16
            if (r0 <= 0) goto L_0x0120
            android.view.View r1 = r2.f2522b
            b4.g0.a(r1, r7, r9, r11, r6)
            r2 = 2
            if (r0 != r2) goto L_0x00e1
            if (r13 != r15) goto L_0x00a1
            if (r14 != r3) goto L_0x00a1
            r0 = r18
            b4.n r2 = r0.B
            float r3 = (float) r7
            float r5 = (float) r9
            float r6 = (float) r8
            float r7 = (float) r10
            android.graphics.Path r2 = r2.a(r3, r5, r6, r7)
            androidx.appcompat.widget.n4 r3 = K
            goto L_0x0101
        L_0x00a1:
            r0 = r18
            b4.e r3 = new b4.e
            r3.<init>(r1)
            b4.n r13 = r0.B
            float r7 = (float) r7
            float r9 = (float) r9
            float r8 = (float) r8
            float r10 = (float) r10
            android.graphics.Path r7 = r13.a(r7, r9, r8, r10)
            androidx.appcompat.widget.n4 r8 = G
            r9 = 0
            android.animation.ObjectAnimator r7 = android.animation.ObjectAnimator.ofObject(r3, r8, r9, r7)
            b4.n r8 = r0.B
            float r10 = (float) r11
            float r6 = (float) r6
            float r11 = (float) r12
            float r5 = (float) r5
            android.graphics.Path r5 = r8.a(r10, r6, r11, r5)
            androidx.appcompat.widget.n4 r6 = H
            android.animation.ObjectAnimator r5 = android.animation.ObjectAnimator.ofObject(r3, r6, r9, r5)
            android.animation.AnimatorSet r6 = new android.animation.AnimatorSet
            r6.<init>()
            android.animation.Animator[] r2 = new android.animation.Animator[r2]
            r8 = 0
            r2[r8] = r7
            r2[r4] = r5
            r6.playTogether(r2)
            b4.c r2 = new b4.c
            r2.<init>(r3)
            r6.addListener(r2)
            goto L_0x0106
        L_0x00e1:
            r0 = r18
            if (r7 != r8) goto L_0x00f5
            if (r9 == r10) goto L_0x00e8
            goto L_0x00f5
        L_0x00e8:
            b4.n r2 = r0.B
            float r3 = (float) r11
            float r6 = (float) r6
            float r7 = (float) r12
            float r5 = (float) r5
            android.graphics.Path r2 = r2.a(r3, r6, r7, r5)
            androidx.appcompat.widget.n4 r3 = I
            goto L_0x0101
        L_0x00f5:
            b4.n r2 = r0.B
            float r3 = (float) r7
            float r5 = (float) r9
            float r6 = (float) r8
            float r7 = (float) r10
            android.graphics.Path r2 = r2.a(r3, r5, r6, r7)
            androidx.appcompat.widget.n4 r3 = J
        L_0x0101:
            r5 = 0
            android.animation.ObjectAnimator r6 = android.animation.ObjectAnimator.ofObject(r1, r3, r5, r2)
        L_0x0106:
            android.view.ViewParent r2 = r1.getParent()
            boolean r2 = r2 instanceof android.view.ViewGroup
            if (r2 == 0) goto L_0x011f
            android.view.ViewParent r1 = r1.getParent()
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            b4.f0.a(r1, r4)
            b4.d r2 = new b4.d
            r2.<init>(r1)
            r0.a(r2)
        L_0x011f:
            return r6
        L_0x0120:
            r0 = r18
            r1 = 0
            return r1
        L_0x0124:
            r1 = 0
            return r1
        L_0x0126:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.f.k(android.view.ViewGroup, b4.c0, b4.c0):android.animation.Animator");
    }

    public final String[] p() {
        return F;
    }
}
