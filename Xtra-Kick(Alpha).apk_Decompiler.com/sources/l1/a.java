package l1;

import androidx.recyclerview.widget.RecyclerView;

public abstract class a {

    /* renamed from: h  reason: collision with root package name */
    public int f9501h;

    public final void e(int i10) {
        this.f9501h = i10 | this.f9501h;
    }

    public final boolean f(int i10) {
        return (this.f9501h & i10) == i10;
    }

    public final boolean g() {
        return f(RecyclerView.UNDEFINED_DURATION);
    }
}
