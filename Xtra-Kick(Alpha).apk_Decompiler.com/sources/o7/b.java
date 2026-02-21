package o7;

import com.github.andreyasadchy.xtra.model.ui.Video;
import la.v;
import wa.l;
import xa.j;
import xa.k;

public final class b extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f12287h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ c f12288i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(c cVar, int i10) {
        super(1);
        this.f12287h = i10;
        this.f12288i = cVar;
    }

    public final void a(Video video) {
        int i10 = this.f12287h;
        c cVar = this.f12288i;
        switch (i10) {
            case 0:
                j.f("it", video);
                cVar.f10683k0 = video;
                cVar.b();
                return;
            default:
                j.f("it", video);
                cVar.f10683k0 = video;
                int i11 = c.f12289t0;
                cVar.t0().d(cVar.f0(), video);
                return;
        }
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        switch (this.f12287h) {
            case 0:
                a((Video) obj);
                return v.f9814a;
            default:
                a((Video) obj);
                return v.f9814a;
        }
    }
}
