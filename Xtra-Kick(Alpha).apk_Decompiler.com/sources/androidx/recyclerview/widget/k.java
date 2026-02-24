package androidx.recyclerview.widget;

import android.support.v4.media.h;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final e1 f2063a;

    /* renamed from: b  reason: collision with root package name */
    public final j f2064b = new j();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f2065c = new ArrayList();

    public k(e1 e1Var) {
        this.f2063a = e1Var;
    }

    public final void a(View view, int i10, boolean z10) {
        int i11;
        e1 e1Var = this.f2063a;
        if (i10 < 0) {
            i11 = e1Var.b();
        } else {
            i11 = f(i10);
        }
        this.f2064b.e(i11, z10);
        if (z10) {
            i(view);
        }
        RecyclerView recyclerView = e1Var.f1972a;
        recyclerView.addView(view, i11);
        recyclerView.dispatchChildAttached(view);
    }

    public final void b(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        int i11;
        e1 e1Var = this.f2063a;
        if (i10 < 0) {
            i11 = e1Var.b();
        } else {
            i11 = f(i10);
        }
        this.f2064b.e(i11, z10);
        if (z10) {
            i(view);
        }
        e1Var.getClass();
        k2 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        RecyclerView recyclerView = e1Var.f1972a;
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else {
                StringBuilder sb2 = new StringBuilder("Called attach on a child which is not detached: ");
                sb2.append(childViewHolderInt);
                throw new IllegalArgumentException(h.h(recyclerView, sb2));
            }
        }
        recyclerView.attachViewToParent(view, i11, layoutParams);
    }

    public final void c(int i10) {
        k2 childViewHolderInt;
        int f10 = f(i10);
        this.f2064b.f(f10);
        e1 e1Var = this.f2063a;
        View childAt = e1Var.f1972a.getChildAt(f10);
        RecyclerView recyclerView = e1Var.f1972a;
        if (!(childAt == null || (childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt)) == null)) {
            if (!childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(256);
            } else {
                StringBuilder sb2 = new StringBuilder("called detach on an already detached child ");
                sb2.append(childViewHolderInt);
                throw new IllegalArgumentException(h.h(recyclerView, sb2));
            }
        }
        recyclerView.detachViewFromParent(f10);
    }

    public final View d(int i10) {
        return this.f2063a.f1972a.getChildAt(f(i10));
    }

    public final int e() {
        return this.f2063a.b() - this.f2065c.size();
    }

    public final int f(int i10) {
        if (i10 < 0) {
            return -1;
        }
        int b10 = this.f2063a.b();
        int i11 = i10;
        while (i11 < b10) {
            j jVar = this.f2064b;
            int b11 = i10 - (i11 - jVar.b(i11));
            if (b11 == 0) {
                while (jVar.d(i11)) {
                    i11++;
                }
                return i11;
            }
            i11 += b11;
        }
        return -1;
    }

    public final View g(int i10) {
        return this.f2063a.f1972a.getChildAt(i10);
    }

    public final int h() {
        return this.f2063a.b();
    }

    public final void i(View view) {
        this.f2065c.add(view);
        e1 e1Var = this.f2063a;
        e1Var.getClass();
        k2 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            childViewHolderInt.onEnteredHiddenState(e1Var.f1972a);
        }
    }

    public final boolean j(View view) {
        return this.f2065c.contains(view);
    }

    public final void k(View view) {
        if (this.f2065c.remove(view)) {
            e1 e1Var = this.f2063a;
            e1Var.getClass();
            k2 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onLeftHiddenState(e1Var.f1972a);
            }
        }
    }

    public final String toString() {
        return this.f2064b.toString() + ", hidden list:" + this.f2065c.size();
    }
}
