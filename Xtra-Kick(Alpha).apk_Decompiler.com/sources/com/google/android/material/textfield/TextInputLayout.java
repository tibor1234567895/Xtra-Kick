package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.h0;
import androidx.appcompat.widget.i2;
import androidx.appcompat.widget.t1;
import androidx.appcompat.widget.u3;
import b4.h;
import c0.g;
import com.google.android.material.internal.CheckableImageButton;
import com.woxthebox.draglistview.R;
import g8.a;
import h3.j3;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;
import m0.l0;
import m0.p;
import m8.d;
import m8.w;
import q0.a0;
import q8.c;
import t8.i;
import t8.j;
import t8.n;
import y8.m;
import y8.r;
import y8.t;
import y8.v;
import y8.x;
import y8.y;

public class TextInputLayout extends LinearLayout {
    public static final int[][] F0 = {new int[]{16842919}, new int[0]};
    public t1 A;
    public boolean A0;
    public ColorStateList B;
    public boolean B0;
    public int C;
    public ValueAnimator C0;
    public h D;
    public boolean D0;
    public h E;
    public boolean E0;
    public ColorStateList F;
    public ColorStateList G;
    public boolean H;
    public CharSequence I;
    public boolean J;
    public i K;
    public i L;
    public StateListDrawable M;
    public boolean N;
    public i O;
    public i P;
    public n Q;
    public boolean R;
    public final int S;
    public int T;
    public int U;
    public int V;
    public int W;

    /* renamed from: a0  reason: collision with root package name */
    public int f3883a0;

    /* renamed from: b0  reason: collision with root package name */
    public int f3884b0;

    /* renamed from: c0  reason: collision with root package name */
    public int f3885c0;

    /* renamed from: d0  reason: collision with root package name */
    public final Rect f3886d0 = new Rect();

    /* renamed from: e0  reason: collision with root package name */
    public final Rect f3887e0 = new Rect();

    /* renamed from: f0  reason: collision with root package name */
    public final RectF f3888f0 = new RectF();

    /* renamed from: g0  reason: collision with root package name */
    public Typeface f3889g0;

    /* renamed from: h  reason: collision with root package name */
    public final FrameLayout f3890h;

    /* renamed from: h0  reason: collision with root package name */
    public ColorDrawable f3891h0;

    /* renamed from: i  reason: collision with root package name */
    public final v f3892i;

    /* renamed from: i0  reason: collision with root package name */
    public int f3893i0;

    /* renamed from: j  reason: collision with root package name */
    public final y8.n f3894j;

    /* renamed from: j0  reason: collision with root package name */
    public final LinkedHashSet f3895j0 = new LinkedHashSet();

    /* renamed from: k  reason: collision with root package name */
    public EditText f3896k;

    /* renamed from: k0  reason: collision with root package name */
    public ColorDrawable f3897k0;

    /* renamed from: l  reason: collision with root package name */
    public CharSequence f3898l;

    /* renamed from: l0  reason: collision with root package name */
    public int f3899l0;

    /* renamed from: m  reason: collision with root package name */
    public int f3900m = -1;

    /* renamed from: m0  reason: collision with root package name */
    public Drawable f3901m0;

    /* renamed from: n  reason: collision with root package name */
    public int f3902n = -1;

    /* renamed from: n0  reason: collision with root package name */
    public ColorStateList f3903n0;

    /* renamed from: o  reason: collision with root package name */
    public int f3904o = -1;

    /* renamed from: o0  reason: collision with root package name */
    public ColorStateList f3905o0;

    /* renamed from: p  reason: collision with root package name */
    public int f3906p = -1;

    /* renamed from: p0  reason: collision with root package name */
    public int f3907p0;

    /* renamed from: q  reason: collision with root package name */
    public final r f3908q = new r(this);

    /* renamed from: q0  reason: collision with root package name */
    public int f3909q0;

    /* renamed from: r  reason: collision with root package name */
    public boolean f3910r;

    /* renamed from: r0  reason: collision with root package name */
    public int f3911r0;

    /* renamed from: s  reason: collision with root package name */
    public int f3912s;

    /* renamed from: s0  reason: collision with root package name */
    public ColorStateList f3913s0;

    /* renamed from: t  reason: collision with root package name */
    public boolean f3914t;

    /* renamed from: t0  reason: collision with root package name */
    public int f3915t0;

    /* renamed from: u  reason: collision with root package name */
    public y f3916u = new j3(20);

    /* renamed from: u0  reason: collision with root package name */
    public int f3917u0;

    /* renamed from: v  reason: collision with root package name */
    public t1 f3918v;

    /* renamed from: v0  reason: collision with root package name */
    public int f3919v0;

    /* renamed from: w  reason: collision with root package name */
    public int f3920w;

    /* renamed from: w0  reason: collision with root package name */
    public int f3921w0;

    /* renamed from: x  reason: collision with root package name */
    public int f3922x;

    /* renamed from: x0  reason: collision with root package name */
    public int f3923x0;

    /* renamed from: y  reason: collision with root package name */
    public CharSequence f3924y;

    /* renamed from: y0  reason: collision with root package name */
    public boolean f3925y0;

    /* renamed from: z  reason: collision with root package name */
    public boolean f3926z;

