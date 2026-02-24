package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.d0;
import f0.l;
import f0.m;
import f8.b;
import f8.d;
import f8.e;
import f8.f;
import h.a;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.WeakHashMap;
import m0.c;
import m0.c1;
import m0.i0;
import m0.j0;
import m8.h;
import m8.o;
import q8.g;
import t8.j;
import t8.n;
import t8.y;

public class Chip extends d0 implements e, y, Checkable {
    public static final Rect D = new Rect();
    public static final int[] E = {16842913};
    public static final int[] F = {16842911};
    public final Rect A = new Rect();
    public final RectF B = new RectF();
    public final b C = new b(0, this);

    /* renamed from: l  reason: collision with root package name */
    public f f3719l;

    /* renamed from: m  reason: collision with root package name */
    public InsetDrawable f3720m;

    /* renamed from: n  reason: collision with root package name */
    public RippleDrawable f3721n;

    /* renamed from: o  reason: collision with root package name */
    public View.OnClickListener f3722o;

    /* renamed from: p  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f3723p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f3724q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f3725r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f3726s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f3727t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f3728u;

    /* renamed from: v  reason: collision with root package name */
    public int f3729v;

    /* renamed from: w  reason: collision with root package name */
    public int f3730w;

    /* renamed from: x  reason: collision with root package name */
    public CharSequence f3731x;

