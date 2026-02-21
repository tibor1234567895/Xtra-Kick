package androidx.recyclerview.widget;

import android.util.Log;
import android.view.animation.Interpolator;

public final class d2 {

    /* renamed from: a  reason: collision with root package name */
    public int f1959a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f1960b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f1961c = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: d  reason: collision with root package name */
    public int f1962d = -1;

    /* renamed from: e  reason: collision with root package name */
    public Interpolator f1963e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1964f = false;

    /* renamed from: g  reason: collision with root package name */
    public int f1965g = 0;

    public final void a(RecyclerView recyclerView) {
        int i10 = this.f1962d;
        if (i10 >= 0) {
            this.f1962d = -1;
            recyclerView.jumpToPositionForSmoothScroller(i10);
            this.f1964f = false;
        } else if (this.f1964f) {
            Interpolator interpolator = this.f1963e;
            if (interpolator == null || this.f1961c >= 1) {
                int i11 = this.f1961c;
                if (i11 >= 1) {
                    recyclerView.mViewFlinger.c(this.f1959a, this.f1960b, interpolator, i11);
                    int i12 = this.f1965g + 1;
                    this.f1965g = i12;
                    if (i12 > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f1964f = false;
                    return;
                }
                throw new IllegalStateException("Scroll duration must be a positive number");
            }
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        } else {
            this.f1965g = 0;
        }
    }
}
