package androidx.recyclerview.widget;

public final class p2 extends v1 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2132a = false;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q2 f2133b;

    public p2(q2 q2Var) {
        this.f2133b = q2Var;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i10) {
        if (i10 == 0 && this.f2132a) {
            this.f2132a = false;
            this.f2133b.g();
        }
    }

    public final void onScrolled(RecyclerView recyclerView, int i10, int i11) {
        if (i10 != 0 || i11 != 0) {
            this.f2132a = true;
        }
    }
}
