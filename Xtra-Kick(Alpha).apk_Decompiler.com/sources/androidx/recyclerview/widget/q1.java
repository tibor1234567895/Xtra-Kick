package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.support.v4.media.n;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.fragment.app.p0;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.gson.internal.bind.l;
import java.util.ArrayList;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;
import m0.j0;
import n0.i;
import q3.a;

public abstract class q1 {

    /* renamed from: h  reason: collision with root package name */
    public k f2143h;

    /* renamed from: i  reason: collision with root package name */
    public RecyclerView f2144i;

    /* renamed from: j  reason: collision with root package name */
    public final n f2145j;

    /* renamed from: k  reason: collision with root package name */
    public final n f2146k;

    /* renamed from: l  reason: collision with root package name */
    public f2 f2147l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f2148m = false;

    /* renamed from: n  reason: collision with root package name */
    public boolean f2149n = false;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f2150o = true;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f2151p = true;

    /* renamed from: q  reason: collision with root package name */
    public int f2152q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f2153r;

    /* renamed from: s  reason: collision with root package name */
    public int f2154s;

    /* renamed from: t  reason: collision with root package name */
    public int f2155t;

    /* renamed from: u  reason: collision with root package name */
    public int f2156u;

    /* renamed from: v  reason: collision with root package name */
    public int f2157v;

    public q1() {
        p0 p0Var = new p0(0, this);
        p0 p0Var2 = new p0(1, this);
        this.f2145j = new n(p0Var);
        this.f2146k = new n(p0Var2);
    }

