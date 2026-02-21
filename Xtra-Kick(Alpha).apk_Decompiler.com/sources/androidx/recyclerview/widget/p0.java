package androidx.recyclerview.widget;

import android.view.View;

public final class p0 {

    /* renamed from: a  reason: collision with root package name */
    public y0 f2123a;

    /* renamed from: b  reason: collision with root package name */
    public int f2124b;

    /* renamed from: c  reason: collision with root package name */
    public int f2125c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2126d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2127e;

    public p0() {
        c();
    }

    public final void a(View view, int i10) {
        if (this.f2126d) {
            this.f2125c = this.f2123a.l() + this.f2123a.d(view);
        } else {
            this.f2125c = this.f2123a.f(view);
        }
        this.f2124b = i10;
    }

    public final void b(View view, int i10) {
        int i11;
        int l10 = this.f2123a.l();
        if (l10 >= 0) {
            a(view, i10);
            return;
        }
        this.f2124b = i10;
        if (this.f2126d) {
            int h10 = (this.f2123a.h() - l10) - this.f2123a.d(view);
            this.f2125c = this.f2123a.h() - h10;
            if (h10 > 0) {
                int e10 = this.f2125c - this.f2123a.e(view);
                int j10 = this.f2123a.j();
                int min = e10 - (Math.min(this.f2123a.f(view) - j10, 0) + j10);
                if (min < 0) {
                    i11 = Math.min(h10, -min) + this.f2125c;
                } else {
                    return;
                }
            } else {
                return;
            }
        } else {
            int f10 = this.f2123a.f(view);
            int j11 = f10 - this.f2123a.j();
            this.f2125c = f10;
            if (j11 > 0) {
                int h11 = (this.f2123a.h() - Math.min(0, (this.f2123a.h() - l10) - this.f2123a.d(view))) - (this.f2123a.e(view) + f10);
                if (h11 < 0) {
                    i11 = this.f2125c - Math.min(j11, -h11);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        this.f2125c = i11;
    }

    public final void c() {
        this.f2124b = -1;
        this.f2125c = RecyclerView.UNDEFINED_DURATION;
        this.f2126d = false;
        this.f2127e = false;
    }

    public final String toString() {
        return "AnchorInfo{mPosition=" + this.f2124b + ", mCoordinate=" + this.f2125c + ", mLayoutFromEnd=" + this.f2126d + ", mValid=" + this.f2127e + '}';
    }
}
