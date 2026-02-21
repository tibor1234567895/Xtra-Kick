package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import b4.e0;
import c0.c;
import c0.g;
import com.woxthebox.draglistview.R;
import j8.a;
import java.util.ArrayList;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;
import m0.j0;
import m0.l0;
import m0.m0;
import m0.o0;
import m0.q2;
import m8.d;
import m8.e;
import m8.r;
import x7.h;
import x7.i;
import x7.j;
import x7.k;
import x7.o;

public class CollapsingToolbarLayout extends FrameLayout {
    public long A;
    public final TimeInterpolator B;
    public final TimeInterpolator C;
    public int D = -1;
    public j E;
    public int F;
    public int G;
    public q2 H;
    public int I = 0;
    public boolean J;
    public int K = 0;
    public boolean L;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3604h = true;

    /* renamed from: i  reason: collision with root package name */
    public final int f3605i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f3606j;

    /* renamed from: k  reason: collision with root package name */
    public View f3607k;

    /* renamed from: l  reason: collision with root package name */
    public View f3608l;

    /* renamed from: m  reason: collision with root package name */
    public int f3609m;

    /* renamed from: n  reason: collision with root package name */
    public int f3610n;

    /* renamed from: o  reason: collision with root package name */
    public int f3611o;

    /* renamed from: p  reason: collision with root package name */
    public int f3612p;

    /* renamed from: q  reason: collision with root package name */
    public final Rect f3613q = new Rect();

    /* renamed from: r  reason: collision with root package name */
    public final d f3614r;

    /* renamed from: s  reason: collision with root package name */
    public final a f3615s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f3616t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f3617u;

    /* renamed from: v  reason: collision with root package name */
    public Drawable f3618v;

    /* renamed from: w  reason: collision with root package name */
    public Drawable f3619w;

    /* renamed from: x  reason: collision with root package name */
    public int f3620x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f3621y;

