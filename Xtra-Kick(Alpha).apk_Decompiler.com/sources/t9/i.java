package t9;

import java.util.List;
import ma.z;
import p9.f;
import xa.j;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m f14857a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f14858b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ i f14859c;

    public i(m mVar, i iVar, i iVar2) {
        this.f14857a = mVar;
        this.f14858b = iVar;
        this.f14859c = iVar2;
    }

    public final void a(Object obj) {
        List list = (List) obj;
        j.g("result", list);
        boolean z10 = !list.isEmpty();
        m mVar = this.f14857a;
        if (z10) {
            la.i iVar = (la.i) z.s(list);
            if (((f) iVar.f9800i) != f.NONE) {
                mVar.f14882i.post(new h(this, iVar, 0));
            } else {
                mVar.f14882i.post(new h(this, iVar, 1));
            }
        } else {
            mVar.f14882i.post(new e(1, this));
        }
    }
}
