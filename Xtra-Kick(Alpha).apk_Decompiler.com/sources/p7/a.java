package p7;

import com.github.andreyasadchy.xtra.model.ui.Video;
import java.util.List;
import java.util.Map;
import la.v;
import m7.h;
import wa.l;
import xa.j;
import xa.k;

public final class a extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f12586h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ c f12587i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(c cVar, int i10) {
        super(1);
        this.f12586h = i10;
        this.f12587i = cVar;
    }

    public final void a(Video video) {
        int i10 = this.f12586h;
        c cVar = this.f12587i;
        switch (i10) {
            case 2:
                j.f("it", video);
                cVar.f10683k0 = video;
                cVar.b();
                return;
            default:
                j.f("it", video);
                cVar.f10683k0 = video;
                int i11 = c.f12598t0;
                cVar.t0().d(cVar.f0(), video);
                return;
        }
    }

    public final Object invoke(Object obj) {
        int i10 = this.f12586h;
        c cVar = this.f12587i;
        switch (i10) {
            case 0:
                Map map = (Map) obj;
                h hVar = cVar.f12601s0;
                if (hVar != null) {
                    j.e("it", map);
                    hVar.f10679d = map;
                    if (hVar.getItemCount() != 0) {
                        hVar.notifyDataSetChanged();
                    }
                    return v.f9814a;
                }
                j.l("pagingAdapter");
                throw null;
            case 1:
                List list = (List) obj;
                h hVar2 = cVar.f12601s0;
                if (hVar2 != null) {
                    j.e("it", list);
                    hVar2.f10680e = list;
                    return v.f9814a;
                }
                j.l("pagingAdapter");
                throw null;
            case 2:
                a((Video) obj);
                return v.f9814a;
            default:
                a((Video) obj);
                return v.f9814a;
        }
    }
}
