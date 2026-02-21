package m6;

import com.github.andreyasadchy.xtra.ui.download.DownloadService;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class l extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f10649i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DownloadService f10650j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(DownloadService downloadService, e eVar) {
        super(2, eVar);
        this.f10650j = downloadService;
    }

    public final e create(Object obj, e eVar) {
        return new l(this.f10650j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((l) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f10649i;
        if (i10 == 0) {
            h0.O1(obj);
            this.f10649i = 1;
            if (h0.L(3000, this) == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        DownloadService.b(this.f10650j);
        return v.f9814a;
    }
}
