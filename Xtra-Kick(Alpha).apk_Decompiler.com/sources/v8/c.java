package v8;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import f0.b;
import f0.d;
import java.util.WeakHashMap;
import m0.c1;
import m0.m0;
import t8.n;

public abstract class c extends FrameLayout {

    /* renamed from: p  reason: collision with root package name */
    public static final b f15958p = new b();

    /* renamed from: h  reason: collision with root package name */
    public final n f15959h;

    /* renamed from: i  reason: collision with root package name */
    public int f15960i;

    /* renamed from: j  reason: collision with root package name */
    public final float f15961j;

    /* renamed from: k  reason: collision with root package name */
    public final float f15962k;

    /* renamed from: l  reason: collision with root package name */
    public final int f15963l;

    /* renamed from: m  reason: collision with root package name */
    public final int f15964m;

    /* renamed from: n  reason: collision with root package name */
    public ColorStateList f15965n;

    /* renamed from: o  reason: collision with root package name */
    public PorterDuff.Mode f15966o;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.graphics.drawable.GradientDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.graphics.drawable.GradientDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: t8.i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.graphics.drawable.GradientDrawable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public c(android.content.Context r5, android.util.AttributeSet r6) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r5 = a9.a.a(r5, r6, r0, r0)
            r4.<init>(r5, r6)
            android.content.Context r5 = r4.getContext()
            int[] r1 = v7.a.F
            android.content.res.TypedArray r1 = r5.obtainStyledAttributes(r6, r1)
            r2 = 6
            boolean r3 = r1.hasValue(r2)
            if (r3 == 0) goto L_0x0023
            int r2 = r1.getDimensionPixelSize(r2, r0)
            float r2 = (float) r2
            java.util.WeakHashMap r3 = m0.c1.f10054a
            m0.o0.s(r4, r2)
        L_0x0023:
            r2 = 2
            int r2 = r1.getInt(r2, r0)
            r4.f15960i = r2
            r2 = 8
            boolean r2 = r1.hasValue(r2)
            if (r2 != 0) goto L_0x003a
            r2 = 9
            boolean r2 = r1.hasValue(r2)
            if (r2 == 0) goto L_0x0045
        L_0x003a:
            t8.m r6 = t8.n.b(r5, r6, r0, r0)
            t8.n r2 = new t8.n
            r2.<init>(r6)
            r4.f15959h = r2
        L_0x0045:
            r6 = 3
            r2 = 1065353216(0x3f800000, float:1.0)
            float r6 = r1.getFloat(r6, r2)
            r4.f15961j = r6
            r6 = 4
            android.content.res.ColorStateList r5 = q8.d.a(r5, r1, r6)
            r4.setBackgroundTintList(r5)
            r5 = 5
            r6 = -1
            int r5 = r1.getInt(r5, r6)
            android.graphics.PorterDuff$Mode r3 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r5 = m8.w.d(r5, r3)
            r4.setBackgroundTintMode(r5)
            r5 = 1
            float r2 = r1.getFloat(r5, r2)
            r4.f15962k = r2
            int r2 = r1.getDimensionPixelSize(r0, r6)
            r4.f15963l = r2
            r2 = 7
            int r6 = r1.getDimensionPixelSize(r2, r6)
            r4.f15964m = r6
            r1.recycle()
            v8.b r6 = f15958p
            r4.setOnTouchListener(r6)
            r4.setFocusable(r5)
            android.graphics.drawable.Drawable r5 = r4.getBackground()
            if (r5 != 0) goto L_0x00e6
            float r5 = r4.getBackgroundOverlayColorAlpha()
            r6 = 2130968880(0x7f040130, float:1.7546426E38)
            int r6 = g8.a.b(r4, r6)
            r1 = 2130968858(0x7f04011a, float:1.7546382E38)
            int r1 = g8.a.b(r4, r1)
            int r5 = g8.a.d(r6, r5, r1)
            t8.n r6 = r4.f15959h
            if (r6 == 0) goto L_0x00b3
            int r0 = v8.d.f15967a
            t8.i r0 = new t8.i
            r0.<init>((t8.n) r6)
            android.content.res.ColorStateList r5 = android.content.res.ColorStateList.valueOf(r5)
            r0.k(r5)
            goto L_0x00cf
        L_0x00b3:
            android.content.res.Resources r6 = r4.getResources()
            int r1 = v8.d.f15967a
            r1 = 2131165946(0x7f0702fa, float:1.7946123E38)
            float r6 = r6.getDimension(r1)
            android.graphics.drawable.GradientDrawable r1 = new android.graphics.drawable.GradientDrawable
            r1.<init>()
            r1.setShape(r0)
            r1.setCornerRadius(r6)
            r1.setColor(r5)
            r0 = r1
        L_0x00cf:
            android.content.res.ColorStateList r5 = r4.f15965n
            if (r5 == 0) goto L_0x00dd
            android.graphics.drawable.Drawable r5 = f0.d.g(r0)
            android.content.res.ColorStateList r6 = r4.f15965n
            f0.b.h(r5, r6)
            goto L_0x00e1
        L_0x00dd:
            android.graphics.drawable.Drawable r5 = f0.d.g(r0)
        L_0x00e1:
            java.util.WeakHashMap r6 = m0.c1.f10054a
            m0.i0.q(r4, r5)
        L_0x00e6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v8.c.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private void setBaseTransientBottomBar(d dVar) {
    }

    public float getActionTextColorAlpha() {
        return this.f15962k;
    }

    public int getAnimationMode() {
        return this.f15960i;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.f15961j;
    }

    public int getMaxInlineActionWidth() {
        return this.f15964m;
    }

    public int getMaxWidth() {
        return this.f15963l;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        WeakHashMap weakHashMap = c1.f10054a;
        m0.c(this);
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
    }

    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int i12 = this.f15963l;
        if (i12 > 0 && getMeasuredWidth() > i12) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
        }
    }

    public void setAnimationMode(int i10) {
        this.f15960i = i10;
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (!(drawable == null || this.f15965n == null)) {
            drawable = d.g(drawable.mutate());
            b.h(drawable, this.f15965n);
            b.i(drawable, this.f15966o);
        }
        super.setBackgroundDrawable(drawable);
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.f15965n = colorStateList;
        if (getBackground() != null) {
            Drawable g10 = d.g(getBackground().mutate());
            b.h(g10, colorStateList);
            b.i(g10, this.f15966o);
            if (g10 != getBackground()) {
                super.setBackgroundDrawable(g10);
            }
        }
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.f15966o = mode;
        if (getBackground() != null) {
            Drawable g10 = d.g(getBackground().mutate());
            b.i(g10, mode);
            if (g10 != getBackground()) {
                super.setBackgroundDrawable(g10);
            }
        }
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : f15958p);
        super.setOnClickListener(onClickListener);
    }
}
