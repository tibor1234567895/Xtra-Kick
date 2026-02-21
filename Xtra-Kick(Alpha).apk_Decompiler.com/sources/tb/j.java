package tb;

import sb.a;

public final class j extends a {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ z f14967e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ k f14968f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(String str, z zVar, k kVar) {
        super(str, true);
        this.f14967e = zVar;
        this.f14968f = kVar;
    }

    public final long a() {
        y yVar;
        z zVar = this.f14967e;
        try {
            yVar = zVar.f();
        } catch (Throwable th) {
            yVar = new y(zVar, (d) null, th, 2);
        }
        k kVar = this.f14968f;
        if (!kVar.f14973e.contains(zVar)) {
            return -1;
        }
        kVar.f14974f.put(yVar);
        return -1;
    }
}
