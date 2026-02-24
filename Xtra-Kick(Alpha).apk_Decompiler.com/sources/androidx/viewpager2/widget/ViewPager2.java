package androidx.viewpager2.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.h;
import android.support.v4.media.session.u;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.fragment.app.c0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g1;
import androidx.recyclerview.widget.n1;
import androidx.recyclerview.widget.q1;
import androidx.viewpager2.adapter.d;
import g4.a;
import h4.b;
import h4.c;
import h4.e;
import h4.f;
import h4.g;
import h4.i;
import h4.l;
import h4.m;
import h4.n;
import h4.o;
import h4.q;
import h4.r;
import java.util.List;
import java.util.WeakHashMap;
import m0.c1;
import m0.j0;

public final class ViewPager2 extends ViewGroup {
    public l A;

    /* renamed from: h  reason: collision with root package name */
    public final Rect f2313h = new Rect();

    /* renamed from: i  reason: collision with root package name */
    public final Rect f2314i = new Rect();

    /* renamed from: j  reason: collision with root package name */
    public final d f2315j;

    /* renamed from: k  reason: collision with root package name */
    public int f2316k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f2317l;

    /* renamed from: m  reason: collision with root package name */
    public final e f2318m;

    /* renamed from: n  reason: collision with root package name */
    public i f2319n;

    /* renamed from: o  reason: collision with root package name */
    public int f2320o;

    /* renamed from: p  reason: collision with root package name */
    public Parcelable f2321p;

    /* renamed from: q  reason: collision with root package name */
    public RecyclerView f2322q;

    /* renamed from: r  reason: collision with root package name */
    public n f2323r;

    /* renamed from: s  reason: collision with root package name */
    public h4.d f2324s;

    /* renamed from: t  reason: collision with root package name */
    public d f2325t;

    /* renamed from: u  reason: collision with root package name */
    public u f2326u;

    /* renamed from: v  reason: collision with root package name */
    public b f2327v;

    /* renamed from: w  reason: collision with root package name */
    public n1 f2328w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f2329x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f2330y;

    /* renamed from: z  reason: collision with root package name */
    public int f2331z;

    /* JADX INFO: finally extract failed */
    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d dVar = new d();
        this.f2315j = dVar;
        this.f2317l = false;
        this.f2318m = new e(0, this);
        this.f2320o = -1;
        this.f2328w = null;
        this.f2329x = false;
        this.f2330y = true;
        this.f2331z = -1;
        this.A = new l(this);
        o oVar = new o(this, context);
        this.f2322q = oVar;
        WeakHashMap weakHashMap = c1.f10054a;
        oVar.setId(j0.a());
        this.f2322q.setDescendantFocusability(131072);
        i iVar = new i(this);
        this.f2319n = iVar;
        this.f2322q.setLayoutManager(iVar);
        this.f2322q.setScrollingTouchSlop(1);
        int[] iArr = a.f6830a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(obtainStyledAttributes.getInt(0, 0));
            obtainStyledAttributes.recycle();
            this.f2322q.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.f2322q.addOnChildAttachStateChangeListener(new g());
            h4.d dVar2 = new h4.d(this);
            this.f2324s = dVar2;
            this.f2326u = new u((Object) this, (Object) dVar2, (Object) this.f2322q, 16, 0);
            n nVar = new n(this);
            this.f2323r = nVar;
            nVar.b(this.f2322q);
            this.f2322q.addOnScrollListener(this.f2324s);
            d dVar3 = new d();
            this.f2325t = dVar3;
            this.f2324s.f7519a = dVar3;
            f fVar = new f(this, 0);
            f fVar2 = new f(this, 1);
            ((List) this.f2325t.f2296b).add(fVar);
            ((List) this.f2325t.f2296b).add(fVar2);
            this.A.g(this.f2322q);
            ((List) this.f2325t.f2296b).add(dVar);
            b bVar = new b(this.f2319n);
            this.f2327v = bVar;
            ((List) this.f2325t.f2296b).add(bVar);
            RecyclerView recyclerView = this.f2322q;
            attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void a() {
        g1 adapter;
        if (this.f2320o != -1 && (adapter = getAdapter()) != null) {
            Parcelable parcelable = this.f2321p;
            if (parcelable != null) {
                if (adapter instanceof androidx.viewpager2.adapter.i) {
                    ((androidx.viewpager2.adapter.g) ((androidx.viewpager2.adapter.i) adapter)).h(parcelable);
                }
                this.f2321p = null;
            }
            int max = Math.max(0, Math.min(this.f2320o, adapter.getItemCount() - 1));
            this.f2316k = max;
            this.f2320o = -1;
            this.f2322q.scrollToPosition(max);
            this.A.k();
        }
    }

