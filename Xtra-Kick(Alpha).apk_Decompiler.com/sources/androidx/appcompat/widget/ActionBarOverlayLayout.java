package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.woxthebox.draglistview.R;
import e0.d;
import g.b1;
import h.a;
import java.util.WeakHashMap;
import m.o;
import m0.c1;
import m0.d2;
import m0.e2;
import m0.f2;
import m0.g2;
import m0.i0;
import m0.m0;
import m0.m2;
import m0.o0;
import m0.q2;
import m0.v;
import m0.w;
import m0.x;

@SuppressLint({"UnknownNullness"})
public class ActionBarOverlayLayout extends ViewGroup implements e2, v, w {
    public static final int[] I = {R.attr.actionBarSize, 16842841};
    public q2 A;
    public f B;
    public OverScroller C;
    public ViewPropertyAnimator D;
    public final d E;
    public final e F;
    public final e G;
    public final x H;

    /* renamed from: h  reason: collision with root package name */
    public int f604h;

    /* renamed from: i  reason: collision with root package name */
    public int f605i = 0;

    /* renamed from: j  reason: collision with root package name */
    public ContentFrameLayout f606j;

    /* renamed from: k  reason: collision with root package name */
    public ActionBarContainer f607k;

    /* renamed from: l  reason: collision with root package name */
    public f2 f608l;

    /* renamed from: m  reason: collision with root package name */
    public Drawable f609m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f610n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f611o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f612p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f613q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f614r;

    /* renamed from: s  reason: collision with root package name */
    public int f615s;

    /* renamed from: t  reason: collision with root package name */
    public int f616t;

    /* renamed from: u  reason: collision with root package name */
    public final Rect f617u = new Rect();

    /* renamed from: v  reason: collision with root package name */
    public final Rect f618v = new Rect();

    /* renamed from: w  reason: collision with root package name */
    public final Rect f619w = new Rect();

    /* renamed from: x  reason: collision with root package name */
    public q2 f620x;

    /* renamed from: y  reason: collision with root package name */
    public q2 f621y;

