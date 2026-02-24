package n7;

import com.github.andreyasadchy.xtra.model.ui.Video;
import la.v;
import wa.l;
import xa.j;
import xa.k;

public final class f extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f11727h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ g f11728i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(g gVar, int i10) {
        super(1);
        this.f11727h = i10;
        this.f11728i = gVar;
    }

    public final void a(Video video) {
        int i10 = this.f11727h;
        g gVar = this.f11728i;
        switch (i10) {
            case 0:
                j.f("it", video);
                gVar.f10683k0 = video;
                gVar.b();
                return;
            default:
                j.f("it", video);
                gVar.f10683k0 = video;
                int i11 = g.f11729t0;
                gVar.t0().d(gVar.f0(), video);
                return;
        }
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        switch (this.f11727h) {
            case 0:
                a((Video) obj);
                return v.f9814a;
            default:
                a((Video) obj);
                return v.f9814a;
        }
    }
}
