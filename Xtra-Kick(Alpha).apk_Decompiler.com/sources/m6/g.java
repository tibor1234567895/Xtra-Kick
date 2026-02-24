package m6;

import com.github.andreyasadchy.xtra.model.ui.Clip;
import com.github.andreyasadchy.xtra.ui.download.ClipDownloadViewModel;
import hb.f0;
import hb.h0;
import la.v;
import ma.i0;
import ma.j0;
import pa.e;
import ra.i;
import wa.p;

public final class g extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Clip f10644i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ClipDownloadViewModel f10645j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Clip clip, ClipDownloadViewModel clipDownloadViewModel, e eVar) {
        super(2, eVar);
        this.f10644i = clip;
        this.f10645j = clipDownloadViewModel;
    }

    public final e create(Object obj, e eVar) {
        return new g(this.f10644i, this.f10645j, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((g) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        h0.O1(obj);
        try {
            String videoUrl = this.f10644i.getVideoUrl();
            if (videoUrl != null) {
                obj2 = i0.b(new la.i("Source", videoUrl));
            } else {
                obj2 = j0.d();
            }
            this.f10645j.f3378f.j(obj2);
        } catch (Exception unused) {
        }
        return v.f9814a;
    }
}
