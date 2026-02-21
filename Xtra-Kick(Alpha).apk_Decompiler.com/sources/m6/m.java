package m6;

import com.github.andreyasadchy.xtra.model.offline.Request;
import com.github.andreyasadchy.xtra.ui.download.DownloadService;
import e6.h1;
import e6.o1;
import hb.f0;
import hb.h0;
import hb.p0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;
import xa.j;

public final class m extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f10651i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DownloadService f10652j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(DownloadService downloadService, e eVar) {
        super(2, eVar);
        this.f10652j = downloadService;
    }

    public final e create(Object obj, e eVar) {
        return new m(this.f10652j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((m) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f10651i;
        if (i10 == 0) {
            h0.O1(obj);
            DownloadService downloadService = this.f10652j;
            o1 e10 = downloadService.e();
            Request request = downloadService.f3388q;
            if (request != null) {
                int offlineVideoId = request.getOfflineVideoId();
                this.f10651i = 1;
                obj = h0.c2(p0.f7834b, new h1(e10, offlineVideoId, (e) null), this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                j.l("request");
                throw null;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
