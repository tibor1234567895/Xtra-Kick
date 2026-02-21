package hb;

public final class r0 implements f1 {

    /* renamed from: h  reason: collision with root package name */
    public final boolean f7838h;

    public r0(boolean z10) {
        this.f7838h = z10;
    }

    public final boolean c() {
        return this.f7838h;
    }

    public final y1 f() {
        return null;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Empty{");
        sb2.append(this.f7838h ? "Active" : "New");
        sb2.append('}');
        return sb2.toString();
    }
}