    /* renamed from: y  reason: collision with root package name */
    public final d f3732y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f3733z;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x032d  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0349  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0369  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x037d  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0284  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0298  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Chip(android.content.Context r18, android.util.AttributeSet r19) {
        /*
            r17 = this;
            r0 = r17
            r7 = r19
            r1 = 2132018302(0x7f14047e, float:1.9674907E38)
            r2 = 2130968799(0x7f0400df, float:1.7546262E38)
            r3 = r18
            android.content.Context r1 = a9.a.a(r3, r7, r2, r1)
            r0.<init>(r1, r7, r2)
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.A = r1
            android.graphics.RectF r1 = new android.graphics.RectF
            r1.<init>()
            r0.B = r1
            f8.b r1 = new f8.b
            r8 = 0
            r1.<init>(r8, r0)
            r0.C = r1
            android.content.Context r9 = r17.getContext()
            r10 = 1
            r11 = 8388627(0x800013, float:1.175497E-38)
            if (r7 != 0) goto L_0x0034
            goto L_0x0094
        L_0x0034:
            java.lang.String r1 = "http://schemas.android.com/apk/res/android"
            java.lang.String r2 = "background"
            java.lang.String r2 = r7.getAttributeValue(r1, r2)
            java.lang.String r3 = "Chip"
            if (r2 == 0) goto L_0x0045
            java.lang.String r2 = "Do not set the background; Chip manages its own background drawable."
            android.util.Log.w(r3, r2)
        L_0x0045:
            java.lang.String r2 = "drawableLeft"
            java.lang.String r2 = r7.getAttributeValue(r1, r2)
            if (r2 != 0) goto L_0x03ad
            java.lang.String r2 = "drawableStart"
            java.lang.String r2 = r7.getAttributeValue(r1, r2)
            if (r2 != 0) goto L_0x03a5
            java.lang.String r2 = "drawableEnd"
            java.lang.String r2 = r7.getAttributeValue(r1, r2)
            java.lang.String r4 = "Please set end drawable using R.attr#closeIcon."
            if (r2 != 0) goto L_0x039f
            java.lang.String r2 = "drawableRight"
            java.lang.String r2 = r7.getAttributeValue(r1, r2)
            if (r2 != 0) goto L_0x0399
            java.lang.String r2 = "singleLine"
            boolean r2 = r7.getAttributeBooleanValue(r1, r2, r10)
            if (r2 == 0) goto L_0x0391
            java.lang.String r2 = "lines"
            int r2 = r7.getAttributeIntValue(r1, r2, r10)
            if (r2 != r10) goto L_0x0391
            java.lang.String r2 = "minLines"
            int r2 = r7.getAttributeIntValue(r1, r2, r10)
            if (r2 != r10) goto L_0x0391
            java.lang.String r2 = "maxLines"
            int r2 = r7.getAttributeIntValue(r1, r2, r10)
            if (r2 != r10) goto L_0x0391
            java.lang.String r2 = "gravity"
            int r1 = r7.getAttributeIntValue(r1, r2, r11)
            if (r1 == r11) goto L_0x0094
            java.lang.String r1 = "Chip text must be vertically center and start aligned"
            android.util.Log.w(r3, r1)
        L_0x0094:
            f8.f r12 = new f8.f
            r12.<init>(r9, r7)
            android.content.Context r1 = r12.f5968l0
            int[] r13 = v7.a.f15937f
            int[] r6 = new int[r8]
            r5 = 2132018302(0x7f14047e, float:1.9674907E38)
            r4 = 2130968799(0x7f0400df, float:1.7546262E38)
            r2 = r19
            r3 = r13
            android.content.res.TypedArray r1 = m8.r.d(r1, r2, r3, r4, r5, r6)
            r14 = 37
            boolean r2 = r1.hasValue(r14)
            r12.M0 = r2
            r2 = 24
            android.content.Context r3 = r12.f5968l0
            android.content.res.ColorStateList r2 = q8.d.a(r3, r1, r2)
            android.content.res.ColorStateList r4 = r12.E
            if (r4 == r2) goto L_0x00c9
            r12.E = r2
            int[] r2 = r12.getState()
            r12.onStateChange(r2)
        L_0x00c9:
            r2 = 11
            android.content.res.ColorStateList r2 = q8.d.a(r3, r1, r2)
            android.content.res.ColorStateList r4 = r12.F
            if (r4 == r2) goto L_0x00dc
            r12.F = r2
            int[] r2 = r12.getState()
            r12.onStateChange(r2)
        L_0x00dc:
            r2 = 19
            r4 = 0
            float r2 = r1.getDimension(r2, r4)
            float r5 = r12.G
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x00f1
            r12.G = r2
            r12.invalidateSelf()
            r12.v()
        L_0x00f1:
            r2 = 12
            boolean r5 = r1.hasValue(r2)
            if (r5 == 0) goto L_0x0100
            float r2 = r1.getDimension(r2, r4)
            r12.B(r2)
        L_0x0100:
            r2 = 22
            android.content.res.ColorStateList r2 = q8.d.a(r3, r1, r2)
            r12.G(r2)
            r15 = 23
            float r2 = r1.getDimension(r15, r4)
            r12.H(r2)
            r2 = 36
            android.content.res.ColorStateList r2 = q8.d.a(r3, r1, r2)
            r12.Q(r2)
            r2 = 5
            java.lang.CharSequence r2 = r1.getText(r2)
            if (r2 != 0) goto L_0x0124
            java.lang.String r2 = ""
        L_0x0124:
            java.lang.CharSequence r5 = r12.L
            boolean r5 = android.text.TextUtils.equals(r5, r2)
            m8.o r6 = r12.f5974r0
            if (r5 != 0) goto L_0x0138
            r12.L = r2
            r6.f10790d = r10
            r12.invalidateSelf()
            r12.v()
        L_0x0138:
            boolean r2 = r1.hasValue(r8)
            if (r2 == 0) goto L_0x014a
            int r2 = r1.getResourceId(r8, r8)
            if (r2 == 0) goto L_0x014a
            q8.g r5 = new q8.g
            r5.<init>(r3, r2)
            goto L_0x014b
        L_0x014a:
            r5 = 0
        L_0x014b:
            float r2 = r5.f13427k
            float r2 = r1.getDimension(r10, r2)
            r5.f13427k = r2
            int r2 = android.os.Build.VERSION.SDK_INT
            r11 = 2
            if (r2 >= r15) goto L_0x015e
            android.content.res.ColorStateList r14 = q8.d.a(r3, r1, r11)
            r5.f13426j = r14
        L_0x015e:
            r6.b(r5, r3)
            r5 = 3
            int r6 = r1.getInt(r5, r8)
            if (r6 == r10) goto L_0x0173
            if (r6 == r11) goto L_0x0170
            if (r6 == r5) goto L_0x016d
            goto L_0x0177
        L_0x016d:
            android.text.TextUtils$TruncateAt r5 = android.text.TextUtils.TruncateAt.END
            goto L_0x0175
        L_0x0170:
            android.text.TextUtils$TruncateAt r5 = android.text.TextUtils.TruncateAt.MIDDLE
            goto L_0x0175
        L_0x0173:
            android.text.TextUtils$TruncateAt r5 = android.text.TextUtils.TruncateAt.START
        L_0x0175:
            r12.J0 = r5
        L_0x0177:
            r5 = 18
            boolean r5 = r1.getBoolean(r5, r8)
            r12.F(r5)
            java.lang.String r5 = "http://schemas.android.com/apk/res-auto"
            if (r7 == 0) goto L_0x019d
            java.lang.String r6 = "chipIconEnabled"
            java.lang.String r6 = r7.getAttributeValue(r5, r6)
            if (r6 == 0) goto L_0x019d
            java.lang.String r6 = "chipIconVisible"
            java.lang.String r6 = r7.getAttributeValue(r5, r6)
            if (r6 != 0) goto L_0x019d
            r6 = 15
            boolean r6 = r1.getBoolean(r6, r8)
            r12.F(r6)
        L_0x019d:
            r6 = 14
            android.graphics.drawable.Drawable r6 = q8.d.c(r3, r1, r6)
            r12.C(r6)
            r6 = 17
            boolean r14 = r1.hasValue(r6)
            if (r14 == 0) goto L_0x01b5
            android.content.res.ColorStateList r6 = q8.d.a(r3, r1, r6)
            r12.E(r6)
        L_0x01b5:
            r6 = 16
            r14 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r6 = r1.getDimension(r6, r14)
            r12.D(r6)
            r6 = 31
            boolean r6 = r1.getBoolean(r6, r8)
            r12.N(r6)
            if (r7 == 0) goto L_0x01e4
            java.lang.String r6 = "closeIconEnabled"
            java.lang.String r6 = r7.getAttributeValue(r5, r6)
            if (r6 == 0) goto L_0x01e4
            java.lang.String r6 = "closeIconVisible"
            java.lang.String r6 = r7.getAttributeValue(r5, r6)
            if (r6 != 0) goto L_0x01e4
            r6 = 26
            boolean r6 = r1.getBoolean(r6, r8)
            r12.N(r6)
        L_0x01e4:
            r6 = 25
            android.graphics.drawable.Drawable r6 = q8.d.c(r3, r1, r6)
            r12.I(r6)
            r6 = 30
            android.content.res.ColorStateList r6 = q8.d.a(r3, r1, r6)
            r12.M(r6)
            r6 = 28
            float r6 = r1.getDimension(r6, r4)
            r12.K(r6)
            r6 = 6
            boolean r6 = r1.getBoolean(r6, r8)
            r12.x(r6)
            r6 = 10
            boolean r6 = r1.getBoolean(r6, r8)
            r12.A(r6)
            if (r7 == 0) goto L_0x022b
            java.lang.String r6 = "checkedIconEnabled"
            java.lang.String r6 = r7.getAttributeValue(r5, r6)
            if (r6 == 0) goto L_0x022b
            java.lang.String r6 = "checkedIconVisible"
            java.lang.String r5 = r7.getAttributeValue(r5, r6)
            if (r5 != 0) goto L_0x022b
            r5 = 8
            boolean r5 = r1.getBoolean(r5, r8)
            r12.A(r5)
        L_0x022b:
            r5 = 7
            android.graphics.drawable.Drawable r5 = q8.d.c(r3, r1, r5)
            r12.y(r5)
            r5 = 9
            boolean r6 = r1.hasValue(r5)
            if (r6 == 0) goto L_0x0242
            android.content.res.ColorStateList r5 = q8.d.a(r3, r1, r5)
            r12.z(r5)
        L_0x0242:
            r5 = 39
            w7.f r5 = w7.f.a(r3, r1, r5)
            r12.f5958b0 = r5
            r5 = 33
            w7.f r3 = w7.f.a(r3, r1, r5)
            r12.f5959c0 = r3
            r3 = 21
            float r3 = r1.getDimension(r3, r4)
            float r5 = r12.f5960d0
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0266
            r12.f5960d0 = r3
            r12.invalidateSelf()
            r12.v()
        L_0x0266:
            r3 = 35
            float r3 = r1.getDimension(r3, r4)
            r12.P(r3)
            r3 = 34
            float r3 = r1.getDimension(r3, r4)
            r12.O(r3)
            r3 = 41
            float r3 = r1.getDimension(r3, r4)
            float r5 = r12.f5963g0
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x028c
            r12.f5963g0 = r3
            r12.invalidateSelf()
            r12.v()
        L_0x028c:
            r3 = 40
            float r3 = r1.getDimension(r3, r4)
            float r5 = r12.f5964h0
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x02a0
            r12.f5964h0 = r3
            r12.invalidateSelf()
            r12.v()
        L_0x02a0:
            r3 = 29
            float r3 = r1.getDimension(r3, r4)
            r12.L(r3)
            r3 = 27
            float r3 = r1.getDimension(r3, r4)
            r12.J(r3)
            r3 = 13
            float r3 = r1.getDimension(r3, r4)
            float r4 = r12.f5967k0
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x02c6
            r12.f5967k0 = r3
            r12.invalidateSelf()
            r12.v()
        L_0x02c6:
            r3 = 4
            r4 = 2147483647(0x7fffffff, float:NaN)
            int r3 = r1.getDimensionPixelSize(r3, r4)
            r12.L0 = r3
            r1.recycle()
            r14 = 2132018302(0x7f14047e, float:1.9674907E38)
            int[] r6 = new int[r8]
            r16 = 2130968799(0x7f0400df, float:1.7546262E38)
            r4 = 2130968799(0x7f0400df, float:1.7546262E38)
            r5 = 2132018302(0x7f14047e, float:1.9674907E38)
            r1 = r9
            r3 = r2
            r2 = r19
            r10 = r3
            r3 = r13
            android.content.res.TypedArray r1 = m8.r.d(r1, r2, r3, r4, r5, r6)
            r2 = 32
            boolean r2 = r1.getBoolean(r2, r8)
            r0.f3728u = r2
            android.content.Context r2 = r17.getContext()
            r3 = 48
            float r2 = m8.w.b(r2, r3)
            double r2 = (double) r2
            double r2 = java.lang.Math.ceil(r2)
            float r2 = (float) r2
            r3 = 20
            float r2 = r1.getDimension(r3, r2)
            double r2 = (double) r2
            double r2 = java.lang.Math.ceil(r2)
            int r2 = (int) r2
            r0.f3730w = r2
            r1.recycle()
            r0.setChipDrawable(r12)
            float r1 = m0.o0.i(r17)
            r12.j(r1)
            int[] r6 = new int[r8]
            r1 = r9
            r2 = r19
            r3 = r13
            r4 = r16
            r5 = r14
            android.content.res.TypedArray r1 = m8.r.d(r1, r2, r3, r4, r5, r6)
            if (r10 >= r15) goto L_0x0334
            android.content.res.ColorStateList r2 = q8.d.a(r9, r1, r11)
            r0.setTextColor(r2)
        L_0x0334:
            r2 = 37
            boolean r2 = r1.hasValue(r2)
            r1.recycle()
            f8.d r1 = new f8.d
            r1.<init>(r0, r0)
            r0.f3732y = r1
            r17.d()
            if (r2 != 0) goto L_0x0351
            f8.c r1 = new f8.c
            r1.<init>(r0)
            r0.setOutlineProvider(r1)
        L_0x0351:
            boolean r1 = r0.f3724q
            r0.setChecked(r1)
            java.lang.CharSequence r1 = r12.L
            r0.setText(r1)
            android.text.TextUtils$TruncateAt r1 = r12.J0
            r0.setEllipsize(r1)
            r17.g()
            f8.f r1 = r0.f3719l
            boolean r1 = r1.K0
            if (r1 != 0) goto L_0x0370
            r1 = 1
            r0.setLines(r1)
            r0.setHorizontallyScrolling(r1)
        L_0x0370:
            r1 = 8388627(0x800013, float:1.175497E-38)
            r0.setGravity(r1)
            r17.f()
            boolean r1 = r0.f3728u
            if (r1 == 0) goto L_0x0382
            int r1 = r0.f3730w
            r0.setMinHeight(r1)
        L_0x0382:
            int r1 = m0.j0.d(r17)
            r0.f3729v = r1
            f8.a r1 = new f8.a
            r1.<init>(r0)
            super.setOnCheckedChangeListener(r1)
            return
        L_0x0391:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            java.lang.String r2 = "Chip does not support multi-line text"
            r1.<init>(r2)
            throw r1
        L_0x0399:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            r1.<init>(r4)
            throw r1
        L_0x039f:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            r1.<init>(r4)
            throw r1
        L_0x03a5:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            java.lang.String r2 = "Please set start drawable using R.attr#chipIcon."
            r1.<init>(r2)
            throw r1
        L_0x03ad:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            java.lang.String r2 = "Please set left drawable using R.attr#chipIcon."
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private RectF getCloseIconTouchBounds() {
        RectF rectF = this.B;
        rectF.setEmpty();
        if (c() && this.f3722o != null) {
            f fVar = this.f3719l;
            Rect bounds = fVar.getBounds();
            rectF.setEmpty();
            if (fVar.T()) {
                float f10 = fVar.f5967k0 + fVar.f5966j0 + fVar.V + fVar.f5965i0 + fVar.f5964h0;
                if (f0.d.b(fVar) == 0) {
                    float f11 = (float) bounds.right;
                    rectF.right = f11;
                    rectF.left = f11 - f10;
                } else {
                    float f12 = (float) bounds.left;
                    rectF.left = f12;
                    rectF.right = f12 + f10;
                }
                rectF.top = (float) bounds.top;
                rectF.bottom = (float) bounds.bottom;
            }
        }
        return rectF;
    }

    /* access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        Rect rect = this.A;
        rect.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return rect;
    }

    private g getTextAppearance() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return fVar.f5974r0.f10792f;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z10) {
        if (this.f3726s != z10) {
            this.f3726s = z10;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z10) {
        if (this.f3725r != z10) {
            this.f3725r = z10;
            refreshDrawableState();
        }
    }

    public final void b(int i10) {
        int i11;
        int i12;
        this.f3730w = i10;
        if (!this.f3728u) {
            InsetDrawable insetDrawable = this.f3720m;
            if (insetDrawable == null) {
                int[] iArr = r8.d.f13884a;
                e();
            } else if (insetDrawable != null) {
                this.f3720m = null;
                setMinWidth(0);
                setMinHeight((int) getChipMinHeight());
                int[] iArr2 = r8.d.f13884a;
                e();
            }
        } else {
            int max = Math.max(0, i10 - ((int) this.f3719l.G));
            int max2 = Math.max(0, i10 - this.f3719l.getIntrinsicWidth());
            if (max2 > 0 || max > 0) {
                if (max2 > 0) {
                    i11 = max2 / 2;
                } else {
                    i11 = 0;
                }
                if (max > 0) {
                    i12 = max / 2;
                } else {
                    i12 = 0;
                }
                if (this.f3720m != null) {
                    Rect rect = new Rect();
                    this.f3720m.getPadding(rect);
                    if (rect.top == i12 && rect.bottom == i12 && rect.left == i11 && rect.right == i11) {
                        int[] iArr3 = r8.d.f13884a;
                        e();
                        return;
                    }
                }
                if (getMinHeight() != i10) {
                    setMinHeight(i10);
                }
                if (getMinWidth() != i10) {
                    setMinWidth(i10);
                }
                this.f3720m = new InsetDrawable(this.f3719l, i11, i12, i11, i12);
                int[] iArr4 = r8.d.f13884a;
                e();
                return;
            }
            InsetDrawable insetDrawable2 = this.f3720m;
            if (insetDrawable2 == null) {
                int[] iArr5 = r8.d.f13884a;
                e();
            } else if (insetDrawable2 != null) {
                this.f3720m = null;
                setMinWidth(0);
                setMinHeight((int) getChipMinHeight());
                int[] iArr6 = r8.d.f13884a;
                e();
            }
        }
    }

    public final boolean c() {
        f fVar = this.f3719l;
        if (fVar != null) {
            Drawable drawable = fVar.S;
            if (drawable == null) {
                drawable = null;
            } else if (drawable instanceof l) {
                drawable = ((m) ((l) drawable)).f5427m;
            }
            if (drawable != null) {
                return true;
            }
        }
        return false;
    }

    public final void d() {
        boolean z10;
        boolean z11 = false;
        if (c()) {
            f fVar = this.f3719l;
            if (fVar == null || !fVar.R) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10 && this.f3722o != null) {
                c1.p(this, this.f3732y);
                z11 = true;
                this.f3733z = z11;
            }
        }
        c1.p(this, (c) null);
        this.f3733z = z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006c, code lost:
        if (r1 != Integer.MIN_VALUE) goto L_0x006e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0079 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchHoverEvent(android.view.MotionEvent r11) {
        /*
            r10 = this;
            boolean r0 = r10.f3733z
            if (r0 != 0) goto L_0x0009
            boolean r11 = super.dispatchHoverEvent(r11)
            return r11
        L_0x0009:
            f8.d r0 = r10.f3732y
            android.view.accessibility.AccessibilityManager r1 = r0.f5950h
            boolean r2 = r1.isEnabled()
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0070
            boolean r1 = r1.isTouchExplorationEnabled()
            if (r1 != 0) goto L_0x001c
            goto L_0x0070
        L_0x001c:
            int r1 = r11.getAction()
            r2 = 256(0x100, float:3.59E-43)
            r5 = 128(0x80, float:1.794E-43)
            r6 = 7
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 == r6) goto L_0x0042
            r6 = 9
            if (r1 == r6) goto L_0x0042
            r6 = 10
            if (r1 == r6) goto L_0x0032
            goto L_0x0070
        L_0x0032:
            int r1 = r0.f5955m
            if (r1 == r7) goto L_0x0070
            if (r1 != r7) goto L_0x0039
            goto L_0x006e
        L_0x0039:
            r0.f5955m = r7
            r0.q(r7, r5)
            r0.q(r1, r2)
            goto L_0x006e
        L_0x0042:
            float r1 = r11.getX()
            float r6 = r11.getY()
            com.google.android.material.chip.Chip r8 = r0.f5956n
            boolean r9 = r8.c()
            if (r9 == 0) goto L_0x005e
            android.graphics.RectF r8 = r8.getCloseIconTouchBounds()
            boolean r1 = r8.contains(r1, r6)
            if (r1 == 0) goto L_0x005e
            r1 = 1
            goto L_0x005f
        L_0x005e:
            r1 = 0
        L_0x005f:
            int r6 = r0.f5955m
            if (r6 != r1) goto L_0x0064
            goto L_0x006c
        L_0x0064:
            r0.f5955m = r1
            r0.q(r1, r5)
            r0.q(r6, r2)
        L_0x006c:
            if (r1 == r7) goto L_0x0070
        L_0x006e:
            r0 = 1
            goto L_0x0071
        L_0x0070:
            r0 = 0
        L_0x0071:
            if (r0 != 0) goto L_0x0079
            boolean r11 = super.dispatchHoverEvent(r11)
            if (r11 == 0) goto L_0x007a
        L_0x0079:
            r3 = 1
        L_0x007a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.dispatchHoverEvent(android.view.MotionEvent):boolean");
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f3733z) {
            return super.dispatchKeyEvent(keyEvent);
        }
        d dVar = this.f3732y;
        dVar.getClass();
        int i10 = 0;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                int i11 = 66;
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            if (keyEvent.hasNoModifiers()) {
                                if (keyCode == 19) {
                                    i11 = 33;
                                } else if (keyCode == 21) {
                                    i11 = 17;
                                } else if (keyCode != 22) {
                                    i11 = 130;
                                }
                                int repeatCount = keyEvent.getRepeatCount() + 1;
                                int i12 = 0;
                                while (i10 < repeatCount && dVar.m(i11, (Rect) null)) {
                                    i10++;
                                    i12 = 1;
                                }
                                i10 = i12;
                                break;
                            }
                            break;
                        case 23:
                            break;
                    }
                }
                if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                    int i13 = dVar.f5954l;
                    if (i13 != Integer.MIN_VALUE) {
                        Chip chip = dVar.f5956n;
                        if (i13 == 0) {
                            chip.performClick();
                        } else if (i13 == 1) {
                            chip.playSoundEffect(0);
                            View.OnClickListener onClickListener = chip.f3722o;
                            if (onClickListener != null) {
                                onClickListener.onClick(chip);
                            }
                            if (chip.f3733z) {
                                chip.f3732y.q(1, 1);
                            }
                        }
                    }
                    i10 = 1;
                }
            } else if (keyEvent.hasNoModifiers()) {
                i10 = dVar.m(2, (Rect) null);
            } else if (keyEvent.hasModifiers(1)) {
                i10 = dVar.m(1, (Rect) null);
            }
        }
        if (i10 == 0 || dVar.f5954l == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public final void drawableStateChanged() {
        int i10;
        super.drawableStateChanged();
        f fVar = this.f3719l;
        boolean z10 = false;
        if (fVar != null && f.u(fVar.S)) {
            f fVar2 = this.f3719l;
            int isEnabled = isEnabled();
            if (this.f3727t) {
                isEnabled++;
            }
            if (this.f3726s) {
                isEnabled++;
            }
            if (this.f3725r) {
                isEnabled++;
            }
            if (isChecked()) {
                isEnabled++;
            }
            int[] iArr = new int[isEnabled];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i10 = 1;
            } else {
                i10 = 0;
            }
            if (this.f3727t) {
                iArr[i10] = 16842908;
                i10++;
            }
            if (this.f3726s) {
                iArr[i10] = 16843623;
                i10++;
            }
            if (this.f3725r) {
                iArr[i10] = 16842919;
                i10++;
            }
            if (isChecked()) {
                iArr[i10] = 16842913;
            }
            if (!Arrays.equals(fVar2.F0, iArr)) {
                fVar2.F0 = iArr;
                if (fVar2.T()) {
                    z10 = fVar2.w(fVar2.getState(), iArr);
                }
            }
        }
        if (z10) {
            invalidate();
        }
    }

    public final void e() {
        this.f3721n = new RippleDrawable(r8.d.c(this.f3719l.K), getBackgroundDrawable(), (Drawable) null);
        f fVar = this.f3719l;
        if (fVar.G0) {
            fVar.G0 = false;
            fVar.H0 = null;
            fVar.onStateChange(fVar.getState());
        }
        RippleDrawable rippleDrawable = this.f3721n;
        WeakHashMap weakHashMap = c1.f10054a;
        i0.q(this, rippleDrawable);
        f();
    }

    public final void f() {
        f fVar;
        if (!TextUtils.isEmpty(getText()) && (fVar = this.f3719l) != null) {
            int r10 = (int) (fVar.r() + fVar.f5967k0 + fVar.f5964h0);
            f fVar2 = this.f3719l;
            int q10 = (int) (fVar2.q() + fVar2.f5960d0 + fVar2.f5963g0);
            if (this.f3720m != null) {
                Rect rect = new Rect();
                this.f3720m.getPadding(rect);
                q10 += rect.left;
                r10 += rect.right;
            }
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            WeakHashMap weakHashMap = c1.f10054a;
            j0.k(this, q10, paddingTop, r10, paddingBottom);
        }
    }

    public final void g() {
        TextPaint paint = getPaint();
        f fVar = this.f3719l;
        if (fVar != null) {
            paint.drawableState = fVar.getState();
        }
        g textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.e(getContext(), paint, this.C);
        }
    }

    public CharSequence getAccessibilityClassName() {
        boolean z10;
        if (!TextUtils.isEmpty(this.f3731x)) {
            return this.f3731x;
        }
        f fVar = this.f3719l;
        if (fVar == null || !fVar.X) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            getParent();
            return "android.widget.Button";
        } else if (isClickable()) {
            return "android.widget.Button";
        } else {
            return "android.view.View";
        }
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f3720m;
        return insetDrawable == null ? this.f3719l : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return fVar.Z;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return fVar.f5957a0;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return fVar.F;
        }
        return null;
    }

    public float getChipCornerRadius() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return Math.max(0.0f, fVar.s());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f3719l;
    }

    public float getChipEndPadding() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return fVar.f5967k0;
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        Drawable drawable;
        f fVar = this.f3719l;
        if (fVar == null || (drawable = fVar.N) == null) {
            return null;
        }
        if (drawable instanceof l) {
            drawable = ((m) ((l) drawable)).f5427m;
        }
        return drawable;
    }

    public float getChipIconSize() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return fVar.P;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return fVar.O;
        }
        return null;
    }

    public float getChipMinHeight() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return fVar.G;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return fVar.f5960d0;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return fVar.I;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return fVar.J;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        Drawable drawable;
        f fVar = this.f3719l;
        if (fVar == null || (drawable = fVar.S) == null) {
            return null;
        }
        if (drawable instanceof l) {
            drawable = ((m) ((l) drawable)).f5427m;
        }
        return drawable;
    }

    public CharSequence getCloseIconContentDescription() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return fVar.W;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return fVar.f5966j0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return fVar.V;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return fVar.f5965i0;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return fVar.U;
        }
        return null;
    }

    public TextUtils.TruncateAt getEllipsize() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return fVar.J0;
        }
        return null;
    }

    public final void getFocusedRect(Rect rect) {
        if (this.f3733z) {
            d dVar = this.f3732y;
            if (dVar.f5954l == 1 || dVar.f5953k == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    public w7.f getHideMotionSpec() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return fVar.f5959c0;
        }
        return null;
    }

    public float getIconEndPadding() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return fVar.f5962f0;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return fVar.f5961e0;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return fVar.K;
        }
        return null;
    }

    public n getShapeAppearanceModel() {
        return this.f3719l.f14744h.f14723a;
    }

    public w7.f getShowMotionSpec() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return fVar.f5958b0;
        }
        return null;
    }

    public float getTextEndPadding() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return fVar.f5964h0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        f fVar = this.f3719l;
        if (fVar != null) {
            return fVar.f5963g0;
        }
        return 0.0f;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.d(this, this.f3719l);
    }

    public final int[] onCreateDrawableState(int i10) {
        boolean z10;
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, E);
        }
        f fVar = this.f3719l;
        if (fVar == null || !fVar.X) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            View.mergeDrawableStates(onCreateDrawableState, F);
        }
        return onCreateDrawableState;
    }

    public final void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (this.f3733z) {
            d dVar = this.f3732y;
            int i11 = dVar.f5954l;
            if (i11 != Integer.MIN_VALUE) {
                dVar.j(i11);
            }
            if (z10) {
                dVar.m(i10, rect);
            }
        }
    }

    public final boolean onHoverEvent(MotionEvent motionEvent) {
        boolean z10;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10) {
                z10 = false;
            }
            return super.onHoverEvent(motionEvent);
        }
        z10 = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        setCloseIconHovered(z10);
        return super.onHoverEvent(motionEvent);
    }

    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        boolean z10;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        f fVar = this.f3719l;
        if (fVar == null || !fVar.X) {
            z10 = false;
        } else {
            z10 = true;
        }
        accessibilityNodeInfo.setCheckable(z10);
        accessibilityNodeInfo.setClickable(isClickable());
        getParent();
    }

    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i10) {
        if (!getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) || !isEnabled()) {
            return null;
        }
        return PointerIcon.getSystemIcon(getContext(), 1002);
    }

    public final void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        if (this.f3729v != i10) {
            this.f3729v = i10;
            f();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r0 != 3) goto L_0x0050;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005a A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0049
            if (r0 == r2) goto L_0x002b
            r4 = 2
            if (r0 == r4) goto L_0x0021
            r1 = 3
            if (r0 == r1) goto L_0x0044
            goto L_0x0050
        L_0x0021:
            boolean r0 = r5.f3725r
            if (r0 == 0) goto L_0x0050
            if (r1 != 0) goto L_0x004e
            r5.setCloseIconPressed(r3)
            goto L_0x004e
        L_0x002b:
            boolean r0 = r5.f3725r
            if (r0 == 0) goto L_0x0044
            r5.playSoundEffect(r3)
            android.view.View$OnClickListener r0 = r5.f3722o
            if (r0 == 0) goto L_0x0039
            r0.onClick(r5)
        L_0x0039:
            boolean r0 = r5.f3733z
            if (r0 == 0) goto L_0x0042
            f8.d r0 = r5.f3732y
            r0.q(r2, r2)
        L_0x0042:
            r0 = 1
            goto L_0x0045
        L_0x0044:
            r0 = 0
        L_0x0045:
            r5.setCloseIconPressed(r3)
            goto L_0x0051
        L_0x0049:
            if (r1 == 0) goto L_0x0050
            r5.setCloseIconPressed(r2)
        L_0x004e:
            r0 = 1
            goto L_0x0051
        L_0x0050:
            r0 = 0
        L_0x0051:
            if (r0 != 0) goto L_0x005b
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L_0x005a
            goto L_0x005b
        L_0x005a:
            r2 = 0
        L_0x005b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.f3731x = charSequence;
    }

    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f3721n) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    public void setBackgroundColor(int i10) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f3721n) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    public void setBackgroundResource(int i10) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.x(z10);
        }
    }

    public void setCheckableResource(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.x(fVar.f5968l0.getResources().getBoolean(i10));
        }
    }

    public void setChecked(boolean z10) {
        f fVar = this.f3719l;
        if (fVar == null) {
            this.f3724q = z10;
        } else if (fVar.X) {
            super.setChecked(z10);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.y(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z10) {
        setCheckedIconVisible(z10);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i10) {
        setCheckedIconVisible(i10);
    }

    public void setCheckedIconResource(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.y(a.a(fVar.f5968l0, i10));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.z(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.z(c0.g.c(fVar.f5968l0, i10));
        }
    }

    public void setCheckedIconVisible(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.A(fVar.f5968l0.getResources().getBoolean(i10));
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        f fVar = this.f3719l;
        if (fVar != null && fVar.F != colorStateList) {
            fVar.F = colorStateList;
            fVar.onStateChange(fVar.getState());
        }
    }

    public void setChipBackgroundColorResource(int i10) {
        ColorStateList c10;
        f fVar = this.f3719l;
        if (fVar != null && fVar.F != (c10 = c0.g.c(fVar.f5968l0, i10))) {
            fVar.F = c10;
            fVar.onStateChange(fVar.getState());
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.B(f10);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.B(fVar.f5968l0.getResources().getDimension(i10));
        }
    }

    public void setChipDrawable(f fVar) {
        f fVar2 = this.f3719l;
        if (fVar2 != fVar) {
            if (fVar2 != null) {
                fVar2.I0 = new WeakReference((Object) null);
            }
            this.f3719l = fVar;
            fVar.K0 = false;
            fVar.I0 = new WeakReference(this);
            b(this.f3730w);
        }
    }

    public void setChipEndPadding(float f10) {
        f fVar = this.f3719l;
        if (fVar != null && fVar.f5967k0 != f10) {
            fVar.f5967k0 = f10;
            fVar.invalidateSelf();
            fVar.v();
        }
    }

    public void setChipEndPaddingResource(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            float dimension = fVar.f5968l0.getResources().getDimension(i10);
            if (fVar.f5967k0 != dimension) {
                fVar.f5967k0 = dimension;
                fVar.invalidateSelf();
                fVar.v();
            }
        }
    }

    public void setChipIcon(Drawable drawable) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.C(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z10) {
        setChipIconVisible(z10);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i10) {
        setChipIconVisible(i10);
    }

    public void setChipIconResource(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.C(a.a(fVar.f5968l0, i10));
        }
    }

    public void setChipIconSize(float f10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.D(f10);
        }
    }

    public void setChipIconSizeResource(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.D(fVar.f5968l0.getResources().getDimension(i10));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.E(colorStateList);
        }
    }

    public void setChipIconTintResource(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.E(c0.g.c(fVar.f5968l0, i10));
        }
    }

    public void setChipIconVisible(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.F(fVar.f5968l0.getResources().getBoolean(i10));
        }
    }

    public void setChipMinHeight(float f10) {
        f fVar = this.f3719l;
        if (fVar != null && fVar.G != f10) {
            fVar.G = f10;
            fVar.invalidateSelf();
            fVar.v();
        }
    }

    public void setChipMinHeightResource(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            float dimension = fVar.f5968l0.getResources().getDimension(i10);
            if (fVar.G != dimension) {
                fVar.G = dimension;
                fVar.invalidateSelf();
                fVar.v();
            }
        }
    }

    public void setChipStartPadding(float f10) {
        f fVar = this.f3719l;
        if (fVar != null && fVar.f5960d0 != f10) {
            fVar.f5960d0 = f10;
            fVar.invalidateSelf();
            fVar.v();
        }
    }

    public void setChipStartPaddingResource(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            float dimension = fVar.f5968l0.getResources().getDimension(i10);
            if (fVar.f5960d0 != dimension) {
                fVar.f5960d0 = dimension;
                fVar.invalidateSelf();
                fVar.v();
            }
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.G(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.G(c0.g.c(fVar.f5968l0, i10));
        }
    }

    public void setChipStrokeWidth(float f10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.H(f10);
        }
    }

    public void setChipStrokeWidthResource(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.H(fVar.f5968l0.getResources().getDimension(i10));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i10) {
        setText(getResources().getString(i10));
    }

    public void setCloseIcon(Drawable drawable) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.I(drawable);
        }
        d();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        f fVar = this.f3719l;
        if (fVar != null && fVar.W != charSequence) {
            k0.c c10 = k0.c.c();
            fVar.W = c10.d(charSequence, c10.f8949c);
            fVar.invalidateSelf();
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z10) {
        setCloseIconVisible(z10);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i10) {
        setCloseIconVisible(i10);
    }

    public void setCloseIconEndPadding(float f10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.J(f10);
        }
    }

    public void setCloseIconEndPaddingResource(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.J(fVar.f5968l0.getResources().getDimension(i10));
        }
    }

    public void setCloseIconResource(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.I(a.a(fVar.f5968l0, i10));
        }
        d();
    }

    public void setCloseIconSize(float f10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.K(f10);
        }
    }

    public void setCloseIconSizeResource(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.K(fVar.f5968l0.getResources().getDimension(i10));
        }
    }

    public void setCloseIconStartPadding(float f10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.L(f10);
        }
    }

    public void setCloseIconStartPaddingResource(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.L(fVar.f5968l0.getResources().getDimension(i10));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.M(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.M(c0.g.c(fVar.f5968l0, i10));
        }
    }

    public void setCloseIconVisible(int i10) {
        setCloseIconVisible(getResources().getBoolean(i10));
    }

    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i12 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i10, i11, i12, i13);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public final void setCompoundDrawablesWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i12 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i10, i11, i12, i13);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setElevation(float f10) {
        super.setElevation(f10);
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.j(f10);
        }
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f3719l != null) {
            if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
                super.setEllipsize(truncateAt);
                f fVar = this.f3719l;
                if (fVar != null) {
                    fVar.J0 = truncateAt;
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        this.f3728u = z10;
        b(this.f3730w);
    }

    public void setGravity(int i10) {
        if (i10 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i10);
        }
    }

    public void setHideMotionSpec(w7.f fVar) {
        f fVar2 = this.f3719l;
        if (fVar2 != null) {
            fVar2.f5959c0 = fVar;
        }
    }

    public void setHideMotionSpecResource(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.f5959c0 = w7.f.b(fVar.f5968l0, i10);
        }
    }

    public void setIconEndPadding(float f10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.O(f10);
        }
    }

    public void setIconEndPaddingResource(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.O(fVar.f5968l0.getResources().getDimension(i10));
        }
    }

    public void setIconStartPadding(float f10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.P(f10);
        }
    }

    public void setIconStartPaddingResource(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.P(fVar.f5968l0.getResources().getDimension(i10));
        }
    }

    public void setInternalOnCheckedChangeListener(h hVar) {
    }

    public void setLayoutDirection(int i10) {
        if (this.f3719l != null) {
            super.setLayoutDirection(i10);
        }
    }

    public void setLines(int i10) {
        if (i10 <= 1) {
            super.setLines(i10);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxLines(int i10) {
        if (i10 <= 1) {
            super.setMaxLines(i10);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxWidth(int i10) {
        super.setMaxWidth(i10);
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.L0 = i10;
        }
    }

    public void setMinLines(int i10) {
        if (i10 <= 1) {
            super.setMinLines(i10);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f3723p = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f3722o = onClickListener;
        d();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.Q(colorStateList);
        }
        if (!this.f3719l.G0) {
            e();
        }
    }

    public void setRippleColorResource(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.Q(c0.g.c(fVar.f5968l0, i10));
            if (!this.f3719l.G0) {
                e();
            }
        }
    }

    public void setShapeAppearanceModel(n nVar) {
        this.f3719l.setShapeAppearanceModel(nVar);
    }

    public void setShowMotionSpec(w7.f fVar) {
        f fVar2 = this.f3719l;
        if (fVar2 != null) {
            fVar2.f5958b0 = fVar;
        }
    }

    public void setShowMotionSpecResource(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.f5958b0 = w7.f.b(fVar.f5968l0, i10);
        }
    }

    public void setSingleLine(boolean z10) {
        if (z10) {
            super.setSingleLine(z10);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        CharSequence charSequence2;
        f fVar = this.f3719l;
        if (fVar != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            if (fVar.K0) {
                charSequence2 = null;
            } else {
                charSequence2 = charSequence;
            }
            super.setText(charSequence2, bufferType);
            f fVar2 = this.f3719l;
            if (fVar2 != null && !TextUtils.equals(fVar2.L, charSequence)) {
                fVar2.L = charSequence;
                fVar2.f5974r0.f10790d = true;
                fVar2.invalidateSelf();
                fVar2.v();
            }
        }
    }

    public void setTextAppearance(int i10) {
        super.setTextAppearance(i10);
        f fVar = this.f3719l;
        if (fVar != null) {
            Context context = fVar.f5968l0;
            fVar.f5974r0.b(new g(context, i10), context);
        }
        g();
    }

    public void setTextAppearanceResource(int i10) {
        setTextAppearance(getContext(), i10);
    }

    public void setTextEndPadding(float f10) {
        f fVar = this.f3719l;
        if (fVar != null && fVar.f5964h0 != f10) {
            fVar.f5964h0 = f10;
            fVar.invalidateSelf();
            fVar.v();
        }
    }

    public void setTextEndPaddingResource(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            float dimension = fVar.f5968l0.getResources().getDimension(i10);
            if (fVar.f5964h0 != dimension) {
                fVar.f5964h0 = dimension;
                fVar.invalidateSelf();
                fVar.v();
            }
        }
    }

    public final void setTextSize(int i10, float f10) {
        super.setTextSize(i10, f10);
        f fVar = this.f3719l;
        if (fVar != null) {
            float applyDimension = TypedValue.applyDimension(i10, f10, getResources().getDisplayMetrics());
            o oVar = fVar.f5974r0;
            g gVar = oVar.f10792f;
            if (gVar != null) {
                gVar.f13427k = applyDimension;
                oVar.f10787a.setTextSize(applyDimension);
                fVar.a();
            }
        }
        g();
    }

    public void setTextStartPadding(float f10) {
        f fVar = this.f3719l;
        if (fVar != null && fVar.f5963g0 != f10) {
            fVar.f5963g0 = f10;
            fVar.invalidateSelf();
            fVar.v();
        }
    }

    public void setTextStartPaddingResource(int i10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            float dimension = fVar.f5968l0.getResources().getDimension(i10);
            if (fVar.f5963g0 != dimension) {
                fVar.f5963g0 = dimension;
                fVar.invalidateSelf();
                fVar.v();
            }
        }
    }

    public void setCloseIconVisible(boolean z10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.N(z10);
        }
        d();
    }

    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
    }

    public void setCheckedIconVisible(boolean z10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.A(z10);
        }
    }

    public void setChipIconVisible(boolean z10) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.F(z10);
        }
    }

    public final void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        f fVar = this.f3719l;
        if (fVar != null) {
            Context context2 = fVar.f5968l0;
            fVar.f5974r0.b(new g(context2, i10), context2);
        }
        g();
    }

    public void setTextAppearance(g gVar) {
        f fVar = this.f3719l;
        if (fVar != null) {
            fVar.f5974r0.b(gVar, fVar.f5968l0);
        }
        g();
    }
}
