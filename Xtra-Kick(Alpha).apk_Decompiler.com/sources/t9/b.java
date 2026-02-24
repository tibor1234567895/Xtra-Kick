package t9;

import java.util.List;
import la.v;
import u9.f;
import wa.a;
import xa.k;
import y9.l;

public final class b extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f14843h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ m f14844i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(m mVar, int i10) {
        super(0);
        this.f14843h = i10;
        this.f14844i = mVar;
    }

    public final void a() {
        int i10 = this.f14843h;
        m mVar = this.f14844i;
        switch (i10) {
            case 0:
                a aVar = mVar.f14883j;
                aVar.f14833l.j();
                if (aVar.f14837p) {
                    ((f) aVar.f14835n).w();
                    return;
                }
                return;
            default:
                try {
                    mVar.f14883j.close();
                    return;
                } catch (Exception e10) {
                    l lVar = mVar.f14884k;
                    lVar.b("exception occurred whiles shutting down Fetch with namespace:" + mVar.f14879f, e10);
                    return;
                }
        }
    }

    public final Object b() {
        switch (this.f14843h) {
            case 0:
                a();
                return v.f9814a;
            case 1:
                a aVar = this.f14844i.f14883j;
                List list = aVar.f14833l.get();
                aVar.e(list);
                return list;
            default:
                a();
                return v.f9814a;
        }
    }
}
