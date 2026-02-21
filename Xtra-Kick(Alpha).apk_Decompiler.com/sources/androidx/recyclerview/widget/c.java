package androidx.recyclerview.widget;

public final class c implements x0 {

    /* renamed from: a  reason: collision with root package name */
    public final g1 f1949a;

    public c(g1 g1Var) {
        this.f1949a = g1Var;
    }

    public final void a(int i10, int i11) {
        this.f1949a.notifyItemRangeRemoved(i10, i11);
    }

    public final void b(int i10, int i11) {
        this.f1949a.notifyItemMoved(i10, i11);
    }

    public final void c(int i10, int i11) {
        this.f1949a.notifyItemRangeInserted(i10, i11);
    }

    public final void d(int i10, int i11, Object obj) {
        this.f1949a.notifyItemRangeChanged(i10, i11, obj);
    }
}