    /* renamed from: z  reason: collision with root package name */
    public ValueAnimator f3622z;

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        super(a9.a.a(context, attributeSet, R.attr.collapsingToolbarLayoutStyle, 2132018098), attributeSet, R.attr.collapsingToolbarLayoutStyle);
        int i10;
        ColorStateList a10;
        ColorStateList a11;
        TextUtils.TruncateAt truncateAt;
        Context context2 = getContext();
        d dVar = new d(this);
        this.f3614r = dVar;
        dVar.W = w7.a.f16157e;
        dVar.i(false);
        dVar.J = false;
        this.f3615s = new a(context2);
        TypedArray d10 = r.d(context2, attributeSet, v7.a.f15940i, R.attr.collapsingToolbarLayoutStyle, 2132018098, new int[0]);
        int i11 = d10.getInt(4, 8388691);
        if (dVar.f10737j != i11) {
            dVar.f10737j = i11;
            dVar.i(false);
        }
        dVar.l(d10.getInt(0, 8388627));
        int dimensionPixelSize = d10.getDimensionPixelSize(5, 0);
        this.f3612p = dimensionPixelSize;
        this.f3611o = dimensionPixelSize;
        this.f3610n = dimensionPixelSize;
        this.f3609m = dimensionPixelSize;
        if (d10.hasValue(8)) {
            this.f3609m = d10.getDimensionPixelSize(8, 0);
        }
        if (d10.hasValue(7)) {
            this.f3611o = d10.getDimensionPixelSize(7, 0);
        }
        if (d10.hasValue(9)) {
            this.f3610n = d10.getDimensionPixelSize(9, 0);
        }
        if (d10.hasValue(6)) {
            this.f3612p = d10.getDimensionPixelSize(6, 0);
        }
        this.f3616t = d10.getBoolean(20, true);
        setTitle(d10.getText(18));
        dVar.n(2132017735);
        dVar.k(2132017709);
        if (d10.hasValue(10)) {
            dVar.n(d10.getResourceId(10, 0));
        }
        if (d10.hasValue(1)) {
            dVar.k(d10.getResourceId(1, 0));
        }
        if (d10.hasValue(22)) {
            int i12 = d10.getInt(22, -1);
            if (i12 == 0) {
                truncateAt = TextUtils.TruncateAt.START;
            } else if (i12 == 1) {
                truncateAt = TextUtils.TruncateAt.MIDDLE;
            } else if (i12 != 3) {
                truncateAt = TextUtils.TruncateAt.END;
            } else {
                truncateAt = TextUtils.TruncateAt.MARQUEE;
            }
            setTitleEllipsize(truncateAt);
        }
        if (d10.hasValue(11) && dVar.f10745n != (a11 = q8.d.a(context2, d10, 11))) {
            dVar.f10745n = a11;
            dVar.i(false);
        }
        if (d10.hasValue(2) && dVar.f10747o != (a10 = q8.d.a(context2, d10, 2))) {
            dVar.f10747o = a10;
            dVar.i(false);
        }
        this.D = d10.getDimensionPixelSize(16, -1);
        if (d10.hasValue(14) && (i10 = d10.getInt(14, 1)) != dVar.f10746n0) {
            dVar.f10746n0 = i10;
            Bitmap bitmap = dVar.K;
            if (bitmap != null) {
                bitmap.recycle();
                dVar.K = null;
            }
            dVar.i(false);
        }
        if (d10.hasValue(21)) {
            dVar.V = AnimationUtils.loadInterpolator(context2, d10.getResourceId(21, 0));
            dVar.i(false);
        }
        this.A = (long) d10.getInt(15, 600);
        this.B = n8.a.d(context2, R.attr.motionEasingStandardInterpolator, w7.a.f16155c);
        this.C = n8.a.d(context2, R.attr.motionEasingStandardInterpolator, w7.a.f16156d);
        setContentScrim(d10.getDrawable(3));
        setStatusBarScrim(d10.getDrawable(17));
        setTitleCollapseMode(d10.getInt(19, 0));
        this.f3605i = d10.getResourceId(23, -1);
        this.J = d10.getBoolean(13, false);
        this.L = d10.getBoolean(12, false);
        d10.recycle();
        setWillNotDraw(false);
        e0 e0Var = new e0(18, this);
        WeakHashMap weakHashMap = c1.f10054a;
        o0.u(this, e0Var);
    }

    public static o b(View view) {
        o oVar = (o) view.getTag(R.id.view_offset_helper);
        if (oVar != null) {
            return oVar;
        }
        o oVar2 = new o(view);
        view.setTag(R.id.view_offset_helper, oVar2);
        return oVar2;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r6 = this;
            boolean r0 = r6.f3604h
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r6.f3606j = r0
            r6.f3607k = r0
            r1 = -1
            int r2 = r6.f3605i
            if (r2 == r1) goto L_0x002f
            android.view.View r1 = r6.findViewById(r2)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r6.f3606j = r1
            if (r1 == 0) goto L_0x002f
            android.view.ViewParent r2 = r1.getParent()
        L_0x001d:
            if (r2 == r6) goto L_0x002d
            if (r2 == 0) goto L_0x002d
            boolean r3 = r2 instanceof android.view.View
            if (r3 == 0) goto L_0x0028
            r1 = r2
            android.view.View r1 = (android.view.View) r1
        L_0x0028:
            android.view.ViewParent r2 = r2.getParent()
            goto L_0x001d
        L_0x002d:
            r6.f3607k = r1
        L_0x002f:
            android.view.ViewGroup r1 = r6.f3606j
            r2 = 0
            if (r1 != 0) goto L_0x0056
            int r1 = r6.getChildCount()
            r3 = 0
        L_0x0039:
            if (r3 >= r1) goto L_0x0054
            android.view.View r4 = r6.getChildAt(r3)
            boolean r5 = r4 instanceof androidx.appcompat.widget.Toolbar
            if (r5 != 0) goto L_0x004a
            boolean r5 = r4 instanceof android.widget.Toolbar
            if (r5 == 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r5 = 0
            goto L_0x004b
        L_0x004a:
            r5 = 1
        L_0x004b:
            if (r5 == 0) goto L_0x0051
            r0 = r4
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x0054
        L_0x0051:
            int r3 = r3 + 1
            goto L_0x0039
        L_0x0054:
            r6.f3606j = r0
        L_0x0056:
            r6.c()
            r6.f3604h = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.a():void");
    }

    public final void c() {
        View view;
        if (!this.f3616t && (view = this.f3608l) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f3608l);
            }
        }
        if (this.f3616t && this.f3606j != null) {
            if (this.f3608l == null) {
                this.f3608l = new View(getContext());
            }
            if (this.f3608l.getParent() == null) {
                this.f3606j.addView(this.f3608l, -1, -1);
            }
        }
    }

    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof i;
    }

    public final void d() {
        if (this.f3618v != null || this.f3619w != null) {
            setScrimsShown(getHeight() + this.F < getScrimVisibleHeightTrigger());
        }
    }

    public final void draw(Canvas canvas) {
        int i10;
        Drawable drawable;
        super.draw(canvas);
        a();
        if (this.f3606j == null && (drawable = this.f3618v) != null && this.f3620x > 0) {
            drawable.mutate().setAlpha(this.f3620x);
            this.f3618v.draw(canvas);
        }
        if (this.f3616t && this.f3617u) {
            ViewGroup viewGroup = this.f3606j;
            d dVar = this.f3614r;
            if (!(viewGroup == null || this.f3618v == null || this.f3620x <= 0)) {
                boolean z10 = true;
                if (this.G != 1) {
                    z10 = false;
                }
                if (z10 && dVar.f10721b < dVar.f10727e) {
                    int save = canvas.save();
                    canvas.clipRect(this.f3618v.getBounds(), Region.Op.DIFFERENCE);
                    dVar.d(canvas);
                    canvas.restoreToCount(save);
                }
            }
            dVar.d(canvas);
        }
        if (this.f3619w != null && this.f3620x > 0) {
            q2 q2Var = this.H;
            if (q2Var != null) {
                i10 = q2Var.e();
            } else {
                i10 = 0;
            }
            if (i10 > 0) {
                this.f3619w.setBounds(0, -this.F, getWidth(), i10 - this.F);
                this.f3619w.mutate().setAlpha(this.f3620x);
                this.f3619w.draw(canvas);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        r3 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean drawChild(android.graphics.Canvas r7, android.view.View r8, long r9) {
        /*
            r6 = this;
            android.graphics.drawable.Drawable r0 = r6.f3618v
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x004d
            int r3 = r6.f3620x
            if (r3 <= 0) goto L_0x004d
            android.view.View r3 = r6.f3607k
            if (r3 == 0) goto L_0x0014
            if (r3 != r6) goto L_0x0011
            goto L_0x0014
        L_0x0011:
            if (r8 != r3) goto L_0x001a
            goto L_0x0018
        L_0x0014:
            android.view.ViewGroup r3 = r6.f3606j
            if (r8 != r3) goto L_0x001a
        L_0x0018:
            r3 = 1
            goto L_0x001b
        L_0x001a:
            r3 = 0
        L_0x001b:
            if (r3 == 0) goto L_0x004d
            int r3 = r6.getWidth()
            int r4 = r6.getHeight()
            int r5 = r6.G
            if (r5 != r2) goto L_0x002b
            r5 = 1
            goto L_0x002c
        L_0x002b:
            r5 = 0
        L_0x002c:
            if (r5 == 0) goto L_0x0038
            if (r8 == 0) goto L_0x0038
            boolean r5 = r6.f3616t
            if (r5 == 0) goto L_0x0038
            int r4 = r8.getBottom()
        L_0x0038:
            r0.setBounds(r1, r1, r3, r4)
            android.graphics.drawable.Drawable r0 = r6.f3618v
            android.graphics.drawable.Drawable r0 = r0.mutate()
            int r3 = r6.f3620x
            r0.setAlpha(r3)
            android.graphics.drawable.Drawable r0 = r6.f3618v
            r0.draw(r7)
            r0 = 1
            goto L_0x004e
        L_0x004d:
            r0 = 0
        L_0x004e:
            boolean r7 = super.drawChild(r7, r8, r9)
            if (r7 != 0) goto L_0x0056
            if (r0 == 0) goto L_0x0057
        L_0x0056:
            r1 = 1
        L_0x0057:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f3619w;
        boolean z10 = false;
        if (drawable != null && drawable.isStateful()) {
            z10 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f3618v;
        if (drawable2 != null && drawable2.isStateful()) {
            z10 |= drawable2.setState(drawableState);
        }
        d dVar = this.f3614r;
        if (dVar != null) {
            z10 |= dVar.r(drawableState);
        }
        if (z10) {
            invalidate();
        }
    }

    public final void e(int i10, int i11, int i12, int i13, boolean z10) {
        View view;
        boolean z11;
        boolean z12;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z13;
        int i19;
        int i20;
        boolean z14 = z10;
        if (this.f3616t && (view = this.f3608l) != null) {
            WeakHashMap weakHashMap = c1.f10054a;
            boolean z15 = false;
            if (!l0.b(view) || this.f3608l.getVisibility() != 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            this.f3617u = z11;
            if (z11 || z14) {
                if (j0.d(this) == 1) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                View view2 = this.f3607k;
                if (view2 == null) {
                    view2 = this.f3606j;
                }
                int height = ((getHeight() - b(view2).f16744b) - view2.getHeight()) - ((i) view2.getLayoutParams()).bottomMargin;
                View view3 = this.f3608l;
                Rect rect = this.f3613q;
                e.a(this, view3, rect);
                ViewGroup viewGroup = this.f3606j;
                if (viewGroup instanceof Toolbar) {
                    Toolbar toolbar = (Toolbar) viewGroup;
                    i16 = toolbar.getTitleMarginStart();
                    i15 = toolbar.getTitleMarginEnd();
                    i14 = toolbar.getTitleMarginTop();
                    i17 = toolbar.getTitleMarginBottom();
                } else if (Build.VERSION.SDK_INT < 24 || !(viewGroup instanceof android.widget.Toolbar)) {
                    i17 = 0;
                    i16 = 0;
                    i15 = 0;
                    i14 = 0;
                } else {
                    android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
                    i16 = toolbar2.getTitleMarginStart();
                    i15 = toolbar2.getTitleMarginEnd();
                    i14 = toolbar2.getTitleMarginTop();
                    i17 = toolbar2.getTitleMarginBottom();
                }
                int i21 = rect.left;
                if (z12) {
                    i18 = i15;
                } else {
                    i18 = i16;
                }
                int i22 = i21 + i18;
                int i23 = rect.top + height + i14;
                int i24 = rect.right;
                if (!z12) {
                    i16 = i15;
                }
                int i25 = i24 - i16;
                int i26 = (rect.bottom + height) - i17;
                d dVar = this.f3614r;
                Rect rect2 = dVar.f10733h;
                if (rect2.left == i22 && rect2.top == i23 && rect2.right == i25 && rect2.bottom == i26) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (!z13) {
                    rect2.set(i22, i23, i25, i26);
                    dVar.S = true;
                }
                if (z12) {
                    i19 = this.f3611o;
                } else {
                    i19 = this.f3609m;
                }
                int i27 = rect.top + this.f3610n;
                int i28 = i12 - i10;
                if (z12) {
                    i20 = this.f3609m;
                } else {
                    i20 = this.f3611o;
                }
                int i29 = i28 - i20;
                int i30 = (i13 - i11) - this.f3612p;
                Rect rect3 = dVar.f10731g;
                if (rect3.left == i19 && rect3.top == i27 && rect3.right == i29 && rect3.bottom == i30) {
                    z15 = true;
                }
                if (!z15) {
                    rect3.set(i19, i27, i29, i30);
                    dVar.S = true;
                }
                dVar.i(z14);
            }
        }
    }

    public final void f() {
        CharSequence charSequence;
        if (this.f3606j != null && this.f3616t && TextUtils.isEmpty(this.f3614r.G)) {
            ViewGroup viewGroup = this.f3606j;
            if (viewGroup instanceof Toolbar) {
                charSequence = ((Toolbar) viewGroup).getTitle();
            } else if (viewGroup instanceof android.widget.Toolbar) {
                charSequence = ((android.widget.Toolbar) viewGroup).getTitle();
            } else {
                charSequence = null;
            }
            setTitle(charSequence);
        }
    }

    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new i();
    }

    public int getCollapsedTitleGravity() {
        return this.f3614r.f10739k;
    }

    public float getCollapsedTitleTextSize() {
        return this.f3614r.f10743m;
    }

    public Typeface getCollapsedTitleTypeface() {
        Typeface typeface = this.f3614r.f10758w;
        if (typeface != null) {
            return typeface;
        }
        return Typeface.DEFAULT;
    }

    public Drawable getContentScrim() {
        return this.f3618v;
    }

    public int getExpandedTitleGravity() {
        return this.f3614r.f10737j;
    }

    public int getExpandedTitleMarginBottom() {
        return this.f3612p;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f3611o;
    }

    public int getExpandedTitleMarginStart() {
        return this.f3609m;
    }

    public int getExpandedTitleMarginTop() {
        return this.f3610n;
    }

    public float getExpandedTitleTextSize() {
        return this.f3614r.f10741l;
    }

    public Typeface getExpandedTitleTypeface() {
        Typeface typeface = this.f3614r.f10761z;
        if (typeface != null) {
            return typeface;
        }
        return Typeface.DEFAULT;
    }

    public int getHyphenationFrequency() {
        return this.f3614r.f10752q0;
    }

    public int getLineCount() {
        StaticLayout staticLayout = this.f3614r.f10736i0;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    public float getLineSpacingAdd() {
        return this.f3614r.f10736i0.getSpacingAdd();
    }

    public float getLineSpacingMultiplier() {
        return this.f3614r.f10736i0.getSpacingMultiplier();
    }

    public int getMaxLines() {
        return this.f3614r.f10746n0;
    }

    public int getScrimAlpha() {
        return this.f3620x;
    }

    public long getScrimAnimationDuration() {
        return this.A;
    }

    public int getScrimVisibleHeightTrigger() {
        int i10;
        int i11 = this.D;
        if (i11 >= 0) {
            return i11 + this.I + this.K;
        }
        q2 q2Var = this.H;
        if (q2Var != null) {
            i10 = q2Var.e();
        } else {
            i10 = 0;
        }
        WeakHashMap weakHashMap = c1.f10054a;
        int d10 = i0.d(this);
        if (d10 > 0) {
            return Math.min((d10 * 2) + i10, getHeight());
        }
        return getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.f3619w;
    }

    public CharSequence getTitle() {
        if (this.f3616t) {
            return this.f3614r.G;
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.G;
    }

    public TimeInterpolator getTitlePositionInterpolator() {
        return this.f3614r.V;
    }

    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.f3614r.F;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            boolean z10 = true;
            if (this.G != 1) {
                z10 = false;
            }
            if (z10) {
                appBarLayout.setLiftOnScroll(false);
            }
            WeakHashMap weakHashMap = c1.f10054a;
            setFitsSystemWindows(i0.b(appBarLayout));
            if (this.E == null) {
                this.E = new j(this);
            }
            j jVar = this.E;
            if (appBarLayout.f3586o == null) {
                appBarLayout.f3586o = new ArrayList();
            }
            if (jVar != null && !appBarLayout.f3586o.contains(jVar)) {
                appBarLayout.f3586o.add(jVar);
            }
            m0.c(this);
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f3614r.h(configuration);
    }

    public final void onDetachedFromWindow() {
        ArrayList arrayList;
        ViewParent parent = getParent();
        j jVar = this.E;
        if (!(jVar == null || !(parent instanceof AppBarLayout) || (arrayList = ((AppBarLayout) parent).f3586o) == null)) {
            arrayList.remove(jVar);
        }
        super.onDetachedFromWindow();
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        q2 q2Var = this.H;
        if (q2Var != null) {
            int e10 = q2Var.e();
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = getChildAt(i14);
                WeakHashMap weakHashMap = c1.f10054a;
                if (!i0.b(childAt) && childAt.getTop() < e10) {
                    c1.k(childAt, e10);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i15 = 0; i15 < childCount2; i15++) {
            o b10 = b(getChildAt(i15));
            View view = b10.f16743a;
            b10.f16744b = view.getTop();
            b10.f16745c = view.getLeft();
        }
        e(i10, i11, i12, i13, false);
        f();
        d();
        int childCount3 = getChildCount();
        for (int i16 = 0; i16 < childCount3; i16++) {
            b(getChildAt(i16)).a();
        }
    }

    public final void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        a();
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        q2 q2Var = this.H;
        if (q2Var != null) {
            i12 = q2Var.e();
        } else {
            i12 = 0;
        }
        if ((mode == 0 || this.J) && i12 > 0) {
            this.I = i12;
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + i12, 1073741824));
        }
        if (this.L) {
            d dVar = this.f3614r;
            if (dVar.f10746n0 > 1) {
                f();
                e(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
                int i15 = dVar.f10749p;
                if (i15 > 1) {
                    TextPaint textPaint = dVar.U;
                    textPaint.setTextSize(dVar.f10741l);
                    textPaint.setTypeface(dVar.f10761z);
                    textPaint.setLetterSpacing(dVar.f10732g0);
                    int i16 = i15 - 1;
                    this.K = i16 * Math.round(textPaint.descent() + (-textPaint.ascent()));
                    super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.K, 1073741824));
                }
            }
        }
        ViewGroup viewGroup = this.f3606j;
        if (viewGroup != null) {
            View view = this.f3607k;
            if (view == null || view == this) {
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i14 = viewGroup.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                } else {
                    i14 = viewGroup.getMeasuredHeight();
                }
                i13 = i14;
            } else {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    i13 = view.getMeasuredHeight() + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                } else {
                    i13 = view.getMeasuredHeight();
                }
            }
            setMinimumHeight(i13);
        }
    }

    public final void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        Drawable drawable = this.f3618v;
        if (drawable != null) {
            ViewGroup viewGroup = this.f3606j;
            boolean z10 = true;
            if (this.G != 1) {
                z10 = false;
            }
            if (z10 && viewGroup != null && this.f3616t) {
                i11 = viewGroup.getBottom();
            }
            drawable.setBounds(0, 0, i10, i11);
        }
    }

    public void setCollapsedTitleGravity(int i10) {
        this.f3614r.l(i10);
    }

    public void setCollapsedTitleTextAppearance(int i10) {
        this.f3614r.k(i10);
    }

    public void setCollapsedTitleTextColor(int i10) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setCollapsedTitleTextSize(float f10) {
        d dVar = this.f3614r;
        if (dVar.f10743m != f10) {
            dVar.f10743m = f10;
            dVar.i(false);
        }
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        d dVar = this.f3614r;
        if (dVar.m(typeface)) {
            dVar.i(false);
        }
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.f3618v;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f3618v = drawable3;
            if (drawable3 != null) {
                int width = getWidth();
                int height = getHeight();
                ViewGroup viewGroup = this.f3606j;
                boolean z10 = true;
                if (this.G != 1) {
                    z10 = false;
                }
                if (z10 && viewGroup != null && this.f3616t) {
                    height = viewGroup.getBottom();
                }
                drawable3.setBounds(0, 0, width, height);
                this.f3618v.setCallback(this);
                this.f3618v.setAlpha(this.f3620x);
            }
            WeakHashMap weakHashMap = c1.f10054a;
            i0.k(this);
        }
    }

    public void setContentScrimColor(int i10) {
        setContentScrim(new ColorDrawable(i10));
    }

    public void setContentScrimResource(int i10) {
        Context context = getContext();
        Object obj = g.f2717a;
        setContentScrim(c.b(context, i10));
    }

    public void setExpandedTitleColor(int i10) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setExpandedTitleGravity(int i10) {
        d dVar = this.f3614r;
        if (dVar.f10737j != i10) {
            dVar.f10737j = i10;
            dVar.i(false);
        }
    }

    public void setExpandedTitleMarginBottom(int i10) {
        this.f3612p = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i10) {
        this.f3611o = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i10) {
        this.f3609m = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i10) {
        this.f3610n = i10;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i10) {
        this.f3614r.n(i10);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        d dVar = this.f3614r;
        if (dVar.f10745n != colorStateList) {
            dVar.f10745n = colorStateList;
            dVar.i(false);
        }
    }

    public void setExpandedTitleTextSize(float f10) {
        d dVar = this.f3614r;
        if (dVar.f10741l != f10) {
            dVar.f10741l = f10;
            dVar.i(false);
        }
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        d dVar = this.f3614r;
        if (dVar.o(typeface)) {
            dVar.i(false);
        }
    }

    public void setExtraMultilineHeightEnabled(boolean z10) {
        this.L = z10;
    }

    public void setForceApplySystemWindowInsetTop(boolean z10) {
        this.J = z10;
    }

    public void setHyphenationFrequency(int i10) {
        this.f3614r.f10752q0 = i10;
    }

    public void setLineSpacingAdd(float f10) {
        this.f3614r.f10748o0 = f10;
    }

    public void setLineSpacingMultiplier(float f10) {
        this.f3614r.f10750p0 = f10;
    }

    public void setMaxLines(int i10) {
        d dVar = this.f3614r;
        if (i10 != dVar.f10746n0) {
            dVar.f10746n0 = i10;
            Bitmap bitmap = dVar.K;
            if (bitmap != null) {
                bitmap.recycle();
                dVar.K = null;
            }
            dVar.i(false);
        }
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z10) {
        this.f3614r.J = z10;
    }

    public void setScrimAlpha(int i10) {
        ViewGroup viewGroup;
        if (i10 != this.f3620x) {
            if (!(this.f3618v == null || (viewGroup = this.f3606j) == null)) {
                WeakHashMap weakHashMap = c1.f10054a;
                i0.k(viewGroup);
            }
            this.f3620x = i10;
            WeakHashMap weakHashMap2 = c1.f10054a;
            i0.k(this);
        }
    }

    public void setScrimAnimationDuration(long j10) {
        this.A = j10;
    }

    public void setScrimVisibleHeightTrigger(int i10) {
        if (this.D != i10) {
            this.D = i10;
            d();
        }
    }

    public void setScrimsShown(boolean z10) {
        boolean z11;
        TimeInterpolator timeInterpolator;
        WeakHashMap weakHashMap = c1.f10054a;
        int i10 = 0;
        if (!l0.c(this) || isInEditMode()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (this.f3621y != z10) {
            int i11 = 255;
            if (z11) {
                if (!z10) {
                    i11 = 0;
                }
                a();
                ValueAnimator valueAnimator = this.f3622z;
                if (valueAnimator == null) {
                    ValueAnimator valueAnimator2 = new ValueAnimator();
                    this.f3622z = valueAnimator2;
                    if (i11 > this.f3620x) {
                        timeInterpolator = this.B;
                    } else {
                        timeInterpolator = this.C;
                    }
                    valueAnimator2.setInterpolator(timeInterpolator);
                    this.f3622z.addUpdateListener(new h(0, this));
                } else if (valueAnimator.isRunning()) {
                    this.f3622z.cancel();
                }
                this.f3622z.setDuration(this.A);
                this.f3622z.setIntValues(new int[]{this.f3620x, i11});
                this.f3622z.start();
            } else {
                if (z10) {
                    i10 = 255;
                }
                setScrimAlpha(i10);
            }
            this.f3621y = z10;
        }
    }

    public void setStaticLayoutBuilderConfigurer(k kVar) {
        d dVar = this.f3614r;
        if (kVar != null) {
            dVar.i(true);
        } else {
            dVar.getClass();
        }
    }

    public void setStatusBarScrim(Drawable drawable) {
        boolean z10;
        Drawable drawable2 = this.f3619w;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f3619w = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f3619w.setState(getDrawableState());
                }
                Drawable drawable4 = this.f3619w;
                WeakHashMap weakHashMap = c1.f10054a;
                f0.d.c(drawable4, j0.d(this));
                Drawable drawable5 = this.f3619w;
                if (getVisibility() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                drawable5.setVisible(z10, false);
                this.f3619w.setCallback(this);
                this.f3619w.setAlpha(this.f3620x);
            }
            WeakHashMap weakHashMap2 = c1.f10054a;
            i0.k(this);
        }
    }

    public void setStatusBarScrimColor(int i10) {
        setStatusBarScrim(new ColorDrawable(i10));
    }

    public void setStatusBarScrimResource(int i10) {
        Context context = getContext();
        Object obj = g.f2717a;
        setStatusBarScrim(c.b(context, i10));
    }

    public void setTitle(CharSequence charSequence) {
        d dVar = this.f3614r;
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
        setContentDescription(getTitle());
    }

    public void setTitleCollapseMode(int i10) {
        boolean z10;
        this.G = i10;
        boolean z11 = true;
        if (i10 == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f3614r.f10723c = z10;
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            if (this.G != 1) {
                z11 = false;
            }
            if (z11) {
                appBarLayout.setLiftOnScroll(false);
            }
        }
        if (z10 && this.f3618v == null) {
            float dimension = getResources().getDimension(R.dimen.design_appbar_elevation);
            a aVar = this.f3615s;
            setContentScrimColor(aVar.a(aVar.f8846d, dimension));
        }
    }

    public void setTitleEllipsize(TextUtils.TruncateAt truncateAt) {
        d dVar = this.f3614r;
        dVar.F = truncateAt;
        dVar.i(false);
    }

    public void setTitleEnabled(boolean z10) {
        if (z10 != this.f3616t) {
            this.f3616t = z10;
            setContentDescription(getTitle());
            c();
            requestLayout();
        }
    }

    public void setTitlePositionInterpolator(TimeInterpolator timeInterpolator) {
        d dVar = this.f3614r;
        dVar.V = timeInterpolator;
        dVar.i(false);
    }

    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f3619w;
        if (!(drawable == null || drawable.isVisible() == z10)) {
            this.f3619w.setVisible(z10, false);
        }
        Drawable drawable2 = this.f3618v;
        if (drawable2 != null && drawable2.isVisible() != z10) {
            this.f3618v.setVisible(z10, false);
        }
    }

    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3618v || drawable == this.f3619w;
    }

    /* renamed from: generateDefaultLayoutParams  reason: collision with other method in class */
    public final FrameLayout.LayoutParams m11generateDefaultLayoutParams() {
        return new i();
    }

    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new i(layoutParams);
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        d dVar = this.f3614r;
        if (dVar.f10747o != colorStateList) {
            dVar.f10747o = colorStateList;
            dVar.i(false);
        }
    }

    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new i(getContext(), attributeSet);
    }
}
