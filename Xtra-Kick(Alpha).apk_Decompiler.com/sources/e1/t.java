package e1;

public final class t extends s {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ a0 f4938g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(a0 a0Var) {
        super(a0Var);
        this.f4938g = a0Var;
    }

    public final c0 a() {
        a0 a0Var = this.f4938g;
        j jVar = a0Var.f4891l;
        if (jVar != null) {
            return jVar == a0Var.f4888i ? new c0(this.f4930b.getCurrentBrowserInfo()) : jVar.f4919d;
        }
        throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }
}
