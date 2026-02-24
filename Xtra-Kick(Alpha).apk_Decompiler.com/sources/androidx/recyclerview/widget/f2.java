package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.util.Log;
import android.view.View;

public abstract class f2 {

    /* renamed from: a  reason: collision with root package name */
    public int f1983a = -1;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f1984b;

    /* renamed from: c  reason: collision with root package name */
    public q1 f1985c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1986d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1987e;

    /* renamed from: f  reason: collision with root package name */
    public View f1988f;

    /* renamed from: g  reason: collision with root package name */
    public final d2 f1989g = new d2();

    /* renamed from: h  reason: collision with root package name */
    public boolean f1990h;

    public PointF a(int i10) {
        q1 q1Var = this.f1985c;
        if (q1Var instanceof e2) {
            return ((e2) q1Var).d(i10);
        }
        Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + e2.class.getCanonicalName());
        return null;
    }

    public final void b(int i10, int i11) {
        PointF a10;
        RecyclerView recyclerView = this.f1984b;
        if (this.f1983a == -1 || recyclerView == null) {
            g();
        }
        if (this.f1986d && this.f1988f == null && this.f1985c != null && (a10 = a(this.f1983a)) != null) {
            float f10 = a10.x;
            if (!(f10 == 0.0f && a10.y == 0.0f)) {
                recyclerView.scrollStep((int) Math.signum(f10), (int) Math.signum(a10.y), (int[]) null);
            }
        }
        boolean z10 = false;
        this.f1986d = false;
        View view = this.f1988f;
        d2 d2Var = this.f1989g;
        if (view != null) {
            if (this.f1984b.getChildLayoutPosition(view) == this.f1983a) {
                f(this.f1988f, recyclerView.mState, d2Var);
                d2Var.a(recyclerView);
                g();
            } else {
                Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                this.f1988f = null;
            }
        }
        if (this.f1987e) {
            g2 g2Var = recyclerView.mState;
            c(i10, i11, d2Var);
            if (d2Var.f1962d >= 0) {
                z10 = true;
            }
            d2Var.a(recyclerView);
            if (z10 && this.f1987e) {
                this.f1986d = true;
                recyclerView.mViewFlinger.b();
            }
        }
    }

    public abstract void c(int i10, int i11, d2 d2Var);

    public abstract void d();

    public abstract void e();

    public abstract void f(View view, g2 g2Var, d2 d2Var);

    public final void g() {
        if (this.f1987e) {
            this.f1987e = false;
            e();
            this.f1984b.mState.f2018a = -1;
            this.f1988f = null;
            this.f1983a = -1;
            this.f1986d = false;
            q1 q1Var = this.f1985c;
            if (q1Var.f2147l == this) {
                q1Var.f2147l = null;
            }
            this.f1985c = null;
            this.f1984b = null;
        }
    }
}