    public static int F(View view) {
        return ((r1) view.getLayoutParams()).f2185i.bottom;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
        if (r5 == 1073741824) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int I(int r4, int r5, int r6, int r7, boolean r8) {
        /*
            int r4 = r4 - r6
            r6 = 0
            int r4 = java.lang.Math.max(r6, r4)
            r0 = -2
            r1 = -1
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r8 == 0) goto L_0x001a
            if (r7 < 0) goto L_0x0011
            goto L_0x001c
        L_0x0011:
            if (r7 != r1) goto L_0x002f
            if (r5 == r2) goto L_0x0021
            if (r5 == 0) goto L_0x002f
            if (r5 == r3) goto L_0x0021
            goto L_0x002f
        L_0x001a:
            if (r7 < 0) goto L_0x001f
        L_0x001c:
            r5 = 1073741824(0x40000000, float:2.0)
            goto L_0x0031
        L_0x001f:
            if (r7 != r1) goto L_0x0023
        L_0x0021:
            r7 = r4
            goto L_0x0031
        L_0x0023:
            if (r7 != r0) goto L_0x002f
            if (r5 == r2) goto L_0x002c
            if (r5 != r3) goto L_0x002a
            goto L_0x002c
        L_0x002a:
            r5 = 0
            goto L_0x0021
        L_0x002c:
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x0021
        L_0x002f:
            r5 = 0
            r7 = 0
        L_0x0031:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.q1.I(int, int, int, int, boolean):int");
    }

    public static int N(View view) {
        return ((r1) view.getLayoutParams()).f2185i.left;
    }

    public static int O(View view) {
        return ((r1) view.getLayoutParams()).u();
    }

    public static p1 P(Context context, AttributeSet attributeSet, int i10, int i11) {
        p1 p1Var = new p1();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f13323a, i10, i11);
        p1Var.f2128a = obtainStyledAttributes.getInt(0, 1);
        p1Var.f2129b = obtainStyledAttributes.getInt(10, 1);
        p1Var.f2130c = obtainStyledAttributes.getBoolean(9, false);
        p1Var.f2131d = obtainStyledAttributes.getBoolean(11, false);
        obtainStyledAttributes.recycle();
        return p1Var;
    }

    public static int Q(View view) {
        return ((r1) view.getLayoutParams()).f2185i.right;
    }

    public static int S(View view) {
        return ((r1) view.getLayoutParams()).f2185i.top;
    }

    public static boolean V(int i10, int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (i12 > 0 && i10 != i12) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i10;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i10;
        }
        return true;
    }

    public static void W(View view, int i10, int i11, int i12, int i13) {
        r1 r1Var = (r1) view.getLayoutParams();
        Rect rect = r1Var.f2185i;
        view.layout(i10 + rect.left + r1Var.leftMargin, i11 + rect.top + r1Var.topMargin, (i12 - rect.right) - r1Var.rightMargin, (i13 - rect.bottom) - r1Var.bottomMargin);
    }

    public static int r(int i10, int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i11, i12) : size : Math.min(size, Math.max(i11, i12));
    }

    public final void A(y1 y1Var) {
        int H = H();
        while (true) {
            H--;
            if (H >= 0) {
                View G = G(H);
                k2 childViewHolderInt = RecyclerView.getChildViewHolderInt(G);
                if (!childViewHolderInt.shouldIgnore()) {
                    if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || this.f2144i.mAdapter.hasStableIds()) {
                        G(H);
                        this.f2143h.c(H);
                        y1Var.l(G);
                        this.f2144i.mViewInfoStore.b(childViewHolderInt);
                    } else {
                        if (G(H) != null) {
                            k kVar = this.f2143h;
                            int f10 = kVar.f(H);
                            e1 e1Var = kVar.f2063a;
                            View childAt = e1Var.f1972a.getChildAt(f10);
                            if (childAt != null) {
                                if (kVar.f2064b.f(f10)) {
                                    kVar.k(childAt);
                                }
                                e1Var.c(f10);
                            }
                        }
                        y1Var.k(childViewHolderInt);
                    }
                }
            } else {
                return;
            }
        }
    }

    public void A0(int i10) {
    }

    public View B(int i10) {
        int H = H();
        for (int i11 = 0; i11 < H; i11++) {
            View G = G(i11);
            k2 childViewHolderInt = RecyclerView.getChildViewHolderInt(G);
            if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i10 && !childViewHolderInt.shouldIgnore() && (this.f2144i.mState.f2024g || !childViewHolderInt.isRemoved())) {
                return G;
            }
        }
        return null;
    }

    public int B0(int i10, y1 y1Var, g2 g2Var) {
        return 0;
    }

    public abstract r1 C();

    public final void C0(RecyclerView recyclerView) {
        D0(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
    }

    public r1 D(Context context, AttributeSet attributeSet) {
        return new r1(context, attributeSet);
    }

    public final void D0(int i10, int i11) {
        this.f2156u = View.MeasureSpec.getSize(i10);
        int mode = View.MeasureSpec.getMode(i10);
        this.f2154s = mode;
        if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
            this.f2156u = 0;
        }
        this.f2157v = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i11);
        this.f2155t = mode2;
        if (mode2 == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
            this.f2157v = 0;
        }
    }

    public r1 E(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof r1 ? new r1((r1) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new r1((ViewGroup.MarginLayoutParams) layoutParams) : new r1(layoutParams);
    }

    public void E0(Rect rect, int i10, int i11) {
        int paddingRight = getPaddingRight() + getPaddingLeft() + rect.width();
        int paddingBottom = getPaddingBottom() + getPaddingTop() + rect.height();
        RecyclerView recyclerView = this.f2144i;
        WeakHashMap weakHashMap = c1.f10054a;
        this.f2144i.setMeasuredDimension(r(i10, paddingRight, i0.e(recyclerView)), r(i11, paddingBottom, i0.d(this.f2144i)));
    }

    public final void F0(int i10, int i11) {
        int H = H();
        if (H == 0) {
            this.f2144i.defaultOnMeasure(i10, i11);
            return;
        }
        int i12 = Integer.MAX_VALUE;
        int i13 = Integer.MAX_VALUE;
        int i14 = RecyclerView.UNDEFINED_DURATION;
        int i15 = RecyclerView.UNDEFINED_DURATION;
        for (int i16 = 0; i16 < H; i16++) {
            View G = G(i16);
            Rect rect = this.f2144i.mTempRect;
            K(G, rect);
            int i17 = rect.left;
            if (i17 < i12) {
                i12 = i17;
            }
            int i18 = rect.right;
            if (i18 > i14) {
                i14 = i18;
            }
            int i19 = rect.top;
            if (i19 < i13) {
                i13 = i19;
            }
            int i20 = rect.bottom;
            if (i20 > i15) {
                i15 = i20;
            }
        }
        this.f2144i.mTempRect.set(i12, i13, i14, i15);
        E0(this.f2144i.mTempRect, i10, i11);
    }

    public final View G(int i10) {
        k kVar = this.f2143h;
        if (kVar != null) {
            return kVar.d(i10);
        }
        return null;
    }

    public final void G0(RecyclerView recyclerView) {
        int i10;
        if (recyclerView == null) {
            this.f2144i = null;
            this.f2143h = null;
            i10 = 0;
            this.f2156u = 0;
        } else {
            this.f2144i = recyclerView;
            this.f2143h = recyclerView.mChildHelper;
            this.f2156u = recyclerView.getWidth();
            i10 = recyclerView.getHeight();
        }
        this.f2157v = i10;
        this.f2154s = 1073741824;
        this.f2155t = 1073741824;
    }

    public final int H() {
        k kVar = this.f2143h;
        if (kVar != null) {
            return kVar.e();
        }
        return 0;
    }

    public final boolean H0(View view, int i10, int i11, r1 r1Var) {
        return view.isLayoutRequested() || !this.f2150o || !V(view.getWidth(), i10, r1Var.width) || !V(view.getHeight(), i11, r1Var.height);
    }

    public boolean I0() {
        return false;
    }

    public int J(y1 y1Var, g2 g2Var) {
        return -1;
    }

    public final boolean J0(View view, int i10, int i11, r1 r1Var) {
        return !this.f2150o || !V(view.getMeasuredWidth(), i10, r1Var.width) || !V(view.getMeasuredHeight(), i11, r1Var.height);
    }

    public void K(View view, Rect rect) {
        RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public void K0(RecyclerView recyclerView, int i10) {
        Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
    }

    public final int L() {
        RecyclerView recyclerView = this.f2144i;
        g1 adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        if (adapter != null) {
            return adapter.getItemCount();
        }
        return 0;
    }

    public final void L0(f2 f2Var) {
        f2 f2Var2 = this.f2147l;
        if (!(f2Var2 == null || f2Var == f2Var2 || !f2Var2.f1987e)) {
            f2Var2.g();
        }
        this.f2147l = f2Var;
        RecyclerView recyclerView = this.f2144i;
        j2 j2Var = recyclerView.mViewFlinger;
        j2Var.f2062n.removeCallbacks(j2Var);
        j2Var.f2058j.abortAnimation();
        if (f2Var.f1990h) {
            Log.w("RecyclerView", "An instance of " + f2Var.getClass().getSimpleName() + " was started more than once. Each instance of" + f2Var.getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        }
        f2Var.f1984b = recyclerView;
        f2Var.f1985c = this;
        int i10 = f2Var.f1983a;
        if (i10 != -1) {
            recyclerView.mState.f2018a = i10;
            f2Var.f1987e = true;
            f2Var.f1986d = true;
            f2Var.f1988f = recyclerView.mLayout.B(i10);
            f2Var.d();
            f2Var.f1984b.mViewFlinger.b();
            f2Var.f1990h = true;
            return;
        }
        throw new IllegalArgumentException("Invalid target position");
    }

    public final int M() {
        RecyclerView recyclerView = this.f2144i;
        WeakHashMap weakHashMap = c1.f10054a;
        return j0.d(recyclerView);
    }

    public boolean M0() {
        return false;
    }

    public int R(y1 y1Var, g2 g2Var) {
        return -1;
    }

    public final void T(View view, Rect rect) {
        Matrix matrix;
        Rect rect2 = ((r1) view.getLayoutParams()).f2185i;
        rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        if (!(this.f2144i == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
            RectF rectF = this.f2144i.mTempRectF;
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    public boolean U() {
        return false;
    }

    public void X(int i10) {
        RecyclerView recyclerView = this.f2144i;
        if (recyclerView != null) {
            recyclerView.offsetChildrenHorizontal(i10);
        }
    }

    public void Y(int i10) {
        RecyclerView recyclerView = this.f2144i;
        if (recyclerView != null) {
            recyclerView.offsetChildrenVertical(i10);
        }
    }

    public void Z() {
    }

    public void a0(RecyclerView recyclerView) {
    }

    public void b0(RecyclerView recyclerView) {
    }

    public View c0(View view, int i10, y1 y1Var, g2 g2Var) {
        return null;
    }

    public void d0(AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.f2144i;
        y1 y1Var = recyclerView.mRecycler;
        g2 g2Var = recyclerView.mState;
        if (recyclerView != null && accessibilityEvent != null) {
            boolean z10 = true;
            if (!recyclerView.canScrollVertically(1) && !this.f2144i.canScrollVertically(-1) && !this.f2144i.canScrollHorizontally(-1) && !this.f2144i.canScrollHorizontally(1)) {
                z10 = false;
            }
            accessibilityEvent.setScrollable(z10);
            g1 g1Var = this.f2144i.mAdapter;
            if (g1Var != null) {
                accessibilityEvent.setItemCount(g1Var.getItemCount());
            }
        }
    }

    public void e0(y1 y1Var, g2 g2Var, i iVar) {
        if (this.f2144i.canScrollVertically(-1) || this.f2144i.canScrollHorizontally(-1)) {
            iVar.a(8192);
            iVar.k(true);
        }
        if (this.f2144i.canScrollVertically(1) || this.f2144i.canScrollHorizontally(1)) {
            iVar.a(4096);
            iVar.k(true);
        }
        iVar.f10916a.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) l.b(R(y1Var, g2Var), J(y1Var, g2Var), 0).f4038a);
    }

    public final void f0(View view, i iVar) {
        k2 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && !this.f2143h.j(childViewHolderInt.itemView)) {
            RecyclerView recyclerView = this.f2144i;
            g0(recyclerView.mRecycler, recyclerView.mState, view, iVar);
        }
    }

    public void g0(y1 y1Var, g2 g2Var, View view, i iVar) {
    }

    public final int getPaddingBottom() {
        RecyclerView recyclerView = this.f2144i;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }

    public final int getPaddingEnd() {
        RecyclerView recyclerView = this.f2144i;
        if (recyclerView == null) {
            return 0;
        }
        WeakHashMap weakHashMap = c1.f10054a;
        return j0.e(recyclerView);
    }

    public final int getPaddingLeft() {
        RecyclerView recyclerView = this.f2144i;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    public final int getPaddingRight() {
        RecyclerView recyclerView = this.f2144i;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    public final int getPaddingStart() {
        RecyclerView recyclerView = this.f2144i;
        if (recyclerView == null) {
            return 0;
        }
        WeakHashMap weakHashMap = c1.f10054a;
        return j0.f(recyclerView);
    }

    public final int getPaddingTop() {
        RecyclerView recyclerView = this.f2144i;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    public void h0(int i10, int i11) {
    }

    public void i0() {
    }

    public void j0(int i10, int i11) {
    }

    public void k0(int i10, int i11) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(android.view.View r9, int r10, boolean r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.k2 r0 = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(r9)
            r1 = 0
            r2 = 1
            if (r11 != 0) goto L_0x0017
            boolean r11 = r0.isRemoved()
            if (r11 == 0) goto L_0x000f
            goto L_0x0017
        L_0x000f:
            androidx.recyclerview.widget.RecyclerView r11 = r8.f2144i
            androidx.recyclerview.widget.d3 r11 = r11.mViewInfoStore
            r11.b(r0)
            goto L_0x0031
        L_0x0017:
            androidx.recyclerview.widget.RecyclerView r11 = r8.f2144i
            androidx.recyclerview.widget.d3 r11 = r11.mViewInfoStore
            q.k r11 = r11.f1966a
            java.lang.Object r3 = r11.getOrDefault(r0, r1)
            androidx.recyclerview.widget.b3 r3 = (androidx.recyclerview.widget.b3) r3
            if (r3 != 0) goto L_0x002c
            androidx.recyclerview.widget.b3 r3 = androidx.recyclerview.widget.b3.a()
            r11.put(r0, r3)
        L_0x002c:
            int r11 = r3.f1946a
            r11 = r11 | r2
            r3.f1946a = r11
        L_0x0031:
            android.view.ViewGroup$LayoutParams r11 = r9.getLayoutParams()
            androidx.recyclerview.widget.r1 r11 = (androidx.recyclerview.widget.r1) r11
            boolean r3 = r0.wasReturnedFromScrap()
            r4 = 0
            if (r3 != 0) goto L_0x011b
            boolean r3 = r0.isScrap()
            if (r3 == 0) goto L_0x0046
            goto L_0x011b
        L_0x0046:
            android.view.ViewParent r3 = r9.getParent()
            androidx.recyclerview.widget.RecyclerView r5 = r8.f2144i
            if (r3 != r5) goto L_0x00ff
            androidx.recyclerview.widget.k r3 = r8.f2143h
            androidx.recyclerview.widget.e1 r5 = r3.f2063a
            androidx.recyclerview.widget.RecyclerView r5 = r5.f1972a
            int r5 = r5.indexOfChild(r9)
            r6 = -1
            if (r5 != r6) goto L_0x005c
            goto L_0x0064
        L_0x005c:
            androidx.recyclerview.widget.j r3 = r3.f2064b
            boolean r7 = r3.d(r5)
            if (r7 == 0) goto L_0x0066
        L_0x0064:
            r3 = -1
            goto L_0x006c
        L_0x0066:
            int r3 = r3.b(r5)
            int r3 = r5 - r3
        L_0x006c:
            if (r10 != r6) goto L_0x0074
            androidx.recyclerview.widget.k r10 = r8.f2143h
            int r10 = r10.e()
        L_0x0074:
            if (r3 == r6) goto L_0x00e3
            if (r3 == r10) goto L_0x0131
            androidx.recyclerview.widget.RecyclerView r9 = r8.f2144i
            androidx.recyclerview.widget.q1 r9 = r9.mLayout
            android.view.View r5 = r9.G(r3)
            if (r5 == 0) goto L_0x00c6
            r9.G(r3)
            androidx.recyclerview.widget.k r6 = r9.f2143h
            r6.c(r3)
            android.view.ViewGroup$LayoutParams r3 = r5.getLayoutParams()
            androidx.recyclerview.widget.r1 r3 = (androidx.recyclerview.widget.r1) r3
            androidx.recyclerview.widget.k2 r6 = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(r5)
            boolean r7 = r6.isRemoved()
            if (r7 == 0) goto L_0x00b5
            androidx.recyclerview.widget.RecyclerView r7 = r9.f2144i
            androidx.recyclerview.widget.d3 r7 = r7.mViewInfoStore
            q.k r7 = r7.f1966a
            java.lang.Object r1 = r7.getOrDefault(r6, r1)
            androidx.recyclerview.widget.b3 r1 = (androidx.recyclerview.widget.b3) r1
            if (r1 != 0) goto L_0x00af
            androidx.recyclerview.widget.b3 r1 = androidx.recyclerview.widget.b3.a()
            r7.put(r6, r1)
        L_0x00af:
            int r7 = r1.f1946a
            r2 = r2 | r7
            r1.f1946a = r2
            goto L_0x00bc
        L_0x00b5:
            androidx.recyclerview.widget.RecyclerView r1 = r9.f2144i
            androidx.recyclerview.widget.d3 r1 = r1.mViewInfoStore
            r1.b(r6)
        L_0x00bc:
            androidx.recyclerview.widget.k r9 = r9.f2143h
            boolean r1 = r6.isRemoved()
            r9.b(r5, r10, r3, r1)
            goto L_0x0131
        L_0x00c6:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r0 = "Cannot move a child from non-existing index:"
            r11.<init>(r0)
            r11.append(r3)
            androidx.recyclerview.widget.RecyclerView r9 = r9.f2144i
            java.lang.String r9 = r9.toString()
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r10.<init>(r9)
            throw r10
        L_0x00e3:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r0 = "Added View has RecyclerView as parent but view is not a real child. Unfiltered index:"
            r11.<init>(r0)
            androidx.recyclerview.widget.RecyclerView r0 = r8.f2144i
            int r9 = r0.indexOfChild(r9)
            r11.append(r9)
            androidx.recyclerview.widget.RecyclerView r9 = r8.f2144i
            java.lang.String r9 = android.support.v4.media.h.h(r9, r11)
            r10.<init>(r9)
            throw r10
        L_0x00ff:
            androidx.recyclerview.widget.k r1 = r8.f2143h
            r1.a(r9, r10, r4)
            r11.f2186j = r2
            androidx.recyclerview.widget.f2 r10 = r8.f2147l
            if (r10 == 0) goto L_0x0131
            boolean r1 = r10.f1987e
            if (r1 == 0) goto L_0x0131
            androidx.recyclerview.widget.RecyclerView r1 = r10.f1984b
            int r1 = r1.getChildLayoutPosition(r9)
            int r2 = r10.f1983a
            if (r1 != r2) goto L_0x0131
            r10.f1988f = r9
            goto L_0x0131
        L_0x011b:
            boolean r1 = r0.isScrap()
            if (r1 == 0) goto L_0x0125
            r0.unScrap()
            goto L_0x0128
        L_0x0125:
            r0.clearReturnedFromScrapFlag()
        L_0x0128:
            androidx.recyclerview.widget.k r1 = r8.f2143h
            android.view.ViewGroup$LayoutParams r2 = r9.getLayoutParams()
            r1.b(r9, r10, r2, r4)
        L_0x0131:
            boolean r9 = r11.f2187k
            if (r9 == 0) goto L_0x013c
            android.view.View r9 = r0.itemView
            r9.invalidate()
            r11.f2187k = r4
        L_0x013c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.q1.l(android.view.View, int, boolean):void");
    }

    public void l0(int i10) {
    }

    public void m(String str) {
        RecyclerView recyclerView = this.f2144i;
        if (recyclerView != null) {
            recyclerView.assertNotInLayoutOrScroll(str);
        }
    }

    public void m0(RecyclerView recyclerView, int i10, int i11) {
        l0(i10);
    }

    public final void n(View view, Rect rect) {
        RecyclerView recyclerView = this.f2144i;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.getItemDecorInsetsForChild(view));
        }
    }

    public void n0(y1 y1Var, g2 g2Var) {
        Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
    }

    public boolean o() {
        return this instanceof CarouselLayoutManager;
    }

    public void o0(g2 g2Var) {
    }

    public boolean p() {
        return false;
    }

    public void p0(Parcelable parcelable) {
    }

    public boolean q(r1 r1Var) {
        return r1Var != null;
    }

    public Parcelable q0() {
        return null;
    }

    public void r0(int i10) {
    }

    public void s(int i10, int i11, g2 g2Var, i0 i0Var) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x008f A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean s0(androidx.recyclerview.widget.y1 r9, androidx.recyclerview.widget.g2 r10, int r11, android.os.Bundle r12) {
        /*
            r8 = this;
            androidx.recyclerview.widget.RecyclerView r9 = r8.f2144i
            r10 = 0
            if (r9 != 0) goto L_0x0006
            return r10
        L_0x0006:
            int r9 = r8.f2157v
            int r12 = r8.f2156u
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            androidx.recyclerview.widget.RecyclerView r1 = r8.f2144i
            android.graphics.Matrix r1 = r1.getMatrix()
            boolean r1 = r1.isIdentity()
            if (r1 == 0) goto L_0x002b
            androidx.recyclerview.widget.RecyclerView r1 = r8.f2144i
            boolean r1 = r1.getGlobalVisibleRect(r0)
            if (r1 == 0) goto L_0x002b
            int r9 = r0.height()
            int r12 = r0.width()
        L_0x002b:
            r0 = 4096(0x1000, float:5.74E-42)
            r1 = 1
            if (r11 == r0) goto L_0x0061
            r0 = 8192(0x2000, float:1.14794E-41)
            if (r11 == r0) goto L_0x0037
            r3 = 0
            r4 = 0
            goto L_0x008d
        L_0x0037:
            androidx.recyclerview.widget.RecyclerView r11 = r8.f2144i
            r0 = -1
            boolean r11 = r11.canScrollVertically(r0)
            if (r11 == 0) goto L_0x004c
            int r11 = r8.getPaddingTop()
            int r9 = r9 - r11
            int r11 = r8.getPaddingBottom()
            int r9 = r9 - r11
            int r9 = -r9
            goto L_0x004d
        L_0x004c:
            r9 = 0
        L_0x004d:
            androidx.recyclerview.widget.RecyclerView r11 = r8.f2144i
            boolean r11 = r11.canScrollHorizontally(r0)
            if (r11 == 0) goto L_0x008b
            int r11 = r8.getPaddingLeft()
            int r12 = r12 - r11
            int r11 = r8.getPaddingRight()
            int r12 = r12 - r11
            int r11 = -r12
            goto L_0x0088
        L_0x0061:
            androidx.recyclerview.widget.RecyclerView r11 = r8.f2144i
            boolean r11 = r11.canScrollVertically(r1)
            if (r11 == 0) goto L_0x0074
            int r11 = r8.getPaddingTop()
            int r9 = r9 - r11
            int r11 = r8.getPaddingBottom()
            int r9 = r9 - r11
            goto L_0x0075
        L_0x0074:
            r9 = 0
        L_0x0075:
            androidx.recyclerview.widget.RecyclerView r11 = r8.f2144i
            boolean r11 = r11.canScrollHorizontally(r1)
            if (r11 == 0) goto L_0x008b
            int r11 = r8.getPaddingLeft()
            int r12 = r12 - r11
            int r11 = r8.getPaddingRight()
            int r11 = r12 - r11
        L_0x0088:
            r4 = r9
            r3 = r11
            goto L_0x008d
        L_0x008b:
            r4 = r9
            r3 = 0
        L_0x008d:
            if (r4 != 0) goto L_0x0092
            if (r3 != 0) goto L_0x0092
            return r10
        L_0x0092:
            androidx.recyclerview.widget.RecyclerView r2 = r8.f2144i
            r5 = 0
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = 1
            r2.smoothScrollBy(r3, r4, r5, r6, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.q1.s0(androidx.recyclerview.widget.y1, androidx.recyclerview.widget.g2, int, android.os.Bundle):boolean");
    }

    public void t(int i10, i0 i0Var) {
    }

    public final void t0() {
        int H = H();
        while (true) {
            H--;
            if (H >= 0) {
                k kVar = this.f2143h;
                int f10 = kVar.f(H);
                e1 e1Var = kVar.f2063a;
                View childAt = e1Var.f1972a.getChildAt(f10);
                if (childAt != null) {
                    if (kVar.f2064b.f(f10)) {
                        kVar.k(childAt);
                    }
                    e1Var.c(f10);
                }
            } else {
                return;
            }
        }
    }

    public int u(g2 g2Var) {
        return 0;
    }

    public final void u0(y1 y1Var) {
        int H = H();
        while (true) {
            H--;
            if (H < 0) {
                return;
            }
            if (!RecyclerView.getChildViewHolderInt(G(H)).shouldIgnore()) {
                View G = G(H);
                if (G(H) != null) {
                    k kVar = this.f2143h;
                    int f10 = kVar.f(H);
                    e1 e1Var = kVar.f2063a;
                    View childAt = e1Var.f1972a.getChildAt(f10);
                    if (childAt != null) {
                        if (kVar.f2064b.f(f10)) {
                            kVar.k(childAt);
                        }
                        e1Var.c(f10);
                    }
                }
                y1Var.j(G);
            }
        }
    }

    public int v(g2 g2Var) {
        return 0;
    }

    public final void v0(y1 y1Var) {
        ArrayList arrayList;
        int size = y1Var.f2250a.size();
        int i10 = size - 1;
        while (true) {
            arrayList = y1Var.f2250a;
            if (i10 < 0) {
                break;
            }
            View view = ((k2) arrayList.get(i10)).itemView;
            k2 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.setIsRecyclable(false);
                if (childViewHolderInt.isTmpDetached()) {
                    this.f2144i.removeDetachedView(view, false);
                }
                n1 n1Var = this.f2144i.mItemAnimator;
                if (n1Var != null) {
                    n1Var.i(childViewHolderInt);
                }
                childViewHolderInt.setIsRecyclable(true);
                k2 childViewHolderInt2 = RecyclerView.getChildViewHolderInt(view);
                childViewHolderInt2.mScrapContainer = null;
                childViewHolderInt2.mInChangeScrap = false;
                childViewHolderInt2.clearReturnedFromScrapFlag();
                y1Var.k(childViewHolderInt2);
            }
            i10--;
        }
        arrayList.clear();
        ArrayList arrayList2 = y1Var.f2251b;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        if (size > 0) {
            this.f2144i.invalidate();
        }
    }

    public int w(g2 g2Var) {
        return 0;
    }

    public final void w0(View view, y1 y1Var) {
        k kVar = this.f2143h;
        e1 e1Var = kVar.f2063a;
        int indexOfChild = e1Var.f1972a.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (kVar.f2064b.f(indexOfChild)) {
                kVar.k(view);
            }
            e1Var.c(indexOfChild);
        }
        y1Var.j(view);
    }

    public int x(g2 g2Var) {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a8, code lost:
        if (r10 == false) goto L_0x00af;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean x0(androidx.recyclerview.widget.RecyclerView r9, android.view.View r10, android.graphics.Rect r11, boolean r12, boolean r13) {
        /*
            r8 = this;
            int r0 = r8.getPaddingLeft()
            int r1 = r8.getPaddingTop()
            int r2 = r8.f2156u
            int r3 = r8.getPaddingRight()
            int r2 = r2 - r3
            int r3 = r8.f2157v
            int r4 = r8.getPaddingBottom()
            int r3 = r3 - r4
            int r4 = r10.getLeft()
            int r5 = r11.left
            int r4 = r4 + r5
            int r5 = r10.getScrollX()
            int r4 = r4 - r5
            int r5 = r10.getTop()
            int r6 = r11.top
            int r5 = r5 + r6
            int r10 = r10.getScrollY()
            int r5 = r5 - r10
            int r10 = r11.width()
            int r10 = r10 + r4
            int r11 = r11.height()
            int r11 = r11 + r5
            int r4 = r4 - r0
            r0 = 0
            int r6 = java.lang.Math.min(r0, r4)
            int r5 = r5 - r1
            int r1 = java.lang.Math.min(r0, r5)
            int r10 = r10 - r2
            int r2 = java.lang.Math.max(r0, r10)
            int r11 = r11 - r3
            int r11 = java.lang.Math.max(r0, r11)
            int r3 = r8.M()
            r7 = 1
            if (r3 != r7) goto L_0x005c
            if (r2 == 0) goto L_0x0057
            goto L_0x0064
        L_0x0057:
            int r2 = java.lang.Math.max(r6, r10)
            goto L_0x0064
        L_0x005c:
            if (r6 == 0) goto L_0x005f
            goto L_0x0063
        L_0x005f:
            int r6 = java.lang.Math.min(r4, r2)
        L_0x0063:
            r2 = r6
        L_0x0064:
            if (r1 == 0) goto L_0x0067
            goto L_0x006b
        L_0x0067:
            int r1 = java.lang.Math.min(r5, r11)
        L_0x006b:
            if (r13 == 0) goto L_0x00aa
            android.view.View r10 = r9.getFocusedChild()
            if (r10 != 0) goto L_0x0075
        L_0x0073:
            r10 = 0
            goto L_0x00a8
        L_0x0075:
            int r11 = r8.getPaddingLeft()
            int r13 = r8.getPaddingTop()
            int r3 = r8.f2156u
            int r4 = r8.getPaddingRight()
            int r3 = r3 - r4
            int r4 = r8.f2157v
            int r5 = r8.getPaddingBottom()
            int r4 = r4 - r5
            androidx.recyclerview.widget.RecyclerView r5 = r8.f2144i
            android.graphics.Rect r5 = r5.mTempRect
            r8.K(r10, r5)
            int r10 = r5.left
            int r10 = r10 - r2
            if (r10 >= r3) goto L_0x0073
            int r10 = r5.right
            int r10 = r10 - r2
            if (r10 <= r11) goto L_0x0073
            int r10 = r5.top
            int r10 = r10 - r1
            if (r10 >= r4) goto L_0x0073
            int r10 = r5.bottom
            int r10 = r10 - r1
            if (r10 > r13) goto L_0x00a7
            goto L_0x0073
        L_0x00a7:
            r10 = 1
        L_0x00a8:
            if (r10 == 0) goto L_0x00af
        L_0x00aa:
            if (r2 != 0) goto L_0x00b0
            if (r1 == 0) goto L_0x00af
            goto L_0x00b0
        L_0x00af:
            return r0
        L_0x00b0:
            if (r12 == 0) goto L_0x00b6
            r9.scrollBy(r2, r1)
            goto L_0x00b9
        L_0x00b6:
            r9.smoothScrollBy(r2, r1)
        L_0x00b9:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.q1.x0(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
    }

    public int y(g2 g2Var) {
        return 0;
    }

    public final void y0() {
        RecyclerView recyclerView = this.f2144i;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public int z(g2 g2Var) {
        return 0;
    }

    public int z0(int i10, y1 y1Var, g2 g2Var) {
        return 0;
    }
}
