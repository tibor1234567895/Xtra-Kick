package x7;

import android.view.View;
import m0.c1;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final View f16743a;

    /* renamed from: b  reason: collision with root package name */
    public int f16744b;

    /* renamed from: c  reason: collision with root package name */
    public int f16745c;

    /* renamed from: d  reason: collision with root package name */
    public int f16746d;

    public o(View view) {
        this.f16743a = view;
    }

    public final void a() {
        int i10 = this.f16746d;
        View view = this.f16743a;
        c1.k(view, i10 - (view.getTop() - this.f16744b));
        c1.j(view, 0 - (view.getLeft() - this.f16745c));
    }
}
