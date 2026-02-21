package h4;

import android.os.Bundle;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g1;
import androidx.viewpager2.widget.ViewPager2;
import java.util.WeakHashMap;
import k0.k;
import m0.c1;
import m0.i0;
import n0.g;

public final class l extends k {

    /* renamed from: b  reason: collision with root package name */
    public final k f7538b = new k(this, 0);

    /* renamed from: c  reason: collision with root package name */
    public final k f7539c = new k(this, 1);

    /* renamed from: d  reason: collision with root package name */
    public e f7540d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ViewPager2 f7541e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(ViewPager2 viewPager2) {
        super(viewPager2);
        this.f7541e = viewPager2;
    }

    public final void e(g1 g1Var) {
        k();
        if (g1Var != null) {
            g1Var.registerAdapterDataObserver(this.f7540d);
        }
    }

    public final void f(g1 g1Var) {
        if (g1Var != null) {
            g1Var.unregisterAdapterDataObserver(this.f7540d);
        }
    }

    public final void g(RecyclerView recyclerView) {
        WeakHashMap weakHashMap = c1.f10054a;
        i0.s(recyclerView, 2);
        this.f7540d = new e(1, this);
        ViewPager2 viewPager2 = this.f7541e;
        if (i0.c(viewPager2) == 0) {
            i0.s(viewPager2, 1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(android.view.accessibility.AccessibilityNodeInfo r6) {
        /*
            r5 = this;
            androidx.viewpager2.widget.ViewPager2 r0 = r5.f7541e
            androidx.recyclerview.widget.g1 r1 = r0.getAdapter()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x001c
            int r1 = r0.getOrientation()
            androidx.recyclerview.widget.g1 r4 = r0.getAdapter()
            int r4 = r4.getItemCount()
            if (r1 != r2) goto L_0x0019
            goto L_0x001d
        L_0x0019:
            r1 = r4
            r4 = 0
            goto L_0x001e
        L_0x001c:
            r4 = 0
        L_0x001d:
            r1 = 0
        L_0x001e:
            com.google.gson.internal.bind.l r1 = com.google.gson.internal.bind.l.b(r4, r1, r3)
            java.lang.Object r1 = r1.f4038a
            android.view.accessibility.AccessibilityNodeInfo$CollectionInfo r1 = (android.view.accessibility.AccessibilityNodeInfo.CollectionInfo) r1
            r6.setCollectionInfo(r1)
            androidx.recyclerview.widget.g1 r1 = r0.getAdapter()
            if (r1 != 0) goto L_0x0030
            goto L_0x0051
        L_0x0030:
            int r1 = r1.getItemCount()
            if (r1 == 0) goto L_0x0051
            boolean r3 = r0.f2330y
            if (r3 != 0) goto L_0x003b
            goto L_0x0051
        L_0x003b:
            int r3 = r0.f2316k
            if (r3 <= 0) goto L_0x0044
            r3 = 8192(0x2000, float:1.14794E-41)
            r6.addAction(r3)
        L_0x0044:
            int r0 = r0.f2316k
            int r1 = r1 - r2
            if (r0 >= r1) goto L_0x004e
            r0 = 4096(0x1000, float:5.74E-42)
            r6.addAction(r0)
        L_0x004e:
            r6.setScrollable(r2)
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.l.h(android.view.accessibility.AccessibilityNodeInfo):void");
    }

    public final void i(int i10, Bundle bundle) {
        boolean z10;
        int i11;
        if (i10 == 8192 || i10 == 4096) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            ViewPager2 viewPager2 = this.f7541e;
            if (i10 == 8192) {
                i11 = viewPager2.getCurrentItem() - 1;
            } else {
                i11 = viewPager2.getCurrentItem() + 1;
            }
            if (viewPager2.f2330y) {
                viewPager2.c(i11, true);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public final void j(AccessibilityEvent accessibilityEvent) {
        accessibilityEvent.setSource(this.f7541e);
        accessibilityEvent.setClassName("androidx.viewpager.widget.ViewPager");
    }

    public final void k() {
        int itemCount;
        int i10;
        ViewPager2 viewPager2 = this.f7541e;
        int i11 = 16908360;
        c1.m(viewPager2, 16908360);
        boolean z10 = false;
        c1.i(viewPager2, 0);
        c1.m(viewPager2, 16908361);
        c1.i(viewPager2, 0);
        c1.m(viewPager2, 16908358);
        c1.i(viewPager2, 0);
        c1.m(viewPager2, 16908359);
        c1.i(viewPager2, 0);
        if (viewPager2.getAdapter() != null && (itemCount = viewPager2.getAdapter().getItemCount()) != 0 && viewPager2.f2330y) {
            int orientation = viewPager2.getOrientation();
            k kVar = this.f7539c;
            k kVar2 = this.f7538b;
            if (orientation == 0) {
                if (viewPager2.f2319n.M() == 1) {
                    z10 = true;
                }
                if (z10) {
                    i10 = 16908360;
                } else {
                    i10 = 16908361;
                }
                if (z10) {
                    i11 = 16908361;
                }
                if (viewPager2.f2316k < itemCount - 1) {
                    c1.n(viewPager2, new g(i10), kVar2);
                }
                if (viewPager2.f2316k > 0) {
                    c1.n(viewPager2, new g(i11), kVar);
                    return;
                }
                return;
            }
            if (viewPager2.f2316k < itemCount - 1) {
                c1.n(viewPager2, new g(16908359), kVar2);
            }
            if (viewPager2.f2316k > 0) {
                c1.n(viewPager2, new g(16908358), kVar);
            }
        }
    }
}