    public final void b(int i10, boolean z10) {
        if (!((h4.d) this.f2326u.f429j).f7531m) {
            c(i10, z10);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    public final void c(int i10, boolean z10) {
        boolean z11;
        int i11;
        int i12;
        boolean z12;
        g1 adapter = getAdapter();
        boolean z13 = false;
        if (adapter == null) {
            if (this.f2320o != -1) {
                this.f2320o = Math.max(i10, 0);
            }
        } else if (adapter.getItemCount() > 0) {
            int min = Math.min(Math.max(i10, 0), adapter.getItemCount() - 1);
            int i13 = this.f2316k;
            if (min == i13) {
                if (this.f2324s.f7524f == 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    return;
                }
            }
            if (min != i13 || !z10) {
                double d10 = (double) i13;
                this.f2316k = min;
                this.A.k();
                h4.d dVar = this.f2324s;
                if (dVar.f7524f == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    dVar.d();
                    c cVar = dVar.f7525g;
                    d10 = ((double) cVar.f7516a) + ((double) cVar.f7517b);
                }
                h4.d dVar2 = this.f2324s;
                dVar2.getClass();
                if (z10) {
                    i11 = 2;
                } else {
                    i11 = 3;
                }
                dVar2.f7523e = i11;
                dVar2.f7531m = false;
                if (dVar2.f7527i != min) {
                    z13 = true;
                }
                dVar2.f7527i = min;
                dVar2.b(2);
                if (z13) {
                    dVar2.a(min);
                }
                if (!z10) {
                    this.f2322q.scrollToPosition(min);
                    return;
                }
                double d11 = (double) min;
                if (Math.abs(d11 - d10) > 3.0d) {
                    RecyclerView recyclerView = this.f2322q;
                    if (d11 > d10) {
                        i12 = min - 3;
                    } else {
                        i12 = min + 3;
                    }
                    recyclerView.scrollToPosition(i12);
                    RecyclerView recyclerView2 = this.f2322q;
                    recyclerView2.post(new r(recyclerView2, min));
                    return;
                }
                this.f2322q.smoothScrollToPosition(min);
            }
        }
    }

    public final boolean canScrollHorizontally(int i10) {
        return this.f2322q.canScrollHorizontally(i10);
    }

    public final boolean canScrollVertically(int i10) {
        return this.f2322q.canScrollVertically(i10);
    }

    public final void d() {
        n nVar = this.f2323r;
        if (nVar != null) {
            View e10 = nVar.e(this.f2319n);
            if (e10 != null) {
                this.f2319n.getClass();
                int O = q1.O(e10);
                if (O != this.f2316k && getScrollState() == 0) {
                    this.f2325t.c(O);
                }
                this.f2317l = false;
                return;
            }
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        Parcelable parcelable = (Parcelable) sparseArray.get(getId());
        if (parcelable instanceof q) {
            int i10 = ((q) parcelable).f7544h;
            sparseArray.put(this.f2322q.getId(), sparseArray.get(i10));
            sparseArray.remove(i10);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        a();
    }

    public CharSequence getAccessibilityClassName() {
        this.A.getClass();
        this.A.getClass();
        return "androidx.viewpager.widget.ViewPager";
    }

    public g1 getAdapter() {
        return this.f2322q.getAdapter();
    }

    public int getCurrentItem() {
        return this.f2316k;
    }

    public int getItemDecorationCount() {
        return this.f2322q.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.f2331z;
    }

    public int getOrientation() {
        return this.f2319n.f1917w;
    }

    public int getPageSize() {
        int i10;
        int i11;
        RecyclerView recyclerView = this.f2322q;
        if (getOrientation() == 0) {
            i10 = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            i11 = recyclerView.getPaddingRight();
        } else {
            i10 = recyclerView.getHeight() - recyclerView.getPaddingTop();
            i11 = recyclerView.getPaddingBottom();
        }
        return i10 - i11;
    }

    public int getScrollState() {
        return this.f2324s.f7524f;
    }

    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.A.h(accessibilityNodeInfo);
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredWidth = this.f2322q.getMeasuredWidth();
        int measuredHeight = this.f2322q.getMeasuredHeight();
        int paddingLeft = getPaddingLeft();
        Rect rect = this.f2313h;
        rect.left = paddingLeft;
        rect.right = (i12 - i10) - getPaddingRight();
        rect.top = getPaddingTop();
        rect.bottom = (i13 - i11) - getPaddingBottom();
        Rect rect2 = this.f2314i;
        Gravity.apply(8388659, measuredWidth, measuredHeight, rect, rect2);
        this.f2322q.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
        if (this.f2317l) {
            d();
        }
    }

    public final void onMeasure(int i10, int i11) {
        measureChild(this.f2322q, i10, i11);
        int measuredWidth = this.f2322q.getMeasuredWidth();
        int measuredHeight = this.f2322q.getMeasuredHeight();
        int measuredState = this.f2322q.getMeasuredState();
        int paddingRight = getPaddingRight() + getPaddingLeft() + measuredWidth;
        int paddingTop = getPaddingTop();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i10, measuredState), View.resolveSizeAndState(Math.max(getPaddingBottom() + paddingTop + measuredHeight, getSuggestedMinimumHeight()), i11, measuredState << 16));
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof q)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        q qVar = (q) parcelable;
        super.onRestoreInstanceState(qVar.getSuperState());
        this.f2320o = qVar.f7545i;
        this.f2321p = qVar.f7546j;
    }

