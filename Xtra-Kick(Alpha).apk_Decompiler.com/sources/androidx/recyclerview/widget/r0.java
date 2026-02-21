package androidx.recyclerview.widget;

import android.view.View;
import java.util.List;

public final class r0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2172a = true;

    /* renamed from: b  reason: collision with root package name */
    public int f2173b;

    /* renamed from: c  reason: collision with root package name */
    public int f2174c;

    /* renamed from: d  reason: collision with root package name */
    public int f2175d;

    /* renamed from: e  reason: collision with root package name */
    public int f2176e;

    /* renamed from: f  reason: collision with root package name */
    public int f2177f;

    /* renamed from: g  reason: collision with root package name */
    public int f2178g;

    /* renamed from: h  reason: collision with root package name */
    public int f2179h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f2180i = 0;

    /* renamed from: j  reason: collision with root package name */
    public int f2181j;

    /* renamed from: k  reason: collision with root package name */
    public List f2182k = null;

    /* renamed from: l  reason: collision with root package name */
    public boolean f2183l;

    public final void a(View view) {
        int i10;
        int u10;
        int size = this.f2182k.size();
        View view2 = null;
        int i11 = Integer.MAX_VALUE;
        for (int i12 = 0; i12 < size; i12++) {
            View view3 = ((k2) this.f2182k.get(i12)).itemView;
            r1 r1Var = (r1) view3.getLayoutParams();
            if (view3 != view && !r1Var.w() && (u10 = (r1Var.u() - this.f2175d) * this.f2176e) >= 0 && u10 < i11) {
                view2 = view3;
                if (u10 == 0) {
                    break;
                }
                i11 = u10;
            }
        }
        if (view2 == null) {
            i10 = -1;
        } else {
            i10 = ((r1) view2.getLayoutParams()).u();
        }
        this.f2175d = i10;
    }

    public final View b(y1 y1Var) {
        List list = this.f2182k;
        if (list != null) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = ((k2) this.f2182k.get(i10)).itemView;
                r1 r1Var = (r1) view.getLayoutParams();
                if (!r1Var.w() && this.f2175d == r1Var.u()) {
                    a(view);
                    return view;
                }
            }
            return null;
        }
        View d10 = y1Var.d(this.f2175d);
        this.f2175d += this.f2176e;
        return d10;
    }
}