    /* renamed from: z0  reason: collision with root package name */
    public final d f3927z0;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextInputLayout(android.content.Context r19, android.util.AttributeSet r20) {
        /*
            r18 = this;
            r0 = r18
            r7 = r20
            r8 = 2130969836(0x7f0404ec, float:1.7548365E38)
            r9 = 2132018105(0x7f1403b9, float:1.9674507E38)
            r1 = r19
            android.content.Context r1 = a9.a.a(r1, r7, r8, r9)
            r0.<init>(r1, r7, r8)
            r10 = -1
            r0.f3900m = r10
            r0.f3902n = r10
            r0.f3904o = r10
            r0.f3906p = r10
            y8.r r1 = new y8.r
            r1.<init>(r0)
            r0.f3908q = r1
            h3.j3 r1 = new h3.j3
            r11 = 20
            r1.<init>(r11)
            r0.f3916u = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.f3886d0 = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.f3887e0 = r1
            android.graphics.RectF r1 = new android.graphics.RectF
            r1.<init>()
            r0.f3888f0 = r1
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
            r0.f3895j0 = r1
            m8.d r1 = new m8.d
            r1.<init>(r0)
            r0.f3927z0 = r1
            android.content.Context r12 = r18.getContext()
            r13 = 1
            r0.setOrientation(r13)
            r14 = 0
            r0.setWillNotDraw(r14)
            r0.setAddStatesFromChildren(r13)
            android.widget.FrameLayout r15 = new android.widget.FrameLayout
            r15.<init>(r12)
            r0.f3890h = r15
            r15.setAddStatesFromChildren(r13)
            android.view.animation.LinearInterpolator r2 = w7.a.f16153a
            r1.W = r2
            r1.i(r14)
            r1.V = r2
            r1.i(r14)
            r2 = 8388659(0x800033, float:1.1755015E-38)
            r1.l(r2)
            int[] r3 = v7.a.J
            r5 = 2132018105(0x7f1403b9, float:1.9674507E38)
            r6 = 5
            int[] r4 = new int[r6]
            r4 = {22, 20, 38, 43, 47} // fill-array
            r16 = 2130969836(0x7f0404ec, float:1.7548365E38)
            r1 = r12
            r2 = r20
            r17 = r4
            r4 = r16
            r11 = 5
            r6 = r17
            androidx.appcompat.widget.u4 r1 = m8.r.e(r1, r2, r3, r4, r5, r6)
            y8.v r2 = new y8.v
            r2.<init>(r0, r1)
            r0.f3892i = r2
            r3 = 46
            boolean r3 = r1.a(r3, r13)
            r0.H = r3
            r3 = 4
            java.lang.CharSequence r3 = r1.k(r3)
            r0.setHint((java.lang.CharSequence) r3)
            r3 = 45
            boolean r3 = r1.a(r3, r13)
            r0.B0 = r3
            r3 = 40
            boolean r3 = r1.a(r3, r13)
            r0.A0 = r3
            r3 = 6
            boolean r4 = r1.l(r3)
            if (r4 == 0) goto L_0x00cc
            int r3 = r1.h(r3, r10)
            r0.setMinEms(r3)
            goto L_0x00da
        L_0x00cc:
            r3 = 3
            boolean r4 = r1.l(r3)
            if (r4 == 0) goto L_0x00da
            int r3 = r1.d(r3, r10)
            r0.setMinWidth(r3)
        L_0x00da:
            boolean r3 = r1.l(r11)
            r4 = 2
            if (r3 == 0) goto L_0x00e9
            int r3 = r1.h(r11, r10)
            r0.setMaxEms(r3)
            goto L_0x00f6
        L_0x00e9:
            boolean r3 = r1.l(r4)
            if (r3 == 0) goto L_0x00f6
            int r3 = r1.d(r4, r10)
            r0.setMaxWidth(r3)
        L_0x00f6:
            t8.m r3 = t8.n.b(r12, r7, r8, r9)
            t8.n r5 = new t8.n
            r5.<init>(r3)
            r0.Q = r5
            android.content.res.Resources r3 = r12.getResources()
            r5 = 2131165958(0x7f070306, float:1.7946148E38)
            int r3 = r3.getDimensionPixelOffset(r5)
            r0.S = r3
            r3 = 9
            int r3 = r1.c(r3, r14)
            r0.U = r3
            android.content.res.Resources r3 = r12.getResources()
            r5 = 2131165959(0x7f070307, float:1.794615E38)
            int r3 = r3.getDimensionPixelSize(r5)
            r5 = 16
            int r3 = r1.d(r5, r3)
            r0.W = r3
            android.content.res.Resources r3 = r12.getResources()
            r5 = 2131165960(0x7f070308, float:1.7946152E38)
            int r3 = r3.getDimensionPixelSize(r5)
            r5 = 17
            int r3 = r1.d(r5, r3)
            r0.f3883a0 = r3
            int r3 = r0.W
            r0.V = r3
            android.content.res.TypedArray r3 = r1.f1100b
            r5 = 13
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r5 = r3.getDimension(r5, r6)
            r7 = 12
            float r7 = r3.getDimension(r7, r6)
            r8 = 10
            float r8 = r3.getDimension(r8, r6)
            r9 = 11
            float r6 = r3.getDimension(r9, r6)
            t8.n r9 = r0.Q
            r9.getClass()
            t8.m r11 = new t8.m
            r11.<init>(r9)
            r9 = 0
            int r16 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r16 < 0) goto L_0x0172
            t8.a r4 = new t8.a
            r4.<init>(r5)
            r11.f14769e = r4
        L_0x0172:
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 < 0) goto L_0x017d
            t8.a r4 = new t8.a
            r4.<init>(r7)
            r11.f14770f = r4
        L_0x017d:
            int r4 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r4 < 0) goto L_0x0188
            t8.a r4 = new t8.a
            r4.<init>(r8)
            r11.f14771g = r4
        L_0x0188:
            int r4 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r4 < 0) goto L_0x0193
            t8.a r4 = new t8.a
            r4.<init>(r6)
            r11.f14772h = r4
        L_0x0193:
            t8.n r4 = new t8.n
            r4.<init>(r11)
            r0.Q = r4
            r4 = 7
            android.content.res.ColorStateList r4 = q8.d.b(r12, r1, r4)
            if (r4 == 0) goto L_0x01f5
            int r5 = r4.getDefaultColor()
            r0.f3915t0 = r5
            r0.f3885c0 = r5
            boolean r5 = r4.isStateful()
            r6 = -16842910(0xfffffffffefeff62, float:-1.6947497E38)
            if (r5 == 0) goto L_0x01d2
            int[] r5 = new int[r13]
            r5[r14] = r6
            int r5 = r4.getColorForState(r5, r10)
            r0.f3917u0 = r5
            r5 = 2
            int[] r6 = new int[r5]
            r6 = {16842908, 16842910} // fill-array
            int r6 = r4.getColorForState(r6, r10)
            r0.f3919v0 = r6
            int[] r6 = new int[r5]
            r6 = {16843623, 16842910} // fill-array
            int r4 = r4.getColorForState(r6, r10)
            goto L_0x01f2
        L_0x01d2:
            int r4 = r0.f3915t0
            r0.f3919v0 = r4
            r4 = 2131100350(0x7f0602be, float:1.7813079E38)
            android.content.res.ColorStateList r4 = c0.g.c(r12, r4)
            int[] r5 = new int[r13]
            r5[r14] = r6
            int r5 = r4.getColorForState(r5, r10)
            r0.f3917u0 = r5
            int[] r5 = new int[r13]
            r6 = 16843623(0x1010367, float:2.3696E-38)
            r5[r14] = r6
            int r4 = r4.getColorForState(r5, r10)
        L_0x01f2:
            r0.f3921w0 = r4
            goto L_0x01ff
        L_0x01f5:
            r0.f3885c0 = r14
            r0.f3915t0 = r14
            r0.f3917u0 = r14
            r0.f3919v0 = r14
            r0.f3921w0 = r14
        L_0x01ff:
            boolean r4 = r1.l(r13)
            if (r4 == 0) goto L_0x020d
            android.content.res.ColorStateList r4 = r1.b(r13)
            r0.f3905o0 = r4
            r0.f3903n0 = r4
        L_0x020d:
            r4 = 14
            android.content.res.ColorStateList r5 = q8.d.b(r12, r1, r4)
            int r3 = r3.getColor(r4, r14)
            r0.f3911r0 = r3
            r3 = 2131100377(0x7f0602d9, float:1.7813134E38)
            int r3 = c0.g.b(r12, r3)
            r0.f3907p0 = r3
            r3 = 2131100378(0x7f0602da, float:1.7813136E38)
            int r3 = c0.g.b(r12, r3)
            r0.f3923x0 = r3
            r3 = 2131100381(0x7f0602dd, float:1.7813142E38)
            int r3 = c0.g.b(r12, r3)
            r0.f3909q0 = r3
            if (r5 == 0) goto L_0x0239
            r0.setBoxStrokeColorStateList(r5)
        L_0x0239:
            r3 = 15
            boolean r4 = r1.l(r3)
            if (r4 == 0) goto L_0x0248
            android.content.res.ColorStateList r3 = q8.d.b(r12, r1, r3)
            r0.setBoxStrokeErrorColor(r3)
        L_0x0248:
            r3 = 47
            int r4 = r1.i(r3, r10)
            if (r4 == r10) goto L_0x0257
            int r3 = r1.i(r3, r14)
            r0.setHintTextAppearance(r3)
        L_0x0257:
            r3 = 38
            int r3 = r1.i(r3, r14)
            r4 = 33
            java.lang.CharSequence r4 = r1.k(r4)
            r5 = 32
            int r5 = r1.h(r5, r13)
            r6 = 34
            boolean r6 = r1.a(r6, r14)
            r7 = 43
            int r7 = r1.i(r7, r14)
            r8 = 42
            boolean r8 = r1.a(r8, r14)
            r9 = 41
            java.lang.CharSequence r9 = r1.k(r9)
            r11 = 55
            int r11 = r1.i(r11, r14)
            r12 = 54
            java.lang.CharSequence r12 = r1.k(r12)
            r13 = 18
            boolean r13 = r1.a(r13, r14)
            r14 = 19
            int r10 = r1.h(r14, r10)
            r0.setCounterMaxLength(r10)
            r10 = 22
            r14 = 0
            int r10 = r1.i(r10, r14)
            r0.f3922x = r10
            r10 = 20
            int r10 = r1.i(r10, r14)
            r0.f3920w = r10
            r10 = 8
            int r10 = r1.h(r10, r14)
            r0.setBoxBackgroundMode(r10)
            r0.setErrorContentDescription(r4)
            r0.setErrorAccessibilityLiveRegion(r5)
            int r4 = r0.f3920w
            r0.setCounterOverflowTextAppearance(r4)
            r0.setHelperTextTextAppearance(r7)
            r0.setErrorTextAppearance(r3)
            int r3 = r0.f3922x
            r0.setCounterTextAppearance(r3)
            r0.setPlaceholderText(r12)
            r0.setPlaceholderTextAppearance(r11)
            r3 = 39
            boolean r4 = r1.l(r3)
            if (r4 == 0) goto L_0x02e1
            android.content.res.ColorStateList r3 = r1.b(r3)
            r0.setErrorTextColor(r3)
        L_0x02e1:
            r3 = 44
            boolean r4 = r1.l(r3)
            if (r4 == 0) goto L_0x02f0
            android.content.res.ColorStateList r3 = r1.b(r3)
            r0.setHelperTextColor(r3)
        L_0x02f0:
            r3 = 48
            boolean r4 = r1.l(r3)
            if (r4 == 0) goto L_0x02ff
            android.content.res.ColorStateList r3 = r1.b(r3)
            r0.setHintTextColor(r3)
        L_0x02ff:
            r3 = 23
            boolean r4 = r1.l(r3)
            if (r4 == 0) goto L_0x030e
            android.content.res.ColorStateList r3 = r1.b(r3)
            r0.setCounterTextColor(r3)
        L_0x030e:
            r3 = 21
            boolean r4 = r1.l(r3)
            if (r4 == 0) goto L_0x031d
            android.content.res.ColorStateList r3 = r1.b(r3)
            r0.setCounterOverflowTextColor(r3)
        L_0x031d:
            r3 = 56
            boolean r4 = r1.l(r3)
            if (r4 == 0) goto L_0x032c
            android.content.res.ColorStateList r3 = r1.b(r3)
            r0.setPlaceholderTextColor(r3)
        L_0x032c:
            y8.n r3 = new y8.n
            r3.<init>(r0, r1)
            r0.f3894j = r3
            r4 = 1
            r5 = 0
            boolean r5 = r1.a(r5, r4)
            r1.n()
            r1 = 2
            m0.i0.s(r0, r1)
            int r1 = android.os.Build.VERSION.SDK_INT
            r7 = 26
            if (r1 < r7) goto L_0x034b
            if (r1 < r7) goto L_0x034b
            m0.s0.l(r0, r4)
        L_0x034b:
            r15.addView(r2)
            r15.addView(r3)
            r0.addView(r15)
            r0.setEnabled(r5)
            r0.setHelperTextEnabled(r8)
            r0.setErrorEnabled(r6)
            r0.setCounterEnabled(r13)
            r0.setHelperText(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private Drawable getEditTextBoxBackground() {
        boolean z10;
        int i10;
        EditText editText = this.f3896k;
        if (editText instanceof AutoCompleteTextView) {
            if (editText.getInputType() != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                int b10 = a.b(this.f3896k, R.attr.colorControlHighlight);
                int i11 = this.T;
                int[][] iArr = F0;
                if (i11 == 2) {
                    Context context = getContext();
                    i iVar = this.K;
                    TypedValue c10 = c.c(R.attr.colorSurface, context, "TextInputLayout");
                    int i12 = c10.resourceId;
                    if (i12 != 0) {
                        i10 = g.b(context, i12);
                    } else {
                        i10 = c10.data;
                    }
                    i iVar2 = new i(iVar.f14744h.f14723a);
                    int d10 = a.d(b10, 0.1f, i10);
                    iVar2.k(new ColorStateList(iArr, new int[]{d10, 0}));
                    iVar2.setTint(i10);
                    ColorStateList colorStateList = new ColorStateList(iArr, new int[]{d10, i10});
                    i iVar3 = new i(iVar.f14744h.f14723a);
                    iVar3.setTint(-1);
                    return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, iVar2, iVar3), iVar});
                } else if (i11 != 1) {
                    return null;
                } else {
                    i iVar4 = this.K;
                    int i13 = this.f3885c0;
                    return new RippleDrawable(new ColorStateList(iArr, new int[]{a.d(b10, 0.1f, i13), i13}), iVar4, iVar4);
                }
            }
        }
        return this.K;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.M == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.M = stateListDrawable;
            stateListDrawable.addState(new int[]{16842922}, getOrCreateOutlinedDropDownMenuBackground());
            this.M.addState(new int[0], f(false));
        }
        return this.M;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.L == null) {
            this.L = f(true);
        }
        return this.L;
    }

    public static void j(ViewGroup viewGroup, boolean z10) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            childAt.setEnabled(z10);
            if (childAt instanceof ViewGroup) {
                j((ViewGroup) childAt, z10);
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.f3896k == null) {
            if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.f3896k = editText;
            int i10 = this.f3900m;
            if (i10 != -1) {
                setMinEms(i10);
            } else {
                setMinWidth(this.f3904o);
            }
            int i11 = this.f3902n;
            if (i11 != -1) {
                setMaxEms(i11);
            } else {
                setMaxWidth(this.f3906p);
            }
            this.N = false;
            h();
            setTextInputAccessibilityDelegate(new x(this));
            Typeface typeface = this.f3896k.getTypeface();
            d dVar = this.f3927z0;
            boolean m10 = dVar.m(typeface);
            boolean o10 = dVar.o(typeface);
            if (m10 || o10) {
                dVar.i(false);
            }
            float textSize = this.f3896k.getTextSize();
            if (dVar.f10741l != textSize) {
                dVar.f10741l = textSize;
                dVar.i(false);
            }
            float letterSpacing = this.f3896k.getLetterSpacing();
            if (dVar.f10732g0 != letterSpacing) {
                dVar.f10732g0 = letterSpacing;
                dVar.i(false);
            }
            int gravity = this.f3896k.getGravity();
            dVar.l((gravity & -113) | 48);
            if (dVar.f10737j != gravity) {
                dVar.f10737j = gravity;
                dVar.i(false);
            }
            this.f3896k.addTextChangedListener(new u3(3, this));
            if (this.f3903n0 == null) {
                this.f3903n0 = this.f3896k.getHintTextColors();
            }
            if (this.H) {
                if (TextUtils.isEmpty(this.I)) {
                    CharSequence hint = this.f3896k.getHint();
                    this.f3898l = hint;
                    setHint(hint);
                    this.f3896k.setHint((CharSequence) null);
                }
                this.J = true;
            }
            if (this.f3918v != null) {
                m(this.f3896k.getText());
            }
            p();
            this.f3908q.b();
            this.f3892i.bringToFront();
            y8.n nVar = this.f3894j;
            nVar.bringToFront();
            Iterator it = this.f3895j0.iterator();
            while (it.hasNext()) {
                ((m) it.next()).a(this);
            }
            nVar.l();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            s(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.I)) {
            this.I = charSequence;
            d dVar = this.f3927z0;
            if (charSequence == null || !TextUtils.equals(dVar.G, charSequence)) {
                dVar.G = charSequence;
                dVar.H = null;
                Bitmap bitmap = dVar.K;
                if (bitmap != null) {
                    bitmap.recycle();
                    dVar.K = null;
                }
                dVar.i(false);
            }
            if (!this.f3925y0) {
                i();
            }
        }
    }

    private void setPlaceholderTextEnabled(boolean z10) {
        if (this.f3926z != z10) {
            if (z10) {
                t1 t1Var = this.A;
                if (t1Var != null) {
                    this.f3890h.addView(t1Var);
                    this.A.setVisibility(0);
                }
            } else {
                t1 t1Var2 = this.A;
                if (t1Var2 != null) {
                    t1Var2.setVisibility(8);
                }
                this.A = null;
            }
            this.f3926z = z10;
        }
    }

    public final void a(float f10) {
        d dVar = this.f3927z0;
        if (dVar.f10721b != f10) {
            if (this.C0 == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.C0 = valueAnimator;
                valueAnimator.setInterpolator(n8.a.d(getContext(), R.attr.motionEasingEmphasizedInterpolator, w7.a.f16154b));
                this.C0.setDuration((long) n8.a.c(getContext(), R.attr.motionDurationMedium4, 167));
                this.C0.addUpdateListener(new x7.h(3, this));
            }
            this.C0.setFloatValues(new float[]{dVar.f10721b, f10});
            this.C0.start();
        }
    }

    public final void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            FrameLayout frameLayout = this.f3890h;
            frameLayout.addView(view, layoutParams2);
            frameLayout.setLayoutParams(layoutParams);
            r();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i10, layoutParams);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r7 = this;
            t8.i r0 = r7.K
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            t8.h r1 = r0.f14744h
            t8.n r1 = r1.f14723a
            t8.n r2 = r7.Q
            if (r1 == r2) goto L_0x0010
            r0.setShapeAppearanceModel(r2)
        L_0x0010:
            int r0 = r7.T
            r1 = 2
            r2 = -1
            r3 = 0
            r4 = 1
            if (r0 != r1) goto L_0x0027
            int r0 = r7.V
            if (r0 <= r2) goto L_0x0022
            int r0 = r7.f3884b0
            if (r0 == 0) goto L_0x0022
            r0 = 1
            goto L_0x0023
        L_0x0022:
            r0 = 0
        L_0x0023:
            if (r0 == 0) goto L_0x0027
            r0 = 1
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            if (r0 == 0) goto L_0x004b
            t8.i r0 = r7.K
            int r1 = r7.V
            float r1 = (float) r1
            int r5 = r7.f3884b0
            t8.h r6 = r0.f14744h
            r6.f14733k = r1
            r0.invalidateSelf()
            android.content.res.ColorStateList r1 = android.content.res.ColorStateList.valueOf(r5)
            t8.h r5 = r0.f14744h
            android.content.res.ColorStateList r6 = r5.f14726d
            if (r6 == r1) goto L_0x004b
            r5.f14726d = r1
            int[] r1 = r0.getState()
            r0.onStateChange(r1)
        L_0x004b:
            int r0 = r7.f3885c0
            int r1 = r7.T
            if (r1 != r4) goto L_0x0062
            android.content.Context r0 = r7.getContext()
            r1 = 2130968880(0x7f040130, float:1.7546426E38)
            int r0 = g8.a.a(r0, r1, r3)
            int r1 = r7.f3885c0
            int r0 = e0.a.b(r1, r0)
        L_0x0062:
            r7.f3885c0 = r0
            t8.i r1 = r7.K
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
            r1.k(r0)
            t8.i r0 = r7.O
            if (r0 == 0) goto L_0x00a3
            t8.i r1 = r7.P
            if (r1 != 0) goto L_0x0076
            goto L_0x00a3
        L_0x0076:
            int r1 = r7.V
            if (r1 <= r2) goto L_0x007f
            int r1 = r7.f3884b0
            if (r1 == 0) goto L_0x007f
            r3 = 1
        L_0x007f:
            if (r3 == 0) goto L_0x00a0
            android.widget.EditText r1 = r7.f3896k
            boolean r1 = r1.isFocused()
            if (r1 == 0) goto L_0x008c
            int r1 = r7.f3907p0
            goto L_0x008e
        L_0x008c:
            int r1 = r7.f3884b0
        L_0x008e:
            android.content.res.ColorStateList r1 = android.content.res.ColorStateList.valueOf(r1)
            r0.k(r1)
            t8.i r0 = r7.P
            int r1 = r7.f3884b0
            android.content.res.ColorStateList r1 = android.content.res.ColorStateList.valueOf(r1)
            r0.k(r1)
        L_0x00a0:
            r7.invalidate()
        L_0x00a3:
            r7.q()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.b():void");
    }

    public final int c() {
        float e10;
        if (!this.H) {
            return 0;
        }
        int i10 = this.T;
        d dVar = this.f3927z0;
        if (i10 == 0) {
            e10 = dVar.e();
        } else if (i10 != 2) {
            return 0;
        } else {
            e10 = dVar.e() / 2.0f;
        }
        return (int) e10;
    }

    public final h d() {
        h hVar = new h();
        hVar.f2590j = (long) n8.a.c(getContext(), R.attr.motionDurationShort2, 87);
        hVar.f2591k = n8.a.d(getContext(), R.attr.motionEasingLinearInterpolator, w7.a.f16153a);
        return hVar;
    }

    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i10) {
        EditText editText = this.f3896k;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i10);
            return;
        }
        if (this.f3898l != null) {
            boolean z10 = this.J;
            this.J = false;
            CharSequence hint = editText.getHint();
            this.f3896k.setHint(this.f3898l);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i10);
            } finally {
                this.f3896k.setHint(hint);
                this.J = z10;
            }
        } else {
            viewStructure.setAutofillId(getAutofillId());
            onProvideAutofillStructure(viewStructure, i10);
            onProvideAutofillVirtualStructure(viewStructure, i10);
            FrameLayout frameLayout = this.f3890h;
            viewStructure.setChildCount(frameLayout.getChildCount());
            for (int i11 = 0; i11 < frameLayout.getChildCount(); i11++) {
                View childAt = frameLayout.getChildAt(i11);
                ViewStructure newChild = viewStructure.newChild(i11);
                childAt.dispatchProvideAutofillStructure(newChild, i10);
                if (childAt == this.f3896k) {
                    newChild.setHint(getHint());
                }
            }
        }
    }

    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.E0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.E0 = false;
    }

    public final void draw(Canvas canvas) {
        i iVar;
        super.draw(canvas);
        boolean z10 = this.H;
        d dVar = this.f3927z0;
        if (z10) {
            dVar.d(canvas);
        }
        if (this.P != null && (iVar = this.O) != null) {
            iVar.draw(canvas);
            if (this.f3896k.isFocused()) {
                Rect bounds = this.P.getBounds();
                Rect bounds2 = this.O.getBounds();
                float f10 = dVar.f10721b;
                int centerX = bounds2.centerX();
                bounds.left = w7.a.b(centerX, f10, bounds2.left);
                bounds.right = w7.a.b(centerX, f10, bounds2.right);
                this.P.draw(canvas);
            }
        }
    }

    public final void drawableStateChanged() {
        boolean z10;
        if (!this.D0) {
            boolean z11 = true;
            this.D0 = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            d dVar = this.f3927z0;
            if (dVar != null) {
                z10 = dVar.r(drawableState) | false;
            } else {
                z10 = false;
            }
            if (this.f3896k != null) {
                WeakHashMap weakHashMap = c1.f10054a;
                if (!l0.c(this) || !isEnabled()) {
                    z11 = false;
                }
                s(z11, false);
            }
            p();
            v();
            if (z10) {
                invalidate();
            }
            this.D0 = false;
        }
    }

    public final boolean e() {
        return this.H && !TextUtils.isEmpty(this.I) && (this.K instanceof y8.h);
    }

    public final i f(boolean z10) {
        float f10;
        float f11;
        int i10;
        float dimensionPixelOffset = (float) getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        if (z10) {
            f10 = dimensionPixelOffset;
        } else {
            f10 = 0.0f;
        }
        EditText editText = this.f3896k;
        if (editText instanceof t) {
            f11 = ((t) editText).getPopupElevation();
        } else {
            f11 = (float) getResources().getDimensionPixelOffset(R.dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        }
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        t8.m mVar = new t8.m();
        mVar.f14769e = new t8.a(f10);
        mVar.f14770f = new t8.a(f10);
        mVar.f14772h = new t8.a(dimensionPixelOffset);
        mVar.f14771g = new t8.a(dimensionPixelOffset);
        n nVar = new n(mVar);
        Context context = getContext();
        Paint paint = i.D;
        TypedValue c10 = c.c(R.attr.colorSurface, context, i.class.getSimpleName());
        int i11 = c10.resourceId;
        if (i11 != 0) {
            i10 = g.b(context, i11);
        } else {
            i10 = c10.data;
        }
        i iVar = new i();
        iVar.i(context);
        iVar.k(ColorStateList.valueOf(i10));
        iVar.j(f11);
        iVar.setShapeAppearanceModel(nVar);
        t8.h hVar = iVar.f14744h;
        if (hVar.f14730h == null) {
            hVar.f14730h = new Rect();
        }
        iVar.f14744h.f14730h.set(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        iVar.invalidateSelf();
        return iVar;
    }

    public final int g(int i10, boolean z10) {
        int compoundPaddingLeft = this.f3896k.getCompoundPaddingLeft() + i10;
        return (getPrefixText() == null || z10) ? compoundPaddingLeft : (compoundPaddingLeft - getPrefixTextView().getMeasuredWidth()) + getPrefixTextView().getPaddingLeft();
    }

    public int getBaseline() {
        EditText editText = this.f3896k;
        if (editText == null) {
            return super.getBaseline();
        }
        return c() + getPaddingTop() + editText.getBaseline();
    }

    public i getBoxBackground() {
        int i10 = this.T;
        if (i10 == 1 || i10 == 2) {
            return this.K;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.f3885c0;
    }

    public int getBoxBackgroundMode() {
        return this.T;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.U;
    }

    public float getBoxCornerRadiusBottomEnd() {
        t8.c cVar;
        boolean c10 = w.c(this);
        RectF rectF = this.f3888f0;
        if (c10) {
            cVar = this.Q.f14785h;
        } else {
            cVar = this.Q.f14784g;
        }
        return cVar.a(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        t8.c cVar;
        boolean c10 = w.c(this);
        RectF rectF = this.f3888f0;
        if (c10) {
            cVar = this.Q.f14784g;
        } else {
            cVar = this.Q.f14785h;
        }
        return cVar.a(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        t8.c cVar;
        boolean c10 = w.c(this);
        RectF rectF = this.f3888f0;
        if (c10) {
            cVar = this.Q.f14782e;
        } else {
            cVar = this.Q.f14783f;
        }
        return cVar.a(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        t8.c cVar;
        boolean c10 = w.c(this);
        RectF rectF = this.f3888f0;
        if (c10) {
            cVar = this.Q.f14783f;
        } else {
            cVar = this.Q.f14782e;
        }
        return cVar.a(rectF);
    }

    public int getBoxStrokeColor() {
        return this.f3911r0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f3913s0;
    }

    public int getBoxStrokeWidth() {
        return this.W;
    }

    public int getBoxStrokeWidthFocused() {
        return this.f3883a0;
    }

    public int getCounterMaxLength() {
        return this.f3912s;
    }

    public CharSequence getCounterOverflowDescription() {
        t1 t1Var;
        if (!this.f3910r || !this.f3914t || (t1Var = this.f3918v) == null) {
            return null;
        }
        return t1Var.getContentDescription();
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.G;
    }

    public ColorStateList getCounterTextColor() {
        return this.F;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f3903n0;
    }

    public EditText getEditText() {
        return this.f3896k;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f3894j.f17161n.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f3894j.f17161n.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.f3894j.f17167t;
    }

    public int getEndIconMode() {
        return this.f3894j.f17163p;
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.f3894j.f17168u;
    }

    public CheckableImageButton getEndIconView() {
        return this.f3894j.f17161n;
    }

    public CharSequence getError() {
        r rVar = this.f3908q;
        if (rVar.f17199q) {
            return rVar.f17198p;
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f3908q.f17202t;
    }

    public CharSequence getErrorContentDescription() {
        return this.f3908q.f17201s;
    }

    public int getErrorCurrentTextColors() {
        t1 t1Var = this.f3908q.f17200r;
        if (t1Var != null) {
            return t1Var.getCurrentTextColor();
        }
        return -1;
    }

    public Drawable getErrorIconDrawable() {
        return this.f3894j.f17157j.getDrawable();
    }

    public CharSequence getHelperText() {
        r rVar = this.f3908q;
        if (rVar.f17206x) {
            return rVar.f17205w;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        t1 t1Var = this.f3908q.f17207y;
        if (t1Var != null) {
            return t1Var.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.H) {
            return this.I;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.f3927z0.e();
    }

    public final int getHintCurrentCollapsedTextColor() {
        d dVar = this.f3927z0;
        return dVar.f(dVar.f10747o);
    }

    public ColorStateList getHintTextColor() {
        return this.f3905o0;
    }

    public y getLengthCounter() {
        return this.f3916u;
    }

    public int getMaxEms() {
        return this.f3902n;
    }

    public int getMaxWidth() {
        return this.f3906p;
    }

    public int getMinEms() {
        return this.f3900m;
    }

    public int getMinWidth() {
        return this.f3904o;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f3894j.f17161n.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f3894j.f17161n.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.f3926z) {
            return this.f3924y;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.C;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.B;
    }

    public CharSequence getPrefixText() {
        return this.f3892i.f17224j;
    }

    public ColorStateList getPrefixTextColor() {
        return this.f3892i.f17223i.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.f3892i.f17223i;
    }

    public n getShapeAppearanceModel() {
        return this.Q;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f3892i.f17225k.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.f3892i.f17225k.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.f3892i.f17228n;
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.f3892i.f17229o;
    }

    public CharSequence getSuffixText() {
        return this.f3894j.f17170w;
    }

    public ColorStateList getSuffixTextColor() {
        return this.f3894j.f17171x.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.f3894j.f17171x;
    }

    public Typeface getTypeface() {
        return this.f3889g0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h() {
        /*
            r8 = this;
            int r0 = r8.T
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0066
            if (r0 == r2) goto L_0x004e
            if (r0 != r1) goto L_0x003b
            boolean r0 = r8.H
            if (r0 == 0) goto L_0x0031
            t8.i r0 = r8.K
            boolean r0 = r0 instanceof y8.h
            if (r0 != 0) goto L_0x0031
            t8.n r0 = r8.Q
            int r4 = y8.h.F
            y8.f r4 = new y8.f
            if (r0 == 0) goto L_0x001e
            goto L_0x0023
        L_0x001e:
            t8.n r0 = new t8.n
            r0.<init>()
        L_0x0023:
            android.graphics.RectF r5 = new android.graphics.RectF
            r5.<init>()
            r4.<init>(r0, r5)
            y8.g r0 = new y8.g
            r0.<init>(r4)
            goto L_0x0038
        L_0x0031:
            t8.i r0 = new t8.i
            t8.n r4 = r8.Q
            r0.<init>((t8.n) r4)
        L_0x0038:
            r8.K = r0
            goto L_0x0068
        L_0x003b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r2 = r8.T
            java.lang.String r3 = " is illegal; only @BoxBackgroundMode constants are supported."
            java.lang.String r1 = android.support.v4.media.h.o(r1, r2, r3)
            r0.<init>(r1)
            throw r0
        L_0x004e:
            t8.i r0 = new t8.i
            t8.n r3 = r8.Q
            r0.<init>((t8.n) r3)
            r8.K = r0
            t8.i r0 = new t8.i
            r0.<init>()
            r8.O = r0
            t8.i r0 = new t8.i
            r0.<init>()
            r8.P = r0
            goto L_0x006c
        L_0x0066:
            r8.K = r3
        L_0x0068:
            r8.O = r3
            r8.P = r3
        L_0x006c:
            r8.q()
            r8.v()
            int r0 = r8.T
            r3 = 0
            r4 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L_0x00af
            android.content.Context r0 = r8.getContext()
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            float r0 = r0.fontScale
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x008d
            r0 = 1
            goto L_0x008e
        L_0x008d:
            r0 = 0
        L_0x008e:
            if (r0 == 0) goto L_0x0098
            android.content.res.Resources r0 = r8.getResources()
            r5 = 2131165765(0x7f070245, float:1.7945756E38)
            goto L_0x00a9
        L_0x0098:
            android.content.Context r0 = r8.getContext()
            boolean r0 = q8.d.d(r0)
            if (r0 == 0) goto L_0x00af
            android.content.res.Resources r0 = r8.getResources()
            r5 = 2131165764(0x7f070244, float:1.7945754E38)
        L_0x00a9:
            int r0 = r0.getDimensionPixelSize(r5)
            r8.U = r0
        L_0x00af:
            android.widget.EditText r0 = r8.f3896k
            if (r0 == 0) goto L_0x011f
            int r0 = r8.T
            if (r0 == r2) goto L_0x00b8
            goto L_0x011f
        L_0x00b8:
            android.content.Context r0 = r8.getContext()
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            float r0 = r0.fontScale
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x00cb
            r3 = 1
        L_0x00cb:
            if (r3 == 0) goto L_0x00ee
            android.widget.EditText r0 = r8.f3896k
            java.util.WeakHashMap r3 = m0.c1.f10054a
            int r3 = m0.j0.f(r0)
            android.content.res.Resources r4 = r8.getResources()
            r5 = 2131165763(0x7f070243, float:1.7945752E38)
            int r4 = r4.getDimensionPixelSize(r5)
            android.widget.EditText r5 = r8.f3896k
            int r5 = m0.j0.e(r5)
            android.content.res.Resources r6 = r8.getResources()
            r7 = 2131165762(0x7f070242, float:1.794575E38)
            goto L_0x0118
        L_0x00ee:
            android.content.Context r0 = r8.getContext()
            boolean r0 = q8.d.d(r0)
            if (r0 == 0) goto L_0x011f
            android.widget.EditText r0 = r8.f3896k
            java.util.WeakHashMap r3 = m0.c1.f10054a
            int r3 = m0.j0.f(r0)
            android.content.res.Resources r4 = r8.getResources()
            r5 = 2131165761(0x7f070241, float:1.7945748E38)
            int r4 = r4.getDimensionPixelSize(r5)
            android.widget.EditText r5 = r8.f3896k
            int r5 = m0.j0.e(r5)
            android.content.res.Resources r6 = r8.getResources()
            r7 = 2131165760(0x7f070240, float:1.7945746E38)
        L_0x0118:
            int r6 = r6.getDimensionPixelSize(r7)
            m0.j0.k(r0, r3, r4, r5, r6)
        L_0x011f:
            int r0 = r8.T
            if (r0 == 0) goto L_0x0126
            r8.r()
        L_0x0126:
            android.widget.EditText r0 = r8.f3896k
            boolean r3 = r0 instanceof android.widget.AutoCompleteTextView
            if (r3 != 0) goto L_0x012d
            goto L_0x0147
        L_0x012d:
            android.widget.AutoCompleteTextView r0 = (android.widget.AutoCompleteTextView) r0
            android.graphics.drawable.Drawable r3 = r0.getDropDownBackground()
            if (r3 != 0) goto L_0x0147
            int r3 = r8.T
            if (r3 != r1) goto L_0x013e
            android.graphics.drawable.Drawable r1 = r8.getOrCreateOutlinedDropDownMenuBackground()
            goto L_0x0144
        L_0x013e:
            if (r3 != r2) goto L_0x0147
            android.graphics.drawable.Drawable r1 = r8.getOrCreateFilledDropDownMenuBackground()
        L_0x0144:
            r0.setDropDownBackgroundDrawable(r1)
        L_0x0147:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.h():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i() {
        /*
            r12 = this;
            boolean r0 = r12.e()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            android.widget.EditText r0 = r12.f3896k
            int r0 = r0.getWidth()
            android.widget.EditText r1 = r12.f3896k
            int r1 = r1.getGravity()
            m8.d r2 = r12.f3927z0
            java.lang.CharSequence r3 = r2.G
            boolean r3 = r2.b(r3)
            r2.I = r3
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 5
            r6 = 8388613(0x800005, float:1.175495E-38)
            r7 = 1
            r8 = 17
            android.graphics.Rect r9 = r2.f10733h
            if (r1 == r8) goto L_0x0047
            r10 = r1 & 7
            if (r10 != r7) goto L_0x002f
            goto L_0x0047
        L_0x002f:
            r10 = r1 & r6
            if (r10 == r6) goto L_0x003b
            r10 = r1 & 5
            if (r10 != r5) goto L_0x0038
            goto L_0x003b
        L_0x0038:
            if (r3 == 0) goto L_0x003d
            goto L_0x0041
        L_0x003b:
            if (r3 == 0) goto L_0x0041
        L_0x003d:
            int r3 = r9.left
            float r3 = (float) r3
            goto L_0x004d
        L_0x0041:
            int r3 = r9.right
            float r3 = (float) r3
            float r10 = r2.f10738j0
            goto L_0x004c
        L_0x0047:
            float r3 = (float) r0
            float r3 = r3 / r4
            float r10 = r2.f10738j0
            float r10 = r10 / r4
        L_0x004c:
            float r3 = r3 - r10
        L_0x004d:
            int r10 = r9.left
            float r10 = (float) r10
            float r3 = java.lang.Math.max(r3, r10)
            android.graphics.RectF r10 = r12.f3888f0
            r10.left = r3
            int r11 = r9.top
            float r11 = (float) r11
            r10.top = r11
            if (r1 == r8) goto L_0x0082
            r8 = r1 & 7
            if (r8 != r7) goto L_0x0064
            goto L_0x0082
        L_0x0064:
            r0 = r1 & r6
            if (r0 == r6) goto L_0x0076
            r0 = r1 & 5
            if (r0 != r5) goto L_0x006d
            goto L_0x0076
        L_0x006d:
            boolean r0 = r2.I
            if (r0 == 0) goto L_0x0072
            goto L_0x007e
        L_0x0072:
            float r0 = r2.f10738j0
            float r0 = r0 + r3
            goto L_0x0088
        L_0x0076:
            boolean r0 = r2.I
            if (r0 == 0) goto L_0x007e
            float r0 = r2.f10738j0
            float r0 = r0 + r3
            goto L_0x0088
        L_0x007e:
            int r0 = r9.right
            float r0 = (float) r0
            goto L_0x0088
        L_0x0082:
            float r0 = (float) r0
            float r0 = r0 / r4
            float r1 = r2.f10738j0
            float r1 = r1 / r4
            float r0 = r0 + r1
        L_0x0088:
            int r1 = r9.right
            float r1 = (float) r1
            float r0 = java.lang.Math.min(r0, r1)
            r10.right = r0
            int r0 = r9.top
            float r0 = (float) r0
            float r1 = r2.e()
            float r1 = r1 + r0
            r10.bottom = r1
            float r0 = r10.width()
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x00e5
            float r0 = r10.height()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x00ad
            goto L_0x00e5
        L_0x00ad:
            float r0 = r10.left
            int r1 = r12.S
            float r1 = (float) r1
            float r0 = r0 - r1
            r10.left = r0
            float r0 = r10.right
            float r0 = r0 + r1
            r10.right = r0
            int r0 = r12.getPaddingLeft()
            int r0 = -r0
            float r0 = (float) r0
            int r1 = r12.getPaddingTop()
            int r1 = -r1
            float r1 = (float) r1
            float r2 = r10.height()
            float r2 = r2 / r4
            float r1 = r1 - r2
            int r2 = r12.V
            float r2 = (float) r2
            float r1 = r1 + r2
            r10.offset(r0, r1)
            t8.i r0 = r12.K
            y8.h r0 = (y8.h) r0
            r0.getClass()
            float r1 = r10.left
            float r2 = r10.top
            float r3 = r10.right
            float r4 = r10.bottom
            r0.o(r1, r2, r3, r4)
        L_0x00e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.i():void");
    }

    public final void k(TextView textView, int i10) {
        boolean z10 = true;
        try {
            a0.d(textView, i10);
            if (Build.VERSION.SDK_INT < 23 || textView.getTextColors().getDefaultColor() != -65281) {
                z10 = false;
            }
        } catch (Exception unused) {
        }
        if (z10) {
            a0.d(textView, 2132017681);
            textView.setTextColor(g.b(getContext(), R.color.design_error));
        }
    }

    public final boolean l() {
        r rVar = this.f3908q;
        if (rVar.f17197o != 1 || rVar.f17200r == null || TextUtils.isEmpty(rVar.f17198p)) {
            return false;
        }
        return true;
    }

    public final void m(Editable editable) {
        int i10;
        boolean z10;
        int i11;
        ((j3) this.f3916u).getClass();
        if (editable != null) {
            i10 = editable.length();
        } else {
            i10 = 0;
        }
        boolean z11 = this.f3914t;
        int i12 = this.f3912s;
        String str = null;
        if (i12 == -1) {
            this.f3918v.setText(String.valueOf(i10));
            this.f3918v.setContentDescription((CharSequence) null);
            this.f3914t = false;
        } else {
            if (i10 > i12) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f3914t = z10;
            Context context = getContext();
            t1 t1Var = this.f3918v;
            int i13 = this.f3912s;
            if (this.f3914t) {
                i11 = R.string.character_counter_overflowed_content_description;
            } else {
                i11 = R.string.character_counter_content_description;
            }
            t1Var.setContentDescription(context.getString(i11, new Object[]{Integer.valueOf(i10), Integer.valueOf(i13)}));
            if (z11 != this.f3914t) {
                n();
            }
            k0.c c10 = k0.c.c();
            t1 t1Var2 = this.f3918v;
            String string = getContext().getString(R.string.character_counter_pattern, new Object[]{Integer.valueOf(i10), Integer.valueOf(this.f3912s)});
            if (string == null) {
                c10.getClass();
            } else {
                str = c10.d(string, c10.f8949c).toString();
            }
            t1Var2.setText(str);
        }
        if (this.f3896k != null && z11 != this.f3914t) {
            s(false, false);
            v();
            p();
        }
    }

    public final void n() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        t1 t1Var = this.f3918v;
        if (t1Var != null) {
            k(t1Var, this.f3914t ? this.f3920w : this.f3922x);
            if (!this.f3914t && (colorStateList2 = this.F) != null) {
                this.f3918v.setTextColor(colorStateList2);
            }
            if (this.f3914t && (colorStateList = this.G) != null) {
                this.f3918v.setTextColor(colorStateList);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0093, code lost:
        if (r3.c() != false) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0097, code lost:
        if (r3.f17170w != null) goto L_0x0099;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0120  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean o() {
        /*
            r10 = this;
            android.widget.EditText r0 = r10.f3896k
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            android.graphics.drawable.Drawable r0 = r10.getStartIconDrawable()
            r2 = 1
            y8.v r3 = r10.f3892i
            if (r0 != 0) goto L_0x001f
            java.lang.CharSequence r0 = r10.getPrefixText()
            if (r0 == 0) goto L_0x0027
            android.widget.TextView r0 = r10.getPrefixTextView()
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0027
        L_0x001f:
            int r0 = r3.getMeasuredWidth()
            if (r0 <= 0) goto L_0x0027
            r0 = 1
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            r4 = 2
            r5 = 0
            r6 = 3
            if (r0 == 0) goto L_0x0064
            int r0 = r3.getMeasuredWidth()
            android.widget.EditText r3 = r10.f3896k
            int r3 = r3.getPaddingLeft()
            int r0 = r0 - r3
            android.graphics.drawable.ColorDrawable r3 = r10.f3891h0
            if (r3 == 0) goto L_0x0040
            int r3 = r10.f3893i0
            if (r3 == r0) goto L_0x004c
        L_0x0040:
            android.graphics.drawable.ColorDrawable r3 = new android.graphics.drawable.ColorDrawable
            r3.<init>()
            r10.f3891h0 = r3
            r10.f3893i0 = r0
            r3.setBounds(r1, r1, r0, r2)
        L_0x004c:
            android.widget.EditText r0 = r10.f3896k
            android.graphics.drawable.Drawable[] r0 = q0.u.a(r0)
            r3 = r0[r1]
            android.graphics.drawable.ColorDrawable r7 = r10.f3891h0
            if (r3 == r7) goto L_0x007d
            android.widget.EditText r3 = r10.f3896k
            r8 = r0[r2]
            r9 = r0[r4]
            r0 = r0[r6]
            q0.u.e(r3, r7, r8, r9, r0)
            goto L_0x007b
        L_0x0064:
            android.graphics.drawable.ColorDrawable r0 = r10.f3891h0
            if (r0 == 0) goto L_0x007d
            android.widget.EditText r0 = r10.f3896k
            android.graphics.drawable.Drawable[] r0 = q0.u.a(r0)
            android.widget.EditText r3 = r10.f3896k
            r7 = r0[r2]
            r8 = r0[r4]
            r0 = r0[r6]
            q0.u.e(r3, r5, r7, r8, r0)
            r10.f3891h0 = r5
        L_0x007b:
            r0 = 1
            goto L_0x007e
        L_0x007d:
            r0 = 0
        L_0x007e:
            y8.n r3 = r10.f3894j
            boolean r7 = r3.d()
            if (r7 != 0) goto L_0x0099
            int r7 = r3.f17163p
            if (r7 == 0) goto L_0x008c
            r7 = 1
            goto L_0x008d
        L_0x008c:
            r7 = 0
        L_0x008d:
            if (r7 == 0) goto L_0x0095
            boolean r7 = r3.c()
            if (r7 != 0) goto L_0x0099
        L_0x0095:
            java.lang.CharSequence r7 = r3.f17170w
            if (r7 == 0) goto L_0x00a1
        L_0x0099:
            int r7 = r3.getMeasuredWidth()
            if (r7 <= 0) goto L_0x00a1
            r7 = 1
            goto L_0x00a2
        L_0x00a1:
            r7 = 0
        L_0x00a2:
            if (r7 == 0) goto L_0x0120
            androidx.appcompat.widget.t1 r7 = r3.f17171x
            int r7 = r7.getMeasuredWidth()
            android.widget.EditText r8 = r10.f3896k
            int r8 = r8.getPaddingRight()
            int r7 = r7 - r8
            boolean r8 = r3.d()
            if (r8 == 0) goto L_0x00ba
            com.google.android.material.internal.CheckableImageButton r5 = r3.f17157j
            goto L_0x00cb
        L_0x00ba:
            int r8 = r3.f17163p
            if (r8 == 0) goto L_0x00c0
            r8 = 1
            goto L_0x00c1
        L_0x00c0:
            r8 = 0
        L_0x00c1:
            if (r8 == 0) goto L_0x00cb
            boolean r8 = r3.c()
            if (r8 == 0) goto L_0x00cb
            com.google.android.material.internal.CheckableImageButton r5 = r3.f17161n
        L_0x00cb:
            if (r5 == 0) goto L_0x00de
            int r3 = r5.getMeasuredWidth()
            int r3 = r3 + r7
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r5 = (android.view.ViewGroup.MarginLayoutParams) r5
            int r5 = m0.p.c(r5)
            int r7 = r5 + r3
        L_0x00de:
            android.widget.EditText r3 = r10.f3896k
            android.graphics.drawable.Drawable[] r3 = q0.u.a(r3)
            android.graphics.drawable.ColorDrawable r5 = r10.f3897k0
            if (r5 == 0) goto L_0x00fc
            int r8 = r10.f3899l0
            if (r8 == r7) goto L_0x00fc
            r10.f3899l0 = r7
            r5.setBounds(r1, r1, r7, r2)
            android.widget.EditText r0 = r10.f3896k
            r1 = r3[r1]
            r4 = r3[r2]
            android.graphics.drawable.ColorDrawable r5 = r10.f3897k0
            r3 = r3[r6]
            goto L_0x011a
        L_0x00fc:
            if (r5 != 0) goto L_0x010a
            android.graphics.drawable.ColorDrawable r5 = new android.graphics.drawable.ColorDrawable
            r5.<init>()
            r10.f3897k0 = r5
            r10.f3899l0 = r7
            r5.setBounds(r1, r1, r7, r2)
        L_0x010a:
            r4 = r3[r4]
            android.graphics.drawable.ColorDrawable r5 = r10.f3897k0
            if (r4 == r5) goto L_0x011e
            r10.f3901m0 = r4
            android.widget.EditText r0 = r10.f3896k
            r1 = r3[r1]
            r4 = r3[r2]
            r3 = r3[r6]
        L_0x011a:
            q0.u.e(r0, r1, r4, r5, r3)
            goto L_0x0141
        L_0x011e:
            r2 = r0
            goto L_0x0141
        L_0x0120:
            android.graphics.drawable.ColorDrawable r3 = r10.f3897k0
            if (r3 == 0) goto L_0x0142
            android.widget.EditText r3 = r10.f3896k
            android.graphics.drawable.Drawable[] r3 = q0.u.a(r3)
            r4 = r3[r4]
            android.graphics.drawable.ColorDrawable r7 = r10.f3897k0
            if (r4 != r7) goto L_0x013e
            android.widget.EditText r0 = r10.f3896k
            r1 = r3[r1]
            r4 = r3[r2]
            android.graphics.drawable.Drawable r7 = r10.f3901m0
            r3 = r3[r6]
            q0.u.e(r0, r1, r4, r7, r3)
            goto L_0x013f
        L_0x013e:
            r2 = r0
        L_0x013f:
            r10.f3897k0 = r5
        L_0x0141:
            r0 = r2
        L_0x0142:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.o():boolean");
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f3927z0.h(configuration);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        /*
            r6 = this;
            super.onLayout(r7, r8, r9, r10, r11)
            android.widget.EditText r7 = r6.f3896k
            if (r7 == 0) goto L_0x01ae
            android.graphics.Rect r8 = r6.f3886d0
            m8.e.a(r6, r7, r8)
            t8.i r7 = r6.O
            if (r7 == 0) goto L_0x001d
            int r9 = r8.bottom
            int r10 = r6.W
            int r10 = r9 - r10
            int r11 = r8.left
            int r0 = r8.right
            r7.setBounds(r11, r10, r0, r9)
        L_0x001d:
            t8.i r7 = r6.P
            if (r7 == 0) goto L_0x002e
            int r9 = r8.bottom
            int r10 = r6.f3883a0
            int r10 = r9 - r10
            int r11 = r8.left
            int r0 = r8.right
            r7.setBounds(r11, r10, r0, r9)
        L_0x002e:
            boolean r7 = r6.H
            if (r7 == 0) goto L_0x01ae
            android.widget.EditText r7 = r6.f3896k
            float r7 = r7.getTextSize()
            m8.d r9 = r6.f3927z0
            float r10 = r9.f10741l
            r11 = 0
            int r10 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r10 == 0) goto L_0x0046
            r9.f10741l = r7
            r9.i(r11)
        L_0x0046:
            android.widget.EditText r7 = r6.f3896k
            int r7 = r7.getGravity()
            r10 = r7 & -113(0xffffffffffffff8f, float:NaN)
            r10 = r10 | 48
            r9.l(r10)
            int r10 = r9.f10737j
            if (r10 == r7) goto L_0x005c
            r9.f10737j = r7
            r9.i(r11)
        L_0x005c:
            android.widget.EditText r7 = r6.f3896k
            if (r7 == 0) goto L_0x01a8
            boolean r7 = m8.w.c(r6)
            int r10 = r8.bottom
            android.graphics.Rect r0 = r6.f3887e0
            r0.bottom = r10
            int r10 = r6.T
            r1 = 1
            if (r10 == r1) goto L_0x009d
            r2 = 2
            if (r10 == r2) goto L_0x007f
            int r10 = r8.left
            int r10 = r6.g(r10, r7)
            r0.left = r10
            int r10 = r6.getPaddingTop()
            goto L_0x00aa
        L_0x007f:
            int r7 = r8.left
            android.widget.EditText r10 = r6.f3896k
            int r10 = r10.getPaddingLeft()
            int r10 = r10 + r7
            r0.left = r10
            int r7 = r8.top
            int r10 = r6.c()
            int r7 = r7 - r10
            r0.top = r7
            int r7 = r8.right
            android.widget.EditText r10 = r6.f3896k
            int r10 = r10.getPaddingRight()
            int r7 = r7 - r10
            goto L_0x00d1
        L_0x009d:
            int r10 = r8.left
            int r10 = r6.g(r10, r7)
            r0.left = r10
            int r10 = r8.top
            int r2 = r6.U
            int r10 = r10 + r2
        L_0x00aa:
            r0.top = r10
            int r10 = r8.right
            android.widget.EditText r2 = r6.f3896k
            int r2 = r2.getCompoundPaddingRight()
            int r10 = r10 - r2
            java.lang.CharSequence r2 = r6.getPrefixText()
            if (r2 == 0) goto L_0x00d0
            if (r7 == 0) goto L_0x00d0
            android.widget.TextView r7 = r6.getPrefixTextView()
            int r7 = r7.getMeasuredWidth()
            android.widget.TextView r2 = r6.getPrefixTextView()
            int r2 = r2.getPaddingRight()
            int r7 = r7 - r2
            int r7 = r7 + r10
            goto L_0x00d1
        L_0x00d0:
            r7 = r10
        L_0x00d1:
            r0.right = r7
            int r10 = r0.left
            int r2 = r0.top
            int r3 = r0.bottom
            android.graphics.Rect r4 = r9.f10733h
            int r5 = r4.left
            if (r5 != r10) goto L_0x00ed
            int r5 = r4.top
            if (r5 != r2) goto L_0x00ed
            int r5 = r4.right
            if (r5 != r7) goto L_0x00ed
            int r5 = r4.bottom
            if (r5 != r3) goto L_0x00ed
            r5 = 1
            goto L_0x00ee
        L_0x00ed:
            r5 = 0
        L_0x00ee:
            if (r5 != 0) goto L_0x00f5
            r4.set(r10, r2, r7, r3)
            r9.S = r1
        L_0x00f5:
            android.widget.EditText r7 = r6.f3896k
            if (r7 == 0) goto L_0x01a2
            android.text.TextPaint r7 = r9.U
            float r10 = r9.f10741l
            r7.setTextSize(r10)
            android.graphics.Typeface r10 = r9.f10761z
            r7.setTypeface(r10)
            float r10 = r9.f10732g0
            r7.setLetterSpacing(r10)
            float r7 = r7.ascent()
            float r7 = -r7
            int r10 = r8.left
            android.widget.EditText r2 = r6.f3896k
            int r2 = r2.getCompoundPaddingLeft()
            int r2 = r2 + r10
            r0.left = r2
            int r10 = r6.T
            if (r10 != r1) goto L_0x0128
            android.widget.EditText r10 = r6.f3896k
            int r10 = r10.getMinLines()
            if (r10 > r1) goto L_0x0128
            r10 = 1
            goto L_0x0129
        L_0x0128:
            r10 = 0
        L_0x0129:
            if (r10 == 0) goto L_0x0137
            int r10 = r8.centerY()
            float r10 = (float) r10
            r2 = 1073741824(0x40000000, float:2.0)
            float r2 = r7 / r2
            float r10 = r10 - r2
            int r10 = (int) r10
            goto L_0x0140
        L_0x0137:
            int r10 = r8.top
            android.widget.EditText r2 = r6.f3896k
            int r2 = r2.getCompoundPaddingTop()
            int r10 = r10 + r2
        L_0x0140:
            r0.top = r10
            int r10 = r8.right
            android.widget.EditText r2 = r6.f3896k
            int r2 = r2.getCompoundPaddingRight()
            int r10 = r10 - r2
            r0.right = r10
            int r10 = r6.T
            if (r10 != r1) goto L_0x015b
            android.widget.EditText r10 = r6.f3896k
            int r10 = r10.getMinLines()
            if (r10 > r1) goto L_0x015b
            r10 = 1
            goto L_0x015c
        L_0x015b:
            r10 = 0
        L_0x015c:
            if (r10 == 0) goto L_0x0164
            int r8 = r0.top
            float r8 = (float) r8
            float r8 = r8 + r7
            int r7 = (int) r8
            goto L_0x016d
        L_0x0164:
            int r7 = r8.bottom
            android.widget.EditText r8 = r6.f3896k
            int r8 = r8.getCompoundPaddingBottom()
            int r7 = r7 - r8
        L_0x016d:
            r0.bottom = r7
            int r8 = r0.left
            int r10 = r0.top
            int r0 = r0.right
            android.graphics.Rect r2 = r9.f10731g
            int r3 = r2.left
            if (r3 != r8) goto L_0x0189
            int r3 = r2.top
            if (r3 != r10) goto L_0x0189
            int r3 = r2.right
            if (r3 != r0) goto L_0x0189
            int r3 = r2.bottom
            if (r3 != r7) goto L_0x0189
            r3 = 1
            goto L_0x018a
        L_0x0189:
            r3 = 0
        L_0x018a:
            if (r3 != 0) goto L_0x0191
            r2.set(r8, r10, r0, r7)
            r9.S = r1
        L_0x0191:
            r9.i(r11)
            boolean r7 = r6.e()
            if (r7 == 0) goto L_0x01ae
            boolean r7 = r6.f3925y0
            if (r7 != 0) goto L_0x01ae
            r6.i()
            goto L_0x01ae
        L_0x01a2:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>()
            throw r7
        L_0x01a8:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            r7.<init>()
            throw r7
        L_0x01ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.onLayout(boolean, int, int, int, int):void");
    }

    public final void onMeasure(int i10, int i11) {
        boolean z10;
        EditText editText;
        int max;
        super.onMeasure(i10, i11);
        EditText editText2 = this.f3896k;
        y8.n nVar = this.f3894j;
        if (editText2 != null && this.f3896k.getMeasuredHeight() < (max = Math.max(nVar.getMeasuredHeight(), this.f3892i.getMeasuredHeight()))) {
            this.f3896k.setMinimumHeight(max);
            z10 = true;
        } else {
            z10 = false;
        }
        boolean o10 = o();
        if (z10 || o10) {
            this.f3896k.post(new y8.w(this, 1));
        }
        if (!(this.A == null || (editText = this.f3896k) == null)) {
            this.A.setGravity(editText.getGravity());
            this.A.setPadding(this.f3896k.getCompoundPaddingLeft(), this.f3896k.getCompoundPaddingTop(), this.f3896k.getCompoundPaddingRight(), this.f3896k.getCompoundPaddingBottom());
        }
        nVar.l();
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof y8.a0)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        y8.a0 a0Var = (y8.a0) parcelable;
        super.onRestoreInstanceState(a0Var.f14484h);
        setError(a0Var.f17120j);
        if (a0Var.f17121k) {
            post(new y8.w(this, 0));
        }
        requestLayout();
    }

    public final void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        boolean z10 = true;
        if (i10 != 1) {
            z10 = false;
        }
        if (z10 != this.R) {
            t8.c cVar = this.Q.f14782e;
            RectF rectF = this.f3888f0;
            float a10 = cVar.a(rectF);
            float a11 = this.Q.f14783f.a(rectF);
            float a12 = this.Q.f14785h.a(rectF);
            float a13 = this.Q.f14784g.a(rectF);
            n nVar = this.Q;
            t8.d dVar = nVar.f14778a;
            t8.m mVar = new t8.m();
            t8.d dVar2 = nVar.f14779b;
            mVar.f14765a = dVar2;
            float b10 = t8.m.b(dVar2);
            if (b10 != -1.0f) {
                mVar.f14769e = new t8.a(b10);
            }
            mVar.f14766b = dVar;
            float b11 = t8.m.b(dVar);
            if (b11 != -1.0f) {
                mVar.f14770f = new t8.a(b11);
            }
            t8.d dVar3 = nVar.f14780c;
            mVar.f14768d = dVar3;
            float b12 = t8.m.b(dVar3);
            if (b12 != -1.0f) {
                mVar.f14772h = new t8.a(b12);
            }
            t8.d dVar4 = nVar.f14781d;
            mVar.f14767c = dVar4;
            float b13 = t8.m.b(dVar4);
            if (b13 != -1.0f) {
                mVar.f14771g = new t8.a(b13);
            }
            mVar.f14769e = new t8.a(a11);
            mVar.f14770f = new t8.a(a10);
            mVar.f14772h = new t8.a(a13);
            mVar.f14771g = new t8.a(a12);
            n nVar2 = new n(mVar);
            this.R = z10;
            setShapeAppearanceModel(nVar2);
        }
    }

    public final Parcelable onSaveInstanceState() {
        boolean z10;
        y8.a0 a0Var = new y8.a0(super.onSaveInstanceState());
        if (l()) {
            a0Var.f17120j = getError();
        }
        y8.n nVar = this.f3894j;
        boolean z11 = true;
        if (nVar.f17163p != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 || !nVar.f17161n.isChecked()) {
            z11 = false;
        }
        a0Var.f17121k = z11;
        return a0Var;
    }

    public final void p() {
        Drawable background;
        int i10;
        t1 t1Var;
        EditText editText = this.f3896k;
        if (editText != null && this.T == 0 && (background = editText.getBackground()) != null) {
            int[] iArr = i2.f869a;
            Drawable mutate = background.mutate();
            if (l()) {
                i10 = getErrorCurrentTextColors();
            } else if (!this.f3914t || (t1Var = this.f3918v) == null) {
                f0.d.a(mutate);
                this.f3896k.refreshDrawableState();
                return;
            } else {
                i10 = t1Var.getCurrentTextColor();
            }
            mutate.setColorFilter(h0.c(i10, PorterDuff.Mode.SRC_IN));
        }
    }

    public final void q() {
        EditText editText = this.f3896k;
        if (editText != null && this.K != null) {
            if ((this.N || editText.getBackground() == null) && this.T != 0) {
                EditText editText2 = this.f3896k;
                Drawable editTextBoxBackground = getEditTextBoxBackground();
                WeakHashMap weakHashMap = c1.f10054a;
                i0.q(editText2, editTextBoxBackground);
                this.N = true;
            }
        }
    }

    public final void r() {
        if (this.T != 1) {
            FrameLayout frameLayout = this.f3890h;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int c10 = c();
            if (c10 != layoutParams.topMargin) {
                layoutParams.topMargin = c10;
                frameLayout.requestLayout();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:77:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void s(boolean r10, boolean r11) {
        /*
            r9 = this;
            boolean r0 = r9.isEnabled()
            android.widget.EditText r1 = r9.f3896k
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0016
            android.text.Editable r1 = r1.getText()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0016
            r1 = 1
            goto L_0x0017
        L_0x0016:
            r1 = 0
        L_0x0017:
            android.widget.EditText r4 = r9.f3896k
            if (r4 == 0) goto L_0x0023
            boolean r4 = r4.hasFocus()
            if (r4 == 0) goto L_0x0023
            r4 = 1
            goto L_0x0024
        L_0x0023:
            r4 = 0
        L_0x0024:
            android.content.res.ColorStateList r5 = r9.f3903n0
            m8.d r6 = r9.f3927z0
            if (r5 == 0) goto L_0x002d
            r6.j(r5)
        L_0x002d:
            r5 = 0
            if (r0 != 0) goto L_0x0049
            android.content.res.ColorStateList r0 = r9.f3903n0
            if (r0 == 0) goto L_0x0042
            int[] r7 = new int[r2]
            r8 = -16842910(0xfffffffffefeff62, float:-1.6947497E38)
            r7[r3] = r8
            int r8 = r9.f3923x0
            int r0 = r0.getColorForState(r7, r8)
            goto L_0x0044
        L_0x0042:
            int r0 = r9.f3923x0
        L_0x0044:
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
            goto L_0x0068
        L_0x0049:
            boolean r0 = r9.l()
            if (r0 == 0) goto L_0x005c
            y8.r r0 = r9.f3908q
            androidx.appcompat.widget.t1 r0 = r0.f17200r
            if (r0 == 0) goto L_0x005a
            android.content.res.ColorStateList r0 = r0.getTextColors()
            goto L_0x0068
        L_0x005a:
            r0 = r5
            goto L_0x0068
        L_0x005c:
            boolean r0 = r9.f3914t
            if (r0 == 0) goto L_0x006c
            androidx.appcompat.widget.t1 r0 = r9.f3918v
            if (r0 == 0) goto L_0x006c
            android.content.res.ColorStateList r0 = r0.getTextColors()
        L_0x0068:
            r6.j(r0)
            goto L_0x007b
        L_0x006c:
            if (r4 == 0) goto L_0x007b
            android.content.res.ColorStateList r0 = r9.f3905o0
            if (r0 == 0) goto L_0x007b
            android.content.res.ColorStateList r7 = r6.f10747o
            if (r7 == r0) goto L_0x007b
            r6.f10747o = r0
            r6.i(r3)
        L_0x007b:
            y8.n r0 = r9.f3894j
            y8.v r7 = r9.f3892i
            if (r1 != 0) goto L_0x00f8
            boolean r1 = r9.A0
            if (r1 == 0) goto L_0x00f8
            boolean r1 = r9.isEnabled()
            if (r1 == 0) goto L_0x008e
            if (r4 == 0) goto L_0x008e
            goto L_0x00f8
        L_0x008e:
            if (r11 != 0) goto L_0x0094
            boolean r11 = r9.f3925y0
            if (r11 != 0) goto L_0x013d
        L_0x0094:
            android.animation.ValueAnimator r11 = r9.C0
            if (r11 == 0) goto L_0x00a3
            boolean r11 = r11.isRunning()
            if (r11 == 0) goto L_0x00a3
            android.animation.ValueAnimator r11 = r9.C0
            r11.cancel()
        L_0x00a3:
            r11 = 0
            if (r10 == 0) goto L_0x00ae
            boolean r10 = r9.B0
            if (r10 == 0) goto L_0x00ae
            r9.a(r11)
            goto L_0x00b1
        L_0x00ae:
            r6.p(r11)
        L_0x00b1:
            boolean r10 = r9.e()
            if (r10 == 0) goto L_0x00d3
            t8.i r10 = r9.K
            y8.h r10 = (y8.h) r10
            y8.f r10 = r10.E
            android.graphics.RectF r10 = r10.f17136v
            boolean r10 = r10.isEmpty()
            r10 = r10 ^ r2
            if (r10 == 0) goto L_0x00d3
            boolean r10 = r9.e()
            if (r10 == 0) goto L_0x00d3
            t8.i r10 = r9.K
            y8.h r10 = (y8.h) r10
            r10.o(r11, r11, r11, r11)
        L_0x00d3:
            r9.f3925y0 = r2
            androidx.appcompat.widget.t1 r10 = r9.A
            if (r10 == 0) goto L_0x00ed
            boolean r11 = r9.f3926z
            if (r11 == 0) goto L_0x00ed
            r10.setText(r5)
            android.widget.FrameLayout r10 = r9.f3890h
            b4.h r11 = r9.E
            b4.x.a(r10, r11)
            androidx.appcompat.widget.t1 r10 = r9.A
            r11 = 4
            r10.setVisibility(r11)
        L_0x00ed:
            r7.f17231q = r2
            r7.d()
            r0.f17172y = r2
            r0.m()
            goto L_0x013d
        L_0x00f8:
            if (r11 != 0) goto L_0x00fe
            boolean r11 = r9.f3925y0
            if (r11 == 0) goto L_0x013d
        L_0x00fe:
            android.animation.ValueAnimator r11 = r9.C0
            if (r11 == 0) goto L_0x010d
            boolean r11 = r11.isRunning()
            if (r11 == 0) goto L_0x010d
            android.animation.ValueAnimator r11 = r9.C0
            r11.cancel()
        L_0x010d:
            r11 = 1065353216(0x3f800000, float:1.0)
            if (r10 == 0) goto L_0x0119
            boolean r10 = r9.B0
            if (r10 == 0) goto L_0x0119
            r9.a(r11)
            goto L_0x011c
        L_0x0119:
            r6.p(r11)
        L_0x011c:
            r9.f3925y0 = r3
            boolean r10 = r9.e()
            if (r10 == 0) goto L_0x0127
            r9.i()
        L_0x0127:
            android.widget.EditText r10 = r9.f3896k
            if (r10 != 0) goto L_0x012c
            goto L_0x0130
        L_0x012c:
            android.text.Editable r5 = r10.getText()
        L_0x0130:
            r9.t(r5)
            r7.f17231q = r3
            r7.d()
            r0.f17172y = r3
            r0.m()
        L_0x013d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.s(boolean, boolean):void");
    }

    public void setBoxBackgroundColor(int i10) {
        if (this.f3885c0 != i10) {
            this.f3885c0 = i10;
            this.f3915t0 = i10;
            this.f3919v0 = i10;
            this.f3921w0 = i10;
            b();
        }
    }

    public void setBoxBackgroundColorResource(int i10) {
        setBoxBackgroundColor(g.b(getContext(), i10));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f3915t0 = defaultColor;
        this.f3885c0 = defaultColor;
        this.f3917u0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f3919v0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.f3921w0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        b();
    }

    public void setBoxBackgroundMode(int i10) {
        if (i10 != this.T) {
            this.T = i10;
            if (this.f3896k != null) {
                h();
            }
        }
    }

    public void setBoxCollapsedPaddingTop(int i10) {
        this.U = i10;
    }

    public void setBoxCornerFamily(int i10) {
        n nVar = this.Q;
        nVar.getClass();
        t8.m mVar = new t8.m(nVar);
        t8.c cVar = this.Q.f14782e;
        t8.d a10 = j.a(i10);
        mVar.f14765a = a10;
        float b10 = t8.m.b(a10);
        if (b10 != -1.0f) {
            mVar.f14769e = new t8.a(b10);
        }
        mVar.f14769e = cVar;
        t8.c cVar2 = this.Q.f14783f;
        t8.d a11 = j.a(i10);
        mVar.f14766b = a11;
        float b11 = t8.m.b(a11);
        if (b11 != -1.0f) {
            mVar.f14770f = new t8.a(b11);
        }
        mVar.f14770f = cVar2;
        t8.c cVar3 = this.Q.f14785h;
        t8.d a12 = j.a(i10);
        mVar.f14768d = a12;
        float b12 = t8.m.b(a12);
        if (b12 != -1.0f) {
            mVar.f14772h = new t8.a(b12);
        }
        mVar.f14772h = cVar3;
        t8.c cVar4 = this.Q.f14784g;
        t8.d a13 = j.a(i10);
        mVar.f14767c = a13;
        float b13 = t8.m.b(a13);
        if (b13 != -1.0f) {
            mVar.f14771g = new t8.a(b13);
        }
        mVar.f14771g = cVar4;
        this.Q = new n(mVar);
        b();
    }

    public void setBoxStrokeColor(int i10) {
        if (this.f3911r0 != i10) {
            this.f3911r0 = i10;
            v();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        int defaultColor;
        if (colorStateList.isStateful()) {
            this.f3907p0 = colorStateList.getDefaultColor();
            this.f3923x0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f3909q0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            defaultColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else {
            if (this.f3911r0 != colorStateList.getDefaultColor()) {
                defaultColor = colorStateList.getDefaultColor();
            }
            v();
        }
        this.f3911r0 = defaultColor;
        v();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f3913s0 != colorStateList) {
            this.f3913s0 = colorStateList;
            v();
        }
    }

    public void setBoxStrokeWidth(int i10) {
        this.W = i10;
        v();
    }

    public void setBoxStrokeWidthFocused(int i10) {
        this.f3883a0 = i10;
        v();
    }

    public void setBoxStrokeWidthFocusedResource(int i10) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i10));
    }

    public void setBoxStrokeWidthResource(int i10) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i10));
    }

    public void setCounterEnabled(boolean z10) {
        if (this.f3910r != z10) {
            Editable editable = null;
            r rVar = this.f3908q;
            if (z10) {
                t1 t1Var = new t1(getContext(), (AttributeSet) null);
                this.f3918v = t1Var;
                t1Var.setId(R.id.textinput_counter);
                Typeface typeface = this.f3889g0;
                if (typeface != null) {
                    this.f3918v.setTypeface(typeface);
                }
                this.f3918v.setMaxLines(1);
                rVar.a(this.f3918v, 2);
                p.h((ViewGroup.MarginLayoutParams) this.f3918v.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                n();
                if (this.f3918v != null) {
                    EditText editText = this.f3896k;
                    if (editText != null) {
                        editable = editText.getText();
                    }
                    m(editable);
                }
            } else {
                rVar.g(this.f3918v, 2);
                this.f3918v = null;
            }
            this.f3910r = z10;
        }
    }

    public void setCounterMaxLength(int i10) {
        Editable editable;
        if (this.f3912s != i10) {
            if (i10 <= 0) {
                i10 = -1;
            }
            this.f3912s = i10;
            if (this.f3910r && this.f3918v != null) {
                EditText editText = this.f3896k;
                if (editText == null) {
                    editable = null;
                } else {
                    editable = editText.getText();
                }
                m(editable);
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i10) {
        if (this.f3920w != i10) {
            this.f3920w = i10;
            n();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            n();
        }
    }

    public void setCounterTextAppearance(int i10) {
        if (this.f3922x != i10) {
            this.f3922x = i10;
            n();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            n();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f3903n0 = colorStateList;
        this.f3905o0 = colorStateList;
        if (this.f3896k != null) {
            s(false, false);
        }
    }

    public void setEnabled(boolean z10) {
        j(this, z10);
        super.setEnabled(z10);
    }

    public void setEndIconActivated(boolean z10) {
        this.f3894j.f17161n.setActivated(z10);
    }

    public void setEndIconCheckable(boolean z10) {
        this.f3894j.f17161n.setCheckable(z10);
    }

    public void setEndIconContentDescription(int i10) {
        y8.n nVar = this.f3894j;
        CharSequence text = i10 != 0 ? nVar.getResources().getText(i10) : null;
        CheckableImageButton checkableImageButton = nVar.f17161n;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
    }

    public void setEndIconDrawable(int i10) {
        y8.n nVar = this.f3894j;
        Drawable a10 = i10 != 0 ? h.a.a(nVar.getContext(), i10) : null;
        CheckableImageButton checkableImageButton = nVar.f17161n;
        checkableImageButton.setImageDrawable(a10);
        if (a10 != null) {
            ColorStateList colorStateList = nVar.f17165r;
            PorterDuff.Mode mode = nVar.f17166s;
            TextInputLayout textInputLayout = nVar.f17155h;
            y8.p.a(textInputLayout, checkableImageButton, colorStateList, mode);
            y8.p.c(textInputLayout, checkableImageButton, nVar.f17165r);
        }
    }

    public void setEndIconMinSize(int i10) {
        y8.n nVar = this.f3894j;
        if (i10 < 0) {
            nVar.getClass();
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        } else if (i10 != nVar.f17167t) {
            nVar.f17167t = i10;
            CheckableImageButton checkableImageButton = nVar.f17161n;
            checkableImageButton.setMinimumWidth(i10);
            checkableImageButton.setMinimumHeight(i10);
            CheckableImageButton checkableImageButton2 = nVar.f17157j;
            checkableImageButton2.setMinimumWidth(i10);
            checkableImageButton2.setMinimumHeight(i10);
        }
    }

    public void setEndIconMode(int i10) {
        this.f3894j.f(i10);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        y8.n nVar = this.f3894j;
        View.OnLongClickListener onLongClickListener = nVar.f17169v;
        CheckableImageButton checkableImageButton = nVar.f17161n;
        checkableImageButton.setOnClickListener(onClickListener);
        y8.p.e(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        y8.n nVar = this.f3894j;
        nVar.f17169v = onLongClickListener;
        CheckableImageButton checkableImageButton = nVar.f17161n;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        y8.p.e(checkableImageButton, onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        y8.n nVar = this.f3894j;
        nVar.f17168u = scaleType;
        nVar.f17161n.setScaleType(scaleType);
        nVar.f17157j.setScaleType(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        y8.n nVar = this.f3894j;
        if (nVar.f17165r != colorStateList) {
            nVar.f17165r = colorStateList;
            y8.p.a(nVar.f17155h, nVar.f17161n, colorStateList, nVar.f17166s);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        y8.n nVar = this.f3894j;
        if (nVar.f17166s != mode) {
            nVar.f17166s = mode;
            y8.p.a(nVar.f17155h, nVar.f17161n, nVar.f17165r, mode);
        }
    }

    public void setEndIconVisible(boolean z10) {
        this.f3894j.g(z10);
    }

    public void setError(CharSequence charSequence) {
        r rVar = this.f3908q;
        if (!rVar.f17199q) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            rVar.c();
            rVar.f17198p = charSequence;
            rVar.f17200r.setText(charSequence);
            int i10 = rVar.f17196n;
            if (i10 != 1) {
                rVar.f17197o = 1;
            }
            rVar.i(i10, rVar.f17197o, rVar.h(rVar.f17200r, charSequence));
            return;
        }
        rVar.f();
    }

    public void setErrorAccessibilityLiveRegion(int i10) {
        r rVar = this.f3908q;
        rVar.f17202t = i10;
        t1 t1Var = rVar.f17200r;
        if (t1Var != null) {
            WeakHashMap weakHashMap = c1.f10054a;
            l0.f(t1Var, i10);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        r rVar = this.f3908q;
        rVar.f17201s = charSequence;
        t1 t1Var = rVar.f17200r;
        if (t1Var != null) {
            t1Var.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z10) {
        r rVar = this.f3908q;
        if (rVar.f17199q != z10) {
            rVar.c();
            TextInputLayout textInputLayout = rVar.f17190h;
            if (z10) {
                t1 t1Var = new t1(rVar.f17189g, (AttributeSet) null);
                rVar.f17200r = t1Var;
                t1Var.setId(R.id.textinput_error);
                rVar.f17200r.setTextAlignment(5);
                Typeface typeface = rVar.B;
                if (typeface != null) {
                    rVar.f17200r.setTypeface(typeface);
                }
                int i10 = rVar.f17203u;
                rVar.f17203u = i10;
                t1 t1Var2 = rVar.f17200r;
                if (t1Var2 != null) {
                    textInputLayout.k(t1Var2, i10);
                }
                ColorStateList colorStateList = rVar.f17204v;
                rVar.f17204v = colorStateList;
                t1 t1Var3 = rVar.f17200r;
                if (!(t1Var3 == null || colorStateList == null)) {
                    t1Var3.setTextColor(colorStateList);
                }
                CharSequence charSequence = rVar.f17201s;
                rVar.f17201s = charSequence;
                t1 t1Var4 = rVar.f17200r;
                if (t1Var4 != null) {
                    t1Var4.setContentDescription(charSequence);
                }
                int i11 = rVar.f17202t;
                rVar.f17202t = i11;
                t1 t1Var5 = rVar.f17200r;
                if (t1Var5 != null) {
                    WeakHashMap weakHashMap = c1.f10054a;
                    l0.f(t1Var5, i11);
                }
                rVar.f17200r.setVisibility(4);
                rVar.a(rVar.f17200r, 0);
            } else {
                rVar.f();
                rVar.g(rVar.f17200r, 0);
                rVar.f17200r = null;
                textInputLayout.p();
                textInputLayout.v();
            }
            rVar.f17199q = z10;
        }
    }

    public void setErrorIconDrawable(int i10) {
        y8.n nVar = this.f3894j;
        nVar.h(i10 != 0 ? h.a.a(nVar.getContext(), i10) : null);
        y8.p.c(nVar.f17155h, nVar.f17157j, nVar.f17158k);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        y8.n nVar = this.f3894j;
        CheckableImageButton checkableImageButton = nVar.f17157j;
        View.OnLongClickListener onLongClickListener = nVar.f17160m;
        checkableImageButton.setOnClickListener(onClickListener);
        y8.p.e(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        y8.n nVar = this.f3894j;
        nVar.f17160m = onLongClickListener;
        CheckableImageButton checkableImageButton = nVar.f17157j;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        y8.p.e(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        y8.n nVar = this.f3894j;
        if (nVar.f17158k != colorStateList) {
            nVar.f17158k = colorStateList;
            y8.p.a(nVar.f17155h, nVar.f17157j, colorStateList, nVar.f17159l);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        y8.n nVar = this.f3894j;
        if (nVar.f17159l != mode) {
            nVar.f17159l = mode;
            y8.p.a(nVar.f17155h, nVar.f17157j, nVar.f17158k, mode);
        }
    }

    public void setErrorTextAppearance(int i10) {
        r rVar = this.f3908q;
        rVar.f17203u = i10;
        t1 t1Var = rVar.f17200r;
        if (t1Var != null) {
            rVar.f17190h.k(t1Var, i10);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        r rVar = this.f3908q;
        rVar.f17204v = colorStateList;
        t1 t1Var = rVar.f17200r;
        if (t1Var != null && colorStateList != null) {
            t1Var.setTextColor(colorStateList);
        }
    }

    public void setExpandedHintEnabled(boolean z10) {
        if (this.A0 != z10) {
            this.A0 = z10;
            s(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        boolean isEmpty = TextUtils.isEmpty(charSequence);
        r rVar = this.f3908q;
        if (!isEmpty) {
            if (!rVar.f17206x) {
                setHelperTextEnabled(true);
            }
            rVar.c();
            rVar.f17205w = charSequence;
            rVar.f17207y.setText(charSequence);
            int i10 = rVar.f17196n;
            if (i10 != 2) {
                rVar.f17197o = 2;
            }
            rVar.i(i10, rVar.f17197o, rVar.h(rVar.f17207y, charSequence));
        } else if (rVar.f17206x) {
            setHelperTextEnabled(false);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        r rVar = this.f3908q;
        rVar.A = colorStateList;
        t1 t1Var = rVar.f17207y;
        if (t1Var != null && colorStateList != null) {
            t1Var.setTextColor(colorStateList);
        }
    }

    public void setHelperTextEnabled(boolean z10) {
        r rVar = this.f3908q;
        if (rVar.f17206x != z10) {
            rVar.c();
            if (z10) {
                t1 t1Var = new t1(rVar.f17189g, (AttributeSet) null);
                rVar.f17207y = t1Var;
                t1Var.setId(R.id.textinput_helper_text);
                rVar.f17207y.setTextAlignment(5);
                Typeface typeface = rVar.B;
                if (typeface != null) {
                    rVar.f17207y.setTypeface(typeface);
                }
                rVar.f17207y.setVisibility(4);
                l0.f(rVar.f17207y, 1);
                int i10 = rVar.f17208z;
                rVar.f17208z = i10;
                t1 t1Var2 = rVar.f17207y;
                if (t1Var2 != null) {
                    a0.d(t1Var2, i10);
                }
                ColorStateList colorStateList = rVar.A;
                rVar.A = colorStateList;
                t1 t1Var3 = rVar.f17207y;
                if (!(t1Var3 == null || colorStateList == null)) {
                    t1Var3.setTextColor(colorStateList);
                }
                rVar.a(rVar.f17207y, 1);
                rVar.f17207y.setAccessibilityDelegate(new androidx.appcompat.widget.w(1, rVar));
            } else {
                rVar.c();
                int i11 = rVar.f17196n;
                if (i11 == 2) {
                    rVar.f17197o = 0;
                }
                rVar.i(i11, rVar.f17197o, rVar.h(rVar.f17207y, ""));
                rVar.g(rVar.f17207y, 1);
                rVar.f17207y = null;
                TextInputLayout textInputLayout = rVar.f17190h;
                textInputLayout.p();
                textInputLayout.v();
            }
            rVar.f17206x = z10;
        }
    }

    public void setHelperTextTextAppearance(int i10) {
        r rVar = this.f3908q;
        rVar.f17208z = i10;
        t1 t1Var = rVar.f17207y;
        if (t1Var != null) {
            a0.d(t1Var, i10);
        }
    }

    public void setHint(int i10) {
        setHint(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setHintAnimationEnabled(boolean z10) {
        this.B0 = z10;
    }

    public void setHintEnabled(boolean z10) {
        if (z10 != this.H) {
            this.H = z10;
            if (!z10) {
                this.J = false;
                if (!TextUtils.isEmpty(this.I) && TextUtils.isEmpty(this.f3896k.getHint())) {
                    this.f3896k.setHint(this.I);
                }
                setHintInternal((CharSequence) null);
            } else {
                CharSequence hint = this.f3896k.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.I)) {
                        setHint(hint);
                    }
                    this.f3896k.setHint((CharSequence) null);
                }
                this.J = true;
            }
            if (this.f3896k != null) {
                r();
            }
        }
    }

    public void setHintTextAppearance(int i10) {
        d dVar = this.f3927z0;
        dVar.k(i10);
        this.f3905o0 = dVar.f10747o;
        if (this.f3896k != null) {
            s(false, false);
            r();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f3905o0 != colorStateList) {
            if (this.f3903n0 == null) {
                d dVar = this.f3927z0;
                if (dVar.f10747o != colorStateList) {
                    dVar.f10747o = colorStateList;
                    dVar.i(false);
                }
            }
            this.f3905o0 = colorStateList;
            if (this.f3896k != null) {
                s(false, false);
            }
        }
    }

    public void setLengthCounter(y yVar) {
        this.f3916u = yVar;
    }

    public void setMaxEms(int i10) {
        this.f3902n = i10;
        EditText editText = this.f3896k;
        if (editText != null && i10 != -1) {
            editText.setMaxEms(i10);
        }
    }

    public void setMaxWidth(int i10) {
        this.f3906p = i10;
        EditText editText = this.f3896k;
        if (editText != null && i10 != -1) {
            editText.setMaxWidth(i10);
        }
    }

    public void setMaxWidthResource(int i10) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    public void setMinEms(int i10) {
        this.f3900m = i10;
        EditText editText = this.f3896k;
        if (editText != null && i10 != -1) {
            editText.setMinEms(i10);
        }
    }

    public void setMinWidth(int i10) {
        this.f3904o = i10;
        EditText editText = this.f3896k;
        if (editText != null && i10 != -1) {
            editText.setMinWidth(i10);
        }
    }

    public void setMinWidthResource(int i10) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i10) {
        y8.n nVar = this.f3894j;
        nVar.f17161n.setContentDescription(i10 != 0 ? nVar.getResources().getText(i10) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i10) {
        y8.n nVar = this.f3894j;
        nVar.f17161n.setImageDrawable(i10 != 0 ? h.a.a(nVar.getContext(), i10) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z10) {
        y8.n nVar = this.f3894j;
        if (z10 && nVar.f17163p != 1) {
            nVar.f(1);
        } else if (!z10) {
            nVar.f(0);
        } else {
            nVar.getClass();
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        y8.n nVar = this.f3894j;
        nVar.f17165r = colorStateList;
        y8.p.a(nVar.f17155h, nVar.f17161n, colorStateList, nVar.f17166s);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        y8.n nVar = this.f3894j;
        nVar.f17166s = mode;
        y8.p.a(nVar.f17155h, nVar.f17161n, nVar.f17165r, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        Editable editable = null;
        if (this.A == null) {
            t1 t1Var = new t1(getContext(), (AttributeSet) null);
            this.A = t1Var;
            t1Var.setId(R.id.textinput_placeholder);
            i0.s(this.A, 2);
            h d10 = d();
            this.D = d10;
            d10.f2589i = 67;
            this.E = d();
            setPlaceholderTextAppearance(this.C);
            setPlaceholderTextColor(this.B);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f3926z) {
                setPlaceholderTextEnabled(true);
            }
            this.f3924y = charSequence;
        }
        EditText editText = this.f3896k;
        if (editText != null) {
            editable = editText.getText();
        }
        t(editable);
    }

    public void setPlaceholderTextAppearance(int i10) {
        this.C = i10;
        t1 t1Var = this.A;
        if (t1Var != null) {
            a0.d(t1Var, i10);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            t1 t1Var = this.A;
            if (t1Var != null && colorStateList != null) {
                t1Var.setTextColor(colorStateList);
            }
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        CharSequence charSequence2;
        v vVar = this.f3892i;
        vVar.getClass();
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        vVar.f17224j = charSequence2;
        vVar.f17223i.setText(charSequence);
        vVar.d();
    }

    public void setPrefixTextAppearance(int i10) {
        a0.d(this.f3892i.f17223i, i10);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f3892i.f17223i.setTextColor(colorStateList);
    }

    public void setShapeAppearanceModel(n nVar) {
        i iVar = this.K;
        if (iVar != null && iVar.f14744h.f14723a != nVar) {
            this.Q = nVar;
            b();
        }
    }

    public void setStartIconCheckable(boolean z10) {
        this.f3892i.f17225k.setCheckable(z10);
    }

    public void setStartIconContentDescription(int i10) {
        setStartIconContentDescription(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setStartIconDrawable(int i10) {
        setStartIconDrawable(i10 != 0 ? h.a.a(getContext(), i10) : null);
    }

    public void setStartIconMinSize(int i10) {
        v vVar = this.f3892i;
        if (i10 < 0) {
            vVar.getClass();
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        } else if (i10 != vVar.f17228n) {
            vVar.f17228n = i10;
            CheckableImageButton checkableImageButton = vVar.f17225k;
            checkableImageButton.setMinimumWidth(i10);
            checkableImageButton.setMinimumHeight(i10);
        }
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        v vVar = this.f3892i;
        View.OnLongClickListener onLongClickListener = vVar.f17230p;
        CheckableImageButton checkableImageButton = vVar.f17225k;
        checkableImageButton.setOnClickListener(onClickListener);
        y8.p.e(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        v vVar = this.f3892i;
        vVar.f17230p = onLongClickListener;
        CheckableImageButton checkableImageButton = vVar.f17225k;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        y8.p.e(checkableImageButton, onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        v vVar = this.f3892i;
        vVar.f17229o = scaleType;
        vVar.f17225k.setScaleType(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        v vVar = this.f3892i;
        if (vVar.f17226l != colorStateList) {
            vVar.f17226l = colorStateList;
            y8.p.a(vVar.f17222h, vVar.f17225k, colorStateList, vVar.f17227m);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        v vVar = this.f3892i;
        if (vVar.f17227m != mode) {
            vVar.f17227m = mode;
            y8.p.a(vVar.f17222h, vVar.f17225k, vVar.f17226l, mode);
        }
    }

    public void setStartIconVisible(boolean z10) {
        this.f3892i.b(z10);
    }

    public void setSuffixText(CharSequence charSequence) {
        CharSequence charSequence2;
        y8.n nVar = this.f3894j;
        nVar.getClass();
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        nVar.f17170w = charSequence2;
        nVar.f17171x.setText(charSequence);
        nVar.m();
    }

    public void setSuffixTextAppearance(int i10) {
        a0.d(this.f3894j.f17171x, i10);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f3894j.f17171x.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(x xVar) {
        EditText editText = this.f3896k;
        if (editText != null) {
            c1.p(editText, xVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f3889g0) {
            this.f3889g0 = typeface;
            d dVar = this.f3927z0;
            boolean m10 = dVar.m(typeface);
            boolean o10 = dVar.o(typeface);
            if (m10 || o10) {
                dVar.i(false);
            }
            r rVar = this.f3908q;
            if (typeface != rVar.B) {
                rVar.B = typeface;
                t1 t1Var = rVar.f17200r;
                if (t1Var != null) {
                    t1Var.setTypeface(typeface);
                }
                t1 t1Var2 = rVar.f17207y;
                if (t1Var2 != null) {
                    t1Var2.setTypeface(typeface);
                }
            }
            t1 t1Var3 = this.f3918v;
            if (t1Var3 != null) {
                t1Var3.setTypeface(typeface);
            }
        }
    }

    public final void t(Editable editable) {
        int i10;
        ((j3) this.f3916u).getClass();
        if (editable != null) {
            i10 = editable.length();
        } else {
            i10 = 0;
        }
        FrameLayout frameLayout = this.f3890h;
        if (i10 != 0 || this.f3925y0) {
            t1 t1Var = this.A;
            if (t1Var != null && this.f3926z) {
                t1Var.setText((CharSequence) null);
                b4.x.a(frameLayout, this.E);
                this.A.setVisibility(4);
            }
        } else if (this.A != null && this.f3926z && !TextUtils.isEmpty(this.f3924y)) {
            this.A.setText(this.f3924y);
            b4.x.a(frameLayout, this.D);
            this.A.setVisibility(0);
            this.A.bringToFront();
            announceForAccessibility(this.f3924y);
        }
    }

    public final void u(boolean z10, boolean z11) {
        int defaultColor = this.f3913s0.getDefaultColor();
        int colorForState = this.f3913s0.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.f3913s0.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z10) {
            this.f3884b0 = colorForState2;
        } else if (z11) {
            this.f3884b0 = colorForState;
        } else {
            this.f3884b0 = defaultColor;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0121  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void v() {
        /*
            r7 = this;
            t8.i r0 = r7.K
            if (r0 == 0) goto L_0x016f
            int r0 = r7.T
            if (r0 != 0) goto L_0x000a
            goto L_0x016f
        L_0x000a:
            boolean r0 = r7.isFocused()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x001f
            android.widget.EditText r0 = r7.f3896k
            if (r0 == 0) goto L_0x001d
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r0 = 0
            goto L_0x0020
        L_0x001f:
            r0 = 1
        L_0x0020:
            boolean r3 = r7.isHovered()
            if (r3 != 0) goto L_0x0033
            android.widget.EditText r3 = r7.f3896k
            if (r3 == 0) goto L_0x0031
            boolean r3 = r3.isHovered()
            if (r3 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r3 = 0
            goto L_0x0034
        L_0x0033:
            r3 = 1
        L_0x0034:
            boolean r4 = r7.l()
            if (r4 != 0) goto L_0x0042
            androidx.appcompat.widget.t1 r4 = r7.f3918v
            if (r4 == 0) goto L_0x0043
            boolean r4 = r7.f3914t
            if (r4 == 0) goto L_0x0043
        L_0x0042:
            r1 = 1
        L_0x0043:
            boolean r4 = r7.isEnabled()
            if (r4 != 0) goto L_0x004c
            int r4 = r7.f3923x0
            goto L_0x007d
        L_0x004c:
            boolean r4 = r7.l()
            if (r4 == 0) goto L_0x005c
            android.content.res.ColorStateList r4 = r7.f3913s0
            if (r4 == 0) goto L_0x0057
            goto L_0x0068
        L_0x0057:
            int r4 = r7.getErrorCurrentTextColors()
            goto L_0x007d
        L_0x005c:
            boolean r4 = r7.f3914t
            if (r4 == 0) goto L_0x0071
            androidx.appcompat.widget.t1 r4 = r7.f3918v
            if (r4 == 0) goto L_0x0071
            android.content.res.ColorStateList r5 = r7.f3913s0
            if (r5 == 0) goto L_0x006c
        L_0x0068:
            r7.u(r0, r3)
            goto L_0x007f
        L_0x006c:
            int r4 = r4.getCurrentTextColor()
            goto L_0x007d
        L_0x0071:
            if (r0 == 0) goto L_0x0076
            int r4 = r7.f3911r0
            goto L_0x007d
        L_0x0076:
            if (r3 == 0) goto L_0x007b
            int r4 = r7.f3909q0
            goto L_0x007d
        L_0x007b:
            int r4 = r7.f3907p0
        L_0x007d:
            r7.f3884b0 = r4
        L_0x007f:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 29
            if (r4 < r5) goto L_0x00ca
            android.content.Context r4 = r7.getContext()
            r5 = 2130968839(0x7f040107, float:1.7546343E38)
            android.util.TypedValue r5 = q8.c.a(r4, r5)
            if (r5 != 0) goto L_0x0093
            goto L_0x00a5
        L_0x0093:
            int r6 = r5.resourceId
            if (r6 == 0) goto L_0x009c
            android.content.res.ColorStateList r4 = c0.g.c(r4, r6)
            goto L_0x00a6
        L_0x009c:
            int r4 = r5.data
            if (r4 == 0) goto L_0x00a5
            android.content.res.ColorStateList r4 = android.content.res.ColorStateList.valueOf(r4)
            goto L_0x00a6
        L_0x00a5:
            r4 = 0
        L_0x00a6:
            android.widget.EditText r5 = r7.f3896k
            if (r5 == 0) goto L_0x00ca
            android.graphics.drawable.Drawable r5 = r5.getTextCursorDrawable()
            if (r5 == 0) goto L_0x00ca
            if (r4 != 0) goto L_0x00b3
            goto L_0x00ca
        L_0x00b3:
            android.widget.EditText r5 = r7.f3896k
            android.graphics.drawable.Drawable r5 = r5.getTextCursorDrawable()
            if (r1 == 0) goto L_0x00c7
            android.content.res.ColorStateList r1 = r7.f3913s0
            if (r1 == 0) goto L_0x00c0
            goto L_0x00c6
        L_0x00c0:
            int r1 = r7.f3884b0
            android.content.res.ColorStateList r1 = android.content.res.ColorStateList.valueOf(r1)
        L_0x00c6:
            r4 = r1
        L_0x00c7:
            f0.b.h(r5, r4)
        L_0x00ca:
            y8.n r1 = r7.f3894j
            r1.k()
            com.google.android.material.internal.CheckableImageButton r4 = r1.f17157j
            android.content.res.ColorStateList r5 = r1.f17158k
            com.google.android.material.textfield.TextInputLayout r6 = r1.f17155h
            y8.p.c(r6, r4, r5)
            android.content.res.ColorStateList r4 = r1.f17165r
            com.google.android.material.internal.CheckableImageButton r5 = r1.f17161n
            y8.p.c(r6, r5, r4)
            y8.o r4 = r1.b()
            boolean r4 = r4 instanceof y8.k
            if (r4 == 0) goto L_0x0111
            boolean r4 = r6.l()
            if (r4 == 0) goto L_0x010a
            android.graphics.drawable.Drawable r4 = r5.getDrawable()
            if (r4 == 0) goto L_0x010a
            android.graphics.drawable.Drawable r1 = r5.getDrawable()
            android.graphics.drawable.Drawable r1 = f0.d.g(r1)
            android.graphics.drawable.Drawable r1 = r1.mutate()
            int r4 = r6.getErrorCurrentTextColors()
            f0.b.g(r1, r4)
            r5.setImageDrawable(r1)
            goto L_0x0111
        L_0x010a:
            android.content.res.ColorStateList r4 = r1.f17165r
            android.graphics.PorterDuff$Mode r1 = r1.f17166s
            y8.p.a(r6, r5, r4, r1)
        L_0x0111:
            y8.v r1 = r7.f3892i
            com.google.android.material.internal.CheckableImageButton r4 = r1.f17225k
            android.content.res.ColorStateList r5 = r1.f17226l
            com.google.android.material.textfield.TextInputLayout r1 = r1.f17222h
            y8.p.c(r1, r4, r5)
            int r1 = r7.T
            r4 = 2
            if (r1 != r4) goto L_0x014f
            int r1 = r7.V
            if (r0 == 0) goto L_0x012e
            boolean r4 = r7.isEnabled()
            if (r4 == 0) goto L_0x012e
            int r4 = r7.f3883a0
            goto L_0x0130
        L_0x012e:
            int r4 = r7.W
        L_0x0130:
            r7.V = r4
            if (r4 == r1) goto L_0x014f
            boolean r1 = r7.e()
            if (r1 == 0) goto L_0x014f
            boolean r1 = r7.f3925y0
            if (r1 != 0) goto L_0x014f
            boolean r1 = r7.e()
            if (r1 == 0) goto L_0x014c
            t8.i r1 = r7.K
            y8.h r1 = (y8.h) r1
            r4 = 0
            r1.o(r4, r4, r4, r4)
        L_0x014c:
            r7.i()
        L_0x014f:
            int r1 = r7.T
            if (r1 != r2) goto L_0x016c
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto L_0x015c
            int r0 = r7.f3917u0
            goto L_0x016a
        L_0x015c:
            if (r3 == 0) goto L_0x0163
            if (r0 != 0) goto L_0x0163
            int r0 = r7.f3921w0
            goto L_0x016a
        L_0x0163:
            if (r0 == 0) goto L_0x0168
            int r0 = r7.f3919v0
            goto L_0x016a
        L_0x0168:
            int r0 = r7.f3915t0
        L_0x016a:
            r7.f3885c0 = r0
        L_0x016c:
            r7.b()
        L_0x016f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.v():void");
    }

    public void setHint(CharSequence charSequence) {
        if (this.H) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f3892i.f17225k;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f3892i.a(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f3894j.f17161n.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f3894j.f17161n.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f3894j.h(drawable);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f3894j.f17161n;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        y8.n nVar = this.f3894j;
        CheckableImageButton checkableImageButton = nVar.f17161n;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = nVar.f17165r;
            PorterDuff.Mode mode = nVar.f17166s;
            TextInputLayout textInputLayout = nVar.f17155h;
            y8.p.a(textInputLayout, checkableImageButton, colorStateList, mode);
            y8.p.c(textInputLayout, checkableImageButton, nVar.f17165r);
        }
    }
}