    public final Parcelable onSaveInstanceState() {
        q qVar = new q(super.onSaveInstanceState());
        qVar.f7544h = this.f2322q.getId();
        int i10 = this.f2320o;
        if (i10 == -1) {
            i10 = this.f2316k;
        }
        qVar.f7545i = i10;
        Parcelable parcelable = this.f2321p;
        if (parcelable != null) {
            qVar.f7546j = parcelable;
        } else {
            g1 adapter = this.f2322q.getAdapter();
            if (adapter instanceof androidx.viewpager2.adapter.i) {
                androidx.viewpager2.adapter.g gVar = (androidx.viewpager2.adapter.g) ((androidx.viewpager2.adapter.i) adapter);
                gVar.getClass();
                q.i iVar = gVar.f2306c;
                int i11 = iVar.i();
                q.i iVar2 = gVar.f2307d;
                Bundle bundle = new Bundle(iVar2.i() + i11);
                for (int i12 = 0; i12 < iVar.i(); i12++) {
                    long f10 = iVar.f(i12);
                    c0 c0Var = (c0) iVar.e(f10, (Long) null);
                    if (c0Var != null && c0Var.F()) {
                        String k10 = h.k("f#", f10);
                        androidx.fragment.app.c1 c1Var = gVar.f2305b;
                        c1Var.getClass();
                        if (c0Var.f1370z == c1Var) {
                            bundle.putString(k10, c0Var.f1356l);
                        } else {
                            c1Var.e0(new IllegalStateException(h.l("Fragment ", c0Var, " is not currently in the FragmentManager")));
                            throw null;
                        }
                    }
                }
                for (int i13 = 0; i13 < iVar2.i(); i13++) {
                    long f11 = iVar2.f(i13);
                    if (gVar.b(f11)) {
                        bundle.putParcelable(h.k("s#", f11), (Parcelable) iVar2.e(f11, (Long) null));
                    }
                }
                qVar.f7546j = bundle;
            }
        }
        return qVar;
    }

    public final void onViewAdded(View view) {
        throw new IllegalStateException("ViewPager2 does not support direct child views");
    }

    public final boolean performAccessibilityAction(int i10, Bundle bundle) {
        this.A.getClass();
        if (!(i10 == 8192 || i10 == 4096)) {
            return super.performAccessibilityAction(i10, bundle);
        }
        this.A.i(i10, bundle);
        return true;
    }

    public void setAdapter(g1 g1Var) {
        g1 adapter = this.f2322q.getAdapter();
        this.A.f(adapter);
        e eVar = this.f2318m;
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(eVar);
        }
        this.f2322q.setAdapter(g1Var);
        this.f2316k = 0;
        a();
        this.A.e(g1Var);
        if (g1Var != null) {
            g1Var.registerAdapterDataObserver(eVar);
        }
    }

    public void setCurrentItem(int i10) {
        b(i10, true);
    }

    public void setLayoutDirection(int i10) {
        super.setLayoutDirection(i10);
        this.A.k();
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 >= 1 || i10 == -1) {
            this.f2331z = i10;
            this.f2322q.requestLayout();
            return;
        }
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public void setOrientation(int i10) {
        this.f2319n.o1(i10);
        this.A.k();
    }

    public void setPageTransformer(m mVar) {
        boolean z10 = this.f2329x;
        if (mVar != null) {
            if (!z10) {
                this.f2328w = this.f2322q.getItemAnimator();
                this.f2329x = true;
            }
            this.f2322q.setItemAnimator((n1) null);
        } else if (z10) {
            this.f2322q.setItemAnimator(this.f2328w);
            this.f2328w = null;
            this.f2329x = false;
        }
        this.f2327v.getClass();
        if (mVar != null) {
            this.f2327v.getClass();
            this.f2327v.getClass();
        }
    }

    public void setUserInputEnabled(boolean z10) {
        this.f2330y = z10;
        this.A.k();
    }
}
