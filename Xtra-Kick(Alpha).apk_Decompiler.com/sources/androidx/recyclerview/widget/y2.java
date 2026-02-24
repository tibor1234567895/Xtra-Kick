package androidx.recyclerview.widget;

import android.view.View;
import java.util.ArrayList;

public final class y2 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f2259a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public int f2260b = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: c  reason: collision with root package name */
    public int f2261c = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: d  reason: collision with root package name */
    public int f2262d = 0;

    /* renamed from: e  reason: collision with root package name */
    public final int f2263e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ StaggeredGridLayoutManager f2264f;

    public y2(StaggeredGridLayoutManager staggeredGridLayoutManager, int i10) {
        this.f2264f = staggeredGridLayoutManager;
        this.f2263e = i10;
    }

    public static s2 h(View view) {
        return (s2) view.getLayoutParams();
    }

    public final void a() {
        ArrayList arrayList = this.f2259a;
        View view = (View) arrayList.get(arrayList.size() - 1);
        s2 h10 = h(view);
        this.f2261c = this.f2264f.f1923y.d(view);
        h10.getClass();
    }

    public final void b() {
        this.f2259a.clear();
        this.f2260b = RecyclerView.UNDEFINED_DURATION;
        this.f2261c = RecyclerView.UNDEFINED_DURATION;
        this.f2262d = 0;
    }

    public final int c() {
        boolean z10 = this.f2264f.D;
        ArrayList arrayList = this.f2259a;
        return z10 ? e(arrayList.size() - 1, -1) : e(0, arrayList.size());
    }

    public final int d() {
        boolean z10 = this.f2264f.D;
        ArrayList arrayList = this.f2259a;
        return z10 ? e(0, arrayList.size()) : e(arrayList.size() - 1, -1);
    }

    public final int e(int i10, int i11) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f2264f;
        int j10 = staggeredGridLayoutManager.f1923y.j();
        int h10 = staggeredGridLayoutManager.f1923y.h();
        int i12 = i11 > i10 ? 1 : -1;
        while (i10 != i11) {
            View view = (View) this.f2259a.get(i10);
            int f10 = staggeredGridLayoutManager.f1923y.f(view);
            int d10 = staggeredGridLayoutManager.f1923y.d(view);
            boolean z10 = false;
            boolean z11 = f10 <= h10;
            if (d10 >= j10) {
                z10 = true;
            }
            if (z11 && z10 && (f10 < j10 || d10 > h10)) {
                return q1.O(view);
            }
            i10 += i12;
        }
        return -1;
    }

    public final int f(int i10) {
        int i11 = this.f2261c;
        if (i11 != Integer.MIN_VALUE) {
            return i11;
        }
        if (this.f2259a.size() == 0) {
            return i10;
        }
        a();
        return this.f2261c;
    }

    public final View g(int i10, int i11) {
        ArrayList arrayList = this.f2259a;
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f2264f;
        View view = null;
        if (i11 != -1) {
            int size = arrayList.size() - 1;
            while (size >= 0) {
                View view2 = (View) arrayList.get(size);
                if ((staggeredGridLayoutManager.D && q1.O(view2) >= i10) || ((!staggeredGridLayoutManager.D && q1.O(view2) <= i10) || !view2.hasFocusable())) {
                    break;
                }
                size--;
                view = view2;
            }
        } else {
            int size2 = arrayList.size();
            int i12 = 0;
            while (i12 < size2) {
                View view3 = (View) arrayList.get(i12);
                if ((staggeredGridLayoutManager.D && q1.O(view3) <= i10) || ((!staggeredGridLayoutManager.D && q1.O(view3) >= i10) || !view3.hasFocusable())) {
                    break;
                }
                i12++;
                view = view3;
            }
        }
        return view;
    }

    public final int i(int i10) {
        int i11 = this.f2260b;
        if (i11 != Integer.MIN_VALUE) {
            return i11;
        }
        ArrayList arrayList = this.f2259a;
        if (arrayList.size() == 0) {
            return i10;
        }
        View view = (View) arrayList.get(0);
        s2 h10 = h(view);
        this.f2260b = this.f2264f.f1923y.f(view);
        h10.getClass();
        return this.f2260b;
    }
}