    /* renamed from: z  reason: collision with root package name */
    public q2 f622z;

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        q2 q2Var = q2.f10130b;
        this.f620x = q2Var;
        this.f621y = q2Var;
        this.f622z = q2Var;
        this.A = q2Var;
        this.E = new d(0, this);
        this.F = new e(this, 0);
        this.G = new e(this, 1);
        j(context);
        this.H = new x();
    }

    public static boolean g(FrameLayout frameLayout, Rect rect, boolean z10) {
        boolean z11;
        int i10;
        g gVar = (g) frameLayout.getLayoutParams();
        int i11 = gVar.leftMargin;
        int i12 = rect.left;
        if (i11 != i12) {
            gVar.leftMargin = i12;
            z11 = true;
        } else {
            z11 = false;
        }
        int i13 = gVar.topMargin;
        int i14 = rect.top;
        if (i13 != i14) {
            gVar.topMargin = i14;
            z11 = true;
        }
        int i15 = gVar.rightMargin;
        int i16 = rect.right;
        if (i15 != i16) {
            gVar.rightMargin = i16;
            z11 = true;
        }
        if (!z10 || gVar.bottomMargin == (i10 = rect.bottom)) {
            return z11;
        }
        gVar.bottomMargin = i10;
        return true;
    }

    public final void a(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            onNestedScrollAccepted(view, view2, i10);
        }
    }

    public final void b(View view, int i10) {
        if (i10 == 0) {
            onStopNestedScroll(view);
        }
    }

    public final void c(View view, int i10, int i11, int[] iArr, int i12) {
        if (i12 == 0) {
            onNestedPreScroll(view, i10, i11, iArr);
        }
    }

    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof g;
    }

    public final void d(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        e(view, i10, i11, i12, i13, i14);
    }

    public final void draw(Canvas canvas) {
        int i10;
        super.draw(canvas);
        if (this.f609m != null && !this.f610n) {
            if (this.f607k.getVisibility() == 0) {
                i10 = (int) (this.f607k.getTranslationY() + ((float) this.f607k.getBottom()) + 0.5f);
            } else {
                i10 = 0;
            }
            this.f609m.setBounds(0, i10, getWidth(), this.f609m.getIntrinsicHeight() + i10);
            this.f609m.draw(canvas);
        }
    }

    public final void e(View view, int i10, int i11, int i12, int i13, int i14) {
        if (i14 == 0) {
            onNestedScroll(view, i10, i11, i12, i13);
        }
    }

    public final boolean f(View view, View view2, int i10, int i11) {
        return i11 == 0 && onStartNestedScroll(view, view2, i10);
    }

    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g();
    }

    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f607k;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        x xVar = this.H;
        return xVar.f10158b | xVar.f10157a;
    }

    public CharSequence getTitle() {
        l();
        return ((d5) this.f608l).f791a.getTitle();
    }

    public final void h() {
        removeCallbacks(this.F);
        removeCallbacks(this.G);
        ViewPropertyAnimator viewPropertyAnimator = this.D;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final boolean i() {
        boolean z10;
        l();
        ActionMenuView actionMenuView = ((d5) this.f608l).f791a.f691h;
        if (actionMenuView == null) {
            return false;
        }
        n nVar = actionMenuView.A;
        if (nVar == null || !nVar.d()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            return true;
        }
        return false;
    }

    public final void j(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(I);
        boolean z10 = false;
        this.f604h = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f609m = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z10 = true;
        }
        this.f610n = z10;
        this.C = new OverScroller(context);
    }

    public final void k(int i10) {
        l();
        if (i10 == 2) {
            ((d5) this.f608l).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else if (i10 == 5) {
            ((d5) this.f608l).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else if (i10 == 109) {
            setOverlayMode(true);
        }
    }

    public final void l() {
        f2 f2Var;
        if (this.f606j == null) {
            this.f606j = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f607k = (ActionBarContainer) findViewById(R.id.action_bar_container);
            View findViewById = findViewById(R.id.action_bar);
            if (findViewById instanceof f2) {
                f2Var = (f2) findViewById;
            } else if (findViewById instanceof Toolbar) {
                f2Var = ((Toolbar) findViewById).getWrapper();
            } else {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(findViewById.getClass().getSimpleName()));
            }
            this.f608l = f2Var;
        }
    }

    public final void m(o oVar, g.v vVar) {
        l();
        d5 d5Var = (d5) this.f608l;
        n nVar = d5Var.f803m;
        Toolbar toolbar = d5Var.f791a;
        if (nVar == null) {
            n nVar2 = new n(toolbar.getContext());
            d5Var.f803m = nVar2;
            nVar2.f952p = R.id.action_menu_presenter;
        }
        n nVar3 = d5Var.f803m;
        nVar3.f948l = vVar;
        if (oVar != null || toolbar.f691h != null) {
            toolbar.e();
            o oVar2 = toolbar.f691h.f623w;
            if (oVar2 != oVar) {
                if (oVar2 != null) {
                    oVar2.r(toolbar.R);
                    oVar2.r(toolbar.S);
                }
                if (toolbar.S == null) {
                    toolbar.S = new y4(toolbar);
                }
                nVar3.f961y = true;
                if (oVar != null) {
                    oVar.b(nVar3, toolbar.f700q);
                    oVar.b(toolbar.S, toolbar.f700q);
                } else {
                    nVar3.h(toolbar.f700q, (o) null);
                    toolbar.S.h(toolbar.f700q, (o) null);
                    nVar3.e(true);
                    toolbar.S.e(true);
                }
                toolbar.f691h.setPopupTheme(toolbar.f701r);
                toolbar.f691h.setPresenter(nVar3);
                toolbar.R = nVar3;
                toolbar.s();
            }
        }
    }

    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        l();
        q2 h10 = q2.h(this, windowInsets);
        boolean g10 = g(this.f607k, new Rect(h10.c(), h10.e(), h10.d(), h10.b()), false);
        WeakHashMap weakHashMap = c1.f10054a;
        Rect rect = this.f617u;
        o0.b(this, h10, rect);
        int i10 = rect.left;
        int i11 = rect.top;
        int i12 = rect.right;
        int i13 = rect.bottom;
        m2 m2Var = h10.f10131a;
        q2 l10 = m2Var.l(i10, i11, i12, i13);
        this.f620x = l10;
        boolean z10 = true;
        if (!this.f621y.equals(l10)) {
            this.f621y = this.f620x;
            g10 = true;
        }
        Rect rect2 = this.f618v;
        if (!rect2.equals(rect)) {
            rect2.set(rect);
        } else {
            z10 = g10;
        }
        if (z10) {
            requestLayout();
        }
        return m2Var.a().f10131a.c().f10131a.b().g();
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j(getContext());
        WeakHashMap weakHashMap = c1.f10054a;
        m0.c(this);
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i15 = gVar.leftMargin + paddingLeft;
                int i16 = gVar.topMargin + paddingTop;
                childAt.layout(i15, i16, measuredWidth + i15, measuredHeight + i16);
            }
        }
    }

    public final void onMeasure(int i10, int i11) {
        boolean z10;
        int i12;
        q2 q2Var;
        g2 g2Var;
        l();
        measureChildWithMargins(this.f607k, i10, 0, i11, 0);
        g gVar = (g) this.f607k.getLayoutParams();
        int max = Math.max(0, this.f607k.getMeasuredWidth() + gVar.leftMargin + gVar.rightMargin);
        int max2 = Math.max(0, this.f607k.getMeasuredHeight() + gVar.topMargin + gVar.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f607k.getMeasuredState());
        WeakHashMap weakHashMap = c1.f10054a;
        if ((i0.g(this) & 256) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i12 = this.f604h;
            if (this.f612p && this.f607k.getTabContainer() != null) {
                i12 += this.f604h;
            }
        } else {
            i12 = this.f607k.getVisibility() != 8 ? this.f607k.getMeasuredHeight() : 0;
        }
        Rect rect = this.f617u;
        Rect rect2 = this.f619w;
        rect2.set(rect);
        q2 q2Var2 = this.f620x;
        this.f622z = q2Var2;
        if (this.f611o || z10) {
            d b10 = d.b(q2Var2.c(), this.f622z.e() + i12, this.f622z.d(), this.f622z.b() + 0);
            q2 q2Var3 = this.f622z;
            int i13 = Build.VERSION.SDK_INT;
            if (i13 >= 30) {
                g2Var = new f2(q2Var3);
            } else if (i13 >= 29) {
                g2Var = new e2(q2Var3);
            } else {
                g2Var = new d2(q2Var3);
            }
            g2Var.g(b10);
            q2Var = g2Var.b();
        } else {
            rect2.top += i12;
            rect2.bottom += 0;
            q2Var = q2Var2.f10131a.l(0, i12, 0, 0);
        }
        this.f622z = q2Var;
        g(this.f606j, rect2, true);
        if (!this.A.equals(this.f622z)) {
            q2 q2Var4 = this.f622z;
            this.A = q2Var4;
            ContentFrameLayout contentFrameLayout = this.f606j;
            WindowInsets g10 = q2Var4.g();
            if (g10 != null) {
                WindowInsets a10 = m0.a(contentFrameLayout, g10);
                if (!a10.equals(g10)) {
                    q2.h(contentFrameLayout, a10);
                }
            }
        }
        measureChildWithMargins(this.f606j, i10, 0, i11, 0);
        g gVar2 = (g) this.f606j.getLayoutParams();
        int max3 = Math.max(max, this.f606j.getMeasuredWidth() + gVar2.leftMargin + gVar2.rightMargin);
        int max4 = Math.max(max2, this.f606j.getMeasuredHeight() + gVar2.topMargin + gVar2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f606j.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + max3, getSuggestedMinimumWidth()), i10, combineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + max4, getSuggestedMinimumHeight()), i11, combineMeasuredStates2 << 16));
    }

    public final boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        boolean z11 = false;
        if (!this.f613q || !z10) {
            return false;
        }
        this.C.fling(0, 0, 0, (int) f11, 0, 0, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE);
        if (this.C.getFinalY() > this.f607k.getHeight()) {
            z11 = true;
        }
        if (z11) {
            h();
            this.G.run();
        } else {
            h();
            this.F.run();
        }
        this.f614r = true;
        return true;
    }

    public final boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    public final void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
    }

    public final void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        int i14 = this.f615s + i11;
        this.f615s = i14;
        setActionBarHideOffset(i14);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r1 = (g.b1) r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onNestedScrollAccepted(android.view.View r1, android.view.View r2, int r3) {
        /*
            r0 = this;
            m0.x r1 = r0.H
            r1.f10157a = r3
            int r1 = r0.getActionBarHideOffset()
            r0.f615s = r1
            r0.h()
            androidx.appcompat.widget.f r1 = r0.B
            if (r1 == 0) goto L_0x001d
            g.b1 r1 = (g.b1) r1
            l.n r2 = r1.f6045s
            if (r2 == 0) goto L_0x001d
            r2.a()
            r2 = 0
            r1.f6045s = r2
        L_0x001d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.onNestedScrollAccepted(android.view.View, android.view.View, int):void");
    }

    public final boolean onStartNestedScroll(View view, View view2, int i10) {
        if ((i10 & 2) == 0 || this.f607k.getVisibility() != 0) {
            return false;
        }
        return this.f613q;
    }

    public final void onStopNestedScroll(View view) {
        if (this.f613q && !this.f614r) {
            if (this.f615s <= this.f607k.getHeight()) {
                h();
                postDelayed(this.F, 600);
                return;
            }
            h();
            postDelayed(this.G, 600);
        }
    }

    public final void onWindowSystemUiVisibilityChanged(int i10) {
        boolean z10;
        boolean z11;
        super.onWindowSystemUiVisibilityChanged(i10);
        l();
        int i11 = this.f616t ^ i10;
        this.f616t = i10;
        if ((i10 & 4) == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if ((i10 & 256) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        f fVar = this.B;
        if (fVar != null) {
            ((b1) fVar).f6041o = !z11;
            if (z10 || !z11) {
                b1 b1Var = (b1) fVar;
                if (b1Var.f6042p) {
                    b1Var.f6042p = false;
                    b1Var.h(true);
                }
            } else {
                b1 b1Var2 = (b1) fVar;
                if (!b1Var2.f6042p) {
                    b1Var2.f6042p = true;
                    b1Var2.h(true);
                }
            }
        }
        if ((i11 & 256) != 0 && this.B != null) {
            WeakHashMap weakHashMap = c1.f10054a;
            m0.c(this);
        }
    }

    public final void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f605i = i10;
        f fVar = this.B;
        if (fVar != null) {
            ((b1) fVar).f6040n = i10;
        }
    }

    public void setActionBarHideOffset(int i10) {
        h();
        this.f607k.setTranslationY((float) (-Math.max(0, Math.min(i10, this.f607k.getHeight()))));
    }

    public void setActionBarVisibilityCallback(f fVar) {
        this.B = fVar;
        if (getWindowToken() != null) {
            ((b1) this.B).f6040n = this.f605i;
            int i10 = this.f616t;
            if (i10 != 0) {
                onWindowSystemUiVisibilityChanged(i10);
                WeakHashMap weakHashMap = c1.f10054a;
                m0.c(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z10) {
        this.f612p = z10;
    }

    public void setHideOnContentScrollEnabled(boolean z10) {
        if (z10 != this.f613q) {
            this.f613q = z10;
            if (!z10) {
                h();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i10) {
        l();
        d5 d5Var = (d5) this.f608l;
        d5Var.f794d = i10 != 0 ? a.a(d5Var.f791a.getContext(), i10) : null;
        d5Var.b();
    }

    public void setLogo(int i10) {
        Drawable drawable;
        l();
        d5 d5Var = (d5) this.f608l;
        if (i10 != 0) {
            drawable = a.a(d5Var.f791a.getContext(), i10);
        } else {
            drawable = null;
        }
        d5Var.f795e = drawable;
        d5Var.b();
    }

    public void setOverlayMode(boolean z10) {
        this.f611o = z10;
        this.f610n = z10 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z10) {
    }

    public void setUiOptions(int i10) {
    }

    public void setWindowCallback(Window.Callback callback) {
        l();
        ((d5) this.f608l).f801k = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        l();
        d5 d5Var = (d5) this.f608l;
        if (!d5Var.f797g) {
            d5Var.f798h = charSequence;
            if ((d5Var.f792b & 8) != 0) {
                Toolbar toolbar = d5Var.f791a;
                toolbar.setTitle(charSequence);
                if (d5Var.f797g) {
                    c1.q(toolbar.getRootView(), charSequence);
                }
            }
        }
    }

    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new g(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        l();
        d5 d5Var = (d5) this.f608l;
        d5Var.f794d = drawable;
        d5Var.b();
    }
}
