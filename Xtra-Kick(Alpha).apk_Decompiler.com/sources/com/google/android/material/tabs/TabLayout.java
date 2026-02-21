package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.gson.internal.bind.l;
import com.woxthebox.draglistview.R;
import f4.a;
import f4.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import l0.e;
import m0.c1;
import m0.i0;
import m0.j0;
import m0.l0;
import m0.o0;
import m8.r;
import m8.w;
import s.f;
import t8.i;
import x8.c;
import x8.d;
import x8.g;
import x8.h;
import x8.j;
import x8.m;

public class TabLayout extends HorizontalScrollView {

    /* renamed from: b0  reason: collision with root package name */
    public static final e f3860b0 = new e(16);
    public final int A;
    public int B = Integer.MAX_VALUE;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public int G;
    public final int H;
    public int I;
    public int J;
    public boolean K;
    public boolean L;
    public int M = -1;
    public int N;
    public boolean O;
    public c P;
    public final TimeInterpolator Q;
    public d R;
    public final ArrayList S = new ArrayList();
    public ValueAnimator T;
    public a U;
    public boolean V;
    public int W;

    /* renamed from: a0  reason: collision with root package name */
    public final f f3861a0 = new f(12, 1);

    /* renamed from: h  reason: collision with root package name */
    public int f3862h = -1;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList f3863i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public h f3864j;

    /* renamed from: k  reason: collision with root package name */
    public final g f3865k;

    /* renamed from: l  reason: collision with root package name */
    public final int f3866l;

    /* renamed from: m  reason: collision with root package name */
    public final int f3867m;

    /* renamed from: n  reason: collision with root package name */
    public final int f3868n;

    /* renamed from: o  reason: collision with root package name */
    public final int f3869o;

    /* renamed from: p  reason: collision with root package name */
    public final int f3870p;

    /* renamed from: q  reason: collision with root package name */
    public final int f3871q;

    /* renamed from: r  reason: collision with root package name */
    public final int f3872r = -1;

    /* renamed from: s  reason: collision with root package name */
    public ColorStateList f3873s;

    /* renamed from: t  reason: collision with root package name */
    public ColorStateList f3874t;

    /* renamed from: u  reason: collision with root package name */
    public ColorStateList f3875u;

    /* renamed from: v  reason: collision with root package name */
    public Drawable f3876v;

    /* renamed from: w  reason: collision with root package name */
    public int f3877w = 0;

    /* renamed from: x  reason: collision with root package name */
    public final PorterDuff.Mode f3878x;

    /* renamed from: y  reason: collision with root package name */
    public final float f3879y;

    /* renamed from: z  reason: collision with root package name */
    public final float f3880z;

