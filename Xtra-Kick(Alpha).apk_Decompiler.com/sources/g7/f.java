package g7;

import com.github.andreyasadchy.xtra.model.ui.Video;
import la.v;
import wa.l;
import xa.j;
import xa.k;

public final class f extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f6857h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ h f6858i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(h hVar, int i10) {
        super(1);
        this.f6857h = i10;
        this.f6858i = hVar;
    }

    public final void a(Video video) {
        int i10 = this.f6857h;
        h hVar = this.f6858i;
        switch (i10) {
            case 0:
                j.f("it", video);
                hVar.f10683k0 = video;
                hVar.b();
                return;
            default:
                j.f("it", video);
                hVar.f10683k0 = video;
                int i11 = h.f6861t0;
                hVar.t0().d(hVar.f0(), video);
                return;
        }
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        switch (this.f6857h) {
            case 0:
                a((Video) obj);
                return v.f9814a;
            default:
                a((Video) obj);
                return v.f9814a;
        }
    }
}
