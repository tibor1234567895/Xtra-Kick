package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;

public final class a2 extends i1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f1932a;

    public a2(RecyclerView recyclerView) {
        this.f1932a = recyclerView;
    }

    public final void a() {
        RecyclerView recyclerView = this.f1932a;
        recyclerView.assertNotInLayoutOrScroll((String) null);
        recyclerView.mState.f2023f = true;
        recyclerView.processDataSetCompletelyChanged(true);
        if (!recyclerView.mAdapterHelper.g()) {
            recyclerView.requestLayout();
        }
    }

    public final void c(int i10, int i11, Object obj) {
        RecyclerView recyclerView = this.f1932a;
        recyclerView.assertNotInLayoutOrScroll((String) null);
        b bVar = recyclerView.mAdapterHelper;
        boolean z10 = true;
        boolean z11 = false;
        if (i11 < 1) {
            bVar.getClass();
        } else {
            ArrayList arrayList = bVar.f1934b;
            arrayList.add(bVar.h(obj, 4, i10, i11));
            bVar.f1938f |= 4;
            if (arrayList.size() != 1) {
                z10 = false;
            }
            z11 = z10;
        }
        if (z11) {
            h();
        }
    }

    public final void d(int i10, int i11) {
        RecyclerView recyclerView = this.f1932a;
        recyclerView.assertNotInLayoutOrScroll((String) null);
        b bVar = recyclerView.mAdapterHelper;
        boolean z10 = true;
        boolean z11 = false;
        if (i11 < 1) {
            bVar.getClass();
        } else {
            ArrayList arrayList = bVar.f1934b;
            arrayList.add(bVar.h((Object) null, 1, i10, i11));
            bVar.f1938f |= 1;
            if (arrayList.size() != 1) {
                z10 = false;
            }
            z11 = z10;
        }
        if (z11) {
            h();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0023, code lost:
        if (r2.size() == 1) goto L_0x0027;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(int r5, int r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r4.f1932a
            r1 = 0
            r0.assertNotInLayoutOrScroll(r1)
            androidx.recyclerview.widget.b r0 = r0.mAdapterHelper
            r0.getClass()
            if (r5 != r6) goto L_0x000e
            goto L_0x0026
        L_0x000e:
            java.util.ArrayList r2 = r0.f1934b
            r3 = 8
            androidx.recyclerview.widget.a r5 = r0.h(r1, r3, r5, r6)
            r2.add(r5)
            int r5 = r0.f1938f
            r5 = r5 | r3
            r0.f1938f = r5
            int r5 = r2.size()
            r6 = 1
            if (r5 != r6) goto L_0x0026
            goto L_0x0027
        L_0x0026:
            r6 = 0
        L_0x0027:
            if (r6 == 0) goto L_0x002c
            r4.h()
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.a2.e(int, int):void");
    }

    public final void f(int i10, int i11) {
        RecyclerView recyclerView = this.f1932a;
        recyclerView.assertNotInLayoutOrScroll((String) null);
        b bVar = recyclerView.mAdapterHelper;
        boolean z10 = true;
        boolean z11 = false;
        if (i11 < 1) {
            bVar.getClass();
        } else {
            ArrayList arrayList = bVar.f1934b;
            arrayList.add(bVar.h((Object) null, 2, i10, i11));
            bVar.f1938f |= 2;
            if (arrayList.size() != 1) {
                z10 = false;
            }
            z11 = z10;
        }
        if (z11) {
            h();
        }
    }

    public final void g() {
        g1 g1Var;
        RecyclerView recyclerView = this.f1932a;
        if (recyclerView.mPendingSavedState != null && (g1Var = recyclerView.mAdapter) != null && g1Var.canRestoreState()) {
            recyclerView.requestLayout();
        }
    }

    public final void h() {
        boolean z10 = RecyclerView.POST_UPDATES_ON_ANIMATION;
        RecyclerView recyclerView = this.f1932a;
        if (!z10 || !recyclerView.mHasFixedSize || !recyclerView.mIsAttached) {
            recyclerView.mAdapterUpdateDuringMeasure = true;
            recyclerView.requestLayout();
            return;
        }
        Runnable runnable = recyclerView.mUpdateChildViewsRunnable;
        WeakHashMap weakHashMap = c1.f10054a;
        i0.m(recyclerView, runnable);
    }
}