    /* JADX INFO: finally extract failed */
    public TabLayout(Context context, AttributeSet attributeSet) {
        super(a9.a.a(context, attributeSet, R.attr.tabStyle, 2132018103), attributeSet, R.attr.tabStyle);
        int i10;
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        g gVar = new g(this, context2);
        this.f3865k = gVar;
        super.addView(gVar, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray d10 = r.d(context2, attributeSet, v7.a.G, R.attr.tabStyle, 2132018103, 24);
        if (getBackground() instanceof ColorDrawable) {
            i iVar = new i();
            iVar.k(ColorStateList.valueOf(((ColorDrawable) getBackground()).getColor()));
            iVar.i(context2);
            WeakHashMap weakHashMap = c1.f10054a;
            iVar.j(o0.i(this));
            i0.q(this, iVar);
        }
        setSelectedTabIndicator(q8.d.c(context2, d10, 5));
        setSelectedTabIndicatorColor(d10.getColor(8, 0));
        gVar.b(d10.getDimensionPixelSize(11, -1));
        setSelectedTabIndicatorGravity(d10.getInt(10, 0));
        setTabIndicatorAnimationMode(d10.getInt(7, 0));
        setTabIndicatorFullWidth(d10.getBoolean(9, true));
        int dimensionPixelSize = d10.getDimensionPixelSize(16, 0);
        this.f3869o = dimensionPixelSize;
        this.f3868n = dimensionPixelSize;
        this.f3867m = dimensionPixelSize;
        this.f3866l = dimensionPixelSize;
        this.f3866l = d10.getDimensionPixelSize(19, dimensionPixelSize);
        this.f3867m = d10.getDimensionPixelSize(20, dimensionPixelSize);
        this.f3868n = d10.getDimensionPixelSize(18, dimensionPixelSize);
        this.f3869o = d10.getDimensionPixelSize(17, dimensionPixelSize);
        if (q8.c.b(context2, R.attr.isMaterial3Theme, false)) {
            i10 = R.attr.textAppearanceTitleSmall;
        } else {
            i10 = R.attr.textAppearanceButton;
        }
        this.f3870p = i10;
        int resourceId = d10.getResourceId(24, 2132017745);
        this.f3871q = resourceId;
        int[] iArr = f.a.f5415y;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(resourceId, iArr);
        try {
            float dimensionPixelSize2 = (float) obtainStyledAttributes.getDimensionPixelSize(0, 0);
            this.f3879y = dimensionPixelSize2;
            this.f3873s = q8.d.a(context2, obtainStyledAttributes, 3);
            obtainStyledAttributes.recycle();
            if (d10.hasValue(22)) {
                this.f3872r = d10.getResourceId(22, resourceId);
            }
            int i11 = this.f3872r;
            if (i11 != -1) {
                TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(i11, iArr);
                try {
                    obtainStyledAttributes2.getDimensionPixelSize(0, (int) dimensionPixelSize2);
                    ColorStateList a10 = q8.d.a(context2, obtainStyledAttributes2, 3);
                    if (a10 != null) {
                        int defaultColor = this.f3873s.getDefaultColor();
                        int colorForState = a10.getColorForState(new int[]{16842913}, a10.getDefaultColor());
                        this.f3873s = new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{colorForState, defaultColor});
                    }
                } finally {
                    obtainStyledAttributes2.recycle();
                }
            }
            if (d10.hasValue(25)) {
                this.f3873s = q8.d.a(context2, d10, 25);
            }
            if (d10.hasValue(23)) {
                int color = d10.getColor(23, 0);
                int defaultColor2 = this.f3873s.getDefaultColor();
                this.f3873s = new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{color, defaultColor2});
            }
            this.f3874t = q8.d.a(context2, d10, 3);
            this.f3878x = w.d(d10.getInt(4, -1), (PorterDuff.Mode) null);
            this.f3875u = q8.d.a(context2, d10, 21);
            this.H = d10.getInt(6, 300);
            this.Q = n8.a.d(context2, R.attr.motionEasingEmphasizedInterpolator, w7.a.f16154b);
            this.C = d10.getDimensionPixelSize(14, -1);
            this.D = d10.getDimensionPixelSize(13, -1);
            this.A = d10.getResourceId(0, 0);
            this.F = d10.getDimensionPixelSize(1, 0);
            this.J = d10.getInt(15, 1);
            this.G = d10.getInt(2, 0);
            this.K = d10.getBoolean(12, false);
            this.O = d10.getBoolean(26, false);
            d10.recycle();
            Resources resources = getResources();
            this.f3880z = (float) resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.E = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            c();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private int getDefaultHeight() {
        ArrayList arrayList = this.f3863i;
        int size = arrayList.size();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 < size) {
                h hVar = (h) arrayList.get(i10);
                if (hVar != null && hVar.f16755a != null && !TextUtils.isEmpty(hVar.f16756b)) {
                    z10 = true;
                    break;
                }
                i10++;
            } else {
                break;
            }
        }
        if (!z10 || this.K) {
            return 48;
        }
        return 72;
    }

    private int getTabMinWidth() {
        int i10 = this.C;
        if (i10 != -1) {
            return i10;
        }
        int i11 = this.J;
        if (i11 == 0 || i11 == 2) {
            return this.E;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f3865k.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i10) {
        g gVar = this.f3865k;
        int childCount = gVar.getChildCount();
        if (i10 < childCount) {
            int i11 = 0;
            while (i11 < childCount) {
                View childAt = gVar.getChildAt(i11);
                boolean z10 = true;
                if ((i11 != i10 || childAt.isSelected()) && (i11 == i10 || !childAt.isSelected())) {
                    childAt.setSelected(i11 == i10);
                    if (i11 != i10) {
                        z10 = false;
                    }
                    childAt.setActivated(z10);
                } else {
                    childAt.setSelected(i11 == i10);
                    if (i11 != i10) {
                        z10 = false;
                    }
                    childAt.setActivated(z10);
                    if (childAt instanceof j) {
                        ((j) childAt).g();
                    }
                }
                i11++;
            }
        }
    }

    public final void a(h hVar, boolean z10) {
        float f10;
        ArrayList arrayList = this.f3863i;
        int size = arrayList.size();
        if (hVar.f16761g == this) {
            hVar.f16758d = size;
            arrayList.add(size, hVar);
            int size2 = arrayList.size();
            int i10 = -1;
            for (int i11 = size + 1; i11 < size2; i11++) {
                if (((h) arrayList.get(i11)).f16758d == this.f3862h) {
                    i10 = i11;
                }
                ((h) arrayList.get(i11)).f16758d = i11;
            }
            this.f3862h = i10;
            j jVar = hVar.f16762h;
            jVar.setSelected(false);
            jVar.setActivated(false);
            int i12 = hVar.f16758d;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            if (this.J == 1 && this.G == 0) {
                layoutParams.width = 0;
                f10 = 1.0f;
            } else {
                layoutParams.width = -2;
                f10 = 0.0f;
            }
            layoutParams.weight = f10;
            this.f3865k.addView(jVar, i12, layoutParams);
            if (z10) {
                TabLayout tabLayout = hVar.f16761g;
                if (tabLayout != null) {
                    tabLayout.i(hVar, true);
                    return;
                }
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public final void addView(View view) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public final void b(int i10) {
        boolean z10;
        if (i10 != -1) {
            if (getWindowToken() != null) {
                WeakHashMap weakHashMap = c1.f10054a;
                if (l0.c(this)) {
                    g gVar = this.f3865k;
                    int childCount = gVar.getChildCount();
                    int i11 = 0;
                    while (true) {
                        if (i11 >= childCount) {
                            z10 = false;
                            break;
                        } else if (gVar.getChildAt(i11).getWidth() <= 0) {
                            z10 = true;
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (!z10) {
                        int scrollX = getScrollX();
                        int d10 = d(i10, 0.0f);
                        if (scrollX != d10) {
                            e();
                            this.T.setIntValues(new int[]{scrollX, d10});
                            this.T.start();
                        }
                        ValueAnimator valueAnimator = gVar.f16752h;
                        if (!(valueAnimator == null || !valueAnimator.isRunning() || gVar.f16754j.f3862h == i10)) {
                            gVar.f16752h.cancel();
                        }
                        gVar.d(i10, this.H, true);
                        return;
                    }
                }
            }
            k(i10, 0.0f, true, true, true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        if (r0 != 2) goto L_0x004c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c() {
        /*
            r5 = this;
            int r0 = r5.J
            r1 = 2
            r2 = 0
            if (r0 == 0) goto L_0x000b
            if (r0 != r1) goto L_0x0009
            goto L_0x000b
        L_0x0009:
            r0 = 0
            goto L_0x0014
        L_0x000b:
            int r0 = r5.F
            int r3 = r5.f3866l
            int r0 = r0 - r3
            int r0 = java.lang.Math.max(r2, r0)
        L_0x0014:
            java.util.WeakHashMap r3 = m0.c1.f10054a
            x8.g r3 = r5.f3865k
            m0.j0.k(r3, r0, r2, r2, r2)
            int r0 = r5.J
            java.lang.String r2 = "TabLayout"
            r4 = 1
            if (r0 == 0) goto L_0x0034
            if (r0 == r4) goto L_0x0027
            if (r0 == r1) goto L_0x0027
            goto L_0x004c
        L_0x0027:
            int r0 = r5.G
            if (r0 != r1) goto L_0x0030
            java.lang.String r0 = "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead"
            android.util.Log.w(r2, r0)
        L_0x0030:
            r3.setGravity(r4)
            goto L_0x004c
        L_0x0034:
            int r0 = r5.G
            if (r0 == 0) goto L_0x0041
            if (r0 == r4) goto L_0x003d
            if (r0 == r1) goto L_0x0046
            goto L_0x004c
        L_0x003d:
            r3.setGravity(r4)
            goto L_0x004c
        L_0x0041:
            java.lang.String r0 = "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead"
            android.util.Log.w(r2, r0)
        L_0x0046:
            r0 = 8388611(0x800003, float:1.1754948E-38)
            r3.setGravity(r0)
        L_0x004c:
            r5.l(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.c():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r5.f3865k;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int d(int r6, float r7) {
        /*
            r5 = this;
            int r0 = r5.J
            r1 = 0
            r2 = 2
            if (r0 == 0) goto L_0x000a
            if (r0 != r2) goto L_0x0009
            goto L_0x000a
        L_0x0009:
            return r1
        L_0x000a:
            x8.g r0 = r5.f3865k
            android.view.View r3 = r0.getChildAt(r6)
            if (r3 != 0) goto L_0x0013
            return r1
        L_0x0013:
            int r6 = r6 + 1
            int r4 = r0.getChildCount()
            if (r6 >= r4) goto L_0x0020
            android.view.View r6 = r0.getChildAt(r6)
            goto L_0x0021
        L_0x0020:
            r6 = 0
        L_0x0021:
            int r0 = r3.getWidth()
            if (r6 == 0) goto L_0x002b
            int r1 = r6.getWidth()
        L_0x002b:
            int r6 = r3.getLeft()
            int r3 = r0 / 2
            int r3 = r3 + r6
            int r6 = r5.getWidth()
            int r6 = r6 / r2
            int r3 = r3 - r6
            int r0 = r0 + r1
            float r6 = (float) r0
            r0 = 1056964608(0x3f000000, float:0.5)
            float r6 = r6 * r0
            float r6 = r6 * r7
            int r6 = (int) r6
            java.util.WeakHashMap r7 = m0.c1.f10054a
            int r7 = m0.j0.d(r5)
            if (r7 != 0) goto L_0x004b
            int r3 = r3 + r6
            goto L_0x004c
        L_0x004b:
            int r3 = r3 - r6
        L_0x004c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.d(int, float):int");
    }

    public final void e() {
        if (this.T == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.T = valueAnimator;
            valueAnimator.setInterpolator(this.Q);
            this.T.setDuration((long) this.H);
            this.T.addUpdateListener(new x7.h(2, this));
        }
    }

    public final h f() {
        j jVar;
        CharSequence charSequence;
        h hVar = (h) f3860b0.j();
        if (hVar == null) {
            hVar = new h();
        }
        hVar.f16761g = this;
        f fVar = this.f3861a0;
        if (fVar != null) {
            jVar = (j) fVar.j();
        } else {
            jVar = null;
        }
        if (jVar == null) {
            jVar = new j(this, getContext());
        }
        jVar.setTab(hVar);
        jVar.setFocusable(true);
        jVar.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(hVar.f16757c)) {
            charSequence = hVar.f16756b;
        } else {
            charSequence = hVar.f16757c;
        }
        jVar.setContentDescription(charSequence);
        hVar.f16762h = jVar;
        int i10 = hVar.f16763i;
        if (i10 != -1) {
            jVar.setId(i10);
        }
        return hVar;
    }

    public final void g() {
        h();
        a aVar = this.U;
        if (aVar != null) {
            int a10 = aVar.a();
            for (int i10 = 0; i10 < a10; i10++) {
                h f10 = f();
                this.U.getClass();
                f10.a((String) null);
                a(f10, false);
            }
        }
    }

    public int getSelectedTabPosition() {
        h hVar = this.f3864j;
        if (hVar != null) {
            return hVar.f16758d;
        }
        return -1;
    }

    public int getTabCount() {
        return this.f3863i.size();
    }

    public int getTabGravity() {
        return this.G;
    }

    public ColorStateList getTabIconTint() {
        return this.f3874t;
    }

    public int getTabIndicatorAnimationMode() {
        return this.N;
    }

    public int getTabIndicatorGravity() {
        return this.I;
    }

    public int getTabMaxWidth() {
        return this.B;
    }

    public int getTabMode() {
        return this.J;
    }

    public ColorStateList getTabRippleColor() {
        return this.f3875u;
    }

    public Drawable getTabSelectedIndicator() {
        return this.f3876v;
    }

    public ColorStateList getTabTextColors() {
        return this.f3873s;
    }

    public final void h() {
        g gVar = this.f3865k;
        for (int childCount = gVar.getChildCount() - 1; childCount >= 0; childCount--) {
            j jVar = (j) gVar.getChildAt(childCount);
            gVar.removeViewAt(childCount);
            if (jVar != null) {
                jVar.setTab((h) null);
                jVar.setSelected(false);
                this.f3861a0.e(jVar);
            }
            requestLayout();
        }
        Iterator it = this.f3863i.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            it.remove();
            hVar.f16761g = null;
            hVar.f16762h = null;
            hVar.f16755a = null;
            hVar.f16763i = -1;
            hVar.f16756b = null;
            hVar.f16757c = null;
            hVar.f16758d = -1;
            hVar.f16759e = null;
            f3860b0.e(hVar);
        }
        this.f3864j = null;
    }

    public final void i(h hVar, boolean z10) {
        int i10;
        h hVar2 = this.f3864j;
        ArrayList arrayList = this.S;
        if (hVar2 != hVar) {
            if (hVar != null) {
                i10 = hVar.f16758d;
            } else {
                i10 = -1;
            }
            if (z10) {
                if ((hVar2 == null || hVar2.f16758d == -1) && i10 != -1) {
                    k(i10, 0.0f, true, true, true);
                } else {
                    b(i10);
                }
                if (i10 != -1) {
                    setSelectedTabView(i10);
                }
            }
            this.f3864j = hVar;
            if (!(hVar2 == null || hVar2.f16761g == null)) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((d) arrayList.get(size)).getClass();
                }
            }
            if (hVar != null) {
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    ((m) ((d) arrayList.get(size2))).a(hVar);
                }
            }
        } else if (hVar2 != null) {
            for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                ((d) arrayList.get(size3)).getClass();
            }
            b(hVar.f16758d);
        }
    }

    public final void j(a aVar) {
        a aVar2 = this.U;
        this.U = aVar;
        g();
    }

    public final void k(int i10, float f10, boolean z10, boolean z11, boolean z12) {
        boolean z13;
        float f11 = ((float) i10) + f10;
        int round = Math.round(f11);
        if (round >= 0) {
            g gVar = this.f3865k;
            if (round < gVar.getChildCount()) {
                if (z11) {
                    gVar.getClass();
                    gVar.f16754j.f3862h = Math.round(f11);
                    ValueAnimator valueAnimator = gVar.f16752h;
                    if (valueAnimator != null && valueAnimator.isRunning()) {
                        gVar.f16752h.cancel();
                    }
                    gVar.c(gVar.getChildAt(i10), gVar.getChildAt(i10 + 1), f10);
                }
                ValueAnimator valueAnimator2 = this.T;
                if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                    this.T.cancel();
                }
                int d10 = d(i10, f10);
                int scrollX = getScrollX();
                if ((i10 >= getSelectedTabPosition() || d10 < scrollX) && ((i10 <= getSelectedTabPosition() || d10 > scrollX) && i10 != getSelectedTabPosition())) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                WeakHashMap weakHashMap = c1.f10054a;
                if (j0.d(this) == 1) {
                    if ((i10 >= getSelectedTabPosition() || d10 > scrollX) && ((i10 <= getSelectedTabPosition() || d10 < scrollX) && i10 != getSelectedTabPosition())) {
                        z13 = false;
                    } else {
                        z13 = true;
                    }
                }
                if (z13 || this.W == 1 || z12) {
                    if (i10 < 0) {
                        d10 = 0;
                    }
                    scrollTo(d10, 0);
                }
                if (z10) {
                    setSelectedTabView(round);
                }
            }
        }
    }

    public final void l(boolean z10) {
        float f10;
        int i10 = 0;
        while (true) {
            g gVar = this.f3865k;
            if (i10 < gVar.getChildCount()) {
                View childAt = gVar.getChildAt(i10);
                childAt.setMinimumWidth(getTabMinWidth());
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                if (this.J == 1 && this.G == 0) {
                    layoutParams.width = 0;
                    f10 = 1.0f;
                } else {
                    layoutParams.width = -2;
                    f10 = 0.0f;
                }
                layoutParams.weight = f10;
                if (z10) {
                    childAt.requestLayout();
                }
                i10++;
            } else {
                return;
            }
        }
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        t8.j.c(this);
        getParent();
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.V) {
            setupWithViewPager((b) null);
            this.V = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
        r1 = (x8.j) r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onDraw(android.graphics.Canvas r8) {
        /*
            r7 = this;
            r0 = 0
        L_0x0001:
            x8.g r1 = r7.f3865k
            int r2 = r1.getChildCount()
            if (r0 >= r2) goto L_0x0032
            android.view.View r1 = r1.getChildAt(r0)
            boolean r2 = r1 instanceof x8.j
            if (r2 == 0) goto L_0x002f
            x8.j r1 = (x8.j) r1
            android.graphics.drawable.Drawable r2 = r1.f16775p
            if (r2 == 0) goto L_0x002f
            int r3 = r1.getLeft()
            int r4 = r1.getTop()
            int r5 = r1.getRight()
            int r6 = r1.getBottom()
            r2.setBounds(r3, r4, r5, r6)
            android.graphics.drawable.Drawable r1 = r1.f16775p
            r1.draw(r8)
        L_0x002f:
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0032:
            super.onDraw(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onDraw(android.graphics.Canvas):void");
    }

    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) l.b(1, getTabCount(), 1).f4038a);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        if (getTabMode() == 0 || getTabMode() == 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 || !super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        if (r0 != 2) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007e, code lost:
        if (r7.getMeasuredWidth() != getMeasuredWidth()) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0080, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008a, code lost:
        if (r7.getMeasuredWidth() < getMeasuredWidth()) goto L_0x0080;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = m8.w.b(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 0
            r5 = 1
            if (r1 == r2) goto L_0x002e
            if (r1 == 0) goto L_0x001f
            goto L_0x0041
        L_0x001f:
            int r8 = r6.getPaddingTop()
            int r8 = r8 + r0
            int r0 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L_0x0041
        L_0x002e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L_0x0041
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L_0x0041
            android.view.View r1 = r6.getChildAt(r4)
            r1.setMinimumHeight(r0)
        L_0x0041:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L_0x005f
            int r1 = r6.D
            if (r1 <= 0) goto L_0x0050
            goto L_0x005d
        L_0x0050:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = m8.w.b(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L_0x005d:
            r6.B = r1
        L_0x005f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto L_0x00ad
            android.view.View r7 = r6.getChildAt(r4)
            int r0 = r6.J
            if (r0 == 0) goto L_0x0082
            if (r0 == r5) goto L_0x0076
            r1 = 2
            if (r0 == r1) goto L_0x0082
            goto L_0x008d
        L_0x0076:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L_0x008d
        L_0x0080:
            r4 = 1
            goto L_0x008d
        L_0x0082:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto L_0x008d
            goto L_0x0080
        L_0x008d:
            if (r4 == 0) goto L_0x00ad
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r1 = r1 + r0
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            int r0 = r0.height
            int r8 = android.view.ViewGroup.getChildMeasureSpec(r8, r1, r0)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            r7.measure(r0, r8)
        L_0x00ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        if (motionEvent.getActionMasked() == 8) {
            if (getTabMode() == 0 || getTabMode() == 2) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setElevation(float f10) {
        super.setElevation(f10);
        t8.j.b(this, f10);
    }

    public void setInlineLabel(boolean z10) {
        if (this.K != z10) {
            this.K = z10;
            int i10 = 0;
            while (true) {
                g gVar = this.f3865k;
                if (i10 < gVar.getChildCount()) {
                    View childAt = gVar.getChildAt(i10);
                    if (childAt instanceof j) {
                        j jVar = (j) childAt;
                        jVar.setOrientation(jVar.f16777r.K ^ true ? 1 : 0);
                        TextView textView = jVar.f16773n;
                        if (textView == null && jVar.f16774o == null) {
                            jVar.h(jVar.f16768i, jVar.f16769j, true);
                        } else {
                            jVar.h(textView, jVar.f16774o, false);
                        }
                    }
                    i10++;
                } else {
                    c();
                    return;
                }
            }
        }
    }

    public void setInlineLabelResource(int i10) {
        setInlineLabel(getResources().getBoolean(i10));
    }

    @Deprecated
    public void setOnTabSelectedListener(d dVar) {
        d dVar2 = this.R;
        ArrayList arrayList = this.S;
        if (dVar2 != null) {
            arrayList.remove(dVar2);
        }
        this.R = dVar;
        if (dVar != null && !arrayList.contains(dVar)) {
            arrayList.add(dVar);
        }
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        e();
        this.T.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(int i10) {
        setSelectedTabIndicator(i10 != 0 ? h.a.a(getContext(), i10) : null);
    }

    public void setSelectedTabIndicatorColor(int i10) {
        this.f3877w = i10;
        i8.a.b(this.f3876v, i10);
        l(false);
    }

    public void setSelectedTabIndicatorGravity(int i10) {
        if (this.I != i10) {
            this.I = i10;
            WeakHashMap weakHashMap = c1.f10054a;
            i0.k(this.f3865k);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i10) {
        this.M = i10;
        this.f3865k.b(i10);
    }

    public void setTabGravity(int i10) {
        if (this.G != i10) {
            this.G = i10;
            c();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.f3874t != colorStateList) {
            this.f3874t = colorStateList;
            ArrayList arrayList = this.f3863i;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                j jVar = ((h) arrayList.get(i10)).f16762h;
                if (jVar != null) {
                    jVar.e();
                }
            }
        }
    }

    public void setTabIconTintResource(int i10) {
        setTabIconTint(c0.g.c(getContext(), i10));
    }

    public void setTabIndicatorAnimationMode(int i10) {
        c cVar;
        this.N = i10;
        if (i10 == 0) {
            cVar = new c();
        } else if (i10 == 1) {
            cVar = new x8.a();
        } else if (i10 == 2) {
            cVar = new x8.b();
        } else {
            throw new IllegalArgumentException(i10 + " is not a valid TabIndicatorAnimationMode");
        }
        this.P = cVar;
    }

    public void setTabIndicatorFullWidth(boolean z10) {
        this.L = z10;
        int i10 = g.f16751k;
        g gVar = this.f3865k;
        gVar.a(gVar.f16754j.getSelectedTabPosition());
        WeakHashMap weakHashMap = c1.f10054a;
        i0.k(gVar);
    }

    public void setTabMode(int i10) {
        if (i10 != this.J) {
            this.J = i10;
            c();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.f3875u != colorStateList) {
            this.f3875u = colorStateList;
            int i10 = 0;
            while (true) {
                g gVar = this.f3865k;
                if (i10 < gVar.getChildCount()) {
                    View childAt = gVar.getChildAt(i10);
                    if (childAt instanceof j) {
                        Context context = getContext();
                        int i11 = j.f16766s;
                        ((j) childAt).f(context);
                    }
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    public void setTabRippleColorResource(int i10) {
        setTabRippleColor(c0.g.c(getContext(), i10));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f3873s != colorStateList) {
            this.f3873s = colorStateList;
            ArrayList arrayList = this.f3863i;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                j jVar = ((h) arrayList.get(i10)).f16762h;
                if (jVar != null) {
                    jVar.e();
                }
            }
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(a aVar) {
        j(aVar);
    }

    public void setUnboundedRipple(boolean z10) {
        if (this.O != z10) {
            this.O = z10;
            int i10 = 0;
            while (true) {
                g gVar = this.f3865k;
                if (i10 < gVar.getChildCount()) {
                    View childAt = gVar.getChildAt(i10);
                    if (childAt instanceof j) {
                        Context context = getContext();
                        int i11 = j.f16766s;
                        ((j) childAt).f(context);
                    }
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i10) {
        setUnboundedRipple(getResources().getBoolean(i10));
    }

    public void setupWithViewPager(b bVar) {
        j((a) null);
        this.V = false;
    }

    public final boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public final void addView(View view, int i10) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable mutate = f0.d.g(drawable).mutate();
        this.f3876v = mutate;
        i8.a.b(mutate, this.f3877w);
        int i10 = this.M;
        if (i10 == -1) {
            i10 = this.f3876v.getIntrinsicHeight();
        }
        this.f3865k.b(i10);
    }

    public final void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    @Deprecated
    public void setOnTabSelectedListener(x8.e eVar) {
        setOnTabSelectedListener((d) eVar);
    }
}
