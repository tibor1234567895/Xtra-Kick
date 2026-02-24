package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.WeakHashMap;
import m0.c;
import n0.i;
import n0.m;

public final class l2 extends c {

    /* renamed from: d  reason: collision with root package name */
    public final m2 f2075d;

    /* renamed from: e  reason: collision with root package name */
    public final WeakHashMap f2076e = new WeakHashMap();

    public l2(m2 m2Var) {
        this.f2075d = m2Var;
    }

    public final boolean a(View view, AccessibilityEvent accessibilityEvent) {
        c cVar = (c) this.f2076e.get(view);
        return cVar != null ? cVar.a(view, accessibilityEvent) : super.a(view, accessibilityEvent);
    }

    public final m b(View view) {
        c cVar = (c) this.f2076e.get(view);
        return cVar != null ? cVar.b(view) : super.b(view);
    }

    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        c cVar = (c) this.f2076e.get(view);
        if (cVar != null) {
            cVar.c(view, accessibilityEvent);
        } else {
            super.c(view, accessibilityEvent);
        }
    }

    public final void d(View view, i iVar) {
        m2 m2Var = this.f2075d;
        if (!m2Var.f2086d.hasPendingAdapterUpdates()) {
            RecyclerView recyclerView = m2Var.f2086d;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().f0(view, iVar);
                c cVar = (c) this.f2076e.get(view);
                if (cVar != null) {
                    cVar.d(view, iVar);
                    return;
                }
            }
        }
        this.f10052a.onInitializeAccessibilityNodeInfo(view, iVar.f10916a);
    }

    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        c cVar = (c) this.f2076e.get(view);
        if (cVar != null) {
            cVar.e(view, accessibilityEvent);
        } else {
            super.e(view, accessibilityEvent);
        }
    }

    public final boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        c cVar = (c) this.f2076e.get(viewGroup);
        return cVar != null ? cVar.f(viewGroup, view, accessibilityEvent) : super.f(viewGroup, view, accessibilityEvent);
    }

    public final boolean g(View view, int i10, Bundle bundle) {
        m2 m2Var = this.f2075d;
        if (!m2Var.f2086d.hasPendingAdapterUpdates()) {
            RecyclerView recyclerView = m2Var.f2086d;
            if (recyclerView.getLayoutManager() != null) {
                c cVar = (c) this.f2076e.get(view);
                if (cVar != null) {
                    if (cVar.g(view, i10, bundle)) {
                        return true;
                    }
                } else if (super.g(view, i10, bundle)) {
                    return true;
                }
                y1 y1Var = recyclerView.getLayoutManager().f2144i.mRecycler;
                return false;
            }
        }
        return super.g(view, i10, bundle);
    }

    public final void h(View view, int i10) {
        c cVar = (c) this.f2076e.get(view);
        if (cVar != null) {
            cVar.h(view, i10);
        } else {
            super.h(view, i10);
        }
    }

    public final void i(View view, AccessibilityEvent accessibilityEvent) {
        c cVar = (c) this.f2076e.get(view);
        if (cVar != null) {
            cVar.i(view, accessibilityEvent);
        } else {
            super.i(view, accessibilityEvent);
        }
    }
}
