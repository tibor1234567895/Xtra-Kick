package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import g.k0;
import g.v;
import m.o;
import m0.n1;

public class ContentFrameLayout extends FrameLayout {

    /* renamed from: h  reason: collision with root package name */
    public TypedValue f631h;

    /* renamed from: i  reason: collision with root package name */
    public TypedValue f632i;

    /* renamed from: j  reason: collision with root package name */
    public TypedValue f633j;

    /* renamed from: k  reason: collision with root package name */
    public TypedValue f634k;

    /* renamed from: l  reason: collision with root package name */
    public TypedValue f635l;

    /* renamed from: m  reason: collision with root package name */
    public TypedValue f636m;

    /* renamed from: n  reason: collision with root package name */
    public final Rect f637n = new Rect();

    /* renamed from: o  reason: collision with root package name */
    public d2 f638o;

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f635l == null) {
            this.f635l = new TypedValue();
        }
        return this.f635l;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f636m == null) {
            this.f636m = new TypedValue();
        }
        return this.f636m;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f633j == null) {
            this.f633j = new TypedValue();
        }
        return this.f633j;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f634k == null) {
            this.f634k = new TypedValue();
        }
        return this.f634k;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f631h == null) {
            this.f631h = new TypedValue();
        }
        return this.f631h;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f632i == null) {
            this.f632i = new TypedValue();
        }
        return this.f632i;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d2 d2Var = this.f638o;
        if (d2Var != null) {
            d2Var.getClass();
        }
    }

    public final void onDetachedFromWindow() {
        n nVar;
        super.onDetachedFromWindow();
        d2 d2Var = this.f638o;
        if (d2Var != null) {
            k0 k0Var = ((v) d2Var).f6220i;
            e2 e2Var = k0Var.f6174y;
            if (e2Var != null) {
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) e2Var;
                actionBarOverlayLayout.l();
                ActionMenuView actionMenuView = ((d5) actionBarOverlayLayout.f608l).f791a.f691h;
                if (!(actionMenuView == null || (nVar = actionMenuView.A) == null)) {
                    nVar.d();
                    h hVar = nVar.B;
                    if (hVar != null && hVar.b()) {
                        hVar.f9899j.dismiss();
                    }
                }
            }
            if (k0Var.D != null) {
                k0Var.f6168s.getDecorView().removeCallbacks(k0Var.E);
                if (k0Var.D.isShowing()) {
                    try {
                        k0Var.D.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                k0Var.D = null;
            }
            n1 n1Var = k0Var.F;
            if (n1Var != null) {
                n1Var.b();
            }
            o oVar = k0Var.Q(0).f6112h;
            if (oVar != null) {
                oVar.c(true);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r17, int r18) {
        /*
            r16 = this;
            r0 = r16
            android.content.Context r1 = r16.getContext()
            android.content.res.Resources r1 = r1.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            int r2 = r1.widthPixels
            int r3 = r1.heightPixels
            r4 = 1
            r5 = 0
            if (r2 >= r3) goto L_0x0018
            r2 = 1
            goto L_0x0019
        L_0x0018:
            r2 = 0
        L_0x0019:
            int r3 = android.view.View.MeasureSpec.getMode(r17)
            int r6 = android.view.View.MeasureSpec.getMode(r18)
            android.graphics.Rect r7 = r0.f637n
            r8 = 6
            r9 = 5
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
            r11 = 1073741824(0x40000000, float:2.0)
            if (r3 != r10) goto L_0x0062
            if (r2 == 0) goto L_0x0030
            android.util.TypedValue r12 = r0.f634k
            goto L_0x0032
        L_0x0030:
            android.util.TypedValue r12 = r0.f633j
        L_0x0032:
            if (r12 == 0) goto L_0x0062
            int r13 = r12.type
            if (r13 == 0) goto L_0x0062
            if (r13 != r9) goto L_0x0040
            float r12 = r12.getDimension(r1)
        L_0x003e:
            int r12 = (int) r12
            goto L_0x004c
        L_0x0040:
            if (r13 != r8) goto L_0x004b
            int r13 = r1.widthPixels
            float r14 = (float) r13
            float r13 = (float) r13
            float r12 = r12.getFraction(r14, r13)
            goto L_0x003e
        L_0x004b:
            r12 = 0
        L_0x004c:
            if (r12 <= 0) goto L_0x0062
            int r13 = r7.left
            int r14 = r7.right
            int r13 = r13 + r14
            int r12 = r12 - r13
            int r13 = android.view.View.MeasureSpec.getSize(r17)
            int r12 = java.lang.Math.min(r12, r13)
            int r12 = android.view.View.MeasureSpec.makeMeasureSpec(r12, r11)
            r13 = 1
            goto L_0x0065
        L_0x0062:
            r12 = r17
            r13 = 0
        L_0x0065:
            if (r6 != r10) goto L_0x009d
            if (r2 == 0) goto L_0x006c
            android.util.TypedValue r6 = r0.f635l
            goto L_0x006e
        L_0x006c:
            android.util.TypedValue r6 = r0.f636m
        L_0x006e:
            if (r6 == 0) goto L_0x009d
            int r14 = r6.type
            if (r14 == 0) goto L_0x009d
            if (r14 != r9) goto L_0x007c
            float r6 = r6.getDimension(r1)
        L_0x007a:
            int r6 = (int) r6
            goto L_0x0088
        L_0x007c:
            if (r14 != r8) goto L_0x0087
            int r14 = r1.heightPixels
            float r15 = (float) r14
            float r14 = (float) r14
            float r6 = r6.getFraction(r15, r14)
            goto L_0x007a
        L_0x0087:
            r6 = 0
        L_0x0088:
            if (r6 <= 0) goto L_0x009d
            int r14 = r7.top
            int r15 = r7.bottom
            int r14 = r14 + r15
            int r6 = r6 - r14
            int r14 = android.view.View.MeasureSpec.getSize(r18)
            int r6 = java.lang.Math.min(r6, r14)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r11)
            goto L_0x009f
        L_0x009d:
            r6 = r18
        L_0x009f:
            super.onMeasure(r12, r6)
            int r12 = r16.getMeasuredWidth()
            int r14 = android.view.View.MeasureSpec.makeMeasureSpec(r12, r11)
            if (r13 != 0) goto L_0x00de
            if (r3 != r10) goto L_0x00de
            if (r2 == 0) goto L_0x00b3
            android.util.TypedValue r2 = r0.f632i
            goto L_0x00b5
        L_0x00b3:
            android.util.TypedValue r2 = r0.f631h
        L_0x00b5:
            if (r2 == 0) goto L_0x00de
            int r3 = r2.type
            if (r3 == 0) goto L_0x00de
            if (r3 != r9) goto L_0x00c3
            float r1 = r2.getDimension(r1)
        L_0x00c1:
            int r1 = (int) r1
            goto L_0x00cf
        L_0x00c3:
            if (r3 != r8) goto L_0x00ce
            int r1 = r1.widthPixels
            float r3 = (float) r1
            float r1 = (float) r1
            float r1 = r2.getFraction(r3, r1)
            goto L_0x00c1
        L_0x00ce:
            r1 = 0
        L_0x00cf:
            if (r1 <= 0) goto L_0x00d7
            int r2 = r7.left
            int r3 = r7.right
            int r2 = r2 + r3
            int r1 = r1 - r2
        L_0x00d7:
            if (r12 >= r1) goto L_0x00de
            int r14 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r11)
            goto L_0x00df
        L_0x00de:
            r4 = 0
        L_0x00df:
            if (r4 == 0) goto L_0x00e4
            super.onMeasure(r14, r6)
        L_0x00e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(d2 d2Var) {
        this.f638o = d2Var;
    }
}
